package com.example.azheng.rxjavamvpdemo.model;


import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.LoginBean;
import com.example.azheng.rxjavamvpdemo.contract.MainContract;
import com.example.azheng.rxjavamvpdemo.net.RetrofitClient;

import io.reactivex.Flowable;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/3/19
 * https://github.com/764990722
 */
public class MainModel implements MainContract.Model {
    @Override
    public Flowable<BaseObjectBean<LoginBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi("1.0.0").login(username,password);
    }

    @Override
    public Flowable<BaseObjectBean<LoginBean>> Zdlogin(String userToken) {
        return RetrofitClient.getInstance().getApi("1.0.0").Zdlogin(userToken);
    }

}
