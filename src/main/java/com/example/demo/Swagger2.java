package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author anonymity
 * @create 2019-01-07 16:23
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * swagger2的配置文件，这里这一配置swagger的一些基本内容，比如扫描包等等
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.rest"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 api 文档的详细信息函数，注意这里的注解引用的是哪个
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Srping Boot 测试使用 Swagger2 构建 RESTFUL API")
                .contact(new Contact("luotaishuai", "https://www.github.com/luotaishuai", ""))
                .version("0.1")
                .description("API 描述")
                .build();
    }
}
