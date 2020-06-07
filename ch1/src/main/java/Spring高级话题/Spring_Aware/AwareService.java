package Spring高级话题.Spring_Aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * Spring的依赖注入最大亮点是你所有的Bean对Spring容器的存在是没有意识的。即你可以将你的容器替换，如：Google Guice，这时Bean之间的耦合度很低
 * 实际中，不可避免要用到Spring容器本身的功能资源，你的Bean必须意识到Spring容器的存在才能调用资源，这就是所有的Spring Aware。这时Bean将会和Spring框架耦合
 * Spring提供的Aware接口：
 * BeanNameAware            获得到容器中Bean的名称
 * BeanFactoryAware         获得当前bean factory，可调用容器服务
 * ApplicationContextAware* 当前application context（可获得Spring容器的所有服务（集成了Messagesource。。。））
 * MessageSourceAware       获得message source
 * ApplicationEventPublisherAware 应用事件发布器
 * ResourceLoaderAware      获得资源加载器，可获取外部资源
 *
 * @author longchenggong
 * @create 2020/1/20
 * @since 1.0.0
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {//1。实现接口，获得Bean名称和资源加载的服务

    private String beanName;
    private ResourceLoader loader;


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {//2。需重新ResourceLoaderAware的set。。
        this.loader=resourceLoader;
    }

    @Override
    public void setBeanName(String name) {//2。实现BeanNameAware需重写setBeanName
        this.beanName=name;
    }

    public void outputResult(){
        System.out.println("Bean的名称："+beanName);
        Resource resource = loader.getResource("classpath:Spring_EL/test.properties");
        try {
            System.out.println("ResourceLoader加载的文件内容为："+ IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
