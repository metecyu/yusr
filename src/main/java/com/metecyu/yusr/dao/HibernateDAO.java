package com.metecyu.yusr.dao;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.metecyu.yusr.model.User;

public class HibernateDAO extends HibernateDaoSupport {
	private static final Logger log = LogManager
			.getLogger(HibernateDAO.class);
	
	public Session session = null;  
	public HibernateDAO(){  
	    //找出hibernate的配置  
	    Configuration config = new Configuration().configure();  
	    //从配置中取出SessionFactory  
	    SessionFactory sf = config.buildSessionFactory();  
	    //从SessionFactory中取出Session  
	    this.session = sf.openSession();  
	}  
	
  
	public User queryById(String id){  
	    System.out.println(id);  
	    User person = null;  
	    //hibernate查询语句  
	    String hql = "FROM User as p WHERE p.id = ?";  
	    Query q = session.createQuery(hql);  
	    q.setString(0, id);  
	    List list = q.list();  
	    Iterator iteator = list.iterator();  
	    if(iteator.hasNext()){  
	     person = (User)iteator.next();  
	    }  
	    return person;  
	}
	
	public static void main(String args[]){
		HibernateDAO dao = new HibernateDAO();
		User user  = dao.queryById("yh1");
		System.out.print(user.getUsername());
		
	} 
}