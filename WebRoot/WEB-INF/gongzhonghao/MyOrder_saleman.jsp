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
		<title>我的订单(销售员)</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="../userController/targetPersonHome.do"><img src="../img/icon_back@2x.png" /></a>
			<center>我的订单</center>
		</header>
		<nav class="orderNav">
			<span class="navAct">待接单</span>
			<a href="../CommodityOrderController/findAllMyOrder_saleman.do?au_id=${user.au_id}&sign=2"><span>未完成</span></a>
			<a href="../CommodityOrderController/findAllMyOrder_saleman.do?au_id=${user.au_id}&sign=3"><span>已完成</span></a>
		</nav>
		<div class="orderCon mT9">
		<c:if test="${not empty '${commodity_order}'}">
		<c:forEach items="${commodity_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span class="greenFont">单号${data.com_id}</span>	
				
					<span class="greenFont fr">待接单</span>
				</p>
				<div class="borderT padding1">
					<p class="marginB1">
						<span class="greenBtn radius05">商品</span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a>￥${data.total_price}</a>
						<img src="../img/icon_in@2x.png" alt="" class="fr littlePic" />
					</p>
					<p>
					 ${data.leave_message}
					</p>
					<input type="button" onclick="getCom('${data.com_id}')" value="接单">
				</div>
			</section>
			</c:forEach>
			</c:if>
		</div>
	</body>
</html>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
function getCom(data){	
	$.ajax({    
		type: "post",
		url: "../CommodityOrderController/salesmanCompeteCommodityOrder2.do",
		async: false,
		dataType: "json",
		data: {"com_id":data},
		success: function(data){
			alert("接单成功");
			
		},
		error: function() {
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		}
	});			
	
}
</script>