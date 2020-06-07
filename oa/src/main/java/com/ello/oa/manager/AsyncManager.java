package com.ello.oa.manager;

import com.ello.oa.common.utils.spring.SpringUtils;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @create 2020/5/7  15:48 author：longchenggong
 */

public class AsyncManager {
    //单例模式
    private AsyncManager() {}
    private static AsyncManager instance=new AsyncManager();
    public static AsyncManager getInstance(){
        return instance;
    }
    /**
     * 操作延迟10毫秒
     */
    private final int OPERATE_DELAY_TIME = 10;
    //异步线程调度
    private ScheduledExecutorService executor= SpringUtils.getBean("scheduledExecutorService");

    //执行任务
    public void execute(TimerTask task){
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

    public void shutdown(){}
}
