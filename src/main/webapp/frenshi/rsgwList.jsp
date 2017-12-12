<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="rsgwcc1" class="easyui-layout" data-options="fit:true">   
    <div data-options="region:'west',title:'West',split:true" style="width:170px;">
    
    	<div id="rsgwcc2" class="easyui-layout" data-options="fit:true">   
		    <div data-options="region:'south',title:'South Title',split:true" style="height:200px;">
		    	<ul id="rsgwtt2"></ul> 
		    </div>   
		    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
		    	<ul id="rsgwtt1"></ul> 
		    </div>   
		</div> 
				  
    </div>   
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
    
    	<!-- <div id="tt2" class="easyui-tabs" data-options='fit:true'">   
		    <div title="首页" style="padding:20px;display:none;">   
		        <h1><center>欢迎光临</center></h1>   
		    </div>   
		</div> -->
		
		员工名称:<input id="ryName">
		<input type="button" onclick="rsgwdatagrid()" value="查询"/>
		
		
		<table id="rsgwdg"></table>  
		
		<div id="rsgwdg2" ></div>  

 

		

    </div>   
</div>  


<script type="text/javascript">
		$(function(){
			rsgwtt1();
			rsgwtt2();
			rsgwdatagrid();
		})
		
		function rsgwtt1(){
			$('#rsgwtt1').tree({    
			    url:'<%=request.getContextPath()%>/RygwtreeController/queryZuTree.action',
			    parentField:'pid',//实体类中父节点的属性名
			    onSelect: function(node){
			    	console.info(node);
					//alert(node.text);  // 在用户点击的时候提示
					if(node.url != null && node.url != ""){
						changeTabs(node.text,node.url);
					}
				}
			})
		}
		function rsgwtt2(){
			$('#rsgwtt2').tree({    
			    url:'<%=request.getContextPath()%>/RygwtreeController/queryRygwzutree.action',
			    parentField:'pid',//实体类中父节点的属性名
			    onSelect: function(node){
			    	console.info(node);
					//alert(node.text);  // 在用户点击的时候提示
					if(node.url != null && node.url != ""){
						changeTabs(node.text,node.url);
					}
				}
			})
		}
		
		
		
		function rsgwdatagrid(){
			$("#rsgwdg").datagrid({    
			    url:'<%=request.getContextPath()%>/RygwjbxxController/queryRygwjbxx.action',  
			    pagination:true,
			    pageNumber:1,
			    pageSize:3,
			    pageList:[3,5,8],
			    queryParams:{//条件查询
			    	ryName:$("#ryName").val(),
			    },
			    
			    columns:[[    
			              {field:'ryId',title:'员工编号',width:100,checkbox:true}, 
			              {field:'ryName',title:'员工名称',width:100}, 
			              {field:'ryCsrq',title:'出生时间',width:100}, 
			              {field:'ygGzEmp',title:'部门',width:100}, 
			              {field:'ygRzDate',title:'入职时间',width:100}, 
			              {field:'abc',title:'操作', width:80,
				      			formatter: function(value,row,index){//单元格formatter(格式化器)函数,row数组
				      				console.info(row);
				      			return "<a href='javascript:updateRsgw("+row.ryId+")' calss='asyui-linkbutton'><img src='<%=request.getContextPath()%>/easyui/themes/icons/pencil.png'></a>";
				      			}
			      		}
			            ]],
	              toolbar: [{
						iconCls: 'icon-remove',
						handler: function(){
						    var row = $('#rsgwdg').datagrid('getSelections');
						    var ids = "";
						    if(row == ""){
						    	alert("请选择至少一行");
						    }else{
						    	//console.info(row);
						    	for (var i = 0; i < row.length; i++) {
									ids += row[i].ryId+","
								}
						    	ids = ids.substr(0,ids.length-1)
						    	$.ajax({
						    		type:"post",
						    		url:"<%=request.getContextPath()%>/RygwjbxxController/deleteRygwjbxx.action",
						    		data:{'ryId':ids},
						    		dataType:'json',
						    		async:false,
						    		success:function(){
					    				alert("12")
			                            $('#rsgwdg').datagrid('reload'); 
						    		},
						    		error:function(){
						    			$('#rsgwdg').datagrid('reload');
						    		}
						    	})
						    }
						}
					},'-',{
						iconCls: 'icon-edit',
						handler: function(){
							var arrs = $('#rsgwdg').datagrid('getChecked');
							
							var ids="";
							for (var i = 0; i < arrs.length; i++) {
								ids +=","+arrs[i].ryId
							}
							//alert(ids);
								oid=ids.substr(1);
								$('#rsgwdg').dialog({    
								    title: '修改',    
								    width: 500,    
								    height: 500,    
								    closed: false,    
								    cache: false,    
								    href: '<%=request.getContextPath()%>/RygwjbxxController/toUpdateRsgw.action?ryId='+oid,    
								    modal: true,
								    buttons:[{
										text:'保存',
										handler:function(){
											$.ajax({
												type:'post',
												url:"<%=request.getContextPath()%>/RygwjbxxController/updateRsgw.action",
												data:$("#rsgwUpdate").serialize(),
												anysc:false,
												success:function(){
													alert("cheng");
													 $('#rsgwdg2').datagrid('reload');
												},
												error:function(){
													alert("shib");
													 $('#rsgwdg2').datagrid('reload');
												}
											})
										}
									},{
										text:'关闭',
										handler:function(){}
									}]
								}); 
								
						}
					}],
			}); 
		}
	
		
			//to修改
		function updateRsgw(id){
			 $('#rsgwdg2').dialog('open');
			alert(id);
			$.ajax({
				type:"post",
				url:"<%=request.getContextPath()%>/RygwjbxxController/toUpdateRsgw.action",
				data:{'ryId':id},
				dataType:'json',
				success:function(){
				},
				error:function(){
				}
			})
		}
		
		//修改
		function rsgwUpdate(){
			$('#rsgwdg2').dialog({    
			    title: '修改',    
			    width: 400,    
			    height: 200,    
			    closed: false,    
			    href: '<%=request.getContextPath()%>/RygwjbxxController/tiaodateRsgw.action',    
			    modal: true,
			    buttons:[{
					text:'保存',
					handler:function(){
						$.ajax({
							type:'post',
							url:"<%=request.getContextPath()%>/RygwjbxxController/updateRsgw.action",
							data:$("#rsgwUpdate").serialize(),
							success:function(){
								alert("cheng");
								 $('#rsgwdg2').datagrid('reload');
							},
							error:function(){
								alert("shib");
								 $('#rsgwdg2').datagrid('reload');
							}
						})
					}
				},{
					text:'关闭',
					handler:function(){}
				}]
			});    
			//$('#rsgwdg2).dialog('refresh', 'new_content.php');   

		}
		
</script>


</body>
</html>