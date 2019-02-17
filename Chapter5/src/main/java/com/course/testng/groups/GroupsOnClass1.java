package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println("groupsOnClass1 中的stu1111111执行");
    }
    public void stu2(){
        System.out.println("groupsOnClass1中的 stu22222222执行");
    }
}
