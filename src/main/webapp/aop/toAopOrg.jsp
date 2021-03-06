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
<div id="aop-layout" class="easyui-layout" style="width:600px;height:400px;" data-options="fit:true">   
    <div data-options="region:'west',iconCls:'icon-reload',title:'East',split:true" style="width:200px;">
    	<ul id="Aop-tree"></ul> 	
    </div>   
	 <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
	 	<div id="aop-tabs" class="easyui-tabs" data-options="fit:true">   
	    	<div title="首页" >
	    	<p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p><p>
	    		<center>
	    			<h1><font color="red">日志管理平台</font></h1>
	    		</center>
	    	</div>   
		</div> 
	 </div>   
	</div>	
	<script type="text/javascript">
		$(function(){
			$('#Aop-tree').tree({    
				url:'<%=request.getContextPath() %>/aoptreecontroller/queryTree.action',
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
				var flag = $('#aop-tabs').tabs('exists',titleStr);  
				if(flag){//true   
					$('#aop-tabs').tabs('select',titleStr);
				}else{
					// 添加一个未选中状态的选项卡面板
					 $('#aop-tabs').tabs('add',{
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