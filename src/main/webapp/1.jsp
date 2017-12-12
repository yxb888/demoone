<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
application.setAttribute("basePath", basePath);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="easyui/jquery.min.js"></script>
<script src="easyui/jquery.easyui.min.js"></script>
<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="easyui/util-js.js"></script>


<script src="zTree/js/jquery.ztree.all.min.js"></script>
<link href="easyui/themes/bootstrap/easyui.css" rel="stylesheet">
<link href="easyui/themes/icon.css" rel="stylesheet">
<link href="zTree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
<!-- 引入EasyUI的样式文件-->
<%-- <link rel="stylesheet" href="<%=basePath %>/easyui/themes/default/easyui.css" type="text/css"/> --%>
<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet"href="<%=basePath %>/easyui/themes/icon.css" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="js/3Djs/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="js/3Djs/css/htmleaf-demo.css">
	<link rel="stylesheet" href="js/3Djs/css/style.css">
</head>
<body class="easyui-layout">
<!--layout布局-->
  
	    <div data-options="region:'west',title:'左侧',split:true" style="width:180px;">
	    	<!--accordion手风琴-->
	    		<div id="aa" class="easyui-accordion" data-options="fit:true">   
<!-- 				    <div title="用户管理"> -->
<!-- 				    	tree树形菜单 -->
<!-- 				    		<div id="shu"></div>   -->
				    	
<!-- 				    </div>    -->
				    <div title="人事管理">
				    	<div id="menuTree" class="ztree"></div>
				    </div>   
				    <div title="系统管理">
				    <div id="menuTreexitong" class="ztree"></div>
				    
				    </div> 
				    <div title="咨询"></div>  
				</div>  
	    </div>   
	    <div data-options="region:'center',title:'展示区'" style="padding:5px;background:#eee;">
	    	 <!--tabs选项卡-->
	    	<div id="tabs" class="easyui-tabs" data-options="fit:true">   
<!-- 	    	js/3Djs/img/1.jpg -->
			    				<div title="精英榜" data-options="fit:true" class="slider" id="slider" style="--img-prev:url()"> 
		  <div class="slider__content" id="slider-content">
		    <div class="slider__images">
		      <div class="slider__images-item slider__images-item--active" data-id="1"><img src="js/3Djs/img/3gq.jpg"/></div>
		      <div class="slider__images-item" data-id="2"><img src="js/3Djs/img/2a.jpg"/></div>
		      <div class="slider__images-item" data-id="3"><img src="js/3Djs/img/2r.jpg"/></div>
		      <div class="slider__images-item" data-id="4"><img src="js/3Djs/img/2qe.jpg"/></div>
		      <div class="slider__images-item" data-id="5"><img src="js/3Djs/img/2l.jpg"/></div>
		      <div class="slider__images-item" data-id="6"><img src="js/3Djs/img/2ee.jpg"/></div>
		    </div>
		    <div class="slider__text">
		      <div class="slider__text-item slider__text-item--active" data-id="1">
		        <div class="slider__text-item-head">
		          <h3>张世杰</h3>
		        </div>
		        <div class="slider__text-item-info">
		          <p>“项目经理”</p>
		        </div>
		      </div>
		      <div class="slider__text-item" data-id="2">
		        <div class="slider__text-item-head">
		          <h3>杨兴北</h3>
		        </div>
		        <div class="slider__text-item-info">
		          <p>“技术总监”</p>
		        </div>
		      </div>
		      <div class="slider__text-item" data-id="3">
		        <div class="slider__text-item-head">
		          <h3>范成奎</h3>
		        </div>
		        <div class="slider__text-item-info">
		          <p>“高级Java开发工程师”</p>
		        </div>
		      </div>
		      <div class="slider__text-item" data-id="4">
		        <div class="slider__text-item-head">
		          <h3>张万利</h3>
		        </div>
		        <div class="slider__text-item-info">
		          <p>“妇联主任”</p>
		        </div>
		      </div>
		      <div class="slider__text-item" data-id="5">
		        <div class="slider__text-item-head">
		          <h3>梁飞</h3>
		        </div>
		        <div class="slider__text-item-info">
		          <p>“Java开发高级工程师”</p>
		        </div>
		      </div>
		      <div class="slider__text-item" data-id="6">
		        <div class="slider__text-item-head">
		          <h3>付朱润</h3>
		        </div>
		        <div class="slider__text-item-info">
		          <p>“Java开发高级工程师”</p>
		        </div>
		      </div>
		    </div>
		  </div>
		  <div class="slider__nav">
		    <div class="slider__nav-arrows">
		      <div class="slider__nav-arrow slider__nav-arrow--left" id="left">to left</div>
		      <div class="slider__nav-arrow slider__nav-arrow--right" id="right">to right</div>
		    </div>
		    <div class="slider__nav-dots" id="slider-dots">
		      <div class="slider__nav-dot slider__nav-dot--active" data-id="1"></div>
		      <div class="slider__nav-dot" data-id="2"></div>
		      <div class="slider__nav-dot" data-id="3"></div>
		      <div class="slider__nav-dot" data-id="4"></div>
		      <div class="slider__nav-dot" data-id="5"></div>
		      <div class="slider__nav-dot" data-id="6"></div>
		    </div>
		  </div>
		</div>
		
	
			    </div>   
			</div>  
	    </div> 
	    
	   <script src="js/3Djs/js/index.js"></script> 
	   
	    <script type="text/javascript" src="<%=basePath %>/easyui/util-js.js"></script> 
