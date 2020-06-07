/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: wait和notify
 * Author:   longchenggong
 * Date:     2019/12/22 16:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package JUC.thread.并行程序;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2019/12/22
 * @since 1.0.0
 */
public class wait和notify {

    final static Object object=new Object();
    public static class T1 extends Thread{
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis()+":T1 start!");

                try {
                    System.out.println(System.currentTimeMillis()+":T1 wait for object");
                    object.wait();//进行等待，并释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+":T1 end!");
            }
        }
    }
    public static class T2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis()+":T2 satrt! notify one thread");
                object.notify();//唤醒T1，但T2还未释放锁（休眠2000），t1拿到锁才会继续执行（即T2 2s后释放锁）
                System.out.println(System.currentTimeMillis()+":T2 end!");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new T1();
        Thread t2=new T2();
        t1.start();
        t2.start();
    }
}
