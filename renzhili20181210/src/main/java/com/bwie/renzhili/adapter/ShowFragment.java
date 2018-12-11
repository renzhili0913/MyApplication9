package com.bwie.renzhili.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import android.support.v4.content.ContextCompat;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwie.renzhili.Apis;
import com.bwie.renzhili.CodeActivity;
import com.bwie.renzhili.R;
import com.bwie.renzhili.bean.LoginBean;
import com.bwie.renzhili.bean.UserBean;
import com.bwie.renzhili.presenter.IPresenterImpl;
import com.bwie.renzhili.view.IView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;


public class ShowFragment extends Fragment implements IView {

    private Banner viewPager;
    private IPresenterImpl iPresenter;
   // private String url="http://www.zhaoapi.cn/home/getHome";
    private ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.data_item,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iPresenter=new IPresenterImpl(this);
        //iPresenter.getRqueryData(Apis.URL_HOME,null,UserBean.class);
        iPresenter.getRqueryData(Apis.URL_POST_HOME,new HashMap<String, String>(),UserBean.class);
        //获取资源id
        viewPager=view.findViewById(R.id.viewpager);
        imageView=view.findViewById(R.id.code);
        //设置样式
        viewPager.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //图片加载器
        viewPager.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                UserBean.DataBean.BannerBean dataBean = (UserBean.DataBean.BannerBean) path;
                com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(dataBean.hasIcon(),imageView);
            }
            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;
            }
        });
      //点击扫描二维码
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断android版本号是否是6.0以上，（Build.VERSION_CODES.M：表示版本号是6.0）
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    //checkSelfPermission判断当前有没有第二个参数所代表的权限，当前权限为相机权限
                    //如果与给定条件不同，这没有此权限。需要授权
                    if (ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){

                        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},100);

                    }  else{
                        //如果版本是6.0以上，且条件满足，授权，直接跳转
                        Intent intent = new Intent(getActivity(),CodeActivity.class);
                        startActivity(intent);
                    }
                }else{
                    //版本低于6.0，直接跳转，通过清单文件配置请求权限
                    Intent intent = new Intent(getActivity(),CodeActivity.class);
                    startActivity(intent);
                }

            }

        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==100&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(getActivity(),CodeActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void getRequeryData(Object o) {
        if (o instanceof  UserBean){
            UserBean userBean = (UserBean) o;
            if (userBean==null||!userBean.isSuccess()){
                Toast.makeText(getActivity(),userBean.getMsg(),Toast.LENGTH_SHORT).show();
            }else{
               viewPager.setImages(userBean.getData().getBanner());
               viewPager.start();

            }
        }
    }
}
