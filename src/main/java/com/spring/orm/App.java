package com.spring.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.orm.dao.PersonDao;
import com.spring.orm.entities.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(PersonConfig.class);
        Person person=new Person("Sachin");
        PersonDao personDao=applicationContext.getBean("personDao",PersonDao.class);
        int r=personDao.insert(person);
        System.out.println(r);
    }
}
