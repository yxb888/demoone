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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<%@ include file="/js/esyuijs.jsp"%>
</head>
<body>
 <table id="userlist">  </table>
<div id="roledialog"></div>
<script>
$(function(){
	serch();

})

function serch(){
	$("#userlist").datagrid({    
		  url:'<%=request.getContextPath()%>/user/queryUser.action',  
	    pagination:true,
	    pageNumber:1,
	    pageSize:3,
	    pageList:[3,5,8],
	    singleSelect:true,
	    checkOnSelect:false,
	    selectOnCheck:false,
	    queryParams:{
// 	    	ryName:$("#ryName").val(),
// 	    	ygGzEmp:yggzemp,
	    },
	    columns:[[    
	              {field:'userid',title:'用户id',width:100,checkbox:true}, 
	              {field:'username',title:'用户名称',width:100}, 
	              {field:'userpwd',title:'用户密码',width:100}, 
	              {field:'usermobile',title:'用户邮箱',width:100}, 
	              {field:'',
	            	  title:'操作',
	            	  width:100,
	            		formatter: function(value,row,index){
		      	return "<input type='button' value='给角色' onclick='setRole("+row.userid+")'>";
		      			}
	           }, 
	          
	     ]],
	}); 
}
function setRole(id){
	   $("#roledialog").dialog({
		    title: '分配角色',    
		    width: 400,    
		    height: 200,    
		    closed: false,    
		    cache: false,    
		    href: '<%=request.getContextPath()%>/role/toShowRole.action?userId='+id,    
		    buttons:[{
				text:'保存',
				handler:function(){
					var data=$("#roleForm").serialize();
					$.ajax({
						url:"<%=request.getContextPath()%>/role/addUserRoleRelation.action",
						data:data+"&userid="+id,
// 						dataType:"json",
						type:"post",
						success:function(awd){
							alert(awd);
							$("#roledialog").dialog("close");
						},error:function(){
							alert("失败");
						}
						
						
						
					})
					
				}
			},{
				text:'关闭',
				handler:function(){
			$("#roledialog").dialog("close");
				}
			}]

	   })
}



</script>
</body>
</html>