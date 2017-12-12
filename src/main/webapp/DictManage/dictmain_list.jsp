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
<div id="cc" class="easyui-layout" style="width:600px;height:400px;" data-options="fit:true" >  
    <div data-options="region:'west',title:'选择上级',split:true"   style="width:150px;" >
    <div id="menuTreedict" class="ztree"></div>
    </div>   
    <div data-options="region:'center',title:'系统业务字典列表'" id="dictlist"   style="padding:5px;background:#eee;">
		
<div id="serch" style="display:none;">
	<table class="tab">
		<tr>
			<td class="t tl4"> 是否允许修改： </td>
			<td class="tr4">
			<input value="0" type="hidden" id="hiddenone"/>
			<input value="${sessionScope.dictcode}" type="hidden" id="dictcode" />
				<select id="dictIfChange"  onchange="javascrip:seache()" >
						<option>-请选择是否允许编辑:默认所有-</option>
						<option value="1">是</option>
						<option value="2">否</option>
				</select>
			</td>
<!-- 				<select id="ENT_ORG" name="condition.ENT_ORG"> -->
<!-- 						<option ></option> -->
<%-- 			 		 	<c:forEach var="items" items="${orgList}"> --%>
<%-- 							<option value="${items.SOG_ID }">${items.SOG_NAME }</option> --%>
<%-- 						</c:forEach> --%>
<!-- 			 	</select>	 -->
	</table>
</div>		
			<div id="code" style="height: 100%">
		<table id="ent_shoareholder"  data-options="fit:true"></table>
			</div>
		<div id="tabsdict" class="easyui-tabs" data-options="fit:true"></div> 
		<div id="tabsdictt" class="easyui-tabs" data-options="fit:true"></div> 
			</div>
			
<!-- 			新增 -->
<div data-options="region:'center',title:'添加/编辑业务字典'"  id="add"   style="padding:5px;background:#eee;display:hidden;margin-top: 40px;">
		<form id="formDet">
		<table class="tab"  align="center" data-options="fit:true" >
			<tr>
				<td class="tl3 t"> * 上级名称： </td>
				
				<td class="tr3">
				<div id="abiaoqian">
					<input placeholder="请选择上级民称" style="width: 50%"   readonly="readonly" id="namelast" required="true"  />
					<input type="hidden" name="tDictCode"   readonly="readonly" id="coded" />
					<input type="hidden" name="tDictPid"   readonly="readonly" id="pid" />
				<a style="margin-bottom:0px;width: auto;%" class="easyui-linkbutton"  href="javascript:void(0)" title="查询" iconCls="icon-search" onclick="initGrid()">查询</a>
				</div>	
				</td>
				
				</tr>
				<tr>
				<td  class="tl3 t">* 业务名称	：</td>
				<td class="tr3">
					<input class=" easyui-validatebox input2"  name="tDictName" id="ENT_NAME_EN" />
				</td>
				</tr>
				<tr>
				<td  class="tl3 t">* 英文名称： </td>
				<td class="tr3">
					<input class="easyui-validatebox input2" name="tDictEnname"   id="ENT_LINKMAN"  />
				</td>
				</tr>
				
				<tr>
				
					<td  class="tl3 t">* 备注：</td>
				<td class="tr3">
					<textarea id="memo"  value="" 
								class="easyui-validatebox input2" validType="length[1,400]" invalidMessage="不能超过400个中文字符！"
								name="tText" style='width:100%;height:100px;'></textarea></td>
					 
			</tr>
		</table>
		</form>
		<div id="addButton" style="display: none;"  align="center">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="savePaa()" name="relper_save" style="margin-left: 10px;">提交</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="returnPerson_change()" name="relper_save" style="margin-left: 10px;">返回</a>
				</div>
		
		

