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
		<title>我的订单(普通用户)</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="../userController/targetPersonHome.do"><img src="../img/icon_back@2x.png" /></a>
			<center>我的订单</center>
		</header>
		<nav class="orderNav">
			<span class="navAct">未支付</span>
			<a href="../CommodityOrderController/findAllMyOrder.do?au_id=${user.au_id}&sign=1"><span>已支付</span></a>
			<a href="../CommodityOrderController/findAllMyOrder.do?au_id=${user.au_id}&sign=2"><span>所有订单</span></a>
		</nav>
		<div class="orderCon mT9">
		<c:if test="${not empty '${commodity_order}'}">
		<c:forEach items="${commodity_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span class="greenFont">单号${data.com_id}</span>
					<a href="../CommodityOrderController/deleteCommodityOrder.do?com_id=${data.com_id}"><span class="greenFont fr">删除</span></a>
				</p>
				<div class="borderT padding1">
					<p class="marginB1">
						<span class="greenBtn radius05">商品</span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a>￥${data.total_price}</a>
						<a href="../commodity/selectCommodityBycIdAndTarget.do?c_id=${data.c_id}"><img src="../img/icon_in@2x.png" alt="" class="fr littlePic" /></a>
					</p>
					<p>
						${data.leave_message}
					</p>
				</div>
			</section>
			</c:forEach>
			</c:if>
			
			<c:if test="${not empty '${install_order}'}">
			<c:forEach items="${install_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span class="greenFont">单号${data.install_id}</span>
					<a href="../InstallController/delectInstallAndOrder.do?install_order_id=${data.install_order_id}"><span class="greenFont fr">删除</span></a>
				</p>
				<div class="borderT padding1">
					<p class="marginB1">
						<span class="greenBtn radius05">安装</span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a>￥${data.total_price}</a>
						<!-- <img src="../img/icon_in@2x.png" alt="" class="fr littlePic" /> 向右的箭头 -->
					</p>
					<p>
						${data.create_time}
					</p>
				</div>
			</section>
			</c:forEach>
			</c:if>
			
			<c:if test="${not empty '${maintain_order}'}">
			<c:forEach items="${maintain_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span class="greenFont">单号${data.maintain_id}</span>
					<a href="../MaintainController/deleteMaintainAndOrder.do?maintain_order_id=${data.maintain_order_id}">
					<span class="greenFont fr">删除</span>
					</a>
				</p>
				<div class="borderT padding1">
					<p class="marginB1">
						<span class="greenBtn radius05">保养</span>
						<!-- <img src="../img/icon_in@2x.png" alt="" class="fr littlePic" />  向右的箭头 -->
					</p>
					<p>
						${data.create_time}
					</p>
				</div>
			</section>
			</c:forEach>
			</c:if>
			
			<c:if test="${not empty '${repair_order}'}">
			<c:forEach items="${repair_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span class="greenFont">单号${data.repair_id}</span>
					<a href="../RepairController/deleteRepairAndOrder.do?repair_order_id=${data.repair_order_id}"><span class="greenFont fr">删除</span></a>
				</p>
				<div class="borderT padding1">
					<p class="marginB1">
						<span class="greenBtn radius05">维修</span>
						<!-- <img src="../img/icon_in@2x.png" alt="" class="fr littlePic" /> 向右的箭头 -->
					</p>
					<p>
						${data.create_time}
					</p>
				</div>
			</section>
			</c:forEach>
			</c:if>
		</div>
	</body>
</html>

