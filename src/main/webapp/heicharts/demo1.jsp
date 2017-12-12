<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	
</head>
<%-- <%@ include file="/js/esyuijs.jsp"%> --%>
<script src="<%=request.getContextPath() %>/js/jquery-1.7.2.min.js"></script>
	<script src="<%=request.getContextPath() %>/js/Highcharts-5.0.12/code/highcharts.js"></script>
	<script src="<%=request.getContextPath() %>/js/Highcharts-5.0.12/code/modules/exporting.js"></script>
<body>
<div id="container" style="max-width:800px;height:400px"></div>
</body>
<script type="text/javascript">

$(function(){
	$.ajax({
		url:"<%=request.getContextPath() %>/cdset/getHeicharts.action",
		type:"post",
		dataType:"json",
			success:function(dataa){
				Highcharts.chart('container', {
				    title: {
				    	align:"center",
				        text: '2017crm系统注册人数'
				    },
				    subtitle: {
				        text: '数据来源：金科教育'
				    },
				    legend: {
				        layout: 'vertical',
				        align: 'right',
				        verticalAlign: 'middle',
				    },
				    plotOptions: {
				        series: {
//			 	            pointStart: Date.UTC(2017,0,1),
//			 	            pointInterval: 24 * 3600 * 1000 * 30 // 间隔一天
				        }
				    },
				    xAxis: {
				    	categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
				    },
				    yAxis: {
				        title: {
				            text: '注册人数（位）'
				        }
				    },
				    series: [{
				    	type: 'line',
				        name: '2017用户注册人数',
				        data: dataa[0].data1
				    },{
				    	type: 'line',
				        name: '2017管理人员注册人数',
				        data: dataa[0].data2
				    	
				    }
				    
				    ]
				});
				
				
				
			},error:function(){
				alert(2);
			}
	});
})
		
				
	

</script>

</html>