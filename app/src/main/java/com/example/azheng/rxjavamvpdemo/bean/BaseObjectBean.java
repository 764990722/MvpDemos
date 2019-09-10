package com.example.azheng.rxjavamvpdemo.bean;



/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：对象
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
