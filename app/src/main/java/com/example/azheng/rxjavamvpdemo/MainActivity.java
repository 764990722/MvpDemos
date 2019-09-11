package com.example.azheng.rxjavamvpdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.widget.Toast;

import com.example.azheng.rxjavamvpdemo.activity.HomeActivity;
import com.example.azheng.rxjavamvpdemo.base.BaseMvpActivity;
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.LoginBean;
import com.example.azheng.rxjavamvpdemo.contract.MainContract;
import com.example.azheng.rxjavamvpdemo.net.Json;
import com.example.azheng.rxjavamvpdemo.presenter.MainPresenter;
import com.example.azheng.rxjavamvpdemo.util.ACache;
import com.example.azheng.rxjavamvpdemo.util.AppValue;
import com.example.azheng.rxjavamvpdemo.util.MD5Utils;
import com.example.azheng.rxjavamvpdemo.util.ProgressDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.azheng.rxjavamvpdemo.net.Json.toJson;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * https://github.com/764990722
 */

public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.et_username_login)
    TextInputEditText etUsernameLogin;
    @BindView(R.id.et_password_login)
    TextInputEditText etPasswordLogin;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mPresenter = new MainPresenter();
        mPresenter.attachView(this);
    }

    /**
     * 测试账号1    17320378800  a123456
     * 测试账号2    17320378805  a123456
     * */

    /**
     * @return 帐号
     */
    private String getUsername() {
        return etUsernameLogin.getText().toString().trim();
    }

    /**
     * @return 密码
     */
    private String getPassword() {
        return MD5Utils.md5Encrypt(etPasswordLogin.getText().toString().trim());
    }


    @Override
    public void onSuccess(BaseObjectBean<LoginBean> bean) {
        Toast.makeText(this,"onSuccess:" + bean.getMsg(), Toast.LENGTH_SHORT).show();
        ACache mCache = ACache.get(this);
        mCache.put("password",toJson(bean.getData()), 60*60*24*30*12);
        String value = mCache.getAsString("password");
        if (value != null) {
            LoginBean list = Json.toObject(value, LoginBean.class);
            AppValue.api_token = list.getApiToken();
            AppValue.userToken = list.getUserToken();
            Log.e("userToken", ""+AppValue.api_token);
            Log.e("userToken", ""+AppValue.userToken);
            if(list.isComplete()){
                mCache.put("UserPhone", list.getUser().getPerson().getPhone(), 60*60*24*30*12);
                AppValue.UserPhone = mCache.getAsString("UserPhone");
                AppValue.UserAccID = list.getUser().getWangyicloud().getAccid();
            }
        }
        startActivity(new Intent(MainActivity.this,HomeActivity.class));
    }

    @Override
    public void onFailed(String msg) {
        Toast.makeText(this,"onFailed:" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dismiss();
    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(this, "onError:" +throwable.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.btn_signin_login)
    public void onViewClicked() {
        if (getUsername().isEmpty() || getPassword().isEmpty()) {
            Toast.makeText(this, "帐号密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.login(getUsername(), getPassword());
    }

}
