package com.example.demo.rest;

import com.example.demo.entity.Breed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author anonymity
 * @create 2019-01-07 16:27
 **/
@Slf4j
@RestController
@Api(tags = "Test Swagger2 API")
@RequestMapping("/v1")
public class SwaggerController {

    @ApiOperation(value = "测试GET请求", notes = "无参数")
    @GetMapping("/create")
    public String createDog() {
        return "金毛";
    }

    @ApiOperation(value = "测试GET请求", notes = "有参数")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "name", value = "品种", dataType = "String", paramType = "path", required = true, defaultValue = "土狗"),
            @ApiImplicitParam(name = "age", value = "年龄", dataType = "int", paramType = "path", required = true, defaultValue = "10")
    })
    @GetMapping("/create/{name}/{age}")
    public String createDog(@PathVariable String name, @PathVariable Integer age) {
        return "name=" + name + ", age=" + age;
    }

    @ApiOperation(value = "测试POST请求", notes = "BODY方式")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "breed", value = "培育下一代", dataType = "Breed", required = true)
    })
    @PostMapping("/breed")
    public String breed(@RequestBody Breed breed) {
        return breed.getA() + "+" + breed.getB() + "=" + "猪";
    }

}
