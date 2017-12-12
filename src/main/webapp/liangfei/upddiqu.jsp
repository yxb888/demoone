<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<form id="upd-org-form" method="post">
	<center>
		<br><br><br><br><br>
		<h3>修改地区</h3>
	</center>
	<center>
		<input id="org-pid" name="tId" type="hidden" value="${diqu.tId}"> 
		<input id="opid" type="hidden" value="${diqu.tBeizhu}"> 
		地区名称： <input  name="tDiquname" value="${diqu.tDiquname}"><br><br>
		地区英文名：<input name="tEgName" value="${diqu.tEgName}"><br><br>
		备注：<textarea name="tBeizhu" id="asd"></textarea><br><br>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-save'"   
        onclick="javascript:updDiqu()">保存</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-no'"   
        onclick="javascript:saveOrg()">关闭</a>    
	</center>
	

</form>


<script type="text/javascript">

			var arr = document.getElementById("opid").value;
			$("#asd").val(arr)
// 			var arr1 = document.getElementsByName("tBeizhu");
// 			alert(arr1)
			
	function updDiqu(){
		$('#upd-org-form').form('submit',{    
		    url:"<%=basePath%>/diqu/updDQSave.action",    
		    onSubmit: function(){    //提交之前触发的函数，一般用来进行表单验证  如果 返回值为 false，则不提交表单
		      return true;   
		    },    
		    success:function(data){  //回调函数  
		    	
		    	$('#dialog-tab').dialog('close');
		    	$('#diqu-datagrid').datagrid('reload'); 

		    }    
		});    
	}
function saveOrg(){
		
	$('#dialog-tab').dialog('close');
		     
	 
	}

	
</script>
</body>
</html>