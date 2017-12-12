<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="rsgwUpdate" method="post">
		<table>
		<input type="hidden" name="ryId" value="${rygwjbxx.ryId}">
		  <tr>
			<td>员工名称</td>
			<td>
				
				<input type="text" name="ryName" value="${rygwjbxx.ryName}">
			</td>
		  </tr>
		  <tr>
			<td>出生时间</td>
			<td>
				<input type="text" name="ryCsrq" value="${rygwjbxx.ryCsrq}">
			</td>
		  </tr>
		  <tr>
			<%-- <td>所属部门</td>
			<td>
				<select name="ygGzEmp">
					<option value="${rygwjbxx.ryId}">${rygwjbxx.ygGzEmp}</option>
				</select>
			</td> --%>
		  </tr>
		  
		  </table>
	</form>
	<script type="text/javascript">
		<%-- $.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/RygwtreeController/queryZuTree.action",
			success:function(){
				
			}
		}) --%>
	
	</script>
</body>
</html>