/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ScheduledTaskService_计划任务
 * Author:   longchenggong
 * Date:     2020/1/21 11:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package Spring高级话题.多线程_异步任务.计划任务;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/21
 * @since 1.0.0
 */
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormate=new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 5000) //1。声明该方法是计划任务，fixedRate属性规定时间执行
    public void reportCurrentTime(){
        System.out.println("每隔五秒执行一次 "+ dateFormate.format(new Date()));
    }
    @Scheduled(cron = "0 50 11 ? * *")//2。cron属性可以指定固定时间。秒分时 日月年
    public void fixTimeExecution(){
        System.out.println("在指定时间 "+ dateFormate.format(new Date())+" 执行");
    }
}
