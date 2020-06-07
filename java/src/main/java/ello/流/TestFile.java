/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestFile
 * Author:   longchenggong
 * Date:     2019/9/27 10:41
 * Description: 文件曹错
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ello.流;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈文件操作〉
 *
 * @author longchenggong
 * @create 2019/9/27
 * @since 1.0.0
 */
public class TestFile {
    static void printFiles(File[] files){
        if (files!=null){
            for (File f:files){
                System.out.println(f+ " "+f.isDirectory());
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        File f=new File("src/com/ello");

        File[] files=f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("col");
            }
        });

        printFiles(files);
    }
}
