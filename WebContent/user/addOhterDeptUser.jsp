<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${systemName}</title>
</head>
<link rel="stylesheet" type="text/css" href="../cssGroup/bootstrap2/css/bootstrap-responsive.min.css">
<link rel="stylesheet" type="text/css" href="../cssGroup/bootstrap2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../cssGroup/cust/layer.css">
<link rel="stylesheet" type="text/css" href="../cssGroup/cust/form.css">
<script type="text/javascript" src="../jsGroup/jquery1.10/jquery.min.js"></script>

<script>


	function refreshPage(){
		// var deptid = $('#deptid').val();
		var form = document.form1;
		form.action='${ctx}/user/navAddOhterDeptUser.do';
		form.submit()
		
	}

	function submitForm(){
		var form = document.form1;
		form.action='${ctx}/user/submitAddOhterDeptUser.do';
		form.submit()
	}
	
	
	
	
	$(function(){
		$('#chooseDeptid').val('${chooseDeptid}');
	}); 

	
</script>
<body>
<!--  栅格系统示例 S -->
<!-- Bootstrap默认的栅格系统为12列 ，形成一个940px宽的容器，默认没有启用 响应式布局特性 。如果加入响应式布局CSS文件，栅格系统会自动根据可视窗口的宽度从724px到1170px进行动态调整。在可视窗口低于767px宽的情况下，列将不再固定并且会在垂直方向堆叠。 -->

  
<!-- 实际案例 E -->
<div class="container">
		<div class="row"> 
			  <%@ include file="/includes/top.jsp"%>
		</div> 
		<div class="row">
			  <%@ include file="/includes/leftmenu.jsp"%>
			  
			  <div class="span10">
			  	<div class='content'>
			  		<h3 style='text-align:left'>添加其他部门用户</h3>
			  		
		
			  		<form name='form1' method="post" class="bs-docs-example form-horizontal">
			            <input type='hidden' name='deptid' value='${deptid}'/>
			            <div class="control-group">
			              <label for="deptprop" class="control-label">部门</label>
			              <div class="controls">
			                	<select id='chooseDeptid' name='chooseDeptid'  onchange='refreshPage()'>
					              	<c:forEach items="${deptList}" var="temp">
										<option value='${temp.id}'>${temp.deptname}</option>
									</c:forEach>
					            </select>
					            	&nbsp&nbsp用户&nbsp&nbsp
					            <select id='userid' name='userid'>
					              	<c:forEach items="${userList}" var="temp">
										<option value='${temp.id}'>${temp.username}</option>
									</c:forEach>
					            </select>
					            	
			              </div>
			            </div>
			            
			             <div class="control-group">
			              
			            </div>
			            
			           
			            
			            
			            <div class="control-group">
			              <div class="controls">
			                <button type="button" class="btn btn-primary" style='margin-left:-30px' onclick='submitForm()'>确认</button>
			                <button type="button" class="btn" style='margin-left:30px' onclick="{location.href='${ctx}/user/navUserList.do'}">返回</button>
			                
			              </div>
			            </div>

			     </form>
			  	</div><!-- end content -->
			  </div><!-- end right area -->
		</div>
		<div class="row">
			  <%@ include file="/includes/footer.jsp"%>
		</div>
</div><!-- end container -->

</body>
</html>
