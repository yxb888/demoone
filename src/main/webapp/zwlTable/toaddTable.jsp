<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="5">新增表格</font><br><br><br><br>
	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		表格名称:<input class="easyui-textbox" name="tabletypename" style="width: 300px"><br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		类型名称：<select id="select-type">
						<option value="0">请选择类型</option> 	 
					</select><br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		表格附件:<textarea id="myTextArea" name="adjunct"></textarea>	<br><br>	
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		表格说明:<textarea  name="tablestate"></textarea>
		
		
	<script type="text/javascript">

	$(function(){
		$.ajax({
			url:"<%=request.getContextPath()%>/tables/queryType.action",
			type:"post",
			dataType:"json",
			success:function(data){
				console.info(data)
				var strs="<option value='0'>--请选择--</option>";
				for (var i = 0; i < data.length; i++) {
					strs += "<option value='"+data[i].tabletypeid+"'>"+data[i].tabletypename+"</option>";
				}
				$("#select-type").html(strs)
			}
		});
	})
	
	</script>
</body>
</html>