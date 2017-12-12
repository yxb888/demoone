<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
application.setAttribute("basePath", basePath);
%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 数据表格 -->
<!-- <input id="orname"> -->

<div id="dialog-tab"></div>
<!-- <input type="button" onclick="seache()" value="查询"> -->
<table id="log-table">
	<a id="btn" href="javascript:shows()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">高级搜索</a>
		<div id="condition" style="display: none;">
			人员名称：<input class="easyui-textbox"  id="pactusername" style="width:300px"> 
			合同名称：<input class="easyui-textbox"  id="pactname" style="width:300px"> 
			<a id="btn" href="javascript:seache()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
		</div>
		<a id="dc" href="javascript:exportgrid()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">导出数据</a>  
</table>
<div id="dd1"></div>


<script type="text/javascript">

	$(function(){
		seache();
	})
	function seache(){
		//默认隐藏条件查询div
		$("#log-table").datagrid({    
		    url:'<%=basePath%>/pact/queryPact.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		    singleSelect:true,
		    checkOnSelect:false,
		    selectOnCheck:false,
		    queryParams:{
		    	pactUserNameStr:$("#pactusername").val(),
		    	pactNameStr:$("#pactname").val(),
		    },
			 toolbar: [{
				text:'批量删除',
				iconCls: 'icon-remove',
				handler: function(getChecked){
					
					var arrs = $('#log-table').datagrid('getChecked');
// 					var row = $('#table-one').datagrid('getSelected');
					var row = $('#log-table').datagrid('getChecked');
					var index = $('#log-table').datagrid('getRowIndex', row);
					if (row){
						$.messager.confirm('删除', '确定要删除吗？',  function(getChecked){if (row){
						var ids="";
						for (var i = 0; i < arrs.length; i++) {
							ids +=","+arrs[i].pactid
					}
					oid=ids.substr(1);
					$.ajax({       //ajax请求删除结果
                        type: "post",
                        url: '<%=basePath%>/pact/deleteAll.action',
                        data: { "pactid": oid },
//                         dataType: "json",
                        async: false,
                        success: function (data) {
//                             debugger;ssss
                            $.messager.alert("提示!", "删除成功！");
                            $('#log-table').datagrid('reload'); 
                        },
                        error: function (data, XMLHttpRequest, textStatus, errorThrown) {
//                         		alert(data);
//                              alert(XMLHttpRequest.status);  
//                    			alert(XMLHttpRequest.readyState);  
//                    			alert(textStatus);  
                            $.messager.alert("提示!", "异常错误");
                            $('#log-table').datagrid('reload'); 
                        }
                    });
// 						$('#table-one').datagrid('deleteRow', index);
					}});
					
					}
				}
			}],
		    columns:[[ 
		        {field:'che',title:'',width:50,checkbox:true},    
		        {field:'pactid',title:'合同编号',width:200},
		        {field:'pactname',title:'合同名称',width:200}, 
		        {field:'pactusername',title:'人员名称',width:200},
		        {field:'pactzt',title:'合同状态',width:200,
		        	formatter:function(value,row,index){
		                 switch(value){
		                     case 1: return "有效" ;
		                     case 2 :return "过期" ;
		                 }
		             }},
		        {field:'timetype',title:'期限类型',width:200,
		        	formatter:function(value,row,index){
		                 switch(value){
		                     case 1: return "固定期限" ;
		                     case 0 :return "无固定期限" ;
		                 }
		             }},
		        {field:'pacttype',title:'合同类别',width:200,
		            	 formatter:function(value,row,index){
			                 switch(value){
			                     case 1: return "劳动合同" ;
			                     case 2 :return "正式合同" ;
			                     case 3 :return "培训合同" ;
			                     case 4 :return "试用期合同" ;
			                 }
			             }},
		        {field:'starttimeStr',title:'开始日期',width:200},
		        {field:'endtimeStr',title:'结束日期',width:200,
// 		        	formatter:function(value,row,index){
						
// 		        	}
		        },
		        {field:'opt',title:'操作',width:100,
		        	  formatter:function(value,rec){  
		        		 // 
		                  var btn = '<a class="editcls" href="javascript:updatePact(\''+rec.pactid+'\')"></a>,<a class="editclss" href="javascript:deletePact(\''+rec.pactid+'\')"></a>'
		                  ;  
		                  return btn;  
		              }  
		        }  
		    ]] ,
		    onLoadSuccess:function(data){  
		        $('.editcls').linkbutton({text:'',plain:true,iconCls:'icon-edit'}); 
		        $('.editclss').linkbutton({text:'',plain:true,iconCls:'icon-remove'}); 
		    } 
		}); 
	};
	
	function deletePact(id){
		
		$.ajax({
				url:"pact/deletePact.action",
				type:"post",
				dataType:"json",
				data:{"pactid":id},
				success:function(data){
				 $('#log-table').datagrid('reload');
				}
			});
	}
	function updatePact(id){
		$('#dialog-tab').dialog({    
		    title: '修改',    
		    width: 1000,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    href: '<%=request.getContextPath()%>/pact/updatePactById.action?pactid='+id,    
		    modal: true   
		}); 
	}
	//高级搜索
	var idss=1;
	function shows(){
		
		//idss是默认奇数，当为奇数时列表展开
		if(idss==1){
			$("#condition").show();
		}else{
			if(idss%2==1){
				$("#condition").show();
			}else{
				$("#condition").hide();
			}
		}
		idss++;
	}
	//导出数据
	function exportgrid(){
		location.href="<%=request.getContextPath()%>/pact/Exportpact.action";
	}
</script>
</body>
</html>