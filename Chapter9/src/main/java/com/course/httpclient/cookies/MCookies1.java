package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MCookies1 {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforTest(){
        bundle =ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        //抽离配置文件，拼接URl
        String result;
        String uri= bundle.getString("getCookies.uri");
        String testurl= (this.url+uri);
//构建声明客户端
        HttpGet get = new HttpGet(testurl);
//声明执行方法
        DefaultHttpClient client = new DefaultHttpClient();
//执行接住返回对象
        HttpResponse response = client.execute(get);
//赋值给String类型的result
        result= EntityUtils.toString(response.getEntity(),"gbk");
//打印输出
        System.out.println(result);
        //获取cookies信息
        this.store = client.getCookieStore();
        //泛型显示数据对象显示
        List<Cookie> cookiesList = store.getCookies();
        //循环遍历cookies
        for(Cookie cookies:cookiesList){
            String name = cookies.getName();
            String value = cookies.getValue();
            System.out.println("cookies name = "+name+"cookies value=" +value);
        }

    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testWithGetCookies() throws IOException {
        //抽离拼接url
        String uri = bundle.getString("test.get.with.cookies");
        String testurl = this.url + uri;
        //声明客户端
        HttpGet get = new HttpGet(testurl);
        //声明执行方法
        DefaultHttpClient client = new DefaultHttpClient();
        //把cookies带进去
        //设置cookies信息，用client方法设置
        client.setCookieStore(this.store);
        //记住返回对象
        HttpResponse response = client.execute(get);
        //获取相应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        //打印状态码
        System.out.println("statuscode="+statusCode);
        //判断输出
        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"gbk");
            //返回200 打印返回结果
            System.out.println(result);
        }else{
            System.out.println("二次发送get请求失败");
        }
    }
}
