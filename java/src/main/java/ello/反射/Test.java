/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Test
 * Author:   longchenggong
 * Date:     2019/10/13 13:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ello.反射;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2019/10/13
 * @since 1.0.0
 */
public class Test {


    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
    public Map getMap(Map<String,Integer> map){
        System.out.println("(******)");
        return null;
    }

    public static void Reflect_Test() throws Exception {
        Class clazz=Class.forName("com.ello.反射.Test");//获取Class对象
        System.out.println("包名："+clazz.getName()+"\n类名："+clazz.getSimpleName());

        Field[] f= clazz.getDeclaredFields();//获取属性;Declared获取含private修饰
        for (Field field : f) {
            System.out.println("属性："+field);
        }
        Method[] m= clazz.getDeclaredMethods();
        for (Method method : m) {
            System.out.println("方法："+method);
        }

        //泛型
        Method method= clazz.getMethod("getMap", Map.class);//获取具体方法的Method对象
        Type type[]= method.getGenericParameterTypes();//获取带泛型参数类型
        Type returnType=method.getGenericReturnType();//返回值泛型参数类型

        for (Type paramType : type) {
            System.out.println("泛型参数类型："+paramType);
            if(paramType instanceof ParameterizedType){
                Type[] genericTypes= ((ParameterizedType) paramType).getActualTypeArguments();//强转
                for (Type genericType : genericTypes) {
                    System.out.println("泛型类型："+genericType);
                }
            }
        }


    }

    public static void 泛型_Test() throws Exception {
        //泛型只存在与编译器，而反射是已经加载进内存中的类，此时的泛型已经被擦除，java提供的专门的类用来获取泛型

        Class clazz=Class.forName("com.ello.反射.Test");//获取Class对象

        Test test= (Test) clazz.newInstance();//调用无参构造器;如果没有无参构造器会抛错，框架中的javabean建议都加上无参构造器
        test.setName("uzi");
        System.out.println(test.getName());

        Method method=clazz.getDeclaredMethod("setName", String.class);
        method.invoke(test,"Jack");
        System.out.println(test.getName());
    }


    public static void main(String[] args) throws Exception {
//        Reflect_Test();
          泛型_Test();
    }
}
