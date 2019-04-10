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

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforTest() {
        //配置文件构建一个对象
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        //配置文件转换成String类型
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        //从配置文件拼测试URl
        String result;
        String uri = bundle.getString("getCookies.uri");
        String testurl = this.url + uri;
        //使用get请求
        HttpGet get = new HttpGet(testurl);
        //httpclient方法`
        DefaultHttpClient client = new DefaultHttpClient();
        //执行接住返回结果
        HttpResponse response = client.execute(get);
        //赋值给String类型文件
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        //打印输出
        System.out.println(result);
        //第二阶段是cookies信息处理
        //获取cookies信息
        this.store = client.getCookieStore();
        //list对象显示Cookieslist
        List<Cookie> cookieList = store.getCookies();
        //for循环遍历，key和value
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            //打印
            System.out.println("cookies name = " + name
                    + "  cookies value = " + value);
        }
    }

    /*@Test(dependsOnMethods = {"testGetCookies"})
   public void  testGetWithCookies() throws IOException {
       String uri = bundle.getString("test.get.with.cookies");
       String testurl2 = this.url+uri;
       //以下代码为请求代码
       HttpGet get = new HttpGet(testurl2);
       //声明执行的方法
       DefaultHttpClient client = new DefaultHttpClient();
       //然后把cookies。store信息带进去
       //设置cookies信息，用client方法设置
       client.setCookieStore(this.store);
       //接住相应对象
       HttpResponse response = client.execute(get);
       //请求后获取响应状态码
       int statusCode = response.getStatusLine().getStatusCode();
       //判断相应状态码
       if(statusCode == 200){
           String result = EntityUtils.toString(response.getEntity(),"gbk");
           System.out.println(result);
       }else{
           System.out.println("请求失败了");
       }
   }*/
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostWithMethod() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        String testurl2 = this.url + uri;

        //声明一个client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testurl2);
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name", "huhansan");
        param.put("age", "18");
        //设置请求信息,设置Header信息
        post.setHeader("content-type", "application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(), "gbk");
        System.out.println(result);

        //将返回结果的字符串转换成json对象
        //JSONObject resultJson = new JSONObject(result);
        JSONObject resultJson = new JSONObject(result);
        //获取到结果值
        String success = (String) resultJson.get("huhansan");
        String status = (String) resultJson.get("status");
        String text = (String) resultJson.get("text");
        //处理结果，就是判断返回结果是否符合预期
        Assert.assertEquals("success", success);
        Assert.assertEquals("1", status);
        Assert.assertEquals("返回数据成", text);
    }

}
