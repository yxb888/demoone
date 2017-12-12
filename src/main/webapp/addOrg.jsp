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
<!-- 新增机构 -->
<!-- 上级部门dialog弹框 -->
</head>
<body>
	<form id="add-org-form" method="post">
	<h3>新增/编辑部门</h3>
	<center>
		部门编号：<input name="orguuid" class="easyui-textbox"  style="width:300px"><br>
		部门名称：<input name="orgname" class="easyui-textbox"  style="width:300px"><br>
		部门英文名：<input name="orgyingyu" class="easyui-textbox"  style="width:300px"><br>
		上级部门：<input id="porg" name="orgupboos" type="text" style="width:300px"><br>
		部门描述：<textarea name="description" cols="30" rows="5"></textarea><br><br><br><br>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-save'"   
        onclick="javascript:saveOrg()">保存</a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-no'"   
        onclick="javascript:saveOrg()">关闭</a>    
	</center>
	
<div id="add-org">
	<ul id="porg-tree"></ul>
</div>  
</form>


<script type="text/javascript">


	function saveOrg(){
// 		$('#add-org-form').form('submit',{    
// 		    contentType:'application/json;charset=utf-8',
// 		    type:"post",
// 		    onSubmit: function(){    //提交之前触发的函数，一般用来进行表单验证  如果 返回值为 false，则不提交表单
// 		      return true;   
// 		    },    
// 		    success:function(data){  //回调函数  
// // 		        alert(data)
// 		        $('#tt').tabs('close','添加机构'); 
// 		        changeTabs('机构查看','org/toOrgLayout.do');
		        
		        
// 		    }    
// 		});  
 		$.ajax({
			url:"<%=basePath%>/orgquery/addOrg.action",
			data:$("#add-org-form").serialize(),
			type:"post",
			dataType:"json",
			success:function(data){
				$('#diaid').tabs('close','新增机构'); 
		        changeTabs('机构查看','orgquery/ToQueryOrg.action');
			},
			error:function(){
				alert("新增失败!")
			}
		}) 
	}

	$(function(){
// 		初始化文本框
		$('#porg').textbox({
			editable:false,//定义用户是否可以直接在该字段内输入文字
			icons: [{
				iconCls:'icon-search',
				handler: function(e){
// 					console.info(e.data.target);
					$('#add-org').dialog({    
					    title: '部门拾取',    
					    width: 400,    
					    height: 500,    
					    closed: false,    
					    modal: true,
					    buttons:[{
							text:'确定',
							handler:function(){
								var checkdNodes = $('#porg-tree').tree('getChecked');
								var node = checkdNodes[0];
								console.info(node.text);
								$('#porg').textbox('setValue',node.text);
								$("#org-pid").val(node.id)
								$('#add-org').dialog("close");
							}
						},{
							text:'取消',
							handler:function(){
								
							}
						}]
					});
					$('#porg-tree').tree({    
					    url:'<%=request.getContextPath() %>/org/queryTree.action',
					    parentField:'pid',
					    checkbox:true,
					    cascadeCheck:false,
					    onSelect: function(node){
					    	searchOrg(node.id,node.text)
						},
						onBeforeCheck:function(node, checked){
// 							console.info(checked);
							if(checked){//如果当前为选中某节点，则取消其他节点的选中状态
// 								获取节点中背选中的节点——————返回值：数组
								var checkdNodes = $('#porg-tree').tree('getChecked');
// 								 取消被选中的节点   uncheck：取消指定的节点
								console.info(checkdNodes)
// 								循环取消
// 								for (var i = 0; i < checkdNodes.length; i++) {
// 									$('#porg-tree').tree('uncheck',checkdNodes[i].target)
// 								}
// 								判断取消
								if(checkdNodes.length>0){
									$('#porg-tree').tree('uncheck',checkdNodes[0].target)
								}
							}
						}
					    

					});
				}
			}]
		})


	})
</script>
</body>
</html>