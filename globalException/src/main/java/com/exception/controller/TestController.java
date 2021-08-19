package com.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author cxks
 * @Date 2021/8/19 23:19
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/error1")
    public void error1(){
        int i = 9/0;
    }

    @RequestMapping("/error4")
    public void error4(){
        throw new RuntimeException("用户已存在");
    }
}
