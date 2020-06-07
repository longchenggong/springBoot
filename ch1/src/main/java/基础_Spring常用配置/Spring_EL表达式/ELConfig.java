/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ELConfig
 * Author:   longchenggong
 * Date:     2020/1/20 09:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.Spring_EL表达式;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *增加common-io 简化相关操作
 * @author longchenggong
 * @create 2020/1/20
 * @since 1.0.0
 */
@Configuration
@ComponentScan("基础_Spring常用配置.Spring_EL表达式")
@PropertySource("classpath:Spring_EL/test.properties")//文件编译要放在resources下才行？
public class ELConfig {
    @Value("I Love You")//1。注入普通字符串
    private String normal;

    @Value("#{systemProperties['os.name']}")//2。操作系统属性
    private String osName;

    @Value("#{T(Math).random()*100.0}")//3。表达式结果
    private double randomNumber;

    @Value("#{demoService.another}")//4。其他Bean属性
    private String fromAnother;

    @Value("classpath:Spring_EL/test.properties")//5。文件资源
    private Resource testFile;

    @Value("http://www.baidu.com")//6。注入网址资源
    private Resource testUrl;

    @Value("${book.name}") //7。注入配置文件 1。使用@PropertySource指定文件地址 2。配置PropertySourcesPlaceholderConfigurer的Bean 3。使用的是$而不是#
    private String bookName;

    @Autowired //7 注入Properties还可以从Environment中获取
    private Environment environment;
    @Bean  //7
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        System.out.println(normal);
        System.out.println(osName);
        System.out.println(randomNumber);
        System.out.println(fromAnother);

        try {
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
