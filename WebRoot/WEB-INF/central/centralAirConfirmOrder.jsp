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
			<div id="deposit_box" style="display: none">
			<span>请输入预定金:</span>
			<input type="number" id="deposit" placeholder="请输入预定金" required="required" >
			
			
			</div>
			<input type="button" value="${commodity.c_id}"  id="c_id" style="display: none"/>
			<input type="button" value="${address.a_id}"  id="a_id" style="display: none"/>
			<input type="button" value="${user.au_id}"  id="au_id" style="display: none"/>
			<input type="button" value="${user.open_id}"  id="open_id" style="display: none"/>
			<input type="button" value="${commodity.price}"  id="price" style="display: none"/>
		</div>
		<footer class="footer footerH4 clearfix">
			<font>金额：<i class="redFont">￥${commodity.price}</i></font>
			<aside class="oneBtn">
			<div id="to_slice">
				<input type="button" value="确定" onclick="makesure()"/>
			</div>
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
<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
var c_id=$("#c_id").val();
var a_id=$("#a_id").val();
var au_id=$("#au_id").val();
var open_id=$("#open_id").val();
var price=$("#price").val();
function makesure(){
	var deposit= $("#deposit").val();	
		if(confirm("您是否决定要分期？")){
			//分期
			var html= $("#to_slice").html("");
			var div="<input type='button' value='确定' onclick='to_slice()'/>";
			$("#to_slice").append(div);
			$("#deposit_box").show();
			alert("请输入预定金");
		}else{//直接选择不分期决定：下面get请求跳转后台创建订单
			window.location.href="http://www.kongtiaoguanjia.com/air/commodity/targetCreateCentralAirOrderState8.do?c_id="
			+c_id+"&au_id="+au_id+"&a_id="+a_id+"&open_id="+open_id+"&price="+price+"&deposit=0"+"&slice_flag=0";
		}
	
		
	
}
</script>
<script type="text/javascript">
var c_id=$("#c_id").val();
var a_id=$("#a_id").val();
var au_id=$("#au_id").val();
var open_id=$("#open_id").val();
var price=$("#price").val();
function to_slice(){
//分期之后点击创建订单	
 var deposit= $("#deposit").val();	
var price=$("#price").val();

	if(deposit==null||deposit==0){//跳转到商用空调创建订单
		alert("请您输入合法的预定金额：总价>=预定金>总价10%");	
	}else if(deposit<(price/10)){alert("请您输入合法的预定金额：总价>=预定金>总价10%");
	}else{
		window.location.href="http://www.kongtiaoguanjia.com/air/commodity/targetCreateCentralAirOrderState8.do?c_id="+c_id
		+"&au_id="+au_id+"&a_id="+a_id+"&open_id="+open_id+"&price="+price+"&deposit="+deposit+"&slice_flag=1";
	}
				
}
</script>