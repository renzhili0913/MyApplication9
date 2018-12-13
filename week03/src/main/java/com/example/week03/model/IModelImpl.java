package com.example.week03.model;

import android.animation.ObjectAnimator;

import com.example.week03.utils.ICallBack;
import com.example.week03.utils.OkHttpUtils;

import java.util.Map;

public class IModelImpl implements IModel {
    private MyCallBack myCallBack;
    @Override
    public void getRequeryData(String url, Map<String, String> params, Class clazz, final MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
        //调用get方法请求数据
        OkHttpUtils.getmInsaner().getEnqueue(url, clazz, new ICallBack() {
            @Override
            public void success(Object obj) {
                myCallBack.setData(obj);
            }

            @Override
            public void failed(Exception e) {
                myCallBack.setData(e.getMessage());
            }
        });
       /* //调用post方法请求数据 获取数据
        OkHttpUtils.getmInsaner().postEnqueue(url, params, clazz, new ICallBack() {
            @Override
            public void success(Object obj) {
                myCallBack.setData(obj);
            }

            @Override
            public void failed(Exception e) {
                myCallBack.setData(e.getMessage());
            }
        });*/
    }
}
