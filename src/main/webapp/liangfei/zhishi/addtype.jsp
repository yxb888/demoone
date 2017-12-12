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
	
<body>
	<form id="add-org-form3" method="post">
	<center>
		<br><br><br><br><br>
		<h3>新增/编辑类型</h3>
	</center>
	<center>
		<input id="org-pid" name="pid" type="hidden"> 
<!-- 		地区编号：<input class="easyui-textbox"  style="width:300px"><br> -->
		类型名称： <input  name="tType"><br><br>
		查看人员：<input name="tEgName" ><br><br>
		类型说明：<textarea name="tExplain" cols="30" rows="5" ></textarea><br><br>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-save'"   
        onclick="javascript:addType()">保存</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-no'"   
        onclick="javascript:saveOrg3()">关闭</a>    
	</center>
	

</form>


<script type="text/javascript">


	function addType(){
		$('#add-org-form3').form('submit',{    
		    url:"<%=basePath%>/zhishi/addType.action",    
		    onSubmit: function(){    //提交之前触发的函数，一般用来进行表单验证  如果 返回值为 false，则不提交表单
		      return true;   
		    },    
		    success:function(data){  //回调函数  
		        alert("新增成功")
		        $('#tabs').tabs('close','新增类型'); 
 		       load_tree_data_old('知识管理','zhishi/queryZhishiType.action');

		    }    
		});    
	}
	function saveOrg3(){
		
		$('#tabs').tabs('close','新增类型'); 
	       load_tree_data_old('人事工作地区管理','diqu/queryDiqu.action');
		     
	 
	}

	
</script>
</body>
</html>