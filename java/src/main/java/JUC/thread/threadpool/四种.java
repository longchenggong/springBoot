package JUC.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/29  16:16
 * @since 1.0.0
 */

public class 四种 {
    public static void 可缓存线程池_newCachedThreadPool(){
        //new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
        //             new SynchronousQueue<Runnable>()) 核心线程数0，最大max，队列 SynchronousQueue
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();//可缓存线程池

        Executors.newFixedThreadPool(1);//定长线程池，最大线程=核心线程 队列：LinkedBlockingQueue
        Executors.newSingleThreadExecutor();//单线程线程池
        Executors.newScheduledThreadPool(2);//支持定时的定长线程池
    }


}
