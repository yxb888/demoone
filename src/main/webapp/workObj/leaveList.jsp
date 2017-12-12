<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
application.setAttribute("basePath", basePath);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 机构layout布局   左右分 -->
<!-- 右侧tabs选项卡 -->
</head>
<body >   
<div id="workObj-id" class="easyui-layout" style="width:600px;height:400px;" data-options="fit:true">   
    <div data-options="region:'west',title:'East',split:false" style="width:200px;">
    	<ul id="workTree-ree"></ul> 	
    </div>   
	 <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
	 	<div id="workObj-dialog" class="easyui-tabs" data-options="fit:true">   
	    	<div title="首页" >
	    	<p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p>
	    		<center>
	    			<h1><font color="red">工作管理平台</font></h1>
	    		</center>
	    	</div>   
		</div> 
	 </div>   
	</div>	
	<script type="text/javascript">
		$(function(){
			$('#workTree-ree').tree({    
				url:'<%=request.getContextPath() %>/worktreecontroller/queryTree.action',
			    parentField:'pid',
			    onSelect: function(node){
			    	console.info(node);
//	 				alert(node.text);  // 在用户点击的时候提示
					if(node.url != null && node.url != ""){
						changeTabs(node.text,node.url);
					}
				}
			});  
		})
		//根据树节点查询  添加新的tabs选项卡
			function changeTabs(titleStr,url){
				var flag = $('#workObj-dialog').tabs('exists',titleStr);  
				if(flag){//true   
					$('#workObj-dialog').tabs('select',titleStr);
				}else{
					// 添加一个未选中状态的选项卡面板
					 $('#workObj-dialog').tabs('add',{
						//title 选项卡面板的身份标识
						title:titleStr,
						selected: true,
						href:"<%=request.getContextPath()%>/"+url,
						closable:true,
						iconCls:"icon-ok"
					}); 		
				}
			}
	</script>
</body>
</html>