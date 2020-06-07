package ello.设计模式.工厂.抽象工厂;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/24  16:24
 * @since 1.0.0
 */

public class M416_Bullet implements Bullet {
    @Override
    public void load() {
        System.out.println("load bullets with M416");
    }
}
