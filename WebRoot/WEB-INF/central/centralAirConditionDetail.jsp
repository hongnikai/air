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
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimum-scale=1.0,maximum-scale=1.0" />
		<title>商品详情</title>
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<style type="text/css">
			body {
				padding-bottom: 4rem;
			}
			
			footer {
				height: 4rem;
			}
		</style>
	</head>
	<body>
		<a style="position: absolute;margin: 1rem;" href="javascript:history.back()"><img src="../img/icon_backcircle@2x.png" style="width: 2.5rem" /></a>
		<img src="http://www.kongtiaoguanjia.com/${central_air.cover_picture}" class="detailPic" name="傻子"/>
		<section class="commodityIntro padding1">
			<p id="commodityDetails">${central_air.c_name}</p>
			<font class="redFont" id="unitPrice">${central_air.price}</font>
			<span class="yellowBgc littleWords">有货</span>
			<span class="grayBgc littleWords">缺货</span>
		</section>
		<p class="padding1 borderTB" onclick="fun1()">参数 <img src="../img/icon_in@2x.png" class="fr littlePic para" /></p>
		<section class="commodityEvaluate padding1">
			<c:if test='${not empty "${commodity_evaluate}"}'>
			<c:forEach  items="${commodity_evaluate}" var="data" varStatus="s" begin="0" end="0" step="1">
			<div class="userInfo">
				<img src="${data.headimg}" alt="../img/closelittle.png"/>
				<span>
					<b class="nickname">${data.nickname}</b>
					<time class="font888">2018-01-01</time>
				</span>
			</div>
			<p>${data.content}</p>
		</c:forEach>
        </c:if>	
			<center class="padding1">
				<a href="../commodity/targetCommodityEvaBycId.do?c_id=${central_air.c_id}" class="whiteBtn w6">查看更多</a>
			</center>
		</section>
		<section class="commodityQA padding1">
			
		
		
		
			<article class="notQA">
			<article class="notQA">
			<c:if test="${not empty '${ask}'}">
			<c:forEach items="${ask}" var="data" varStatus="s" begin="0" end="1" step="1">
				<p>${data.question}</p>
				<small style="color: gray;">${data.num}个回答</small>
				</c:forEach>
			</c:if> 
			<c:if test="${empty ask}">
				<small style="color: gray;">暂无回答</small>
			</c:if>
				<center class="padding1">
					<a href="../commodity/selectAllAsk_all.do?c_id=${central_air.c_id}" class="whiteBtn w6">查看全部</a>
				</center>
				
				<center class="font888 padding1">
					<img src="../img/icon_detail_wdj@2x.png" />宝贝好不好，问问已买过的人
				</center>
				<center class="padding1">
					<a href="../CommonController/gotoCreateQuestion.do?c_id=${central_air.c_id}" class="whiteBtn w6">去提问</a>
				</center>
			</article>
				<%-- <p>暂无回答</p>
				<center class="font888 padding1">
					<img src="../img/icon_detail_wdj@2x.png" />宝贝好不好，问问已买过的人
				</center>
				<center class="padding1">
					<a href="" class="whiteBtn w6">去提问</a>
				</center> --%>
			</article>
		</section>
		<c:if test='${not empty "${central_air}"}'>
		<input style="display: none" value="${central_air.detaile_picture}" type="text" id="pic"/>
		<div id="d_pic">
		<img src="http://www.kongtiaoguanjia.com/${central_air.detaile_picture}" class="detailPic" />
		<img src="img/img_banner1@2x.png" class="detailPic" />
		</div>
		 </c:if>
		 <footer class="footer">
			<aside class="threeBtns">
				<a href="">
					<img src="../img/icon_detail_xsy@2x.png" />销售员
				</a>
				<a>
					<img src="../img/icon_detail_sc@2x.png" />收藏
				</a>
				<!-- <a href="../commodity/targetCommodityCart.do">   商用空调暂时取消加入购物车功能
					<img src="../img/icon_user_gwc@2x.png" />购物车
				</a> -->
			</aside>
			<aside class="twoBtns">
				<input type="button" value="立即购买" class="buyNow" onclick="buy()"/>
				<input type="text" value="${user.open_id}" id="open_id" style="display: none">
				<input type="text" value="${central_air.c_id}" id="c_id" style="display: none">
				<input type="text" value="${central_air.price}" id="price" style="display: none">
				<input type="text" value="${user.au_id}" id="au_id" style="display: none">
				
				<%-- <input type="button" value="加入购物车" id="addToCart" onclick="addToCart('${central_air.c_id}')"/> --%>
			</aside>
		</footer>
		<article class="layer"></article>
		<div class="paraPopUp">
			<center>产品参数</center>
			<ul id="show"><!-- paramsList -->
						<li><font>上市时间</font><span>${central_air.create_time}</span></li>
						<li><font>保修日期</font><span>${central_air.repair_time}</span></li>
						<li><font>内机包装尺寸</font><span>${central_air.insert_pack_size}</span></li>
						<li><font>内机堆码层数极限</font><span>${central_air.insert_plies_max}</span></li>
						<li><font>内机毛重</font><span>${central_air.insert_weight}</span></li>
						<li><font>内机尺寸</font><span>${central_air.insert_size}</span></li>
						<li><font>制冷功率</font><span>${central_air.cold_power}</span></li>
						<li><font>制冷量</font><span>${central_air.cold_amount}</span></li>
						<li><font>外机包装尺寸</font><span>${central_air.out_pack_size}</span></li>
						<li><font>外机堆码层数极限</font><span>${central_air.out_plies_max}</span></li>
						<li><font>外机尺寸</font><span>${central_air.out_size}</span></li>
						<li><font>外机毛重</font><span>${central_air.out_weight}</span></li>
						<li><font>室内机噪音</font><span>${central_air.indoor_noise}</span></li>
						<li><font>室外机噪音</font><span>${central_air.outdoor_noise}</span></li>
						<li><font>智能类型</font><span>${central_air.smart_type}</span></li>
						<li><font>电辅加热功率</font><span>${central_air.heating_power}</span></li>
						<li><font>空调面板颜色</font><span>${central_air.air_board_color}</span></li>
						<li><font>能效备案号</font><span>${central_air.efficiency_number}</span></li>
						<li><font>空调类型</font><span>${central_air.air_type}</span></li>
						<li><font>冷暖类型</font><span>${central_air.temperature_type}</span></li>
						<li><font>空调功率</font><span>${central_air.air_power}</span></li>
						<li><font>适用面积</font><span>${central_air.suit_area}</span></li>
						<li><font>售后服务</font><span>${central_air.customer_service}</span></li>
						<li><font>工作方式</font><span>${central_air.work_method}</span></li>
						<li><font>能效等级</font><span>${central_air.power_level}</span></li>
						<li><font>是否循环风量</font><span>${central_air.wind_refresh_yes_or_not}</span></li>
						<li><font>室外净机重量</font><span>${central_air.out_net_weight}</span></li>
						<li><font>室内净机重量</font><span>${central_air.insert_net_weight}</span></li>
			</ul>
			<input type="button" value="确定" class="sure" onclick="fun2()"/>
		</div>

		<div class="buyPopUp">
			<section class="buyInfo">
				<img src="../img/img_home_bytc@2x.png" />
				<span>
						<b class="buyName"></b>
						<font class="redFont" id="buyPrice">￥0</font>
					</span>
			</section>
			<ul>
				<li>
					<font class="buyName"></font>
					<span class="fr count">
						<i id="minus">-</i>
						<i id="num">0</i>
						<i id="add">+</i>
					</span>
				</li>
			</ul>
			<p>合计
				<font class="fr redFont" id="buyTotal">￥0</font>
			</p>
			<input type="submit" value="确定" class="sure"/>
		</div> 
		<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/cookie.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
function addToCart(data){
	window.location.href="http://www.kongtiaoguanjia.com/air/commodity/addShopCar.do?c_id="+data;
}		
function fun1(){
	$(".paraPopUp").show();
}
function fun2(){
	$(".paraPopUp").hide();
}
function buy(){
	var c_id= $("#c_id").val();
	window.location.href="../commodity/centralAirtoBuyRightNow.do?c_id="+c_id;
}
$(function(){
 	var pic=$("#pic").val();
	var p= pic.split(","); 
	
	var html=$("#d_pic").html("");
	var img="";
	if(p[0]==","||p[0]==""||p[0]==null){}else{
		 img+="<img src='http://www.kongtiaoguanjia.com/"+p[0]+"'/>";	
	}
	if(p[1]==","||p[1]==""||p[1]==null){}else{
		img+="<img src='http://www.kongtiaoguanjia.com/"+p[1]+"'/>";
	}
	if(p[2]==","||p[2]==""||p[2]==null){}else{
		img+="<img src='http://www.kongtiaoguanjia.com/"+p[2]+"'/>";
	}
	html.append(img);
})

</script>
	</body>

</html>