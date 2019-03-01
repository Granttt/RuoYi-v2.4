package com.my.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: 高希阳
 * @Date: 2019/3/1 11:36
 * @Description:
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloWorld {

    @RequestMapping("world")
    public String helloTest(){
        return "success";
    }

}
