<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>内部项目信息管理平台</title>
  </head>
  
  
  <table cellpadding="0" cellspacing="0">
          			<tr>
                       <td>部门名称</td>
                      
                   </tr>
<c:forEach items="${deptList}" var="temp">
<tr>
    <td>${temp.deptname }</td>
</tr>
</c:forEach>

</table>
                        

</html>
