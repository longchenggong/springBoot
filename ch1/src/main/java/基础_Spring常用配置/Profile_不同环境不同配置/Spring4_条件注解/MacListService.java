/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MacListService
 * Author:   longchenggong
 * Date:     2020/1/21 15:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 基础_Spring常用配置.Profile_不同环境不同配置.Spring4_条件注解;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2020/1/21
 * @since 1.0.0
 */
public class MacListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
