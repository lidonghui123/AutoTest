package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpclient1 {
    @Test
    public void test1() throws IOException {

        //用来存放我们的结果
        String result;
        //请求链接
        HttpGet get = new HttpGet("http://www.baidu.com");
        //用什么形式请求
        HttpClient client = new DefaultHttpClient();
        //用什么接收
        HttpResponse response = client.execute(get);
        //转换成String类型，并且赋值
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        //打印查看
        System.out.println(result);
        }
    }

