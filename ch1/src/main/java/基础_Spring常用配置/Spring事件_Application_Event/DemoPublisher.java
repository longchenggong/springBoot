/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DemoPublisher
 * Author:   longchenggong
 * Date:     2020/1/20 14:58
 * Description: 发布类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.Spring事件_Application_Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈发布类〉
 *
 * @author longchenggong
 * @create 2020/1/20
 * @since 1.0.0
 */
@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;//1。注入ApplicationContext用来发布事件

    public void publish(String msg){//2。publish方法发布
        applicationContext.publishEvent(new DemoEvent(this,msg));
    }
}

