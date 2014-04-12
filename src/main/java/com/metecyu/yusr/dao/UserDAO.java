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

import com.metecyu.yusr.model.User;
import com.metecyu.yusr.model.UserDeptRel;
import com.metecyu.yusr.util.PinyinUtils;

@Repository
public class UserDAO extends HibernateDaoSupport {
	private static final Logger log = LogManager
			.getLogger(UserDAO.class);
	
	
	/**
	 * 保存	
	 */
	public User save(User user) {
		getHibernateTemplate().save(user);
		return user;
	}
	public UserDeptRel saveDeptRel(UserDeptRel userDeptRel) {
		getHibernateTemplate().save(userDeptRel);
		return userDeptRel;
	}
	/**
	 * 更新
	 */
	public User update(User user) {
		getHibernateTemplate().update(user);
		return user;
	}
	/**
	 * 通过id获得对象
	 */
	public User findById(String id) {
		
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getSession().get(
					"com.metecyu.yusr.model.User", id);
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
	 * 物理删除
	 */
	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
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
	public int findMaxSerial(String deptid){  
        Map<String,Object> params = new HashMap();    
        StringBuffer sb=new StringBuffer();    
        sb.append("select max(rel.orderno) from UserDeptRel rel  ");  
        sb.append(" where rel.dept.id = :deptid ");
        Query query = getSession().createQuery(sb.toString());   
        query.setParameter("deptid", deptid);  
        Object ret = query.uniqueResult();  
        int count =0;  
        if(ret!=null){  
            count = ((Integer)ret).intValue();  
        }  
        return count;    
    } 
	/**
	 * 获取所有有效部门
	 * @return
	 */
	public List<Object[]> findDeptUser(String deptid){  
        Map<String,Object> params = new HashMap();    
        StringBuffer sb=new StringBuffer();    
        sb.append(" select user,rel.dept,rel from User user inner join user.userDeptRels as rel ");
        sb.append(" where user.iseffect='y' and rel.dept.id = :deptid ");
        sb.append(" order by rel.orderno");
        
        //params.put("deptid", deptid);  
        
        /*// logger.info(sb.toString());  
        Query query = getSession().createQuery(sb.toString());  
        Iterator<Entry<String, Object>> it = params.entrySet().iterator();  
        while (it.hasNext()) {  
           Map.Entry<String,Object> entry = (Map.Entry) it.next();  
           String key = entry.getKey();  
           Object value = entry.getValue();  
           query.setParameter(key, value);  
        }  */
        
        Query query = getSession().createQuery(sb.toString());  
        query.setParameter("deptid", deptid);
        List<Object[]> list = query.list();
        return list;
    } 
	/**
	 * 获得新的 部门编号
	 * 编号规则：
	 * 	1  如果id未占用，直接使用id。
	 * 	2  如果已被占用在原有的id后添加2位数字编号。
	 * 	3 如果编号用完使用uuid（当然通常情况下 不太可能用完）
	 * @param userid
	 * @return
	 */
	public String getNewUserid(String userid){
		 User user = this.findById(userid);
		 if(user==null){  //如果没用重名
			 return userid;
		 }		 
		 // 对重复id 进行再编号（）  
		 List<User> list = findReIdUserList(userid);
		 if(list ==null || list.size()==0 ){
			 userid = userid+"@01";
			 return userid;
		 }
		 if(list.size()>0){ //已有重名情况
			 String atLastUserid = list.get(0).getId();
			 String[] arr = atLastUserid.split("@");
			 String num = arr[1];// 数字位
			 int ten = Integer.parseInt(""+num.charAt(0)); //十位
			 int ge = Integer.parseInt(""+num.charAt(1));// 个位
			 int inum = ten*10 + ge;
			 
			 if(inum>=99){ //如果编号超过99个
				 UUID uuid = UUID.randomUUID();
				 return uuid.toString();
			 }
			 inum++;
			 num = inum+"";
			 if(num.length()==1){ //如果是个位数  十位补0
				 num = "0"+num;
			 }
			 return userid+"@"+num;
		 }
		 return ""; 
	}
	/**
	 * 生成部门id
	 * @param username
	 * @return
	 * @throws BadHanyuPinyinOutputFormatCombination
	 */
	public String genarateUserId(String username) throws BadHanyuPinyinOutputFormatCombination{
		String py = PinyinUtils.getFirstHanyuPinyin(username);
		String newUserid = this.getNewUserid(py);
		return newUserid; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 调整部门编号
	 * @return
	 */
	public int updateUserOrderNo(String orderNo){  
		//log.info("================== clear 0.1");
        Map<String,Object> params = new HashMap();    
        
        StringBuffer sb=new StringBuffer();
        sb.append("update User t set t.orderno = t.orderno+1 where t.orderno >="+orderNo);  
        int count = getSession().createQuery(sb.toString()).executeUpdate();    
        this.getSession().clear();
        return count;    
    } 
	/**
	 * 获取id重复的部门列表
	 * @return
	 */
	private List<User> findReIdUserList(String userid){  
        Map<String,Object> params = new HashMap();    
        StringBuffer sb=new StringBuffer();    
        sb.append("from User user where user.id like '"+userid+"@%' order by user.id desc");  
        Query query = getSession().createQuery(sb.toString());    
        List<User> list = query.list();
        return list;
    }
	
	

	
	
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
}