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

<form id="adduser-form">
			用户名:<input class="easyui-textbox" onblur="checkName()" id="username" name="username" style="width:300px">
				<span id="msg"></span>
			<br>
					
			问题1:<select id="key1-select" >
						<option value="0">请选择问题</option> 	
						<option value="1">你的生日</option> 	 
						<option value="2">姓名</option> 	 
						<option value="3">配偶</option> 						 
					</select>
					<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="easyui-textbox" id="key1-1" style="width:300px"><br>
			问题2:<select id="key2-select">
					<option value="0">请选择问题</option> 	 
					<option value="1">你的生日</option> 	 
					<option value="2">姓名</option> 	 
					<option value="3">配偶</option> 	 
				</select>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="easyui-textbox" id="key2-1" style="width:300px"><br>
			问题3:<select id="key3-select" >
					<option value="0">请选择问题</option>
					<option value="1">你的生日</option> 	 
					<option value="2">姓名</option> 	 
					<option value="3">配偶</option>  	 
				</select>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="easyui-textbox" id="key3-1" style="width:300px"><br>
				<p>
				<p>
				<p>
				<p>
				<p>
				<p>
				<p>
				<center>
				 	<a class="easyui-linkbutton" data-options="iconCls:'icon-save'"   
			        onclick="javascript:saveUser()">保存</a>
			        <a class="easyui-linkbutton" data-options="iconCls:'icon-no'"   
			        onclick="javascript:saveUsers()">关闭</a>
			        </center>
		</form>
		<script type="text/javascript">
		function checkName(){
			var checkName = $("#username").val();
			var msg = $("#msg").val();
			$.ajax({
				url:"<%=basePath%>/user/checkName.action",
//	 			data:$("#adduser-form").serialize(),
				data:{"checkName":username},
				type:"post",
				dataType:"json",
				success:function(data){
					if(data=="checkNameError"){
//	 					alert("用户名不存在!")
						msg.innerHTML="<font color='red'>用户名正确!</font>";
					}
				},
				error:function(){
				}
			}) 
			
		}
			function saveUser(){
				var username= $("#username").val();
				var userpwd= $("#userpwd").val();
				var usermobile =$("#usermobile").val();
				
				var key1 = $("#key1-select").val();
				var key1s = $("#key1-1").val();
				var key2 = $("#key2-select").val();
				var key2s = $("#key2-1").val();
				var key3 = $("#key3-select").val();
				var key3s = $("#key3-1").val();
				if(key1=="1"){
					var keyone =key1s;
				}else if(key1=="2"){
					var keytow =key1s;
				}else if(key1=="3"){
					var keytrhree =key1s;
				}
				if(key2=="1"){
					var keyone =key2s;
				}else if(key2=="2"){
					var keytow =key2s;
				}else if(key2=="3"){
					var keytrhree =key2s;
				}
				if(key3=="1"){
					var keyone =key3s;
				}else if(key3=="2"){
					var keytow =key3s;
				}else if(key3=="3"){
					var keytrhree =key3s;
				}
		 		$.ajax({
					url:"<%=basePath%>/user/updateUserLock.action",
	//	 			data:$("#adduser-form").serialize(),
					data:{"username":username,"keyoneStr":keyone,"keytow":keytow,"keytrhree":keytrhree},
					type:"post",
					dataType:"json",
					success:function(data){
						$('#clearUserLock-dialog').dialog('close'); 
					},
					error:function(){
						alert("解锁失败!")
					}
				}) 
			}
		</script>
</body>
</html>