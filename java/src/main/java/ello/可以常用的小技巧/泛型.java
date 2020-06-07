package ello.可以常用的小技巧;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/14  15:53
 * @since 1.0.0
 */

public class 泛型 {
    //通配符：？-不确定的java类型  上界通配符< ? extends E>  下界 <? super E>
    //      T(type) -具体java类型
    //      k v -健值
    //      E(element)
//？和 T 都表示不确定的类型，区别在于我们可以对 T 进行操作，但是对 ？ 不行
// 使用 & 符号设定多重边界

    //自己设计一个泛型的获取数组最小值的函数.并且这个方法只能接受Number的子类并且实现了Comparable接口
    //注意：Number并没有实现Comparable
    //T exends Number 以及 T extends Comparable<? super T>。
    // 前面一部分表示类型参数T必须是Number的子类，后面一部分表示T或者T的父类实现了Comparable接口
    private static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0) return null;
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0) min = values[i];
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(min(new Integer[]{1, 2, 3}));
        System.out.println(min(new Double[]{1.2, 2.2, -1d}));

    }
}
