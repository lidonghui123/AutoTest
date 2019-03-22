package com.tester.extend.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestMethodDemo {


    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");
    }
     @Test
    public void test4(){
        Reporter.log("测试通过");
        Assert.assertEquals(1,2);
    }
    @Test
    public void test5() throws IOException {
        String result2;

        HttpGet gettwo = new HttpGet("http://www.baidu.com");

        HttpClient client2 = new DefaultHttpClient();

        HttpResponse response2 = client2.execute(gettwo);

        result2 = EntityUtils.toString(response2.getEntity(),"utf-8");

        System.out.println(result2);


    }
   /* @Test
    public void logDemo(){
        Reporter.log("测试日志打印");
        throw  new RuntimeException("这是我们自己写的运行时候异常");
    }*/
}
