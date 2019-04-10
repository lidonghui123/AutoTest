package com.course.controller;


import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j
@RestController //控制器，运行下面
@Api(value = "v1", description = " 这是我的第一个版本的demo")//对该类进行描述
@RequestMapping("v1") //v1上下对应，path路径一定要写上
public class Demo {

    //首先获取一个执行sql语句的对象,必须要加上aotuwlred标签, 启动机加载demo类
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)//path路径，以及请求的方法
    @ApiOperation(value = " 获取用户数量", httpMethod = "GET")//接口文档注释该方法注解，以及请求方法
    public int getUserCount() {
        // 执行sql,里面写于mysql.xml的id，然后return了
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = " 添加用户",httpMethod = "POST")
    public int addUser(@RequestBody User user){
        //debug一下，打一个断点看看怎么引起的
        int  result = template.insert("addUser",user);
        return result;
    }

    /*@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "插入数据", httpMethod = "POST")
    public int addUser(@RequestBody User user) {
        int result = template.insert("addUser");
        return result;
    }*/

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ApiOperation(value = "此方法是数据库更新的sql语句", httpMethod = "POST")
    public int updateUser(@RequestBody User user) {
        //更新updateUser信息
        int result = template.update("updateUser", user);
        return result;
    }

   /* @RequestMapping(value = "/delectUser", method = RequestMethod.POST)
    @ApiOperation(value = "此方法是数据库删除的sql语句", httpMethod = "POST")
    public int delUser(@RequestParam int id) {
        //执行方法，sql语句的id映射到mysql.xml语句中，直接返回结果
        int result = template.delete("delectUser", id);
        return result;
    }*/

   @RequestMapping(value = "/delUser",method = RequestMethod.POST)
   @ApiOperation(value = "删除用户sql语句",httpMethod = "POST")
   public int delUser(@RequestBody User user){
       //执行方法，sql语句的id映射到mysql.xml语句中，直接返回结果
       int result = template.delete("delectUser",user);
       return  result;
   }

}
