package com.example.azheng.rxjavamvpdemo.model;


import com.example.azheng.rxjavamvpdemo.bean.BaseArrayBean;
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.BeanFamily;
import com.example.azheng.rxjavamvpdemo.bean.BeanPhone;
import com.example.azheng.rxjavamvpdemo.bean.BeanZqin;
import com.example.azheng.rxjavamvpdemo.contract.HoneContract;
import com.example.azheng.rxjavamvpdemo.net.RetrofitClient;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * 类 描 述：
 */
public class HomeModel implements HoneContract.Model {
    @Override
    public Flowable<BaseObjectBean<BeanPhone>> phone(String phone) {
        return RetrofitClient.getInstance().getApi("1.0.0").phone(phone);
    }

    @Override
    public Flowable<BaseArrayBean<BeanFamily>> family() {
        return RetrofitClient.getInstance().getApi("1.0.0").family();
    }

    @Override
    public Flowable<BaseObjectBean> delete(String number,int position) {
        return RetrofitClient.getInstance().getApi("1.0.0").delete(number);
    }

    @Override
    public Flowable<BaseObjectBean<BeanZqin>> name(String name) {
        return RetrofitClient.getInstance().getApi("1.0.0").name(name);
    }

    @Override
    public Flowable<BaseObjectBean> getAds(RequestBody requestBody) {
        return RetrofitClient.getInstance().getApi("1.0.0").getAds(requestBody);
    }

    @Override
    public Flowable<BaseObjectBean> uploadFile(MultipartBody.Part body) {
        return RetrofitClient.getInstance().getApi("1.0.0").uploadFile(body);
    }

    @Override
    public Flowable<BaseObjectBean> upLoadImages(String name,String precept,List<MultipartBody.Part> part) {
        return RetrofitClient.getInstance().getApi("1.0.0").upLoadImages(name,precept,part);
    }

}
