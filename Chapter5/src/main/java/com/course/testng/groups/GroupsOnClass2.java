package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu" )
public class GroupsOnClass2 {

    public void stu1(){
        System.out.println("groupsOnClass2 中的stu1111111执行");
    }
    public void stu2(){
        System.out.println("groupsOnClass2 中的stu2222222执行");
    }
}
