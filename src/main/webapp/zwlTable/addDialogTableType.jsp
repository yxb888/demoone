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
<div id="cc1" class="easyui-layout" style="width:600px;height:400px;" data-options="fit:true">   
    <div data-options="region:'west',iconCls:'icon-reload',title:'East',split:true" style="width:200px;">
    	<!--accordion手风琴-->
	    		<div id="aa" class="easyui-accordion" data-options="fit:true">   
				    <div title="按部门选择">
				    	<!--tree树形菜单-->
				    		<ul id="treeBm"></ul>  
				    </div>   
				    <div title="按角色选择">
				    	<div id="treeEmps">
				    	</div>  
				    </div>   
				 	
    </div>   
	</div>
	<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
	 	<table id="MyTable5"></table> 
	 </div> 
</div>	
	<script type="text/javascript">
		$(function(){
			queryBms();
			queryEmps();
		})
		function queryBms(){
			$('#treeBm').tree({    
			    url:'<%=request.getContextPath() %>/tables/queryBms.action',
			    parentField:'pid',
			    radio:true,
			    onSelect: function(node){
					console.info(node.text);
			    	 names = node.text;
			    	 queryTableAll(names);
				}
				}); 
		}
		
		function queryEmps(){
			$.ajax({
				url:"<%=basePath%>/tables/queryEmps.action",
				type:"post",
				dataType:"json",
				success:function(data){
					console.info(data)
					var strs="";
					for (var i = 0; i < data.length; i++) {
						strs += "<input type='button' value='"+data[i].username+"' style='width:200px;height:30px;' onclick='queryTableOne("+data[i].username+")'><br>"
					}
					$("#treeEmps").html(strs)
				}
			});
		}
		function queryTableOne(username){
			$("#MyTable5").datagrid({    
			    url:'<%=request.getContextPath()%>/pact/queryOrgsPage.action',  
			    pagination:true,
			    pageNumber:1,
			    pageSize:3,
			    pageList:[3,5,8],
			   
			    queryParams:{
			    	usernameStr:username,
			    },
			    columns:[[    
			        {field:'username',title:'姓名',width:100},    
			        {field:'empid',title:'工号',width:100}, 
			        {field:'bm',title:'部门',width:300},
			    ]] 
			});
			
		}
		function queryTableAll(names){
			$("#MyTable5").datagrid({    
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