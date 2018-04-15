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
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>制作订单价格</title>
	</head>
	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>制作订单价格</center>
		</header>
		<div class="orderCon mT6">
			<section class="orderBox">
				<p class="margin05"><span>单号${commodityOrder.com_id}</span></p>
				<div class="orderInfo">
					<img src="http://www.kongtiaoguanjia.com/${commodityOrder.cover_picture}" alt="商品图片" />
					<article>
						<h4>${commodityOrder.c_name}</h4>
						<small>${commodityOrder.brand}</small>
						<p>
							<font class="redFont">￥<input id="price" class="radius2 priceIpt" type="number" name="price" required="required"/></font>
							<i class="fr greenFont">X1</i>
						</p>
					</article>
				</div>
				<article class="textWrap">
					备注
					<textarea id="beizhu" class="radius05"></textarea>
				</article>
			</section>
			<section class="orderBox paddingTB0">
				<ul>
					<li><span>合计：	</span><span class="redFont fr">￥${commodityOrder.total_price}</span></li>
					<li><span>预定金：	</span><span class="redFont fr">￥${commodityOrder.deposit}</span></li>
					<li><span>剩余尾款：	</span><span class="redFont fr">￥${commodityOrder.retainage}</span></li>
				</ul>
			</section>
		<input type="text" id="com_id" name="com_id" value="${commodityOrder.com_id}" style="display: none;">
		<input type="button" value="保存" class="longBtn" onclick="fun()"/>
		</div>
	</body>
</html>
<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
function fun(){
	var price= $("#price").val();
	var com_id=$("#com_id").val();
	var beizhu=$("#beizhu").val();
	
	 $.ajax({
			url:"http://www.kongtiaoguanjia.com/air/CommodityOrderController/updatePriceCommodityOrderBySaleman.do",
			type:"post",
			data:{"com_id":com_id,"price":price,"beizhu":beizhu},
			success:function(data){
				alert("success!");
					if(data.sign==0){
						alert("修改失败: 价格输入有误");
					}else{
						alert("修改成功");
					}
			
			
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