package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;


public class TestConfig {
    //存储变量，与application对应的一些变量
    //用静态的，加载一次就可以了。
    public static String loginUrl;
    public static String updateUserInfoUrl;
    public static String getuserListUrl;
    public static String getUserInfoUrl;
    public static String addUserUrl;


    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore store;
}
