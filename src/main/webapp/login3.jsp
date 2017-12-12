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
    body {
/*       background-color: #DADADA; */
/*         background: #DADADA url(dist/eee.jpg) no-repeat fixed top; */
        background-size:1400px 900px;
      
    }
    body > .grid {
      height: 100%;
    }
    .image {
      margin-top: -100px;
    }
    .column {
      max-width: 450px;
    }
  </style>
  <script>
  
   function sub(){
	var name=   $("#name").val()
	var pwd=   $("#pwd").val()
	   $.ajax({
			url:"user/login.action",
			data:{username:name,userpwd:pwd},
			type:"post",
			anync:false,
			success:function(msg) {
				  if(msg=="ok"){
					  alert("登录成功！");
					   location.href="1.jsp";
				}else{
					
					alert("登录失败，账号或密码错误！");
				}
			},
			error:function(){
				alert("登录失败");
			}
	 
   });}
//   $(document)
//     .ready(function() {
//       $('.ui.form')
//         .form({
//           fields: {
//             email: {
//               identifier  : 'email',
//               rules: [
//                 {
//                   type   : 'empty',
//                   prompt : 'Please enter your e-mail'
//                 },
//                 {
//                   type   : 'email',
//                   prompt : 'Please enter a valid e-mail'
//                 }
//               ]
//             },
//             password: {
//               identifier  : 'password',
//               rules: [
//                 {
//                   type   : 'empty',
//                   prompt : 'Please enter your password'
//                 },
//                 {
//                   type   : 'length[6]',
//                   prompt : 'Your password must be at least 6 characters'
//                 }
//               ]
//             }
//           }
//         })
//       ;
//     })
//   ;
  </script>
</head>
<body>

<div class="ui middle aligned center aligned grid">
  <div class="column">
    <h2 class="ui teal image header">
      <img src="dist/assets/images/logo.png" class="image">
      <div class="content">
        Log-in to your account
      </div>
    </h2>
    <form id="ajaxfor"  class="ui large form">
      <div class="ui stacked segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" id="name" name="username" placeholder="E-mail address">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" id="pwd" name="userpwd" placeholder="Password">
          </div>
        </div>
        <div onclick="sub()" class="ui fluid large teal submit button">Login</div>
      </div>

      <div class="ui error message"></div>

    </form>

    <div class="ui message">
      New to us? <a href="getlogin.jsp">Sign Up</a>
    </div>
  </div>
</div>
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
