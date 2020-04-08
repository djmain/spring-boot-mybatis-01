package com.spring.boot.mybatis.student.dao;

import com.spring.boot.mybatis.student.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by Jay on 2020/4/8
 */
@Repository
public interface StudentMapper
{
    List<Student> list();
}