</div>
			
				
<!-- 			xiugai -->
<div data-options="region:'center',title:'添加/编辑业务字典'"  id="update"   style="padding:5px;background:#eee;display:hidden;margin-top: 40px;">
		<form id="formDetupdate">
		<table class="tab"  align="center" data-options="fit:true" >
			<tr>
				<td class="tl3 t"> * 上级名称： </td>
				
				<td class="tr3">
				<div id="updateabiaoqian">
					<input placeholder="请选择上级民称" style="width: 50%"   readonly="readonly" id="namelastupdate" required="true"  />
					<input  name="tDictCode" type="hidden"  readonly="readonly" id="codedupdate" />
					<input  name="tDictPid"   type="hidden"  readonly="readonly" id="pidupdate" />
					<input  name="tDictId"  type="hidden"   readonly="readonly" id="dictidupdate" />
				<a style="margin-bottom:0px;width: auto;%" class="easyui-linkbutton"  href="javascript:void(0)" title="查询" iconCls="icon-search" onclick="initGrid()">查询</a>
				</div>	
				</td>
				
				</tr>
				<tr>
				<td  class="tl3 t">* 业务名称	：</td>
				<td class="tr3">
					<input class=" easyui-validatebox input2"  name="tDictName" id="ENT_NAME_ENupdate" />
				</td>
				</tr>
				<tr>
				<td  class="tl3 t">* 英文名称： </td>
				<td class="tr3">
					<input class="easyui-validatebox input2" name="tDictEnname"   id="ENT_LINKMANupdate"  />
				</td>
				</tr>
				
				<tr>
				
					<td  class="tl3 t">* 备注：</td>
				<td class="tr3">
					<textarea id="memoupdate"  value="" 
								class="easyui-validatebox input2" validType="length[1,400]" invalidMessage="不能超过400个中文字符！"
								name="tText" style='width:100%;height:100px;'></textarea></td>
					 
			</tr>
		</table>
		</form>
		<div id="updateButton" style="display: none;"  align="center">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="updatePaa()" name="relper_save" style="margin-left: 10px;">提交</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="returnPerson_change()" name="relper_save" style="margin-left: 10px;">返回</a>
				</div>
		
		

</div>
			
					
			
			
			
		
</div>  
<div id="w" class="easyui-window" title="Modal Window" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:300px;height:500px;padding:10px;">
		<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'center'" style="padding:10px;">
		<div id="menuTreedictttt" class="ztree"></div>
		</div>
		<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="saveP()">Ok</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:alert('cancel')">Cancel</a>
			</div>
			</div>
	</div>

<script type="text/javascript">
	$(function(){
// 		alert('${sessionScope.dictcode}');
		seache();
		load_menu_tree_data();
		$("#updateabiaoqian").hide();
		$("#updateButton").hide();
		
	})
	
	function saveP(){
		var zTree = $.fn.zTree.getZTreeObj("menuTreedictttt");
		var nodes = zTree.getCheckedNodes(true);
// 		var node = zTree.getNodeByParam("id", 1, null);
// 		nodes = zTree.getSelectedNodes();
		$("#namelast").val(nodes[0].name);
		$("#namelastupdate").val(nodes[0].name);
		$("#coded").val(nodes[0].code);
		$("#codedupdate").val(nodes[0].code);
		$("#pid").val(nodes[0].id);
		$("#pidupdate").val(nodes[0].id);
		$('#w').window('close');
		
		
	}
	
	function returnPerson_change(){
		$("#dictlist").show();
		$("#add").hide();
		$("#abiaoqian").hide();
		$("#addButton").hide();
		$("#updateButton").hide();
		$("#updateabiaoqian").hide();
	}
	function savePaa(){
		$.ajax({
			url:"dict/dictAdd.action",
			type:"post",
//    			dataType:"json",
   		 	async: false,
   			data:$("#formDet").serialize(),
   			success:function(data){
   				$.messager.alert("提示信息","新增成功！","info");
   				$("#dictlist").show();
				$("#add").hide();
				$("#abiaoqian").hide();
				$("#addButton").hide();
				$("#updateButton").hide();
				$("#updateabiaoqian").hide();
// 				var treeObj = $.fn.zTree.getZTreeObj("ztree");
// 			var namelast=	$("#namelast").val();
// 				var newNode = {name:namelast};
// 				newNode = treeObj.addNodes(null, newNode);
				
				 $('#ent_shoareholder').datagrid('reload'); 
   			},
   			error :function(){
   				
   				alert("cuole");
   			}
		
		});
		
		
	}
