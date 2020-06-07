package ello.Lambda表达式.冒号;

import java.util.*;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/20
 * @since 1.0.0
 */
public interface PersonFactory<p extends Person> {
    p create(String firstName,String lastName);

    public static void main(String[] args) {
        //通过::关键字传递方法或构造函数的引用
        PersonFactory<Person> personFactory=Person::new;

        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person);

        Queue<String> namesQueue = new ArrayDeque<>(Arrays.asList("Larry", "Steve", "James"));
        namesQueue.forEach(System.out::println);

        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1, "Larry");
        namesMap.put(2, "Steve");
        namesMap.put(3, "James");
        namesMap.forEach((key, value) -> System.out.println(key + " " + value));
        namesMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
