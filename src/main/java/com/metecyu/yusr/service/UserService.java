package com.metecyu.yusr.service;
import java.util.ArrayList;
import java.util.List;

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
import com.metecyu.yusr.webmodel.WDept;
import com.metecyu.yusr.webmodel.WUser;

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
	 * 添加用户
	 */
	public User addUser(String loginid,String username,String passward,String birthday,String mobile,String fjh,String fphone,String workstate,String orgtype,String sfzid,String duty,String dutydetails,String mainDeptid) throws Exception {
		String userid = this.userDAO.genarateUserId(username);
		if(loginid ==null || loginid.equals("")){
			loginid = userid;
		}
		User user = addUser(userid, loginid, username, passward, birthday, mobile, fjh, fphone, workstate, orgtype, sfzid, duty, dutydetails,mainDeptid);
		return user; 
	}
	
	// 查找部门的用户列表
	public List<UserDeptRel>  findDeptUser(String deptid){
		return userDAO.findDeptUser(deptid);
	}
	
	// 查找部门的用户列表
	public User findById(String id){
		return userDAO.findById(id);
	}
	
	//删除部门
	public User delete(String deptid) {
		User user = this.userDAO.findById(deptid);
		user.setIseffect("n");
		userDAO.save(user);
		return user; 
	}
	
	
	/**
	 * 修改用户
	 */
	public User saveUser(String userid,String loginid,String username,String password,String birthday,String mobile,String fjh,String fphone,String workstate,String orgtype,String sfzid,String duty,String dutydetails,String mainDeptid) throws Exception {
		User user  = this.userDAO.findById(userid);
		user.setId(userid);
		user.setLoginid(loginid);
		user.setUsername(username);
		user.setPassword(password);
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
		
		UserDeptRel mainDeptRel = deptDAO.findMainUserDeptRel(userid);
		Dept dept = deptDAO.findById(mainDeptid);
		if(mainDeptRel==null){
			// 建立部门关联 
			int max = this.userDAO.findMaxSerial(mainDeptid);
			UserDeptRel rel = new UserDeptRel();
			rel.setIsmain("y");
			rel.setUser(user);
			rel.setDept(dept);
			rel.setOrderno(max+1);
			userDAO.saveDeptRel(rel);
		}else if(!mainDeptRel.getDept().getId().equals(mainDeptid)){ //部门id被修改了
			int max = this.userDAO.findMaxSerial(mainDeptid);
			mainDeptRel.setDept(dept);
			mainDeptRel.setOrderno(max+1);
			userDAO.saveDeptRel(mainDeptRel);			
		}
		
		return user; 
	}
	
	
	/**
	 * 获得所有的部门
	 * @param deptname
	 * @param wholename
	 * @param type
	 * @return
	 */
	public List<WUser> turnToWUser(List<UserDeptRel> deptList) {	
		int i = 0;
		List<WUser> outList = new ArrayList();
		for(UserDeptRel rel:deptList){
			i++;
			User user = rel.getUser();
			WUser w = new WUser();
			w.setSnum(""+i);
			w.setId(user.getId());
			w.setLoginid(user.getLoginid());
			w.setUsername(user.getUsername());
			w.setPassword(user.getPassword());
			w.setBirthday(user.getBirthday());
			w.setMobile(user.getMobile());
			w.setFjh(user.getFjh());
			w.setFphone(user.getFphone());
			w.setWorkstate(user.getWorkstate());
			w.setOrgtype(user.getOrgtype());
			w.setSfzid(user.getSfzid());
			w.setDuty(user.getDuty());
			w.setDutydetails(user.getDutydetails());
		
			outList.add(w);
		}
		return outList;
	}
	
	
	
	
	

}