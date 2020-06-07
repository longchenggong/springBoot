/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PrePostConfig
 * Author:   longchenggong
 * Date:     2020/1/20 10:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.Bean的初始化和销毁的两种方式;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/20
 * @since 1.0.0
 */
@Configuration
@ComponentScan("基础_Spring常用配置.Bean的初始化和销毁的两种方式")
public class PrePostConfig {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }
    @Bean
    JSR250WayService jsr250WayService(){
        return new  JSR250WayService();
    }
}
