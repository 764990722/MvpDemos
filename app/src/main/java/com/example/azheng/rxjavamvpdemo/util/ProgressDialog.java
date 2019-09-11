package com.example.azheng.rxjavamvpdemo.util;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.azheng.rxjavamvpdemo.R;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * https://github.com/764990722
 */

public class ProgressDialog {

    private static volatile ProgressDialog instance;

    private ProgressDialog() {
    }

    public static ProgressDialog getInstance() {
        if (instance == null) {
            synchronized (ProgressDialog.class) {
                if (instance == null) {
                    instance = new ProgressDialog();
                }
            }
        }
        return instance;
    }

    private MaterialDialog materialDialog;

    public void show(Context mContext) {
        materialDialog = new MaterialDialog.Builder(mContext)
//                .title(R.string.progress_dialog_title)
                .content(R.string.progress_please_wait)
                .progress(true, 0)
                .cancelable(false)
                .progressIndeterminateStyle(false)
                .show();

    }

    public void dismiss() {
        materialDialog.dismiss();
    }
}
