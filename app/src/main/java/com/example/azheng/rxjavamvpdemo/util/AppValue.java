package com.example.azheng.rxjavamvpdemo.util;

import android.annotation.SuppressLint;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * https://github.com/764990722
 */

public class AppValue {

    public static final int CROP_PICTURE = 2;//裁剪后图片返回码
    public static final int REQUEST_CODE_CHOOSE = 23;//定义请求码常量
    public static String api_token = "";
    /*登录后保存用来自动登录*/
    public static String userToken = "";
    /*获取手机*/
    public static String UserPhone = "";
    /*保存用户accid*/
    public static String UserAccID = "";
    /*头像截图保存路径*/
    @SuppressLint("SdCardPath")
    public final static String userXIXPath = "/sdcard/BloodSource/file/Huancun/Image/";

}
