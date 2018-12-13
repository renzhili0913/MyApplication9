package com.example.week03;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.week03.adapter.LinearAdapter;
import com.example.week03.bean.UserBean;
import com.example.week03.presenter.IPresenterImpl;
import com.example.week03.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView {
    private IPresenterImpl iPresenter;
    private XRecyclerView xRecyclerView;
    private LinearAdapter linearAdapter;
    private int mpage;
    private Button but_login;
    private ImageView head_portrait;
    private TextView nickname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mpage=1;
        iPresenter=new IPresenterImpl(this);
        //获取资源id
        xRecyclerView=findViewById(R.id.xRecycleview);
        but_login=findViewById(R.id.but_login);
        head_portrait=findViewById(R.id.head_portrait);
        nickname=findViewById(R.id.nickname);
        //登录事件
        but_login.setOnClickListener(this);
        //头像动画
        head_portrait.setOnClickListener(this);
        //创建线性管理器
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置管理器
        xRecyclerView.setLayoutManager(linearLayoutManager);
        //设置分割线
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, OrientationHelper.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this,R.drawable.shape_item_decoration));
        xRecyclerView.addItemDecoration(dividerItemDecoration);
        //设置动画
        xRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //创建适配器
        linearAdapter = new LinearAdapter(this);
        xRecyclerView.setAdapter(linearAdapter);
        //是否开启下拉刷新功能
        xRecyclerView.setPullRefreshEnabled(true);
        //是否开启上拉加载功能
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mpage=1;
                initData();
            }

            @Override
            public void onLoadMore() {
                initData();
            }
        });
        initData();
        //图片点击事件
        linearAdapter.setOnClickListener(new LinearAdapter.Click() {
            @Override
            public void onClick(View view, int position) {
                //创建动画
                ObjectAnimator animator = ObjectAnimator.ofFloat(view,"alpha",1f,0f,1f);
                //动画执行时间
                animator.setDuration(3000);
                //启动动画
                animator.start();
            }
        });
        //条目长按事件
        linearAdapter.setOnLongClickListener(new LinearAdapter.LongClick() {
            @Override
            public void onLongClick(final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("删除：");
                builder.setMessage("确认删除吗？");
                //确认
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        linearAdapter.removeData(position);
                    }
                });
                //取消
               builder.setNegativeButton("取消",null);
               //展示
               builder.show();

            }
        });
    }

    private void initData() {
        //添加数据
        Map<String,String> params=new HashMap<>();
        //params.put("page",String.valueOf(mpage));
        iPresenter.getRequeryData(String.format(Apis.URL_DATA,mpage),params,UserBean.class);
    }

    @Override
    public void showRequeryData(Object o) {
        if (o instanceof UserBean){
            UserBean userBean = (UserBean) o;
            if (userBean==null||!userBean.isSuccess()){
                Toast.makeText(MainActivity.this,userBean.getMsg(),Toast.LENGTH_SHORT).show();
            }else{
                if (mpage==1){
                    linearAdapter.setList(userBean.getData());
                }else{
                    linearAdapter.addList(userBean.getData());
                }
                mpage++;
                //刷新完毕执行
                xRecyclerView.refreshComplete();
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but_login:
                UMShareAPI umShareAPI = UMShareAPI.get(MainActivity.this);
                umShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                       // Log.i("TAG", "UMAuthListener onComplete");
                        //获取名字
                        String name  = map.get("screen_name");
                        //获取头像
                        String img  = map.get("profile_image_url");
                        Glide.with(MainActivity.this).load(img).into(head_portrait);
                        nickname.setText(name);
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });

                break;
            case R.id.head_portrait:
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(head_portrait,"scaleX",1f,2f,1f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(head_portrait,"scaleY",1f,2f,1f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(3000);
                animatorSet.playTogether(scaleX,scaleY);
                animatorSet.start();
                break;
                default:
                    break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
