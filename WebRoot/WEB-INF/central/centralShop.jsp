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
<form action="../commodity/chooesCentralAirByParameter.do">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimum-scale=1.0,maximum-scale=1.0" />
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>商城首页</title>
	</head>

	<body>
		<nav class="homeNav padding1">
			<!-- <div class="padding05 radius2" style="width: 85%;">
				<input id="key" type="text" placeholder="请输入搜索关键词" />
				<img src="../img/home_nav_search@2x.png" onclick="sousuo()" class="littlePic fr"/>
				
			</div> -->
			<center><h1>空调金管家商城</h1></center>
				<span style="float: right; display:block; margin-top:-10px;"><a href="../targetGongZhongHao/homePage.do">取消</a></span>
		</nav>
		<nav class="showNav padding05 borderTB">
			<span><a href="../commodity/selectCommodity.do">综合</a></span>
			<span id="price">价格 <i></i></span>
			<span id="sales">销量 <i></i></span>
			<span class="screening">筛选</span>
		</nav>
	
		<figure class="hotSell">
		<c:if test="${not empty '${central_air}'}">
		<c:forEach items="${central_air}" var="data" varStatus="s">
			<a href='../commodity/selectCentralAirBycIdAndTarget.do?c_id=${data.c_id}'>  
			 <img src="http://www.kongtiaoguanjia.com/${data.cover_picture}"/> 
				<center class="padding05">${data.c_name}</center>
				<center class="redFont">￥${data.price}</center>
			</a>
		</c:forEach>
		</c:if>
		</figure>
	
		<aside class="layer"></aside>
		<input type="hidden" value="格力" name="brand" id="brand">
		<input type="hidden" value="2" name="use_type" id="use_type">
		<input type="hidden" value="0" name="type" id="type">
		<input type="hidden" value="0" name="frequency" id="frequency">
		<input type="hidden" value="1匹" name="level" id="level">
		<div class="commodityPopUp">
			<ul>
				<li>
					<h3>品牌</h3>
					<span onclick="change_brand('美的')">美的</span>
					<span onclick="change_brand('格力')">格力</span>
					<span onclick="change_brand('大金')">大金</span>
					<span onclick="change_brand('奥克斯')">奥克斯</span>
					<span onclick="change_brand('格力')">其它</span>
				</li>
				<li>
					<h3>空调种类</h3>
					<span onclick="change_use_type('2')">商用中央式</span>
				</li>
				<li>
					<h3>分类</h3>
					<span onclick="change_type('0')">挂机</span>
					<span onclick="change_type('1')">柜机</span>
					<span onclick="change_type('2')">天井机</span>
				</li>
				<li>
					<h3>频率</h3>
					<span onclick="change_frequency('0')">定频</span>
					<span onclick="change_frequency('1')">变频</span>
				</li>
				<li>
					<h3>功率</h3>
					<span onclick="change_level('1匹')">1匹</span>
					<span onclick="change_level('小1.5匹')">小1.5匹</span>
					<span onclick="change_level('1.5匹')">1.5匹</span>
					<span onclick="change_level('2匹')">2匹</span>
					<span onclick="change_level('2.5匹')">2.5匹</span>
					<span onclick="change_level('3匹')">3匹</span>
					<span onclick="change_level('4匹及以上')">4匹及以上</span>
				</li>
			</ul>
			<footer class="twoBtns">
				<input type="reset" value="重置" class="reset" />
				<input type="submit" value="确定" class="sure" />
			</footer>
		</div>
		<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
