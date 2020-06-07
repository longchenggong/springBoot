/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: 动态编译JavaCompiler
 * Author:   longchenggong
 * Date:     2019/10/13 13:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ello.反射;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2019/10/13
 * @since 1.0.0
 */
public class 动态编译JavaCompiler {

    public static String path=System.getProperty("user.dir");
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        System.out.println();
        //动态编译
        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
        int result=compiler.run(null,null,null,path+"/files/HelloWord.java");
            //四个参数：1：为java编译期提供参数
            // 2：得到Java编译器的输出信息
            //3：接收编译器的错误信息
            //4：可变参数(string数组)，能传入一个或多个Java源文件 【字符串可以通过IO存储为一个临时文件】
            //返回值：0编译成功，非0表示编译失败
        System.out.println(result==0?"编译成功":"编译失败");
        System.out.println(path);
        //动态运行 通过Runtime
        Runtime run= Runtime.getRuntime();
        Process process= run.exec("java -cp /Users/longchenggong/ideaWork/javaTest/files  HelloWord");

        InputStream in= process.getInputStream();

        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        System.out.println(reader.readLine());
        String info="";
        while ((info=reader.readLine())!=null){

            System.out.println("info:"+info);
        }



        //通过反射 ClassLoad

        URL[] urls=new URL[]{new URL("file:/"+"")};
        URLClassLoader loader=new URLClassLoader(urls);
        Class c=loader.loadClass("");
            //调用加载类的main方法
        c.getMethod("main",String[].class).invoke(null,(Object) new String[]{"aa","bb"});//(Object)必须加，要不然会编译成invoke(null,"aa","bb")

    }

}
