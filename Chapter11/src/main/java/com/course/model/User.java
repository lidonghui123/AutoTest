package com.course.model;

import lombok.Data;

@Data//注解在类上, 为类提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
public class User {
    private int id;
    private String name;
    private int age;
    private String sex;
}
