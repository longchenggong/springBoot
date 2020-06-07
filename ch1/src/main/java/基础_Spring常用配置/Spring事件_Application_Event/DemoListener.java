/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DemoListener
 * Author:   longchenggong
 * Date:     2020/1/20 14:47
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.Spring事件_Application_Event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/20
 * @since 1.0.0
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {//1。实现接口，并指定监听事件类型

    public void onApplicationEvent(DemoEvent demoEvent) {//2。使用onApplicationEvent方法对消息进行处理
        String msg=demoEvent.getMsg();
        System.out.println("我（bean-demoListener）接收到类 bean-demoPublisher发布的消息："+msg);
    }
}
