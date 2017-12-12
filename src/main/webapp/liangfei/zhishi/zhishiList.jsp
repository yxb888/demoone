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
	知识标题:
	<input id="tTitle" class="easyui-textbox"  style="width:100px">
	关键字:
	<input id="tKeyword" class="easyui-textbox"  style="width:100px">
	<!-- 查询按钮 -->
	<input type="button" onclick="seache()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" value="查询">
	<!-- 表格 -->
	<table id="zhishi-datagrid">
		<a id="btn" href="javascript:shows()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">高级搜索</a>
		<!-- 高级搜索的查询显示隐藏  div -->
		<div id="condition">
	发布时间：           	<input id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2030-10-01\'}'})"/> --
				<input id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2030-10-01'})"/><br>
	类型名称：<select id="select-type">
						<option value="0">请选择类型</option> 	 
					</select>
		</div>  
		<a id="dc1" href="javascript:exportgrid()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">导出数据</a>
	</table>
	<script type="text/javascript">
	$(function(){
		seache();
	})
	function seache(){
		//默认隐藏条件查询div
		$("#condition").hide();

		$("#zhishi-datagrid").datagrid({    
		    url:'<%=basePath%>/zhishi/queryZhishi.action',  
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
				iconCls: '',
				handler: function(){
					var arrs = $('#zhishi-datagrid').datagrid('getChecked');
					
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
				
				iconCls: '',
				handler: function(getChecked){
					
					var arrs = $('#zhishi-datagrid').datagrid('getChecked');
					var row = $('#zhishi-datagrid').datagrid('getChecked');
					var index = $('#zhishi-datagrid').datagrid('getRowIndex', row);
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

                            $('#zhishi-datagrid').datagrid('reload'); 
                        },
                        error: function (data, XMLHttpRequest, textStatus, errorThrown) {

                            $.messager.alert("提示!", "异常错误");
                            $('#zhishi-datagrid').datagrid('reload'); 
                        }
                    });

					}
						});
					
					}
					}
			}], 
		    columns:[[    
		       
		       // {field:'tId',title:'编号',width:50,checkbox:true},    
		        {field:'tTitle',title:'知识标题',width:100},    
		        {field:'tTypeName',title:'类型名称',width:100,formatter:function(value,row,index){
		        		// return  row.主表里面声明从表.从表两者关联字段
		        	return row.ziyuanzhishitype.tType;

           		  }
				},
		        {field:'tKeyword',title:'关键字',width:100},
		        {field:'tIssur',title:'发布人',width:100},
		        {field:'tReleasetimeStr',title:'发布时间',width:150},
		        {field:'tFujianNumber',title:'附件数',width:100},
		        /* {field:'cRyid',title:'操作',width:100,formatter:function(value,rows,index){
					   return '<a href="javascript:deleteOne(\''+rows.tId+'\')">删除</a> ';
				   }} */
		        
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
				 $("zhishi-datagrid").datagrid('load')
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
                    $('#zhishi-datagrid').datagrid('reload'); 
                },
                error: function (data, XMLHttpRequest, textStatus, errorThrown) {
                    $.messager.alert("提示!", "异常错误");
                    $('#zhishi-datagrid').datagrid('reload'); 
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
			location.href="<%=request.getContextPath()%>/zhishi/Exportpact2.action";
		}
		$.ajax({
			url:"<%=basePath%>/tables/queryType.action",
			type:"post",
			dataType:"json",
			success:function(data){
				console.info(data)
				var strs="<option value='0'>--请选择--</option>";
				for (var i = 0; i < data.length; i++) {
					strs += "<option value='"+data[i].tabletypeid+"'>"+data[i].tabletypename+"</option>";
				}
				$("#select-type").html(strs)
			}
		});
	
</body>
</html>