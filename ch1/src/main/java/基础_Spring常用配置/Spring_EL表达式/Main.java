/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Main
 * Author:   longchenggong
 * Date:     2020/1/20 09:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.Spring_EL表达式;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/20
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig resourceService = context.getBean(ELConfig.class);
        resourceService.outputResource();
        context.close();
    }
}
