package ello.设计模式.工厂.抽象工厂;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/24
 * @since 1.0.0
 */
public interface Factory {
    Gun produceGun();
    Bullet produceBullet();
}
