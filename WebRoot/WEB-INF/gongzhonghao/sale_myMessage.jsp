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
		<link rel="stylesheet" type="text/css" href="css/air.css" />
		<title>我的消息</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>我的消息</center>
		</header>
		<div class="orderCon mT6">
				<c:if test='${not empty "${commodityOrder}"}'>
				<c:forEach items="${commodityOrder}" var="data" varStatus="s"> 
			<section class="orderBox">
				<p class="margin05"><span>单号${data.com_id}</span>
					<time class="fr font888">${data.create_time}</time>
				</p>
				<article class="font888" style="padding: 1rem;">
					客户还未发起评价
				</article>
			</section>
			</c:forEach>
			</c:if>
		</div>
	</body>

</html>