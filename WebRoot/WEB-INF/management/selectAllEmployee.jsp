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
		<title>员工列表</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>员工列表</center>
		</header>
		<div class="orderCon mT6">
			<section class="orderBox">
				<ul>
					
					<c:if test="${not empty '${employee}'}">
					<c:forEach items="${employee}" var="data" varStatus="s">
					<!-- 分数大于60分，显示为绿色 -->
					<c:if test="${data.score > '60'}">
					<li class="padding05 borderB"><span>
					<a id="${data.au_id}" onclick="find(this.id)">${data.nickname}</a></span>
					<span class="greenFont fr">${data.score}分</span></li>
					</c:if>
					
					
					
					<!-- 分数小于60分，显示为红色的 -->
					<c:if test="${data.score < '60'}">
					<li class="padding05 borderB"><span>
					<a id="${data.au_id}" onclick="find(this.id)">${data.nickname}</a>
					</span><span class="redFont fr">${data.score}分</span></li>
					</c:if>
					</c:forEach>
					</c:if>
				</ul>
			</section>
		</div>
	</body>
</html>
<script type="text/javascript">
function find(data){
	window.location.href="../userController/selectEmployeeOrder.do?au_id="+data;	
}
</script>