// 	修改
	function updatePaa(){

		$.ajax({
			url:"dict/dictupdate.action",
			type:"post",
//    			dataType:"json",
   		 	async: false,
   			data:$("#formDetupdate").serialize(),
   			success:function(data){
   				$.messager.alert("提示信息","修改成功！","info");
   				$("#dictlist").show();
				$("#add").hide();
				$("#abiaoqian").hide();
				$("#addButton").hide();
				$("#updateButton").hide();
				$("#updateabiaoqian").hide();
				 $('#ent_shoareholder').datagrid('reload'); 
   			},
   			error :function(){
   				
   				alert("cuole");
   			}
		
		});
		
		
	}
	function initGrid(){	
		$('#w').window('open');
		var menuTreeObjj;
		   //加载菜单数据
		   		$.ajax({
		   			url:"tree/selectMenuListDict.action",
		   			type:"get",
		   			dataType:"json",
		   			success:function(data) {
		   				menuTreeObjj = $.fn.zTree.init($("#menuTreedictttt"), setttting, data);
		   			}
		   		});
		
	}
// 	字典树
	
		var setting = {
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
						$("#tabsdict").tabs("add", {
							title:treeNode.name,
							closable:true,
							href:treeNode.addPage
						});
					}
				}
			}
		};
	
		var setttting = {
				check: {
					enable: true,
					chkStyle: "radio"
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
// 					alert(treeNode.addPage);
					if (null != treeNode.addPage && "" != treeNode.addPage) {
						$("#tabsdictt").tabs("add", {
							title:treeNode.name,
							closable:true,
							href:treeNode.addPage
						});
					}
				},
				beforeExpand: zTreeBeforeExpand
			
			}
		};
		
		var menuTreeObj;
	   //加载菜单数据
	   function load_menu_tree_data() {
	   		$.ajax({
	   			url:"tree/selectMenuListDict.action",
	   			type:"get",
	   			dataType:"json",
	   			success:function(data) {
	   				menuTreeObj = $.fn.zTree.init($("#menuTreedict"), setting, data);
	   			}
	   		});
	   }
	
	   function zTreeBeforeExpand(treeId, treeNode) {
		    return false;
		};
	function seache(){
		$("#abiaoqian").hide();
		$("#ent_shoareholder").datagrid({    
		    url:'<%=basePath%>/dict/DictManageAction_selectdictlist.action',  
		    pagination:true,
		    pageNumber:1,
		    pageSize:3,
		    pageList:[3,5,8],
		  
		    singleSelect:false,
		    checkOnSelect:true,
		    selectOnCheck:false,
		    queryParams:{
		    	dictIfChange:$("#dictIfChange").val(),
		    	dictcode:$("#dictcode").val(),
		    },
		    toolbar: [{
				text:'添加',
				iconCls:'icon-add',
				handler:function(){
					$("#dictlist").hide();
					$("#add").show();
					$("#update").hide();
					$("#abiaoqian").show();
					$("#addButton").show();
					$("#updateabiaoqian").hide();
					$("#updateButton").hide();
// 					lastIndex = $('#ent_shoareholder').datagrid('getRows').length;
// 					$('#ent_shoareholder').datagrid('appendRow',{});
// 					$('#ent_shoareholder').datagrid('selectRow', lastIndex);
// 					$('#ent_shoareholder').datagrid('beginEdit', lastIndex);
				}
 			},'-',{
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
// 						alert(arrs[0].dictId);
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
			},'-',{
				text:'删除',
				iconCls: 'icon-remove',
				handler: function(getChecked){
					
					var arrs = $('#ent_shoareholder').datagrid('getChecked');
					var row = $('#ent_shoareholder').datagrid('getSelected');
					var index = $('#ent_shoareholder').datagrid('getRowIndex', row);
					if (row){
					$.messager.confirm('删除', '确定要删除吗？',  function(row){if (row){
					var ids="";
					for (var i = 0; i < arrs.length; i++) {
						ids +=","+arrs[i].dictId
					}
					oid=ids.substr(1);
					$.ajax({       //ajax请求删除结果
                        type: "post",
                        url: '<%=basePath%>/dict/DictManageAction_delitelist.action',
                        data: { "dictId": oid },
                        async: false,
                        success: function (data) {
                            $.messager.alert("提示!", "删除成功！");
                            $('#ent_shoareholder').datagrid('reload'); 
                        },
                        error: function (data) {
                            $.messager.alert("提示!", "异常错误");
                        }
                    });
// 						$('#ent_shoareholder').datagrid('deleteRow', index);
					}});
					
					}
<%-- 						location.href="<%=request.getContextPath()%>/po/deleteAll.do?ids="+oid; --%>
				}
			},'-',{
				text:'高级查询',
				iconCls: 'icon-search',
				handler: function(){
					var hiddenone=$("#hiddenone").val();
					if(hiddenone==0){
						$("#serch").show();
						$("#hiddenone").val("1");
// 						$("#code").attr("style","height:100%");
// 						alert(hiddenone);
					}else if(hiddenone==1){
						$("#serch").hide();
						$("#hiddenone").val("0");
// 						$("#code").attr("style","height:100%");
					}
					
				}
				
			},'-',{
				text:'导出字典数据',
// 				iconCls: 'icon-search',
				iconCls: 'icon-undo',
				handler: function(){
					$.ajax({       //ajax请求删除结果
                        type: "post",
                        url: '<%=basePath%>/dict/expotexecle.action',
//                         data: { "dictId": oid },
                        async: false,
                        success: function (data) {
                            $.messager.alert("提示!", "导出成功！");
//                             $('#ent_shoareholder').datagrid('reload'); 
                        },
                        error: function (data) {
                            $.messager.alert("提示!", "异常错误");
                        }
                    });
					
					
					
				}
				
				
			}
			],
		    columns:[[    
		        {field:'dictId',title:'',width:'60%',checkbox:true},    
		        {field:'dictCode',title:'所属编码 ',width:'60%'},    
// 		        {field:'dictCode',title:'字典名称 ',width:'60%'},    
		        {field:'dictIfchange',title:'是否允许修改 ',width:200,
	 				formatter:function(val, row){
			           if (row.dictIfchange != "" && row.dictIfchange == "1") {
								return "是";
							} else  if(row.dictIfchange != "" && row.dictIfchange == "2"){
								return "否";
							}
						}	
		        
		        
		        
		        }, 
// 		        {field:'userpwd',title:'用户密码',width:200},
// 		        {field:'usermobile',title:'手机号',width:200},
// 		        {field:'orupboos',title:'上级机构',width:200},
// 		        {field:'str',title:'操作',width:200},
		    ]]    
		}); 
	};
	
	
