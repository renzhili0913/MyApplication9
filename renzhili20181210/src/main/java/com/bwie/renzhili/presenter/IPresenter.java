package com.bwie.renzhili.presenter;

import java.util.Map;

public interface IPresenter {
    void getRqueryData(String url, String params, Class clazz);
    void getRqueryData(String url, Map<String,String> params, Class clazz);
}
