package com.bwie.renzhili.bean;

public class LoginBean {


    private String msg;
    private String code;

    public boolean isSuccess(){
        return code.equals("0");
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
