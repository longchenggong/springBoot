/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: DemoService
 * Author:   longchenggong
 * Date:     2020/1/21 15:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package Spring高级话题.组合注解;

import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/21
 * @since 1.0.0
 */
@Service
public class DemoService {
    public void outputResult(){
        System.out.println("从组合注解配置照样获得的Bean");
    }
}
