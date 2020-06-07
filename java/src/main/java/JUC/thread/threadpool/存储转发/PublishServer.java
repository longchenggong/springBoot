/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PublishServer
 * Author:   longchenggong
 * Date:     2019/11/29 08:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package JUC.thread.threadpool.存储转发;


import ello.Util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author longchenggong
 * @create 2019/11/29
 * @since 1.0.0
 */
public class PublishServer implements Runnable {

    private ExecutorService executors=null;
    private int threadPool=10;

    @Override
    public void run() {
        startServer();
    }
    private void startServer(){
        SubscribeManager subManager = SubscribeManager.getInstance();//订阅管理
        subManager.startF5MonitorThread();
        //1。f5状态检测
        //2。加载订阅发布服务信息 esb_publish_info(服务发布基本信息) left join esb_subcrb_info(订阅服务基本信息)
        //3。启动发布存储监听
        executors= Executors.newFixedThreadPool(threadPool);

        try {
           ServerSocket server= new ServerSocket(0,100);//"端口"0则字典分配,backlog"请求进入连接队列最大长度"

           while (true){
               Socket socket= server.accept();
               socket.setSoTimeout(60000);
               StoreProcess process=new StoreProcess(socket);
               executors.execute(process);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//存储流程
class StoreProcess implements Runnable{
    private Socket socket=null;
    private StoreService service=new StoreService();
    public StoreProcess(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        InputStream is=null;
        OutputStream os=null;
        try {
        is=socket.getInputStream();
        os=socket.getOutputStream();
        byte[] reqData= Util.readDataWithLen(is,123);
        byte[] rspData=service.execute(reqData);//响应给发布方到报文
        os.write(000000);
        os.write(rspData);
        os.flush();
        } catch (IOException e) {  e.printStackTrace();
        }finally { if(is!=null){try {is.close();} catch (IOException e) {e.printStackTrace();}
            }if(os!=null){ try {os.close();} catch (IOException e) { e.printStackTrace();} }}}
}

class StoreService{
    public byte[] execute(byte[] reqData){
        //获取订阅系统
        //插入转发记录      esb_msg_send_log
        //保存消息报文(发布) esb_publish_msg_log
        //返回消息存储成功（自行组装返回报文）
        return "消息存储成功".getBytes();
    }

}

class SubscribeManager{
    private static SubscribeManager instance=new SubscribeManager();
    private SubscribeManager() {
        //reload() 一些初始化参数   esb_subcrb_sys_info 订阅系统基本信息
         }
    public static SubscribeManager getInstance(){
        return instance;
    }
/*f5状态检测线程，如处于隔离状态不进行消息转发，每隔一分钟检测表 esb_f5_contorl中当前应用到状态
* */
public void startF5MonitorThread(){
    new Thread(new Runnable() {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(60*1000);
                    //更新f5状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }).start();
}

    /**
     * 转发线程
     * 根据每个订阅系统循环 esb_subcrb_sys_info(转发线程池参数)
     */
    public void startForward() {
        //while (it.hasNext){

        final String threadName="Pool-Forward-"+"拼装sysid"+"-Thread";


    //}

}
}