/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ProfileConfig
 * Author:   longchenggong
 * Date:     2020/1/20 14:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.Profile_不同环境不同配置;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * 在不同环境使用不同配置（数据库等）
 *
 * @author longchenggong
 * @create 2020/1/20
 * @since 1.0.0
 */
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DemoBean devDemoBean(){
        return new DemoBean("from development profile");
    }

    @Bean
    @Profile("prod")
    public DemoBean prodDemoBean(){
        return new DemoBean("from production profile");
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");//1.将活动的Profile设置为dev
        context.register(ProfileConfig.class);//2。注册Bean配置类
        context.refresh();//3。刷新容器

        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        context.close();
    }
}
