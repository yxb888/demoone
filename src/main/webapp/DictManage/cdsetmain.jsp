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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<%@ include file="/js/esyuijs.jsp"%>
</head>
<body>
<div id="rsgwcc1" class="easyui-layout" data-options="fit:true"> 
<div data-options="region:'west',title:'West',split:true" style="width:170px;">

<u id="rsgwtt1"></u>
</div>
 <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
<div style="margin:20px 0;"></div>
<div style="margin:20px 0"></div>
	<input id="ryName">
		<input type="button" onclick="seache()" value="查询"/>
	<select  onchange="change()" id="userDto_default_org" name="userDto.default_org" value="" class="easyui-combotree" data-options="" style="width:205px;border:1px  solid #95B8E7;padding:1px"></select>
	
<%-- 	<input class="easyui-combotree" onchange="" data-options="url:'<%=request.getContextPath()%>/RygwtreeController/queryZuTree.action',method:'get',required:true"  --%>
<!-- 	style="width: 200px"/> -->
<!-- 		<tr> -->
<!-- 			<td>Start Date:</td> -->
<!-- 			<td> -->
<!-- 				<input class="easyui-datebox" data-options="sharedCalendar:'#cc'"> -->
<!-- 			</td> -->
<!-- 			<td>End Date:</td> -->
<!-- 			<td> -->
<!-- 				<input class="easyui-datebox" data-options="sharedCalendar:'#cc'"> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
<!-- 	<div id="cc" class="easyui-calendar"></div> -->
<!-- <div id="" data-options="fit:true"></div> -->
<table id=ent_shoareholder style="height: 90%"></table>
</div>
</div>

<script>
$(function(){
	var yggzemp=null;
	seache(yggzemp);
	
// 	function rsgwtt1(){
		$('#rsgwtt1').tree({    
		    url:'<%=request.getContextPath()%>/RygwtreeController/queryZuTree.action',
		    parentField:'pid',//实体类中父节点的属性名
		    onSelect: function(node){
		    	console.info(node);
// 				alert(node.text);  // 在用户点击的时候提示
				seache(node.text);
				
				if(node.url != null && node.url != ""){
					changeTabs(node.text,node.url);
				}
			}
		})
// 	}

		$("#userDto_default_org").combotree({
			url:"<%=request.getContextPath()%>/RygwtreeController/queryZuTreeOnse.action",
			onLoadSuccess:function(data){
				$("#userDto_default_org").combotree('setValue','请选择.');
			},
			onClick: function(node){

                alert(11);  

       }
		});

})


function change(){
	
	
	alert(11);
}
function seache(yggzemp){
	$("#ent_shoareholder").datagrid({    
		  url:'<%=request.getContextPath()%>/RygwjbxxController/queryRygwjbxx.action',  
	    pagination:true,
	    pageNumber:1,
	    pageSize:3,
	    pageList:[3,5,8],
	  
	    singleSelect:false,
	    checkOnSelect:true,
	    selectOnCheck:false,
	    queryParams:{
	    	ryName:$("#ryName").val(),
	    	ygGzEmp:yggzemp,
	    },
	    toolbar: [{
				text:'修改',
			iconCls: 'icon-edit',
			handler: function(){
				var arrs = $('#ent_shoareholder').datagrid('getChecked');
				var ids="";
				for (var i = 0; i < arrs.length; i++) {
					ids +=arrs[i].userid
				}
					oid=ids.substr(1);
				if(arrs.length!=1){
					alert("一次只能修改一条")
				}else{
					$("#dictlist").hide();
					$("#update").show();
					$("#add").hide();
					$("#updateabiaoqian").show();
					$("#addButton").hide();
					$("#updateButton").show();
					
					var arrs = $('#ent_shoareholder').datagrid('getChecked');
//						alert(arrs[0].dictId);
					$.ajax({
						url:"dict/selectupdate.action",
						data:{"dictId":arrs[0].dictId},
						dataType:"json",
						success:function(data){
							$("#namelastupdate").val(data[0].dicttree.tDictLeaf);
							$("#ENT_NAME_ENupdate").val(data[0].dicttree.tDictText);
							$("#ENT_LINKMANupdate").val(data[0].dicttree.tDictEnname);
							$("#memoupdate").text(data[0].dicttree.tText);
							$("#dictidupdate").val(data[0].dicttree.tDictId);
							$("#pidupdate").val(data[0].dicttree.tDictPid);
							$("#codedupdate").val(data[0].dicttree.tDictCode);
						}
						
						
					})
				}					
			}
		}
		],
	    columns:[[    
	              {field:'ryId',title:'员工编号',width:100,checkbox:true}, 
	              {field:'ryName',title:'员工名称',width:100}, 
	              {field:'ryCsrq',title:'出生时间',width:100}, 
	              {field:'ygGzEmp',title:'部门',width:100}, 
	              {field:'ygRzDate',title:'入职时间',width:100}, 
	              {field:'ygForm',title:'已使用M/剩余M', width:300,
		      			formatter: function(value,row,index){
		      				if (value){
		      			    	var s = '<div style="width:100%;border:1px solid #ccc">' +
		      			    			'<div style="width:' + value + '%;background:#cc0000;color:#fff">' + value + '%' + '</div>'
		      			    			'</div>';
		      			    	return s;
		      		    	} else {
		      		    		
		      			    	return '';
		      		    	}
		      			}
	      		}
	            ]],
	}); 
};







</script>









</body>
</html>