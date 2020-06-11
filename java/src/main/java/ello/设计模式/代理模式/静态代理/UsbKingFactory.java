package ello.设计模式.代理模式.静态代理;

/**
 * @create 2020/6/9  00:19 author：longchenggong
 *
 * 金士顿厂家,不接受用户单独购买
 */
public class UsbKingFactory implements UsbSell {
    @Override
    public float sell(int amount) {
        //一个u盘85
        return 85.0f*amount;
    }
}
