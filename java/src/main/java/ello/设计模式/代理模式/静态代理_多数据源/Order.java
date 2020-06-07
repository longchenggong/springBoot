package ello.设计模式.代理模式.静态代理_多数据源;

/**
 * @author longchenggong
 * @description 订单类
 * @create 2020/3/27  16:51
 * @since 1.0.0
 */

public class Order {
    private String id;
    private Object orderInfo;
    private Long creatTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Long getCreatTime() {
        return creatTime;
    }

    /**
     *
     * @param creatTime  根据订单创建时间自动按年进行分库
     */
    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }
}
