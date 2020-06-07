/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DemoConfig
 * Author:   longchenggong
 * Date:     2020/1/21 15:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package Spring高级话题.组合注解;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/21
 * @since 1.0.0
 */
@WiselyConfiguration_组合注解("Spring高级话题.组合注解")//1。@WiselyConfiguration组合注解替代 @Configuration和@ComponentScan
public class DemoConfig {

    //--------------------------------------
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputResult();
        context.close();
    }

}
