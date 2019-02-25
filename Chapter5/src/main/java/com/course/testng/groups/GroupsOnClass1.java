package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println();
        System.out.println("syu1已经执行");
    }
    public void stu2(){
        System.out.println("syu2已经执行");
    }
}
