/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HttpClient
 * Author:   longchenggong
 * Date:     2019/9/20 18:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ello.protocol.http;

import sun.net.www.http.HttpClient;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2019/9/20
 * @since 1.0.0
 */
public class HttpClientTest {


    public static void sendHTTPReq() throws IOException {
        byte[] result=null;
        byte[] req=null;

        URL url=new URL("http://www.baidu.com/more/index.html");
        URLConnection conn=url.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        OutputStream os= conn.getOutputStream();
//        os.write(req);
//        os.flush();

        InputStream is= conn.getInputStream();
        BufferedInputStream bis=new BufferedInputStream(is);
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] cache=new byte[8192];
        int len=-1;
        while ((len=bis.read(cache))!=-1){
            baos.write(cache,0,len);
        }
        baos.flush();
        result=baos.toByteArray();
        baos.close();
        System.out.println(new String(result,"utf-8"));
    }

    public static void sendHTTPSReq() throws IOException {

        URL url=new URL("https://www.baidu.com");
        HttpsURLConnection conn= (HttpsURLConnection) url.openConnection();

        InputStreamReader isr=new InputStreamReader(conn.getInputStream());

        BufferedReader bu=new BufferedReader(isr);

        char[] c=new char[4900];

        int len=isr.read(c);
        while (len!=-1){
            System.out.println(isr.read());
        }

    }

    public static void main(String[] args) throws IOException {
        sendHTTPSReq();
    }

}
