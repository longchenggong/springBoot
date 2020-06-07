package com.ello.oa.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @create 2020/5/7  16:49 author：longchenggong
 *
 * 线程工具类
 */

public class Threads {
    private static final Logger logger = LoggerFactory.getLogger(Threads.class);
    public void sleep(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 停止线程池
     * 先使用shutdown，停止接收任务并完成已接收任务
     * 如过超时，则调用shutdownNow，取消队列中的任务，并中断阻塞函数
     * 仍超时，强制退出。
     * catch对shutdown时线程本身调用中断处理。
     *
     * @param pool
     */
    public static void shutdownAndAwaitTermination(ExecutorService pool){
        if(pool!=null&&!pool.isShutdown()){
            pool.shutdown();
            try {
                if(!pool.awaitTermination(120, TimeUnit.MILLISECONDS)){
                    pool.shutdownNow();
                    if (!pool.awaitTermination(120, TimeUnit.SECONDS))
                    {
                        logger.info("Pool did not terminate");
                    }
                }
            } catch (InterruptedException e) {
                pool.shutdownNow();
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    //打印线程异常信息
    public static void printException(Runnable r,Throwable t){
            if(t==null && r instanceof Future<?>){
                Future<?> future= (Future <?>) r;
                if (future.isDone()) {
                    try {
                        future.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    } catch (ExecutionException e) {
                        t=e.getCause();
                    }
                }
            }
            if(t!=null){
                logger.error(t.getMessage(), t);
            }
    }
}
