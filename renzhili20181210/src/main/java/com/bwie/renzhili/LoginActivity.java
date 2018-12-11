package com.bwie.renzhili;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,IView {
    private IPresenterImpl iPresenter;
    private EditText name, password;
    private Button but_login;
    private ImageButton imageView;
    private TextView forget_pass;
    private String names;
    private String pass;
   // private String url="http://www.zhaoapi.cn/user/reg?mobile=%s&password=%s";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_item);
        iPresenter=new IPresenterImpl(this);
        initView();
    }

    private void initView() {
        //获取资源id
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        but_login = findViewById(R.id.but_login);
        imageView = findViewById(R.id.display);
        forget_pass = findViewById(R.id.forget_pass);
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
        imageView.setOnClickListener(this);
        forget_pass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_login:
                //获取输入框的值
                names = name.getText().toString().trim();
                pass = password.getText().toString().trim();
                if (names.isEmpty()||pass.isEmpty()){
                    Toast.makeText(LoginActivity.this,"用户名或密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    //iPresenter.getRqueryData(String.format(Apis.URL_REGISTER,names,pass),null,LoginBean.class);
                    Map<String, String> params = new HashMap<>();
                    params.put("mobile",names);
                    params.put("password",pass);
                    iPresenter.getRqueryData(Apis.URL_POST_LOGIN,params,LoginBean.class);
                }
                break;
            case R.id.display:
                break;
            case R.id.forget_pass:
                break;
            default:
                break;

        }
    }

    @Override
    public void getRequeryData(Object o) {
        if (o instanceof LoginBean){
            LoginBean loginBean = (LoginBean) o;
            if (loginBean==null||!loginBean.isSuccess()){
                Toast.makeText(LoginActivity.this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(LoginActivity.this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
    }