</body>
</form>
</html>
<script type="text/javascript">
function change_brand(data){
	$("#brand").val(data);
}
function change_use_type(data){
	$("#use_type").val(data);
}
function change_type(data){
	$("#use_type").val(data);
}
function change_frequency(data){
	$("#frequency").val(data);
}
function change_level(data){
	$("#level").val(data);
}
</script>
<script type="text/javascript">
function sousuo(){
	var keyword= $("#key").val();
	window.location.href="../CommonController/selectGoodsByKeyWords.do?keyword="+keyword;
}
</script>
<script type="text/javascript">
$(".showNav>span#price").toggle(function() { /*价格升降*/
	$(this).find("i").attr('class', 'iTop');
	$.ajax({
		url:"../commodity/selectCentralAirConditionByMark.do",
		type:"post",
		data:{"mark":2},
		success:function(data){
					var html=$(".hotSell").html("");
					for(i=0;i<data.length;i++){
					var	str="<a href='../commodity/selectCentralAirBycIdAndTarget.do?c_id="+data[i].c_id+"'>";
						str+="<img src='http://www.kongtiaoguanjia.com/"+data[i].cover_picture+"'/>";
						str+="<center class='padding05'>"+data[i].c_name+"</center>";
						str+="<center class='redFont'>￥"+data[i].price+"</center>";
						str+="</a>";
						html.append(str); 
					}
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
})
	
	
	
	
}, function() {
	$(this).find('i').attr('class', 'iBottom');
	$.ajax({
		url:"../commodity/selectCentralAirConditionByMark.do",
		type:"post",
		data:{"mark":1},
		success:function(data){
			var html=$(".hotSell").html("");
			for(i=0;i<data.length;i++){	
			var	str="<a href='../commodity/selectCentralAirBycIdAndTarget.do?c_id="+data[i].c_id+"'>";
				str+="<img src='htt	p://www.kongtiaoguanjia.com/"+data[i].cover_picture+"'/>";
				str+="<center class='padding05'>"+data[i].c_name+"</center>";
				str+="<center class='redFont'>￥"+data[i].price+"</center>";
				str+="</a>";
				html.append(str); 
				}
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
	})
	
})

$(".showNav>span#sales").toggle(function() { /*销量升降*/
	$(this).find("i").attr('class', 'iTop');
	$.ajax({
		url:"../commodity/selectCentralAirConditionByMark.do",
		type:"post",
		data:{"mark":4},
		success:function(data){
			alert("按时打算的话");
					var html=$(".hotSell").html("");
					for(i=0;i<data.length;i++){
					var	str="<a href='../commodity/selectCentralAirBycIdAndTarget.do?c_id="+data[i].c_id+"'>";
						str+="<img src='http://www.kongtiaoguanjia.com/"+data[i].cover_picture+"'/>";
						str+="<center class='padding05'>"+data[i].c_name+"</center>";
						str+="<center class='redFont'>￥"+data[i].price+"</center>";
						str+="</a>";
						html.append(str); 
					}
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
})
}, function() {
	$(this).find('i').attr('class', 'iBottom');
	$.ajax({
		url:"../commodity/selectCentralAirConditionByMark.do",
		type:"post",
		data:{"mark":3},
		success:function(data){
			alert("asdasdsad");
					var html=$(".hotSell").html("");
					for(i=0;i<data.length;i++){
					var	str="<a href='../commodity/selectCentralAirBycIdAndTarget.do?c_id="+data[i].c_id+"'>";
						str+="<img src='http://www.kongtiaoguanjia.com/"+data[i].cover_picture+"'/>";
						str+="<center class='padding05'>"+data[i].c_name+"</center>";
						str+="<center class='redFont'>￥"+data[i].price+"</center>";
						str+="</a>";
						html.append(str); 
					}
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
})
})


			$('.commodityPopUp li span').click(function() {
				$(this).addClass('popAct').siblings().removeClass('popAct');
			})

			$('.commodityPopUp .twoBtns .reset').click(function() {
				$('.commodityPopUp li span').removeClass("popAct");
			})

			var layer = document.querySelector(".layer"),
				commodityPopUp = document.querySelector(".commodityPopUp"),
				screening = document.querySelector(".screening"),
				sure = document.querySelector(".sure");
			screening.onclick = function() {
				layer.style.display = "block";
				commodityPopUp.style.display = "block";
			}
			layer.onclick = function() {
				this.style.display = "none";
				commodityPopUp.style.display = "none";
			}
			sure.onclick = function() {
				layer.style.display = "none";
				commodityPopUp.style.display = "none";
			}



</script>