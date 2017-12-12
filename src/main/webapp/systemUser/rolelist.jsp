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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="editRoleForm">
 <table id="rolelist">  </table>
 </form>
 <input id="roleid" type="hidden"/>
<div id="roledialog"></div>
<div id="w" class="easyui-window" title="Modal Window" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:300px;height:500px;padding:10px;">
		<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center'" style="padding:10px;">
		<div id="menuTreedict" class="ztree"></div>
		<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="saveP()">保存</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="cancel()">取消</a>
			</div>
			</div>
	</div>
<script>
$(function(){
	serch();

})
// 保存修改
function saveP(){
	var roleid=$("#roleid").val();
	if($("#editRoleForm").form("validate")){
	      var treeObj = $.fn.zTree.getZTreeObj("menuTreedict");
	      var nodes = treeObj.getCheckedNodes(true);//在提交表单之前将选中的checkbox收集
	      var array = new Array();
	      for(var i=0;i<nodes.length;i++){
	       array.push(nodes[i].id);
	      }
	      var menuIds = array.join(",");
	      $("input[name=menuIds]").val(menuIds);//将获取的菜单选项赋值给隐藏域,从而将数据传到后台

	  	$.ajax({
			url:"tree/SaveByRoleId.action",
			type:"post",
			data:{menuIds:menuIds,roleid:roleid},
// 			dataType:"json",
			success:function(data) {
				alert(data);
				$('#w').window('close');
			}
		});
	      
	      
	     }
	
	
}
// 保存结束-----
function cancel(){
	$('#w').window('close');
	
}
function serch(){
	$("#rolelist").datagrid({    
		  url:'<%=request.getContextPath()%>/role/queryRole.action',  
	    pagination:true,
	    pageNumber:1,
	    pageSize:3,
	    pageList:[3,5,8],
	    singleSelect:true,
	    checkOnSelect:false,
	    selectOnCheck:false,
	    queryParams:{
// 	    	ryName:$("#ryName").val(),
// 	    	ygGzEmp:yggzemp,
	    },
	    columns:[[    
	              {field:'rId',title:'角色id',width:100}, 
	              {field:'rName',title:'角色名称',width:100}, 
	              {field:'',
	            	  title:'操作',
	            	  width:100,
	            		formatter: function(value,row,index){
		      	return "<input type='button' value='给权限' onclick='setRole("+row.rId+")'>";
		      			}
	           }, 
	          
	     ]],
	}); 
}
function setRole(id){
	$("#roleid").val(id);
	$('#w').window('open');
	var setting = {
			check: {
				enable: true,
				chkboxType: {"Y" : "s", "N" : "ps"} //勾选时影响子节点，取消勾选时影响父子节点
			},
			data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "pid",
				rootPId: 0
			},
		},
		callback: {
			onClick: function(event, treeId, treeNode) {
				if (null != treeNode.addPage && "" != treeNode.addPage) {
					$("#tabsdictt").tabs("add", {
						title:treeNode.name,
						closable:true,
						href:treeNode.addPage
					});
				}
			},
		}
	};
// 		这个请求是当前用户所对应的权限	
	var treeNode=null;
	$.ajax({
		url:"tree/findMenuByRoleId.action",
		type:"get",
		data:{roleid:id},
		dataType:"json",
		success:function(data) {
			    treeNode = data;
		}
	});

	
//		这个请求是所以权限	
	var menuTreeObj;
		$.ajax({
			url:"tree/selectMenuList.action",
			type:"get",
			data:{roleid:id},
			dataType:"json",
			success:function(data) {
// 				alert(data);
// 展示所有的权限的树
				menuTreeObj = $.fn.zTree.init($("#menuTreedict"), setting, data);
                
				      //当角色关联的菜单数据长度大于0时,遍历角色关联的菜单数据
				      if (treeNode.length > 0) {
				          
				          //获取ztree对象
				          var treeObj = $.fn.zTree.getZTreeObj("menuTreedict");
				          
				          //遍历勾选角色关联的菜单数据
				          for (var i = 0; i < treeNode.length; i++) {
				              
				          //根据角色菜单节点数据的属性搜索，获取与完整菜单树完全匹配的节点JSON对象集合
				          var nodes = treeObj.getNodesByParam("id", treeNode[i].id, null);
				          //勾选当前选中的节点
				          treeObj.checkNode(nodes[0],true,false);
				                                     
				                                 };
				                             };
				                         },
		});

}

</script>
</body>
</html>