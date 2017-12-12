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

<table id="aop-table"></table>
<script type="text/javascript">
	$(function(){
		seache();
	})
	function seache(){
		$("#aop-table").datagrid({    
		    url:'<%=basePath%>/aops/queryAopPage.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		    singleSelect:true,
		    checkOnSelect:false,
		    selectOnCheck:false,
// 		    queryParams:{
// 		    	orname:$("#orname").val(),
// 		    },
		    columns:[[    
		        {field:'che',title:'',width:50,checkbox:true},    
		        {field:'id',title:'编号',width:200},    
		        {field:'method',title:'请求方法',width:100}, 
		        {field:'paramVal',title:'请求参数',width:300},
		        {field:'returnval',title:'返回值',width:600},
		        {field:'implUrl',title:'实现类',width:300},
		        {field:'cztime',title:'操作时间',width:100},
		    ]]    
		}); 
	};
</script>
</body>
</html>
