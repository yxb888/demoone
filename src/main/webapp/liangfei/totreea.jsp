<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src="easyui/jquery.min.js"></script>
<script src="easyui/jquery.easyui.min.js"></script>
<script src="easyui/locale/easyui-lang-zh_CN.js"></script>

<script src="zTree/js/jquery.ztree.all.min.js"></script>
<link href="easyui/themes/default/easyui.css" rel="stylesheet">
<link href="easyui/themes/icon.css" rel="stylesheet">
<link href="zTree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">


<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet" href="<%=basePath %>/easyui/themes/default/easyui.css" type="text/css"/>

<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet"href="<%=basePath %>/easyui/themes/icon.css" type="text/css"/>
</head>

<body>

<div id="cc" class="easyui-layout" data-options="fit:true">   

    <div data-options="region:'west',title:'West',split:true" style="width:140px;">
    	<div id="treeDemo" class="ztree"></div>
    </div>   
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>   
</div>  


	<script type="text/javascript">
	var setting = {
			data: {
				simpleData: {
					enable: true,
				    pIdKey:"pid",
				    idKey:"id",
				}
			}
	};
	
	$(document).ready(function(){
          
		$.ajax({
			url:"<%=request.getContextPath()%>/treea/queryTreea.action",
			dataType:"json",
			type:"post",
			success:function(zNodes){
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			},
			error:function(){
				alert("查询失败");
			}
			
		})
		
	});
	</script>
</body>
</html>