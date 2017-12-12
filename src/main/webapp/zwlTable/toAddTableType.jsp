<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<form id="tableTypeForm">

<div id="dd3"></div>
	<br>
	<br>
	<br>
	<br>
	<br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	<font size="5">新增表格类型</font>
	<br>
	<br>
	<br>
	<br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	类型名称：
	<input class="easyui-textbox" name="tabletypename" style="width: 300px">
	<br>
	<br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	查看人员：
	<input class="easyui-textbox" style="width: 200px" id="pactusername"
		name="tablequeryname">
	<a id="btn" href="javascript:querydia()" class="easyui-linkbutton"
		data-options="iconCls:'icon-search'"></a>
	<br>
	<br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	类型说明：
	<textarea style="width:300px;height:40px" name="typestate"></textarea>
		<input type="hidden"  id="tablecount" name="tablecount">
	<br><br><br><br>
	</form>
	
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="btn" href="javascript:addTableType()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>  
	
	<script type="text/javascript">
	$(function(){
	$('#pactusername').textbox({
		
		editable:false,//定义用户是否可以直接在该字段内输入文字
	})
})
	function querydia(){
		$('#dd3').dialog({    
		    title: '人员拾取',    
		    width: 600,    
		    height: 600,    
		    closed: false,    
		    cache: false,    
		    href: '<%=request.getContextPath()%>/zwlTable/addDialogTableType.jsp',    
		    modal: true  ,
		    buttons:[{
				text:'保存',
				handler:function(){
					
					var selected = $('#MyTable5').datagrid('getSelections');//返回所有被选中的行
					var trs = "";
					var Strs="";
					var count = 0;
					for (var i = 0; i < selected.length; i++) {
						Strs += ","+selected[i].username
						count++;
					}
					$("#tablecount").val(count)
					
					trs += Strs.substr(1)
					$('#pactusername').textbox('setValue',trs);
					$('#dd3').dialog('close');   
				}
			},{
				text:'关闭',
				handler:function(){
					$('#dd').dialog('close'); 
				}
			}]
		});  
			
	}
	//新增
	function addTableType(){
		$.ajax({
			url:'<%=request.getContextPath()%>/tables/addTableType.action',
			type:"post",
			data:$("#tableTypeForm").serialize(),
			dataType:"json",
			success:function(data){
				$('#tabs').tabs('close','新增表格类型'); 
			},
			error:function (){
				alert("失败咯")
			}
		
		});
	}
	</script>
</body>
</html>