<script type="text/javascript" src="<%=basePath %>/my97/WdatePicker.js"></script> 
	    
	    
<script >

		$(function() {
// 			load_tree_data_old();
	   		load_menu_tree_data();
	   	
	   });
	
	
		var setting = {
// 				view: {
// 					addHoverDom: addHoverDom,
// 					removeHoverDom: removeHoverDom,
// 					selectedMulti: false
// 				},
// 				edit: {
// 					enable: true,
// 					editNameSelectAll: true,
// 					showRemoveBtn: showRemoveBtn,
// 					showRenameBtn: showRenameBtn
// 				},
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
						$("#tabs").tabs("add", {
							title:treeNode.name,
							closable:true,
							href:treeNode.addPage
						});
					}
				},
				beforeDrag: beforeDrag,
				beforeEditName:beforeEditName,
				beforeRemove: function(treeId, treeNode){
					var idss=treeNode.id;
					$.messager.confirm('删除', '确定要删除节点1 -- " + treeNode.name + " 吗？',  function(row){if (row){
						$.ajax({
							url:"tree/deletetree.action",
							type:"post",
//								dataType:"json",
							 	async: false,
								data:{idss:idss},
								success:function(data){
									$.messager.alert("提示信息","删除成功！","info");
								}
						})
					
					}})
					
					
					
				},
				beforeRename: beforeRename,
				onRemove: onRemove,
				onRename: onRename
			}
		};
		
		var menuTreeObj;
	   //加载菜单数据
	   function load_menu_tree_data() {
	   		$.ajax({
	   			url:"tree/getCurrenUserNodes.action",
	   			type:"get",
	   			dataType:"json",
	   			data:{left:1},
	   			success:function(data) {
	   				menuTreeObj = $.fn.zTree.init($("#menuTree"), setting, data);
	   				load_menu_tree_dataa();
	   			}
	   		});
	   }
	
		var menuTreeObjj;
	   //加载菜单数据
	   function load_menu_tree_dataa() {
	   		$.ajax({
// 	   			url:"tree/selectMenuListTree.action",
	   			url:"tree/getCurrenUserNodes.action",
	   			type:"get",
	   			data:{left:2},
	   			dataType:"json",
	   			success:function(data) {
	   				menuTreeObjj = $.fn.zTree.init($("#menuTreexitong"), setting, data);
	   			}
	   		});
	   }
	
	






	//普通菜单树
	function load_tree_data_old(){
	
		$('#shu').tree({   
			onClick:function(node){
			//判断tabs选型卡是否存在
			var tabs =$("#tabs").tabs("getTab",node.text);
			if(null != node.url && "" !=node.url){
				if(tabs==null){
				$('#tabs').tabs('add',{    
				    title:node.text,    
				    href:node.url 
				 }); 
				} 
			  }
			},
		   data:[{    
			    "id": 1,    
			    "text": "用户管理",    
			    "state": "closed",    
			    "children": [{    
			        "id": 11,    
			        "text": "用户查询" ,
			         url:"user/toUserPage.action"   
			    },{    
			        "id": 12,    
			        "text": "用户充值"   
			    }]    
			},{    
			    "id": 2,    
			    "text": "部门管理",    
			    "state": "closed",
			    "children": [{    
			        "id": 21,    
			        "text": "部门查询" ,
			         url:"toPage"   
			    },{    
			        "id": 22,    
			        "text": "echarts统计图" ,
			         url:"chart/toChartsPage" 
			   }] 
			},{    
			    "id": 3,    
			    "text": "角色管理",    
			    "state": "closed",
			    "children": [{    
			        "id": 31,    
			        "text": "角色查询" ,
			         url:"role/toRolesPage"
			   }] 
			},{    
			    "id": 4,    
			    "text": "权限管理",    
			    "state": "closed",
			    "children": [{    
			        "id": 41,    
			        "text": "权限查询" ,
			         url:"permission/toPermissionPage"
			    	}] 
			    }]
		});
}
	
	//账户退出功能
	function userLoginOut(){
	
			   $.ajax({
		   type: "POST",
		   url: "user/userLoginOut",
		   success: function(){
		   alert(1232);
			}
		});
		
		
	}
	var log, className = "dark";
	function beforeDrag(treeId, treeNodes) {
		return false;
	}
	function beforeEditName(treeId, treeNode) {
		className = (className === "dark" ? "":"dark");
		showLog("[ "+getTime()+" beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
		var zTree = $.fn.zTree.getZTreeObj("menuTree");
		zTree.selectNode(treeNode);
		setTimeout(function() {
			if (confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？")) {
				setTimeout(function() {
			
					zTree.editName(treeNode);
				}, 0);
			}
			

		}, 0);
		return false;
	}
	
	
	
	
	
	
	function onRemove(e, treeId, treeNode) {
		showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
	}
	function beforeRename(treeId, treeNode, newName, isCancel) {
		className = (className === "dark" ? "":"dark");
		showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
		if (newName.length == 0) {
			setTimeout(function() {
				var zTree = $.fn.zTree.getZTreeObj("menuTree");
				zTree.cancelEditName();
				alert("节点名称不能为空.");
			}, 0);
			return false;
		}
		$.ajax({
			url:"tree/updatetree.action",
			type:"post",
//				dataType:"json",
			 	async: false,
				data:{idssname:newName,idssnameid:treeNode.id},
				success:function(data){
					$.messager.alert("提示信息","修改成功！","info");
				}
		})
		
		return true;
	}
	function onRename(e, treeId, treeNode, isCancel) {
		showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
	}
	function showRemoveBtn(treeId, treeNode) {
		return true;
// 		return !treeNode.isFirstNode;
	}
	function showRenameBtn(treeId, treeNode) {
		return true;
// 		return !treeNode.isLastNode;
	}
	function showLog(str) {
		if (!log) log = $("#log");
		log.append("<li class='"+className+"'>"+str+"</li>");
		if(log.children("li").length > 8) {
			log.get(0).removeChild(log.children("li")[0]);
		}
	}
	function getTime() {
		var now= new Date(),
		h=now.getHours(),
		m=now.getMinutes(),
		s=now.getSeconds(),
		ms=now.getMilliseconds();
		return (h+":"+m+":"+s+ " " +ms);
	}

	var newCount = 1;
	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='add node' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn) btn.bind("click", function(){
			var zTree = $.fn.zTree.getZTreeObj("menuTree");
			zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"牛 逼" + (newCount++)});
			var s="牛 逼" + (newCount++);
			$.ajax({
				url:"tree/addtree.action",
				type:"post",
//					dataType:"json",
				 	async: false,
					data:{addpid:treeNode.id,addname:s},
					success:function(data){
						$.messager.alert("提示信息","新增成功！","info");
					}
			})
			
			
			return false;
		});
	};
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	};
	function selectAll() {
		var zTree = $.fn.zTree.getZTreeObj("menuTree");
		zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
	}
	
</script>
</body>
</html>