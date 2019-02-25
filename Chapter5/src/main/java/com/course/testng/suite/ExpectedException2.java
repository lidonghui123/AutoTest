package com.course.testng.suite;

import org.testng.annotations.Test;

public class ExpectedException2 {
    /**
     * 异常测试
     */
    //失败的测试
    @Test(expectedExceptions = RuntimeException.class)
    public void testExceptionsFailed(){
        System.out.println("异常测试失败");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public  void testExceptionSuccess(){
        System.out.println("异常测试成功");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = "testExceptionSuccess")
    public void testRunMethod1(){
        System.out.println("此方法依赖异常测试成功");
    }


}
