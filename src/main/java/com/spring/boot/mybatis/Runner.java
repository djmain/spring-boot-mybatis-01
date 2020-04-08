package com.spring.boot.mybatis;

import com.spring.boot.mybatis.person.service.PersonService;
import com.spring.boot.mybatis.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

/**
 * created by Jay on 2020/4/8
 */
@Service
public class Runner implements ApplicationRunner
{
    @Autowired
    PersonService personService;

    @Autowired
    StudentService studentService;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        System.out.println(personService.list());
        System.out.println(studentService.list());
    }
}
