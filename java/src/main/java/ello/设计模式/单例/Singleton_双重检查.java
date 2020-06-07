/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Singleton_双重检查
 * Author:   longchenggong
 * Date:     2019/8/27 19:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ello.设计模式.单例;

/**
 * 先判断instance是否非实例化，没有则将实例化语句加锁，当instance真正为null时才去实例化
 *
 * @author longchenggong
 * @create 2019/8/27
 * @since 1.0.0
 */
public class Singleton_双重检查 {
    //使用静态变量记录唯一实例
    //volatile可以确保当singleton被初始化后，多线程才可以正确处理
    //被volatile修饰当变量当值，将不会被本地线程缓存
    //对该变量读写都是直接操作共享内存，确保多个线程能正确对处理该变量
    private static volatile Singleton_双重检查 singleton;

    private Singleton_双重检查() { }

    public static Singleton_双重检查 getInstance(){
        //如果实例不存在，则进入同步区
        if(singleton==null){//双重检查机制
            //只有第一次才会彻底执行下面代码
            synchronized (Singleton_双重检查.class){//同步锁
                if(singleton==null){//双重检查机制
                    singleton=new Singleton_双重检查();
                }
            }
        }
        return singleton;
    }
}
