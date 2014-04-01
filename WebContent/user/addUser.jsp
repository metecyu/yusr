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

<script>
	function submitAdd(){
		
		var form = document.form1;
		form.action='${ctx}/user/submitAddUser.do';
		form.submit()
	}
</script>
<body>
<!--  栅格系统示例 S -->
<!-- Bootstrap默认的栅格系统为12列 ，形成一个940px宽的容器，默认没有启用 响应式布局特性 。如果加入响应式布局CSS文件，栅格系统会自动根据可视窗口的宽度从724px到1170px进行动态调整。在可视窗口低于767px宽的情况下，列将不再固定并且会在垂直方向堆叠。 -->

  
<!-- 实际案例 E -->
<div class="container">
		<div class="row"> 
			  <div class="span12">
				  	<div class="top" style='padding:1px;'>
							<div style='color:#E4E4D0; margin-left:50px'>
								<h4>${systemName}</h4> 
							</div>
				  	</div>
			  </div>
		</div> 
		<div class="row">
			  <div class="span2">
			  		<div class='menu'>
				  		<div class="list-group">
						  <a href="#" class="list-group-item">
						    <h4 class="list-group-item-heading">用户管理</h4>
						  </a>  
						  <a href="#" class="list-group-item">
						    <h4 class="list-group-item-heading">部门管理</h4>
						  </a>
						  <a href="#" class="list-group-item">
						    <h4 class="list-group-item-heading">角色管理</h4>
						  </a>
						</div>
					</div>
			  </div><!-- end left area -->
			  
			  <div class="span10">
			  	<div class='content'>
			  		<h3 style='text-align:left'>新建部门</h3>
		
			  		<form name='form1' method="post" class="bs-docs-example form-horizontal">
			            <!-- <div class="control-group">
			              <label for="deptid" class="control-label">部门编号</label>
			              <div class="controls">
			                <input name='deptid' type="text" placeholder="部门编号" id="deptid">
			              </div>
			            </div> -->
			            <div class="control-group">
			              <label for="loginid" class="control-label">登录id</label>
			              <div class="controls">
			                <input name='loginid' type="text" placeholder="不填写可自动生成" id="loginid">
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="username" class="control-label">用户名称</label>
			              <div class="controls">
			                <input name='username' type="text" placeholder="填写用户名称" id="username">
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="password" class="control-label">密码</label>
			              <div class="controls">
			                <input name='password' type="text" placeholder="" id="password">
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="birthday" class="control-label">生日</label>
			              <div class="controls">
			                <input name=birthday type="text" placeholder="" id="birthday">
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
			              <label for="deptprop" class="control-label">部门属性</label>
			              <div class="controls">
			                	<select name='deptprop'>
					              <option value='1'>业务</option>
					              <option value='2'>服务</option>
					            </select>
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
			  <div class="span12">
			  	<div class='tail'> 2014 MetecYu </div>
			  </div>
		</div>
</div><!-- end container -->

</body>
</html>
