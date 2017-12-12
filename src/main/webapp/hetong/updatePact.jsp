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
<form id="myForm4"> 
	<center>
	<br><br><br><br><br><br><br><br>
	<input type="hidden" name="pactid" value="${pact.pactid}">
<%-- 	<input  name="starttime" value="${pact.starttimeStr}"> --%>
<%-- 	<input  name="endtime" value="${pact.endtimeStr}"> --%>
	<table>
	<tr>
		<td><h2>新增合同</h2></td>
	</tr>
	
	<tr>
		<td>人员姓名:</td>
		<td><input class="easyui-textbox" style="width:200px" id="bnbbb" name="pactusername" value="${pact.pactusername}">
		</td>
	</tr>
	<tr>
		<td>合同名称:</td>
		<td><input class="easyui-textbox" style="width:200px" name="pactname" value="${pact.pactname}"></td>
	</tr>
	
		
	
	<tr>
		<td>期限类型:</td>
		<td><input type="radio" name="timetype" value="1" ${pact.timetype==1?'checked':''}>固定期限
		<input type="radio" name="timetype" value="0"  ${pact.timetype==0?'checked':''}>无固定期限</td>
		
	
		
		<td>合同状态:</td>
		<td>
			<select id="cc" class="easyui-combobox" name="pactzt" style="width:200px;"  >   
			    <option value="1" ${pact.pactzt==1?'selected':''}>有效</option>   
			    <option value="2" ${pact.pactzt==2?'selected':''}>已过期</option>   
			</select>
		</td>
	</tr>
	
	<tr>
		<td>合同类别:</td>
			<td>
				<select id="cc" class="easyui-combobox" name="pacttype" style="width:200px;">   
				    <option value="1" ${pact.pacttype==1?'selected':''}>劳动合同</option>   
				    <option value="2" ${pact.pacttype==2?'selected':''}>正式合同</option>   
				    <option value="3" ${pact.pacttype==3?'selected':''}>培训合同</option>   
				    <option value="4" ${pact.pacttype==4?'selected':''}>试用期合同</option>   
				</select>
			</td>
	</tr>
	<tr>
		<td>合同内容</td>
		<td>
			<textarea style="width:300px;height:40px" name="pactmatter" id="pctmatter"></textarea>
			<input type="hidden" id="pactmatter0" value="${pact.pactmatter}">
		</td>
	</tr>
		<tr>
		<td>合同附件</td>
		<td>
			<textarea style="width:300px;height:40px" name="pactaccessory" id="pactaccessory"></textarea>
			<input type="hidden" id="pactaccessory0" value="${pact.pactaccessory}">
		</td>
	</tr>
	
	</table><br><br>
	
	 </center>
	</form> 
	<center>
	<a class="easyui-linkbutton" data-options="iconCls:'icon-save'"   
        onclick="javascript:updPact()">保存</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-no'"   
        onclick="javascript:saveOrg()">关闭</a>  
       </center>
	<script type="text/javascript">
		 
		 var arr3 = document.getElementById("pactmatter0").value;
		 $("#pctmatter").val(arr3);
		 var arr4 = document.getElementById("pactaccessory0").value;
		 $("#pactaccessory").val(arr4);
		
		 
		 
		 function updPact(){
				$('#myForm4').form('submit',{    
				    url:"<%=request.getContextPath()%>/pact/updatePactType.action",    
				    onSubmit: function(){    //提交之前触发的函数，一般用来进行表单验证  如果 返回值为 false，则不提交表单
				      return true;   
				    },    
				    success:function(data){  //回调函数  
				    	
				    	$('#dialog-tab').dialog('close');
				    	$('#log-table').datagrid('reload'); 

				    }    
				});    
			}

	
		 function saveOrg(){
				
				$('#dialog-tab').dialog('close');
					     
				 
				}

	
	</script>
</body>
</html>