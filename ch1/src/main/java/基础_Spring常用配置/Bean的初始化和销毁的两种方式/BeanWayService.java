/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: yy
 * Author:   longchenggong
 * Date:     2020/1/20 10:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.Bean的初始化和销毁的两种方式;

/**
 * Java配置方式：initMethod和destroyMethod相当于xml配置大的init-method和destory-method
 *
 * @author longchenggong
 * @create 2020/1/20
 * @since 1.0.0
 */
public class BeanWayService {
    public void init(){
        System.out.println("@Bean-init-method");
    }

    public BeanWayService() {
        System.out.println("初始化构造函数-BeanWayService");
    }
    public void destroy(){
        System.out.println("@Bean-destroy-method");
    }
}
