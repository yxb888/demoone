/*
File Name: CheckInput.js
Author: wei zhang
Date: 2011-5-12
* 1. CheckNumber 校验日期格式
* 2. CheckDate 比较两个日期输入栏位日期大小
* 3. CompareDate 校验开始日期必须在结束日期之前
* 4. CompareMonth 校验开始日期必须比结束日期早若干个月
* 5. CheckLength 校验输入字符串的长度
* 6. CheckEmail 校验 email 格式
* 7. CheckPhoneNum 校验电话号码格式
* 8. CheckNull 非空校验
* 9. CheckValue(两个，参数列表不一样) 输入值的取值区间校验
* 10.CheckSelect 检查下拉框的选择
* 11.isEmpty 校验输入的参数是否为NULL
* 12.isPosInteger 包含0的整数
* 13.isNature 自然数：大于零的整数
* 14.isNumberOrNull 校验输入为数值或为空
* 15.isInteger 包括0的整数
* 16.isNumber 浮点数
* 17.isSKU 正确的SKU编号（但库中不一定存在)
* 18.isArabic 由数字组成的字串
* 19.isPosNumber 不为负的浮点数,包括0
* 20.isType 检测数据类型是否合法 
* 21.isChinese 检测是否为中文字符
* 22.gID:document.getElementById的简写
* 23.CheckNullNew:新的表单校验是否为空，如果为空，一律返回false，然后自己写显示在div的信息
* 24.doReset：表单重置的方法
* 26. CompareDate 校验开始日期必须在结束日期之前（新方法）
*/

/**
 * document.getElementById的简写
 */
function gID(id)
{	
	// return HTML object by object id
	var obj = document.getElementById(id);
	return obj ? obj : undefined;
}

/**
 * 校验时，转换每个输入框的class
 * 
 * @param form_name：form的名称
 * @param input_type：input标签的类型，一般都是text
 * @param error_input_name:要验证的输入框的name
 * @param orginal_class_name:原始状态的class的名称
 * @param error_class_name：验证错误后，输入框的要变成的class的名称
 * @return
 */
function changeTextClass(form_name,input_type,error_input_name,orginal_class_name,error_class_name)
{
	// 遍历整个表单
    var form_elements=document.forms[form_name].elements;
    for(var j=0;j<form_elements.length;j++)
    {
    	// 循环该表单
    	// 得到第j个元素
        var this_element=document.forms[form_name].elements[j];
        var temp_input_type=this_element.type;// 该元素的input类型
        var temp_input_name=this_element.name// 该元素的input名称
        
        // 如果该元素的Input类型和传进来的类型匹配
        if(temp_input_type==input_type)
        {
        	// 如果该元素的input名称和传进来的名称匹配，则将该元素的class改变
             if(temp_input_name!=error_input_name)
             {
                 document.forms[form_name].elements[j].className=orginal_class_name;
             }
             else
             {
            	 // 否则class不改变
                 document.forms[form_name].elements[j].className=error_class_name;
             }
        }
    }
}


/**
 * 校验时，转换每个输入框的class
 * 
 * @param form_name：form的名称
 * @param input_type：input标签的类型，一般都是text
 * @param error_input_id:要验证的输入框的ID
 * @param orginal_class_name:原始状态的class的名称
 * @param error_class_name：验证错误后，输入框的要变成的class的名称
 * @return
 */
function changeTextClassById(form_name,input_type,error_input_id,orginal_class_name,error_class_name)
{
	// 遍历整个表单
    var form_elements=document.forms[form_name].elements;
    for(var j=0;j<form_elements.length;j++)
    {
    	// 循环该表单
    	// 得到第j个元素
        var this_element=document.forms[form_name].elements[j];
        var temp_input_type=this_element.type;// 该元素的input类型
        var temp_input_id=this_element.id// 该元素的input的ID
        
        // 如果该元素的Input类型和传进来的类型匹配
        if(temp_input_type==input_type)
        {
        	// 如果该元素的input的ID和传进来的的ID匹配，则将该元素的class改变
             if(temp_input_id!=error_input_id)
             {
                document.forms[form_name].elements[j].className=orginal_class_name;
             }
             else
             {
            	 // 否则class不改变
                 document.forms[form_name].elements[j].className=error_class_name;
             }
        }
    }
}

/**
 * 校验输入必须为数值 frmName 输入框所在的Form txtName 输入框的 name txtLab 输入框的标签
 */
function CheckNumber(frmName,txtName,txtLab)
{
	var frmTemp,temp;
	frmTemp=document.forms[frmName];
	temp=frmTemp.elements[txtName].value;
	if (temp=="")
	{
		// alert("请在" + txtLab +"中输入数字!");
		frmTemp.elements[txtName].focus();
		return false;
	}
	temp= Math.abs(temp);
	if(temp.toString()=="NaN")
	{
		// alert("请在" + txtLab +"中输入数字!");
		frmTemp.elements[txtName].focus();
		return false;
	}
	var re,p;
	re = /\./i;
	temp=temp.toString();
	p=temp.search(re);
	if(p==-1)
	{
		return true;
	}
	else
	{
		temp=temp.substr(p+1);
		if(temp.length>4)
		{
			// alert("在" + txtLab +"中输入数字只允许小数点后四位!");
			frmTemp.elements[txtName].focus();
			return false;
		}
	}
	
	return true;
}

/**
 * 校验输入必须为数值 frmName 输入框所在的Form txtName 输入框的 name
 */
function CheckNumberNew(frmName,txtName)
{
	var frmTemp,temp;
	frmTemp=document.forms[frmName];
	temp=frmTemp.elements[txtName].value;
	
	if (temp=="")
	{
		frmTemp.elements[txtName].focus();
		return false;
	}
	
	temp= Math.abs(temp);
	if(temp.toString()=="NaN")
	{
		frmTemp.elements[txtName].focus();
		return false;
	}
	var re,p;
	re = /\./i;
	temp=temp.toString();
	p=temp.search(re);
	if(p==-1)
		return true;
	else
	{
		temp=temp.substr(p+1);
		if(temp.length>4)
		{
			frmTemp.elements[txtName].focus();
			return false;
		}
	}
	
	return true;
}


/**
 * 校验日期格式 frmName 输入框所在的Form txtName 输入框的 name txtLab 输入框的标签
 */
function CheckDate(frmName,txtName)
{
	var frmTemp,temp,s;

	frmTemp=document.forms[frmName];
	temp=new String(frmTemp.elements[txtName].value);
	s=new String("");

	for(var i=0;i<=temp.length-1;i++)
	{
		if(temp.charAt(i)=="-" || temp.charAt(i)=="/")
			s=s+"/";
		else
		{
			if(isNaN(Number(temp.charAt(i))))
			{
				// alert("在" + txtLab +"中输入的日期格式不对");
				return false;
			}
			else
				s=s+temp.charAt(i);
		}
	}
	
	d = new Date(s);
	if (d.toString()=="NaN")
	{
		// alert("在" + txtLab +"中输入的日期格式不对")
		frmTemp.elements[txtName].focus();
		return false;
	}
	
	return true
}

