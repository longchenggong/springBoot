package ello.设计模式.适配器模式.类适配器;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/26  09:20
 * @since 1.0.0
 */

public class M5DataLineAdapter extends M4DataLine implements Target {
    @Override
    public void connection() {
        System.out.println("插入type-c 转接头");
        super.connection();
    }


    public static void main(String[] args) {
        Target target = new M5DataLine();
        target.connection();

        Target adapter = new M5DataLineAdapter();
        adapter.connection();
    }
}
