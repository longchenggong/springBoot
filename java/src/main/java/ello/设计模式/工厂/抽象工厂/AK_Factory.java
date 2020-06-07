package ello.设计模式.工厂.抽象工厂;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/24  16:35
 * @since 1.0.0
 *
 * 1.接口 枪、子弹
 * 2.接口实现类
 * 3.创建工厂
 * 4.创建具体工厂
 *
 *抽象工厂是生产一整套产品（多个），这些产品必须相互有依赖关系，而工厂方法是生产单一产品。
 * ak和m416两种枪，都有各自的子弹，生产ak的工厂可以顺便生产ak使用的子弹
 */

public class AK_Factory implements Factory {
    @Override
    public Gun produceGun() {
        return new Ak();
    }

    @Override
    public Bullet produceBullet() {
        return new AK_Bullet();
    }

    public static void main(String[] args) {
        AK_Factory ak_factory = new AK_Factory();
        Bullet bullet = ak_factory.produceBullet();
        Gun gun = ak_factory.produceGun();
        bullet.load();
        gun.shooting();

    }
}
