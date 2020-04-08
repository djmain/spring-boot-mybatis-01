package com.spring.boot.mybatis.student.service;

import com.spring.boot.mybatis.student.dao.StudentMapper;
import com.spring.boot.mybatis.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by Jay on 2020/4/8
 */
@Service
public class StudentService
{
    @Autowired
    StudentMapper studentMapper;

    public List<Student> list()
    {
        return studentMapper.list();
    }
}
