package ello.集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/15  09:28
 * @since 1.0.0
 */

public class hashMap_Test {

    public static void main(String[] args) throws InterruptedException {
        //多线程情况下会导致数据丢失
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //16384
        Map hashMap = new HashMap(2 ^ 14);

       // Map hashMap = Collections.synchronizedMap(new HashMap(2 ^ 14));
       CountDownLatch countDownLatch= new CountDownLatch(1000);
        for (int i = 0; i < 10000; i++) {
            int finalI=i;
            executorService.submit(()->{
                countDownLatch.countDown();
                hashMap.put(finalI, finalI);
                System.out.println(Thread.currentThread().getName()+":map 数量大小为："+hashMap.size());
            });
        }
        countDownLatch.await();
        //实际输出大小小于10000
        System.out.println(hashMap.size());
    }
}
