package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

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
   /* @Test
    public void logDemo(){
        Reporter.log("测试日志打印");
        throw  new RuntimeException("这是我们自己写的运行时候异常");
    }*/
}
