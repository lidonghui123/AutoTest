package com.course.model;

import lombok.Data;

@Data
public class UpdateUserInfoCase {
    //model加载
    private int id;
    private int userId;
    private String userName;
    private String sex;
    private String age;
    private String permission;
    private String expected;
}
