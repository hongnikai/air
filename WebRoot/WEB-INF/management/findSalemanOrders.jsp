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
		<title>销售员订单</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>销售员订单</center>
		</header>
		<div class="orderCon mT6">
			
			<c:if test="${not empty '${commodity_order}'}">
			<c:forEach items="${commodity_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span onclick="find('${data.com_id}')">01.单号:${data.com_id}</span>
					<span class="greenFont fr">${user.nickname}</span>
				</p>
				<div class="orderInfo">
					<img src="http://www.kongtiaoguanjia.com/${data.cover_picture}" alt="商品图片" />
					<article>
						<h4>${data.brand}</h4>
						<c:if test="${data.use_type=='0'}">
						<small>家用分体式</small>
						</c:if>
						<c:if test="${data.use_type=='1'}">
						<small>家用中央空调</small>
						</c:if>
						<c:if test="${data.use_type=='2'}">
						<small>商用中央空调</small>
						</c:if>
						<c:if test="${data.type=='0'}">
						<small>挂机</small>
						</c:if>
						<c:if test="${data.type=='1'}">
						<small>柜机</small>
						</c:if>
						<c:if test="${data.type=='2'}">
						<small>分体机</small>
						</c:if>
						<p>
							<font class="redFont">￥${data.total_price}</font>
							<i class="fr greenFont">X1</i>
						</p>
					</article>
				</div>
			</section>
			</c:forEach>
			</c:if>
		</div>
	</body>
</html>
<script type="text/javascript">
function find(data){
	window.location.href="../CommodityOrderController/findCommodityOrderEvaDetail.do?com_id="+data;
}
</script>