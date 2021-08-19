package com.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author cxks
 * @Date 2021/8/19 22:39
 */
@Configuration
@EnableAsync
public class SyncConfiguration {
    @Bean(name = "scorePoolTaskExecutor")
    public ThreadPoolTaskExecutor getScorePoolTaskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程数
        taskExecutor.setCorePoolSize(10);
        // 线程池维护线程的最大数量，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        taskExecutor.setMaxPoolSize(100);
        // 缓存队列
        taskExecutor.setQueueCapacity(50);
        // 允许的空闲时间，当超过了核心线程之外的线程在空闲时间到达之后会被销毁
        taskExecutor.setKeepAliveSeconds(200);
        // 异步方法内部线程名称
        taskExecutor.setThreadNamePrefix("score-");
        /**
         * 当线程的任务缓存队列已满且线程池中的线程数量达到maxPoolSize,如果还有任务到来就会采取任务拒绝策略
         * 通常有一下四种策略
         * ThreadPoolExecutor.AbortPolicy; 丢弃任务并抛出异常RejectExecutionException异常，
         * ThreadPoolExecutor.DiscardPolicy; 也是丢弃任务，但是不抛出异常
         * ThreadPoolExecutor.DiscardOldestPolicy; 丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
         * ThreadPoolExecutor.CallerRunsPolicy; 尝试添加当前的任务，自动重复调用execute()方法，直到成功
         */
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }
}
