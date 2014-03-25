<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<Meta http-equiv="Pragma" Content="No-cach">
<style>
.ipt{
	border:1px solid #FFCC66;
}
.subCss{
	background:url(indicator_tiny_red.gif) 100px center no-repeat;
}
td{
	word-wrap:break-word;word-break:break-all;height:25px;
}

checkbox { width:100px; height: 100px; }
radio { width:300px; height: 300px; }

body
{
    font-family:'Verdana','宋体';
    font-size:14px;
}
</style>
<link rel="stylesheet" type="text/css" href="table.css" />
<script type="text/javascript" src="../js/jquery1_7/jquery-1.7.2.js"></script>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />

</head>
<body>	
	<form action="${ctx}/cat/navHomePage.do" method="post">
		<div style='width:000px;margin-left:100px;font-size:20px'>
			<c:forEach var="item" items="${projectList}"> 
				<div style='float:left;width:450px'> 
				<input type="checkbox" name="projectIds" value = "${item.id}">${item.catname} -- ${item.projectname}
				</div>
			</c:forEach>
		</div>
		<input type="submit" value="确定" />
	</form>

</body>
</html>
