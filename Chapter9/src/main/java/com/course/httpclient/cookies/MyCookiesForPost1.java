package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost1 {

    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforTest() {
        //配置文件拼接测试
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        //配置文件转换成String类型
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        //从配置文件拼接测试URl
        String result;
        String uri = bundle.getString("getCookies.uri");
        String testurl = this.url + uri;

        //使用get请求
        HttpGet get = new HttpGet(testurl);
        // 声明一个对象来进行响应结果的存储
        DefaultHttpClient client = new DefaultHttpClient();

        //执行get方法
        HttpResponse response = client.execute(get);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(), "gbk");
        //打印结果
        System.out.println(result);

        //第二部分cookies信息获取
        //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        //for循环遍历，key和value
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            //打印cookies的key和value信息
            System.out.println("cookies name= " + name + "cookies value =" + value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testWithPostCookies() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String testurl2 = this.url+uri;

        //声明一个client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testurl2);
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        //如果有请求头信息，就的设置请求头信息了
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法里面
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        //把参数和entity对象绑定到一起，set进方法里面
        post.setEntity(entity);
        //声明一个对象来进行相应结果的存储
        String result;
        //设置cookies信息
        client.setCookieStore(store);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取相应结果
        result = EntityUtils.toString(response.getEntity(),"gbk");
        //打印结果
        System.out.println(result);
        //将返回的结果字符串转换成json对象
        JSONObject resultjson = new JSONObject(result);
        //获取到结果
        String success = (String) resultjson.get("huhansan");
        String status = (String) resultjson.get("status");
        String text = (String) resultjson.get("text");
        //处理结果，就是判断返回结果是否符合预期
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
        Assert.assertEquals("返回数据成功",text);

    }
}
