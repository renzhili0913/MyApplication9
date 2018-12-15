package com.example.week03_03.model;

import com.example.week03_03.utils.ICallback;
import com.example.week03_03.utils.OkHttpUtils;

import java.util.Map;

public class IModelImpl implements IModel {
    private MyCallBack myCallBack;
    @Override
    public void getRequeryData(String url, Map<String, String> params, Class clazz, final MyCallBack myCallBack) {
        this.myCallBack=myCallBack;
        OkHttpUtils.getmInsaner().getEnqueue(url, clazz, new ICallback() {
            @Override
            public void success(Object obj) {
                myCallBack.setData(obj);
            }

            @Override
            public void failed(Exception e) {
                myCallBack.setData(e.getMessage());
            }
        });
    }
}
