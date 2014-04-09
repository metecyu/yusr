package com.metecyu.yusr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.metecyu.yusr.model.Dept;
import com.metecyu.yusr.model.User;
import com.metecyu.yusr.model.UserDeptRel;
import com.metecyu.yusr.service.DeptService;
import com.metecyu.yusr.service.UserService;
import com.metecyu.yusr.webmodel.WUser;

@Controller
@RequestMapping("/user") 
public class UserController extends MultiActionController{

	private static final Logger log = LogManager.getLogger(UserController.class);
	
	//入参对象
	
	@Resource
	private DeptService deptService;
	@Resource
	private UserService userService;
	
	@RequestMapping("/navUserList")
	public ModelAndView navUserList(HttpServletRequest request,HttpServletResponse response) {
		
		List<Dept> deptList = this.deptService.findAllDept();
		String deptid = request.getParameter("deptid");
		if(deptid==null || deptid.equals("") ){
			if(deptList.size()>0){
				deptid=deptList.get(0).getId();
			}
		}
		List<User> userList = userService.findDeptUser(deptid);
		Map map = new HashMap();
		List<WUser> outList  = userService.turnToWUser(userList);
		map.put("userList", outList);
		map.put("deptList", deptList);
		map.put("allDeptCount", outList.size());
		map.put("deptid", deptid);
		
		return new ModelAndView("/user/userList", map);
	}
	

	@RequestMapping("/navAddUser")
	public ModelAndView navAddUser(HttpServletRequest request,HttpServletResponse response) {
		List deptList = deptService.findAllDept();
		Map map = new HashMap();
		map.put("deptList", deptList);
		return new ModelAndView("/user/addUser", map);
	}

	@RequestMapping("/submitAddUser")
	public ModelAndView submitAddDept(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String loginid = request.getParameter("loginid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		
		String mobile = request.getParameter("mobile");
		String fjh = request.getParameter("fjh");
		String fphone = request.getParameter("fphone");
		String workstate = request.getParameter("workstate");
		
		String orgtype = request.getParameter("orgtype");
		String sfzid = request.getParameter("sfzid");
		String duty = request.getParameter("duty");
		String dutydetails = request.getParameter("dutydetails");
		String mainDeptid = request.getParameter("mainDeptid");
		
		userService.addUser(loginid, username, password, birthday, mobile, fjh, fphone, workstate, orgtype, sfzid, duty, dutydetails, mainDeptid);
		return new ModelAndView("redirect:/user/navUserList.do");

	}
	
	@RequestMapping("/navEditUser")
	public ModelAndView navEditUser(HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("userid");
		User user = userService.findById(id);
		Map map = new HashMap();
		
		List deptList = deptService.findAllDept();
		map.put("deptList", deptList);
		UserDeptRel rel = deptService.findMainUserDeptRel(id);
		map.put("user", user);
		map.put("mainDeptid", rel.getDept().getId());
		
		return new ModelAndView("/user/editUser", map);
	}
	
	@RequestMapping("/submitEditUser")
	public ModelAndView submitEditUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String loginid = request.getParameter("loginid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		
		String mobile = request.getParameter("mobile");
		String fjh = request.getParameter("fjh");
		String fphone = request.getParameter("fphone");
		String workstate = request.getParameter("workstate");
		
		String orgtype = request.getParameter("orgtype");
		String sfzid = request.getParameter("sfzid");
		String duty = request.getParameter("duty");
		String dutydetails = request.getParameter("dutydetails");
		String mainDeptid = request.getParameter("mainDeptid");
		userService.saveUser(userid, loginid, username, password, birthday, mobile, fjh, fphone, workstate, orgtype, sfzid, duty, dutydetails, mainDeptid);
		Map map = new HashMap();
		map.put("deptid", mainDeptid);
		return new ModelAndView("redirect:/user/navUserList.do", map);
	}
	
	
	@RequestMapping("/submitDelDept")
	public ModelAndView submitDelDept(HttpServletRequest request,HttpServletResponse response) {
		String userid = request.getParameter("userid");
		userService.delete(userid);
		Map map = new HashMap();
		return new ModelAndView("redirect:/user/navUserList.do", map);
	}

	
	@RequestMapping("/navAdjustDeptOrder")
	public ModelAndView navAdjustDeptOrder(HttpServletRequest request,HttpServletResponse response) {
		List deptList = this.deptService.findAllDept();
		Map map = new HashMap();
		map.put("deptList", deptList);
		return new ModelAndView("/user/adjustDeptOrder", map);
	}
	
	@RequestMapping("/submitAdjustDeptOrder")
	public ModelAndView submitAdjustDeptOrder(HttpServletRequest request,HttpServletResponse response) {
		String deptid = request.getParameter("deptid");
		String targetDeptid = request.getParameter("targetDeptid");
		
		deptService.adjustDeptOrder(deptid, targetDeptid);
		Map map = new HashMap();
		return new ModelAndView("redirect:/user/navUserList.do", map);
	}
	
	
}
