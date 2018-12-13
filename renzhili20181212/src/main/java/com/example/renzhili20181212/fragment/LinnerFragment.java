package com.example.renzhili20181212.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.renzhili20181212.Apis;
import com.example.renzhili20181212.R;
import com.example.renzhili20181212.adapter.LinnerAdapter;
import com.example.renzhili20181212.bean.UserBean;
import com.example.renzhili20181212.presenter.IPresenterImpl;
import com.example.renzhili20181212.view.IView;

import java.util.HashMap;

public class LinnerFragment extends Fragment implements IView {
    private IPresenterImpl iPresenter;
    private RecyclerView recyclerView;
    private LinnerAdapter linnerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.linner_fragment_item,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        iPresenter=new IPresenterImpl(this);
        //获取资源id
        recyclerView=view.findViewById(R.id.recycleview);
        //创建管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),OrientationHelper.VERTICAL));
        //C创建适配器
        linnerAdapter = new LinnerAdapter(getActivity());
        recyclerView.setAdapter(linnerAdapter);
        //动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //加载数据
        iPresenter.getRequeryData(Apis.URL_DATA,new HashMap<String, String>(),UserBean.class);
    }

    @Override
    public void showRequeryData(Object o) {
        if (o instanceof UserBean){
            UserBean userBean = (UserBean) o;
            linnerAdapter.setList(userBean.getData());
        }
    }
}
