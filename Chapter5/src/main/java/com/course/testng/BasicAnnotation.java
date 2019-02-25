package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的注解，用来把方法标记测试的一部分。
    /*Test
    public void testCase1(){
        System.out.println("Test这是测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.println(" test这是测试用例2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod这是在测试方法之前运行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("aftermethod这是在测试方法之后运行的");

    }
    @BeforeClass
    public  void beforeClass(){
        System.out.println("beforeclass 这是在之前运行的方法");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass 这是在之后运行的方法");
    }

    @BeforeSuite
    public void beforSuite(){
        System.out.println("beforsuite测试套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite测试套件");
    }
*/

    @Test
   public void testCase1(){
       System.out.println("test这是测试用例1");
   }
   @Test
   public void testCase2(){
       System.out.println("test2这是测试用例2");
   }

   @BeforeMethod
   public void BeforeMethod(){
       System.out.println(" beforemethod是测试方法之前运行的");
   }
   @AfterMethod
    public void aftermethod(){
       System.out.println("aftermethod 是在测试方法之后运行");
   }
   @BeforeClass
   public void beforeclass(){
       System.out.println("beforeclass是在测试类运行之前运行的");
   }
   @AfterClass
   public void afterclass(){
       System.out.println("afterclass 是在测试类之后运行的的");
   }
}

