package ello.设计模式.设计原则.依赖倒置原则;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/3/27  16:08
 * @since 1.0.0
 */

public class PythonCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("学习Python");
    }
}
