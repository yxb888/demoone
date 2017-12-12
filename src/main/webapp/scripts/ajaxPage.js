
function setAjaxPage(page,tabId){
	document.getElementById("totalPages"+tabId).innerHTML=page.totalPages;
	document.getElementById("totalCount"+tabId).innerHTML=page.totalCount;
	document.getElementById("_pageNo"+tabId).innerHTML=page.pageNo;

	$("#pageSize"+tabId).val(page.pageSize);
	$("#pageNo"+tabId).val(page.pageNo);
}

function ajaxJumpPage(tabId,refeshFlag){
	var pageNo = $("#pageNo"+tabId).val();
	var pageSize = $("#pageSize"+tabId).val();
	
	if(!isNumeric(pageNo)){
		alert("请输入数字！");
		return;
	}else if(!isNumeric(pageSize)){
		alert("请输入数字！");
		return;
	}
	var _totalPages = document.getElementById("totalPages"+tabId).innerHTML;
	if(parseInt(pageNo) > parseInt(_totalPages)){
		$("#pageNo"+tabId).val(_totalPages)
	}
	if(parseInt(pageNo) < 1){
		$("#pageNo"+tabId).val(1);
	}
	onAjaxSubmit(tabId,refeshFlag);
	
}

function  prePage(tabId)
{
	var pageNo = $("#pageNo"+tabId).val();
	
	if(!isNumeric(pageNo)){
		alert("请输入数字！");
		return;
	}
	if(parseInt(pageNo) <= 1){
		return;
	}
	
	$("#pageNo"+tabId).val(parseInt(pageNo) -1);
	document.getElementById("_pageNo"+tabId).innerHTML=parseInt(pageNo) - 1;
	ajaxJumpPage(tabId,true);
}
function nextPage(tabId){
	var pageNo = $("#pageNo"+tabId).val();
	if(!isNumeric(pageNo)){
		alert("请输入数字！");
		return;
	}
	var _totalPages = document.getElementById("totalPages"+tabId).innerHTML;
	if(parseInt(pageNo) >= parseInt(_totalPages)){
		return;
	}
	
	$("#pageNo"+tabId).val(parseInt(pageNo) + 1);
	document.getElementById("_pageNo"+tabId).innerHTML=parseInt(pageNo) + 1;
	ajaxJumpPage(tabId,true);
}
function lastPage(tabId){
	$("#pageNo"+tabId).val(document.getElementById("totalPages"+tabId).innerHTML);
	ajaxJumpPage(tabId,true);
}
function firstPage(tabId){
	$("#pageNo"+tabId).val(1);
	ajaxJumpPage(tabId,true);
}

function isNumeric(value){
    var numericReg = /[0-9]+/g;
    if( value.search(numericReg) != -1 ){
        return true;
    }
    return false;
}

