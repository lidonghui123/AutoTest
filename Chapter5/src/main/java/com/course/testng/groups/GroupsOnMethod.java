package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端测试的方法11111");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端测试的方法22222");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端测试的方法333333");
    }
    @Test(groups = "client")
    public  void test4(){
        System.out.println("这是客户端测试的方法444444");
    }
    @BeforeGroups("server")
    public void  BeforeOnServer(){
        System.out.println("这是服务端组开始运行的方法");
    }
    @AfterGroups("server")
    public void afterOnServer(){
        System.out.println("这是服务端组开始运行的方法");
    }
    @BeforeGroups("client")
    public void  BeforeOnclient(){
        System.out.println("这是客户端组开始运行的方法");
    }
    @AfterGroups("client")
    public void afterOnclient(){
        System.out.println("这是客户端组开始运行的方法");
    }
}
