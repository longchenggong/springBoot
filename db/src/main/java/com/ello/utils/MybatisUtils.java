package com.ello.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @create 2020/6/11  13:09 author：longchenggong
 */

public class MybatisUtils {
    private static SqlSessionFactory factory=null;
    static {
        try {
            InputStream in = Resources.getResourceAsStream("mybatis.xml");
             factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取SqlSession的方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if (factory != null) {
            sqlSession=factory.openSession();//非自动提交事务
        }
        return sqlSession;
    }
}
