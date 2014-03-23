package com.metecyu.yusr.service;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.metecyu.yusr.dao.DeptDAO;
import com.metecyu.yusr.model.Dept;

@Service
public class DeptService  {
	private static final Logger log = LogManager
			.getLogger(DeptService.class);
	@Resource
	private DeptDAO deptDAO; 
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
	 * 获得所有的部门
	 * @param deptname
	 * @param wholename
	 * @param type
	 * @return
	 */
	public List<Dept> findAllDept() {		
		return deptDAO.findAllDept();
	}
	
	
	
	
	

	

}