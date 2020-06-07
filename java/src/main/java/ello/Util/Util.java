/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Util
 * Author:   longchenggong
 * Date:     2019/11/29 10:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ello.Util;



import java.io.IOException;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2019/11/29
 * @since 1.0.0
 */
public class Util {


    public static byte[] readDataWithLen(InputStream is,int length) throws IOException {
        byte[] result=new byte[length];

        int len=0;
        int count=0;

        byte[] tmp=new byte[length];
        while ((len=is.read(tmp))!=-1){
            System.arraycopy(tmp,0,result,count,len);
            count+=len;
            if(count==length){
                break;
            }
        }
        return result;
    }
}
