<!DOCTYPE html>
<html>
<head>
  <!-- Standard Meta -->
  <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <!-- Site Properties -->
  <title>Login Example - Semantic</title>
  <link rel="stylesheet" type="text/css" href="dist/components/reset.css">
  <link rel="stylesheet" type="text/css" href="dist/components/site.css">

  <link rel="stylesheet" type="text/css" href="dist/components/container.css">
  <link rel="stylesheet" type="text/css" href="dist/components/grid.css">
  <link rel="stylesheet" type="text/css" href="dist/components/header.css">
  <link rel="stylesheet" type="text/css" href="dist/components/image.css">
  <link rel="stylesheet" type="text/css" href="dist/components/menu.css">

  <link rel="stylesheet" type="text/css" href="dist/components/divider.css">
  <link rel="stylesheet" type="text/css" href="dist/components/segment.css">
  <link rel="stylesheet" type="text/css" href="dist/components/form.css">
  <link rel="stylesheet" type="text/css" href="dist/components/input.css">
  <link rel="stylesheet" type="text/css" href="dist/components/button.css">
  <link rel="stylesheet" type="text/css" href="dist/components/list.css">
  <link rel="stylesheet" type="text/css" href="dist/components/message.css">
  <link rel="stylesheet" type="text/css" href="dist/components/icon.css">
    <!-- 引入EasyUI的样式文件-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/easyui/themes/default/easyui.css" type="text/css"/>

<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/easyui/themes/icon.css" type="text/css"/>

  <script src="dist/assets/library/jquery.min.js"></script>
  <script src="dist/components/form.js"></script>
  <script src="dist/components/transition.js"></script>
<!--   牛逼背景 -->
	<link href="https://fonts.googleapis.com/css?family=Cormorant+Garamond" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="js/loginBargand/css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="js/loginBargand/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="js/loginBargand/css/demo-entry.css" />
	<script>document.documentElement.className = 'js';</script>
  <style type="text/css">
  </style>
  
</head>
<body>
<div id="user-add-dialog"></div>
<div id="clearUserLock-dialog"></div>
		<main>
			<div class="content">
				<nav class="page-nav">
<div class="ui middle aligned center aligned grid">
  <div class="column">
    <h2 class="ui teal image header">
<!--       <img src="dist/assets/images/logo.png" class="image"> -->
      <img src="js/loginBargand/img/1c.jpg" class="image">
      <div >
        Log-in to your account
      </div>
    </h2>
	    	<form id="ajaxfor"  class="ui large form">
			      <div class="ui stacked segment">
				        <div class="field">
				          <div class="ui left icon input">
				            <i class="user icon"></i>
<!-- 				            用户名 -->
				            <input type="text" id="name" name="username" placeholder="E-mail address"><span id="userNameCheck"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				            
				            <div>
				            	<br>
						       <a href="javascript:addLoginUser()">注册账号</a>
						    </div>
				          </div>
				        </div>
				        <div class="field">
				          <div class="ui left icon input">
				            <i class="lock icon"></i>
<!-- 				            密码 -->
				            <input type="password" id="pwd" name="userpwd" placeholder="Password"><span id="userPassCheck"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				            <div>
				            	<br>
						       <a href="javascript:clearUserLock()">解锁账号</a>
						    </div>
				          </div>
				        </div>
				        <div class="field">
				          <div class="ui left icon input">
<!-- 				            <i class="lock icon"></i> -->
<!-- 				            验证码 -->
				            <input type="text" name="checkImg"><span id="chdckImgFont"></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				            <a href="javascript:F5Img('<%=request.getContextPath()%>')">
								<img src="<%=request.getContextPath()%>/imgF5" id="img" />
							 </a>
				            
				          </div>
				        </div>
<!-- 				        登录按钮 -->
			        	<div onclick="sub()" class="ui fluid large teal submit button">Login</div>
			      </div>
			      <div class="ui error message"></div>
	   		</form>
	   		 <div >
  		    忘记密码? <a href="getlogin.jsp">Sign Up</a>
    </div>
  </div>
</div>
				
					<a class="page-nav__item page-nav__item--close" href="#">Back</a>
				</nav>
				<div class="pieces" style="background-image: url(js/loginBargand/img/e.jpg)"></div>
				<h2 class="content__title">Explore</h2>
			</div>
		</main>
</main>

