package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    //加載配置文件的對象
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
    //工具类直接命名静态方法，不用new，直接可以使用

    public static String getUrl(InterfaceName name) {
        String address = bundle.getString("test.url");
        String uri = "";
        //最终的测试地址
        String testUrl;
        //补全逻辑,配置工具类
        if (name == InterfaceName.GETUSERLIST) {
            uri = bundle.getString("getUserList.uri");
        }
        if(name== InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }
        if(name==InterfaceName.UPDATEUSERINFO){
            uri = bundle.getString("updateUserInfo.uri");
        }
        if(name==InterfaceName.GETISERINFO){
            uri = bundle.getString("getUserInfo.uri");
        }
        if(name==InterfaceName.ADDUSERINFO){
            uri = bundle.getString("addUser.uri");
        }


        testUrl = address + uri;
        return testUrl;
    }

}
