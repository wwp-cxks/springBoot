package com.async.controller;

import com.async.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author cxks
 * @Date 2021/8/19 22:57
 */
@Slf4j
@RestController
public class TestController {
    @Autowired
    private ScoreService service;

    @RequestMapping("/sync")
    public String creatUser(){
        log.info("-----注册用户-----");
        service.addScore();
        return "ok";
    }

    @RequestMapping("/sync2")
    public String creatUser2(){
        log.info("-----注册用户2-----");
        service.addScore2();
        return "ok";
    }
}
