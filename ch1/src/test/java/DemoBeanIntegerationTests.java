import Spring_测试.TestBean;
import Spring_测试.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/1/21  17:25
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class) //1。SpringJUnit4ClassRunner在JUnit环境下提供 TestContext Framework功能
@ContextConfiguration(classes = {TestConfig.class}) //2。加载ApplicationContext，class属性用来加载配置类
@ActiveProfiles("prod")   //3。声明活动的profile
public class DemoBeanIntegerationTests {
    @Autowired
    private TestBean testBean;

    @Test
    public void prodBeanShouldInject() {
        String expected = "from production profile";
        String actual = testBean.getContent();
        Assert.assertEquals(expected,actual);
    }
}
