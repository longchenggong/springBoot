/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TraceThreadPoolExecutor
 * Author:   longchenggong
 * Date:     2019/12/29 17:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package JUC.thread.threadpool.线程池中获取线程堆栈信息;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2019/12/29
 * @since 1.0.0
 */
public class TraceThreadPoolExecutor extends ThreadPoolExecutor {
    public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    //重写
    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command,clientTrace(),Thread.currentThread().getName()));
    }
    //重写
    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task,clientTrace(),Thread.currentThread().getName()));
    }


    private Exception clientTrace(){
        return new Exception("Client stack trace 错误");
    }

    /**
     *将传入的Runnable任务进行一层包装，使之能处理异常信息
     * @param task
     * @param clientStack 异常参数，保存这提交任务线程的堆栈信息，发送异常时，这个异常会被打印
     * @param clientThreadName
     * @return
     */
    private Runnable wrap(final Runnable task,final Exception clientStack,String clientThreadName){
        return  new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e) {
                   clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }
}
