<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String basePath=request.getContextPath()+"/"; 
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <link rel="stylesheet" href="../kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="../kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="../kindeditor/kindeditor-all-min.js"></script>
	<script charset="utf-8" src="../kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="../kindeditor/plugins/code/prettify.js"></script>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
	<script src="../uploadify/jquery.uploadify.min.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="../uploadify/uploadify.css">
	
</head>
<body>
<form action="movieAction_addMovie.action" id="from1" method="post">
   电影名称：  <input    name="moviename"  /><br/>
  电影信息：<textarea   name="movieimgshow"  style=" width:700px;height:200px;">
   
   </textarea><br/>
  
   地区<select name="areaid">
       <option value="0">--请选择--</option>
   
   </select>  &nbsp;&nbsp;   
   
 年代  <select name="timeid">
       <option value="0">--请选择--</option>
   
   </select>
   &nbsp;&nbsp; 
类型  <select name="movieTypeid">
       <option value="0">--请选择--</option>
   
   </select> <br/>
  
   <input type="hidden" name="moviepath" id="moviepath"  /> //上传的路径标签   保存导数据库的真正的文件路径
   
    <input type="submit" value="提交"/>

    
</form>

   <div id="queue"></div>   进度条标签
<input id="file_upload" name="photo" type="file"  />  //上传组件标签
<div  id="imglist"></div>图片显示标签

   


</body>
 <script>
 KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="movieimgshow"]', {
			cssPath : '../kindeditor/plugins/code/prettify.css',
			uploadJson : '../kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '../kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
		})	 
		});
		 
		prettyPrint();
		
		editor1.html("<strong><span style='font-size:24px;'>editor1</span></strong>")
 
 </script>
<script type="text/javascript">

$(function() {
	$('#file_upload').uploadify({
		 
		'swf'      : '../uploadify/uploadify.swf',//动画地址
		'uploader' : 'movieAction_upMovieFile.action',  //上传的action地址
		'fileTypeExts'  :   '*.gif;*.jpg;*.png;*.bmp;*.mp4;*.mpeg4;*.wmv',  //允许上传的文件格式
		'multi'             :   false,   //是否开启多文件上传
		'method'            :   'post', //提交方式
		'fileObjName':'photo',    //服务器 接收的文件名称  
	 
        'onUploadSuccess' : function(file,data) {  
        //参数data服务端输出返回的信息
        	  var  suffix= data.substr(-4)
              
              alert(suffix)
              
              if(suffix==".mp4"||suffix=="peg4"||suffix==".wmv"){
            	  
            	  $("#imglist").append("<video controls='controls'  width='200'  height='300' ><source src='<%=basePath%>"+data+"' type='video/mp4' /></video>"
					  
            	  );
              }else{
          $("#imglist").append("<img  src='<%=basePath%>"+data+"'  width=30 height=30  />")
                alert("<img  src='<%=basePath%>"+data+"'  width=30 height=30  />");
              }
          $("#moviepath").val(data);
    },  
	});
});



 


          $(document).ready(function(){
        	      
        	 
        	//地区   
        	   $.ajax({
        	   
        	url:"areaAction_query.action",   
        	data:"",
        	type:"post",
            
        	
        	success:function(result){
        	
        		result=eval("("+result+")");
        		 
        		 
        		
        		 for(var i=0;i<result.list.length;i++){
						
        			 $("select[name=areaid]").append("<option  value='"+result.list[i].areaid+"'>"+result.list[i].areaname+"</option>")
					} 
        		 
 
        		 
        	
        		
        	}
        	    
        	   
           })
         //时间  
           
         $.ajax({
        	url:"timeAction_querytime.action", 
        	data:"timen=",
        	type:"post",
        	success:function(result){
        		
        		result=eval("("+result+")");
        		
        	   for (var i=0;i<result.list.length;i++){
        		   
        	  $("select[name='timeid']").append("<option value='"+result.list[i].timeid+"'>"+result.list[i].timen+"</option>");   
        		   
        		   
        	   }	
        		
        		
        	}
        	 
        	 
        	 
         })    
           
           
       //类型      
           
         $.ajax({
         	url:"movieTypeAction_queryMovieType.action", 
         	data:"",
         	type:"post",
         	success:function(result){
         		
         		result=eval("("+result+")");
         		
         	   for (var i=0;i<result.objects.length;i++){
         		   
         	  $("select[name='movieTypeid']").append("<option value='"+result.objects[i].movieTypeid+"'>"+result.objects[i].movieTypeName+"</option>");   
         		   
         		   
         	   }	
         		
         		
         	}
         	 
         	 
         	 
          })    
        
  
          
          
          
          }) 










</script>


</html>