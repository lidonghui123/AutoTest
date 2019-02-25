package com.course.testng.multiTread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {
    /**
     * invocationCount 执行10次，
     * threadPoolSize线程池里面5个线程
     *Thread.currentThread().getId()获取当前线程Id'
     */
    /*
    @Test(invocationCount = 10,threadPoolSize = 5)
    public void test1(){
        System.out.println(1);
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }
*/
    @Test(invocationCount = 3,threadPoolSize = 2)
    public void test2(){
        System.out.println(1);
        System.out.printf("Thread Id: %s%n", Thread.currentThread().getId());
    }
}
