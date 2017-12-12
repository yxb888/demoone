<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
application.setAttribute("basePath", basePath);
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%-- <form action="<%=request.getContextPath()%>/diqu/addDiqu.action" method="post"> 
	<center>
	<br><br><br><br><br><br><br><br>
	<table>
	<tr>
		<td><h2>新增地区/编辑地区</h2></td>
	</tr>
	
	<tr>
		<td>地区名称:</td>
		<td><input class="easyui-textbox" style="width:300px" name="tDiquname"></td>
	</tr>
	<tr>
		<td>地区英文名:</td>
		<td><input class="easyui-textbox" style="width:300px" name="tEgName"></td>
	</tr>
	
	<tr>
		<td>备注:</td>
		<td><textarea style="width:300px;height:40px" name="tBeizhu"></textarea> </td>
	</tr>
	</table><br><br>
	<input type="submit" >	
	<input type="reset">		
	</center>
	</form>  --%>
	
<body>
	<form id="add-org-form" method="post">
	<center>
		<br><br><br><br><br>
		<h3>新增/编辑地区</h3>
	</center>
	<center>
		<input id="org-pid" name="pid" type="hidden"> 
<!-- 		地区编号：<input class="easyui-textbox"  style="width:300px"><br> -->
		地区名称： <input  name="tDiquname"><br><br>
		地区英文名：<input name="tEgName" ><br><br>
		备注：<textarea name="tBeizhu" cols="30" rows="5" ></textarea><br><br>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-save'"   
        onclick="javascript:addDiqu()">保存</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-no'"   
        onclick="javascript:saveOrg()">关闭</a>    
	</center>
	

</form>


<script type="text/javascript">


	function addDiqu(){
		$('#add-org-form').form('submit',{    
		    url:"<%=basePath%>/diqu/addDiqu.action",    
		    onSubmit: function(){    //提交之前触发的函数，一般用来进行表单验证  如果 返回值为 false，则不提交表单
		      return true;   
		    },    
		    success:function(data){  //回调函数  
		        alert("新增成功")
		        $('#tabs').tabs('close','新增地区'); 
 		       load_tree_data_old('人事工作地区管理','diqu/queryDiqu.action');

		    }    
		});    
	}
	function saveOrg(){
		
		$('#tabs').tabs('close','新增地区'); 
	       load_tree_data_old('人事工作地区管理','diqu/queryDiqu.action');
		     
	 
	}

	
</script>
</body>
</html>