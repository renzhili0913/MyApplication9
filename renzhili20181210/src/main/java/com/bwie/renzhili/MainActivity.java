package com.bwie.renzhili;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.renzhili.bean.LoginBean;
import com.bwie.renzhili.presenter.IPresenterImpl;
import com.bwie.renzhili.view.IView;
import com.umeng.qq.handler.UmengQQHandler;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IView {
    private IPresenterImpl iPresenter;
    private EditText name, password;
    private Button but_login;
    private ImageButton imageView;
    private TextView but_register, forget_pass;
    private String names;
    private String pass;
   // private String url="http://www.zhaoapi.cn/user/login?mobile=%s&password=%s";
    private ImageView qq_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iPresenter = new IPresenterImpl(this);
        initView();
    }

    private void initView() {
        //获取资源id
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        but_login = findViewById(R.id.but_login);
        imageView = findViewById(R.id.display);
        but_register = findViewById(R.id.but_register);
        forget_pass = findViewById(R.id.forget_pass);
        qq_login=findViewById(R.id.qq_login);
        //显示隐藏
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageView.setBackgroundResource(R.drawable.ic_action_pass);
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    imageView.setBackgroundResource(R.drawable.ic_action_no_pass);
                }
                return false;
            }
        });
        //设置点击事件
        but_login.setOnClickListener(this);
        but_register.setOnClickListener(this);
        forget_pass.setOnClickListener(this);
        qq_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_login:
                //获取输入框的值
                names = name.getText().toString().trim();
                pass = password.getText().toString().trim();
                if (names.isEmpty()||pass.isEmpty()){
                    Toast.makeText(MainActivity.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    //iPresenter.getRqueryData(String.format(Apis.URL_LOGIN,names,pass),null,LoginBean.class);
                    Map<String, String> params = new HashMap<>();
                    params.put("mobile",names);
                    params.put("password",pass);
                    iPresenter.getRqueryData(Apis.URL_POST_LOGIN,params,LoginBean.class);
                }
                break;
            case R.id.but_register:
                //注册
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.forget_pass:
                break;
            case R.id.qq_login:
                UMShareAPI umShareAPI =UMShareAPI.get(MainActivity.this);
                umShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                       //iPresenter.getRqueryData(String.format(url,names,pass),null,LoginBean.class);
                        Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });

                break;
            default:
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void getRequeryData(Object o) {
        if (o instanceof LoginBean){
            LoginBean loginBean = (LoginBean) o;
            if (loginBean==null||!loginBean.isSuccess()){
                Toast.makeText(MainActivity.this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(MainActivity.this,ShowActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
