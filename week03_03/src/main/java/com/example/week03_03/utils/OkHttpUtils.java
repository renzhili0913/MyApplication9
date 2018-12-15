package com.example.week03_03.utils;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpUtils {
    private static volatile OkHttpUtils mInsaner;
    private OkHttpClient mClient;
    private Handler handler = new Handler(Looper.getMainLooper());

    public static OkHttpUtils getmInsaner() {
        if (mInsaner==null){
            synchronized (OkHttpUtils.class){
                mInsaner=new OkHttpUtils();
            }
        }
        return mInsaner;
    }

    public OkHttpUtils() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mClient=new OkHttpClient.Builder()
                .connectTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

    }
    //异步post请求
    public void postEnqueue(String url, Map<String,String> params, final Class clazz, final ICallback iCallback){
        FormBody.Builder  builder = new FormBody.Builder();
        for (Map.Entry<String,String> entry: params.entrySet()
             ) {
            builder.add(entry.getKey(),entry.getValue());
        }
        RequestBody body = builder.build();
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
                        iCallback.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    try{
                        String string = response.body().string();
                        Gson gson = new Gson();
                        final Object o = gson.fromJson(string, clazz);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iCallback.success(o);
                            }
                        });
                    }catch (Exception e){
                        iCallback.failed(e);
                    }
            }
        });
    }
    //异步get请求
    public void getEnqueue(String url, final Class clazz, final ICallback iCallback){
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iCallback.failed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try{
                    String string = response.body().string();
                    Gson gson = new Gson();
                    final Object o = gson.fromJson(string, clazz);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iCallback.success(o);
                        }
                    });
                }catch (Exception e){
                    iCallback.failed(e);
                }
            }
        });
    }
}