<script type="text/javascript" src="<%=request.getContextPath()%>/easyui/jquery.min.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript" src="<%=request.getContextPath()%>/easyui/jquery.easyui.min.js"></script>
<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript" src="<%=request.getContextPath()%>/easyui/locale/easyui-lang-zh_CN.js"></script>
  <script type="text/javascript">
  
  function sub(){

	   	var userNameCheck = document.getElementById("userNameCheck");
	   	var chdckImgFont = document.getElementById("chdckImgFont");
	   	var userPassCheck = document.getElementById("userPassCheck");
	   	

		   $.ajax({
				url:"user/login.action",
				data:$("#ajaxfor").serialize(),
				type:"post",
				anync:false,
				success:function(data) {
					alert(data)
				    if(data=="LoginNameError"){
//	 					alert("用户名不存在!")
						userNameCheck.innerHTML="<font color='red'>用户名不存在!</font>";
					}else if(data == "LoginUserLock"){
//	 					alert("用户锁定！")
						userNameCheck.innerHTML="<font color='red'>用户锁定！</font>";
					}else if(data == "LoginError"){
//	 					alert('密码错误,错误三次将锁定用户！')
					userPassCheck.innerHTML="<font color='red'>密码错误,错误三次将锁定用户！</font>";
					}else if(data == "LoginLock"){
//	 					alert('错误三次,锁定用户！')
						userNameCheck.innerHTML="<font color='red'>错误三次,锁定用户！</font>";
					}else if(data == "ImgError"){
//	 					alert("验证码错误");
						chdckImgFont.innerHTML="<font color='red'>验证码错误!<font>";
					}else{
						location.href="<%=request.getContextPath()%>/1.jsp";
					}
				},
				error:function(data){
					alert("程序错误,请检查网络或服务器!");
				}
		 
	   });
		
	}
	 //刷新验证码
		function F5Img(path){
			//Math.random() 保证每次的请求地址都不一样
			document.getElementById("img").src = path+"/imgF5?"+Math.random();
		}
		function addLoginUser(){
			// 	注册弹框
		 	$("#user-add-dialog").dialog({    
		 	    title: '注册',    
		 	    width: 550,    
		 	    height: 400,    
		 	    closed: false,    
		 	    cache: false,    
			    href: '<%=request.getContextPath()%>/user/addLoginUser.action',    
		 	    modal: true,
		 	});
		}
		
		function clearUserLock(){
			// 	解锁弹框弹框
		 	$("#clearUserLock-dialog").dialog({    
		 	    title: '注册',    
		 	    width: 550,    
		 	    height: 400,    
		 	    closed: false,    
		 	    cache: false,    
			    href: '<%=request.getContextPath()%>/user/clearUser.jsp',    
		 	    modal: true,
		 	});
		}
  </script>
<script src="js/loginBargand/js/imagesloaded.pkgd.min.js"></script>
		<script src="js/loginBargand/js/anime.min.js"></script>
		<script src="js/loginBargand/js/main.js"></script>
		<script>
		{
			imagesLoaded(document.body, { background: true }, ()=>document.body.classList.remove('loading'));

			const piecesEl = document.querySelector('.content .pieces');
			const piecesObj = new Pieces(piecesEl, {
				 pieces: {rows: 14, columns: 12}
			});
			const menuEl = document.querySelector('.page-nav');
			const optionsCtrl = document.querySelector('.content__title');
			const closeOptionsCtrl = menuEl.querySelector('a.page-nav__item--close');

			const showOptions = () => {
				menuEl.classList.add('page-nav--open');

				piecesObj.animate({
					duration: 3000,
					delay: (t,i) => {
						const elBounds = piecesEl.getBoundingClientRect();
						const x1 = elBounds.left + elBounds.width/2;
						const y1 = elBounds.top + elBounds.height/2;
						const tBounds = t.getBoundingClientRect();
						const x2 = tBounds.left + tBounds.width/2;
						const y2 = tBounds.top + tBounds.height/2;
						const dist = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
						const maxDist = Math.sqrt(Math.pow(elBounds.left-x1,2) + Math.pow(elBounds.top-y1,2));
						const maxDelay = 300;

						t.dataset.centerx = x2;
						t.dataset.centery = y2;

						return -1*maxDelay/maxDist*dist + maxDelay;
					},
					easing: [0.1,1,0,1],
					translateX: (t,i) => { 
						return t.dataset.column < piecesObj.getTotalColumns()/2 ? anime.random(-400,0) : anime.random(0,400);
					},
					translateY: (t,i) => { 
						return t.dataset.row < piecesObj.getTotalRows()/2 ? anime.random(-400,0) : anime.random(0,400);
					},
					opacity: 0.2
				});
				
				anime.remove(optionsCtrl);
				anime({
					targets: optionsCtrl,
					duration: 700,
					easing: 'easeOutExpo',
					scale: 1.2,
					opacity: 0
				});

				anime.remove(menuEl);
				anime({
					targets: menuEl,
					duration: 700,
					delay: 150,
					easing: 'easeOutExpo',
					scale: [0,1],
					opacity: 1
				});
			};

			const hideOptions = (ev) => {
				ev.preventDefault();
				menuEl.classList.remove('page-nav--open');

				piecesObj.animate({
					duration: 600,
					delay: (t,i) => {
						const elBounds = piecesEl.getBoundingClientRect();
						const x1 = elBounds.left + elBounds.width/2;
						const y1 = elBounds.top + elBounds.height/2;
						const x2 = t.dataset.centerx;
						const y2 = t.dataset.centery;
						const dist = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
						const maxDist = Math.sqrt(Math.pow(elBounds.left-x1,2) + Math.pow(elBounds.top-y1,2));
						const maxDelay = 800;

						return maxDelay/maxDist*dist;
					},
					easing: [0.1,1,0,1],
					translateX: 0,
					translateY: 0,
					opacity: 1
				});
				
				anime.remove(optionsCtrl);
				anime({
					targets: optionsCtrl,
					duration: 700,
					delay: 200,
					easing: 'easeOutQuint',
					scale: [1.1,1],
					opacity: 1
				});

				anime.remove(menuEl);
				anime({
					targets: menuEl,
					duration: 700,
					easing: 'easeOutQuint',
					scale: 0.8,
					opacity: 0
				});
			};

			optionsCtrl.addEventListener('click', showOptions);
			closeOptionsCtrl.addEventListener('click', hideOptions);
		}
		</script>
		<script src="js/loginBargand/pater/pater.js"></script>
</body>

</html>
