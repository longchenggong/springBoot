package ello.设计模式.适配器模式.类适配器;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/26  09:19
 * @since 1.0.0
 */

public class M5DataLine implements Target {
    @Override
    public void connection() {
        System.out.println("使用小米5连接线。。。");
    }
}
