package com.example.week03_03;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.week03_03.adapter.MyRecyclerAdapter;
import com.example.week03_03.bean.UserBean;
import com.example.week03_03.presenter.IPresenterImpl;
import com.example.week03_03.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView {
    private ImageButton image_select;
    private XRecyclerView xRecyclerView;
    private IPresenterImpl iPresenter;
    private int mpage;
    private MyRecyclerAdapter myRecyclerAdapter;
    private boolean isChanged=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iPresenter=new IPresenterImpl(this);
        initView();
        initRecyclerView();
    }
    /**创建线性布局*/
    private void initRecyclerView() {
        mpage=1;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(linearLayoutManager);
        // 创建适配器
        myRecyclerAdapter = new MyRecyclerAdapter(this);
        myRecyclerAdapter.setOnClickListener(new MyRecyclerAdapter.Click() {
            @Override
            public void onClick(int position) {
                xRecyclerView.setItemAnimator(new DefaultItemAnimator());
                myRecyclerAdapter.removeData(position);
            }
        });
        xRecyclerView.setAdapter(myRecyclerAdapter);
        //设置间隔线
        xRecyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        //设置默认动画
        xRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置支持加载刷新
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setPullRefreshEnabled(true);
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

    }
    /**获取数据*/
    private void initData() {
        iPresenter.getRequeryData(String.format(Apis.URL_DATA,mpage),new HashMap<String, String>(),UserBean.class);
    }

    /**初始化*/
    private void initView() {
        //获取资源id
        image_select=findViewById(R.id.image_select);
        xRecyclerView=findViewById(R.id.xrecyclerview);
        //点击事件
        image_select.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_select:
                image_select.setBackgroundResource(R.drawable.on_select_image);
                //图片平移出去还能弹回来
                //如果没有mimg.getTranslationX()则图片不会弹回来
                ObjectAnimator translationX = ObjectAnimator.ofFloat(image_select, "translationX", image_select.getTranslationX(), -600f, image_select.getTranslationX());
                ObjectAnimator translationY = ObjectAnimator.ofFloat(image_select, "translationY", image_select.getTranslationY(), 1100f, image_select.getTranslationY());
                //动画时间
                translationX.setDuration(3000);//时间
                translationY.setDuration(3000);//时间
                //执行动画
                //渐变透明
                ObjectAnimator alpha = ObjectAnimator.ofFloat(image_select, "alpha", 0.0f, 1.0f);
                alpha.setDuration(3000);//时间


                if (v == image_select) {

                    if (isChanged) {
                        Toast.makeText(MainActivity.this, "取消选中", Toast.LENGTH_LONG).show();
                    } else {
                        translationY.start();//开始执行
                        translationX.start();//开始执行
                        alpha.start();//开始执行
                        image_select.setBackgroundResource(R.drawable.select_image);

                        Toast.makeText(MainActivity.this, "选中状态", Toast.LENGTH_LONG).show();

                    }
                    isChanged = !isChanged;

                }


                break;
            default:
                break;
        }
    }

    @Override
    public void showRequeryData(Object o) {
        if ( o instanceof  UserBean){
            UserBean userBean = (UserBean) o;
            if (!userBean.isSuccess()||userBean==null){
                Toast.makeText(MainActivity.this,userBean.getMsg(),Toast.LENGTH_SHORT).show();
            }else{
                if (mpage==1){
                    myRecyclerAdapter.setList(userBean.getData());
                }else{
                    myRecyclerAdapter.addList(userBean.getData());
                }
                mpage++;
                xRecyclerView.refreshComplete();
                xRecyclerView.loadMoreComplete();
            }
        }
    }
}
