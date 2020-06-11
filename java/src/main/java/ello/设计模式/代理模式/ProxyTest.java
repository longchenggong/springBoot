package ello.设计模式.代理模式;

import ello.设计模式.代理模式.动态代理.MySellHandler;
import ello.设计模式.代理模式.静态代理.TaoBao;
import ello.设计模式.代理模式.静态代理.UsbKingFactory;
import ello.设计模式.代理模式.静态代理.UsbSell;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @create 2020/6/9  00:32 author：longchenggong
 */

public class ProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       //静态代理
        System.out.println("===========静态代理============");
        TaoBao taoBao = new TaoBao();
        System.out.println(taoBao.sell(1));

        //----------------反射
        System.out.println("===========反射============");
        Method sell = TaoBao.class.getMethod("sell",int.class);//方法名称，方法参数类型
        System.out.println(sell.invoke(taoBao,2));

        //---动态代理
        System.out.println("===========动态代理=============");
        UsbSell factory= new UsbKingFactory();//1.创建目标类
        InvocationHandler handler= new MySellHandler(factory);//2。创建InvocationHandler对象
        //3。创建代理对象
        UsbSell proxy= (UsbSell) Proxy.newProxyInstance(factory.getClass().getClassLoader(),factory.getClass().getInterfaces(), handler);
        //4。通过代理对象执行方法
        System.out.println(proxy.sell(2));//执行的是handler中的invoke()
    }
}
