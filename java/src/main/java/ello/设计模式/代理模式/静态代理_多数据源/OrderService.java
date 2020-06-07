package ello.设计模式.代理模式.静态代理_多数据源;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/3/27  16:58
 * @since 1.0.0
 */

public class OrderService implements IOrderService {

    private OrderDao orderDao;

    public OrderService() {
        orderDao=new OrderDao();
    }

    @Override
    public int creatOrder(Order order) {
        System.out.println("OrderService调用Orderdao创建订单");
        return orderDao.insert(order);
    }
}
