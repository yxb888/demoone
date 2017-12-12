<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
application.setAttribute("basePath", basePath);
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/easyui/themes/default/easyui.css" type="text/css"/>
<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet"href="<%=request.getContextPath()%>/easyui/themes/icon.css" type="text/css"/>
<script src="<%=request.getContextPath()%>/easyui/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/easyui/jquery.easyui.min.js"></script>
<script src="<%=request.getContextPath()%>/easyui/locale/easyui-lang-zh_CN.js"></script>
<style>
.code_bg{
    position: fixed;
    top:0;
    left: 0;
    right:0;
    bottom:0;
    background-color: rgba(0,0,0,.5);
    z-index: 99;
}
.icon-login-bg{
    background-image: url(../img/icon/loginicon.png);
    background-repeat: no-repeat;
}
.code-con{
    position: absolute;
    top:100px;
    width: 320px;
    left: 50%;
    margin-left: -160px;
    background-color: #fff;
    z-index: 100;
    -moz-user-select: none;
    -webkit-user-select: none;
}
.code-img{
    margin: 5px 5px;
    padding: 5px 5px;
    background-color: #f5f6f7;
}
.code-img img{
    display: block;
}
.icon-w-25{
    display: inline-block;
    width: 25px;
    height: 25px;
    text-indent: -9999px;
}
.icon-push{
    cursor: pointer;
    background-position: -149px -95px;
}
.code-push{
    height: 25px;
}
.code-btn{
    position: relative;
    height: 30px;
    text-align: center;
    color: #999;
    margin: 10px 10px;
    box-sizing: border-box;
    background-color: #f5f6f7;
    border-radius: 15px;
    border: 1px solid #e1e1e1;
}
.code-btn-m{
    position: absolute;
    width: 40px;
    height: 40px;
    border-radius: 50%;
    background-color: #f5f6f7;
    border: 1px solid #e1e1e1;
    z-index: 5;
    top:-8px;
    left: 10px;
    box-shadow: 0 0 3px #ccc;
    cursor: pointer;
    background-position: -63px 10px;
}
.code-btn-img{
    background-image:url(../img/icon/codejt.png);
    background-repeat: no-repeat;
}
.code-btn-img.active{
    background-position: -134px 10px;
}
.code-btn-img.error{
    background-position: 8px 10px;
}
.code-img-con{
    position: relative;
}
.code-mask{
    position: absolute;
    top:0;
    left: 0;
    z-index: 10;
}
.code-tip{
    padding-left: 10px;
    font-size: 12px;
    color: #999;
}
.code-tip-red{
    color: red;
}
.code-tip-green{
    color: green;
}
</style>

<body>

<script>
(function ($) {
    $.fn.imgcode = function (options) {
        //初始化参数
        var defaults = {
            callback:""  //回调函数
        };
        var opts = $.extend(defaults, options);
        return this.each(function () {
            var $this = $(this);//获取当前对象
            var html = '<div class="code-k-div">' +
                '<div class="code_bg"></div>' +
                '<div class="code-con">' +
                '<div class="code-img">' +
                '<div class="code-img-con">' +
                '<div class="code-mask"><img src="../img/front(1).png"></div>' +
                '<img src="../img/back(1).png"></div>' +
                '<div class="code-push"><i class="icon-login-bg icon-w-25 icon-push">刷新</i><span class="code-tip"></span></div>' +
                '</div>' +
                '<div class="code-btn">' +
                '<div class="code-btn-img code-btn-m"></div>' +
                '<span>按住滑块，拖动完成上方拼图</span>' +
                '</div></div></div>';
            $this.html(html);

            //定义拖动参数
            var $divMove = $(this).find(".code-btn-img"); //拖动按钮
            var $divWrap = $(this).find(".code-btn");//鼠标可拖拽区域
            var mX = 0, mY = 0;//定义鼠标X轴Y轴
            var dX = 0, dY = 0;//定义滑动区域左、上位置
            var isDown = false;//mousedown标记
            if(document.attachEvent) {//ie的事件监听，拖拽div时禁止选中内容，firefox与chrome已在css中设置过-moz-user-select: none; -webkit-user-select: none;
                $divMove[0].attachEvent('onselectstart', function() {
                    return false;
                });
            }
            //按钮拖动事件
            $divMove.on({
                mousedown: function (e) {
                    //清除提示信息
                    $this.find(".code-tip").html("");
                    var event = e || window.event;
                    mX = event.pageX;
                    dX = $divWrap.offset().left;
                    dY = $divWrap.offset().top;
                    isDown = true;//鼠标拖拽启
                    $(this).addClass("active");
                    //修改按钮阴影
                    $divMove.css({"box-shadow":"0 0 8px #666"});
                }
            });
            //鼠标点击松手事件
            $(document).mouseup(function (e) {
                var lastX = $this.find(".code-mask").offset().left - dX - 1;
                isDown = false;//鼠标拖拽启
                $divMove.removeClass("active");
                //还原按钮阴影
                $divMove.css({"box-shadow":"0 0 3px #ccc"});
                checkcode(lastX);
            });
            //滑动事件
            $divWrap.mousemove(function (event) {
                var event = event || window.event;
                var x = event.pageX;//鼠标滑动时的X轴
                if (isDown) {
                    if(x>(dX+30) && x<dX+$(this).width()-20){
                        $divMove.css({"left": (x - dX - 20) + "px"});//div动态位置赋值
                        $this.find(".code-mask").css({"left": (x - dX-30) + "px"});
                    }
                }
            });
            //验证数据
            function checkcode(code){
                var iscur=false;
                //模拟ajax
                setTimeout(function(){
                    if(iscur){
                        checkcoderesult(1,"验证通过");
                        $this.find(".code-k-div").hide();
                        opts.callback({code:1000,msg:"验证通过",msgcode:"23dfdf123"});
                    }else{
                        $divMove.addClass("error");
                        checkcoderesult(0,"验证不通过");
                        opts.callback({code:1001,msg:"验证不通过"});
                        setTimeout(function() {
                            $divMove.removeClass("error");
                            $this.find(".code-mask").animate({"left":"0px"},200);
                            $divMove.animate({"left": "10px"},200);
                        },400);
                    }
                },500)
            }
            //验证结果
            function checkcoderesult(i,txt){
                if(i==0){
                    $this.find(".code-tip").addClass("code-tip-red");
                }else{
                    $this.find(".code-tip").addClass("code-tip-green");
                }
                $this.find(".code-tip").html(txt);
            }
        })
    }
})(jQuery);





</script>

<div id="imgscode"></div>
<script>
$("#imgscode").imgcode();
</script>





</body>
</html>