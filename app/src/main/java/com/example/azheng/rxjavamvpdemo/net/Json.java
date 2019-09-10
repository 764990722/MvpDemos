package com.example.azheng.rxjavamvpdemo.net;

import com.google.gson.Gson;

/**
 * 创建时间: 2017/3/20.
 * 类 描 述: JSON操作的类
 */

public class Json {

    private static Gson gson;

    /**
     * 静态代码块,初始化
     */
    static {
        gson = new Gson();
    }

    /**
     * 将对象序列化成JSON
     *
     * @param object 序列化的对象
     * @return 返回序列化的JSON字符串
     */
    public static String toJson(Object object) {
        String json;
        try {
            json = gson.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    /**
     * 将JSON字符串反序列化成对象
     *
     * @param json JSON字符串
     * @param cls  序列化的CLASS类模型
     * @param <T>  泛型
     * @return 返回反序列化的对象
     */
    public static <T> T toObject(String json, Class<?> cls) {
        T object;
        try {
            object = (T) gson.fromJson(json, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return object;
    }
}
