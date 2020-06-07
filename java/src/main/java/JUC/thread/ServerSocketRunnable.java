/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TRunnable
 * Author:   longchenggong
 * Date:     2019/8/13 10:06
 * Description: 线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package JUC.thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 〈一句话功能简述〉<br> 
 * 〈线程〉
 *
 * @author longchenggong
 * @create 2019/8/13
 * @since 1.0.0
 */
public class ServerSocketRunnable implements Runnable {
    boolean started=true;
    ServerSocket server=null;//服务器套接字等待请求传入

    public ServerSocketRunnable(int prot) throws IOException {
      server=new ServerSocket(prot);
    }

    @Override
    public void run() {
        Socket socket=null;
        while (started){
            try {
                System.out.println("**********");
                socket=server.accept();//侦听 阻塞方法需要放到线程中
                InputStream is=socket.getInputStream();
                byte[] cache=new byte[100];
                int readLen=is.read(cache);
                if(readLen!=-1){
                    String cmd=new String(cache,0,readLen);
                    System.out.printf(cmd);
                }
            } catch (IOException e) {
                if(started)e.printStackTrace();
            }finally {
                if(socket!=null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
