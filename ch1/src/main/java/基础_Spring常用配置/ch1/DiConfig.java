/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DiConfig
 * Author:   longchenggong
 * Date:     2020/1/19 16:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.ch1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @Configuration 声明当前类是一个配置类（意味着类中有一个或多个@bean）
 * 配置类 @ComponentScan自动扫描包下所有有使用@Service、@Component、@Repository、和@Controller类，并注册为Bean
 *
 * @author longchenggong
 * @create 2020/1/19
 * @since 1.0.0
 */
@Configuration
@ComponentScan("基础_Spring常用配置.ch1")
public class DiConfig {
}
