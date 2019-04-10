package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)//具体方法实现
                //添加apiInfo的方法，自己进行实现的
                .apiInfo(apiInfo())
                // 配置整个访问路径,默认根目
                .pathMapping("/")
                //然后选择这个目录。select
                .select()
                //加上PathSelectors的一个选择器,加上正则匹配,匹配访问的方法和路径
                .paths(PathSelectors.regex("/.*"))
                //然后整合一下文件，build
                .build();
    }
    private ApiInfo apiInfo() {
        //返回一个api，加上title，生成文档的时候title怎么显示
        return  new ApiInfoBuilder().title("我的接口文档")
                //添加一个联系人内容
                .contact(new Contact("libowen","","137676@qq.com"))
                //添加描述
                .description("这是我的swagger生成的接口文档")
                .version("1.0.0.0")
                .build();
    }
}
