<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
	application.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 弹框 -->
	<div id="dialog-tabZ"></div>
	<!-- 表格 -->
	<table id="table-one3">
		<a id="btn" href="javascript:shows()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">高级搜索</a>
		<!-- 高级搜索的查询显示隐藏  div -->
		<div id="condition3">
	类型名称：<input id="egname" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:100px"> 
	类型说明：<input id="egname" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:100px"> 
		<input type="button" onclick="seache()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" value="查询">
		
		</div>  
	</table>
	<script type="text/javascript">
	$(function(){
		seache();
	})
	function seache(){
		//默认隐藏条件查询div
		$("#condition3").hide();

		$("#table-one3").datagrid({    
		    url:'<%=basePath%>/zhishi/queryZhishiType.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		  	//  singleSelect:true, 
		     //checkOnSelect:false, 
		     //selectOnCheck:false,  是否打开点击选择行 
		    queryParams:{
		    	tTitle:$("#tTitle").val(),
		    	tKeyword:$("#tKeyword").val(),
		    },
		    toolbar: [{
		    	text:'新增类型',
		    	iconCls: 'icon-add',
				handler: function(){
						var flag = $('#tabs').tabs('exists','新增类型');  
						if(flag){//true   
							$('#tabs').tabs('select','新增类型');
						}else{
							// 添加一个未选中状态的选项卡面板
							 $('#tabs').tabs('add',{
								//title 选项卡面板的身份标识
								title:'新增类型',
								selected: true,
								href:"liangfei/zhishi/addtype.jsp",
								closable:true,
								iconCls:"icon-ok"
							}); 		
						}

					}					
			},'-',{
		    	text:'修改',
				iconCls: 'icon-edit',
				handler: function(){
					var arrs = $('#table-one3').datagrid('getChecked');
					
					var ids="";
					for (var i = 0; i < arrs.length; i++) {
						ids +=","+arrs[i].tId
					}
					
						oid=ids.substr(1);
// 						alert(oid)
						$('#dialog-tabZ').dialog({    
						    title: '修改',    
						    width: 500,    
						    height: 500,    
						    closed: false,    
						    cache: false,    
						    href: '<%=request.getContextPath()%>/diqu/updateDiqu.action?tId='+oid,    
						    modal: true   
						}); 
					}					
			},'-',{
			   	text:'',
				iconCls: 'icon-edit',
				iconCls: '',
				handler: function(getChecked){
					
					var arrs = $('#table-one3').datagrid('getChecked');
					var row = $('#table-one3').datagrid('getChecked');
					var index = $('#table-one3').datagrid('getRowIndex', row);
					if (row){
						$.messager.confirm('删除', '确定要删除吗？',  function(getChecked){if (row){
						var ids="";
						for (var i = 0; i < arrs.length; i++) {
							ids +=","+arrs[i].tId
					}
					oid=ids.substr(1);
					$.ajax({       //ajax请求删除结果
                        type: "post",
                        url: '<%=basePath%>/diqu/deleteAll.action',
                        data: { "tId": oid },
//                         dataType: "json",
                        async: false,
                        success: function (data) {
//                             debugger;ssss
                            $.messager.show({
                            	title:'提示!',
                            	msg:'删除成功',
                            	timeout:1000,
                            	showType:'slide',
                            	style:{
                            		right:'',
                            		top:document.body.scrollTop+document.documentElement.scrollTop,
                            		bottom:''
                            	}

                            });

                            $('#table-one3').datagrid('reload'); 
                        },
                        error: function (data, XMLHttpRequest, textStatus, errorThrown) {

                            $.messager.alert("提示!", "异常错误");
                            $('#table-one3').datagrid('reload'); 
                        }
                    });

					}
						});
					
					}
					}
			}], 
		    columns:[[    
		       
		       // {field:'tId',title:'编号',width:50,checkbox:true},    
		        {field:'tType',title:'类型名称',width:100},    
		        {field:'tExplain',title:'类型说明',width:100},    
		        {field:'tCount',title:'可查看人员数量',width:100},    
		    /*     {field:'cRyid',title:'操作',width:50,formatter:function(value,rows,index){
					   return '<a href="javascript:deleteOne(\''+rows.tId+'\')">删除</a> ';
				   }} */
		    ]]    
		}); 
	};
		
		function deleteOne(tId){
			$.ajax({       //ajax请求删除结果
                type: "post",
                url: '<%=basePath%>/diqu/deleteAll.action',
                data: { "tId": tId },
                async: false,
                success: function (data) {
                    $.messager.show({
                    	title:'提示!',
                    	msg:'删除成功',
                    	timeout:1000,
                    	showType:'slide',
                    	style:{
                    		right:'',
                    		top:document.body.scrollTop+document.documentElement.scrollTop,
                    		bottom:''
                    	}
                    });
                    $('#table-one3').datagrid('reload'); 
                },
                error: function (data, XMLHttpRequest, textStatus, errorThrown) {
                    $.messager.alert("提示!", "异常错误");
                    $('#table-one3').datagrid('reload'); 
                }
            });
		}
		//高级搜索     隐藏div
		var idss=1;
		function shows(){
			
			//idss是默认奇数，当为奇数时列表展开
			if(idss==1){
				$("#condition3").show();
			}else{
				if(idss%2==1){
					$("#condition3").show();
				}else{
					$("#condition3").hide();
				}
			}
			idss++;
		}

</body>
</html>