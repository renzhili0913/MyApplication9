package com.example.week03_02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.week03_02.bean.ClicdBean;
import com.example.week03_02.presenter.IPresenterImpl;
import com.example.week03_02.view.IView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements IView {
    private IPresenterImpl iPresenter;
    private Banner banner;
    private TextView title,price;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_item);
        initView();
    }

    private void initView() {
        iPresenter=new IPresenterImpl(this);
        //获取资源id
        banner=findViewById(R.id.banner);
        title=findViewById(R.id.title);
        price=findViewById(R.id.price);
        //接受intent传来的值
        Intent intent = getIntent();
        final int intExtra = intent.getIntExtra(Constans.INTENT_KEY_PRODUCES_PID, 0);
       //创建map集合
        Map<String,String> params = new HashMap<>();
        params.put(Constans.MAP_KEY_PRODUCTS_DETAIL_PID,String.valueOf(intExtra));
        //调用获取数据的方法
        iPresenter.getRequeryData(Apis.URL_DATAILS,params,ClicdBean.class);


        //轮播图
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setImageLoader(new ImageLoaderInterface<ImageView>() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
               // ClicdBean.DataBean  dataBean = (ClicdBean.DataBean) path;
                //加载图片到imageview上
                Glide.with(context).load(path).into(imageView);
            }

            @Override
            public ImageView createImageView(Context context) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                return imageView;

            }
        });
    }

    @Override
    public void showRequeryData(Object o) {
        if (o instanceof ClicdBean){
            ClicdBean clicdBean= (ClicdBean) o;
            if (clicdBean==null||!clicdBean.isSucccess()){
                Toast.makeText(LoginActivity.this,clicdBean.getMsg(),Toast.LENGTH_SHORT).show();
            }else{
                //赋值
                title.setText(clicdBean.getData().getTitle());
                price.setText("价格："+clicdBean.getData().getPrice());
                //获取图片字段
                String img = clicdBean.getData().getImages();
                //调用截取图片的方法，将图片存入集合image中
                sub(img);
                //设置图片集合到banner中
                banner.setImages(image);
                //banner设置方法全部调用完毕时最后调用
                banner.start();

            }
        }
    }
    /**存图片的集合*/
    private List<String> image= new ArrayList<>();
    /**截取图片的方法*/
    public void sub(String url){
        //获取以“|”为截取的下标位置
        int i = url.indexOf("|");
        if (i>=0){
            String substring = url.substring(0, i);
            image.add(substring);
            sub(url.substring(i+1,url.length()));
        }else{
            image.add(url);
        }
    }

}
