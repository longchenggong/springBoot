package com.ello.oa.common.utils.thread;

import com.ello.oa.common.utils.Threads;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @create 2020/5/7  16:43 author：longchenggong
 */
@Configuration
public class ThreadPoolConfig {

    // 核心线程池大小
    private int corePoolSize = 50;

    // 最大可创建的线程数
    private int maxPoolSize = 200;

    // 队列最大长度
    private int queueCapacity = 1000;

    // 线程池维护线程所允许的空闲时间
    private int keepAliveSeconds = 300;

    //定时任务
    @Bean(name = "scheduledExecutorService")
    protected ScheduledExecutorService scheduledExecutorService(){
        return new ScheduledThreadPoolExecutor(corePoolSize,new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(true).build()){
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                super.afterExecute(r, t);
                Threads.printException(r,t);
            }
        };
    }
}
