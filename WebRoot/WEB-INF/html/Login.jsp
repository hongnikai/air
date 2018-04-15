<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html style="width: 100%; height: 100%;">

	<head>
		<meta charset="utf-8">
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="../css/login.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	    <script type="text/javascript" src="../js/jquery-3.1.0.min.js" charset="utf-8"></script>
	</head>
	<body style="background-color:#50BD65">
		<div class="login-wrap">
			<h2><font>空调金管家</font><br>后 台 管 理 系 统</h2>
			<div class="login">
				<div class="username-wrap"><img src="../img/user.png" style=""/><input class="username" type="text" placeholder="用户名" id="txtUser" name=""></div>
				<div class="password-wrap"><img src="../img/lock.png" /><input class="password" type="password" placeholder="密码" id="txtPassword" name=""></div>
				<div class="login-type">登录类型
					<select name="user_type" id="user_type">
						<option value="4">总管理员</option>
						<option value="3">管理员</option>
					</select>
				</div>
				<button class="log" type="button" onclick="login()">登录</button>
			</div>
		</div>
		<div class="yy2">
			<div class="tishi">
				<h2>账号或密码不能为空</h2>
				<button class="close">确定</button>
			</div>
		</div>
		<script type="text/javascript">
			// 判断回车  
			function keydown(e) {
				var e = e || event;
				if(e.keyCode == 13) {
					$(".log").click();
				}
			}
			document.onkeydown = keydown;
			//登录
			function login(){
				var username = $("#txtUser").val();
				var password = $("#txtPassword").val();
				var type = $("#user_type").val();
				if(username == "" || password == ""){
					$('.yy2').show();
					return false;
				}
				$.ajax({
			           dataType: "json",
			           type: "post",
			           url: "../system/loginManager.do",
			           data:{
			           		"username":username,
			           		"password":password,
			           		"type":type
			           },
			           success: function(data){
			           		if(data.object == 1){
			           			window.location.href = "../targetBackstage/index.do";
			           		}else{
			           			alert(data.object);
			           		}
			           },
			           error: function(msg){
							alert("哎呀网络开小差了，稍等会吧！");
							console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
						},
						async:false
			      });
				
			}
			//关闭弹窗
			$('.close').click(function(){
				$('.yy2').hide();
			})
		</script>

	</body>

</html>
