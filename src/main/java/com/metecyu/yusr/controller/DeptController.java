package com.metecyu.yusr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.metecyu.yusr.model.Dept;
import com.metecyu.yusr.service.DeptService;
import com.metecyu.yusr.webmodel.WDept;

@Controller
@RequestMapping("/dept") 
public class DeptController extends MultiActionController{

	private static final Logger log = LogManager.getLogger(DeptController.class);
	
	//入参对象
	
	@Resource
	private DeptService deptService;
	@RequestMapping("/navDeptList")
	public ModelAndView navDeptList(HttpServletRequest request,HttpServletResponse response) {
		List deptList = deptService.findAllDept();
		Map map = new HashMap();
		List<WDept> outList  = deptService.turnToWDept(deptList);
		map.put("deptList", outList);
		map.put("allDeptCount", outList.size());
		return new ModelAndView("/dept/deptList", map);
	}
	

	@RequestMapping("/navAddDept")
	public ModelAndView navAddDept(HttpServletRequest request,HttpServletResponse response) {
		List deptList = deptService.findAllDept();
		Map map = new HashMap();
	
		return new ModelAndView("/dept/addDept", map);
	}

	@RequestMapping("/submitAddDept")
	public ModelAndView submitAddDept(HttpServletRequest request,HttpServletResponse response) throws BadHanyuPinyinOutputFormatCombination {
		String deptid = request.getParameter("deptid");
		String deptname = request.getParameter("deptname");
		String wholename = request.getParameter("wholename");
		String deptprop = request.getParameter("deptprop");
		deptService.addDept(deptname, wholename, deptprop);
		return new ModelAndView("redirect:/dept/navDeptList.do");
		//return navDeptList(request,response);
	}
	
	@RequestMapping("/navEditDept")
	public ModelAndView navEditDept(HttpServletRequest request,HttpServletResponse response) {
		String deptid = request.getParameter("deptid");
		Dept dept = deptService.findById(deptid);
		Map map = new HashMap();
		map.put("dept", dept);
		return new ModelAndView("/dept/editDept", map);
	}
	
	@RequestMapping("/submitEditDept")
	public ModelAndView submitEditDept(HttpServletRequest request,HttpServletResponse response) {
		String deptid = request.getParameter("deptid");
		String deptname = request.getParameter("deptname");
		String wholename = request.getParameter("wholename");
		String deptprop = request.getParameter("deptprop");
		Dept dept = deptService.findById(deptid);
		deptService.saveDept(deptid, deptname, wholename, deptprop);
		Map map = new HashMap();
		map.put("dept", dept);
		return new ModelAndView("redirect:/dept/navDeptList.do", map);
	}
	
	
	@RequestMapping("/submitDelDept")
	public ModelAndView submitDelDept(HttpServletRequest request,HttpServletResponse response) {
		String deptid = request.getParameter("deptid");
		deptService.delete(deptid);
		Map map = new HashMap();
		return new ModelAndView("redirect:/dept/navDeptList.do", map);
	}

	
	
}
