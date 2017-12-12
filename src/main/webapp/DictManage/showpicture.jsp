<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
application.setAttribute("basePath", basePath);
%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table id="ent_shoareholder" data-options="fit:true"></table>
	<script type="text/javascript">
	$(function(){
		seache();
	});
	function seache(){
		$("#ent_shoareholder").datagrid({    
			  url:'<%=request.getContextPath()%>/cdset/queryPicture.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		  
		    singleSelect:false,
		    checkOnSelect:true,
		    selectOnCheck:false,
		    queryParams:{
// 		    	ryName:$("#ryName").val(),
// 		    	ygGzEmp:yggzemp,
		    },
		    columns:[[    
		              {field:'pId',title:'照片id',width:'20%',align:'center'}, 
		              {field:'pName',title:'照片名称',width:'20%',align:'center'}, 
		              {field:'pUrl',title:'照片地址',width:'30%',align:'center'}, 
		              {field:'pLastname',title:'上传人',width:'10%',align:'center'}, 
		              {field:'a',title:'操作', width:'10%',sortable : true,align:'center',
			      			formatter: function(value,row,index){
// 			      				if (value){
			      			    	var s = '<a href="javascript:void(0)" onclick="">下载</a>';
			      			    	return s;
// 			      		    	}
			      			}}
		            ]],
		}); 
	};


	
	
	
	
	</script>
</body>
</html>