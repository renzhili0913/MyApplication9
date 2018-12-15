package com.example.week03_04.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.week03_04.Apis;
import com.example.week03_04.Constans;
import com.example.week03_04.MainActivity;
import com.example.week03_04.R;
import com.example.week03_04.adapter.MyRecyclerAdapter;
import com.example.week03_04.bean.PhotoBean;
import com.example.week03_04.presenter.IPresenterImpl;
import com.example.week03_04.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowFragment extends Fragment implements View.OnClickListener,IView {
    private ImageButton image_select;
    private XRecyclerView xRecyclerView;
    private IPresenterImpl iPresenter;
    private int mpage;
    private boolean falg=true;
    private MyRecyclerAdapter myRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.show_item,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iPresenter=new IPresenterImpl(this);
        initView(view);
        initRecycleView();
    }

    private void initRecycleView() {
        mpage=1;
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mpage=1;
                ininData();
            }

            @Override
            public void onLoadMore() {
                ininData();
            }
        });
        changeRecyclerView();
        ininData();
    }

    private void changeRecyclerView() {
        if (falg){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
           // xRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),OrientationHelper.VERTICAL));
            xRecyclerView.setLayoutManager(linearLayoutManager);
        }else{
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            //xRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),OrientationHelper.VERTICAL));
            xRecyclerView.setLayoutManager(gridLayoutManager);
        }
        //创建适配器
        myRecyclerAdapter = new MyRecyclerAdapter(getActivity(), falg);
        xRecyclerView.setAdapter(myRecyclerAdapter);
        falg=!falg;
    }

    private void ininData() {
        Map<String,String> params = new HashMap<>();
        params.put(Constans.MAP_KEY_SEARCH_PRODUCTS_KEYWORDS,"笔记本");
        params.put(Constans.MAP_KEY_SEARCH_PRODUCES_PAGE,String.valueOf(mpage));
      /*  params.put(Constans.MAP_KEY_SEARCH_PRODUCES_SORT,String.valueOf(0));*/
        iPresenter.getRequeryData(Apis.URL_DATA,params,PhotoBean.class);
    }

    private void initView(View view) {
        //获取资源id
        image_select=view.findViewById(R.id.image_select);
        xRecyclerView=view.findViewById(R.id.xrecycleview);
        //点击事件
        image_select.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_select:
                if (falg){
                    image_select.setBackgroundResource(R.drawable.ic_action_grid);
                }else{
                    image_select.setBackgroundResource(R.drawable.ic_action_linear);
                }
                List<PhotoBean.DataBean> list = myRecyclerAdapter.getList();
                changeRecyclerView();
                myRecyclerAdapter.setList(list);
                break;
                default:
                    break;
        }
    }

    @Override
    public void showRequeryData(Object o) {
        if (o instanceof  PhotoBean){
            PhotoBean photoBean= (PhotoBean) o;
            if (!photoBean.isSuccess()||photoBean==null){
                Toast.makeText(getActivity(),photoBean.getMsg(),Toast.LENGTH_SHORT).show();
            }else{
                if (mpage==1){
                    // 传值到适配器
                    myRecyclerAdapter.setList(photoBean.getData());
                }else{
                    myRecyclerAdapter.addList(photoBean.getData());
                }
                mpage++;
                xRecyclerView.refreshComplete();
                xRecyclerView.loadMoreComplete();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iPresenter.onAtch();
    }
}
