package com.spring.orm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Person;

@Component("personDao")
public class PersonDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public PersonDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonDao(HibernateTemplate hibernateTemplate) {
		super();
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public String toString() {
		return "PersonDao [hibernateTemplate=" + hibernateTemplate + "]";
	}
	
	@Transactional
	public int insert(Person person)
	{
		return (Integer)hibernateTemplate.save(person);
	}
}
