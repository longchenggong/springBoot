/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PrintStream
 * Author:   longchenggong
 * Date:     2019/9/16 14:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ello.流;

import java.io.*;

/**
 * 打印字节流
 *
 * @author longchenggong
 * @create 2019/9/16
 * @since 1.0.0
 *
 */
public class PrintStream {

    public static void 输出到文件(){
        java.io.PrintStream out=null;
        try {
//            out = new java.io.PrintStream("write.txt"); //直接输出到文件
            out=new java.io.PrintStream(new FileOutputStream("write1.txt"));//将输出传给字节输出流
            System.setOut(out);//重定向输出到文件
            System.out.println("Hello");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                out.close();
            }
        }
    }

    public static void 打印流实现文件拷贝(){
        FileInputStream in=null;
        java.io.PrintStream out=null;
        try {
            in= new FileInputStream("write.txt");
            out=new java.io.PrintStream("111.txt");
            byte[] date=new byte[512];
            int tmp=0;
            while ((tmp=in.read(date))!=-1){
//                out.print(new String(date,0,tmp));
                out.write(date,0,tmp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(out!=null){
                    out.close();
                }
            }
        }

    }
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        输出到文件();
        打印流实现文件拷贝();
    }
}
