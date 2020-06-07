package ello.集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/26  09:36
 * @since 1.0.0
 */

public class List_Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList <>();
        list.add("1");
        list.add("5");
        list.add("2");
        for (Iterator<String> it=list.iterator();it.hasNext();) {
            System.out.println(it.next());
        }

        for (int i = 0; i <list.size() ;i++) {
            System.out.println(list.get(i));
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
