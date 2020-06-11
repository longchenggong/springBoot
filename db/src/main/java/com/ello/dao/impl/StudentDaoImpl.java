package com.ello.dao.impl;

import com.ello.dao.StudentDao;
import com.ello.domain.Student;
import com.ello.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @create 2020/6/11  13:20 author：longchenggong
 */

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId="com.ello.dao.StudentDao.selectStudents";
        List <Student> students = sqlSession.selectList(sqlId);
        for (Student student : students) {
            System.out.println(student);
        }
        //关闭SqlSession
        sqlSession.close();

        return students;
    }

    @Override
    public int insertStudent(Student student) {
        return 0;
    }
}
