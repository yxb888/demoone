//调ajax通用方法 
//param为传入参数 格式：method类型?url?参数
//id：表示在该id下显示
//flag: 表示结果是否需要返回，不返回则显示在id下，需要返回flag=‘return’
function ajax(param,id,flag){
  
	var param_array = param.split("?");
	var asyncValue = true;
	var showContent="";
	if(flag=="return");
		asyncValue = false;
//	$("#"+id).ajaxStart(function(){
//		$("#"+id).html("系统加载数据中，请稍后...");
//	});
	$.ajax({
		type:param_array[0],
		url:param_array[1],
		data:param_array[2],
		async:asyncValue,
		error:function(){
			$("#"+id).html("对不起，系统忙...");
		},
		success:function(html){
			if(flag!='return')
				$("#"+id).html(html);
			else
				showContent = html;
    	}
	});
	return showContent.replace(/^\s*/, "").replace(/\s*$/, "");//去掉左右空格
}	
