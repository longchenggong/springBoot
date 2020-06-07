/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ConditionConifg
 * Author:   longchenggong
 * Date:     2020/1/21 15:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.Profile_不同环境不同配置.Spring4_条件注解;

import org.springframework.context.annotation.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/21
 * @since 1.0.0
 */
@Configuration
@ComponentScan("基础_Spring常用配置.Profile_不同环境不同配置.Spring4_条件注解")
public class ConditionConifg {
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(MacCondition.class) //1。通过conditional注解，符合mac条件则实例化Mac（即根据特定条件控制Bean的创建行为，如：只有某个Bean被创建才会创建另一个）
    public ListService macListService(){
        return new MacListService();
    }


    //-----------------------------
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConifg.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name")+" 系统下的输出："+listService.showListCmd());
    }
}

