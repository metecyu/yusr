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

<!-- jquery  -->
<script type="text/javascript" src="${ctx}/jsGroup/jquery1.10/jquery.min.js"></script>
<!-- dialog确认框 -->
<link rel="stylesheet" href="${ctx}/jsGroup/jquery-ui-1.10.2/themes/base/jquery.ui.all.css"> 
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.core.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.widget.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.mouse.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.button.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.draggable.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.position.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.button.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.dialog.js"></script>
<!-- jquery 日期控件 -->
<script src="../jsGroup/jquery-ui-1.10.2/ui/jquery.ui.datepicker.js"></script>
<script src="../jsGroup/jquery-ui-1.10.2/ui/i18n/jquery.ui.datepicker-zh-CN.js"></script>






<script>
	function submitAdd(){
		
		var form = document.form1;
		form.action='${ctx}/user/submitAddUser.do';
		form.submit()
	}
	$(function(){
		$("#birthday").datepicker({firstDay:0});
		var oDate1 = new Date();
		$('#birthday').datepicker("setDate", oDate1 );
		
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
			  		<h3 style='text-align:left'>新建用户</h3>
		
			  		<form name='form1' method="post" class="bs-docs-example form-horizontal">
			            <!-- <div class="control-group">
			              <label for="deptid" class="control-label">部门编号</label>
			              <div class="controls">
			                <input name='deptid' type="text" placeholder="部门编号" id="deptid">
			              </div>
			            </div> -->
			            
			             <div class="control-group">
			              <label for="username" class="control-label">用户名称</label>
			              <div class="controls">
			                <input name='username' type="text" placeholder="填写用户名称" id="username">
			              </div>
			            </div>
			            <div class="control-group">
			              <label for="mainDeptid" class="control-label">部门</label>
			              <div class="controls">
			                	<select name='mainDeptid'>
					               <c:forEach items="${deptList}" var="temp">
										<option value='${temp.id}'>${temp.deptname }</option>
									</c:forEach>
					            </select>
			              </div>
			            </div>
			            
			            
			            <div class="control-group">
			              <label for="loginid" class="control-label">登录id</label>
			              <div class="controls">
			                <input name='loginid' type="text" placeholder="不填写可自动生成" id="loginid">
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="password" class="control-label">密码</label>
			              <div class="controls">
			                <input name='password' type="text" placeholder="" id="password">
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="sfzid" class="control-label">身份证</label>
			              <div class="controls">
			                <input name=sfzid type="text" placeholder="" id="sfzid">
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="birthday" class="control-label">生日</label> 
			              <div class="controls">
			                <input name='birthday' type="text" placeholder="" id="birthday" >
			               
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="mobile" class="control-label">手机</label>
			              <div class="controls">
			                <input name='mobile' type="text" placeholder="" id="mobile">
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="fjh" class="control-label">分机号</label>
			              <div class="controls">
			                <input name='fjh' type="text" placeholder="" id="fjh">
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="workstate" class="control-label">状态</label>
			              <div class="controls">
			                	<select name='workstate'>
					              <option value='1'>在职</option>
					              <option value='2'>离职</option>
					              <option value='3'>退休</option>
					            </select>
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="orgtype" class="control-label">类型</label>
			              <div class="controls">
			                	<select name='orgtype'>
					              <option value='1'>编制人员</option>
					              <option value='2'>服务人员</option>
					            </select>
			              </div>
			            </div> 
			            
			            <div class="control-group">
			              <label for="duty" class="control-label">职务名称</label>
			              <div class="controls">
			                <input name="duty" type="text" placeholder="" id="duty">
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="dutydetails" class="control-label">职务明细</label>
			              <div class="controls">
			              	<textarea name='dutydetails' id='dutydetails' placeholder="可不填写" rows="3"></textarea>
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <div class="controls">
			                <button type="button" class="btn btn-primary" onclick='submitAdd()'>保存</button>
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
