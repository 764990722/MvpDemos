package com.example.azheng.rxjavamvpdemo.presenter;


import com.example.azheng.rxjavamvpdemo.base.BasePresenter;
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.LoginBean;
import com.example.azheng.rxjavamvpdemo.contract.MainContract;
import com.example.azheng.rxjavamvpdemo.model.MainModel;
import com.example.azheng.rxjavamvpdemo.net.RxScheduler;

import io.reactivex.functions.Consumer;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * https://github.com/764990722
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainContract.Model model;

    public MainPresenter() {
        model = new MainModel();
    }

    private void onSuccess(BaseObjectBean<LoginBean> bean) {
        mView.hideLoading();
        if (bean!=null){
            switch (bean.getCode()){
                case "000":
                    mView.onSuccess(bean);
                    break;
                default:
                    mView.onFailed(bean.getMsg());
                    break;
            }
        }
    }

    /*密码登录*/
    @Override
    public void login(String username, String password) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.login(username, password)
                .compose(RxScheduler.<BaseObjectBean<LoginBean>>Flo_io_main())
                .as(mView.<BaseObjectBean<LoginBean>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<LoginBean>>(){
                    @Override
                    public void accept(BaseObjectBean<LoginBean> bean) throws Exception {
                        onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }


    /*自动登录*/
    @Override
    public void Zdlogin(String userToken) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.Zdlogin(userToken)
                .compose(RxScheduler.<BaseObjectBean<LoginBean>>Flo_io_main())
                .as(mView.<BaseObjectBean<LoginBean>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<LoginBean>>(){
                    @Override
                    public void accept(BaseObjectBean<LoginBean> bean) throws Exception {
                        onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }



}
