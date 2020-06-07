/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TaskExecutorConfig
 * Author:   longchenggong
 * Date:     2020/1/21 10:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package Spring高级话题.多线程_异步任务;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/21
 * @since 1.0.0
 *
 */
@Configuration
@ComponentScan("Spring高级话题.多线程_异步任务")
@EnableAsync //1。@EnableAsync注解开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer {// 2。实现AsyncConfigurer重写getAsyncExecutor并返回一个ThreadPoolTaskExecutor，这样就获取到一个基于线程出的TaskExecutor
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();

        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

//---------------------------------------------------------------------------------
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskServiceask = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            asyncTaskServiceask.executeAsyncTask(i);
            asyncTaskServiceask.executeAsyncTaskPlus(i);

        }

    }
}
