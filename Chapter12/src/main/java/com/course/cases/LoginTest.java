package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {

    @BeforeTest//(groups = "loginTrue",description = "测试准备工作，获取httpclient对象")
    public void Beforetest() {
        //把5个对象一一进行赋值

        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETISERINFO);
        TestConfig.getuserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);

        TestConfig.defaultHttpClient = new DefaultHttpClient();

    }

    @Test //(groups = "loginTrue",description = "登录成功接口测试")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        //执行sql语句
        LoginCase loginCase = session.selectOne("loginCase", 1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
    }

    @Test //(groups = "loginFalse",description = "用户登录失败接口测试")
    public void loginFalse() throws IOException {
        /*SqlSession session = DatabaseUtil.getSqlSession();
        //
        LoginTest loginCase = session.selectOne("loginCase",2);
        //de
        System.out.println(loginCase.toString());
        //
        System.out.println(TestConfig.loginUrl);*/
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase = session.selectOne("loginCase", 2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

    }

}
