/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Main
 * Author:   longchenggong
 * Date:     2020/1/19 16:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.ch1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/19
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        //使用AnnotationConfigApplicationContext作为Spring容器，接受输入一个配置类作为参数
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UserFunctionService userFunctionService = context.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello("ss"));
        context.close();
    }
}
