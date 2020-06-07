package ello.设计模式.适配器模式.对象适配器;

import ello.设计模式.适配器模式.类适配器.Target;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/26  09:24
 * @since 1.0.0
 */

public class M5DataLineAdapter implements Target {
    private Target target;

    public M5DataLineAdapter(Target target) {
        this.target = target;
    }

    @Override
    public void connection() {

    }
}
