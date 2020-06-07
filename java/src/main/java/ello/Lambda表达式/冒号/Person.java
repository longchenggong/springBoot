package ello.Lambda表达式.冒号;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/4/20  16:06
 * @since 1.0.0
 */

public class Person {
    String firstName;
    String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {}

    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}
