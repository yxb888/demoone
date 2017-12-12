function jumpPage(pageNo) {
	$("#pageNo").val(pageNo);
	$("#mainForm").submit();
}
function goPage(){
	
	var pageNo = $("#cusPageNo").val();
	if (pageNo.search("^-?\\d+$") != 0) {
		return;
	}
	var totalCount = $("#totalCount").val();
	var pageSize = $('#pageSize').val();
	if(parseInt(pageSize,10)==0){
		$.messager.alert("提示信息","每页条数不能为  0 ","error");
		return;
	}
	var totalRow = parseInt(totalCount/pageSize,10);
	if(totalRow==0){
		totalRow+=1;
 	}
	if((totalCount-(pageSize*totalRow))>0){
		totalRow+=1;
	}
	if(parseInt(pageNo,10)>parseInt(totalRow,10)){
		pageNo = totalRow;
	}
	if(parseInt(pageNo,10)<=0){
		pageNo = 1;
	}
	jumpPage(pageNo);
}
function sort(orderBy, defaultOrder) {
	if ($("#orderBy").val() == orderBy) {
		if ($("#order").val() == "") {
			$("#order").val(defaultOrder);
		}
		else if ($("#order").val() == "desc") {
			$("#order").val("asc");
		}
		else if ($("#order").val() == "asc") {
			$("#order").val("desc");
		}
	}
	else {
		$("#orderBy").val(orderBy);
		$("#order").val(defaultOrder);
	}

	$("#mainForm").submit();
}

function search() {
	$("#order").val("");
	$("#orderBy").val("");
	$("#pageNo").val("1");

	$("#mainForm").submit();
}