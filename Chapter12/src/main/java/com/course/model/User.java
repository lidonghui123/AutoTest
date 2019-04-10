package com.course.model;


import lombok.Data;

@Data
public class User {

    private int id;
    private String userName;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String idDelete;
//json格式的处理,tostring变成json格式复写方法
    @Override
    public String toString(){
        return (
                "{id:"+id+","+
                "userName:"+userName+","+
                "password:"+password+","+
                "age:"+age+","+
                "sex:"+sex+","+
                "permission:"+permission+","+
                "idDelete:"+idDelete+"}"
                );
    }


}
