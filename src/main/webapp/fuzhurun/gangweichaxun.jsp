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
<div id="upd-dialog"></div>
<table id="gangwei-dategrid"></table>
<script type="text/javascript">
	$(function(){
		seache();
	})
	function seache(){
		$("#gangwei-dategrid").datagrid({ 
		    url:'<%=basePath%>/gangwei/selectGangWei.action',  
 		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		    singleSelect:true,
		    checkOnSelect:false,
		    selectOnCheck:false,
		    queryParams:{
		    	orname:$("#orname").val(),
		    },
		    toolbar: [{
				iconCls: 'icon-edit',
				handler: function(){
					var arrs = $('#gangwei-dategrid').datagrid('getChecked');
					var ids="";
					for (var i = 0; i < arrs.length; i++) {
						ids +=","+arrs[i].tGwId
					}
						oid=ids.substr(1);
					
						$('#upd-dialog').dialog({    
						    title: '修改',    
						    width: 500,    
						    height: 500,    
						    closed: false,    
						    cache: false,    
						    href: '<%=request.getContextPath()%>/gangwei/updateGangWei.action?tGwId='+oid,    
						    modal: true   
						}); 
					}					
				
			},'-',{
				iconCls: 'icon-remove',
				handler: function(getChecked){
					                   
					var rows = $('#gangwei-dategrid').datagrid('getChecked');
					if(rows == null || rows.length <= 0){
						$.messager.alert('提示','请选择需要删除的数据','warning')
					}else{
						$.messager.confirm('提示','你真的要删除吗？',function(r){
							if(r){
								var ids = "";
								for (var i = 0; i < rows.length; i++) {
									ids += ids == "" ? rows[i].tGwId : ","+rows[i].tGwId;
								}
								$.ajax({
									url:'<%=basePath%>/gangwei/delAllGangWei.action',
									type:'post',
									data:{
										'ids':ids
									},
									dataType:'json',
									success:function(data){
										seache();
									}
								})
							}
						})
					}
				}
			}],
    columns:[[    
        {field:'tGwId',title:'ID',checkbox:true},    
       /*  {field:'headImg',title:'头像',width:'10%',formatter:function(value,row,index){
        	return "<img width='50px' height='50px' src='"+value+"'/>";
        }}, */
       /*  {field:'loginNumber',title:'账号',width:'10%'},   */  
        {field:'tGwName',title:'岗位名称'},
        {field:'tGwEgname',title:'英文名称'},
        {field:'tGwSjgw',title:'上级岗位'},
        {field:'tGwInfo',title:'岗位描述'},
        {field:'tGwFzr',title:'负责人'},
        /* {field:'sex',title:'性别',width:'3%',formatter:function(value,row,index){
        	return value == 1 ? "男":"女";
        }},
        {field:'email',title:'邮箱',width:'10%'},
        {field:'registerTime',title:'开号时间',width:'12%'},
        {field:'ulevel',title:'等级',width:'5%',formatter:function(value,row,index){
        	return value <=8 ? "<b><font color='red'>vip"+value+"</font></b>":"<b><font color='gold'>svip"+(value-8)+"</font></b>";
        }},
        {field:'showDeptName',title:'部门',width:'10%'},
        {field:'status',title:'状态',width:'5%',formatter:function(value,row,index){
        	return value == 0 ? "正常":"<font color='red'>冻结</font>";
        }},*/
        {field:'abc',title:'操作',formatter:function(value,row,index){
        	return row.status == 0 ? "<a href='javascript:lock(\""+row.id+"\");'>冻结</a>":"<a href='javascript:unlock(\""+row.id+"\");'>解冻</a>";
        }} 
    ]]    
});  
	};
/* //删除
 function delUser(){
	var rows = $('#gangweiList').datagrid('getChecked');
	if(rows == null || rows.length <= 0){
		$.messager.alert('提示','请选择需要删除的数据','warning')
	}else{
		$.messager.confirm('提示','你真的要删除吗？',function(r){
			if(r){
				var ids = "";
				for (var i = 0; i < rows.length; i++) {
					ids += ids == "" ? rows[i].id : ","+rows[i].id;
				}
				$.ajax({
					url:'../user/deleteUserByIds.do',
					type:'post',
					data:{
						'ids':ids
					},
					dataType:'json',
					success:function(data){
						searchUser();
					}
				})
			}
		})
	}
}  */
</script>
</html>