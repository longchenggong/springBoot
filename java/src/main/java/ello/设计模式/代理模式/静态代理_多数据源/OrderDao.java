package ello.设计模式.代理模式.静态代理_多数据源;

/**
 * @author longchenggong
 * @description 持久层
 * @create 2020/3/27  16:54
 * @since 1.0.0
 */

public class OrderDao {
    int insert(Order order){
        System.out.println("OderaDao创建Order订单成功！");
        return 1;
    }
}
