package com.example.azheng.rxjavamvpdemo.presenter;


import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.azheng.rxjavamvpdemo.R;
import com.example.azheng.rxjavamvpdemo.adapter.FamilyAdapter;
import com.example.azheng.rxjavamvpdemo.base.BasePresenter;
import com.example.azheng.rxjavamvpdemo.bean.BaseArrayBean;
import com.example.azheng.rxjavamvpdemo.bean.BaseObjectBean;
import com.example.azheng.rxjavamvpdemo.bean.BeanFamily;
import com.example.azheng.rxjavamvpdemo.bean.BeanPhone;
import com.example.azheng.rxjavamvpdemo.bean.BeanZqin;
import com.example.azheng.rxjavamvpdemo.contract.HoneContract;
import com.example.azheng.rxjavamvpdemo.dialog.RuntimeRationale;
import com.example.azheng.rxjavamvpdemo.model.HomeModel;
import com.example.azheng.rxjavamvpdemo.net.RxScheduler;
import com.example.azheng.rxjavamvpdemo.util.AppValue;
import com.example.azheng.rxjavamvpdemo.util.MyGlideEngine;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import io.reactivex.functions.Consumer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 创 建 人 PeaceJay
 * 创建时间 2019/9/9
 * 类 描 述：
 */
public class HomePresenter extends BasePresenter<HoneContract.View> implements HoneContract.Presenter {

    private HoneContract.Model model;

    public HomePresenter() {
        model = new HomeModel();
    }

    private FamilyAdapter bookAdapter;
    private boolean IsMulti;
    private int Number;


