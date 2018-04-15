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
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>商品展示</title>
	</head>

	<body>
		<nav class="homeNav padding1">
			<div class="padding05 radius2" style="width: 85%;">
				<input id="key" type="text" placeholder="请输入搜索关键词" />
				<img src="../img/home_nav_search@2x.png"  onclick="sousuo()" class="littlePic fr"/>
			</div>
			<a href="../targetGongZhongHao/homePage.do">取消</a>
		</nav>
		<!-- <nav class="showNav padding05 borderTB">
			<span>综合</span>
			<span id="price">价格 <i></i></span>
			<span id="sales">销量 <i></i></span>
			<span class="screening">筛选</span>
		</nav> -->
		<figure class="hotSell">
			<c:if test='${not empty "${commdity_list}"}'>
  			<c:forEach  items="${commdity_list}" var="data" varStatus="s"> 
				<a href="../commodity/selectCommodityBycIdAndTarget.do?c_id=${data.c_id}"><img src="http://www.kongtiaoguanjia.com/${data.cover_picture}" />
				<center class="padding05">${data.c_name}</center>
				<center class="redFont">${data.price}</center>
			</a>
			
			</c:forEach>
           	</c:if>
		</figure>
		<aside class="layer"></aside>
		<div class="commodityPopUp">
			<ul>
				<li>
					<h3>品牌</h3>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
				</li>
				<li>
					<h3>品牌</h3>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
				</li>
				<li>
					<h3>品牌</h3>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
				</li>
				<li>
					<h3>品牌</h3>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
					<span>美的</span>
				</li>
			</ul>
			<footer class="twoBtns">
				<input type="reset" value="重置" class="reset" />
				<input type="submit" value="确定" class="sure" />
			</footer>
		</div>
		<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>
<script type="text/javascript">
function sousuo(){
	
	var keyword= $("#key").val();
	window.location.href="../CommonController/selectGoodsByKeyWords.do?keyword="+keyword;
	
}


</script>
<!-- 
<!--<a href=""><img src="img/img_sp@2x.png" />
				<center class="padding05">首付交了手机费的历史</center>
				<center class="redFont">￥199</center>
			</a>
			<a href=""><img src="img/img_yanshou@2x.png" />
				<center class="padding05">首付交了手机费的历史</center>
				<center class="redFont">￥199</center>
			</a>
			<a href=""><img src="img/img_yanshou@2x.png" />
				<center class="padding05">首付交了手机费的历史</center>
				<center class="redFont">￥199</center>
			</a>
			<a href=""><img src="img/img_home_md@2x.png" />
				<center class="padding05">首付交了手机费的历史</center>
				<center class="redFont">￥199</center>
			</a>-->
