package ello.设计模式.工厂.抽象工厂;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/24  16:23
 * @since 1.0.0
 */

public class AK_Bullet implements Bullet {
    @Override
    public void load() {
        System.out.println("load bullets with AK");
    }
}
