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
		<ul class="easyui-tree">   
		    <li>   
		        <span>人力资源</span>   
		        <ul>   
		            <li>   
		                <span>组织机构</span>   
		                <ul>   
		                    <li>   
		                        <span><a href="javascript:queryJg('<%=request.getContextPath()%>/user/tiao.action','用户查询')">用户查询</a></span>   
		                    </li>   
		                     <li>   
		                        <span><a href="javascript:queryJg('<%=request.getContextPath()%>/po/toAdd.do','机构管理')">机构管理</a></span>   
		                    </li>   
		                    <li>   
		                        <span><a href="javascript:queryJg('<%=request.getContextPath()%>/log/tiao.do','日志记录')">日志记录</a></span>   
		                    </li>   
		                 </ul>
		              </li>
		       </ul>                   
		</ul>  
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
	<script type="text/javascript">
		function queryJg(uri,titleStr){
			var flag = $('#tt').tabs('exists',titleStr);
			
			if(flag){
				$('#tt').tabs('select', titleStr);  
			}else{
				$('#tt').tabs('add',{
					title: titleStr,
					selected: true,
					href:uri,
					closable:true,
					iconCls:"icon-ok"
				});
			}
		}
	</script>
		
</body>
</html>