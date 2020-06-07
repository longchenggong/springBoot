package JUC.thread.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/2/27  16:13
 * @since 1.0.0
 */

public class ThreadPoolExecutor模版 {


    public static void main(String[] args) {
        final String threadName = "ello-test-Thread" ;
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(
                10, 10, 0L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue <Runnable>(200),
                new ThreadFactory() {
                    final AtomicInteger threadNumber = new AtomicInteger(1);
                    ThreadGroup tg = new ThreadGroup(threadName);

                    public Thread newThread(Runnable r) {
                        return new Thread(tg, r, threadName + threadNumber.getAndIncrement());
                    }
                }, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(executor.getCorePoolSize() + " " + executor.getQueue().size());
                Thread t = new Thread(r);
                t.start();
            }
        });

        QueryThread qt = new QueryThread("idddd");
        String thdName = "Pool-Query-Thread" ;
        new Thread(qt, thdName).start();

    }
}

class QueryThread implements Runnable {
    private String id;

    public QueryThread(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("执行任务：");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
