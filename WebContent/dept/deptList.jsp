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

<script type="text/javascript" src="../cssGroup/bootstrap2/js/jquery.js"></script>
<script type="text/javascript" src="../cssGroup/bootstrap2/js/bootstrap.min.js"></script>


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
			  	<div class='content '>
			  		<h3 style='text-align:left'>部门清单</h3> 
			  		<div class='handle' style='padding-top:10px;float:right;' >   
				  		 <div class="btn-group">
			                <button class="btn dropdown-toggle" data-toggle="dropdown">其它操作 <span class="caret"></span></button>
			                <ul class="dropdown-menu">
			                  <li class="divider"></li> 
			                  <li><a href="${ctx}/dept/navAdjustDeptOrder.do">调整部门排序</a></li>
			                  <li class="divider"></li> 
			                  <li><a href="#">显示删除部门(未完成)</a></li> 
			                </ul>
			              </div><!-- /btn-group -->
					  		
			  			<button type="button" class="btn btn-primary" style='margin-left:30px' onclick="{location.href='${ctx}/dept/navAddDept.do';}">新建部门</button> 
			  		</div>
			  		<div class='table bs-docs-example' style='width:60% ;height:30px;padding-top:10px;'>
			  			<h4>部门数量 :<span class="badge badge-info">${allDeptCount}</span>&nbsp&nbsp&nbsp&nbsp 总人数:<span class="badge badge-info">xx</span></h4>
			  		</div>
					<div class='table bs-docs-example' style='padding-top:10px;'>
				  		<table class="table table-hover">
				  			<thead>   
					  			<tr> 
									<th>#</th>
									<th>部门</th>
									<th>人数</th>
									<th>负责人</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${deptList}" var="temp">
								<tr>
									<th>${temp.snum }</th>
									<td>${temp.deptname }</td>
									<td>${temp.peoples } </td>
									<td>${temp.monitor }</td>
									<td><a href="${ctx}/dept/navEditDept.do?deptid=${temp.id}">修改<span class="label"></span></a>  </td>
									<td>详情 </td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
			  	</div><!-- end content -->
			  </div><!-- end right area -->
		</div>
		<div class="row">
			  <%@ include file="/includes/footer.jsp"%>
		</div>
</div><!-- end container -->

</body>
</html>
