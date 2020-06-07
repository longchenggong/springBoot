/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: XmlTest
 * Author:   longchenggong
 * Date:     2019/9/30 11:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package 报文解析;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author longchenggong
 * @create 2019/9/30
 * @since 1.0.0
 */

public class XmlTest {
    public static  String path=System.getProperty("user.dir")+"/pom.xml";

    public static byte[] readFile(String fileName){
       byte[] result=null;
       BufferedInputStream bis=null;
        ByteArrayOutputStream bos=null;
        try {
            bis= new BufferedInputStream(new FileInputStream(fileName));

            bos=new ByteArrayOutputStream();
            byte[] buffer=new byte[2048];
            int len;
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            bos.flush();
            result=bos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static void readOfDomOfJAVA(){

        InputStream in= new ByteArrayInputStream(readFile(path));


        DocumentBuilder documentBuilder=null;
        try {
            documentBuilder =DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document= documentBuilder.parse(in);
            Element root= document.getDocumentElement();
            NodeList list= root.getChildNodes();
            System.out.println(root.getChildNodes().getLength());
            for(int i=0;i<list.getLength();i++){
                Node child=list.item(i);
                System.out.println(child.getNodeType()+" "+child.getNodeName());
            }


         //   _traversal(root);


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }






    }

    public static void _traversal(Node node){
        Properties metqaNodeAttr=new Properties();
        if(node.getNodeType()==1){
            String nodeName1=node.getNodeName();
            NamedNodeMap attributes=node.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attr=attributes.item(i);
                String nodeName=attr.getNodeName();
                String nodeVale=attr.getNodeValue();
                if((nodeName!=null)&&(nodeVale!=null)){
                    metqaNodeAttr.put(nodeName,nodeVale);
//                    System.out.println(nodeName+" :  "+nodeVale);
                }
            }
        }
//        System.out.println(metqaNodeAttr);
        NodeList nodeList= node.getChildNodes();
        System.out.println("nodeList:"+nodeList);
        for (int i=0;i<nodeList.getLength();i++){
            Node child=nodeList.item(i);
            if(child.getNodeType()==1){
                _traversal(child);

            }
        }
    }

    public static void main(String[] args) {
        readOfDomOfJAVA();
    }

}
