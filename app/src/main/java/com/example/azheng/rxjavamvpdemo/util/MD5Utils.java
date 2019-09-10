package com.example.azheng.rxjavamvpdemo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * 功能说明：MD5加密的工具类
 */
public class MD5Utils {
//    private static String YAN = "wderer223sdeaaddr23wssdee334a";
    public static String md5Encrypt(String str){
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] bys = digest.digest((str).getBytes());
            StringBuilder sb = new StringBuilder();
            for(byte bb : bys){
                int num = bb & 0xff;
                String hex = Integer.toHexString(num);
                if(hex.length() == 1){
                    sb.append("0");
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


}