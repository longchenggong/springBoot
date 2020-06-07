package ello.设计模式.工厂.简单工厂;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/24  09:38
 * @since 1.0.0
 */

public class ShapeFactory2 {
    public static Object getClass(Class<?extends Shape> clazz){
        Object obj=null;

        try {
            obj=Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
        Circle circle = (Circle) ShapeFactory2.getClass(Circle.class);
        circle.draw();

    }
}
