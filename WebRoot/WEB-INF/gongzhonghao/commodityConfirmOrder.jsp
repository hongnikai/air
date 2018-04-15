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
		<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>确认订单</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href=""><img src="../img/icon_back@2x.png" /></a>
			<center>确认订单</center>
		</header>
			<!-- <form action="../commodity/targetCreateCommodityOrder.do"> -->
		<div class="orderCon mT6">
			<section class="orderBox mT0">
				<%-- <p class="margin05"><span><img src="../img/icon_orders_time@2x.png" class="littlePic marginLR05"/>预约上门时间</span>
					<input id="back_time" value="${commodity_order.time}" type="button">
					<input name="c_id" value="${commodity.c_id}" style="display: none;"/>
					<input name="a_id" value="${address.a_id}" style="display: none;"/>
					<time class="font888" id="appointTime"></time>
					<input type="submit" value=">" class="littlePic" style="float: right;">
					</form>
				</p> --%>
				<div class="orderInfo">
					<section>
						<a href=""><img src="../img/icon_address@2x.png" class="littlePic" /></a>
						<div class="addr">
							<p>收货人：<span>${address.name}</span>
								<font class="fr">tel:${address.mobile}</font>
							</p>
							<p>收货地址：${address.province}${address.detail}</p>
						</div>
						<img src="../img/icon_in@2x.png" alt="" class="littlePic" />
					</section>
				</div>
				<p class="padding05 borderB"><span class="greenFont">单号:${commodity.c_id}</span>
				</p>
				<div class="padding1">
					<p class="marginB1">
						
						<img src="http://www.kongtiaoguanjia.com/${commodity.cover_picture}" alt="" class="fr littlePic" />
					</p>
					<p>
						${commodity.brand} 品牌  ${commodity.level}  
					</p>
				</div>
			</section>
			<section class="orderBox paddingTB0">
				<ul>
					<li><span>合计：	</span><span class="redFont fr">￥${commodity.price}</span></li>
				</ul>
			</section>
			<input type="button" value="${commodity.c_id}"  id="c_id" style="display: none"/>
			<input type="button" value="${address.a_id}"  id="a_id" style="display: none"/>
			<input type="button" value="${user.au_id}"  id="au_id" style="display: none"/>
			<input type="button" value="${user.open_id}"  id="open_id" style="display: none"/>
			<input type="button" value="${commodity.price}"  id="price" style="display: none"/>
		</div>
		<footer class="footer footerH4 clearfix">
			<font>金额：<i class="redFont">￥${commodity.price}</i></font>
			<aside class="oneBtn">
				<input type="button" value="确定" onclick="makesure()" />
			</aside>
		</footer>
		<script type="text/javascript">
			var time = location.search,
				timeArr=time.split('&');console.log(timeArr);
			var timeDateStr=time.slice(1,11),
				timeStr=timeArr[1].fromCharCode(timeArr[1]);
			console.log(timeDateStr+','+timeStr);
			document.getElementById("appointTime").innerHTML = timeDateStr+','+timeStr;
		</script>
	</body>
</html>
<script type="text/javascript">
function makesure(){
	var c_id=$("#c_id").val();
	var a_id=$("#a_id").val();
	var au_id=$("#au_id").val();
	var open_id=$("#open_id").val();
	var price=$("#price").val();
	
	 $.ajax({
			url:"http://www.kongtiaoguanjia.com/air/payController/toPay_Weixin.do",
			type:"post",
			data:{"money":price,"openid":open_id,"au_id":au_id,"c_id":c_id,"a_id":a_id},
			success:function(data){
						console.log(data);
						WeixinJSBridge.invoke('getBrandWCPayRequest', {
						    "appId":""+data.data.appId+"",//公众号名称，由商户传入
						    "timeStamp":""+data.data.timeStamp+"",//时间戳，自1970年以来的秒数
						    "nonceStr":""+data.data.nonceStr+"", //随机串
						    "package":""+data.data.package+"",
						    "signType":"MD5",//微信签名方式：
						    "paySign":""+data.data.paySign+"" //微信签名
						},
						function(res){
						    // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回
						    // ok，但并不保证它绝对可靠。
						    if(res.err_msg == "get_brand_wcpay_request:ok" ) {
						    window.location.href="http://www.kongtiaoguanjia.com/air/CommodityOrderController/createCommodityOrderState1.do?money="
						    		+price+"&au_id="+au_id+"&c_id="+c_id+"&a_id="+a_id;
						    }
						}
						);
				},
			dataType:"json",
			error: function(msg){
				alert("哎呀网络开小差了，稍等会吧！");
				console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
			},
			async:false
		}) 
}

</script>