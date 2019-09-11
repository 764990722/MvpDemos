package com.example.azheng.rxjavamvpdemo.bean;



/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * https://github.com/764990722
 * 类 描 述：
 */
public class BaseObjectBean<T> {

    /**
     * msg : 登录成功
     * state : true
     * data : {}
     * code : 000
     * exception :
     */

    private String msg;
    private boolean state;
    private T data;
    private String code;
    private String exception;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }


    public static class DataBean {
    }
}
