package ello.设计模式.工厂.工厂方法模式_项目中最多;

import ello.设计模式.工厂.简单工厂.Circle;
import ello.设计模式.工厂.简单工厂.Shape;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/24  10:30
 * @since 1.0.0
 */

public class CircleFactory implements Factory {
    @Override
    public Shape getShape() {
        return new Circle();
    }


    //工厂方法是简单工厂的进一步深化。每个对象都有一个与之对应的工厂。
    //客户端不需要知道所需要的对象类，只要知道对应的工厂即可。
    //由子类指定创建哪个对象，利用面向对象的多态性和里氏
    public static void main(String[] args) {
        Factory circleFactory = new CircleFactory();
        Shape circle = circleFactory.getShape();
        circle.draw();
    }
}
