/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: WiselyConfiguration
 * Author:   longchenggong
 * Date:     2020/1/21 15:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package Spring高级话题.组合注解;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/21
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration  //1。元注解（注解的注解）
@ComponentScan  //1。元注解（注解的注解）
public @interface WiselyConfiguration_组合注解 {
    String[] value() default {};
}
