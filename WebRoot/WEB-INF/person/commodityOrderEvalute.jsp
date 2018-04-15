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
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>所有人员购买订单(已评价)</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>我的订单</center>
		</header>
		<nav class="orderNav">
			<span>已评价</span>
			<a href="../CommodityOrderController/commodityOrderNotPay.do"><span class="navAct">未支付</span></a>
			<a href="../CommodityOrderController/commodityOrderPay.do"><span>已支付</span></a>
		</nav>
		<div id="tomcat" class="orderCon mT9">
			<section class="orderBox">
				<p class="margin05"><span class="greenFont">单号</span>
					<!-- <input type="button" value="接单" class="greenBtn fr" /> -->
				</p>
				<div class="orderInfo">
					<img src="http://www.kongtiaoguanjia.com/" alt="商品图片" />
					<article>
						<h4></h4>
						<small>总价</small>
						<p>
							<font class="redFont">￥</font>
							<i class="fr greenFont">X1</i>
						</p>
					</article>
				</div>
				<%-- <p class="margin05">
					<span>共<i>1</i>件商品 合计：<font class="redFont">￥${data.total_price}</font></span>
					<span class="fr">剩余尾款：<font class="redFont">￥${data.retainage}</font></span>
				</p> --%>
			</section>
		</div>
	</body>
</html>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({    
		type: "post",
		url: "http://www.kongtiaoguanjia.com/air/CommodityOrderController/selectOwnCommodityOrder.do",
		async: false,
		dataType: "json",
		data: {"sign":2},
		success: function(data){
			console.log(data);
			var html=$("#tomcat").html("");
			for(var i=0;i<data.length;i++){
				var td="<section class='orderBox'>";	
				td+="<p class='margin05'><span class='greenFont'>单号:"+data[i].com_id+"</span>";
				td+="</p>";
				td+="<div class='orderInfo'>";
				td+="<img src='http://www.kongtiaoguanjia.com/"+data[i].cover_picture+"' alt='商品图片' />";
				td+="<article>";
				td+="<h4></h4>";
				td+="<small>总价</small>";
				td+="<font class='redFont'>￥"+data[i].total_price+"</font>";
				td+="<i class='fr greenFont'>x1</i>";
				td+="<br>"
				td+="<small>预定金</small>";
				//td+="<br>"
				td+="<font class='redFont'>￥"+data[i].deposit+"</font>";
				td+="</article>";
				td+="</section>"
				$("#tomcat").append(td);
			}
		},
		error: function() {
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		}
	}); 
	
})
</script>