package ello.设计模式.代理模式.静态代理_多数据源;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/3/27  17:24
 * @since 1.0.0
 */

public class OrderServicesStaticProxy implements IOrderService {


    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private IOrderService orderService;

    public OrderServicesStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int creatOrder(Order order) {
        before();
        Long time = order.getCreatTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理自动分配到【DB_"+dbRouter+"】数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.creatOrder(order);
        after();
        return 0;
    }

    private void before(){
        System.out.println("Proxy before method.");
    }
    private void after(){
        System.out.println("Proxy after method.");
    }

    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2019/10/23");
            order.setCreatTime(date.getTime());

            IOrderService orderService = new OrderServicesStaticProxy(new OrderService());
            orderService.creatOrder(order);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
