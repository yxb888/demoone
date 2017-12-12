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
<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet" href="<%=basePath %>/easyui/themes/default/easyui.css" type="text/css"/>

<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet"href="<%=basePath %>/easyui/themes/icon.css" type="text/css"/>
</head>
<body class="easyui-layout">   
		<!-- 上 -->
    <div data-options="region:'north',title:'North Title',split:true,collapsible:false" style="height:100px;"></div>   
   		<!-- 下 -->
    <!-- <div data-options="region:'south',title:'South Title',split:true" style="height:100px;">2</div> -->   
    	<!-- 右 -->
    <!-- <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;">3</div> -->   
    	<!-- 左 -->
    <div data-options="region:'west',title:'West',split:false" style="width:300px;">
		<ul id="tree-show"></ul>  
    
    </div>   
    	<!-- 中 -->
    <div id="center-tab"  data-options="region:'center',title:'center title',iconCls:'icon-add'" style="padding:5px;background:#eee;">
		<div id="tt" class="easyui-tabs" data-options="fit:true">   
			    <div title="首页" style="padding:20px;display:none;">   
			    </div>   
		</div>  
    </div> 

<!-- 引入JQuery -->
<script type="text/javascript" src="<%=basePath %>/easyui/jquery.min.js"></script>

<!-- 引入EasyUI -->
<script type="text/javascript" src="<%=basePath %>/easyui/jquery.easyui.min.js"></script>

<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript" src="<%=basePath %>/easyui/locale/easyui-lang-zh_CN.js"></script>
<!-- 引入EasyUI树组件util文件 -->
<script type="text/javascript" src="<%=basePath %>/easyui/util-js.js"></script>
<!-- 引入My97插件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/my97/WdatePicker.js"></script>
	<script type="text/javascript">
	$(function(){
		$('#tree-show').tree({    
		    url:'<%=request.getContextPath() %>/tree/queryTree.action',
		    parentField:'pid',
		    onSelect: function(node){
		    	console.info(node);
// 				alert(node.text);  // 在用户点击的时候提示
				if(node.url != null && node.url != ""){
					changeTabs(node.text,node.url);
				}
			}
		});  
	})
	//根据树节点查询  添加新的tabs选项卡
		function changeTabs(titleStr,url){
			var flag = $('#tt').tabs('exists',titleStr);  
			if(flag){//true   
				$('#tt').tabs('select',titleStr);
			}else{
				// 添加一个未选中状态的选项卡面板
				 $('#tt').tabs('add',{
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