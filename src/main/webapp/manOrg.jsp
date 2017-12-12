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
<!-- 机构管理展示 -->
</head>
<body>
机构编码&nbsp;&nbsp;<input type="text" id="org1"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
机构名称&nbsp;&nbsp;<input type="text" id="org2"/><br>
机构英文名称&nbsp;&nbsp;<input type="text" id="orgYWMC"/>
<!-- 条件查询按钮 -->
<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:seache()">查询</a>
<br>
<table id="oeg-datagrid"></table>
<script type="text/javascript">
	$(function(){
		seache();
	})
	function seache(){
		$("#oeg-datagrid").datagrid({    
		    url:'<%=basePath%>/orgquery/queryOrgManPage.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		    singleSelect:true,
		    checkOnSelect:false,
		    selectOnCheck:false,
		    queryParams:{
		    	orgBM:$("#org1").val(),
		    	orgMC:$("#org2").val(),
		    	orgYYMC:$("#orgYWMC").val(),
		    },
		    columns:[[    
// 		        {field:'che',title:'',width:50,checkbox:true}, 
		        {field:'orgid',title:'机构ID',width:200},    
		        {field:'orguuid',title:'机构编码',width:200}, 
		        {field:'orgname',title:'机构名称',width:200},
		        {field:'orgyingyu',title:'机构英文名称',width:200},
		        {field:'orgboos',title:'机构经理',width:200},
		        {field:'orgupboos',title:'上级机构',width:200},
		    ]]    
		}); 
	}
</script>
</body>
</html>