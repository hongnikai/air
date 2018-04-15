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
		<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>保养订单详情</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>保养订单详情</center>
		</header>
		<nav class="schedule mT5">
			<a style="color: white;" href="../MaintainController/selectMaintainOrderPic.do?maintain_order_id=${maintain_order.maintain_order_id}">进度详情</a>
			<a href="../MaintainController/selectMaintainOrderPic.do?maintain_order_id=${maintain_order.maintain_order_id}"><img src="../img/icon_in2@2x.png" class="fr littlePic" /></a>
		</nav>
		<div class="orderCon mT0">
			<section class="orderBox mT0">
				<p class="margin05"><span><img src="../img/icon_orders_time@2x.png" class="littlePic marginLR05"/>预约上门时间</span>
				<span id="m_div"></span><span id="m_time" style="display: none;">${maintain_order.time}</span>
					<time class="fr font888"><span id="time_stage">
					<c:if test="${maintain_order.time_stage=='0'}">
					<a>全天</a>
					</c:if>
					<c:if test="${maintain_order.time_stage=='1'}">
					<a>上午</a>
					</c:if>
					<c:if test="${maintain_order.time_stage=='2'}">
					<a>下午</a>
					</c:if>
					</span><img src="../img/icon_in@2x.png" class="littlePic"/></time>
					
					
				</p>
				<div class="orderInfo">
					<section>
						<img src="../img/icon_address@2x.png" class="littlePic" />
						<div class="addr">
							<p>收货人：<span>${maintain_order.person}</span></p>
							<p>收货地址：${maintain_order.address}</p>
						</div>
						<img src="../img/icon_in@2x.png" alt="" class="littlePic" />
					</section>
				</div>
				<article class="techniqueInfo">
					<p class="padding05 borderB">
						<span class="greenFont">${maintain_order.maintain_order_id}</span>
						<a class="greenFont fr" href="">去付款</a>
					</p>
					<p class="margin1">
						<span class="greenBtn radius05">安装</span>
					</p>
					<p class="margin1">
					<input type="text" id="purpose" value="${maintain.purpose}" style="display: none;">
					<input type="text" id="type" value="${maintain.type}"  style="display: none;"/>
					${maintain.brand}&nbsp<div id="install_purpose"></div><div id="install_type"></div>${maintain.level}
					</p>
				</article>
			</section>
			<section class="orderBox paddingTB0">
				<ul>
					<li><span>合计：	</span><span class="redFont fr">${maintain_order.total_price}</span></li>
					<li><span>预定金：	</span><span class="redFont fr">${maintain_order.deposit}</span></li>
					<li><span>剩余尾款：	</span><span class="redFont fr">${maintain_order.retainage}</span></li>
				</ul>
			</section>
		</div>
	</body>
</html>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	var html=$("#m_time").html();
	var str= html.split(" ");
	console.log(str);
	$("#m_div").append(str[0]); 
	
})


</script>
