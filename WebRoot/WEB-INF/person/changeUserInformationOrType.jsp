<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimum-scale=1.0,maximum-scale=1.0" />
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>注册</title>
	</head>

	<body>
		<header class="header" style="border: 0;">
			<a href=""><img src="../img/icon_back@2x.png" /></a>
		</header>
		<div class="regWrap">
			<div>
				<img src="../img/icon_user@2x.png" />
				<input type="text" name="mobile" id="mobile" placeholder="请输入手机号"/>
			</div>
			<div>
				<img src="../img/lock.png" />
				<input type="text" name="password" id="password"  placeholder="请输入密码"/>
			</div>
		</div>
		<input type="button" value="登录" onclick="login()" class="longBtn"/>
		<script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">

		</script>
	</body>

</html>
<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
function user(data){
	window.location.href="../userController/";
}
function login(){	
	var mobile= $("#mobile").val();
	var password=$("#password").val();
	 $.ajax({
		url:"http://www.kongtiaoguanjia.com/air/userController/roleReLogin.do",
		type:"post",
		data:{"mobile":mobile,"password":password},
		success:function(data){
				if(data.sign==0){
					alert("您输入的账户/密码 不正确")
				}else{
					window.location.href="http://www.kongtiaoguanjia.com/air/targetGongZhongHao/homePage.do";	
				}
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
}) 
}
</script>

