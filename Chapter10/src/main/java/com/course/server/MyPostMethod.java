package com.course.server;


import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "这是我全部的post请求")
@RequestMapping("/v1")
public class MyPostMethod {
    //这个变量是用来装我们的cookies信息的
    private static Cookie cookie;

    //用户登录成功获取到的cookies，然后在访问其他接口获取到列表
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        //value = "userName"前端显示的名字，required = true必须要传
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password) {
        if (userName.equals("zhangsan") && password.equals("123456")) {
            cookie = new Cookie("login", "true");
            response.addCookie(cookie);
            return "恭喜你登录成功了";
        }
        return "登录失败";

    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取参数列表", httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                              @RequestBody User u) {
        User user;
        //获取cookies信息
        Cookie[] cookies = request.getCookies();
        //验证cookies是否合法
        for (Cookie c : cookies) {
            if (c.getName().equals( "login")
                    && c.getValue().equals("true")
                    && u.getUserName().equals("zhangsan")
                    && u.getPassword().equals("123456")
            ) {
                user = new User();
                user.setName("libowen");
                user.setAge("18");
                user.setSex("man");

                return user.toString();
            }
        }
        return "参数不合法";
    }

}


