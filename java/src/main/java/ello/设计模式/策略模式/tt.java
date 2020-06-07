package ello.设计模式.策略模式;

import java.util.Arrays;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/3/3  15:18
 * @since 1.0.0
 *
 * 定义一系列算法，把他们一个个封装起来，并且使他们可相互替换。本模式可使算法独立于使用它到客户而变化
 * 策略模式：Strategy
 */

public class tt {

    public static void main(String[] args) {
        //排序忽略大小写
        String[] array={"apple","Pear","Banana","orange"};
        Arrays.sort(array,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(array));
    }
}
