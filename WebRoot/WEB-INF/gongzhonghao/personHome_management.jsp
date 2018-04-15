<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimum-scale=1.0,maximum-scale=1.0" />
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<title>个人主页</title>
	</head>

	<body>
		<header class="header bB0">
			<a><img src="../img/icon_user_set@2x.png" /></a>
			<a class="r0" ><img src="../img/icon_user_msg@2x.png"/></a>
		</header>
		<div class="headshot center mT5">
			<a href="../userController/targetchangUserInformation.do?au_id=${user.au_id}"><img src="${user.headimg}" /></a>
			<center>管理员${user.nickname}</center>
		</div>
		<p class="personLine">
			<span>员工工作</span>
			<a href="../userController/managementSelectAllEmployee.do" class="fr">查看全部></a>
		</p>
		<footer class="footer">
			<a href="../targetGongZhongHao/homePage.do">
				<img src="../img/icon_home@2x.png" /> 主页
			</a>
			<a class="classify">
				<img src="../img/icon_fenlei@2x.png" /> 分类
			</a>
			<a href="../CommodityOrderController/findAllMyOrder.do?au_id=${user.au_id}">
				<img src="../img/icon_orders@2x.png"/>
				订单
			</a>
			<a href="">
				<img src="../img/icon_user@2x.png"/>
				我的
			</a>
		</footer>
		<div class="menu">
			<ul>
				<li><a href="../commodity/targetContralAirConditionShop.do">中央空调</a></li>
				<li><a href="../commodity/selectCommodity.do">普通空调</a></li>
			</ul>
		</div>
	</body>
</html>
<script type="text/javascript">
$(".classify").toggle(function(){
	$(".menu").show();
},function(){
	$(".menu").hide();
})
</script>