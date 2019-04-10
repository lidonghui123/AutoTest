package com.course.httpclient;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNoe {

    @BeforeTest
    public  void beforTest(){
        System.out.println("简单那输出测试");
    }
    @Test
    public  void test(){
        System.out.println("简单测试");
    }
}

