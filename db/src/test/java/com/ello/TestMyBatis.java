package com.ello;

import com.ello.dao.StudentDao;
import com.ello.dao.impl.StudentDaoImpl;
import com.ello.domain.Student;
import com.ello.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class TestMyBatis {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testInsert() throws IOException {
        //访问mybatis读取student数据
        //1。读取mybatis主配置文件  target/class
        String config = "mybatis.xml";
        //2.读取config文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建 sqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //5.获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //6.指定要执行的sql语句标示。mapping映射中的namespace+id
        String sqlId = "com.ello.dao.StudentDao" + "." + "insertStudent";
        //7.执行sql
        Student student = new Student();
        student.setId(103);
        student.setName("扎飞");
        student.setAge(43);
        student.setEmail("zhafei@qq.com");
        int nums = sqlSession.insert(sqlId, student);
        //mybatis默认不是自动提交事务，DML需要手动提交
        sqlSession.commit();
        System.out.println("数据库改变结果：" + nums);
        //关闭
        sqlSession.close();
    }

    //通过dao执行
    @Test
    public void testSelectStudens() {
        StudentDao dao = new StudentDaoImpl();
        List <Student> students = dao.selectStudents();
        for (Student student : students) {
            System.out.println("testSelectStudents:" + student);
        }
    }

    //mybatis动态代理：根据dao的方法调用slq语句(根据dao接口，创建一个接口实现类 【jdk动态代理】)
    //1.反射拿到dao的全限定名称，和mapper文件中的namespace是一样的
    //2.mapper中的id和接口中的方法名称一致->根据<select>调用select()[根据返回值也能确定list、int]
    //项目开发使用这种
    @Test
    public void testSelect(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List <Student> students = dao.selectStudents();
        for (Student student : students) {
            System.out.println("student = " + student);
        }
    }
}
