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

<form id="updateForm" method="post">
    		<table align="center">
    	
    			<tr>
    				<td>岗位名称:</td>
    				<td>
    				 <input id="id" name="tGwId"type="hidden" value="${gw.tGwId}"/> 
    				    <input id="opid" type="hidden" value="${gw.tGwInfo}"/> 
    				<input class="easyui-textbox" value="${gw.tGwName}" id="tGwName" name="tGwName" >
    				</td>
    			</tr>
    			<tr>
    				<td>英文名称:</td>
    				<td><input class="easyui-textbox" value="${gw.tGwEgname}" type="text" id="tGwEgname" name="tGwEgname" /></td>
    			</tr>
				<tr>
				<td>上级岗位:</td>
				<td><input class="easyui-textbox" type="text" id="tGwSjgw" value="${gw.tGwSjgw}" name="tGwSjgw" /></td>
    			</tr>
    			<tr>
				<td>岗位描述:</td>
				<td><textarea  id="tGwInfo" name="tGwInfo"  ></textarea></td>
    			</tr>
				<tr>
    				<td>
		 <a class="easyui-linkbutton" onclick="upgangwei()">保存</a>  
						</td>
    			</tr>
    			
    		</table>
    	</form> 
    	<script type="text/javascript">
    	
    	var arr = document.getElementById("opid").value;
		$("#tGwInfo").val(arr)
    	
	function upgangwei(){
		$("#updateForm").form('submit',{
			url:'<%=basePath%>/gangwei/updateDQSave.action',
			onSubmit: function(){ //提交之前触发的函数，一般用来进行表单验证  如果 返回值为 false，则不提交表单
				return true;
			},
			success:function(data){
				$('#upd-dialog').dialog('close');
		    	$('#gangwei-dategrid').datagrid('reload'); 

 			}
 		})
		 
	}

 
</script>
</body>

</html>