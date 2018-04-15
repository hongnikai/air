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
<form action="../commodity/changeCommodityOrderPrice.do" >
<input type="text" value="${user.au_id}" name="au_id" style="display: none"/>
<input type="text" value="${commodityOrder.com_id}" name="com_id" style="display: none;"/>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimum-scale=1.0,maximum-scale=1.0" />
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>制作订单价格</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>制作订单价格</center>
		</header>
		<div class="orderCon mT6">
			<section class="orderBox">
				<p class="margin05"><span>单号${commodityOrder.com_id}</span></p>
				<div class="orderInfo">
					<img src="http://www.kongtiaoguanjia.com/${commodityOrder.cover_picture}" alt="商品图片" />
					<article>
						<h4>${commodityOrder.brand}</h4>
						<small>${commodityOrder.c_name}</small>
						<p>
							<font class="redFont">￥${commodityOrder.total_price}<input class="radius2 priceIpt" type="text" name="price" required="required"/></font>
							<i class="fr greenFont">X1</i>
						</p>
					</article>
				</div>
				<article class="textWrap">
					备注
					<textarea class="radius05" name="text" required="required"></textarea>
				</article>
			</section>
			<section class="orderBox paddingTB0">
				<ul>
					<li><span>合计：	</span><span class="redFont fr">￥${commodityOrder.total_price}</span></li>
					<li><span>预定金：	</span><span class="redFont fr">￥${commodityOrder.deposit}</span></li>
					<li><span>剩余尾款：	</span><span class="redFont fr">￥${commodityOrder.retainage}</span></li>
				</ul>
			</section>
		<input type="submit" value="保存" class="longBtn" />
		</div>
	</body>
	</form>
</html>