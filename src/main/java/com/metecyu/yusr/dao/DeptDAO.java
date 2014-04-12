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
	 * 更新
	 */
	public Dept update(Dept dept) {
		getHibernateTemplate().update(dept);
		return dept;
	}
	
	/**
	 * 更新
	 */
	public UserDeptRel updateUserRel(UserDeptRel rel) {
		getHibernateTemplate().update(rel);
		return rel;
	}
	
	
	/**
	 * 通过id获得对象
	 */
	public Dept findById(String id) {
		
		log.debug("getting Dept instance with id: " + id);
		try {
			Dept instance = (Dept) getSession().get(
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
	 * 物理删除
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
	 * 物理删除
	 */
	public void delete(UserDeptRel persistentInstance) {
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
	public List<Dept> findAllDept(){  
        Map<String,Object> params = new HashMap();    
        StringBuffer sb=new StringBuffer();    
        sb.append("from Dept dept where dept.iseffect='y' order by dept.orderno");  
        Query query = getSession().createQuery(sb.toString());    
        List<Dept> list = query.list();
        return list;
    } 
	/**
	 * 获得新的 部门编号
	 * 编号规则：
	 * 	1  如果id未占用，直接使用id。
	 * 	2  如果已被占用在原有的id后添加2位数字编号。
	 * 	3 如果编号用完使用uuid（当然通常情况下 不太可能用完）
	 * @param deptid
	 * @return
	 */
	public String getNewDeptid(String deptid){
		 Dept dept = this.findById(deptid);
		 if(dept==null){  //如果没用重名
			 return deptid;
		 }		 
		 // 对重复id 进行再编号（）  
		 List<Dept> list = findReIdDeptList(deptid);
		 if(list ==null || list.size()==0 ){
			 deptid = deptid+"@01";
			 return deptid;
		 }
		 if(list.size()>0){ //已有重名情况
			 String atLastDeptid = list.get(0).getId();
			 String[] arr = atLastDeptid.split("@");
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
			 return deptid+"@"+num;
		 }
		 return ""; 
	}
	/**
	 * 生成部门id
	 * @param deptname
	 * @return
	 * @throws BadHanyuPinyinOutputFormatCombination
	 */
	public String genarateDeptId(String deptname) throws BadHanyuPinyinOutputFormatCombination{
		String py = PinyinUtils.getFirstHanyuPinyin(deptname);
		String newDeptid = this.getNewDeptid(py);
		return newDeptid; 
	}
	
	
	/**
	 * 调整部门编号
	 * @return
	 */
	public int updateDeptOrderNo(String orderNo){  
		//log.info("================== clear 0.1");
        Map<String,Object> params = new HashMap();    
        
        StringBuffer sb=new StringBuffer();
        sb.append("update Dept t set t.orderno = t.orderno+1 where t.orderno >="+orderNo);  
        int count = getSession().createQuery(sb.toString()).executeUpdate();    
        this.getSession().clear();
        return count;    
    } 
	
	/**
	 * 调整部门用户排序
	 * @return
	 */
	public int updateUserDeptOrderNo(String deptid,String orderNo){  
		//log.info("================== clear 0.1");
        Map<String,Object> params = new HashMap();    
        
        StringBuffer sb=new StringBuffer();
        sb.append("update UserDeptRel t set t.orderno = t.orderno+1 where t.orderno >="+orderNo+" and t.dept.id='"+deptid+"'");  
        int count = getSession().createQuery(sb.toString()).executeUpdate();    
        this.getSession().clear();
        return count;    
    } 
	
	
	/**
	 * 获取id重复的部门列表
	 * @return
	 */
	private List<Dept> findReIdDeptList(String deptid){  
        Map<String,Object> params = new HashMap();    
        StringBuffer sb=new StringBuffer();    
        sb.append("from Dept dept where dept.id like '"+deptid+"@%' order by dept.id desc");  
        Query query = getSession().createQuery(sb.toString());    
        List<Dept> list = query.list();
        return list;
    }
	
	
	
	/**
	 * 获取主办部门
	 * @return
	 */
	public UserDeptRel findMainUserDeptRel(String userid){  
        Map<String,Object> params = new HashMap();  
        List<UserDeptRel> list = findUserDeptRelListByUserid(userid,"y");
        UserDeptRel dept = null;
        if(list.size()==1){
        	dept = list.get(0);
        }else if(list.size()>1){
        	String msg = "用户的主办部门不应超过1个";
        	logger.error(msg);
        	throw new RuntimeException(msg);
        }
        return dept;
    }

	
	
	
	/**
	 * 获取用户部门关联
	 * 
	 * @param userid
	 * @param ismain  y:仅限主办部门 
	 * @return
	 */
	
	public List<UserDeptRel> findUserDeptRelListByUserid(String userid,String ismain){  
        Map<String,Object> params = new HashMap();    
        StringBuffer sb=new StringBuffer();    
        sb.append(" select rel from UserDeptRel rel");
        sb.append(" where rel.user.id=:userid");
        if("y".equals(ismain)){
        	sb.append(" and rel.ismain='y'");
        }
        Query query = getSession().createQuery(sb.toString());  
        query.setParameter("userid", userid);
        List<UserDeptRel> list = query.list();
        return list;
    } 
	
	
	/**
	 * 获取用户的部门关联记录， 如果没有的话返回null对象
	 * @param deptid
	 * @param userid 
	 * @return
	 */
	public UserDeptRel findUserDeptRelByDeptId(String deptid,String userid){  
		UserDeptRel ret =null;
		List<UserDeptRel> list = findUserDeptRelListByUserid(userid,"");
		for(UserDeptRel rel:list){
			if(rel.getDept().getId().equals(deptid)){
				ret = rel; 
			}
		}
		return ret;
    } 
	
	
	
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
}