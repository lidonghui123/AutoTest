package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

/**
 * 这是一个入口启动应用程序
 * 这是优化完的class，代码如下
 */

@EnableScheduling//打开quartz定时器总开关
@SpringBootApplication //他是一个组合注解 由@Configuration，@EnableAutoConfiguration和@ComponentScan组成
@ComponentScan("com.course")
public class Application {
    //为了资源方面处理的更好
    private static ConfigurableApplicationContext context;

    public   static void main(String[] args) {
        Application.context = SpringApplication.run(Application.class, args);
    }
    //预摧毁的方法
    @PreDestroy
    public void close() {
        Application.context.close();
    }



}