// function getshoareholderList() {
// 		$('#ent_shoareholder').datagrid({
// 			/* url :  ctx + "/supplier/supplierManageAction_selectholderListInftemp.action", */
// 			url :  ctx + "/dict/DictManageAction_selectdictlist.action",
// 			title:"主要股东",
// 		type : 'post',
// 		dataType : 'json',
// // 		queryParams:{ "condition.ENT_ID":$("#RESULT_ENTID").val()},
// 		fitColumns : true,         
//         nowrap : false,
//         striped : true,
//         rownumbers : true,
//         singleSelect : true,
//         remoteSort : false,
//         pagination : true,
// 			columns : [ [
// 			{field : "ESR_ID",hidden:true}, 
// 			{
// 				field : 'ESR_NAME', 
// 				title : '姓名',
// 				width : '10%',
// 				align : 'center',      
// 				sortable : true,
// 				editor:{type:'text',options:{}}
// 			},{
			 
// 				field : 'ESR_SEX',
// 				title : '性别 ',
// 				width : '19%',   
// 				align : 'center',
// 				sortable : true,
// 				editor:{type:'combobox',options:{data:[{"value":"男","name":"男"},{"value":"女","name":"女"}],required: true,editable:false,valueField:'value',textField:'name'}},
// 				formatter:function(val, row){
// 			           if (row.ESR_SEX != "" && row.ESR_SEX == "01") {
// 								return "男";
// 							} else {
// 								return "女";
// 							}
// 						}
// 			},{
			 
