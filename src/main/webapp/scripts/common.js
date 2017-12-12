//--------------------------------------------------------------------------
// File:        common.js
// Description: common function
// Rev:         0.9
// Created:     Apr 13, 2011
// Author:      北京汇金宝科技有限公司 (FangChen)
//
// Copyright Wistron Information Technology & Services Corp.
//
//--------------------------------------------------------------------------

// reset form
function resetForm(formId){
    document.getElementById(formId).reset();
}

// account man-hour
function accountManhour(tcOroc, cr, ta){
    var numberReg = /[0-9]+(\.[0-9]+)?/g;
    var tcOrOcValue = document.getElementById(tcOroc).value;
    var crValue = document.getElementById(cr).value;

    //if TC OR OC is number, then continue
    if( isFloat(tcOrOcValue) ){
        tcOrOcValue = parseFloat(tcOrOcValue);
    } else {
        document.getElementById(ta).value = "";
        return false;
    }

    //if CR is number, then continue
    if( isFloat(crValue) ){
        crValue = parseFloat(crValue);
    } else {
        document.getElementById(ta).value = "";
        return false;
    }

    // TA = TC * CR or TA = OC * CR
    var taValue = tcOrOcValue * crValue;
    document.getElementById(ta).value = toFixedValue(taValue, 2);
}

// to fixed value
function toFixedValue(value, fractionDigits){
    return value.toFixed(fractionDigits);
}

// check the value is alpha
function isAlpha(value){
    var alphaReg = /[a-z]+/g;
    if( value.search(alphaReg) != -1 ){
        return true;
    }
    return false;
}

// check the value is numeric
function isNumeric(value){
    var numericReg = /[0-9]+/g;
    if( value.search(numericReg) != -1 ){
        return true;
    }
    return false;
}

// check the value is Alphanumeric
function isAlphanumeric(value){
    var alphanumericReg = /[a-z0-9]+/g;
    if( value.search(alphanumericReg) != -1 ){
        return true;
    }
    return false;
}

// check the value is Float
function isFloat(value){
    var floatReg = /[0-9]+(\.[0-9]+)?/g;
    if( value.search(floatReg) != -1 ){
        return true;
    }
    return false;
}

// check the value max length
function chkMaxLength(value, maxLength){
    if (value.length > maxLength){
        return false;
    }
    return true;
}

// check the value min length
function chkMinLength(value, minLength){
    if (value.length < minLength){
        return false;
    }
    return true;
}

// To flash point select list
function flashPoint(refreshId, selectPrefix){
    var str = document.getElementById(refreshId).value;
    var arr =str.split(",");
    var selectPrefixReg = eval("/^"+selectPrefix+".*/g");

    var selObj = document.getElementsByTagName("select");
    var selObjLenght = selObj.length;
    for( var i=0 ; i < selObjLenght ; i++ ){
        var selId = selObj[i].id;
        if( selId.search(selectPrefixReg) != -1 ){
            var selObjoneLength = selObj[i].length;
            for( var j = selObjoneLength; j >= 0 ; j-- ){
                selObj[i].remove(j);
            }
            for( var x = 0 ; x < arr.length ; x++ ){
                var optionObj = new Option(arr[x],arr[x]);
                selObj[i].options.add(optionObj);
            }
        }
    }
}

// To flash station select list
function flashStation(refreshId, selectPrefix){
    var str = document.getElementById(refreshId).value;
    var arr =str.split(",");
    var selectPrefixReg = eval("/^"+selectPrefix+".*/g");

    var selObj = document.getElementsByTagName("select");
    var selObjLenght = selObj.length;
    for( var i=0 ; i < selObjLenght ; i++ ){
        var selId = selObj[i].id;
        if( selId.search(selectPrefixReg) != -1 ){
            var selObjoneLength = selObj[i].length;
            for( var j = selObjoneLength; j >= 0 ; j-- ){
                selObj[i].remove(j);
            }
            for( var x = 0 ; x < arr.length ; x++ ){
                var optionObj = new Option(arr[x],arr[x]);
                selObj[i].options.add(optionObj);
            }
        }
    }
}

// Check string not empty
function isEmptyStr(s)
{
    return ((s==null) || (trim(s).length == 0));
}

// To trim blank space in front and behind from a string
function trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g, "");
}

//删除select中的元素
function deleteSelect(id){
	
	var selObj = document.getElementById(id);
    var optionslength = selObj.options.length;
    for( var i = optionslength; i >=0 ; i--){
          selObj.remove(j);
    }
}
//通用页面checkbox的处理方法
function onSelectClick(elementName,targetName){
	var _str="";
	var _form = document.forms[0];
	
	var cb = document.getElementsByName(elementName);
	if(cb.length >1)
    {
	    for(var i=0;i<cb.length;i++)
	    {
			if(cb[i].checked)
			{
				if(cb[i].value != undefined)
					_str += cb[i].value+";";
			}
	    }
	    if(_str.lastIndexOf(";")==_str.length-1){
	    	_str = _str.substring(0, _str.length-1);
	    }
    }
    else{
		_str = document.getElementsByName(elementName)[0].value;
    }
	document.getElementById(targetName).value = _str;
	tb_remove();
}
function onAllSelectClick(flag,elementName){
	var cb = document.getElementsByName(elementName);
	if(cb.length >1)
    {
	    for(var i=0;i<cb.length;i++)
	    {
			cb[i].checked = flag
	    }	
    }
    else{
		cb.checked = flag;
    }
}
