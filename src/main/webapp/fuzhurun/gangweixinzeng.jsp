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

<form id="roleForm" method="post">
    		<table align="center">
    		
    			<tr>
    				<td>岗位名称:</td>
    				<td>
    				<input class="easyui-textbox" id="tGwName" name="tGwName" data-options="iconCls:'icon-man'" style="width:150px;height:24px;">
    				</td>
    			</tr>
    			<tr>
    				<td>英文名称:</td>
    				<td><input class="easyui-textbox" type="text" id="tGwEgname" name="tGwEgname" data-options="iconCls:'icon-man'" style="width:150px"/></td>
    			</tr>
				<tr>
				<td>上级岗位:</td>
				<td><input class="easyui-textbox" type="text" id="tGwSjgw" name="tGwSjgw" data-options="buttonText:'',buttonIcon:'icon-search'" style="width:150px"/></td>
    			</tr>
    			<tr>
				<td>岗位描述:</td>
				<td><textarea  id="tGwInfo" name="tGwInfo" style="height:40px;width:200px"></textarea></td>
    			</tr>
				<tr>
    				<td>
		 <a class="easyui-linkbutton" data-options="iconCls:'icon-save'"onclick="addgangwei()">保存</a>  
<!--        <a href="javascript:saveOrg()">保存</a> -->
        
<!--         <a class="easyui-linkbutton" data-options="iconCls:'icon-no'"    -->
<!--         onclick="saveOrg()">关闭</a>  -->
						</td>
    			</tr>
    			
    		</table>
    	</form> 
    	<script type="text/javascript">
	function addgangwei(){
		$("#roleForm").form('submit',{
			url:'<%=basePath%>/gangwei/addGangWei.action',
			onSubmit: function(){ //提交之前触发的函数，一般用来进行表单验证  如果 返回值为 false，则不提交表单
				return true;
			},
			success:function(data){
// 			alert("新增成功")
// 			$("#tGwId").val("");
// 				$("#tGwName").val("");
// 				$("#tGwEgname").val("");
// 				$("#tGwSjgw").val("");
// 				$("#tGwInfo").val("");
				$('#tabs').tabs('close','岗位新增');
 			}
 		})
		 
	}

//  	$('#roleForm').form('submit',{
// 		onSubmit:function(){
// 			return true;
// 		},
// 		success:function(data){
// 			if(data){
// 				$.messager.alert('提示','新增成功','info');
// 				$('#roleForm').form('reset');
// 			}else{
// 				$.messager.alert('提示','保存失败','info');
// 			}
// 		}
// 	}) 
// })
</script>
</body>

</html>