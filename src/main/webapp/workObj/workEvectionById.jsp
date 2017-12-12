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
	<form>
	<h3>请假明细</h3>
		<table>
			<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请人&nbsp;&nbsp;&nbsp;&nbsp;${workEvection.user.username}<br>
				</td>
			</tr>
			<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					出差开始时间&nbsp;&nbsp;&nbsp;&nbsp;${workEvection.starttime}
				</td>
			</tr>
			<tr>	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					出差结束时间&nbsp;&nbsp;&nbsp;&nbsp;${workEvection.endtime}
				</td>
			</tr>
			<tr>	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请时间&nbsp;&nbsp;&nbsp;&nbsp;${workEvection.applytime}
				</td>
			</tr>
			<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出差事由&nbsp;&nbsp;&nbsp;&nbsp;${workEvection.applycause}
				</td>
			</tr>
			<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请状态&nbsp;&nbsp;&nbsp;&nbsp;
<%-- 					${workEvection.applystate==1?'处理中':${workEvection.applystate==2?'驳回':'批准'}}  --%>
<%-- 						${workEvection.applystate==1}?'处理中':${workEvection.applystate==2}?'驳回':'批准' --%>
<%-- 						${workEvection.applystate==1?'处理中':''} --%>
						
						<input id="cspwd" style="width:200px;border:1px ;padding:1px;"  type="text"  data-options="required:true,validType:['lengthb[0,15]','telPhone']"  class="easyui-validatebox"/>
				</td>
			</tr>
		</table>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<center>
<!-- 		<a class="easyui-linkbutton" data-options="iconCls:'icon-save'"    -->
<!--         onclick="javascript:saveOrg()">保存</a> -->
		
	        <a class="easyui-linkbutton" data-options="iconCls:'icon-no'"   
	        onclick="javascript:saveOrg()">关闭</a>
        </center>    
</form>
<script type="text/javascript">
		var s=${workEvection.applystate};
		if(s==1){
			$("#cspwd").val("处理中");
		}else if(s==2){
			$("#cspwd").val("批准");
		}else{
			$("#cspwd").val("驳回");
		}
	function saveOrg(){
		$("#workEvection-dialog").dialog("close")
		
		
		
	}
</script>
</body>
</html>