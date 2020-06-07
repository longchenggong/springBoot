package 关键字;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/1/30  16:10
 * @since 1.0.0
 */

public class test {
    /**
     final 变量：a.基本数据类型一旦初始化后便不能更改 b.引用类型，初始化后不能再让其指向另一个对象
           方法：方法不能被重写
            类：类不能别继承。final类的所有类成员方法都被隐式指定为final方法
     *
     */
    /**
     static 1.修饰成员变量、成员方法：被类中所有对象共享，存于方法区
            2.静态代码块：定义在类中方法外（静态代码块->非静态代码块->构造方法），只执行一次
            3.静态内部类（修饰类只能修饰静态内部类）：不依赖外围类的创建；不能使用任何外围类的非static成员变量和方法
            4.静态导包（导入类中的静态资源）：import static，不需要类名调用，直接使用静态成员和成员方法
     */
    /**
     this

     */


    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date date = new Date();
        System.out.println(dateFormat.format(date));


        ResourceBundle bundle = ResourceBundle.getBundle("");

        System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
    }

}
