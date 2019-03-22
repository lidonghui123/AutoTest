package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {

  /*  @Test
    public void test1() throws IOException {

        //用来存放我们的结果
        String result;
        //get的方法的请求
        HttpGet get = new HttpGet("http://www.baidu.com");
        //这是用来执行get方法的，httpclient执行get请求
        HttpClient client = new DefaultHttpClient();
        //开始执行，返回response
        HttpResponse response = client.execute(get);
        //转换成String类型的，
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }*/

    @Test
    public void test2() throws IOException {

        String result1;

        HttpGet getone = new HttpGet("http://192.168.145.20:8088/testsite/normalwork");

        HttpClient client1 = new DefaultHttpClient();

        HttpResponse response1 = client1.execute(getone);

        result1 = EntityUtils.toString(response1.getEntity(),"utf-8");

        System.out.println(result1);
    }
    @Test
    public void test3() throws IOException {
        String result2;

        HttpGet gettwo = new HttpGet("http://www.baidu.com");

        HttpClient client2 = new DefaultHttpClient();

        HttpResponse response2 = client2.execute(gettwo);

        result2 = EntityUtils.toString(response2.getEntity(),"utf-8");

        System.out.println(result2);

    }
    @Test
    public void test5() throws IOException {
        String result3;
        HttpGet getthree = new HttpGet("www.baidu.com");

        HttpClient clinet3 = new DefaultHttpClient();

        HttpResponse response3 = clinet3.execute(getthree);

        result3 = EntityUtils.toString(response3.getEntity(),"utf-8");

        System.out.println(result3);
    }
}
