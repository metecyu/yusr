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

import com.metecyu.yusr.bmodel.UserD;
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
	
	
	// 跳转到到部门用户清单界面
	@RequestMapping("/navUserList")
	public ModelAndView navUserList(HttpServletRequest request,HttpServletResponse response) {
		List<Dept> deptList = this.deptService.findAllDept();
		String deptid = request.getParameter("deptid");
		if(deptid==null || deptid.equals("") ){
			if(deptList.size()>0){
				deptid=deptList.get(0).getId();
			}
		}
		List<UserD> userList = userService.findDeptUser(deptid);
		Map map = new HashMap();
		List<WUser> outList  = userService.turnToWUser(userList,deptid);
		map.put("userList", outList);
		map.put("deptList", deptList);
		map.put("allDeptCount", outList.size());
		map.put("deptid", deptid);
		return new ModelAndView("/user/userList", map);
	}
	
	// 跳转到新建用户界面
	@RequestMapping("/navAddUser")
	public ModelAndView navAddUser(HttpServletRequest request,HttpServletResponse response) {
		List deptList = deptService.findAllDept();
		Map map = new HashMap();
		map.put("deptList", deptList);
		return new ModelAndView("/user/addUser", map);
	}
	// 确定添加用户
	@RequestMapping("/submitAddUser")
	public ModelAndView submitAddUser(HttpServletRequest request,HttpServletResponse response) throws Exception {
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
	// 跳转到修改用户界面
	@RequestMapping("/navEditUser")
	public ModelAndView navEditUser(HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("userid");
		String deptid = request.getParameter("deptid");
		String isDisDelFromDept = "n";
		User user = userService.findById(id);
		UserDeptRel rel = deptService.findMainUserDeptRel(id);
		
		if(!deptid.equals(rel.getDept().getId())){
			isDisDelFromDept ="y";
		}
		Map map = new HashMap();
		List deptList = deptService.findAllDept();
		map.put("deptList", deptList);
		
		map.put("user", user);
		map.put("mainDeptid", rel.getDept().getId());
		map.put("deptid", deptid);
		map.put("isDisDelFromDept",isDisDelFromDept);
		
		
		return new ModelAndView("/user/editUser", map);
	}
	// 确定修改用户
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
	
	// 确定删除用户
	@RequestMapping("/submitDelUser")
	public ModelAndView submitDelUser(HttpServletRequest request,HttpServletResponse response) {
		String userid = request.getParameter("userid");
		UserDeptRel rel = deptService.findMainUserDeptRel(userid);
		userService.delete(userid);
		// User user = userService.findById(userid);
		
		
		Map map = new HashMap();
		map.put("deptid", rel.getDept().getId());
		return new ModelAndView("redirect:/user/navUserList.do", map);
	}
	// 确定删除用户
	@RequestMapping("/submitDelUserFromDept")
	public ModelAndView submitDelUserFromDept(HttpServletRequest request,HttpServletResponse response) {
		String userid = request.getParameter("userid");
		String deptid = request.getParameter("deptid");
		deptService.delUserDeptRel(deptid, userid);
		Map map = new HashMap();
		map.put("deptid", deptid);
		return new ModelAndView("redirect:/user/navUserList.do", map);
	}

	// 调整用户排序
	@RequestMapping("/navAdjustUserOrder")
	public ModelAndView navAdjustUserOrder(HttpServletRequest request,HttpServletResponse response) {
		String deptid = request.getParameter("deptid");
		List<UserD> userList = this.userService.findDeptUser(deptid);
		Map map = new HashMap();
		map.put("userList", userList);
		map.put("deptid", deptid);
		return new ModelAndView("/user/adjustUserOrder", map);
	}
	
	// 跳转到添加其他部门用户
	@RequestMapping("/navAddOhterDeptUser")
	public ModelAndView navAddOhterDeptUser(HttpServletRequest request,HttpServletResponse response) {
		
		List<Dept> deptList = this.deptService.findAllDept();
		String deptid = request.getParameter("deptid");
		String chooseDeptid = request.getParameter("chooseDeptid");
		
		if(chooseDeptid==null || chooseDeptid.equals("") ){
			if(deptList.size()>0){
				chooseDeptid=deptList.get(0).getId();
			}
		}
		List<UserD> userList = userService.findDeptUser(chooseDeptid);
		Map map = new HashMap();
		map.put("deptList", deptList);
		map.put("userList", userList);
		map.put("chooseDeptid", chooseDeptid);
		map.put("deptid", deptid);
		return new ModelAndView("/user/addOhterDeptUser", map);
	}
	
	// 跳转到添加其他部门用户
	@RequestMapping("/submitAddOhterDeptUser")
	public ModelAndView submitAddOhterDeptUser(HttpServletRequest request,HttpServletResponse response) {
		List<Dept> deptList = this.deptService.findAllDept();
		String deptid = request.getParameter("deptid");
		String userid = request.getParameter("userid");
		deptService.addNoMainDeptUser(deptid, userid);
		Map map = new HashMap();
		map.put("deptid", deptid);
		return new ModelAndView("redirect:/user/navUserList.do", map);
	}
		
		
	// 确定用户排序
	@RequestMapping("/submitAdjustUserOrder")
	public ModelAndView submitAdjustUserOrder(HttpServletRequest request,HttpServletResponse response) {
		String deptid = request.getParameter("deptid");
		String userid = request.getParameter("userid");
		String targetUserid = request.getParameter("targetUserid");
		
		deptService.adjustUserOrder(deptid,userid, targetUserid);
		Map map = new HashMap();
		return new ModelAndView("redirect:/user/navUserList.do", map);
	}
	
	
}
