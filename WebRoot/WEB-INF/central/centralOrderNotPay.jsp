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
		<title>我的订单(未付款)</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>我的订单</center>
		</header>
		<nav class="orderNav">
			<a href="http://www.kongtiaoguanjia.com/air/commodity/centralOrderState8BySign.do?sign=2&au_id=${user.au_id}"><span>已评价</span></a>
			<span class="navAct">未付款</a></span>
			<a href="http://www.kongtiaoguanjia.com/air/commodity/centralOrderState8BySign.do?sign=1&au_id=${user.au_id}"><span>已付款</span></a>
		</nav>
		<div class="orderCon mT9">
		<c:if test='${not empty "${commodityOrder}"}'>
		<c:forEach items="${commodityOrder}" var="data" varStatus="s"> 
			<section class="orderBox">
				<p class="margin05"><span class="greenFont">单号${data.com_id}</span> 
				<a href="../commodity/selectCommodityBycIdAndTarget.do?c_id=${data.c_id}"><span class="greenBtn fr">付款</span></a>
					<!-- <input type="button" value="接单" class="greenBtn fr" /> -->
					<%-- <a href="../commodity/commodityOrderComplete.do?com_id=${data.com_id}&au_id=${user.au_id}" class="greenBtn fr">报价</a> --%>
				</p>
				<div class="orderInfo">
					<img src="http://www.kongtiaoguanjia.com/${data.cover_picture}" alt="商品图片" />
					<article>
						<h4></h4>
						<small>总价</small>
						<p>
							<font class="redFont">￥${data.total_price}</font><br>
							<font class="redFont">￥${data.deposit}</font>
							<i class="fr greenFont">X1</i>
						</p>
					</article>
				</div>
				<%-- <p class="margin05">
					<span>共<i>1</i>件商品 合计：<font class="redFont">￥${data.total_price}</font></span>
					<span class="fr">剩余尾款：<font class="redFont">￥${data.retainage}</font></span>
				</p> --%>
			</section>
		</c:forEach>
		</c:if>
		</div>
	</body>

</html>
