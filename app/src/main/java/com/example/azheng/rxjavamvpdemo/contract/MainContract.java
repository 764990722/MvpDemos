package com.example.azheng.rxjavamvpdemo.contract;

import com.example.azheng.rxjavamvpdemo.base.BaseView;
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.LoginBean;

import io.reactivex.Flowable;


/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * https://github.com/764990722
 * 类 描 述：
 */
public interface MainContract {
    interface Model {
        Flowable<BaseObjectBean<LoginBean>> login(String username, String password);
        Flowable<BaseObjectBean<LoginBean>> Zdlogin(String userToken);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BaseObjectBean<LoginBean> bean);

        void onFailed(String msg);
    }

    interface Presenter {
        /**
         * 登陆
         * @param username
         * @param password
         */
        void login(String username, String password);

        /**
         * 自动登录
         userToken
         */
        void Zdlogin(String userToken);
    }
}
