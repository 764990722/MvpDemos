package com.example.azheng.rxjavamvpdemo.net;


import com.example.azheng.rxjavamvpdemo.bean.BaseArrayBean;
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.BeanFamily;
import com.example.azheng.rxjavamvpdemo.bean.BeanPhone;
import com.example.azheng.rxjavamvpdemo.bean.BeanZqin;
import com.example.azheng.rxjavamvpdemo.bean.LoginBean;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/3/19
 * https://github.com/764990722
 * 注解@FormUrlEncoded对所传地址进行编码解析
 */
public interface APIService {
    /*以上接口由血源派App测试服务器提供*/
    //////////////////POST/////////////////////
    //////////////////POST/////////////////////
    /*密码登录*/
    @FormUrlEncoded
    @POST("/login/password")
    Flowable<BaseObjectBean<LoginBean>> login(@Field("phone") String username,
                                              @Field("password") String password);

    /*自动登录*/
    @FormUrlEncoded
    @POST("/login/token")
    Flowable<BaseObjectBean<LoginBean>> Zdlogin(@Field("userToken") String userToken);

    /*查找亲友*/
    @FormUrlEncoded
    @POST("/user/query")
    Flowable<BaseObjectBean<BeanZqin>> name(@Field("name") String name);


    //////////////////GET/////////////////////
    //////////////////GET/////////////////////
    /*检查手机号*/
    @GET("/user/inspect")
    Flowable<BaseObjectBean<BeanPhone>> phone(@Query("phone") String phone);

    /*家庭圈列表*/
    @GET("/familyGroup/own")
    Flowable<BaseArrayBean<BeanFamily>> family();

    /*解散家庭圈*/
    @GET("/familyGroup/dismiss")
    Flowable<BaseObjectBean> delete(@Query("number") String number);


    //////////////////JSON/////////////////////
    //////////////////JSON/////////////////////
    /*列表排序json*/
    @POST("/familyGroup/reorder")
    Flowable<BaseObjectBean> getAds(@Body RequestBody requestBody);


    //////////////////From/////////////////////
    //////////////////From/////////////////////
    /*单图上传 修改头像-*/
    @Multipart
    @POST("/user/updateAvatar")
    Flowable<BaseObjectBean> uploadFile(@Part MultipartBody.Part body);

    /*单图上传--带参数 创建家庭圈
     name       // 名称，必填，字符串
     precept    // 家训，选填，字符串
    * */
    @Multipart
    @POST("/familyGroup/create")
    Flowable<BaseObjectBean> upLoadImages(@Query("name") String name,
                                          @Query("precept") String precept,
                                          @Part List<MultipartBody.Part> part);

    /*注释  多图上传很简单  参数改为List<MultipartBody.Part>  图片名称+时间遍历*/


}
