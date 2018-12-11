package com.example.renzhilli20181211;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.renzhilli20181211.adapter.MyBaseAdapter;
import com.example.renzhilli20181211.bean.UserBean;
import com.example.renzhilli20181211.presenter.IPresenterImpl;
import com.example.renzhilli20181211.view.IView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements IView {
    private IPresenterImpl iPresenter;
    private PullToRefreshListView listView;
    private MyBaseAdapter myBaseAdapter;
    private int mpage;
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
        listView=findViewById(R.id.listview);
        //创建适配器器
        myBaseAdapter = new MyBaseAdapter(this);
        listView.setAdapter(myBaseAdapter);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                mpage=1;
                inintData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                inintData();
            }
        });
        inintData();
    }

    private void inintData() {
        iPresenter.getRequeryData(Apis.url,new HashMap<String, String>(),UserBean.class);
    }

    @Override
    public void showRequeryData(Object o) {
        if (o instanceof UserBean){
            UserBean userBean = (UserBean) o;
            if (mpage==1){
                myBaseAdapter.setBanner(userBean.getData());
                myBaseAdapter.setList(userBean.getData());
            }else{
                myBaseAdapter.addList(userBean.getData());
            }
            mpage++;
            listView.onRefreshComplete();
        }
    }
}
