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
			<a href="../RepairController/deleteRepair.do?repair_id=${repair.repair_id}"><img src="../img/icon_back@2x.png" /></a>
			<center>确认订单</center>
		</header>
			<form action="../RepairController/targetCreateRepairOrder.do">
		<div class="orderCon mT6">
			<section class="orderBox mT0">
				<p class="margin05"><span><img src="../img/icon_orders_time@2x.png" class="littlePic marginLR05"/>预约上门时间</span>
					<span id="m_div"><span id="m_time" style="display: none;">${repair_order.time}</span></span>
					<c:if test="${repair_order.time_stage=='0'}">
					<span>全天</span>
					</c:if>
					<c:if test="${repair_order.time_stage=='1'}">
					<span>上午</span>
					</c:if>
					<c:if test="${repair_order.time_stage=='2'}">
					<span>下午</span>
					</c:if>
					<input id="back_time" value="${repair_order.time}" type="button" style="display: none;">
					<input name="repair_id" value="${repair.repair_id}" style="display: none;"/>
					<input name="a_id" value="${address.a_id}" style="display: none;"/>
					<time class="font888" id="appointTime"></time>
					<input type="submit" value=">"  class="littlePic fr">
					</form>
				</p>
		<%-- <p>${repair.repair_id}</p> --%>
				<div class="orderInfo">
					<section>
						<a><img src="../img/icon_address@2x.png" class="littlePic" /></a>
						<div class="addr">
							<p>收货人：<span>${address.name}</span>
								<font class="fr">tel:${address.mobile}</font>
							</p>
							<p>收货地址：${address.province}${address.detail}</p>
						</div>
						<img src="../img/icon_in@2x.png" alt="" class="littlePic" />
					</section>
				</div>
				<p class="padding05 borderB"><span class="greenFont">01.单号:${repair_order.repair_order_id}</span>
						<%-- 	<span class="greenFont fr">维修人员正在接单的路上...</span>
					<span class="greenFont fr">${repair_order.repair_man_id}</span> --%>
				</p>
				<div class="padding1">
					<p class="marginB1">
					<c:if test="${repair_order.time_stage=='0'}">
					<span class="greenBtn radius05">全天</span>
					</c:if>
					<c:if test="${repair_order.time_stage=='1'}">
					<span class="greenBtn radius05">上午</span>
					</c:if>
					<c:if test="${repair_order.time_stage=='2'}">
					<span class="greenBtn radius05">下午</span>
					</c:if>
					
						
						<img src="../img/icon_in@2x.png" alt="" class="fr littlePic" />
					</p>
					<p>
					<%-- 	${brand} 品牌 ${purpose} ${type} ${level}  --%>
					</p>
				</div>
			</section>
		<%-- 	<section class="orderBox pricesShow">
				<center class="greenFont">相同服务价格显示</center>
				<div class="tabBox">
					<table>
						<tr>
							<td>XX品牌</td>
							<td>柜机</td>
							<td>3匹</td>
							<td>￥5000</td>
						</tr>
						<tr>
							<td>XX品牌</td>
							<td>柜机</td>
							<td>3匹</td>
							<td>￥5000</td>
						</tr>
					</table>
				</div>
			</section> --%>
			<section class="orderBox paddingTB0">
				<ul>
					<li><span>合计：	</span><span class="redFont fr">100</span></li>
					<li><span>预定金：	</span><span class="redFont fr">100</span></li>
					<li><span>剩余尾款：	</span><span class="redFont fr">100</span></li>
					<input type="hidden" value="${address.a_id}" id="a_id">
					<input type="hidden" value="${repair_order.repair_order_id}" id="repair_order_id">
					<input type="hidden" value="${repair.repair_id}" id="repair_id">
					<input type="hidden" value="${user.au_id}" id="au_id">
					<input type="hidden" value="${user.open_id}" id="open_id">
					<input type="hidden" value="${repair_order.total_price}" id="price">
				</ul>
			</section>
		</div>
		<footer class="footer footerH4 clearfix">
			<font>10%预定金：<i class="redFont">${repair_order.total_price}</i></font>
			<aside class="oneBtn">
				<input type="button" value="确定" onclick="makesure('${repair_order.repair_order_id}')" />
			</aside>
		</footer>
	</body>
</html>
<script type="text/javascript">
function makesure(data){
	var a_id=$("#a_id").val();
	var repair_order_id=$("#repair_order_id").val();
	var repair_id=$("#repair_id").val();
	var au_id=$("#au_id").val();
	var open_id=$("#open_id").val();
	var price=$("#price").val();
	
	 var aaa= $("#back_time").val();
		if(aaa==null||aaa==""||aaa==" "){
			alert("请先预上门时间");
		}else{
			
			 $.ajax({
					url:"http://www.kongtiaoguanjia.com/air/payController/toPay_Weixin.do",
					type:"post",
					data:{"money":price,"openid":open_id,"au_id":au_id,"c_id":repair_id,"a_id":a_id},
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
								    	window.location.href="../payController/toPayTheRepairOrder.do?a_id="+a_id+"&repair_order_id="+repair_order_id+"&repair_id="+repair_id;
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
			
			
			
			
			
	//	 	window.location.href="../RepairController/targetRepairOrderDetail.do?repair_order_id="+data;
		} 
}

</script>