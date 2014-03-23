package com.metecyu.yusr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.metecyu.yusr.service.DeptService;

@Controller
@RequestMapping("/dept") 
public class DeptController extends MultiActionController{

	private static final Logger log = LogManager.getLogger(DeptController.class);
	
	//入参对象
	
	@Resource
	private DeptService deptService;
	@RequestMapping("/deptList")
	public ModelAndView navChooseProject() {
		List cwTaskProjectList = deptService.findAllDept();
		Map map = new HashMap();
		map.put("deptList", cwTaskProjectList);
		return new ModelAndView("/dept/deptList", map);
	}
	
	
	
}
