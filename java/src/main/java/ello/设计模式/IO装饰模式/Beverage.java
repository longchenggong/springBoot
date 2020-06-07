/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Beverage
 * Author:   longchenggong
 * Date:     2019/9/25 13:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ello.设计模式.IO装饰模式;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2019/9/25
 * @since 1.0.0
 */
abstract class Beverage {
    private String description;

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    abstract double cost();
}

class Decaf extends Beverage{

    public Decaf() {
        super("无咖啡因咖啡");
    }

    @Override
    double cost() {
        return 1;
    }
}

abstract class Condiment extends Beverage{
    protected Beverage beverage;//进行关联
    public Condiment(Beverage beverage) {
        super("调味");
        this.beverage=beverage;
    }
}

class Milk extends Condiment{

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    double cost() {
        return beverage.cost()+ 0.1;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" 牛奶";
    }
}

class Mocha extends Condiment{

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    double cost() {
        return beverage.cost()+ 0.2;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" 摩卡";
    }
}
class AppTest{
    public static void main(String[] args) {
        Beverage beverage=new Decaf();

        Beverage b1=new Milk(beverage);
        Beverage b2=new Mocha(b1);

        System.out.println(b2.getDescription()+":"+b2.cost());
    }
}
