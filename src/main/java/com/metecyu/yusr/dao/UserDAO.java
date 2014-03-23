package com.metecyu.yusr.dao;
import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;


import com.metecyu.yusr.model.User;

@Repository
public class UserDAO extends HibernateDaoSupport {
	private static final Logger log = LogManager
			.getLogger(UserDAO.class);
	
	
	public User save() {
		User user = new User();
		user.setUsername("张平");
		getHibernateTemplate().save(user);

		return user;
	}

	
	
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
}