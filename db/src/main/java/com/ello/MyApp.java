package com.ello;

import java.io.IOException;

/**
 * @create 2020/6/9  21:44 author：longchenggong
 */

public class MyApp {
    public static void main(String[] args) throws IOException {
//        //访问mybatis读取student数据
//        //1。读取mybatis主配置文件  target/class
//        String config="mybatis.xml";
//        //2.读取config文件
//        InputStream in = Resources.getResourceAsStream(config);
//        //3.创建sqlSessionFactoryBuilder对象
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        //4.创建 sqlSessionFactory
//        SqlSessionFactory factory = builder.build(in);




//        //5.获取sqlSession
//        SqlSession sqlSession= MybatisUtils.getSqlSession();
//        //6.指定要执行的sql语句标示。mapping映射中的namespace+id
//        String sqlId="com.ello.dao.StudentDao"+"."+"selectStudents";
//        //7.执行sql
//        List <Student> studentList = sqlSession.selectList(sqlId);
//        studentList.forEach(stu -> System.out.println(stu));
//        //关闭
//        sqlSession.close();



    }
}
