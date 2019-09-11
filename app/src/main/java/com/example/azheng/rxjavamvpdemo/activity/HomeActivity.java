package com.example.azheng.rxjavamvpdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.example.azheng.rxjavamvpdemo.R;
import com.example.azheng.rxjavamvpdemo.adapter.FamilyAdapter;
import com.example.azheng.rxjavamvpdemo.base.BaseMvpActivity;
import com.example.azheng.rxjavamvpdemo.bean.BaseArrayBean;
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.BeanFamily;
import com.example.azheng.rxjavamvpdemo.bean.BeanPhone;
import com.example.azheng.rxjavamvpdemo.bean.BeanZqin;
import com.example.azheng.rxjavamvpdemo.contract.HoneContract;
import com.example.azheng.rxjavamvpdemo.presenter.HomePresenter;
import com.example.azheng.rxjavamvpdemo.util.AppValue;
import com.example.azheng.rxjavamvpdemo.util.ProgressDialog;
import com.example.azheng.rxjavamvpdemo.util.SnackbarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * https://github.com/764990722
 * 类 描 述：
 */
public class HomeActivity extends BaseMvpActivity<HomePresenter> implements HoneContract.View {

    @BindView(R.id.edit_phone)
    TextInputEditText edit_phone;
    @BindView(R.id.edit_name)
    TextInputEditText edit_name;
    @BindView(R.id.edit_out_name)
    TextInputEditText edit_out_name;
    @BindView(R.id.edit_out_depict)
    TextInputEditText edit_out_depict;
    @BindView(R.id.iv_herd)
    ImageView iv_herd;
    @BindView(R.id.rv_mr_all)
    RecyclerView rv_mr_all;

    private Activity activity;
    private List<String> imgsPath = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item;
    }

    @Override
    public void initView() {
        mPresenter = new HomePresenter();
        mPresenter.attachView(this);
        mPresenter.family();
    }

    @Override
    public void onSuccess(BaseObjectBean<BeanPhone> bean) {
        if (bean.getData().isRegister()) {
            SnackbarUtil.showSnackbar(rv_mr_all,"已注册");
        } else {
            SnackbarUtil.showSnackbar(rv_mr_all,"未注册");
        }
    }




    @Override
    public void onSuccess1(BaseObjectBean<BeanZqin> bean) {
        if (bean.getData().getUsers().size() == 0) {
            SnackbarUtil.showSnackbar(rv_mr_all,"未找到");
        } else {
            SnackbarUtil.showSnackbar(rv_mr_all,bean.getData().getUsers().get(0).getName());
        }
    }

    @Override
    public void onSuccess2(BaseObjectBean bean) {
        SnackbarUtil.showSnackbar(rv_mr_all,"上传json" + bean.getMsg());
    }

    @Override
    public void onSuccess3(BaseObjectBean bean) {
        SnackbarUtil.showSnackbar(rv_mr_all,"单图上传" + bean.getMsg());
    }

    @Override
    public void onSuccess4(BaseObjectBean bean) {
        SnackbarUtil.showSnackbar(rv_mr_all,"单图带参上传" + bean.getMsg());
        mPresenter.family();
    }

    @Override
    public void onSuccess5(BaseArrayBean<BeanFamily> bean) {
        //家庭圈列表
        mPresenter.familyList(activity, rv_mr_all, bean);
    }

    @Override
    public void onSuccess6(BaseObjectBean bean) {
        SnackbarUtil.showSnackbar(rv_mr_all,"解散或退出" + bean.getMsg());
    }


    @Override
    public void onFailed(String msg) {
        SnackbarUtil.showSnackbar(rv_mr_all,"onFailed:" + msg);
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
        SnackbarUtil.showSnackbar(rv_mr_all,"onError:" + throwable.toString());
        Log.e("onError", throwable.toString());
    }

    /*检查手机号*/
    @OnClick(R.id.but_phone)
    public void but_phone() {
        mPresenter.phone(edit_phone.getText().toString());
    }

    /*查找宗亲*/
    @OnClick(R.id.but_name)
    public void but_name() {
        mPresenter.name(edit_name.getText().toString());
    }

    /*上传json*/
    @OnClick(R.id.but_json)
    public void but_json() {
        JSONArray jsonArrayNew = new JSONArray();
        jsonArrayNew.add("4325630894");
        jsonArrayNew.add("4287102044");
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonArrayNew.toJSONString());
        mPresenter.getAds(requestBody);
    }

    /*单图上传*/
    @OnClick(R.id.but_form)
    public void but_form() {
        imgsPath.clear();
        //选取图片后直接上传  IsMulti判断是不带参传图  还是带参
        mPresenter.getFrom(activity, false, 1);
    }

    /*图片+参数上传*/
    @OnClick(R.id.iv_herd)
    public void iv_herd() {
        imgsPath.clear();
        mPresenter.inMore(edit_out_name, edit_out_depict, activity);
    }

    /*图片+参数上传*/
    @OnClick(R.id.but_create)
    public void but_create() {
        imgsPath.clear();
        mPresenter.inMore(edit_out_name, edit_out_depict, activity);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null) {
                if (requestCode == AppValue.REQUEST_CODE_CHOOSE) {
                    //知乎选择图片后 直接上传
                    mPresenter.getzhImag(data, activity);
                } else if (requestCode == AppValue.CROP_PICTURE) {
                    //截图后的操作 直接上传
                    mPresenter.getjtImag(data, activity, iv_herd, imgsPath, edit_out_name.getText().toString(), edit_out_depict.getText().toString());
                }
            }
        }
    }


}
