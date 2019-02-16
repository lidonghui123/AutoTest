package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    @BeforeSuite
    public void  beforeSuite(){
        System.out.println();
        System.out.println("beforeSuite     运行啦");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after Suite 运行啦");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("befoetest 运行啦");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("after test  运行啦");
    }

}
