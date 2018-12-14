package com.example.week03_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week03_02.adapter.MyDataAdapter;
import com.example.week03_02.bean.PhotoBean;
import com.example.week03_02.presenter.IPresenterImpl;
import com.example.week03_02.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView {
    private IPresenterImpl iPresenter;
    private ImageButton image_switch;
    private TextView text_comprehensive,text_Sales_volume,text_price,text_screen;
    private XRecyclerView xRecyclerView;
    private int mpage;
    private int mSrot=0;
    private boolean falg=true;
    private MyDataAdapter myDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iPresenter=new IPresenterImpl(this);
        initView();
        initRecyclerView();
    }
    /**初始化*/
    private void initView() {
        //获取资源id
        image_switch=findViewById(R.id.image_switch);
        text_comprehensive=findViewById(R.id.text_comprehensive);
        text_comprehensive.setSelected(true);
        text_Sales_volume=findViewById(R.id.text_Sales_volume);
        text_price=findViewById(R.id.text_price);
        text_screen=findViewById(R.id.text_screen);
        xRecyclerView=findViewById(R.id.xrecycleview);
        //点击事件
        image_switch.setOnClickListener(this);
        text_comprehensive.setOnClickListener(this);
        text_Sales_volume.setOnClickListener(this);
        text_price.setOnClickListener(this);
        text_screen.setOnClickListener(this);

    }
    /**获取RecyclerView方法，*/
    private void initRecyclerView() {
        mpage=1;
        xRecyclerView.setLoadingMoreEnabled(true);
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
        changeRecyclerView();
        initData();
    }
    /**判断加载什么布局的方法*/
    private void changeRecyclerView() {
        if (falg){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            xRecyclerView.setLayoutManager(linearLayoutManager);
        }else{
            GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            xRecyclerView.setLayoutManager(gridLayoutManager);
        }
        // 创建适配器 添加适配器
        myDataAdapter = new MyDataAdapter(this, falg);
        xRecyclerView.setAdapter(myDataAdapter);
        //条目点击事件，跳转详情页面
        myDataAdapter.setOnClickListener(new MyDataAdapter.Click() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                intent.putExtra(Constans.INTENT_KEY_PRODUCES_PID,myDataAdapter.getData().get(position).getPid());
                startActivity(intent);
            }
        });
        // 切换状态值
        falg=!falg;
    }

    private void initData() {
        Map<String,String> params = new HashMap<>();
        params.put(Constans.MAP_KEY_SEARCH_PRODUCTS_KEYWORDS,"笔记本");
        params.put(Constans.MAP_KEY_SEARCH_PRODUCES_PAGE,String.valueOf(mpage));
        params.put(Constans.MAP_KEY_SEARCH_PRODUCES_SORT,String.valueOf(mSrot));
        //调用获取数据的方法
        iPresenter.getRequeryData(Apis.URL_DATA,params,PhotoBean.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_switch:
                //判断状态值转换按钮背景图片
                if (falg){
                    image_switch.setBackgroundResource(R.drawable.ic_action_linear);
                }else{
                    image_switch.setBackgroundResource(R.drawable.ic_action_grid);
                }
                //获取适配器中的数据
                List<PhotoBean.DataBean> data = myDataAdapter.getData();
                //调用从新判断加载网格或线性布局
                changeRecyclerView();
                //传值到适配器中重新赋值
                myDataAdapter.setList(data);
                break;
            case R.id.text_comprehensive:
                if (!text_comprehensive.isSelected()){
                    mpage=1;
                    mSrot=0;
                    //请求数据的方法
                    initData();
                    //设置背景选中状态
                    text_comprehensive.setSelected(true);
                    text_Sales_volume.setSelected(false);
                    text_price.setSelected(false);
                }
                break;
            case R.id.text_Sales_volume:
                if (!text_comprehensive.isTextSelectable()){
                    mpage=1;
                    mSrot=1;
                    initData();
                    text_comprehensive.setSelected(false);
                    text_Sales_volume.setSelected(true);
                    text_price.setSelected(false);
                }
                break;
            case R.id.text_price:
                if (!text_comprehensive.isTextSelectable()){
                    mpage=1;
                    mSrot=2;
                    initData();
                    text_comprehensive.setSelected(false);
                    text_Sales_volume.setSelected(false);
                    text_price.setSelected(true);
                }
                break;
                default:
                    break;
        }
    }

    @Override
    public void showRequeryData(Object o) {
        if (o instanceof PhotoBean){
            PhotoBean photoBean = (PhotoBean) o;
            if (photoBean==null||!photoBean.isSuccess()){
                Toast.makeText(MainActivity.this,photoBean.getMsg(),Toast.LENGTH_SHORT).show();
            }else{
                if (mpage==1){
                    myDataAdapter.setList(photoBean.getData());
                }else{
                    myDataAdapter.addList(photoBean.getData());
                }
                mpage++;
                xRecyclerView.loadMoreComplete();
                xRecyclerView.refreshComplete();
            }
        }else{
            Toast.makeText(MainActivity.this,"获取数据失败",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresenter.onAtach();
    }
}
