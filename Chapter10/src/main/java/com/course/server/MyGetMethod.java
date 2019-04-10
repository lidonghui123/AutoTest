package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {
        //HttpServerletrequest
        //HttpServerletreresponse
        //设置cookie信息bbnppp0;;
        Cookie cookie = new Cookie("login", "true");
        //添加相应的cookie
        response.addCookie(cookie);
        return "恭喜你获得cookies成功";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies访问的get请求
     */

   @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
   @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带cookies信息来";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "这是一个需要携带cookies访问的get请求";
            }
        }
        return "你必须携带cookies信息来";
    }
    /**
     *开发一个需要参数才能访问的get请求
     *第一种的实现方式url：key = value & key=value
     * 我们来模拟一个模拟获取商品列表
     */
    //商品列表返回的是一个map
    //本小结的学习的重点是注解@RequestParam
    /*RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        //给商品列表添加参数
        myList.put("鞋",200);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        //直接return回去商品列表。
        return myList;
    }*/

    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies",httpMethod = "GET")
    public Map<String, Integer> getList(@RequestParam Integer start ,
                                        @RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();

        myList.put("鞋",200);
        myList.put("干脆面",1);
        myList.put("衬衫",300);

        return  myList;
    }
    /**
     * 第二个get的请求
     *访问路径上的区别
     * URl:Ip:port/get/with/param/10/20
     */

    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "这是第二个get请求商品列表的")
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();

        myList.put("鞋",200);
        myList.put("干脆面",1);
        myList.put("衬衫",300);

        return myList;
    }
}
