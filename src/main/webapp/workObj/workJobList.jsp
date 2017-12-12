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
<table id="workJob-table"></table>
<script type="text/javascript">

	$(function(){
		seache();
	})
	function seache(){
		$("#workJob-table").datagrid({    
		    url:'<%=basePath%>/workjobcontroller/queryWorkJobObjPage.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		    singleSelect:true,
		    checkOnSelect:false,
		    selectOnCheck:false,
		    columns:[[    
// 		        {field:'che',title:'',width:50,checkbox:true},    
		        {field:'workid',title:'编号',width:200},    
		        {field:'workuuid',title:'工作文号',width:200},    
		        {field:'workname',title:'工作名称',width:200}, 
		        {field:'startdate',title:'开始时间',width:200},
		        {field:'enddate',title:'结束时间',width:200},
		        {field:'principal',title:'负责人',width:200,
		        	 formatter:function(value,row,index){
							return row.user.username;
		        	 }	
		        },
		        {field:'workresult',title:'处理结果',width:200,
			        formatter:function(value,row,index){
		                   switch(value){
		                       case 1: return "处理中" ;
		                       case 2 :return "处理完成" ;
		                       case 3 :return "未开始" ;
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