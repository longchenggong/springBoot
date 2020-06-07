package ello.设计模式.工厂.简单工厂;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/24  09:02
 * @since 1.0.0
 */

public class Circle implements Shape {
    public Circle() {
        System.out.println("Circle");
    }

    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}
