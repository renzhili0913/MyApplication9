package com.bwie.renzhili.utils;


import android.os.Handler;
import android.os.Looper;
import android.text.method.HideReturnsTransformationMethod;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {
    private static volatile OkHttpUtils mInstance;
    private Handler handler = new Handler(Looper.getMainLooper());
    private OkHttpClient mClient;
    /**单例模式懒汉式，可以用恶汉式*/
    public static OkHttpUtils getmInstance() {
        if (mInstance==null){
            synchronized (OkHttpUtils.class){
                mInstance=new OkHttpUtils();
            }
        }
        return mInstance;
    }
    /**完成构造方法*/
    public OkHttpUtils() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor() ;
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        /**
         * 使用构造者模式
         * 设置连接超时
         * 设置读取超时
         * 设置写超时
         * 添加拦截器
         * */
        mClient=new OkHttpClient.Builder()
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();


    }
    /**
     * 网络异步get请求方法
     * */
    public void getEnqueue(String url, final Class clazz, final ICallBack iCallBack) {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            //网络请求连接失败
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.failed(e);
                    }
                });
            }

            //网络请求连接成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(result, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.success(o);
                    }
                });
            }
        });
    }
    /**
     * 创建异步post方法
     * 创建表单FormBody
     * 把我们取出的key和value对应的放进去
     * 最后，build表单，生成RequestBody
     *
     * @param url 请求地址
     * @param params
     * @param clazz
     * @param iCallBack
     */
    public void  postEnqueue(String url, Map<String,String> params, final Class clazz, final ICallBack iCallBack){
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String> entry:params.entrySet()
             ) {
            builder.add(entry.getKey(),entry.getValue());
        }
        FormBody body = builder.build();
        Request request = new Request.Builder()
                .post(body)
                .url(url)
                .build();
        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                final Object o = gson.fromJson(result, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.success(o);
                    }
                });
            }
        });
    }
    private static String byte2String(byte[] bytes){
        return new String(bytes);
    }

}
