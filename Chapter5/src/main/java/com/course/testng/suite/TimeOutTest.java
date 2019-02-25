package com.course.testng.suite;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 2000)
    public void testFailed() throws InterruptedException{
        //System.out.println("失败了");
        Thread.sleep(3000);
    }

    @Test(timeOut = 3000)
    public void testSuccess()throws InterruptedException{
        Thread.sleep(2000);
        System.out.println("成功的");
    }
}
