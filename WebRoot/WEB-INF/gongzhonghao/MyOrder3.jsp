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
		<title>我的订单(普通用户)</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="../userController/targetPersonHome.do"><img src="../img/icon_back@2x.png" /></a>
			<center>我的订单</center>
		</header>
		<nav class="orderNav">
			<a href="../CommodityOrderController/findAllMyOrder.do?au_id=${user.au_id}&sign=0"><span >未支付</span></a>
			<a href="../CommodityOrderController/findAllMyOrder.do?au_id=${user.au_id}&sign=1"><span>已支付</span></a>
			<span class="navAct">所有订单</span>
		</nav>
		<div class="orderCon mT9">
		<c:if test="${not empty '${commodity_order}'}">
		<c:forEach items="${commodity_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span class="greenFont">单号${data.com_id}</span>
					<c:if test="${data.order_state=='0'}">
					<span class="greenFont fr">交易关闭</span>
					</c:if>
					<c:if test="${data.order_state=='1'}">
					<span class="greenFont fr">已支付</span>
					</c:if>
					<c:if test="${data.order_state=='3'}">
					<span class="greenFont fr">已收货</span>
					</c:if>
					<c:if test="${data.order_state=='7'}">
					
					<span class="greenFont fr"><a href="../CommodityOrderController/getCommodityOrderDetail.do?com_id=${data.com_id}">已评价	</a></span>

					</c:if>
					<c:if test="${data.order_state=='8'}">
					<a onclick="pay('${data.com_id}')"><span class="greenFont fr">支付尾款:￥${data.retainage}</span></a>
					</c:if>
				</p>
				<div class="borderT padding1">
					<p class="marginB1">
						<span class="greenBtn radius05">商品</span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a>￥${data.total_price}</a>
						<img src="../img/icon_in@2x.png" alt="" class="fr littlePic" />
					</p>
					<p>
						${data.c_name}
					</p>
				</div>
			</section>
			</c:forEach>
			</c:if>
			
			<c:if test="${not empty '${install_order}'}">
			<c:forEach items="${install_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span class="greenFont">单号${data.install_id}</span>
					<c:if test="${data.order_state==0}">
					<span class="greenFont fr">未支付</span>
					</c:if>
					<c:if test="${data.order_state==1}">
					<span class="greenFont fr">已支付</span>
					</c:if>
					<c:if test="${data.order_state==4}">
					<span class="greenFont fr">安装中</span>
					</c:if>
					<c:if test="${data.order_state==7}">
					<span class="greenFont fr">已评价</span>
					</c:if>
					<c:if test="${data.order_state==8}">
					<span class="greenFont fr">预生成</span>
					</c:if>
				</p>
				<div class="borderT padding1">
					<p class="marginB1">
						<span class="greenBtn radius05">安装</span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a>￥${data.total_price}</a>
						<img src="../img/icon_in@2x.png" alt="" class="fr littlePic" />
					</p>
					<p>
						${data.create_time}
					</p>
				</div>
			</section>
			</c:forEach>
			</c:if>
			
			<c:if test="${not empty '${maintain_order}'}">
			<c:forEach items="${maintain_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span class="greenFont">单号${data.maintain_id}</span>
					<c:if test="${data.order_state=='0'}">
					<span class="greenFont fr">未支付</span>
					</c:if>
					<c:if test="${data.order_state==1}">
					<span class="greenFont fr">已支付</span>
					</c:if>
					<c:if test="${data.order_state==3}">
					<span class="greenFont fr">已收货</span>
					</c:if>
					<c:if test="${data.order_state==5}">
					<span class="greenFont fr">保养中</span>
					</c:if>
					<c:if test="${data.order_state==7}">
					<span class="greenFont fr">已评价</span>
					</c:if>
					<c:if test="${data.order_state==8}">
					<span class="greenFont fr">预生成</span>
					</c:if>
				</p>
				<div class="borderT padding1">
					<p class="marginB1">
						<span class="greenBtn radius05">保养</span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a>￥${data.total_price}</a>
						<img src="../img/icon_in@2x.png" alt="" class="fr littlePic" />
					</p>
					<p>
						${data.create_time}
					</p>
				</div>
			</section>
			</c:forEach>
			</c:if>
			
			<c:if test="${not empty '${repair_order}'}">
			<c:forEach items="${repair_order}" var="data" varStatus="s">
			<section class="orderBox">
				<p class="margin05"><span class="greenFont">单号${data.repair_id}</span>
					<c:if test="${data.order_state=='0'}">
					<span class="greenFont fr">未支付</span>
					</c:if>
					<c:if test="${data.order_state==1}">
					<span class="greenFont fr">已支付</span>
					</c:if>
					<c:if test="${data.order_state==3}">
					<span class="greenFont fr">已收货</span>
					</c:if>
					<c:if test="${data.order_state==6}">
					<span class="greenFont fr">保养中</span>
					</c:if>
					<c:if test="${data.order_state==7}">
					<span class="greenFont fr">已评价</span>
					</c:if>
					<c:if test="${data.order_state==8}">
					<span class="greenFont fr">预生成</span>
					</c:if>
				</p>
				<div class="borderT padding1">
					<p class="marginB1">
						<span class="greenBtn radius05">维修</span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a>￥${data.total_price}</a>
						<img src="../img/icon_in@2x.png" alt="" class="fr littlePic" />
					</p>
					<p>
						${data.create_time}
					</p>
				</div>
			</section>
			</c:forEach>
			</c:if>
		</div>
	</body>
</html>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript">
function pay(data){
	
	alert(data);
	 $.ajax({
		url:"http://www.kongtiaoguanjia.com/air/CommodityOrderController/findCommodity.do",
		type:"post",
		data:{"com_id":data},
		success:function(data){
					var com_id=data.com_id;
					var money=data.money;
					var open_id=data.open_id;
					var au_id=data.au_id;
					var a_id=data.a_id;
					var c_id=data.c_id;
					 $.ajax({
							url:"http://www.kongtiaoguanjia.com/air/payController/toPay_Weixin.do",
							type:"post",
							data:{"money":money,"openid":open_id,"au_id":au_id,"c_id":c_id,"a_id":a_id},
							success:function(data){
										console.log(data);
										alert(data.data.appId);
										
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
										    	
										    	$.ajax({
													url:"http://www.kongtiaoguanjia.com/air/CommodityOrderController/updataCentralAirOrderRetainage.do",
													type:"post",
													data:{"com_id":com_id,"money":money},
													success:function(data){
																var sign= data.sign;
																if(sign==1){
																	alert("支付成功");
																}else{
																	alert("支付失败");
																}
														},
													dataType:"json",
													error: function(msg){
														alert("哎呀网络开小差了，稍等会吧！");
														console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
													},
													async:false
											});
										    	/* window.location.href="http://www.kongtiaoguanjia.com/air/CommodityOrderController/updataCentralAirOrderRetainage.do?com_id="+
										    			com_id+"&money="+money; */
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
					
					
					
	
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
});
	
	
	
	
}

</script>