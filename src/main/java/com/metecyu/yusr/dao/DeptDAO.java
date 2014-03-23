package com.metecyu.yusr.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.metecyu.yusr.model.Dept;

@Repository
public class DeptDAO extends HibernateDaoSupport {
	private static final Logger log = LogManager
			.getLogger(DeptDAO.class);
	
	
	
	/**
	 * 保存	
	 */
	public Dept save(Dept dept) {
		getHibernateTemplate().save(dept);
		return dept;
	}
	/**
	 * 查找
	 */
	public Dept findById(String id) {
		log.debug("getting Dept instance with id: " + id);
		try {
			Dept instance = (Dept) getSessionFactory().getCurrentSession().get(
					"com.metecyu.yusr.model.Dept", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	/**
	 * 删除
	 */
	public void delete(Dept persistentInstance) {
		log.debug("deleting Dept instance");
		try {
			getSessionFactory().getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	/**
	 * 获取最大的部门编号
	 * @return
	 */
	public int findMaxSerial(){  
        Map<String,Object> params = new HashMap();    
        StringBuffer sb=new StringBuffer();    
        sb.append("select max(dept.orderno) from Dept dept where dept.iseffect='y'");  
        Query query = getSession().createQuery(sb.toString());    
        Object ret = query.uniqueResult();  
        int count =-1;  
        if(ret!=null){  
            count = ((Integer)ret).intValue();  
        }  
        return count;    
    } 
	/**
	 * 获取最大的部门编号
	 * @return
	 */
	public List<Dept> findAllDept(){  
        Map<String,Object> params = new HashMap();    
        StringBuffer sb=new StringBuffer();    
        sb.append("from Dept dept where dept.iseffect='y'");  
        Query query = getSession().createQuery(sb.toString());    
        List<Dept> list = query.list();
        return list;
    } 

	
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
}