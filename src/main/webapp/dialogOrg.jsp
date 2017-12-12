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
<!-- 机构展示 -->
</head>
<body>
机构编码&nbsp;&nbsp;<input type="text" id="org1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
机构名称&nbsp;&nbsp;<input type="text" id="org2"/><br>
机构英文名称&nbsp;&nbsp;<input type="text" id="orgYWMC"/>
<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:seache()">查询</a>
<table id="table-one"></table>
<script type="text/javascript">
	$(function(){
		seache();
// 		$('#dg').showColumn('fixColumnSize', 'name'); 
	})
	function seache(){
		$("#table-one").datagrid({    
		    url:'<%=basePath%>/orgquery/queryOrgPage.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		    singleSelect:true,
		    checkOnSelect:false,
		    selectOnCheck:false,
		    queryParams:{
		    	orgBM:$("#org1").val(),
		    	orgMC:$("#org2").val(),
		    	orgYYMC:$("#orgYWMC").val(),
		    },
		    toolbar: [{
				iconCls: 'icon-edit',
				handler: function(){
					var arrs = $('#table-one').datagrid('getChecked');
					var ids="";
					for (var i = 0; i < arrs.length; i++) {
						ids +=","+arrs[i].userid
					}
						oid=ids.substr(1);
					if(arrs.length!=1){
						alert("一次只能修改一条")
					}else{
						$('#dialog-tab').dialog({    
						    title: '修改',    
						    width: 500,    
						    height: 500,    
						    closed: false,    
						    cache: false,    
						    href: '',    
						    modal: true   
						}); 
					}					
				}
			},'-',{
				text:'删除',
				iconCls: 'icon-remove',
				handler: function(getChecked){
					
					var arrs = $('#table-one').datagrid('getChecked');
// 					var row = $('#table-one').datagrid('getSelected');
					var row = $('#table-one').datagrid('getChecked');
					var index = $('#table-one').datagrid('getRowIndex', row);
					if (row){
						$.messager.confirm('删除', '确定要删除吗？',  function(getChecked){if (row){
						var ids="";
						for (var i = 0; i < arrs.length; i++) {
							ids +=","+arrs[i].orgid
					}
					oid=ids.substr(1);
					$.ajax({       //ajax请求删除结果
                        type: "post",
                        url: '<%=basePath%>/orgquery/deleteAllOrg.action',
                        data: { "orgid": oid },
                        async: false,
                        success: function (data) {
                        	$.messager.show({
                        		title:'提示！',
                        		msg:'删除成功！',
                        		timeout:1000,
                        		showType:'slide',
                        		style:{
                        			right:'',
                        			top:document.body.scrollTop+document.documentElement.scrollTop,
                        			bottom:''
                        		}
                        	});
                            $('#table-one').datagrid('reload'); 
                        },
                        error: function (data, XMLHttpRequest, textStatus, errorThrown) {
                            $.messager.alert("提示!", "异常错误");
                            $('#table-one').datagrid('reload'); 
                        }
                    });
					}});
					}
				}
			}],
		    columns:[[    
		        {field:'che',title:'',width:50,checkbox:true},    
		        {field:'orgid',title:'机构ID',width:200},    
		        {field:'orguuid',title:'机构编码',width:200}, 
		        {field:'orgname',title:'机构名称',width:200},
		        {field:'orgyingyu',title:'机构英文名称',width:200},
		        {field:'orgboos',title:'机构经理',width:200},
		        {field:'orgupboos',title:'上级机构',width:200},
		    ]]    
		}); 
	};
	function editorg(orgid){
		alert(orgid);
	}
</script>
</body>
</html>