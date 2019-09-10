package com.example.azheng.rxjavamvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.azheng.rxjavamvpdemo.base.BaseMvpActivity;
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.LoginBean;
import com.example.azheng.rxjavamvpdemo.contract.MainContract;
import com.example.azheng.rxjavamvpdemo.net.Json;
import com.example.azheng.rxjavamvpdemo.presenter.MainPresenter;
import com.example.azheng.rxjavamvpdemo.util.ACache;
import com.example.azheng.rxjavamvpdemo.util.AppValue;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * 类 描 述：
 */
public class SplashActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void initView() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
        ACache mCache = ACache.get(SplashActivity.this);
        String value = mCache.getAsString("password");
        if (value != null) {
            LoginBean list = Json.toObject(value, LoginBean.class);
            AppValue.api_token = list.getApiToken();
            AppValue.userToken = list.getUserToken();
            mPresenter.Zdlogin(AppValue.userToken);
            Log.e("userToken", ""+AppValue.api_token);
            Log.e("userToken", ""+AppValue.userToken);
        } else {
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
            finish();
        }
    }

    @Override
    public void onSuccess(BaseObjectBean<LoginBean> bean) {
        Toast.makeText(this, "onSuccess:" + bean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(this, "onFailed:" + msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
        finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
