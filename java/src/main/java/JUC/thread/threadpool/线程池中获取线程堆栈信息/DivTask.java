/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DivTask
 * Author:   longchenggong
 * Date:     2019/12/29 17:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package JUC.thread.threadpool.线程池中获取线程堆栈信息;

import java.util.concurrent.SynchronousQueue;
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
public class DivTask implements Runnable {
    int a,b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re=a/b;
        System.out.println(re);
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pools=new ThreadPoolExecutor(0,Integer.MAX_VALUE,0L, TimeUnit.SECONDS,new SynchronousQueue<>());
        for (int i=0;i<5;i++){
              pools.submit(new DivTask(100,i)); //4条数据，无错误堆栈
        //    pools.execute(new DivTask(100,i));//有错误堆栈，并无任务具体信息
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        ThreadPoolExecutor poolMy=new TraceThreadPoolExecutor(0,Integer.MAX_VALUE,0L,TimeUnit.SECONDS,new SynchronousQueue<>());
        for (int i=0;i<5;i++){
            poolMy.execute(new DivTask(100,i));
        }
    }
}
