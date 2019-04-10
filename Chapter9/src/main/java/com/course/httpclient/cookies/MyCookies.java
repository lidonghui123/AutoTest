package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
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

public class MyCookies {

    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore  store;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        //从配置文件中拼接测试文件url
        String result;
        //使用get请求
        HttpGet get = new HttpGet(this.url+bundle.getString("getCookies.uri"));
        //httpclient方法
        HttpClient client = new DefaultHttpClient();
        //执行接住返回结果
        HttpResponse response = client.execute(get);
        //赋值给String类型文件
        result = EntityUtils.toString(response.getEntity(),"gbk");
        //打印返回值
        System.out.println(result);

        //获取cookies信息
        this.store = ((DefaultHttpClient) client).getCookieStore();
        //数组对象显示
        List<Cookie> cookieList = store .getCookies();

        for (Cookie cookie:cookieList){
            String name = cookie.getName();
            String value  = cookie.getValue();

            System.out.println("cookies name =" +name+"  cookies value ="+value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies") ;
        String testurl1 =this.url+uri;
        //声明客户端
        HttpGet get = new HttpGet(testurl1);
        //声明执行方法
        DefaultHttpClient client = new DefaultHttpClient();
        //然后把cookiesStroe带进去
        //设置cookies信息，用client方法设置。
        client.setCookieStore(this.store);
        //接住相应
        HttpResponse response = client.execute(get);
        //获取相应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statuscode "+statusCode);
        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"gbk");
            System.out.println(result);
        }

    }



}
