package com.metecyu.yusr.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.metecyu.yusr.model.Dept;
import com.metecyu.yusr.model.UserDeptRel;
import com.metecyu.yusr.util.PinyinUtils;

@Repository
public class DataCenter extends HibernateDaoSupport {
	private static final Logger log = LogManager
			.getLogger(DataCenter.class);
	
	/**
	 * 保存	
	 */
	public void deleteAllUserDeptRel() {
		
        StringBuffer sb=new StringBuffer();
        sb.append("delete UserDeptRel rel");  
        int count = getSession().createQuery(sb.toString()).executeUpdate();   
        
	}
	public void deleteAllDept() {
        StringBuffer sb=new StringBuffer();
        sb.append("delete Dept dept");  
        int count = getSession().createQuery(sb.toString()).executeUpdate();
	}
	public void deleteAllUser() {
        StringBuffer sb=new StringBuffer();
        sb.append("delete User user");  
        int count = getSession().createQuery(sb.toString()).executeUpdate();
	}

	
	
	
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
}