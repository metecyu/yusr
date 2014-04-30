<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${systemName}</title> 
</head>
<link rel="stylesheet" type="text/css" href="${ctx}/cssGroup/bootstrap2/css/bootstrap-responsive.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/cssGroup/bootstrap2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/cssGroup/cust/layer.css">
<link rel="stylesheet" type="text/css" href="${ctx}/cssGroup/cust/form.css">
<script type="text/javascript" src="${ctx}/jsGroup/jquery1.10/jquery.min.js"></script>

<!-- dialog确认框 -->
<link rel="stylesheet" href="${ctx}/jsGroup/jquery-ui-1.10.2/themes/base/jquery.ui.all.css"> 
<!-- 	<script src="../jsGroup/jquery-ui-1.10.2/jquery-1.9.1.js"></script> -->
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.core.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.widget.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.mouse.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.button.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.draggable.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.position.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.button.js"></script>
<script src="${ctx}/jsGroup/jquery-ui-1.10.2/ui/jquery.ui.dialog.js"></script>

  
  
<script>
	function submitForm(){
		var form = document.form1;
		form.action='${ctx}/dept/submitEditDept.do';
		form.submit()
	}
	function submitDel(){
			var form = document.form1;
			form.action='${ctx}/dept/submitDelDept.do';
			form.submit()	
	}
	$(function(){
		$('#deptprop').val(${dept.type});
		
		
		$( "#dialog-confirm" ).dialog({
		      resizable: false,
		      autoOpen: false,
		      modal: true		      
		});
	}); 
	
	function navSubmitDel(){
		$("#dialog-confirm").dialog( "open" );  
	}


	
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
			  		<h3 style='text-align:left'>修改部门信息</h3>
			  		
		
			  		<form name='form1' method="post" class="bs-docs-example form-horizontal">
			  			<input type='hidden' name='deptid' value='${dept.id}'/>
			  			
			  
			            <div class="control-group">
			              <label for="deptname" class="control-label">部门名称</label>
			              <div class="controls">
			                <input name='deptname' type="text" placeholder="部门名称" id="deptname" value='${dept.deptname}'>
			                <button type="button" class="btn btn-danger pull-right" style='margin-left:90px' onclick='navSubmitDel()'>删除</button>
			              </div>
			              
			            </div>
			             
			            <div class="control-group">
			              <label for="wholename" class="control-label">部门全称</label>
			              <div class="controls">
			                <input name='wholename' type="text" placeholder="部门全称" id="wholename"  value='${dept.deptwholename}'>
			              </div>
			            </div>
			            
			            <div class="control-group">
			              <label for="deptprop" class="control-label">部门属性</label>
			              <div class="controls">
			                	<select id='deptprop' name='deptprop'>
					              <option value='1'>业务</option>
					              <option value='2'>服务</option>
					            </select>
			              </div>
			            </div>
			            <div class="control-group">
			              <label for="deptid" class="control-label">部门编号</label>
			              <div class="controls">
			                <label for="deptid" class="control-label">${dept.id}</label>
			                 
			              </div>
			            </div> 
			            
			            
			            <div class="control-group">
			              <div class="controls">
			                <button type="button" class="btn btn-primary" style='margin-left:-30px' onclick='submitForm()'>保存</button>
			                <button type="button" class="btn" style='margin-left:30px' onclick="{location.href='${ctx}/dept/navDeptList.do'}">返回</button>
			                
			                
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

<div id="dialog-confirm" title="确认框">
  	<div style='margin-top:30px;text-align:center'><h4 >是否删除？</h4></div>
  	<div style='margin-top:30px;text-align:center' > 
  		<button type="button" class="btn btn-danger" onclick='{
  			submitDel(); 
  		}'>确认删除</button> 
  		<button type="button" class="btn" style='margin-left:30px' onclick='{
  			$("#dialog-confirm").dialog( "close" );  			
  		}'>取消</button>
  	</div>
</div>



</body>
</html>
