package com.spring.boot.mybatis.book;

import com.spring.boot.mybatis.person.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by Jay on 2020/4/8
 */
@Repository
public interface BookMapper
{
    List<Person> list();
}
