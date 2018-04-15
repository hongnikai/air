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
		<title>问大家</title>
		<style type="text/css">
			body{
				background-color: #f6f6f6;
			}
			.header{
				border-bottom: 0;
			}
			.orderCon{
				background-color: #f6f6f6;
			}
			.orderCon .orderBox{
				padding: 1rem;
			}
		</style>
	</head>

	<body>
		<header class="header bgcGray">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" class="littlePic" /></a>
			<center>问大家</center>
		</header>
		<div class="orderCon">
			<c:if test="${not empty '${ask}'}">
			<c:forEach items="${ask}" var="data" varStatus="s" begin="0" end="0" step="1">
			<section class="orderBox fontBig">
				关于
				<font>${data.question}</font>
				的问题
			</section>
			</c:forEach>
			</c:if>
		</div>
		<form action="../CommonController/addQuestionBycId.do">
		<footer class="footer">
			<input type="text" placeholder="向已买过的人提问，4-40字" value=""  name="question" />
			<input value="${ask[0].c_id}" id="c_id" name="c_id" type="hidden" />
			<input type="submit" value="提问" />
		</footer>
		</form>
	<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>	
	</body>
</html>
