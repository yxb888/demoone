
/**
//滚动条高度
var scrollnum = 0;
//停止滚动的标记
var overflag = 0;

//每次上移20px
function scrollup(){
    if(overflag==2 && scrollnum>0){
    scrollnum = document.getElementById("leftMenuBackground").scrollTop*1-20;
    if(scrollnum<0){scrollnum=0;}
    document.getElementById("leftMenuBackground").scrollTop=scrollnum;

    }
}
//每次下移20px
function scrolldown(){
    var contentH = parseInt(document.getElementById("leftMenu").scrollHeight);
    if(overflag==1 && scrollnum < contentH){
    scrollnum = document.getElementById("leftMenuBackground").scrollTop*1+20;
    if(scrollnum>contentH){scrollnum=contentH;}
    document.getElementById("leftMenuBackground").scrollTop=scrollnum;

    }
}
//鼠标上移
function mouseup(){
    scrollup();
    if(overflag==2 && scrollnum>0){
        setTimeout("mouseup()",100);
    }
}
//鼠标下移
function mousedown(){
    scrolldown();
    var contentH = parseInt(document.getElementById("leftMenu").scrollHeight);
    if(overflag==1 && scrollnum < contentH){
        setTimeout("mousedown()",100);
    }
}
//鼠标移动停止
function mousestop(){
    overflag = 0;
}
//鼠标移动开始
function mousestart(turn){
    overflag = turn;
}
//-->

function showhideScroll(parentPageheighttmp){
    var contentH = parseInt(document.getElementById("leftMenu").scrollHeight);
    if( parseInt(contentH) > parseInt(parentPageheighttmp)) {
    	//alert("1");
        document.getElementById("scrollUp").style.display = "block";
        document.getElementById("scrollDown").style.display = "block";
    } else {
    	//alert("2");
        document.getElementById("scrollUp").style.display = "none";
        document.getElementById("scrollDown").style.display = "none";
        document.getElementById("leftMenuBackground").scrollTop = 0;
    }
}

function writeScroll(){
	
    var parentPageheighttmp =  parseInt( window.document.body.clientHeight);
    var postiontmp = parentPageheighttmp - 110;
    var scrollnum = document.body.scrollTop;
    var contentH = parseInt(document.getElementById("leftMenu").scrollHeight);

    document.getElementById("leftMenuBackground").style.height=postiontmp;

    var isDisplay = "";

//    document.write('<span id="scrollUp" style="position:absolute; left:130px; top:11px; width:15px; height:16px; z-index:2; display:none;">');
//    document.write('<img src="${ctx}/images/scrollup.gif" width="15" height="16" onClick="mousestart(2);scrollup();" onMouseOver="mousestart(2);mouseup();" onMouseOut="mousestop()">');
//    document.write('</span>');
//    document.write('<span id="scrollDown" style="position:absolute; left:130px; top:'+ postiontmp + 'px; width:15px; height:16px; z-index:2; display:none;">');
//    document.write('<img src="${ctx}/images/scrolldown.gif" width="15" height="16"  onClick="mousestart(1);scrolldown();" onMouseOver="mousestart(1);mousedown();" onMouseOut="mousestop()">');
//    document.write('</span>');
    //alert("contentH:"+contentH+"|parentPageheighttmp:"+parentPageheighttmp);
    if( contentH > parentPageheighttmp ) {
        document.getElementById("scrollUp").style.display = "block";
        document.getElementById("scrollDown").style.display = "block";
    } else {
        document.getElementById("scrollUp").style.display = "none";
        document.getElementById("scrollDown").style.display = "none";
    }
}
**/