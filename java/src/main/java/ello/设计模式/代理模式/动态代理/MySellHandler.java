package ello.设计模式.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @create 2020/6/9  00:39 author：longchenggong
 */
//必须实现InvocationHandler 接口，完成代理类功能（1。调用目标方法 2。实现功能增强）
public class MySellHandler implements InvocationHandler {

    private Object target=null;
    //动态代理：目标对象是活动的，动态传入即是代理谁
    public MySellHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.执行目标方法
        Object res = method.invoke(target, args);

        //2.功能增强
        if (res != null) {
             res= (float) res+35;
        }
        return res;
    }
}
