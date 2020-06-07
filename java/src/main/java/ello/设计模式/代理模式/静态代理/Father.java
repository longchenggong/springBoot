package ello.设计模式.代理模式.静态代理;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/3/27  16:46
 * @since 1.0.0
 */

public class Father {
    private Son son;

    public Father(Son son) {
        this.son = son;
    }
    void findLove(){
        System.out.println("父亲帮物色");
        this.son.findLove();
        System.out.println("双方同意");
    }


    public static void main(String[] args) {
        //只能传入son
        Father father=new Father(new Son());
        father.findLove();
    }
}
