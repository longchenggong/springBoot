package com.ello.oa;

import org.junit.Test;

import java.util.*;

/**
 * @create 2020/5/26  18:02 author：longchenggong
 */

public class MyTest {

    @Test
    public void testSystemProperty(){


        Properties properties = System.getProperties();
        Enumeration <?> enumeration = properties.propertyNames();

        System.out.println(List.class.isAssignableFrom(ArrayList.class));
        while (enumeration.hasMoreElements()){
            Object o = enumeration.nextElement();
           // System.out.println(o +" "+properties.get(o));
        }


        Collection c = new ArrayList();
        c.add(1);
        c.add(1);
        c.add(1);




        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            Object o=iterator.next();
            System.out.println(o);

        }


        System.out.println("===========");


        List l = new LinkedList();
        System.out.println(10>>2); //右移 除于2n
    }
}
