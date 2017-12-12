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
<!--  -->
<a id="btn" href="javascript:showsTable()" class="easyui-linkbutton" data-options="iconCls:'icon-search'" >高级搜索</a>
		<div id="conditions" style="display: none;">
			表格名称：<input class="easyui-textbox"  id="tablename" style="width:300px"> &nbsp;&nbsp;&nbsp;
			类型名称：<select id="select-type">
						<option value="0">请选择类型</option> 	 
					</select>
					<br>
		<input id="d4311" class="Wdate" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'d4312\')||\'2030-10-01\'}'})"/> --
		<input id="d4312" class="Wdate" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'d4311\')}',maxDate:'2030-10-01'})"/>
			<a id="btn" href="javascript:seachetable()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
		</div>
<table id="tableTable">
	
</table>
<script type="text/javascript">

	$(function(){
		seachetable();
//		$("#conditions").hide();
	})
	function seachetable(){
		//默认隐藏条件查询div
		
		//---
		$("#tableTable").datagrid({    
		    url:'<%=basePath%>/tables/queryTables.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		    singleSelect:true,
		    checkOnSelect:false,
		    selectOnCheck:false,
		    queryParams:{
		    	tablename:$("#tablename").val(),
		    	typeid:$("#select-type").val(),
		    	strattime:$("#d4311").val(),
		    	endtime:$("#d4312").val(),
		    },

			 toolbar: [{
				text:'批量删除',
				iconCls: 'icon-remove',
				handler: function(getChecked){
					
					var arrs = $('#tableTable').datagrid('getChecked');
					var row = $('#tableTable').datagrid('getChecked');
					var index = $('#tableTable').datagrid('getRowIndex', row);
					if (row){
						$.messager.confirm('删除', '确定要删除吗？',  function(getChecked){if (row){
						var ids="";
						for (var i = 0; i < arrs.length; i++) {
							ids +=","+arrs[i].tableid
					}
					oid=ids.substr(1);
					$.ajax({       //ajax请求删除结果
                        type: "post",
                        url: '<%=basePath%>/tables/deleteTableAll.action',
                        data: { "tableid": oid },
//                         dataType: "json",
                        async: false,
                        success: function (data) {
//                             debugger;ssss
                            $.messager.alert("提示!", "删除成功！");
                            $('#tableTable').datagrid('reload'); 
                        },
                        error: function (data, XMLHttpRequest, textStatus, errorThrown) {
                            $.messager.alert("提示!", "异常错误");
                            $('#tableTable').datagrid('reload'); 
                        }
                    });
					}});
					
					}
				}
			}],
		    columns:[[ 
		              
		        {field:'ches',title:'',width:50,checkbox:true},    
		        {field:'tablename',title:'表格名称',width:200},
		        {field:'typeid',title:'表格类型',width:200,
		        	 formatter:function(value,row,index){
						return row.tabletype.tabletypename;
		        	 }	
		        },
		        {field:'creater',title:'创建人',width:200},
		        {field:'createtimeStr',title:'创建时间',width:200},
		        {field:'adjunct',title:'附件数',width:200},
		        {field:'opti',title:'操作',width:100,
		        	  formatter:function(value,rec){  
		        		 // 
		                  var btn = '<a class="deletes" href="javascript:deleteTable(\''+rec.tableid+'\')"></a>'
		                  ;  
		                  return btn;  
		              }  
		        }  
		         
		    ]] ,
		    onLoadSuccess:function(data){  
		        $('.deletes').linkbutton({text:'',plain:true,iconCls:'icon-remove'}); 
		    } 
		}); 
	};

	//高级搜索
	var idss=1;
	function showsTable(){
		//idss是默认奇数，当为奇数时列表展开
		if(idss==1){
			$("#conditions").show();
		}else{
			if(idss%2==1){
				$("#conditions").show();
			}else{
				$("#conditions").hide();
			}
		}
		idss++;
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
	}
	
	
	function deleteTable(tid){
		$.ajax({
			url:"<%=basePath%>/tables/deleteTable.action",
			type:"post",
			dataType:"json",
			data:{"tableid":tid},
			success:function(data){
			 $('#tableTable').datagrid('reload');
			}
		});
	}

	</script>
</body>
</html>