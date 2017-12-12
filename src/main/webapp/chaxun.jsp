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

<table id="user-dategrid"></table>
<script type="text/javascript">
	$(function(){
		seache();
	})
	function seache(){
		$("#user-dategrid").datagrid({    
		    url:'<%=basePath%>/user/queryUser.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		    singleSelect:true,
		    checkOnSelect:false,
		    selectOnCheck:false,
		    queryParams:{
		    	orname:$("#orname").val(),
		    },
		    toolbar: [{
				iconCls: 'icon-edit',
				handler: function(){
					var arrs = $('#user-dategrid').datagrid('getChecked');
					var ids="";
					for (var i = 0; i < arrs.length; i++) {
						ids +=","+arrs[i].orid
					}
						oid=ids.substr(1);
					if(arrs.length!=1){
						alert("一次只能修改一条")
					}else{
						$('#dialog-tab').dialog({    
						    title: '修改',    
						    width: 500,    
						    height: 500,    
						    closed: false,    
						    cache: false,    
						    href: '<%=request.getContextPath()%>/po/editOr.do?orid='+oid,    
						    modal: true   
						}); 
					}					
				}
			},'-',{
				iconCls: 'icon-remove',
				handler: function(getChecked){
					                   
					var arrs = $('#user-dategrid').datagrid('getChecked');
					var ids="";
					for (var i = 0; i < arrs.length; i++) {
						ids +=","+arrs[i].orid
					}
						oid=ids.substr(1);
						location.href="<%=request.getContextPath()%>/po/deleteAll.do?ids="+oid;
				}
			}],
		    columns:[[    
		        {field:'che',title:'',width:50,checkbox:true},    
		        {field:'userid',title:'用户ID',width:200},    
		        {field:'username',title:'用户名',width:200}, 
		        {field:'userpwd',title:'用户密码',width:200},
		        {field:'usermobile',title:'手机号',width:200},
// 		        {field:'orupboos',title:'上级机构',width:200},
// 		        {field:'str',title:'操作',width:200},
		    ]]    
		}); 
	};
</script>
</body>
</html>