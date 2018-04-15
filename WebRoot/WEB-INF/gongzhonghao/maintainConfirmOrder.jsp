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
			<a href="../MaintainController/deleteMaintian.do?maintain_id=${maintain.maintain_id}"><img src="../img/icon_back@2x.png" /></a>
			<center>确认订单</center>
		</header>
			<form action="../MaintainController/targetCreateMainta1inOrder.do">
		<div class="orderCon mT6">
			<section class="orderBox mT0">
				<p class="margin05"><span><img src="../img/icon_orders_time@2x.png" class="littlePic marginLR05"/>预约上门时间</span>
					<span id="m_div"><span id="m_time" style="display: none;">${maintain_order.time}</span></span>
					<c:if test="${maintain_order.time_stage=='0'}">
					<span>全天</span>
					</c:if>
					<c:if test="${maintain_order.time_stage=='1'}">
					<span>上午</span>
					</c:if>
					<c:if test="${maintain_order.time_stage=='2'}">
					<span>下午</span>
					</c:if>
					<input name="maintain_id" value="${maintain.maintain_id}" style="display: none;"/>
					<input name="a_id" value="${address.a_id}" style="display: none;"/>
					<time class="font888" id="appointTime"></time>
					<input type="submit" value=">" class="littlePic" style="float: right;">
					</form>
				</p>
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
				<p class="padding05 borderB"><span class="greenFont">单号:${maintain_order.maintain_order_id}</span>
					<span class="greenFont fr">待接单</span>
				</p>
				<div class="padding1">
					<p class="marginB1">
					<span class="greenBtn radius05">维修</span>
					
						
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
				</ul>
			</section>
		</div>
		<input type="hidden" value="${maintain.maintain_id}" id="maintain_id">
		<input type="hidden" value="${maintain_order.maintain_order_id}" id="maintain_order_id" >
		<input type="hidden" value="${maintain_order.total_price}" id="price">
		<input type="hidden" value="${user.au_id}" id="au_id">
		<input type="hidden" value="${user.open_id}" id="open_id">
		<input type="hidden" value="${address.a_id}" id="a_id">
		
		<footer class="footer footerH4 clearfix">
			<font>10%预定金：<i class="redFont">${maintain_order.total_price}</i></font>
			<aside class="oneBtn">
				<input type="button" value="确定" onclick="makesure('${maintain_order.maintain_order_id}')" />
			</aside>
		</footer>
	</body>

</html>
<script type="text/javascript">
$(function(){
	var html=$("#m_time").html();
	var str= html.split(" ");
	console.log(str);
	$("#m_div").append(str[0]); 
})



function makesure(data){
	var maintain_order_id=$("#maintain_order_id").val();
	var maintain_id=$("#maintain_id").val();
	var price=$("#price").val();
	var au_id=$("#au_id").val();
	var open_id=$("#open_id").val();
	var a_id=$("#a_id").val();
	
	 var aaa= $("#m_time").html();
		if(aaa==null||aaa==""||aaa==" "){
			alert("请先预上门时间");
		}else{
			 $.ajax({
					url:"http://www.kongtiaoguanjia.com/air/payController/toPay_Weixin.do",
					type:"post",
					data:{"money":price,"openid":open_id,"au_id":au_id,"c_id":maintain_id},
					success:function(data){
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
								    window.location.href="http://www.kongtiaoguanjia.com/air/MaintainController/changeMaintainOrderStage1.do?maintain_order_id="+maintain_order_id;
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
}



</script>