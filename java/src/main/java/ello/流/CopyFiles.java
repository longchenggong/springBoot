package ello.流;

import java.io.*;

/**
 * @create 2020/5/31  14:29 author：longchenggong
 */

public class CopyFiles {


    public static void main(String[] args) {
        File local = new File("ch1/src");
        File remote = new File("a");

        copyDir (local,remote);
    }

    private static void copyDir(File srcFile, File desFile) {
        if(srcFile.isFile()){ //如果是一个文件，递归结束

            FileInputStream in=null;
            FileOutputStream out=null;

            try {
                in =new FileInputStream(srcFile);

                String path=desFile.getAbsoluteFile()+srcFile.getAbsolutePath().substring(44);
                out =new FileOutputStream(path);


                byte[] b=new byte[1024];
                int len=0;

                while ((len=in.read(b))!=-1){
                    out.write(b,0,len);//返回的是读取多少个字节，最有一次不会正好读完，只取我们需要的
                }

                //输出流需要刷新
                out.flush();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            return;
        }

        File[] files = srcFile.listFiles();
        for (File file : files) {

            if(file.isDirectory()){
          //     System.out.println(file.getAbsolutePath());//绝对路径
                String srcDir = file.getAbsolutePath();
                String desDir = desFile.getAbsolutePath()+srcDir.substring(44);


               System.out.println(desDir);
                File f = new File(desDir);
                if(!f.exists()){
                    f.mkdirs(); //创建目录
                }
            }

            copyDir(file,desFile); //递归
        }
    }
}
