package com.example.azheng.rxjavamvpdemo.bean;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * 类 描 述：
 */
public class BeanPhone {

    /**
     * hasPwd : true        // 注册标识，布尔值，为真已注册，否则未注册
     * register : true      // 有无密码，布尔值，为真有密码，否则无密码
     */

    private boolean hasPwd;
    private boolean register;

    public boolean isHasPwd() {
        return hasPwd;
    }

    public void setHasPwd(boolean hasPwd) {
        this.hasPwd = hasPwd;
    }

    public boolean isRegister() {
        return register;
    }

    public void setRegister(boolean register) {
        this.register = register;
    }
}
