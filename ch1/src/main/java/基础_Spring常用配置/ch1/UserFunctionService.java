/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserFunctionService
 * Author:   longchenggong
 * Date:     2020/1/19 10:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.ch1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/19
 * @since 1.0.0
 */
@Service
public class UserFunctionService {
    @Autowired
    FunctionService functionService;

    public String sayHello(String str){
       return functionService.sayHello(str);
    }
}
