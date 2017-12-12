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
	<div id="dialog-tab"></div>
	<!-- 数据表格 -->
	地区名称:
	<input id="orname" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px">
	<input type="button" onclick="seache()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" value="查询">
	<table id="diqu-datagrid">
		<a id="btn" href="javascript:shows()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">高级搜索</a>
		<!-- 高级搜索的查询显示隐藏  div -->
		<div id="condition">
	英文名称：<input id="egname" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> 
		</div>  
		<a id="dc" href="javascript:exportgrid()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">导出数据</a>
		<a id="dcs" href="javascript:expwordid()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">导出word数据</a>
		
	</table>
	<script type="text/javascript">
	$(function(){
		seache();
	})
	function seache(){
		//默认隐藏条件查询div
		$("#condition").hide();

		$("#diqu-datagrid").datagrid({    
		    url:'<%=basePath%>/diqu/queryDiqu.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		  	//  singleSelect:true, 
		     //checkOnSelect:false, 
		     //selectOnCheck:false,  是否打开点击选择行 
		    queryParams:{
		    	tDiquname:$("#orname").val(),
		    	tEgName:$("#egname").val(),
		    },
		    toolbar: [{
				iconCls: 'icon-edit',
				handler: function(){
					var arrs = $('#diqu-datagrid').datagrid('getChecked');
					
					var ids="";
					for (var i = 0; i < arrs.length; i++) {
						ids +=","+arrs[i].tId
					}
					
						oid=ids.substr(1);
// 						alert(oid)
						$('#dialog-tab').dialog({    
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
				text:'删除',
				iconCls: 'icon-remove',
				handler: function(getChecked){
					
					var arrs = $('#diqu-datagrid').datagrid('getChecked');
					var row = $('#diqu-datagrid').datagrid('getChecked');
					var index = $('#diqu-datagrid').datagrid('getRowIndex', row);
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

                            $('#diqu-datagrid').datagrid('reload'); 
                        },
                        error: function (data, XMLHttpRequest, textStatus, errorThrown) {

                            $.messager.alert("提示!", "异常错误");
                            $('#diqu-datagrid').datagrid('reload'); 
                        }
                    });

					}
						});
					
					}
					}
			}],
		    columns:[[    
		       
		        {field:'tId',title:'地区编号',width:50,checkbox:true},    
		        {field:'tDiquname',title:'地区名称',width:200},    
		        {field:'tEgName',title:'英文名称',width:200},
		        {field:'tBeizhu',title:'备注',width:200},
		        {field:'cRyid',title:'操作',width:100,formatter:function(value,rows,index){
					   return '<a href="javascript:deleteOne(\''+rows.tId+'\')">删除</a> ';
				   }}
		        
		    ]]    
		}); 
	};
		function  removeOne(id){
			alert(1)
			$.ajax({
			url:'<%=request.getContextPath()%>/diqu/deleteOne.action',
			type:'post',
			data:{
				tId:id
			},
			dataType:'json',
			success:function(data){
			 if (data==true) {
				 $("diqu-datagrid").datagrid('load')
			}
				
				
			}
		})
		}
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
                    $('#diqu-datagrid').datagrid('reload'); 
                },
                error: function (data, XMLHttpRequest, textStatus, errorThrown) {
                    $.messager.alert("提示!", "异常错误");
                    $('#diqu-datagrid').datagrid('reload'); 
                }
            });
		}
		//高级搜索     隐藏div
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
			location.href="<%=request.getContextPath()%>/diqu/Exportpact.action";
		}
		//导出word数据
		function expwordid(){
			location.href="<%=request.getContextPath()%>/diqu/exportApplyForm.action";
		}


</script>
</body>
</html>