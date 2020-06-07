/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IOTest_BufferedReader
 * Author:   longchenggong
 * Date:     2019/9/24 15:19
 * Description: 适配器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ello.设计模式.IO装饰模式;

import java.io.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈适配器〉
 *
 * @author longchenggong
 * @create 2019/9/24
 * @since 1.0.0
 */
public class IOTest_BufferedReader {
    public static void main(String[] args) throws IOException {
//        readFile("111.txt");
        readFile2("111.txt");


    }

//需求：在输出的一行前加 引号
//定义BufferedReader的子类，继承BufferedReader增强功能.
    private static void readFile(String path) throws IOException {
        Reader reader=new FileReader(path);
        BufferedReader bufferedReader=new MyQutoBufferedReader(reader);
        int count=0;
        String line=null;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
            count++;
        }
    }



    private static void readFile2(String path) throws IOException {
        Reader read = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(read);
        BufferedReader br = new MyQutoBufferedReader2(bufferedReader);
        br = new MyLineBufferedReader2(br);
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
//// quotation 引号
class MyQutoBufferedReader extends BufferedReader {
    public MyQutoBufferedReader(Reader in) {
        super(in);
    }
    public String readLine() throws IOException {
        String line=super.readLine();
        if(line!=null){
            return "\"" +line+"\"";
        }else {
            return  null;
        }
    }
}
//-------------------------------------

// quotation 引号
class MyQutoBufferedReader2 extends BufferedReader {
    private BufferedReader bufferedReader;
    public MyQutoBufferedReader2(BufferedReader bufferedReader) {
        super(bufferedReader);
        this.bufferedReader = bufferedReader;
    }
    public String readLine() throws IOException {
        String line = super.readLine();
        if (line != null) {
            return "\"" + line + "\"~";
        } else {
            return null;
        }
    }
}

class MyLineBufferedReader2 extends MyQutoBufferedReader2 {
    private BufferedReader bufferedReader;
    public MyLineBufferedReader2(BufferedReader bufferedReader) {
        super(bufferedReader);
        this.bufferedReader = bufferedReader;
    }
    int count;
    @Override
    public String readLine() throws IOException {
        String line = super.readLine();
        if (line != null) {
            count++;
            return count + ":" + line;
        } else {
            return null;
        }
    }
}