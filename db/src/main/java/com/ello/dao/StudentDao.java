package com.ello.dao;

import com.ello.domain.Student;

import java.util.List;

/**
 * @author longchenggong
 * @description TODO
 * @create 2020/6/9
 * @since 1.0.0
 */
public interface StudentDao {

    public List<Student> selectStudents();

    public int insertStudent(Student student);
}
