package com.example.azheng.rxjavamvpdemo.base;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * https://github.com/764990722
 * 类 描 述：
 */
public abstract class BaseMvpFragment<T extends BasePresenter>  extends BaseFragment implements BaseView{

    protected T mPresenter;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }
}
