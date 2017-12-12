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
<table id="tableType">
<a id="btn" href="javascript:addTableType()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">新增类型</a>  
</table>
<script type="text/javascript">
	$(function(){
		seachetabletype();
	})
	function seachetabletype(){
		//---
		$("#tableType").datagrid({    
		    url:'<%=basePath%>/tables/queryTablesType.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		    singleSelect:true,
		    checkOnSelect:false,
		    selectOnCheck:false,
// 		    queryParams:{
// 		    	tablename:$("#tablename").val(),
// 		    	typeid:$("#select-type").val(),
// 		    	strattime:$("#d4311").val(),
// 		    	endtime:$("#d4312").val(),
// 		    },

			 toolbar: [{
				text:'批量删除',
				iconCls: 'icon-remove',
				handler: function(getChecked){
					
					var arrs = $('#tableType').datagrid('getChecked');
					var row = $('#tableType').datagrid('getChecked');
					var index = $('#tableType').datagrid('getRowIndex', row);
					if (row){
						$.messager.confirm('删除', '确定要删除吗？',  function(getChecked){if (row){
						var ids="";
						for (var i = 0; i < arrs.length; i++) {
							ids +=","+arrs[i].tabletypeid
					}
					oid=ids.substr(1);
					$.ajax({       //ajax请求删除结果
                        type: "post",
                        url: '<%=basePath%>/tables/deleteTableTypeAll.action',
                        data: { "tabletypeid": oid},
//                         dataType: "json",
                        async: false,
                        success: function (data) {
//                             debugger;ssss
                            $.messager.alert("提示!", "删除成功！");
                            $('#tableType').datagrid('reload'); 
                        },
                        error: function (data, XMLHttpRequest, textStatus, errorThrown) {
                            $.messager.alert("提示!", "异常错误");
                            $('#tableType').datagrid('reload'); 
                        }
                    });
				}});
					
					}
				}
			}],
		    columns:[[ 
		              
 		        {field:'ches',title:'',width:50,checkbox:true}, 
		        {field:'tabletypename',title:'表格类型名称',width:200},
		        {field:'typestate',title:'类型说明',width:200},
		        {field:'tablecount',title:'可查看人员数量',width:200},
		        {field:'opti',title:'操作',width:100,
		        	  formatter:function(value,rec){  
		        		 // 
		                  var btn = '<a class="deletes" href="javascript:deleteTableType(\''+rec.tabletypeid+'\')"></a>'
		                  ;  
		                  return btn;  
		              }  
		        }  
		         
		    ]] ,
		    onLoadSuccess:function(data){  
		        $('.deletes').linkbutton({text:'',plain:true,iconCls:'icon-remove'}); 
		    } 
		}); 
	};
	function addTableType(){
		
		$('#tabs').tabs('add',{    
		    title:'新增表格类型',    
		    href: "<%=request.getContextPath()%>/tables/toAddTableType.action"
		 }); 
<%-- 		location.href="<%=request.getContextPath()%>/tables/toAddTableType.action"; --%>
	}
	function deleteTableType(tid){
		$.ajax({
			url:"<%=basePath%>/tables/deleteTableType.action",
			type:"post",
			dataType:"json",
			data:{"tabletypeid":tid},
			success:function(data){
			 $('#tableType').datagrid('reload');
			}
		});
	}
	</script>	
</body>
</html>