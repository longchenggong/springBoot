package ello.设计模式.代理模式.静态代理;

/**
 * @create 2020/6/9  00:22 author：longchenggong
 */
//淘宝是一个商家，代理金士顿u盘销售
public class TaoBao implements UsbSell {

    private UsbKingFactory usbKingFactory=new UsbKingFactory();

    @Override
    public float sell(int amount) {
       float price= usbKingFactory.sell(amount);
       price+=25;//商家加价;增强功能
        return price;
    }
}
