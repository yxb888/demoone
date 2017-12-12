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

<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/easyui/themes/default/easyui.css" type="text/css"/>
<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet"href="<%=request.getContextPath()%>/easyui/themes/icon.css" type="text/css"/>
	<script language="javascript" src="<%=request.getContextPath()%>/scripts/table.js"></script>
	<script language="javascript" src="<%=request.getContextPath()%>/scripts/checkInput.js"></script>
<body class="easyui-layout">
	
	<div id="login_dia" class="easyui-dialog"   
	        data-options="closable:false, title:'找回密码', modal:true, width:280, height:200,
	        buttons:[{text:'修改',
				handler:function(){ updatePasswordMethod()}
	        }]"> 
	 <form id="get_form"> 
	 
	 邮箱：<input  placeholder="请输入邮箱" style="width: 50%" class="easyui-textbox" name="namelast" data-options="validType: 'email'" 
                            missingMessage="邮箱不能为空" invalidMessage="请输入正确的邮箱"     id="namelast"   /> 
<!-- 	   <input id="userMobile" class="easyui-textbox" data-options="prompt:'请输入手机号'"><br> -->
	<input class="easyui-linkbutton" type="button" data-options="width:100, height:28" id="btn" value="免费获取验证码" onclick="send_mobile_msg(this)" /><br>
	    验证码：<input id="user_Code"  class="easyui-textbox" data-options="prompt:'请输入验证码'"><br>
	    密码：<input id="user_Pwd" type="password" class="easyui-textbox"><br>
	 </form>
	</div>
	<script src="<%=request.getContextPath()%>/easyui/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/easyui/jquery.easyui.min.js"></script>
<script src="<%=request.getContextPath()%>/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script>
	
	$(function() {
		});
		
	
		var countdown=10; 
		function settime(target) { 
			if (countdown == 0) { 
				target.removeAttribute("disabled");    
				target.value="免费获取验证码"; 
				countdown = 10; 
			} else {
				target.setAttribute("disabled", true); 
				target.value="重新发送(" + countdown + ")"; 
				countdown--; 
				setTimeout(function() { settime(target) },1000)
			} 
		}
	
	//发送验证码
		function send_mobile_msg(target) {
			//获取手机号，手机号为空不能发送
			var namelast = $("#namelast").val();
			if (null == namelast || "" == namelast) {
				alert("请输入邮箱");
				return;
			}
// 			if (!CheckEmail("get_form","namelast") && document.getElementById("namelast").value!="") {
// 				$.messager.alert("更新用户","电子邮件格式不正确！","warning");
// 				return false;
// 			} else {
				//发送短信
				$.ajax({
					url:"user/sendEmailMethod.action",
					data:{namelast:namelast},
					dataType:"json",
					type:"post",
					success:function(data) {
						alert(data.message);
// 						alert(JSON.stringify(data));
// 						alert("发送成功");
					}
				});
				//倒计时
				settime(target);
// 			}
			
		}
	
		//找回密码
		function updatePasswordMethod() {
			//获取手机号，手机号为空不能发送
			var userMobile = $("#namelast").val();
			if (null == userMobile || "" == userMobile) {
				alert("请输入手机号");
				return;
			}
			//获取验证码
			var user_Code = $("#user_Code").val();
			if (null == user_Code || "" == user_Code) {
				alert("请输入验证码");
				return;
			}
			//获取密码
			var user_Pwd = $("#user_Pwd").val();
			if (null == user_Pwd || "" == user_Pwd) {
				alert("请输入密码");
				return;
			}
			//修改
			$.ajax({
				url:"user/updatePasswordMethod.action",
				data:{usermobile:userMobile,userImgCode:user_Code,userpwd:user_Pwd},
				dataType:"json",
				type:"post",
				success:function(data) {
					alert(data.message);
				}
			});
		}
		
		
	</script>
</body>
</html>