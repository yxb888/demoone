<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="cc" class="easyui-layout" style="width:600px;height:400px;" data-options="fit:true">   
    <div data-options="region:'west',iconCls:'icon-reload',title:'East',split:true" style="width:200px;">
    	<ul id="MyTrees"></ul> 	
    </div>   
	 <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
	 	<table id="MyTable3"></table> 
	 </div>   
	</div>	
	<script type="text/javascript">
	var names="";
	$(function (){
			queryte();
		})
	function queryte(){
		
		
		$('#MyTrees').tree({    
		    url:'<%=request.getContextPath() %>/pact/queryPactTree.action',
		    parentField:'pid',
		    radio:true,

		    onSelect: function(node){
				console.info(node.text);
		    	 names = node.text;
		    	 queryOrgs(names);
			}
			}); 
	}
	function queryOrgs(names){
		
		$("#MyTable3").datagrid({    
		    url:'<%=request.getContextPath()%>/pact/queryOrgsPage.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		   
		    queryParams:{
		    	bmstr:names,
		    },
		    columns:[[    
		        {field:'username',title:'姓名',width:100},    
		        {field:'empid',title:'工号',width:100}, 
		        {field:'bm',title:'部门',width:300},
		    ]] 
		});
		
	}
	</script>
</body>
</html>