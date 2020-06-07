package ello.设计模式.工厂.简单工厂;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/24  09:05
 * @since 1.0.0
 */



public class ShapeFactory {
    // 使用 getShape 方法获取形状类型的对象。  新增需要修改，不符合开闭原则，可以通过反射+配置文件类名这种方式使用较多
    public static Shape getShape(String shapeType){
        if (shapeType==null)return null;
        if (shapeType.equalsIgnoreCase("CIRCLE")) return new Circle();
        if (shapeType.equalsIgnoreCase("SQUARE")) return new Square();
        return null;
    }


    public static void main(String[] args) {
        Shape circle=ShapeFactory.getShape("circle");
        circle.draw();
    }
}
