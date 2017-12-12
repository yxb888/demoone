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

<link href="js/webuploader/webuploader.css" rel="stylesheet">

<script src="js/webuploader/webuploader.min.js"></script>
</head>
<body>
<div class="easyui-panel" title="修改公司系统显示设置" style="width:100%;">
<form id="formset"  method="POST"
 enctype="multipart/form-data" accept="image/gif, image/jpeg,image/jpg, image/png">
	<table width="100%" class="editTab" id="search">
                <tr>
                    <td align="right">公司名称：</td>
                    <td align="left">
                    	<input required="required" value="北京金科牛逼一组有限集团" disabled="disabled" value="${userDto.sur_user_cd}" readonly="readonly" style="width:200px;border:1px  solid #95B8E7;padding:1px;"  type="text" />
                    	<font color="red">&nbsp;&nbsp;*</font>
                    </td>
                    <td align="right">公司简介：</td>
                    <td align="left">
                    	<input disabled="disabled" value="就是牛逼" style="width:200px;border:1px  solid #95B8E7;padding:1px;"  maxlength = "10"  value="${userDto.sur_user_name}" type="text"  data-options="required:true,validType:['lengthb[0,20]','name'] "  class="easyui-validatebox"/>
                    	<font color="red">&nbsp;&nbsp;*</font>
                    </td>
				</tr>
                <tr>
                    <td align="right">系统标题：</td>
                	<td align="left">
                		<input id="" name="pId" type="hidden" value="2"/>
                		<input id="cspwd" name="pTimege" style="width:200px;border:1px  solid;padding:1px;"  type="text"    class="easyui-validatebox"/>
                    	
                		<font color="red">&nbsp;&nbsp;*</font>               	
                	</td>
                    <td align="right">系统英文标题：</td>
                    <td align="left">
                    <input id="cspwdA" name="pCspwd" style="width:200px;border:1px  solid #95B8E7;padding:1px;"  type="text"  data-options="required:true,validType:['lengthb[0,15]','telPhone']"  class="easyui-validatebox"/>
                    	<font color="red">&nbsp;&nbsp;*</font>
                    </td>
				</tr>
                <tr>
                	<td align="right">公司（LOGO）：</td>
                    <td align="left">
               
							<div id="uploader" class="wu-example">
						<!-- 	    用来存放文件信息 -->
							    <div id="thelist" class="uploader-list"></div>
							    <div class="btns">
							        <div id="picker">选择文件</div>
							        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="ctlBtn()" name="relper_save" style="margin-left: 10px;">上传</a>
							    </div>
							</div> 
                    </td> 
                    
                    <td align="right"></td>
                    <td align="left">
                    <div>
              		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="openPicture()" name="relper_save" style="margin-left: 10px;">浏览图片</a>		
                    </div></td> 
                </tr>
	</table>
</form>
</div>
		<div id=""   align="center">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="updatePaa()" name="relper_save" style="margin-left: 10px;">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="returnPerson_change()" name="relper_save" style="margin-left: 10px;">返回</a>
		</div>
		<div id="roledialog"></div>
<script type="text/javascript">

	 function openPicture(){
		   $("#roledialog").dialog({
			    title: '浏览图片',    
			    width: 1000,    
			    height: 500,    
			    closed: false,    
			    cache: false,    
			    href: '<%=request.getContextPath()%>/cdset/toPictue.action',    
			    buttons:[{
					text:'关闭',
					handler:function(){
				$("#roledialog").dialog("close");
					}
				}]

		   })
	}




var $list=$("#thelist");   
//初始化全局,百度文档上没说明
// 	var $btn =;   
	//开始上传 

var uploader = WebUploader.create({
    // swf文件路径
    swf: 'js/webuploader/Uploader.swf',
    // 文件接收服务端。
    server: 'cdset/uploadMyFileNameMethod.action',
    //[可选] [默认值：'file']设置文件上传域的name。 
    fileVal:"fileName",
    // 选择文件的按钮。可选。
    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
    pick: '#picker',
    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
    resize: false,
 // 只允许选择图片文件。 
    accept: {
        title: 'Images',
        extensions: 'jpg,jpeg,png',
        mimeTypes: 'image/jpg,image/jpeg,image/png'
     },
     thumb: {
         type: 'image/jpg,jpeg,png'
      },
      fileNumLimit: 8, //限制上传个数
      fileSingleSizeLimit: 2048000 //限制单个上传图片的大小
});

// 当有文件被添加进队列的时候
uploader.on( 'fileQueued', function( file ) {
    $list.append( '<div id="' + file.id + '" class="item">' +
        '<h4 class="info">' + file.name + '</h4>' +
        '<p class="state">等待上传...</p>' +
    '</div>' );
    
});


// 文件上传过程中创建进度条实时显示。
uploader.on( 'uploadProgress', function( file, percentage ) {
    var $li = $( '#'+file.id ),
        $percent = $li.find('.progress .progress-bar');

    // 避免重复创建
    if ( !$percent.length ) {
        $percent = $('<div class="progress progress-striped active">' +
          '<div class="progress-bar" role="progressbar" style="width: 0%">' +
          '</div>' +
        '</div>').appendTo( $li ).find('.progress-bar');
    }

    $li.find('p.state').text('上传中');

    $percent.css( 'width', percentage * 100 + '%' );
});
		
		
		uploader.on( 'uploadSuccess', function( file,response ) {
			$("#img_id").attr("src",response.url);
			console.log(response);
    $( '#'+file.id ).find('p.state').text('已上传');
});

uploader.on( 'uploadError', function( file ) {
// 	alert(response[0].message);
    $( '#'+file.id ).find('p.state').text('上传出错');
});

uploader.on( 'uploadComplete', function( file ) {
    $( '#'+file.id ).find('.progress').fadeOut();
});
// $("#ctlBtn").on('click', function() { 
// 	alert(111);
// //     console.log("上传...");  
// //     uploader.upload();  
// //     console.log("上传成功");  
// });  
function ctlBtn(){
 console.log("上传...");  
 uploader.upload();  
 console.log("上传成功");  
	
	
}


$(function(){

	seliet();
})

  function uploadPic(){  
                if($("#file").val()==""){  
                    $.messager.alert("提示","请选择文件夹");  
                    return false;  
                }  
                 $("#p").ajaxSubmit({    
                    type:"post",  //提交方式    
                    url:"${pageContext.request.contextPath}/student/filesUpload", //请求url    
                    success:function(data){ //提交成功的回调函数    
                        $.messager.alert("提示",data);  
                    }    
                });    
            }  



function seliet(){
		$.ajax({
			url:"cdset/selectcompanyKey.action",
			type:"post",
//    			dataType:"json",
   		 	async: false,
//    			data:$("#formDet").serialize(),
   			success:function(data){
//    				$.messager.alert("提示信息","查询成功！","info");
   			$("#cspwd").val(data[1].pTimege);
   			$("#cspwdA").val(data[1].pCspwd);
//    			$("#csline").val(data[1].pCsline);
//    			$("#xq").val(data[1].pXq);
//    			$("#disk").val(data[0].pDisk);
//    			$("#lostline").val(data[0].pLostline);
   			},
   			error :function(){
   				
   				alert("cuole");
   			}
		
		});
}



function updatePaa(){

	$.ajax({
		url:"cdset/updatecompanySelective.action",
		type:"post",
// 			dataType:"json",
		 	async: false,
			data:$("#formset").serialize(),
			success:function(data){
				$.messager.alert("提示信息","保存成功！","info");
		
			},
			error :function(){
				
				alert("cuole");
			}
	
	});
}
	
	




</script>
		

</body>
</html>