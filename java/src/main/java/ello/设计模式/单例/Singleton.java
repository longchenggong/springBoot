/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Singleton
 * Author:   longchenggong
 * Date:     2019/8/27 19:21
 * Description: 经典单例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ello.设计模式.单例;

/**
 * 〈经典单例〉 懒汉式：只有使用该对象的时候才来创建，线程不安全（多个线程同时执行getInstance）
 *
 * @author longchenggong
 * @create 2019/8/27
 * @since 1.0.0
 */
public class Singleton {
    //使用静态变量记录唯一实例
    private static Singleton singleton = null;
    //构造函数使用private修饰，确保系统中只能产生一个实例
    private Singleton() {}
    public static  Singleton getInstance(){
        if(singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {
        Singleton singleton1=Singleton.getInstance();
        Singleton singleton2=Singleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton1==singleton2);
    }
}
