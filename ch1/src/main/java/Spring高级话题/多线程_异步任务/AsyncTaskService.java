/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AsyncTaskService
 * Author:   longchenggong
 * Date:     2020/1/21 11:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package Spring高级话题.多线程_异步任务;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/21
 * @since 1.0.0
 */
@Service
@Async //1。注解表明该方法是异步方法，类上表明类所有方法都是异步。并自动注入ThreadPoolTaskExecutor作为TaskExecutor
public class AsyncTaskService {
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务："+i);
    }
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1:" +(i+1));
    }
}
