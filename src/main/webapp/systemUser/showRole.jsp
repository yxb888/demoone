<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <input type="text" id="userId"  value="${userId}" name="userId">
 <form id="roleForm">
 </form>
      <script type="text/javascript">
          $(function(){
        	  $.ajax({
        		  url:"<%=request.getContextPath()%>/role/roleNodes.action",
        		  data:{"userId":$("#userId").val()},
        		  dataType:"json",
        		  type:"post",
        		  success:function(data){
        			// alert(data); 
        			 var str ="";
        			 for (var i = 0; i < data.list.length; i++) {
// 						alert(data.list[i].rId)
						var count=0;
						for (var j = 0; j < data.roles.length; j++) {
							if(data.roles[j].rId==data.list[i].rId){
								str+="<input type='checkbox' name='id' checked='checked' value='"+data.roles[j].rId+"'>"+data.roles[j].rName+"";
								count=1;
								break;
							}
							
						}
						if(count!=1){
							str+="<input type='checkbox' name='id'  value='"+data.list[i].rId+"'>"+data.list[i].rName+"";
						}
					}
        			 $("#roleForm").html(str);
        		  },error:function(){
        			  alert("错误");
        		  }
        	  })
          })
   

     </script>
</body>
</html>