<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>内部项目信息管理平台</title>
  </head>
  <a href='./dept/deptList.do'>部门</a>
	<%
	
		// response.sendRedirect("http://172.16.112.249:8085/newOA/user/showDaiBanxiangJsp.do"); 
		response.sendRedirect("./dept/navDeptList.do"); 
	
	%>
</html>
