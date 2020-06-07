/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: FunctionService
 * Author:   longchenggong
 * Date:     2020/1/19 10:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.ch1;

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
public class FunctionService {
    public String sayHello(String str){
        return "嘿嘿嘿" +str;
    }
}
