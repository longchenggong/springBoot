package ello.设计模式.代理模式.静态代理;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/3/27  16:45
 * @since 1.0.0
 */

public class Son implements Person {
    @Override
    public void findLove() {
        System.out.println("儿子要求：");
    }
}
