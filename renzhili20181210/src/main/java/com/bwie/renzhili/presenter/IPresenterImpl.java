package com.bwie.renzhili.presenter;

import com.bwie.renzhili.model.IModelImpl;
import com.bwie.renzhili.model.MyCallBack;
import com.bwie.renzhili.view.IView;

import java.util.Map;

public class IPresenterImpl implements IPresenter {
    private IView iView;
    private IModelImpl iModel;
    public IPresenterImpl(IView iView) {
        this.iView = iView;
        iModel=new IModelImpl();
    }

    @Override
    public void getRqueryData(String url, String params, Class clazz) {
        iModel.getRequeryData(url, params, clazz, new MyCallBack() {
            @Override
            public void setData(Object o) {
                iView.getRequeryData(o);
            }
        });
    }

    @Override
    public void getRqueryData(String url, Map<String, String> params, Class clazz) {
        iModel.getRequeryData(url, params, clazz, new MyCallBack() {
            @Override
            public void setData(Object o) {
                iView.getRequeryData(o);
            }
        });
    }
}
