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
		<script type="text/javascript" src="../js/jquery.js"></script>
		<title>我的订单</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>我的订单</center>
		</header>
		<nav class="orderNav">
			<span class="navAct">待接单</span>
			<span><a href="../InstallController/targetJiShuNotComplete.do?au_id=${user.au_id}">未完成</a></span>
			<span><a href="../InstallController/targetJiShuComplete.do?au_id=${user.au_id}">已完成</a></span>
		</nav>
		<input type="hidden" value="${user.au_id}" id="au_id">
		<div class="orderCon mT9">
			<section class="orderBox" id="install">
			</section>
			
			<section class="orderBox" id="maintain">
			</section>
			
			<section class="orderBox" id="repair">
			</section>
			
		</div>
	</body>
</html>
<script type="text/javascript">
var au_id= $("#au_id").val();
	$(function(){
		
		$.ajax({
			url:"../InstallController/selectJiShuOrderWaitForGet.do",
			type:"post",
			data:{"au_id":au_id},
			success:function(data){
						console.log(data);
						if(data.install_order.length==0){
							var html=$("#install").html("");
						}else{
							var html=$("#install").html("");
							for(var i=0;i<data.install_order.length;i++){
								var td="<p class='margin05'><span class='greenFont'>单号"+data.install_order[i].install_order_id+"</span>";
									td+="<input id="+data.install_order[i].install_order_id+" type='button' value='接单' class='greenBtn fr text_center' onclick='getOrder3(this.id)'; />";
									td+="</p>";
									td+="<div class='orderInfo'>";
									td+="<article>";
									td+="<h4>安装订单</h4>";
									td+="<small>"+data.install_order[i].brand+"</small>";
									if(data.install_order[i].type==0){
										td+="<small>挂机</small>&nbsp;&nbsp;";
									}else if(data.install_order[i].type==1){
										td+="<small>柜机</small>&nbsp;&nbsp;";
									}else if(data.install_order[i].type==2){
										td+="<small>天井机</small>&nbsp;&nbsp;";
									}else {}
									if(data.install_order[i].purpose==0){
										td+="<small>家用分体式</small>";	
									}else if(data.install_order[i].purpose==1){
										td+="<small>家用中央空调</small>";	
									}else if(data.install_order[i].purpose==2){
										td+="<small>商用中央空调</small>";
									}else{}
									td+="<p>";
									td+="<font class='redFont'>￥"+data.install_order[i].total_price+"</font>";
									td+="<i class='fr greenFont'>X1</i>";
									td+="</p></article></div>";
									td+="<p class='margin05'>";
									td+="<span>共<i>1</i>件商品 合计：<font class='redFont'>￥"+data.install_order[i].total_price+"</font></span>";
									td+="<span class='fr'>剩余尾款：<font class='redFont'>￥"+data.install_order[i].retainage+"</font></span>";
									td+="</p>";
								html.append(td);
							}
						}
						if(data.maintain_order.length==0){
							var html=$("#maintain").html("");
						}else{
							var html=$("#maintain").html("");
							for(var i=0;i<data.maintain_order.length;i++){
								var td="<p class='margin05'><span class='greenFont'>单号"+data.maintain_order[i].maintain_order_id+"</span>";
									td+="<input id="+data.maintain_order[i].maintain_order_id+" type='button' value='接单' class='greenBtn fr text_center'  onclick='getOrder2(this.id)'; />";
									td+="</p>";
									td+="<div class='orderInfo'>";
									td+="<article>";
									td+="<h4>保养订单</h4>";
									td+="<small>"+data.maintain_order[i].brand+"</small>&nbsp;&nbsp;";
									if(data.maintain_order[i].type==0){
										td+="<small>挂机</small>&nbsp;&nbsp;";
									}else if(data.maintain_order[i].type==1){
										td+="<small>柜机</small>&nbsp;&nbsp;";
									}else if(data.maintain_order[i].type==2){
										td+="<small>天井机</small>&nbsp;&nbsp;";
									}else {}
									if(data.maintain_order[i].purpose==0){
										td+="<small>家用分体式</small>";	
									}else if(data.maintain_order[i].purpose==1){
										td+="<small>家用中央空调</small>";	
									}else if(data.maintain_order[i].purpose==2){
										td+="<small>商用中央空调</small>";
									}else{}
									td+="<p>";
									td+="<font class='redFont'>￥"+data.maintain_order[i].total_price+"</font>";
									td+="<i class='fr greenFont'>X1</i>";
									td+="</p></article></div>";
									td+="<p class='margin05'>";
									td+="<span>共<i>1</i>件商品 合计：<font class='redFont'>￥"+data.maintain_order[i].total_price+"</font></span>";
									td+="<span class='fr'>剩余尾款：<font class='redFont'>￥"+data.maintain_order[i].retainage+"</font></span>";
									td+="</p>";
								html.append(td);
							}
						}
						if(data.repair_order.length==0){
							var html=$("#repair").html("");
						}else{
							var aaa="asdasd";
							var html=$("#repair").html("");
							for(var i=0;i<data.repair_order.length;i++){
								var td="<p class='margin05'><span class='greenFont'>单号"+data.repair_order[i].repair_order_id+"</span>";
									td+="<input id="+data.repair_order[i].repair_order_id+" type='button' value='接单' class='greenBtn fr text_center' onclick='getOrder(this.id)'; />";
									td+="</p>";
									td+="<div class='orderInfo'>";
									td+="<article>";
									td+="<h4>维修订单</h4>";
									td+="<small>"+data.repair_order[i].brand+"</small>&nbsp;&nbsp;";
									if(data.repair_order[i].type==0){
										td+="<small>挂机</small>&nbsp;&nbsp;";
									}else if(data.repair_order[i].type==1){
										td+="<small>柜机</small>&nbsp;&nbsp;";
									}else if(data.repair_order[i].type==2){
										td+="<small>天井机</small>&nbsp;&nbsp;";
									}else {}
									if(data.repair_order[i].purpose==0){
										td+="<small>家用分体式</small>";	
									}else if(data.repair_order[i].purpose==1){
										td+="<small>家用中央空调</small>";	
									}else if(data.repair_order[i].purpose==2){
										td+="<small>商用中央空调</small>";
									}else{}
									td+="<p>";
									td+="<font class='redFont'>￥"+data.repair_order[i].total_price+"</font>";
									td+="<i class='fr greenFont'>X1</i>";
									td+="</p></article></div>";
									td+="<p class='margin05'>";
									td+="<span>共<i>1</i>件商品 合计：<font class='redFont'>￥"+data.repair_order[i].total_price+"</font></span>";
									td+="<span class='fr'>剩余尾款：<font class='redFont'>￥"+data.repair_order[i].retainage+"</font></span>";
									td+="</p>";
								html.append(td);
							}
						}
				},
			dataType:"json",
			error: function(msg){
				alert("哎呀网络开小差了，稍等会吧！");
				console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
			},
			async:false
		});
	})
function getOrder(data){//接维修订单方法
		var repair_order_id=data;
		 $.ajax({
				url:"../InstallController/jishuGetOrders.do",
				type:"post",
				data:{"order_id":repair_order_id,"au_id":au_id},
				success:function(data){
					alert(data.sign);
					console.log(data);
				},
				dataType:"json",
				error: function(msg){
					alert("哎呀网络开小差了，稍等会吧！");
					console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
				},
				async:false
			});
}
function getOrder2(data){
	var maintain_order_id=data;
	$.ajax({
		url:"../InstallController/jishuGetOrders.do",
		type:"post",
		data:{"order_id":maintain_order_id,"au_id":au_id,"sign":1},
		success:function(data){
			alert(data.sign);
			console.log(data);
		},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
	});
}
function getOrder3(data){
	var install_order_id=data;
	$.ajax({
		url:"../InstallController/jishuGetOrders.do",
		type:"post",
		data:{"order_id":install_order_id,"au_id":au_id,"sign":2},
		success:function(data){
			alert(data.sign);
			console.log(data);
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