<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimum-scale=1.0,maximum-scale=1.0" />
		<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>安装订单详情</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>订单详情</center>
		</header>
		<nav class="schedule mT5">
			<a href="../InstallController/selectInstallOrderPic.do?install_order_id="+${map.install_order_id}>进度详情</a>
			<a href="../InstallController/selectInstallOrderPic.do?install_order_id="+${map.install_order_id}><img src="../img/icon_in2@2x.png" class="fr littlePic" /></a>
		</nav>
		<div class="orderCon mT0">
			<section class="orderBox mT0">
				<p class="margin05"><span><img src="../img/icon_orders_time@2x.png" class="littlePic marginLR05"/>预约上门时间</span>
					<time class="fr font888">${map.time}&nbsp;&nbsp;<span id="time_stage"></span><img src="../img/icon_in@2x.png" class="littlePic"/></time>
				</p><input type="text" value="${map.time_stage}" style="display: none;"  id="time_stage_value"/>
				<div class="orderInfo">
					<section>
						<img src="../img/icon_address@2x.png" class="littlePic" />
						<div class="addr">
							<p>收货人：<span>${map.person}</span></p>
							<p>收货地址：${map.address}</p>
						</div>
						<img src="../img/icon_in@2x.png" alt="" class="littlePic" />
					</section>
				</div>
				<article class="techniqueInfo">
					<p class="padding05 borderB">
						<span class="greenFont">${map.install_order_id}</span>
						<a class="greenFont fr" href="">去付款</a>
					</p>
					<p class="margin1">
						<span class="greenBtn radius05">安装</span>
					</p>
					<p class="margin1">
					<input type="text" id="purpose" value="${install.purpose}" style="display: none;">
					<input type="text" id="type" value="${install_type}" style="display: none;" />
					${install.brand}&nbsp;&nbsp;<span id="install_purpose"></span><span id="install_type"></span>&nbsp;&nbsp;${install.level}
					</p>
				</article>
			</section>
			<section class="orderBox paddingTB0">
				<ul>
					<li><span>合计：	</span><span class="redFont fr">${map.total_price}</span></li>
					<li><span>预定金：	</span><span class="redFont fr">${map.deposit}</span></li>
					<li><span>剩余尾款：	</span><span class="redFont fr">${map.retainage}</span></li>
				</ul>
			</section>
		</div>
	</body>
</html>
<script type="text/javascript">
$(function(){
	var data=$("#time_stage_value").val();
	if(data==0){
		$("#time_stage").append("全天");	
	}else if(data==1){
		$("#time_stage").append("上午");	
	}else if(data==2){
		$("#time_stage").append("下午");	
	}else{
		alert("安装时间值->溢出");
	}
	
	var purpose= $("#purpose").val();
	if(purpose==0){
		$("#install_purpose").append("家用分体式");	
	}else if(purpose==1){
		$("#install_purpose").append("家用中央空调");
	}else if(purpose==2){
		$("#install_purpose").append("商用中央空调");
	}else{
		alert("安装表purpose类型数据溢出");
	}
	
	
	var type=$("#type").val();
	if(type==0){
		$("#install_type").append("挂机");
	}else if(type==1){
		$("#install_type").append("柜机");
	}else if(type==2){
		$("#install_type").append("分体机");
	}else{
		alert("安装表type类型数据溢出");
	}
	
	
})
</script>