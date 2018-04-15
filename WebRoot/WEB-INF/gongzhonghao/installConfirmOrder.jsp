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
		<title>确认订单</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="../InstallController/deleteInstallOrderAndTarget.do?install_order_id=${install_order_id}"><img src="../img/icon_back@2x.png" /></a>
			<center>确认订单</center>
		</header>
		<div class="orderCon mT6">
			<section class="orderBox mT0">
			<form action="../InstallController/timeStage.do">
				<p class="margin05"><span><img src="../img/icon_orders_time@2x.png" class="littlePic marginLR05"/>预约上门时间</span>
				<%-- <input id="back_time" value="${time}" type="button"> --%>
					<a id="back_time">${time}</a>
					<input type="text" value="${address}" name="address" style="display: none;"/>
					<input type="text" value="${person}" name="person" style="display: none;"/>
					<input type="text" value="${mobile}" name="mobile" style="display: none;"/>
					<input type="text" value="${install_id}" id="install_id" name="install_id" style="display: none;"/>
					<input type="text" value="${au_id}"  id="au_id"  name="au_id" style="display: none;"/>
					<time class="font888" id="appointTime"></time>
					<input type="submit" value=">" class="littlePic" style="float: right">
				
				</p>
					</form>
				<div class="orderInfo">
					<section>
						<a href="../InstallController/targetChangeInstallOrderAddressInformation.do?a_id=${a_id}&install_id=${install_id}&install_order_id=${install_order_id}"><img src="../img/icon_address@2x.png" class="littlePic" /></a>
						<div class="addr">
							<p>收货人：<span>${person}</span>
								<font class="fr">tel:${mobile}</font>
							</p>
							<p>收货地址：${address}</p>
						</div>
						<img src="../img/icon_in@2x.png" alt="" class="littlePic" />
					</section>
				</div>
				<p class="padding05 borderB"><span class="greenFont" id="maintain_order_id">01.单号:${install_order_id}</span>
					<!-- <span class="greenFont fr">XX员工</span> -->
				</p>
				<div class="padding1">
					<p class="marginB1">
						<span class="greenBtn radius05">安装</span>
						<img src="../img/icon_in@2x.png" alt="" class="fr littlePic" />
					</p>
					<p>
					${brand}  品牌 ${purpose} ${type} 
					</p>
				</div>
			</section>
			<section class="orderBox pricesShow">
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
			</section>
			<section class="orderBox paddingTB0">
				<ul>
					<li><span>合计：	</span><span class="redFont fr" id="price">${price}</span></li>
					<li><span>预定金：	</span><span class="redFont fr">0</span></li>
					<li><span>剩余尾款：	</span><span class="redFont fr">${price}</span></li>
				</ul>
			</section>
		</div>
		<footer class="footer footerH4 clearfix">
			<input type="hidden" value="${user.open_id}" id="open_id"> 
			<input type="hidden" value="${a_id}" id="a_id">
			<font>10%预定金：<i class="redFont">${price}</i></font>
			<aside class="oneBtn">
				<input type="button" value="确定" onclick="makesure('${au_id}')" />
			</aside>
		</footer>
	<%-- 	<h1>${install_order_id}</h1><br>   这页所需数据一部分
		<h1>${address}</h1><br>
		<h1>${person}</h1><br>
		<h1>${price}</h1><br>
		<h1>${mobile}</h1><br>000000000000000 --%>
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
	var maintain_order_id=$("#maintain_order_id").html();
	var price= $("#price").html();
	var install_id=$("#install_id").val();  //c_id
	var open_id=$("#open_id").val();
	var au_id=$("#au_id").val();
	var a_id=$("#a_id").val();
	
	 function makesure(data){
	
	    var aaa= $("#back_time").html();
		if(aaa==null||aaa==""||aaa==" "){
			alert("请先预上门时间");
		}else{
			 $.ajax({
				url:"http://www.kongtiaoguanjia.com/air/payController/toPay_Weixin.do",
				type:"post",
				data:{"money":price,"openid":open_id,"au_id":au_id,"c_id":install_id,"a_id":a_id},
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
							    	window.location.href="../InstallController/changeInstallOrderState1.do?install_order_id="+install_order_id;
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
			}); 
		 	
					
		}  
	} 
</script>