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
<a id="btn" href="javascript:showsField()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >显示设置</a>
		<div id="showField" style="display: none;">
			<input type="checkbox" name="evection" value="evectionsite" >出差地点
			<input type="checkbox" name="evection" value="evectionsite" >出差地点
			<input type="checkbox" name="evection" value="evectionsite" >出差地点
			<input type="checkbox" name="evection" value="evectionsite" >出差地点
			<input type="checkbox" name="evection" value="evectionsite" >出差地点
		</div>

<div id="workEvection-dialog"></div>
<table id="workevection-table"></table>
<script type="text/javascript">

	$(function(){
		seache();
	})
	function seache(){
		$("#workevection-table").datagrid({    
		    url:'<%=basePath%>/workevectioncontroller/queryWorkEvectionPage.action',  
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
				text:'批量删除',
				iconCls: 'icon-remove',
				handler: function(getChecked){
					
					var arrs = $('#workevection-table').datagrid('getChecked');
// 					var row = $('#workevection-table').datagrid('getSelected');
					var row = $('#workevection-table').datagrid('getChecked');
					var index = $('#workevection-table').datagrid('getRowIndex', row);
					if (row){
						$.messager.confirm('删除', '确定要删除吗？',  function(getChecked){if (row){
						var ids="";
						for (var i = 0; i < arrs.length; i++) {
							ids +=","+arrs[i].evectionid
					}
					oid=ids.substr(1);
					$.ajax({       //ajax请求删除结果
                        type: "post",
                        url: '<%=basePath%>/workevectioncontroller/deleteWorkEvectionAll.action',
                        data: { "evectionid": oid },
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
                            $('#workevection-table').datagrid('reload'); 
                        },
                        error: function (data, XMLHttpRequest, textStatus, errorThrown) {
                            $.messager.alert("提示!", "异常错误");
                            $('#workevection-table').datagrid('reload'); 
                        }
                    });
					}});
					}
				}
			}],
		    columns:[[    
		        {field:'che',title:'',width:50,checkbox:true},    
		        {field:'evectionsite',title:'出差地点',width:200},    
		        {field:'applycause',title:'出差事由',width:200},
		        {field:'starttime',title:'出差开始时间',width:200}, 
		        {field:'endtime',title:'出差结束时间',width:200},
		        {field:'applytime',title:'申请时间',width:200},
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
 			{field:'evectionname',title:'申请人',width:200,
			        formatter:function(value,row,index){
		                  return row.user.username;
		               }
		        },
		        {field:'sss',title:'操作',width:200,
			        formatter:function(value,row,index){
			        	var btn = '<a class="editclss" href="javascript:queryWorkEvectionById(\''+row.evectionid+'\')"></a>';  
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
// 	showColumn  显示指定的列。field
// 	hideColumn	隐藏指定的列。field
	
	
// 	查看详情
	function queryWorkEvectionById(evectionid){
		$("#workEvection-dialog").dialog({    
		    title: '查看详情',    
		    width: 500,    
		    height: 300,    
		    closed: false,    
		    cache: false,    
		    href: '<%=basePath%>/workevectioncontroller/queryWorkEvectionById.action?evectionid='+evectionid,    
		    modal: true,
		});   
		
	}
	var idss=1;
	function showsField(){
		//idss是默认奇数，当为奇数时列表展开
		if(idss==1){
			$("#showField").show();
		}else{
			if(idss%2==1){
				$("#showField").show();
			}else{
				$("#showField").hide();
			}
		}
		idss++;
	}
</script>
</body>
</html>