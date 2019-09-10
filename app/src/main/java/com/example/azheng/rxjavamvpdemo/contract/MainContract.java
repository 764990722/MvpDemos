package com.example.azheng.rxjavamvpdemo.contract;

import com.example.azheng.rxjavamvpdemo.base.BaseView;
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.LoginBean;

import io.reactivex.Flowable;


/**
 * @author azheng
 * @date 2018/6/4.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
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
