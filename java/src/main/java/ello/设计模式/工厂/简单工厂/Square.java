package ello.设计模式.工厂.简单工厂;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/24  09:04
 * @since 1.0.0
 */

public class Square implements Shape {
    public Square() {
        System.out.println("Square");
    }

    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}
