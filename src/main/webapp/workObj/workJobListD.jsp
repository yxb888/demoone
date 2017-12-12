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
<table id="workJobdaiban-table"></table>
<script type="text/javascript">

	$(function(){
		seache();
	})
	function seache(){
		$("#workJobdaiban-table").datagrid({    
		    url:'<%=basePath%>/workjobcontroller/queryWorkJobObjDPage.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		    singleSelect:true,
		    checkOnSelect:false,
		    selectOnCheck:false,
// 		    queryParams:{
// 		    	orgBM:$("#org1").val(),
// 		    	orgMC:$("#org2").val(),
// 		    	orgYYMC:$("#orgYWMC").val(),
// 		    },
		    toolbar: [{
// 				iconCls: 'icon-edit',
// 				handler: function(){
// 					var arrs = $('#workJobdaiban-table').datagrid('getChecked');
// 					var ids="";
// 					for (var i = 0; i < arrs.length; i++) {
// 						ids +=","+arrs[i].workid
// 					}
// 						oid=ids.substr(1);
// 					if(arrs.length!=1){
// 						alert("一次只能修改一条")
// 					}else{
// 						$('#dialog-tab').dialog({    
// 						    title: '修改',    
// 						    width: 500,    
// 						    height: 500,    
// 						    closed: false,    
// 						    cache: false,    
// 						    href: '',    
// 						    modal: true   
// 						}); 
// 					}					
// 				}
// 			},'-',{
// 				text:'删除',
// 				iconCls: 'icon-remove',
// 				handler: function(getChecked){
					
// 					var arrs = $('#workJobdaiban-table').datagrid('getChecked');
// // 					var row = $('#workJobdaiban-table').datagrid('getSelected');
// 					var row = $('#workJobdaiban-table').datagrid('getChecked');
// 					var index = $('#workJobdaiban-table').datagrid('getRowIndex', row);
// 					if (row){
// 						$.messager.confirm('删除', '确定要删除吗？',  function(getChecked){if (row){
// 						var ids="";
// 						for (var i = 0; i < arrs.length; i++) {
// 							ids +=","+arrs[i].workid
// 					}
// 					oid=ids.substr(1);
// 					$.ajax({       //ajax请求删除结果
//                         type: "post",
<%--                         url: '<%=basePath%>/orgquery/deleteAllOrg.action', --%>
//                         data: { "workid": oid },
//                         async: false,
//                         success: function (data) {
//                         	$.messager.show({
//                         		title:'提示！',
//                         		msg:'删除成功！',
//                         		timeout:1000,
//                         		showType:'slide',
//                         		style:{
//                         			right:'',
//                         			top:document.body.scrollTop+document.documentElement.scrollTop,
//                         			bottom:''
//                         		}
//                         	});
//                             $('#workJobdaiban-table').datagrid('reload'); 
//                         },
//                         error: function (data, XMLHttpRequest, textStatus, errorThrown) {
//                             $.messager.alert("提示!", "异常错误");
//                             $('#workJobdaiban-table').datagrid('reload'); 
//                         }
//                     });
// 					}});
// 					}
// 				}
			}],
		    columns:[[    
// 		        {field:'che',title:'',width:50,checkbox:true},    
		        {field:'workserial',title:'流水号',width:200},    
		        {field:'workserialtype',title:'流程类型',width:200,
			        formatter:function(value,row,index){
		                   switch(value){
		                       case 1: return "开发" ;
		                       case 2 :return "测试" ;
		                       default : return "其他";
		                   }
		               }
		        },
		        {field:'workname',title:'工作名称/文号',width:200}, 
		        {field:'initiator',title:'发起人',width:200,
		        	 formatter:function(value,row,index){
						return row.user.username;
		        	 }	
		        },
// 		        {field:'workresult',title:'处理结果',width:200,
// 			        formatter:function(value,row,index){
// 		                   switch(value){
// 		                       case 1: return "处理中" ;
// 		                       case 2 :return "处理完成" ;
// 		                       case 3 :return "未开始" ;
// 		                       default : return "其他";
// 		                   }
// 		               }
// 		        },
// 		        {field:'applystate',title:'申请状态',width:200,
// 			        formatter:function(value,row,index){
// 		                   switch(value){
// 		                       case 1: return "处理中" ;
// 		                       case 2 :return "批准" ;
// 		                       case 3 :return "驳回" ;
// 		                       default : return "其他";
// 		                   }
// 		               }
// 		        },
// 		        {field:'sss',title:'操作',width:200,
// 			        formatter:function(value,row,index){
// 			        	var btn = '<a class="editclss" href="javascript:qurryLeaveById(\''+row.workid+'\')"></a>';  
// 		                return btn;  
// 			        }
// 		        },
		        
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