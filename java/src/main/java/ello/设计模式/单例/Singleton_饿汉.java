/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Singleton_饿汉
 * Author:   longchenggong
 * Date:     2019/8/27 19:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ello.设计模式.单例;

/**
 * 饿汉模式
 * 类加载到内存后，实例化一个单例，JVM保证线程安全（简单试用，推荐使用）
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 *
 * @author longchenggong
 * @create 2019/8/27
 * @since 1.0.0
 */
public class Singleton_饿汉 {
    //使用静态变量记录唯一实例
    private static final Singleton_饿汉 singleton=new Singleton_饿汉();
    //无法通过new创建
    private Singleton_饿汉() { }

    public static Singleton_饿汉 getInstance(){
        return  singleton;
    }
}
