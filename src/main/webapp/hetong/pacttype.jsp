<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table id="MyTable5">
</table>
	<script type="text/javascript">
	 $(function(){
		searces();
	}) 
	function searces(){
		$("#MyTable5").datagrid({    
		    url:'<%=request.getContextPath()%>/pact/queryPactType.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
// 		    queryParams:{
// 		    	method:$("#methods").val(),
// 		    	starttime:$("#d4311").val(),
// 		    	endtime:$("#d4312").val(),
// 		    },			 
				toolbar: [{
				text:'批量删除',
				iconCls: 'icon-remove',
				handler: function(getChecked){
					
					var arrs = $('#MyTable5').datagrid('getChecked');
					var row = $('#MyTable5').datagrid('getChecked');
					var index = $('#MyTable5').datagrid('getRowIndex', row);
					if (row){
						$.messager.confirm('删除', '确定要删除吗？',  function(getChecked){if (row){
						var ids="";
						for (var i = 0; i < arrs.length; i++) {
							ids +=","+arrs[i].pacttypeid
					}
					oid=ids.substr(1);
					$.ajax({       //ajax请求删除结果
                        type: "post",
                        url: '<%=request.getContextPath()%>/pact/deletePactTypeAll.action',
                        data: { "pacttypeid": oid },
//                         dataType: "json",
                        async: false,
                        success: function (data) {
//                             debugger;ssss
                            $.messager.alert("提示!", "删除成功！");
                            $('#MyTable5').datagrid('reload'); 
                        },
                        error: function (data, XMLHttpRequest, textStatus, errorThrown) {
//                         		alert(data);
//                              alert(XMLHttpRequest.status);  
//                    			alert(XMLHttpRequest.readyState);  
//                    			alert(textStatus);  
                            $.messager.alert("提示!", "异常错误");
                            $('#MyTable5').datagrid('reload'); 
                        }
                    });
					}});
					
					}
<%-- 						location.href="<%=request.getContextPath()%>/po/deleteAll.do?ids="+oid; --%>
				}
			}],

				
		    columns:[[    
		        {field:'pacttypename',title:'类别名称',width:400},    
		        {field:'pacttypeaccess',title:'类别描述',width:400}, 
		        {field:'opts',title:'操作',width:100,
		        	  formatter:function(value,rec){  
		                  var btn = '<a class="editclss" href="javascript:deletePactType(\''+rec.pacttypeid+'\')"></a>'
		                  ;  
		                  return btn;  
		              }  
		        }  
		    ]]  ,
		    onLoadSuccess:function(data){  
		        $('.editcls').linkbutton({text:'',plain:true,iconCls:'icon-edit'}); 
		        $('.editclss').linkbutton({text:'',plain:true,iconCls:'icon-remove'}); 
		    }  
		}); 
	}
		function deletePactType(id){
			
			$.ajax({
					url:"pact/deletePactType.action",
					type:"post",
					dataType:"json",
					data:{"pacttypeid":id},
					success:function(data){
							  $('#MyTable5').datagrid('reload');
					}
				});
		}
		
		
	
</script>
</body>
</html>