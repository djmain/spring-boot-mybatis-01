package com.spring.boot.mybatis.person.service;

import com.spring.boot.mybatis.person.dao.PersonMapper;
import com.spring.boot.mybatis.person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by Jay on 2020/4/8
 */

@Service
public class PersonService
{
    @Autowired
    PersonMapper personMapper;

    public List<Person> list()
    {
        return personMapper.list();
    }
}
