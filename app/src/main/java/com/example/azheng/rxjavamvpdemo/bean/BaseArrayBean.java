package com.example.azheng.rxjavamvpdemo.bean;

import java.util.List;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * https://github.com/764990722
 * 类 描 述：
 */
public class BaseArrayBean<T> {

    /**
     * msg : 成功
     * state : true
     * data : []
     * code : 000
     * exception :
     */

    private String msg;
    private boolean state;
    private String code;
    private String exception;
    private List<T> data;

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

    public List<?> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data =  data;
    }
}
