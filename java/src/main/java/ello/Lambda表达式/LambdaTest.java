package ello.Lambda表达式;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Operation;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/3/20  14:11
 * @since 1.0.0
 */

public class LambdaTest {

    public static Integer operation(Integer num,MyLambdaInterface m){
        return m.getValue(num);
    }

    public static void checkAndExecute(List<Student> studentList, Predicate<Student> predicate, Consumer<Student> consumer){
        for (Student student : studentList) {
            if (predicate.test(student)) consumer.accept(student);
        }
    }
    public static void main(String[] args) {

       Integer a= operation(200,x->x+x);
        System.out.println(a);
        new Thread(() -> System.out.println("hello lambda")).start();



        new  Thread(()-> System.out.println("hello lambda")).start();


    }
}
