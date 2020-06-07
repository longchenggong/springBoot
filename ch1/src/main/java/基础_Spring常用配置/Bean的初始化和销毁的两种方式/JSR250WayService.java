/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: JSR250WayService
 * Author:   longchenggong
 * Date:     2020/1/20 10:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.Bean的初始化和销毁的两种方式;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * 注解方式(需增加JSR250支持)
 *
 * @author longchenggong
 * @create 2020/1/20
 * @since 1.0.0
 */
public class JSR250WayService {
    @PostConstruct //构造函数执行完之后执行
    public void init(){
        System.out.println("jsr250-init-method");
    }

    public JSR250WayService() {
        System.out.println("初始化构造函数-JSR250WayService");
    }
    @PreDestroy //Bean销毁之前执行
    public void destroy(){
        System.out.println("jsr250-destroy-method");
    }
}
