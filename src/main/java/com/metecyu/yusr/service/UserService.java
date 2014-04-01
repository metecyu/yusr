package com.metecyu.yusr.service;
import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.metecyu.yusr.dao.DeptDAO;
import com.metecyu.yusr.dao.UserDAO;
import com.metecyu.yusr.model.Dept;
import com.metecyu.yusr.model.User;
import com.metecyu.yusr.model.UserDeptRel;
import com.metecyu.yusr.util.DateCenter;

@Service
public class UserService  {
	private static final Logger log = LogManager
			.getLogger(UserService.class);
	@Resource
	private UserDAO userDAO;
	@Resource
	private DeptDAO deptDAO; 
	/**
	 * 添加用户
	 * @param username
	 * @param wholename
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	public User addUser(String userid,String loginid,String username,String passward,String birthday,String mobile,String fjh,String fphone,String workstate,String orgtype,String sfzid,String duty,String dutydetails,String mainDeptid) throws Exception {
		
		User user = new User();
		user.setId(userid);
		user.setLoginid(loginid);
		user.setUsername(username);
		user.setPassword(passward);
		user.setBirthday(DateCenter.getDate(birthday));
		user.setMobile(mobile);
		user.setFjh(fjh);
		user.setFphone(fphone);
		user.setWorkstate(workstate);
		user.setOrgtype(orgtype);
		user.setSfzid(sfzid);
		user.setDuty(duty);
		user.setDutydetails(dutydetails);
		user.setIseffect("y");
		userDAO.save(user);
		
		// 建立部门关联 
		Dept dept = deptDAO.findById(mainDeptid);
		int max = this.userDAO.findMaxSerial(mainDeptid);
		UserDeptRel rel = new UserDeptRel();
		rel.setIsmain("y");
		rel.setUser(user);
		rel.setDept(dept);
		rel.setOrderno(max+1);
		userDAO.saveDeptRel(rel);
		return user; 
	}
	
	/**
	 * 添加部门
	 * @param username
	 * @param wholename
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	public User addUser(String loginid,String username,String passward,String birthday,String mobile,String fjh,String fphone,String workstate,String orgtype,String sfzid,String duty,String dutydetails,String mainDeptid) throws Exception {
		String userid = this.userDAO.genarateUserId(username);
		User user = addUser(userid, loginid, username, passward, birthday, mobile, fjh, fphone, workstate, orgtype, sfzid, duty, dutydetails,mainDeptid);
		return user; 
	}
	
	

}