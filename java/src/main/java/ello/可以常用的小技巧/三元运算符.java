package ello.可以常用的小技巧;

import java.util.HashMap;
import java.util.Map;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/28  08:53
 * @since 1.0.0
 */

public class 三元运算符 {
    public static void main(String[] args) {
        Map<String,Boolean> map=new HashMap <String,Boolean>();
        Boolean a=(map!=null ? map.get("test"):false);
        System.out.println(a);
        Boolean b=(map!=null ? map.get("test"):Boolean.FALSE);
        System.out.println(b);
    }
}