/**
 * 校验日期格式，带时间,格式为YYYY-MM-DD HH:MM:SS frmName 输入框所在的Form txtName 输入框的 name txtLab
 * 输入框的标签
 */
function CheckDateTime(frmName,txtName)
{
	var frmTemp,tm;

	frmTemp=document.forms[frmName];
	tm = frmTemp.elements[txtName].value;
	var reg = /^(\d+)-(\d{1,2})-(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
    var r = tm.match(reg);    
    if(r==null)return false;    
    r[2]=r[2]-1;    
    var d= new Date(r[1],r[2],r[3],r[4],r[5],r[6]);    
    if(d.getFullYear()!=r[1])return false;    
    if(d.getMonth()!=r[2])return false;    
    if(d.getDate()!=r[3])return false;    
    if(d.getHours()!=r[4])return false;    
    if(d.getMinutes()!=r[5])return false;    
    if(d.getSeconds()!=r[6])return false;    
    return true;    

}
/**
 * 校验日期格式 frmName 输入框所在的Form txtName 输入框的 name
 */
function CheckDateNew(frmName,txtName)
{
	var frmTemp,temp,s;

	frmTemp=document.forms[frmName];
	temp=new String(frmTemp.elements[txtName].value);
	s=new String("");

	for(var i=0;i<=temp.length-1;i++)
	{
		if(temp.charAt(i)=="-" || temp.charAt(i)=="/")
			s=s+"/";
		else
		{
			if(isNaN(Number(temp.charAt(i))))
			{
				return false;
			}
			else
				s=s+temp.charAt(i);
		}
	}
	d=new Date(s);
	if(d.toString()=="NaN")
	{
		frmTemp.elements[txtName].focus();
		return false;
	}
	return true
}

/**
 * 校验开始日期必须在结束日期之前，如果开始日期晚于结束日期，返回 false，否则返回 true dtBegin 开始日期所在输入框 dtEnd
 * 结束日期所在输入框 str 提示信息
 * 
 */
function CompareDate(frmName,dtBegin,dtEnd)
{
	var frmTemp,temp,s;
	
	frmTemp=document.forms[frmName];
	
	temp = new String(frmTemp.elements[dtBegin].value);
	
	s=new String("");
	for(var i = 0;i <= temp.length - 1;i++)
	{
		if(temp.charAt(i)=="-" || temp.charAt(i)=="/")
			s=s+"/";
		
		else
		{
			if(isNaN(Number(temp.charAt(i))))
			{
				// alert("请输入正确的开始日期");
				frmTemp.elements[dtBegin].focus();
				
				return false;
			}
			else
				s = s + temp.charAt(i);
		}
	}
	
	dtOne=new Date(s);
	if(dtOne.toString()=="NaN")
	{
		// alert("请输入正确的开始日期");
		frmTemp.elements[dtBegin].focus();
		
		return false;
	}
	
	frmTemp=document.forms[frmName];
	temp = new String(frmTemp.elements[dtEnd].value);
	
	s=new String("");
	for(var i=0;i<=temp.length-1;i++)
	{
		if(temp.charAt(i)=="-" || temp.charAt(i)=="/")
			s=s+"/";
		else
		{
			if(isNaN(Number(temp.charAt(i))))
			{
				// alert("请输入正确的结束日期");
				
				frmTemp.elements[dtEnd].focus();
				
				return false;
			}
			else
				s = s + temp.charAt(i);
		}
	}
	
	dtTwo=new Date(s);
	if(dtTwo.toString()=="NaN")
	{
		// alert("请输入正确的结束日期");
	
		frmTemp.elements[dtEnd].focus();
		
		return false;
	}
	
	dtTwo=new Date(s);
	if(dtOne.valueOf()>dtTwo.valueOf())
	{
		// alert(str);
	
		frmTemp.elements[dtBegin].focus();
		
		return false;
	}
	else
		return true;
}

/**
 * 校验开始日期必须在结束日期之前，如果开始日期晚于结束日期，返回 false，否则返回 true,格式：YYYY-MM-DD hh:mm:ss
 * dtBegin 开始日期所在输入框 dtEnd 结束日期所在输入框 str 提示信息
 * 
 */
function CompareDateTime(frmName,dtBegin,dtEnd)
{
	var frmTemp,temp,s;
	
	frmTemp=document.forms[frmName];
	
	temp = new String(frmTemp.elements[dtBegin].value.substr(0,10));
	
	s=new String("");
	for(var i = 0;i <= temp.length - 1;i++)
	{
		if(temp.charAt(i)=="-" || temp.charAt(i)=="/")
			s=s+"/";
		
		else
		{
			if(isNaN(Number(temp.charAt(i))))
			{
				// alert("请输入正确的开始日期");
				frmTemp.elements[dtBegin].focus();
				
				return false;
			}
			else
				s = s + temp.charAt(i);
		}
	}
	
	dtOne=new Date(s);
	if(dtOne.toString()=="NaN")
	{
		// alert("请输入正确的开始日期");
		frmTemp.elements[dtBegin].focus();
		
		return false;
	}
	
	frmTemp=document.forms[frmName];
	temp = new String(frmTemp.elements[dtEnd].value.substr(0,10));
	
	s=new String("");
	for(var i=0;i<=temp.length-1;i++)
	{
		if(temp.charAt(i)=="-" || temp.charAt(i)=="/")
			s=s+"/";
		else
		{
			if(isNaN(Number(temp.charAt(i))))
			{
				// alert("请输入正确的结束日期");
				
				frmTemp.elements[dtEnd].focus();
				
				return false;
			}
			else
				s = s + temp.charAt(i);
		}
	}
	
	dtTwo=new Date(s);
	if(dtTwo.toString()=="NaN")
	{
		// alert("请输入正确的结束日期");
	
		frmTemp.elements[dtEnd].focus();
		
		return false;
	}
	
	dtTwo=new Date(s);
	if(dtOne.valueOf()>dtTwo.valueOf())
	{
		frmTemp.elements[dtBegin].focus();
		return false;
	}
	else if(dtOne.valueOf()== dtTwo.valueOf())
	{
		var ss1 = new String(frmTemp.elements[dtBegin].value.substr(10,8));
		var ss2 = new String(frmTemp.elements[dtEnd].value.substr(10,8));
		if(ss1 > ss2)
		{
			frmTemp.elements[dtBegin].focus();
			return false;
		}else
			return true;
		
	}
	else
		return true;
}

/**
 * 校验开始日期必须在结束日期之前，如果开始日期晚于结束日期，返回 false，否则返回 true dtBegin 开始日期所在输入框的值 dtEnd
 * 结束日期所在输入框的值
 */
function CompareDateNew(dtBegin,dtEnd)
{
	var temp,s;
	temp=new String(dtBegin);
	s=new String("");
	for(var i=0;i<=temp.length-1;i++)
	{
		if (temp.charAt(i)=="-" || temp.charAt(i)=="/")
			s=s+"/";
		
		else
		{
			s=s+temp.charAt(i);
		}
	}
	
	dtOne=new Date(s);
	temp=new String(dtEnd);
	s=new String("");
	for(var i=0;i<=temp.length-1;i++)
	{
		if(temp.charAt(i)=="-" || temp.charAt(i)=="/")
			s=s+"/";
		else
		{
				s=s+temp.charAt(i);
		}
	}
	
	dtTwo=new Date(s);
	if(dtOne.valueOf()>dtTwo.valueOf())
	{
		return false;
	}
	else
		return true;
}


/**
 * 校验开始日期必须比结束日期早若干个月 dtBegin 开始日期所在输入框 dtEnd 结束日期所在输入框 minus 指定要早的月数
 */
function CompareMonth(dtBegin,dtEnd,minus)
{
	var temp,s;
	temp=new String(dtBegin.value);
	s=new String("");
	for(var i=0;i<=temp.length-1;i++)
	{
		if(temp.charAt(i)=="-" || temp.charAt(i)=="/")
			s=s+"/";
		else
		{
			if(isNaN(Number(temp.charAt(i))))
			{
				// alert("请输入正确的开始日期");
				dtBegin.focus();
				return false;
			}
			else
				s=s+temp.charAt(i);
		}
	}
	
	dtOne=new Date(s);
	if(dtOne.toString()=="NaN")
	{
		// alert("请输入正确的开始日期");
		dtBegin.focus();
		return false;
	}

	temp=new String(dtEnd.value);
	s=new String("");
	for(var i=0;i<=temp.length-1;i++)
	{
		if(temp.charAt(i)=="-" || temp.charAt(i)=="/")
			s=s+"/";
		else
		{
			if(isNaN(Number(temp.charAt(i))))
			{
				// alert("请输入正确的结束日期");
				dtBegin.focus();
				return false;
			}
			else
				s=s+temp.charAt(i);
		}
	}
	dtTwo=new Date(s);
	if(dtTwo.toString()=="NaN")
	{
		// alert("请输入正确的结束日期");
		dtEnd.focus();
		return false;
	}
	dtTwo=new Date(s);
	if(((dtTwo.getYear()*12+dtTwo.getMonth())-(dtOne.getYear()*12+dtOne.getMonth()))>=minus)
		return true;
	else
	{
		// alert("开始日期应比结束日期早 " + minus + "月");
		dtBegin.focus();
		return false;
	}
}

function CompareSysDateMonth(begdate,months)
{
	dtTwo = new Date();
	var olddate = new Date(begdate.replace(/\-/g,"/"));
	
	// 得到当前日期
	var strDate = dtTwo.getFullYear()+ '-' + (dtTwo.getMonth()+ 1) + '-'+dtTwo.getDate();
	
	var now = new Date(strDate.replace(/\-/g,"/"));
	
	// 算出上月的时间
	var newdate = new Date(now.setMonth(now.getMonth() - months));

	var newdatevalue = newdate.getYear()+ '-'  + (newdate.getMonth()+ 1 )+ '-' + newdate.getDate();
	
	if (olddate < newdate)
	{
		return false;
	}
	
	return true;
}

function CompareSysDateYear(begdate,years)
{
	dtTwo = new Date();
	var olddate = new Date(begdate.replace(/\-/g,"/"));
	
	// 得到当前日期
	var strDate = dtTwo.getFullYear()+ '-' + (dtTwo.getMonth()+ 1) + '-'+dtTwo.getDate();
	
	var now = new Date(strDate.replace(/\-/g,"/"));
	
	// 算出上月的时间
	var newdate = new Date(now.setYear(now.getYear() - years));

	var newdatevalue = newdate.getYear()+ '-'  + (newdate.getMonth()+ 1 )+ '-' + newdate.getDate();
	
	if (olddate < newdate)
	{
		// alert("只能查询 " + years + " 年以内的数据");
		return false;
	}
	
	return true;
}

/**
 * 校验输入字符串的长度 frmName 表名称 txtName 输入框名称 txtLab 输入框的标签名 minLen 最小长度 maxLen 最大长度
 */
function CheckLength(frmName,txtName,txtLab,minLen,maxLen)
{
	var temp,lCount=0;
	frmTemp=document.forms[frmName];
	temp=new String(frmTemp.elements[txtName].value);
	for(var i =0;i<temp.length;i++)
	{
		if(temp.charCodeAt(i)>255)
			lCount +=2;
		else
			lCount +=1; 
	}
	if(minLen>0 && lCount==0)
	{
		// alert("请输入"+txtLab);
		frmTemp.elements[txtName].focus();
		return false;
	}
	if(lCount<minLen)
	{
		// alert(txtLab +"至少需要输入"+minLen+"个字符");
		frmTemp.elements[txtName].focus();
		return false;
	}
	if(lCount>maxLen)
	{
		// alert(txtLab +"过长，请删减");
		frmTemp.elements[txtName].focus();
		return false;
	}
	
	return true;
}


/**
 * 校验输入字符串的长度 frmName 表名称 txtName 输入框名称 txtLab 输入框的标签名 minLen 最小长度 maxLen 最大长度
 */
function CheckLengthNew(frmName,txtName,minLen,maxLen)
{
	var temp,lCount=0;
	frmTemp=document.forms[frmName];
	temp=new String(frmTemp.elements[txtName].value);
	for(var i =0;i<temp.length;i++)
	{
		if(temp.charCodeAt(i)>255)
			lCount +=2;
		else
			lCount +=1;
	}
/*
 * if(minLen>0 && lCount==0) { alert("请输入"+txtLab);
 * frmTemp.elements[txtName].focus(); return false; }
 */
	if(lCount<minLen)
	{
		/*
         * alert(txtLab +"至少需要输入"+minLen+"个字符");
         * frmTemp.elements[txtName].focus();
         */
		return false;
	}
	if(lCount>maxLen)
	{
/*
 * alert(txtLab +"过长，请删减"); frmTemp.elements[txtName].focus();
 */
		return false;
	}
	return true;
}


/**
 * 校验 email 格式 frmName 表单名称 txtName 输入框名称
 */
function CheckEmail(frmName,txtName)
{
	var frmTemp,temp;
	frmTemp=document.forms[frmName];
	temp=frmTemp.elements[txtName].value;

	var i = temp.indexOf("@");
	var j = temp.indexOf(".");
	if(parseInt(i)>1 )
		return true;
	else
	{
		return false;
	}
}

/**
 * 校验电话号码格式 frmName 表单名称 txtName 输入框名称 txtLab 输入框标签名
 */
function CheckPhoneNum(frmName,txtName,txtLab)
{
	var frmTemp,temp;
	frmTemp=document.forms[frmName];
	temp=frmTemp.elements[txtName].value;

	if(temp=="")
	{
		// alert("请在" + txtLab +"中输入数据!")
		frmTemp.elements[txtName].focus();
		return false;
	}

	var re = /[^1234567890()-]/i;
	if(!temp.search(re))
	{
		// alert("请在" + txtLab +"中输入正确的号码!")
		frmTemp.elements[txtName].focus();
		return false;
	}
	return true;
}

/**
 * 非空校验 frmName 表单名称 txtName 输入框名称 txtLab 输入框标签名
 */
function CheckNull(frmName,txtName,txtLab)
{
	var frmTemp,temp;
	frmTemp=document.forms[frmName];
	temp=frmTemp.elements[txtName].value;

	if(temp=="")
	{
// alert("请输入" + txtLab + "！");
		frmTemp.elements[txtName].focus();
		return false;
	}
	return true;
}

/**
 * 非空校验 frmName 表单名称 txtName 输入框名称
 */
function CheckNullNew(frmName,txtName)
{
	var frmTemp,temp;
	frmTemp=document.forms[frmName];
	temp=frmTemp.elements[txtName].value;
    temp=temp.replace(/\s+/g,"");
	if(temp=="")
	{
		return false;
	}
	return true;
}

function isType4Form(frmName,txtName,checkType){
     var frmTemp,temp;
    frmTemp=document.forms[frmName];
    var el = frmTemp.elements[txtName];
    temp=frmTemp.elements[txtName].value;
    return checkType4Form(checkType, temp);
}
/**
 * 非空校验,可检查数组 frmName 表单名称 txtName 输入框名称
 */
function CheckNullForAll(frmName,txtName)
{
	var frmTemp,temp,txtTemp;
	frmTemp=document.forms[frmName];
	txtTemp = frmTemp.elements[txtName];
	if(txtTemp.length == undefined){
		temp=txtTemp.value;
	    temp=temp.replace(/\s+/g,"");
		if(temp=="")
		{
			return false;
		}
		return true;
	}else{
		var flag = true;
		for(var i=0;i<txtTemp.length;i++){
			temp=txtTemp[i].value;
		    temp=temp.replace(/\s+/g,"");
			if(temp=="")
			{
				flag = false;
				break;
			}
		}
		return flag;
	}
}

/**
 * 输入值的取值区间校验，在 minValue 和 maxValue 之间返回 true，否则返回 false frmName 表单名称 txtName
 * 输入框名称 txtLab 输入框标签名 minValue 最小值 maxValue 最大值
 */
function CheckValue(frmName,txtName,txtLab,minValue,maxValue)
{
	var frmTemp,temp;
	frmTemp=document.forms[frmName];
	temp=frmTemp.elements[txtName].value;
	if (temp=="")
	{
		// alert("请在" + txtLab +"中输入数字!");
		frmTemp.elements[txtName].focus();
		
		return false;
	}
	temp=Number(temp);;
	if(isNaN(temp))
	{
		// alert("请在" + txtLab +"中输入数字!");
		frmTemp.elements[txtName].focus();
		return false;
	}
	else
	{
		if(temp>=minValue && temp<=maxValue)
			return true;
		else
		{
			// alert("请在" + txtLab +"中输入正确值：介于"+minValue+" 与 "+maxValue+" 之间!");
			frmTemp.elements[txtName].focus();
			return false;
		}
	}
}

/**
 * 输入值的取值区间校验，在 minValue 和 maxValue 之间返回 true，否则返回 false obj 输入框 txtLab 输入框标签名
 * minValue 最小值 maxValue 最大值
 */
function CheckValue(obj,txtLab,minValue,maxValue)
{
	var temp;
	temp=obj.value;
	if (temp=="")
	{
		// alert("请在" + txtLab +"中输入数字!");
		obj.focus();
		return false;
	}
	temp=Number(temp);
	if(isNaN(temp))
	{
		// alert("请在" + txtLab +"中输入数字!");
		obj.focus();
		return false;
	}
	else
	{
		if(temp>=minValue && temp<=maxValue)
			return true;
		else
		{
			// alert("请在" + txtLab +"中输入正确值：介于"+minValue+" 与 "+maxValue+" 之间!");
			obj.focus();
			return false;
		}
	}
}

/**
 * 检查下拉框的选择 frmName 表单名称 txtName 输入框名称 txtLab 输入框标签名称 intIllegue 不合法值
 */
function CheckSelect(frmName,txtName,txtLab,intIllegue)
{
	var frmTemp,temp;
	frmTemp=document.forms[frmName];
	temp=frmTemp.elements[txtName].value;
	
	if (temp==intIllegue)
	{
		// alert("请在" + txtLab +"中选择");
		frmTemp.elements[txtName].focus();
		
		return false;
	}
	
	return true;
}

/**
 * @parm isEmpty : 校验输入的参数是否为NULL
 * @parm isPosInteger: 包含0的整数
 * @parm isNature : 自然数：大于零的整数
 * @parm isInteger : 包括0的整数
 * @parm isNumber : 浮点数
 * @parm isSKU : 正确的SKU编号（但库中不一定存在)
 * @parm isArabic : 由数字组成的字串
 * @parm isPosNumber : 不为负的浮点数,包括0
 */
function isEmpty(inputStr) 
{
	if (inputStr == null || inputStr == '') return true;
	
	return false;
}

function isInteger(inputVal) 
{
	inputStr = inputVal.toString();
	if (isEmpty(inputStr)) return false;
	
	for (var i = 0; i < inputVal.length; i ++ )
	{
		var oneChar = inputVal.charAt(i);
		if (i == 0 && (oneChar == "+" || oneChar == "-"))
		{
			if (inputVal.length == 1 ) 	
			{
				return false;
			}
			else 
			{
				continue;
			}
		}
		
		if (oneChar < "0" || oneChar > "9")
		{
			return false;
		}	
	}
	
	return true;
}

function isIntegerNew(inputVal) 
{
	inputStr = inputVal.toString();
	if (isEmpty(inputStr)) return false;
	
	for (var i = 0; i < inputVal.length; i ++ ) 
	{
		var oneChar = inputVal.charAt(i);
		if (oneChar < "0" || oneChar > "9")
			return false;
	}
	
	return true;
}

function isPosInteger(input) 
{
	inputVal = input.value;
	if (isEmpty(inputVal))
	{
		// alert ("请输入税!");
		input.focus();
		return false;
	}
	
	for (var i = 0; i < inputVal.length; i ++ ) 
	{
		var oneChar = inputVal.charAt(i);
		if (i == 0 && oneChar == "+")
			if (inputVal.length == 1 )
			{
			// alert ("请输入正的整数!");
				input.focus();
				return false;
			}
			else continue;
		
		if (oneChar < "0" || oneChar > "9")
		{
			// alert ("请输整数!");
			input.focus();
			return false;
		}
	}
	return true;
}

function isNature(inputVal) 
{
	if (isInteger(inputVal)) 
	{
		if (parseInt(inputVal.toString()) < 1 ) return false;
	}
	else	return false;
	
	return true;
}

function isNumberOrNull(inputVal) 
{
	oneDecimal = false;
	inputStr = inputVal.toString();
	
	if (isEmpty(inputStr)) return true;
	
	for (var i = 0; i < inputVal.length; i ++ ) 
	{
		var oneChar = inputVal.charAt(i);
		
		if (i == 0 && (oneChar == "+" || oneChar == "-") )
			if (inputVal.length == 1 ) 	return false;
			else continue;
		if (oneChar == "." && !oneDecimal) {
			oneDecimal = true;
			continue;
		}
		if (oneChar < "0" || oneChar > "9")
			return false;
	}
	
	return true;
}

function isNumberOrNull(frmName,txtName,txtLab)
{
	var frmTemp,temp;
	frmTemp=document.forms[frmName];
	temp=frmTemp.elements[txtName].value;

	if (isEmpty(temp)) return true;
	
	return CheckNumber(frmName,txtName,txtLab);
}

function isNumber(input) 
{
	oneDecimal = false;
	inputVal = input.value;
	
	if (isEmpty(inputVal))
	{
		// alert("请输入正整数!");
		input.focus();
		return false;
	}
	for (var i = 0; i < inputVal.length; i ++ ) 
	{
		var oneChar = inputVal.charAt(i);
		if (i == 0 && (oneChar == "+" || oneChar == "-") )
			if (inputVal.length == 1 )
			{
				// alert("请输入正整数!");
				input.focus();
			 	return false;
			}
			else continue;
		if (oneChar == "." && !oneDecimal) 
		{
			oneDecimal = true;
			continue;
		}
		
		if (oneChar < "0" || oneChar > "9")
		{
			// alert("请输入正整数!");
			input.focus();
		 	return false;
		}
	}
	
	return true;
}

function isPosNumber(input) 
{
	oneDecimal = false;
	inputVal = input.value;
	if (isEmpty(inputVal))
	{
		// alert("请输入正整数!");
		input.focus();
		return false;
	}
	
	for (var i = 0; i < inputVal.length; i ++ ) 
	{
		var oneChar = inputVal.charAt(i);
		if (i == 0 && (oneChar == "+" || oneChar == "-") )
			if (inputVal.length == 1 )
			{
				// alert("请输入正整数!");
				input.focus();
			 	return false;
			}
			else continue;
		if (oneChar == "." && !oneDecimal) 
		{
			oneDecimal = true;
			continue;
		}
		
		if (oneChar < "0" || oneChar > "9")
		{
			// alert("请输入正整数!");
			input.focus();
		 	return false;
		}
	}
	
	if (parseFloat(inputVal) < 0)
	{
		// alert("请输入正数!");
		input.focus();
	 	return false;
	}
	
	return true;
}

function isArabic(inputVal) 
{
	var checkOK = "0123456789";
	var checkStr = inputVal.toString();
	
	if (isEmpty(checkStr)) return false;
	
	for (i = 0;  i < checkStr.length;  i++)
	{
		ch = checkStr.charAt(i);
		if (checkOK.indexOf(ch) == -1)
			return (false);
	}
	
	return true;
}

function CheckSKU(input) 
{
	var checkOK = "0123456789abcdefghijklmnopqrstuvwxzyABCDEFGHIJKLMNOPQRSTUVWXYZ";
	var checkStr = input.value;
	
	if (isEmpty(checkStr))
	{
		alert("请输入SKU!");
		input.focus();
		return false;
	}
	
	if (checkStr.length != 14)
	{
		alert("请输入14位SKU!");
		input.focus();
		return false;
	}
	
	for (i = 0;  i < checkStr.length;  i++)
	{
		ch = checkStr.charAt(i);
		
		if (checkOK.indexOf(ch) == -1)
		{
			alert("SKU中包含非法字符");
			input.focus();
			return (false);
		}
	}
	
	return true;
}
	
// function selectShelf(lStockID,obj,objView)
// {
// if(lStockID==null || lStockID=="" || parseInt(lStockID)==-1 )
// {
// alert("请先选择仓库!");
// return false;
// }
// var strTemp="/inventory/ShelfControlA.jsp?lStockID=" + lStockID;
// var vReturnValue = window.showModalDialog(strTemp,
// "shelf","dialogWidth:650px;dialogHeight:400px;center:true;help:no;resizable:no;status:no");
// if (vReturnValue == -1 || vReturnValue== null)
// {
// obj.value ="";
// objView.value ="";
// }
// else
// {
// var i=vReturnValue.indexOf(";")
// obj.value = vReturnValue.substr(0,i);
// objView.value = vReturnValue.substr(i+1);
// }
// }
	
// function selectShelfB(lStockID,obj,objView,objQty,lProjectID,lProductID)
// {
// if(lStockID==null || lStockID=="" || parseInt(lStockID)==-1 )
// {
// alert("请先选择仓库!");
// return false;
// }
//
// var strTemp="/inventory/ShelfControlA.jsp?lStockID=" +
// lStockID+"&lProjectID=" + lProjectID + "&lProductID=" + lProductID;
// var vReturnValue = window.showModalDialog(strTemp,
// "shelf","dialogWidth:650px;dialogHeight:400px;center:true;help:no;resizable:no;status:no");
// if (vReturnValue == -1 || vReturnValue== null)
// {
// obj.value ="";
// objView.value ="";
// objQty.value="0";
// document.all.item(obj.name + lProductID).innerHTML = "0";
// }
// else
// {
// var i=vReturnValue.indexOf(";")
// obj.value = vReturnValue.substr(0,i);
// var j=vReturnValue.indexOf("#")
// objView.value = vReturnValue.substr(i+1,j-i-1);
// objQty.value=vReturnValue.substr(j+1);
// document.all.item(obj.name + lProductID).innerHTML =
// vReturnValue.substr(j+1);
//
// }
// }

// function selectBatchNo(lStockID,lProductID,objBatchNo,objShelfID,bSingle)
// {
// if(parseInt(lStockID) == -1)
// {
// alert("请先选择仓库!");
// return false;
// }
// if(parseInt(lProductID) == -1)
// {
// alert("请先选择物资!");
// return false;
// }
// if(objBatchNo == "")
// {
// alert("没有批次号文本框的名称");
// return false;
// }
// var strTemp="/inventory/BatchNoControlA.jsp?lStockID=" + lStockID
// +"&lProductID="+lProductID + "&bSingle="+bSingle;
// var vReturnValue = window.showModalDialog(strTemp,
// "","dialogWidth:650px;dialogHeight:400px;center:true;help:no;resizable:no;status:no");
// if (vReturnValue == -1 || vReturnValue== null)
// {
// return true;
// }
// else
// {
// var iPos = 0;
// var iNum = 0;
// var strHtml = "";
// while (iPos < vReturnValue.length)
// {
// iNum = vReturnValue.indexOf(";",iPos);
// strHtml = strHtml + "<input type=\"Text\" readonly class=\"f9\"
// name=\""+objBatchNo+"\" size=\"12\"
// value=\""+vReturnValue.substr(iPos,iNum-iPos)+"\">";
// iPos = iNum + 1;
// if(objShelfID !=null && objShelfID!="")
// {
// iNum = vReturnValue.indexOf("|",iPos);
// strHtml = strHtml + "<input type=\"hidden\" class=\"f9\"
// name=\""+objShelfID+"\" size=\"12\"
// value=\""+vReturnValue.substr(iPos,iNum-iPos)+"\">";
// iPos = iNum + 1;
// iNum = vReturnValue.indexOf("#",iPos);
// strHtml = strHtml + "<input type=\"Text\" readonly class=\"f9\"
// name=\""+objShelfID+"View\" size=\"12\"
// value=\""+vReturnValue.substr(iPos,iNum-iPos)+"\">";
// iPos = iNum + 1;
// }
// else
// {
// iNum = vReturnValue.indexOf("|",iPos);
// iPos = iNum + 1;
// iNum = vReturnValue.indexOf("#",iPos);
// iPos = iNum + 1;
// }
// strHtml = strHtml + "<br>"
// }
// document.all.item("P"+lProductID).innerHTML = strHtml;
// }
// }

// function selectBatchNoB(lStockID,lProductID,objBatchNo,bSingle)
// {
// if(parseInt(lStockID) == -1)
// {
// alert("请先选择仓库!");
// return false;
// }
// if(lProductID==null || lProductID=="")
// {
// alert("请先选择物资!");
// return false;
// }
// if(objBatchNo == "")
// {
// alert("没有批次号文本框的名称");
// return false;
// }
// var strTemp="/inventory/BatchNoControlA.jsp?lStockID=" + lStockID
// +"&lProductID="+lProductID + "&bSingle="+bSingle;
// var vReturnValue = window.showModalDialog(strTemp,
// "","dialogWidth:650px;dialogHeight:400px;center:true;help:no;resizable:no;status:no");
// if (vReturnValue == -1 || vReturnValue== null)
// {
// return true;
// }
// else
// {
// var iNum = vReturnValue.indexOf(";",0);
// objBatchNo.value=vReturnValue.substr(0,iNum);
// }
// }

// function
// selectBatchNoC(lStockID,lProjectID,lProductID,objBatchNo,objShelfID,objQty,bSingle)
// {
// if(parseInt(lStockID) == -1)
// {
// alert("请先选择仓库!");
// return false;
// }
// if(parseInt(lProjectID) == -1)
// {
// alert("请先选择项目!");
// return false;
// }
// if(parseInt(lProductID) == -1)
// {
// alert("请先选择物资!");
// return false;
// }
// if(objBatchNo == "")
// {
// alert("没有批次号文本框的名称");
// return false;
// }
// if(objQty == "")
// {
// alert("没有库存量显示的名称");
// return false;
// }
// var strTemp="/inventory/BatchNoControlC.jsp?lStockID=" + lStockID
// +"&lProjectID="+lProjectID +"&lProductID="+lProductID;
// var vReturnValue = window.showModalDialog(strTemp,
// "","dialogWidth:650px;dialogHeight:400px;center:true;help:no;resizable:no;status:no");
// if (vReturnValue == -1 || vReturnValue== null)
// {
// return true;
// }
// else
// {
// var iPos = 0;
// var iNum = 0;
// var strHtml = "";
// while (iPos < vReturnValue.length)
// {
// iNum = vReturnValue.indexOf(";",iPos);
// document.all.item(objBatchNo).value = vReturnValue.substr(iPos,iNum-iPos);
// //strHtml = strHtml + "<input type=\"Text\" readonly class=\"f9\"
// name=\""+objBatchNo+"\" size=\"12\"
// value=\""+vReturnValue.substr(iPos,iNum-iPos)+"\">";
// iPos = iNum + 1;
// if(objShelfID !=null && objShelfID!="")
// {
// iNum = vReturnValue.indexOf("|",iPos);
// document.all.item(objShelfID).value = vReturnValue.substr(iPos,iNum-iPos);
// //objShelfID.value = vReturnValue.substr(iPos,iNum-iPos);
// //strHtml = strHtml + "<input type=\"hidden\" class=\"f9\"
// name=\""+objShelfID+"\" size=\"12\"
// value=\""+vReturnValue.substr(iPos,iNum-iPos)+"\">";
// iPos = iNum + 1;
// iNum = vReturnValue.indexOf("#",iPos);
// //strHtml = strHtml + "<br><input type=\"Text\" readonly class=\"f9\"
// name=\""+objShelfID+"View\" size=\"12\"
// value=\""+vReturnValue.substr(iPos,iNum-iPos)+"\">";
// iPos = iNum + 1;
// }
// else
// {
// iNum = vReturnValue.indexOf("|",iPos);
// iPos = iNum + 1;
// iNum = vReturnValue.indexOf("#",iPos);
// iPos = iNum + 1;
// }
// iNum = vReturnValue.indexOf("*",iPos);
// //objQty.value = vReturnValue.substr(iPos,iNum-iPos);
// document.all.item(objQty).innerHTML = vReturnValue.substr(iPos,iNum-iPos);
// document.all.item(objShelfID+"Qty").value =
// vReturnValue.substr(iPos,iNum-iPos);
// iPos = iNum + 1;
//
// iNum = vReturnValue.indexOf("%",iPos);
// document.all.item("dRMBPrice"+lProductID).value =
// vReturnValue.substr(iPos,iNum-iPos);
// iPos = iNum + 1;
// iNum = vReturnValue.indexOf("$",iPos);
// document.all.item("dUSDPrice"+lProductID).value =
// vReturnValue.substr(iPos,iNum-iPos);
// iPos = iNum + 1;
// }
// document.all.item("P"+lProductID).innerHTML = strHtml;
// }
// }
	
	/* 检测数据类型是否合法 */ 
function isType(s,t)
{ 
    var RegExpPtn; 
    var RegExpPtn1; 
    var t2=t; 
    
    if (t2 != "")
    { 
        switch(s)
        { 
    		case "QQ":// QQzs
    				RegExpPtn=/^[1-9]c{4,}$/;
    				if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                 	break; 
            case "EN":// 英文
                    RegExpPtn=/^[A-Za-z]+$/; 
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "CN":// 中文 ,如果不判断双字节字符，则为"/^[\u4e00-\u9fa5]+$/"
                    RegExpPtn=/[^\x00-\xff]+$/; 
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "NUM":// 实数
                    RegExpPtn=/^(\+|-)?\d+($|\.\d+$)/; 
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "INT":// 正整数
                    RegExpPtn=/^[1-9]d*$/; 
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "NUMBER":// 数字
                    RegExpPtn=/^[0-9]\d{3}$/; 
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "DATE":// 日期yyyy-mm-dd
                    RegExpPtn=/^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/; 
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "EMAIL":// 邮件
                    RegExpPtn=/\w[\w.-]+@[\w-]+(\.\w{2,})+/gi; 
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "MSN":// MSNzs
                    RegExpPtn=/\w[\w.-]+@msn.com|hotmail.com/g; 
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break;
            case "CARD":// 身份证,也可直接调用isCard()函数
                    return isCard(t2)                                 
                    break; 
            case "URL":// 网址
                    RegExpPtn=/^[a-zA-z]+\:\/\/(\w+(-\w+)*)(\.(\w+(-\w+)*))*(\?\S*)?$/;   
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "IP":// IP地址,,也可直接调用isIP()函数
                    return isIP(t2)                                 
                    break; 
            case "ID1":// ID类型1,充许英文+数字+下划线(0~30字节)
                    RegExpPtn=/^[a-zA-Z][a-zA-Z0-9_]{0,29}$/;   
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "ID3":// ID类型3,充许数字+英文+下划线(0~30字节)
                    RegExpPtn=/^[0-9][a-zA-Z0-9_]{0,29}$/;   
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "ID2":// ID类型1,充许中文+英文+数字+下划线(0~30字节)
                    RegExpPtn=/^[a-zA-Z][a-zA-Z0-9_][_0-9a-zA-Z\u4e00-\u9fa5]{0,29}$/;   
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "ID5":// ID类型5,充许中文+英文(0~30字节)
                    RegExpPtn=/^[a-zA-Z][a-zA-Z\u4e00-\u9fa5]{0,29}$/;   
                    RegExpPtn1=/^[\u4e00-\u9fa5][a-zA-Z\u4e00-\u9fa5]{0,29}$/;  
                    if (!(RegExpPtn.test(t2)||RegExpPtn1.test(t2))){return false;}else{return true;} 
                    break; 
            case "LetterAndNum":// LetterAndNum类型,充许数字+英文(0~30字节)
                    RegExpPtn=/^[0-9][a-zA-Z0-9]{0,29}$/;   
                     RegExpPtn1=/^[a-zA-Z][a-zA-Z0-9]{0,29}$/;   
                    if (!(RegExpPtn.test(t2)||RegExpPtn1.test(t2)) ){return false;}else{return true;} 
                    break;
            case "LN":// LetterAndNum类型,充许数字+英文(0~30字节)
                RegExpPtn=/^[0-9][a-zA-Z0-9]$/;   
                 RegExpPtn1=/^[a-zA-Z][a-zA-Z0-9]$/;   
                if (!(RegExpPtn.test(t2)||RegExpPtn1.test(t2)) ){return false;}else{return true;} 
                break;
            case "money":
                    RegExpPtn=/^(([1-9]{1}\d*)|([0]{1}))(\.(\d){1,2})?$/; 
                    if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                    break; 
            case "date_day":// 日期yyyy-mm-dd
                RegExpPtn=/^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$/; 
                if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                break; 
            case "chi_string(30)":// 中文长名称，允许中文+英文+数字+下划线(1~30字节)
                RegExpPtn=/^[_0-9a-zA-Z\u4e00-\u9fa5]{0,30}$/;   
                if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                break; 
            case "chi_name(10)":// 中文人名，允许中文(2~10)
                RegExpPtn=/^[^\x00-\xff]{2,10}$/;   
                alert(!RegExpPtn.test(t2));
                if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                break; 
            case "number(10.4)":// 数字，允许小数保留4位
                RegExpPtn=/^-{0,1}\d{1,10}(\.\d{1,4}){0,1}$/; 
                if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                break; 
            case "number(10.2)":// 数字，允许小数保留2位
                RegExpPtn=/^-{0,1}\d{1,10}(\.\d{1,2}){0,1}$/;   
                if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                break; 
            case "number(18.2)":// 数字，允许小数保留2位
                RegExpPtn=/^-{0,1}\d{1,10}(\.\d{1,2}){0,1}$/;   
                if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                break; 
            case "year":// 允许有效年份
                RegExpPtn=/^(1|2){1}\d{3}$/;
                if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                break; 
            case "percentage":// 百分比,允许保留小数2位
                RegExpPtn=/^\d{1,2}(\.\d{1,2}){0,1}$/;   
                if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                break; 
            case "integer(+4)":// 年数,允许整数1-9999
                RegExpPtn=/^[^0]{1}\d{0,3}$/;
                if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                break; 
            case "phoneNumber":// 电话号码,有效电话号码
                RegExpPtn=/^\d{1,30}$/;   
                if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                break;
            case "credentials":// 证件号码,有效证件号码
                RegExpPtn=/^[_0-9a-zA-Z\u4e00-\u9fa5]{0,30}$/;   
                if (!RegExpPtn.test(t2) ){return false;}else{return true;} 
                break; 
            default : break; 
        } 
    }
    else
    { 
        return false;         
    } 
} 

/* 检测数据类型是否合法 */ 
function checkType4Form(s,t)
{ 
    var RegExpPtn; 
    var t2=t; 
    
    if (t2 != "")
    { 
        switch(s)
        { 
            case "date_day":// 日期
                RegExpPtn=/^(1|2)+\d{3}-(1|0){1}[1-9]{1}-(2|1|0){1}[1-9]{1}$/;
                return RegExpPtn.test(t2)?false:"日期格式(yyyy-mm-dd)";
                break; 
            case "chi_string(30)":// 中文长名称
                RegExpPtn=/^[_0-9a-zA-Z\u4e00-\u9fa5]{0,30}$/;   
                return RegExpPtn.test(t2)?false:"允许中文+英文+数字+下划线(1~30)";
                break; 
            case "chi_name(10)":// 中文人名，
                RegExpPtn=/^[^\x00-\xff]{2,10}$/;   
                return RegExpPtn.test(t2)?false:"允许中文名称(2~10)";
                break; 
            case "number(10.4)":// 数字
                RegExpPtn=/^-{0,1}\d{1,10}(\.\d{1,4}){0,1}$/; 
                return RegExpPtn.test(t2)?false:"允许最大10位，小数保留4位";
                break; 
            case "number(10.2)":// 数字
                RegExpPtn=/^-{0,1}\d{1,10}(\.\d{1,2}){0,1}$/;   
                return RegExpPtn.test(t2)?false:"允许最大10位，小数保留2位";
                break; 
            case "number(18.4)":// 数字
                RegExpPtn=/^-{0,1}\d{1,10}(\.\d{1,4}){0,1}$/;   
                return RegExpPtn.test(t2)?false:"允许最大18位，小数保留4位";
            case "number(18.2)":// 数字
                RegExpPtn=/^-{0,1}\d{1,10}(\.\d{1,2}){0,1}$/;   
                return RegExpPtn.test(t2)?false:"允许最大18位，小数保留2位";
                break; 
            case "year":// 年份
                RegExpPtn=/^(1|2){1}\d{3}$/;
                return RegExpPtn.test(t2)?false:"允许有效年份";
                break; 
            case "percentage":// 百分比
                RegExpPtn=/^\d{1,2}(\.\d{1,2}){0,1}$/;   
                return RegExpPtn.test(t2)?false:"允许小数保留2位";
                break; 
            case "integer(+4)":// 年数
                RegExpPtn=/^[^0]{1}\d{0,3}$/;
                return RegExpPtn.test(t2)?false:"合理整数范围1-9999";
                break; 
            case "integer(+8)":// 人数
                RegExpPtn=/^[^0]{1}\d{0,3}$/;
                return RegExpPtn.test(t2)?false:"合理整数范围1-99999999";
                break; 
            case "phoneNumber":// 电话号码
                RegExpPtn=/^\d{1,30}$/;   
                return RegExpPtn.test(t2)?false:"允许有效电话号码";
                break;
            case "credentials":// 证件号码
                RegExpPtn=/^[_0-9a-zA-Z\u4e00-\u9fa5]{0,30}$/;   
                return RegExpPtn.test(t2)?false:"允许有效证件号码";
                break; 
            case "zipCode":// 邮政编码
                RegExpPtn=/^[^0]{1}\d{5}$/;   
                return RegExpPtn.test(t2)?false:"允许有效6位编码";
                break; 
            case "length20":// 长度验证
                return (t2.length<=30)?false:"允许长度小于20";
                break; 
            case "length50":// 长度验证
                return (t2.length<=30)?false:"允许长度小于50";
                break; 
            default : break; 
        } 
    }
    else
    { 
        return false;         
    } 
} 
	
	
// 检查字符串是否全部为中文,返回false,说明是中文字符，否则返回true
function isChinese(value)
{
	var RegExpPtn=/[^\x00-\xff]+$/;// 双字节字符
	for (var i=0;i<value.length;i++) 
	{
        var temp_char=value.charAt(i)
        
    	if (RegExpPtn.test(temp_char))
    	{
			return false;
   		}
	}
		
	return true;
}
	
/**
 * 校验输入必须为数值 frmName 输入框所在的Form txtName 输入框的 name
 */
function CheckNumberValue(temp)
{
	if (temp=="")
	{
		return false;
	}
	
	temp= Math.abs(temp);
	
	if(temp.toString()=="NaN")
	{
		return false;
	}
	
	var re,p;
	re = /\./i;
	temp=temp.toString();
	p=temp.search(re);
	if(p==-1)
		return true;
	else
	{
		temp=temp.substr(p+1);
		
		if(temp.length>4)
		{
			return false;
		}
	}
	
	return true;
}
	
/**
 * 获取当前日期（YYYY-MM-DD）
 * 
 * @param date
 * @return YYYY-MM-DD
 */
function getDateTime(date)   
{   
    var thisYear = date.getFullYear(); 

    var thisMonth = date.getMonth() + 1;   
    
    // 如果月份长度是一位则前面补0
    if(thisMonth<10) 
    {
        thisMonth = "0" + thisMonth; 
    }  
       
    var thisDay = date.getDate();   
    
    // 如果天的长度是一位则前面补0
    if(thisDay<10) 
    {
        thisDay = "0" + thisDay; 
    }  
       
    return thisYear + "-" + thisMonth + "-" + thisDay;   
}
/**
 * js日期对象转换成yyyy-mm-dd格式的日期字符
 * 
 * @param {Object}
 *            date
 * @return {TypeName}
 */
function dateToString(date)   
{   
    var thisYear = date.getFullYear(); 
    var thisMonth = date.getMonth() + 1;      
    // 如果月份长度是一位则前面补0
    if(thisMonth<10) 
    {
        thisMonth = "0" + thisMonth; 
    }      
    var thisDay = date.getDate();     
    // 如果天的长度是一位则前面补0
    if(thisDay<10) 
    {
        thisDay = "0" + thisDay; 
    }         
    return thisYear + "-" + thisMonth + "-" + thisDay;   
}
/**
 * yyyy-mm-dd格式的日期转换成js的日期格式
 * 
 * @param {Object}
 *            dateString
 * @return {TypeName}
 */
function stringToDate(dateString){
	var ss = dateString.split("-");
	if(ss.length == 3){
		var y = parseInt(ss[0]);
		var m = parseInt(ss[1]);
		var d = parseInt(ss[2]);
		var dd = new Date(y,m-1,d);
		return dd;
	}else{
		alert("时间格式出错");
	}
	
}
/**
 * 在yyyy-mm-dd格式的日期的基础上加n天
 * 
 * @param {Object}
 *            day ：yyyy-mm-dd格式的日期
 * @param {Object}
 *            n ：加的天数
 * @return {TypeName}
 */
function addDays(day,n){
	var d = stringToDate(day);
	d.setDate(d.getDate()+n);
	return dateToString(d);
		
}

$.extend($.fn.validatebox.defaults.rules, {
	remoteValid : {
		validator : function(value, param) {
			alert(param[0]);
			$.ajax({url: param[0] + value, type: 'post', dataType: 'json', async: false, 
				success: function(data){
					return data.message === 'ok' ? true : false;
				},
				error: function(){
					return false;
				}
			});
		},
		message : 'Please enter at least {0} characters.'
	}
});