<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="dd">
	<ul id="porg-tree"></ul>
	<table id="myTbale2"></table>
</div>
<form id="MyForms"> 
	<center>
	<br><br><br><br><br><br><br><br>
	<table>
	<tr>
		<td><h2>新增合同</h2></td>
	</tr>
	<tr>
		<td>人员姓名:</td>
		<td><input class="easyui-textbox" style="width:200px" id="bnbbb" name="pactusername" >
		<a id="btn" href="javascript:querydia()" class="easyui-linkbutton" data-options="iconCls:'icon-search'"></a> 
		</td>
	</tr>
	<tr>
		<td>合同编号:</td>
		<td><input class="easyui-textbox" style="width:200px" name="pactid"></td>
	
		<td>合同名称:</td>
		<td><input class="easyui-textbox" style="width:200px" name="pactname"></td>
	</tr>
	
		
	
	<tr>
		<td>期限类型:</td>
		<td><input type="radio" name="timetype" value="1">固定期限
		<input type="radio" name="timetype" value="0">无固定期限</td>
		
	
		
		<td>合同状态:</td>
		<td>
			<select id="cc" class="easyui-combobox" name="pactzt" style="width:200px;">   
			    <option value="1">有效</option>   
			    <option value="2">已过期</option>   
			</select>
		</td>
	</tr>
	
	<tr>
		<td>合同类别:</td>
			<td>
				<select id="cc" class="easyui-combobox" name="pacttype" style="width:200px;">   
				    <option value="1">劳动合同</option>   
				    <option value="2">正式合同</option>   
				    <option value="3">培训合同</option>   
				    <option value="4">试用期合同</option>   
				</select>
			</td>
	</tr>
	<tr>
		<td>开始日期:</td>
			<td>
				<input id="d4311" name="starttime" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2030-10-01\'}'})"/>
			</td>
			
			
			<td>结束日期:</td>
			<td>
				<input id="d4312" name="endtime" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2030-10-01'})"/>
			</td>
	</tr>
	<tr>
		<td>合同内容</td>
		<td>
			<textarea style="width:300px;height:40px" name="pactmatter"></textarea>
		</td>
	</tr>
		<tr>
		<td>合同附件</td>
		<td>
			<textarea style="width:300px;height:40px" name="pactaccessory"></textarea>
		</td>
	</tr>
	</table><br><br>
	</center>
	</form> 
	<center>
	<a id="btn" href="javascript:savePact()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">提交</a>
	<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">取消</a>
	</center> 
<script type="text/javascript">
$(function(){
	
		//$('#usernamepact').textbox('textbox').attr('readonly',true);  //设置输入框为禁用
		//$("#usernamepact").val("123")
	$('#bnbbb').textbox({
		
		editable:false,//定义用户是否可以直接在该字段内输入文字
	})
})

function querydia(){
	var bm="";
	$('#dd').dialog({    
	    title: '部门选择',    
	    width: 600,    
	    height: 600,    
	    closed: false,    
	    cache: false,    
	    href: '<%=request.getContextPath()%>/hetong/dialog.jsp',    
	    modal: true  ,
	    buttons:[{
			text:'保存',
			handler:function(){
				var selected = $('#MyTable3').datagrid('getSelected');//返回第一个被选中的行
				$('#bnbbb').textbox('setValue',selected.username);
				$('#dd').dialog('close');   
			}
		},{
			text:'关闭',
			handler:function(){
				$('#dd').dialog('close'); 
			}
		}]
	});  
		
}

function savePact(){
	$.ajax({
		url:"<%=request.getContextPath()%>/pact/addPact.action",
		type:"post",
		data:$("#MyForms").serialize(),
		dataType:"json",
		success:function(data){
			$('#tabs').tabs('close','新增合同'); 
		},
		error:function (){
			alert("失败咯")
		}
	
	});
}
</script>
</body>
</html>