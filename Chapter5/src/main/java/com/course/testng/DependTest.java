package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void test1(){
        System.out.println("test1 执行啦");
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 执行啦 ");
    }


}
