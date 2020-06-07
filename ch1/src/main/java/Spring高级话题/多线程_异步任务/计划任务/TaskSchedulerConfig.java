/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TaskSchedulerConfig
 * Author:   longchenggong
 * Date:     2020/1/21 11:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package Spring高级话题.多线程_异步任务.计划任务;

import Spring高级话题.多线程_异步任务.TaskExecutorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/21
 * @since 1.0.0
 */
@Configuration
@ComponentScan("Spring高级话题.多线程_异步任务.计划任务")
@EnableScheduling //1。通过注解开启对计划任务的支持
public class TaskSchedulerConfig {
    //--------------------------------------
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

    }
}
