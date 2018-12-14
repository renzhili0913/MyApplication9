package com.example.week03_02.presenter;

import java.util.Map;

public interface IPresenter {
    void getRequeryData(String url, Map<String,String> params, Class clazz);
}
