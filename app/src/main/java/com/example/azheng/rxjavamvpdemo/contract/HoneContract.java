package com.example.azheng.rxjavamvpdemo.contract;

import com.example.azheng.rxjavamvpdemo.base.BaseView;
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.BeanPhone;
import com.example.azheng.rxjavamvpdemo.bean.BeanZqin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;


/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * 类 描 述：
 */
public interface HoneContract {
    interface Model {
        Flowable<BaseObjectBean<BeanPhone>> phone(String phone);
        Flowable<BaseObjectBean<BeanZqin>> name(String name);
        Flowable<BaseObjectBean> getAds(RequestBody requestBody);
        Flowable<BaseObjectBean> uploadFile(MultipartBody.Part body);
        Flowable<BaseObjectBean> upLoadImages(String name,String precept,List<MultipartBody.Part> part);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BaseObjectBean<BeanPhone> bean);//检测号码

        void onSuccess1(BaseObjectBean<BeanZqin> bean);//查找宗亲

        void onSuccess2(BaseObjectBean bean);//json上传

        void onSuccess3(BaseObjectBean bean);//单图上传

        void onSuccess4(BaseObjectBean bean);//多图上传

        void onFailed(String msg);
    }

    interface Presenter {
        /**
         * 检查手机号
         */
        void phone(String phone);

        /**
         * 查找宗亲
         */
        void name(String name);

        /**
         * 列表排序json
         */
        void getAds(RequestBody requestBody);

        /**
         * 纯图片上传
         */
        void uploadFile(MultipartBody.Part body);

        /**
         * 多图上传代参数
         */
        void upLoadImages(String name,String precept,List<MultipartBody.Part> part);

    }
}
