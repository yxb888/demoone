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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

	<%@ include file="/js/esyuijs.jsp"%>
</head>
<body>
<div class="easyui-panel" title="参数设置" style="width:100%;">
<form id="formset">
	<table width="100%" class="editTab" id="search">
                <tr>
                    <td align="right">添加用户时密码最短长度：</td>
                    <td align="left">
                    <input id="lostline" name="pLostline" class="easyui-numberspinner" style="width:200px;"
    required="required" data-options="min:1,max:10,editable:false">
<%--                     	<input id="userDto_sur_user_cd" name="userDto.sur_user_cd" required="required" value="${userDto.sur_user_cd}" readonly="readonly" style="width:200px;border:1px  solid #95B8E7;padding:1px;"  type="text" /> --%>
                    	<font color="red">&nbsp;&nbsp;*</font>
                    </td>
                    <td align="right">审批提示时间间隔：</td>
                    <td align="left">
                    <input id="timege" name="pTimege" class="easyui-numberspinner" style="width:200px;"
    required="required" data-options="min:1,max:10,editable:false">
<%--                     	<input id="userDto_sur_user_name" name="userDto.sur_user_name" style="width:200px;border:1px  solid #95B8E7;padding:1px;"  maxlength = "10"  value="${userDto.sur_user_name}" type="text"  data-options="required:true,validType:['lengthb[0,20]','name'] "  class="easyui-validatebox"/> --%>
                    	<font color="red">&nbsp;&nbsp;*</font>
                    </td>
				</tr>
                <tr>
                    <td align="right">添加用户初始密码：</td>
                	<td align="left">
                		<input id="cspwd" name="pCspwd" style="width:200px;border:1px  solid #95B8E7;padding:1px;" value="${userDto.tel}" type="text"  data-options="required:true,validType:['lengthb[0,15]','telPhone']"  class="easyui-validatebox"/>
                		<font color="red">&nbsp;&nbsp;*</font>               	
                	</td>
                    <td align="right">页面表格默认显示的记录行数：</td>
                    <td align="left">
                    <select id="csline" name="pCsline" style="width:200px;">
                    <option name="pCsline">50</option>
                    <option name="pCsline">100</option>
                    </select>
                    	<font color="red">&nbsp;&nbsp;*</font>
                    </td>
				</tr>
                <tr>
                	<td align="right">使用表格的图形视图默认是否显示详情页面信息：</td>
                    <td align="left">
                    <select id="xq" name="pXq" style="width:200px;">
                    <option name="pXq">是</option>
                    <option name="pXq">否</option>
                    </select>	
                    </td> 
                	  <td align="right">默认磁盘大小：</td>
                    <td align="left">
                     <input id="disk" name="pDisk" class="easyui-numberspinner" style="width:200px;"
    required="required" data-options="min:1,max:200,editable:false">
                    </td>
                </tr>
	</table>
</form>
</div>
		<div id="updateButton"   align="center">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="updatePaa()" name="relper_save" style="margin-left: 10px;">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="returnPerson_change()" name="relper_save" style="margin-left: 10px;">返回</a>
		</div>
		

<script type="text/javascript">
$(function(){

	seliet();
})
function seliet(){
		$.ajax({
			url:"cdset/selectByPrimaryKey.action",
			type:"post",
//    			dataType:"json",
   		 	async: false,
//    			data:$("#formDet").serialize(),
   			success:function(data){
//    				$.messager.alert("提示信息","查询成功！","info");
   			$("#cspwd").val(data[0].pCspwd);
   			$("#timege").val(data[0].pTimege);
   			$("#csline").val(data[0].pCsline);
   			$("#xq").val(data[0].pXq);
   			$("#disk").val(data[0].pDisk);
   			$("#lostline").val(data[0].pLostline);
   			},
   			error :function(){
   				
   				alert("cuole");
   			}
		
		});
}



function updatePaa(){

	$.ajax({
		url:"cdset/updateByPrimaryKeySelective.action",
		type:"post",
// 			dataType:"json",
		 	async: false,
			data:$("#formset").serialize(),
			success:function(data){
				$.messager.alert("提示信息","保存成功！","info");
		
			},
			error :function(){
				
				alert("cuole");
			}
	
	});
}
	
	




</script>
</body>
</html>