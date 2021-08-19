package com.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author cxks
 * @Date 2021/8/19 22:54
 */
@Service
@Slf4j
public class ScoreService {
    
    @Async
    public void addScore(){
        // TODO 模拟睡5秒，用于积分赠送处理
        try{
            Thread.sleep(1000*5);
            log.info("----s---处理积分-----");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Async("scorePoolTaskExecutor")
    public void addScore2(){
        // TODO 模拟睡5秒，用于积分赠送处理
        try{
            Thread.sleep(1000*5);
            log.info("----s---处理积分-----");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
