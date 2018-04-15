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
		<title>创建地址</title>
	</head>
<form action="../commodity/createPersonAddressCartTarget.do">
	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>创建地址</center>
		</header>
		<div class="orderCon mT6">
			<section class="orderBox paddingTB0">
				<ul class="addrEdit">
				<input name="c_car_id" value="${c_car_id}" style="display: none"/>
				<input name="price" value="${price}" style="display: none"/>
				<input name="c_id" value="${c_id}" style="display: none"/>
				<input name="au_id" value="${au_id}" style="display: none"/>
				<input name="open_id" value="${open_id}" style="display: none"/>
					<li><span>收货人</span><input type="text" name="name" id="name" value="" required="required"/></li>
					<li><span>联系电话</span><input type="text" name="mobile" id="mobile" required="required"/></li>
					<li><span>所在地区</span><input type="text" name="province"  style="float: none;" id="demo2" required="required"/><a class="right-icon" id="right-icon"><img class="littlePic" src="../img/icon_in@2x.png"/></a></li>
					<li><span>详细地址</span><input type="text" name="detail" id="detail" required="required"/></li>
				</ul>
			</section>
			<input type="submit" class="longBtn" value="保存" id="save"/>
		</div>
		<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/picker.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/city.js" type="text/javascript" charset="utf-8"></script>
	</body>
</form>
</html>