// 				field : 'ESR_PHONE',
// 				title : '电话 ',
// 				width : '19%',   
// 				align : 'center',
// 				sortable : true,
// 				editor:{type:'text',options:{}}
// 			},{
			 
// 				field : 'ESR_EMAIL',
// 				title : '邮箱 ',
// 				width : '19%',   
// 				align : 'center',
// 				sortable : true,
// 				editor:{type:'text',options:{}}
// 			},{
			 
// 				field : 'ESR_CERTNO',
// 				title : '身份证号',
// 				width : '19%',   
// 				align : 'center',
// 				sortable : true,
// 				editor:{type:'text',options:{}}
// 			}, 
// 			 {
			 
// 				field : 'FLAG',
// 				title : '状态',
// 				width : '9%',   
// 				align : 'center',
// 				sortable : true,
// 				/* editor:{type:'text',options:{}}, */
// 				formatter:function(val, row){
// 			           if (row.FLAG != "" && row.FLAG == "1") {
// 							return "新增数据（待审核）";
// 						} else if(row.FLAG != "" && row.FLAG == "2") {
// 							return "删除数据（待审核）";
// 						}else if(row.FLAG != "" && row.FLAG == "3") {
// 							return "修改数据（待审核）";
// 						}else if(row.FLAG != "" && row.FLAG == "4") {
// 							return "原始数据（已审核）";
// 						}else{
// 							return val;
// 						}
// 				}
// 			}
// 			] ],
// 			/* toolbar:[{
// 				text:'添加',
// 				iconCls:'icon-add',
// 				handler:function(){
// 					lastIndex = $('#ent_shoareholder').datagrid('getRows').length;
// 					$('#ent_shoareholder').datagrid('appendRow',{});
// 					$('#ent_shoareholder').datagrid('selectRow', lastIndex);
// 					$('#ent_shoareholder').datagrid('beginEdit', lastIndex);
// 				}
// 			},{
// 				text:'删除',
// 				iconCls:'icon-remove',
// 				handler:function(){
// 					var row = $('#ent_shoareholder').datagrid('getSelected');
// 					if (row){
// 						var index = $('#ent_shoareholder').datagrid('getRowIndex', row);
// 						var row1 = $("#ent_shoareholder").datagrid("getRows");	
// 						$.messager.confirm('删除', '确定要删除吗？', function(data){if (data){
// 							var id = row.ESR_ID;
// 							if(id !=undefined){
// 								delholderinf(id);
// 							}
// 							$('#ent_shoareholder').datagrid('deleteRow', index);
// 						}});				
// 					}
// 				}
// 			},{
// 				text:'保存',
// 				iconCls:'icon-save',
// 				 handler:function () {
//                       // $('#ent_shoareholder').datagrid('acceptChanges');
//                        saveholderbutton();
//                   }
// 			}], */
// 			onDblClickRow : function(rowIndex, rowData) {
// 				RI=rowIndex;
// 				RD=rowData;
// 				$('#ent_shoareholder').datagrid('beginEdit',RI);
// 			},
// 			onLoadSuccess : function(data) {
// 				if (data.total == 0) {
// 					var tips = "<font color=red>没有主要股东信息数据....</font>";
// 					$('#ent_shoareholder').datagrid("insertRow", {
// 						index : 1,
// 						row : {
// 							ESR_NAME : tips
// 						}
// 					
// 				}
// 			},
// 			onLoadError : function() {
// 				$.messager.alert('错误', '数据加载错误!', 'error');
// 			}
// 		});
// 	}




</script>



</body>
</html>