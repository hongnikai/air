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
		<script type="text/javascript" src="../js/jquery.js"></script>
		<title>个人主页(销售人员)</title>
	</head>

	<body>
		<header class="header bB0">
			<a href="../targetGongZhongHao/set.do"><img src="../img/icon_user_set@2x.png" /></a>
			<a href="../commodity/targetMyMessage.do?au_id=${user.au_id}" class="r0" ><img src="../img/icon_user_msg@2x.png"/></a>
		</header>
		<div class="headshot center mT5">
			<a href="../userController/targetchangUserInformation.do?au_id=${user.au_id}"><img src="${user.headimg}" /></a>
			<center>销售员${user.nickname}</center>
		</div>
		<p class="personLine">
			<span>销售订单</span>
			<a href="../CommodityOrderController/findAllMyOrder_saleman.do?au_id=${user.au_id}" class="fr">查看全部</a>
		</p>
		<div class="personOrder center">
			<a href="../CommodityOrderController/findAllMyOrder_saleman.do?au_id=${user.au_id}&sign=3">
				<img src="../img/completed.png" /> 已完成
			</a>
			<a href="../CommodityOrderController/findAllMyOrder_saleman.do?au_id=${user.au_id}&sign=2">
				<img src="../img/unfinished.png" /> 未完成
			</a>
		</div>
		<div class="score">
			<p>当前评分</p>
			<center><big>${user.score}</big>分</center>
		</div>
		<footer class="footer">
			<a href="../targetGongZhongHao/homePage.do">
				<img src="../img/icon_home@2x.png" /> 主页
			</a>
			<a class="classify">
				<img src="../img/icon_fenlei@2x.png" /> 分类
			</a>
			<a href="../CommodityOrderController/findAllMyOrder_saleman.do?au_id=${user.au_id}">
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