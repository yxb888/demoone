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
<!-- style="background-image:url('img/25.jpg');width: 1000px;height: 800px;display: none; -->
<div id="work-dialog">
</div> 
<!-- <div id="work-dialog" background="img/25.jpg"></div> -->
<table id="workLeave-table"></table>
<script type="text/javascript">

	$(function(){
		seache();
	})
	function seache(){
		$("#workLeave-table").datagrid({    
		    url:'<%=basePath%>/workobjcontroller/queryWorkObjPage.action',  
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
				text:'删除',
				iconCls: 'icon-remove',
				handler: function(getChecked){
					
					var arrs = $('#workLeave-table').datagrid('getChecked');
// 					var row = $('#workLeave-table').datagrid('getSelected');
					var row = $('#workLeave-table').datagrid('getChecked');
					var index = $('#workLeave-table').datagrid('getRowIndex', row);
					if (row){
						$.messager.confirm('删除', '确定要删除吗？',  
							function(getChecked){if (row){
								var ids="";
								for (var i = 0; i < arrs.length; i++) {
									ids +=","+arrs[i].workid
								}
								oid=ids.substr(1);
								$.ajax({       //ajax请求删除结果
			                        type: "post",
			                        url: '<%=basePath%>/workobjcontroller/deleteLeaveAll.action',
			                        data: { "workid": oid },
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
			                            $('#workLeave-table').datagrid('reload'); 
			                        },
			                        error: function (data, XMLHttpRequest, textStatus, errorThrown) {
			                            $.messager.alert("提示!", "异常错误");
			                            $('#workLeave-table').datagrid('reload'); 
			                        }
			                    });
							}
						});
					}
				}
			}],
		    columns:[[    
		        {field:'che',title:'',width:50,checkbox:true},    
// 		        {field:'workid',title:'假条ID',width:200},    
		        {field:'applytime',title:'申请时间',width:200}, 
		        {field:'startdate',title:'开始时间',width:200},
		        {field:'enddate',title:'结束时间',width:200},
		        {field:'leavecause',title:'请假事由',width:200},
		        {field:'leavetype',title:'请假类型',width:200,
			        formatter:function(value,row,index){
		                   switch(value){
		                       case 1: return "事假" ;
		                       case 2 :return "病假" ;
		                       case 3 :return "产假" ;
		                       case 4 :return "婚假" ;
		                       case 5 :return "年假" ;
		                       default : return "其他";
		                   }
		               }
		        },
		        {field:'applystate',title:'申请状态',width:200,
			        formatter:function(value,row,index){
		                   switch(value){
		                       case 1: return "处理中" ;
		                       case 2 :return "批准" ;
		                       case 3 :return "驳回" ;
		                       default : return "其他";
		                   }
		               }
		        },
		        {field:'sss',title:'操作',width:200,
			        formatter:function(value,row,index){
			        	var btn = '<a class="editclss" href="javascript:qurryLeaveById(\''+row.workid+'\')"></a>';  
		                return btn;  
			        }
		        },
		        
		    ]]  ,
		    onLoadSuccess:function(data){  
		        $('.editcls').linkbutton({text:'',plain:true,iconCls:'icon-edit'}); 
		        $('.editclss').linkbutton({text:'',plain:true,iconCls:'icon-large-picture'}); 
		    } 
		})
	}
	
	
// 	查看详情
	function qurryLeaveById(workid){
		$("#work-dialog").dialog({    
		    title: '查看详情',    
		    width: 500,    
		    height: 300,    
		    closed: false,    
		    cache: false,    
		    href: '<%=basePath%>/workobjcontroller/qurryLeaveById.action?workid='+workid,    
		    modal: true,
		});   
		
	}
</script>
</body>
</html>