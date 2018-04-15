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
		<title>技术人员订单</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>技术员订单</center>
		</header>
		<div class="orderCon mT6">
			
			<c:if test="${not empty '${install_order}'}">
			<c:forEach items="${install_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span onclick="find_install('${data.install_order_id}')">01.单号:${data.install_order_id}</span>
					<span class="greenFont fr">${user.nickname}员工</span>
				</p>
				<div class="orderInfo">
					<article>
						<h4>${data.brand}</h4>
						<small style="color: green;">安装</small>
						<c:if test="${data.purpose=='0'}">
						<small>家用分体式</small>
						</c:if>
						<c:if test="${data.purpose=='1'}">
						<small>家用中央空调</small>
						</c:if>
						<c:if test="${data.purpose=='2'}">
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
			
		<c:if test="${not empty '${maintain_order}'}">
			<c:forEach items="${maintain_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span onclick="find_maintain('${data.maintain_order_id}')">01.单号:${data.maintain_order_id}</span>
					<span class="greenFont fr">${user.nickname}员工</span>
				</p>
				<div class="orderInfo">
					<article>
						<h4>${data.brand}</h4>
						<small style="color: green;">保养</small>
						<c:if test="${data.purpose=='0'}">
						<small>家用分体式</small>
						</c:if>
						<c:if test="${data.purpose=='1'}">
						<small>家用中央空调</small>
						</c:if>
						<c:if test="${data.purpose=='2'}">
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
			
			<c:if test="${not empty '${repair_order}'}">
			<c:forEach items="${repair_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span onclick="find_repair('${data.repair_order_id}')">01.单号:${data.repair_order_id}</span>
					<span class="greenFont fr">${user.nickname}员工</span>
				</p>
				<div class="orderInfo">
					<article>
						<h4>${data.brand}</h4>
						<small style="color: green;">维修</small>
						<c:if test="${data.purpose=='0'}">
						<small>家用分体式</small>
						</c:if>
						<c:if test="${data.purpose=='1'}">
						<small>家用中央空调</small>
						</c:if>
						<c:if test="${data.purpose=='2'}">
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
function find_install(data){
	window.location.href="../InstallController/findInstallEvaDetail.do?install_order_id="+data;
}
function find_maintain(data){
	window.location.href="../MaintainController/findMaintainEvaDetail.do?maintain_order_id="+data;
}
function find_repair(data){
	window.location.href="../RepairController/findRepairEvaDetail.do?repair_order_id="+data;
}


</script>