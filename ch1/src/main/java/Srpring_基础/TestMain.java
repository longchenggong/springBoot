package Srpring_基础;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/3/25  11:04
 * @since 1.0.0
 */

public class TestMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Object o = context.getBean("person");
        System.out.println(ToStringBuilder.reflectionToString(o));
        System.out.println("~~:"+ToStringBuilder.reflectionToString(o,ToStringStyle.JSON_STYLE));
    }
}
