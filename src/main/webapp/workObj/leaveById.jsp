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
	<form id="add-org-form" metdod="post">
	<h3>请假明细</h3>
		<table>
			<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;申请人&nbsp;&nbsp;&nbsp;&nbsp;${workObj.user.username}<br>
				</td>
			</tr>
			<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型&nbsp;&nbsp;&nbsp;&nbsp;${workObj.leavetype}
				</td>
			</tr>
			<tr>	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					开始时间&nbsp;&nbsp;&nbsp;&nbsp;${workObj.startdate}
				</td>
			</tr>
			<tr>	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					结束时间&nbsp;&nbsp;&nbsp;&nbsp;${workObj.enddate}
				</td>
			</tr>
			<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>
					请假原因&nbsp;&nbsp;&nbsp;&nbsp;${workObj.leavecause}
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
	function saveOrg(){
		$("#work-dialog").dialog("close")
	}
</script>
</body>
</html>