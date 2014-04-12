package com.metecyu.yusr.service;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.metecyu.yusr.dao.DeptDAO;
import com.metecyu.yusr.dao.UserDAO;
import com.metecyu.yusr.model.Dept;
import com.metecyu.yusr.model.User;
import com.metecyu.yusr.model.UserDeptRel;
import com.metecyu.yusr.webmodel.WDept;

@Service
public class DeptService  {
	private static final Logger log = LogManager
			.getLogger(DeptService.class);
	@Resource
	private DeptDAO deptDAO;
	@Resource
	private UserDAO userDAO; 
	
	/**
	 * 添加部门
	 * @param deptname
	 * @param wholename
	 * @param type
	 * @return
	 */
	public Dept addDept(String deptid,String deptname,String wholename,String type) {
		int max = this.deptDAO.findMaxSerial();
		Dept dept = new Dept();
		dept.setId(deptid);
		dept.setIseffect("y");
		dept.setDeptname(deptname);
		dept.setDeptwholename(wholename);
		dept.setType(type);
		dept.setOrderno(max+1);
		deptDAO.save(dept);
		return dept; 
	}
	
	/**
	 * 添加部门
	 * @param deptname
	 * @param wholename
	 * @param type
	 * @return
	 * @throws BadHanyuPinyinOutputFormatCombination 
	 */
	public Dept addDept(String deptname,String wholename,String type) throws BadHanyuPinyinOutputFormatCombination {
		String deptid = this.deptDAO.genarateDeptId(deptname);
		int max = this.deptDAO.findMaxSerial();
		Dept dept = addDept(deptid,deptname,wholename,type);
		return dept; 
	}
	
	/**
	 * 获得所有的部门
	 * @param deptname
	 * @param wholename
	 * @param type
	 * @return
	 */
	public List<Dept> findAllDept() {		
		return deptDAO.findAllDept();
	}
	
	/**
	 * 获得所有的部门
	 * @param deptname
	 * @param wholename
	 * @param type
	 * @return
	 */
	public List<WDept> turnToWDept(List<Dept> deptList) {	
		int i = 0;
		List<WDept> outList = new ArrayList();
		for(Dept dept:deptList){
			i++;
			WDept w = new WDept();
			w.setId(dept.getId());
			w.setDeptname(dept.getDeptname());
			w.setSnum(""+i);
			w.setPeoples("10");
			w.setMonitor("张三");
			outList.add(w);
		}
		return outList;
	}
	
	
	/**
	 */
	public Dept findById(String id) {		
		return deptDAO.findById(id);
	}
	
	/**
	 * 保存部门修改
	 * @param deptname
	 * @param wholename
	 * @param type
	 * @return
	 */
	public Dept saveDept(String deptid,String deptname,String wholename,String type) {
		Dept dept = this.deptDAO.findById(deptid);
		dept.setDeptname(deptname);
		dept.setDeptwholename(wholename);
		dept.setType(type);
		deptDAO.save(dept);
		return dept; 
	}
	
	//删除部门
	public Dept delete(String deptid) {
		Dept dept = this.deptDAO.findById(deptid);
		dept.setIseffect("n");
		deptDAO.save(dept);
		return dept; 
	}
	
	/**
	 * 调整部门排序
	 * @param deptid
	 * @param targetDeptid
	 * @param shift
	 */
	public void adjustDeptOrder(String deptid,String targetDeptid){
		
		Dept dept = this.deptDAO.findById(deptid);
		Dept targetDept = this.deptDAO.findById(targetDeptid);
		int targetOrder = targetDept.getOrderno();
		int count = deptDAO.updateDeptOrderNo(""+targetOrder);
		dept.setOrderno(targetOrder);
		deptDAO.update(dept);
	}
	

	/**
	 * 添加非主办部门用户
	 * @param deptid  
	 * @param userid
	 */
	public UserDeptRel addNoMainDeptUser(String deptid,String userid){
		UserDeptRel hisRel = deptDAO.findUserDeptRelByDeptId(deptid, userid);
		if(hisRel!=null){
			return hisRel;
		}
	   	User user = userDAO.findById(userid);
		// 建立部门关联 
		Dept dept = deptDAO.findById(deptid);
		int max = this.userDAO.findMaxSerial(deptid); //添加用户至最后
		UserDeptRel rel = new UserDeptRel();
		rel.setIsmain("n");
		rel.setUser(user);
		rel.setDept(dept);
		rel.setOrderno(max+1);
		userDAO.saveDeptRel(rel);
		return rel;
	}
	
	/**
	 * 获得主办部门关联记录
	 * @param deptid
	 * @param targetDeptid
	 * @param shift
	 */
	public UserDeptRel findMainUserDeptRel(String userid){
		UserDeptRel rel = this.deptDAO.findMainUserDeptRel(userid);
		return rel;
	}
	
	
	/**
	 * 调整用户部门排序
	 * @param sourceid
	 * @param targetid
	 */
	public void adjustUserOrder(String deptid,String userid,String targetUserid){
		
		UserDeptRel rel = this.deptDAO.findUserDeptRelByDeptId(deptid, userid);
		UserDeptRel targetRel = this.deptDAO.findUserDeptRelByDeptId(deptid, targetUserid);
		int targetOrder = targetRel.getOrderno();
		int count = deptDAO.updateUserDeptOrderNo(deptid,""+targetOrder);
		//List list = this.deptDAO.findAllDept();
		
		rel.setOrderno(targetOrder);
		deptDAO.updateUserRel(rel);

	}
	
	/**
	 * 删除用户部门关联，如果是主办部门则不删因为这样破坏了用户必须属于至少一个部门的规则
	 * @param deptid
	 * @param userid
	 * @return
	 */
	 
	public int delUserDeptRel(String deptid,String userid){
		UserDeptRel rel = this.deptDAO.findUserDeptRelByDeptId(deptid, userid);
		if(rel.getIsmain().equals("n")){
			this.deptDAO.delete(rel);
			return 1;
		}
		return 0;
	}
	
	

	

}