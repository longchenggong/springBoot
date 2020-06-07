/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DemoEvent
 * Author:   longchenggong
 * Date:     2020/1/20 14:36
 * Description: 自定义事件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.Spring事件_Application_Event;

import org.springframework.context.ApplicationEvent;

/**
 * 1。自定义事件（继承 ApplicationEvent）
 * 2。定义事件监听器（实现 ApplicationListener）
 * 3。使用容器发布事件
 *
 * @author longchenggong
 * @create 2020/1/20
 * @since 1.0.0
 */
public class DemoEvent extends ApplicationEvent {

    private static final long serialVersionUID=1L;
    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