    /*检查手机号*/
    @Override
    public void phone(String phone) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.phone(phone)
                .compose(RxScheduler.<BaseObjectBean<BeanPhone>>Flo_io_main())
                .as(mView.<BaseObjectBean<BeanPhone>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<BeanPhone>>(){
                    @Override
                    public void accept(BaseObjectBean<BeanPhone> bean) throws Exception {
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
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }

    /*家庭圈列表*/
    @Override
    public void family() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.family()
                .compose(RxScheduler.<BaseArrayBean<BeanFamily>>Flo_io_main())
                .as(mView.<BaseArrayBean<BeanFamily>>bindAutoDispose())
                .subscribe(new Consumer<BaseArrayBean<BeanFamily>>(){
                    @Override
                    public void accept(BaseArrayBean<BeanFamily> bean) throws Exception {
                        mView.hideLoading();
                        if (bean!=null){
                            switch (bean.getCode()){
                                case "000":
                                    mView.onSuccess5(bean);
                                    break;
                                default:
                                    mView.onFailed(bean.getMsg());
                                    break;
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }

    /*解散家庭圈*/
    @Override
    public void delete(String number,final int position) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.delete(number,position)
                .compose(RxScheduler.<BaseObjectBean>Flo_io_main())
                .as(mView.<BaseObjectBean>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean>(){
                    @Override
                    public void accept(BaseObjectBean bean) throws Exception {
                        mView.hideLoading();
                        if (bean!=null){
                            switch (bean.getCode()){
                                case "000":
                                    mView.onSuccess6(bean);
                                    if (bookAdapter!=null){
                                        bookAdapter.removeList(position);
                                    }
                                    break;
                                default:
                                    mView.onFailed(bean.getMsg());
                                    break;
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }


    /*查找宗亲*/
    @Override
    public void name(String name) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.name(name)
                .compose(RxScheduler.<BaseObjectBean<BeanZqin>>Flo_io_main())
                .as(mView.<BaseObjectBean<BeanZqin>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<BeanZqin>>(){
                    @Override
                    public void accept(BaseObjectBean<BeanZqin> bean) throws Exception {
                        mView.hideLoading();
                        if (bean!=null){
                            switch (bean.getCode()){
                                case "000":
                                    mView.onSuccess1(bean);
                                    break;
                                default:
                                    mView.onFailed(bean.getMsg());
                                    break;
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }

    /*上传json*/
    @Override
    public void getAds(RequestBody request) {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getAds(request)
                .compose(RxScheduler.<BaseObjectBean>Flo_io_main())
                .as(mView.<BaseObjectBean>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean>(){
                    @Override
                    public void accept(BaseObjectBean bean) throws Exception {
                        mView.hideLoading();
                        if (bean!=null){
                            switch (bean.getCode()){
                                case "000":
                                    mView.onSuccess2(bean);
                                    break;
                                default:
                                    mView.onFailed(bean.getMsg());
                                    break;
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }

    /*单图上传*/
    @Override
    public void uploadFile(MultipartBody.Part body) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.uploadFile(body)
                .compose(RxScheduler.<BaseObjectBean>Flo_io_main())
                .as(mView.<BaseObjectBean>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean>(){
                    @Override
                    public void accept(BaseObjectBean bean) throws Exception {
                        mView.hideLoading();
                        if (bean!=null){
                            switch (bean.getCode()){
                                case "000":
                                    mView.onSuccess3(bean);
                                    break;
                                default:
                                    mView.onFailed(bean.getMsg());
                                    break;
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }


    /*多图上传*/
    @Override
    public void upLoadImages(String name,String precept,List<MultipartBody.Part> part) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.upLoadImages(name,precept,part)
                .compose(RxScheduler.<BaseObjectBean>Flo_io_main())
                .as(mView.<BaseObjectBean>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean>(){
                    @Override
                    public void accept(BaseObjectBean bean) throws Exception {
                        mView.hideLoading();
                        if (bean!=null){
                            switch (bean.getCode()){
                                case "000":
                                    mView.onSuccess4(bean);
                                    break;
                                default:
                                    mView.onFailed(bean.getMsg());
                                    break;
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }

    public void getFrom(Activity activity,boolean IsMulti,int Number) {
        this.IsMulti = IsMulti;
        this.Number = Number;
        requestPermission(Permission.Group.CAMERA,Permission.Group.STORAGE,activity);
    }


    public void getzhImag(final Intent data,Activity activity) {
        try{
            List<Uri> mSelected = Matisse.obtainResult(data);
            for (Uri imageUri : mSelected) {
                startPhotoZoom(imageUri,activity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getjtImag(final Intent data, Activity activity, ImageView iv_herd,List<String> imgsPath,String name,String precept) {
        if (data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                try {
                    Bitmap photo = extras.getParcelable("data");
                    saveBitmap(photo,imgsPath);
                    iv_herd.setImageBitmap(photo);
                    if (!IsMulti){
                        FileImage(imgsPath);
                    } else {
                        FileImage(imgsPath,name,precept);
                    }
                }catch (Exception e){}
            }
        }
        try {
            Bitmap headShot = BitmapFactory.decodeStream(activity.getContentResolver().openInputStream(cropImageUri));
            if (headShot != null) {
                saveBitmap(headShot,imgsPath);
                iv_herd.setImageBitmap(headShot);
                if (!IsMulti){
                    FileImage(imgsPath);
                } else {
                    FileImage(imgsPath,name,precept);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void FileImage(List<String> imgsPath) {
        for (String pathItem : imgsPath) {
            if (!TextUtils.isEmpty(pathItem)) {
                File file = new File(pathItem);
                RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
                MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);// pictures 是参数名
                uploadFile(body);
            }
        }
    }


    public void familyList(final Activity activity, RecyclerView rv_mr_all, final BaseArrayBean<BeanFamily> bean){
        rv_mr_all.setFocusable(true);//解决显示位置
        rv_mr_all.setNestedScrollingEnabled(true);
        rv_mr_all.setLayoutManager(new LinearLayoutManager(activity));
        bookAdapter = new FamilyAdapter(bean.getData(),activity);
        rv_mr_all.setAdapter(bookAdapter);
        bookAdapter.buttonSetOnclick(new FamilyAdapter.ButtonInterface() {
            @Override
            public void onclick(View view, int position) {
                Toast.makeText(activity, "单点下标："+position, Toast.LENGTH_SHORT).show();
            }
        });

        bookAdapter.setOnRecyclerViewItemClickListener(new FamilyAdapter.OnItemClickListener() {
            @Override
            public void onLongClick(int position) {
                Toast.makeText(activity, "长按下标："+position, Toast.LENGTH_SHORT).show();
            }
        });

        bookAdapter.DeleteOnclick(new FamilyAdapter.DeleteInterface() {
            @Override
            public void onclick(View view, int position) {
                BeanFamily data = (BeanFamily) bean.getData().get(position);
                delete(data.getNumber(),position);
            }
        });
    }


    private void FileImage(List<String> imgsPath, String name, String precept) {
        for (String pathItem : imgsPath) {
            if (!TextUtils.isEmpty(pathItem)) {
                File file = new File(pathItem);
                MultipartBody.Builder builder = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)//表单类型
                        .addFormDataPart(name,"")
                        .addFormDataPart(precept,"");
                RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/jpg"), file);
                builder.addFormDataPart("file", file.getName(), photoRequestBody);
                List<MultipartBody.Part> parts = builder.build().parts();
                upLoadImages(name,precept, parts);
            }
        }
    }


    private void requestPermission(String[] CAMERA,String[] CONTACTS, final Activity activity) {
        AndPermission.with(activity)
                .runtime()
                .permission(CAMERA,CONTACTS)
                .rationale(new RuntimeRationale())
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> permissions) {
                        //成功
                        callGallery(true,activity);
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(@NonNull List<String> permissions) {
                        //失败
                        //拒绝的权限需要手动开启
                        if (AndPermission.hasAlwaysDeniedPermission(activity, permissions)) {
                            callGallery(false,activity);
                        }
                    }
                })
                .start();
    }


    /**
     * 调用图库选择
     */
    private void callGallery(boolean isok,Activity activity){
        Matisse.from(activity)
                .choose(MimeType.of(MimeType.JPEG, MimeType.PNG, MimeType.GIF))//照片视频全部显示MimeType.allOf()
                .countable(true)//true:选中后显示数字;false:选中后显示对号
                .maxSelectable(Number)//最大选择数量为9
                //.addFilter(new GifSizeFilter(320, 320, 5 * Filter.K * Filter.K))
                .gridExpectedSize(activity.getResources().getDimensionPixelSize(R.dimen.dp120))//图片显示表格的大小
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)//图像选择和预览活动所需的方向
                .thumbnailScale(0.85f)//缩放比例
                .theme(R.style.Matisse_Zhihu)//主题  暗色主题 R.style.Matisse_Dracula
                .imageEngine(new MyGlideEngine())//图片加载方式，Glide4需要自定义实现
                .capture(isok) //是否提供拍照功能，兼容7.0系统需要下面的配置
                //参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                .captureStrategy(new CaptureStrategy(false,"com.example.azheng.rxjavamvpdemo.fileprovider"))//存储到哪里
                .forResult(AppValue.REQUEST_CODE_CHOOSE);//请求码
    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    //裁剪图片存放地址的Uri
    private Uri cropImageUri;
    protected void startPhotoZoom(Uri uri,Activity activity) {
        File CropPhoto=new File(activity.getExternalCacheDir(),"crop_Family_image.jpg");
        try{
            if(CropPhoto.exists()){
                CropPhoto.delete();
            }
            CropPhoto.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        cropImageUri=Uri.fromFile(CropPhoto);
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //添加这一句表示对目标应用临时授权该Uri所代表的文件
        }
        // 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 1200);
        intent.putExtra("outputY", 1200);
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cropImageUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true); // no face detection
        activity.startActivityForResult(intent, AppValue.CROP_PICTURE);
    }

    /**
     * 保存Bitmap到本地
     *
     * @param bitmap
     */
    public void saveBitmap(Bitmap bitmap,List<String> imgsPath) {
        String imgPath = AppValue.userXIXPath + "crop_Family_image.jpg";
        File f = new File(imgPath);
        if (f.exists()) {
            f.delete();
        } else {
            File path = new File(f.getParent());
            if (!path.exists()) {
                path.mkdirs();
            }
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        imgsPath.add(imgPath);
        try {
            FileOutputStream out = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 20, out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inMore(TextInputEditText edit_out_name, TextInputEditText edit_out_depict, Activity activity) {
        //isEmpty是否有元素  true为没有
        if (TextUtils.isEmpty(edit_out_name.getText())){
            Toast.makeText(activity, "昵称不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        getFrom(activity,true,1);
    }

}
