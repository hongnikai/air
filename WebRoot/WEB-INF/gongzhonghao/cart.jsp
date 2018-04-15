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
		<title>购物车</title>
		<style type="text/css">
			.orderCon .orderBox .orderInfo>article {
				vertical-align: middle;
			}
			
			.orderCon .orderBox .orderInfo>img {
				margin: 1rem 0;
			}
			
			.footer>.twoBtns {
				width: 30%;
			}
			
			.footer>.twoBtns>input {
				font-size: 1.5rem;
			}
			
			.footer>font:nth-child(2) {
				display: inline-block;
				width: 50%;
				text-align: center;
			}
			
			.footer>span:first-child {
				margin: 2%;
			}
		</style>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>购物车(<i id="cartNum"></i>)</center>
		</header>
		<div class="orderCon">
			<section class="orderBox">
				<div class="orderInfo bB0 bT0">
				<c:if test='${not empty "${commodity_car}"}'>
				<c:forEach  items="${commodity_car}" var="data" varStatus="s">
					<input type="radio" name="sb" class="c_radio" value="${data.c_car_id}" onclick="xianshi_price()"/>
					<img src="http://www.kongtiaoguanjia.com/${data.cover_picture}" alt="商品图片" />
					<article>
						<h4>${data.brand}</h4>
						<small>${data.c_name}</small>
						<p>
							<font class="redFont">${data.price}</font>
							<i class="fr greenFont">X1</i>
						</p>
					</article>
					</c:forEach>
				</c:if>
				</div>
			</section>
		</div>
		<footer class="footer footerH4 clearfix">
			<span>
				<!-- <input type="checkbox" id="checkAll"/>
				<label for="checkAll">全选</label> -->
			</span>
			<font>需支付：<i class="redFont"><input type="button" alt="0" id="to_price" style="border:0px;background-color:transparent;"/></i></font>
			<aside class="twoBtns">
				<input type="button" value="结算" id="settlement"  onclick="get()"/>
				<input type="submit" value="删除" id="delete" onclick="delete_commodity()"/>
			</aside>
		</footer>
		<script type="text/javascript" src="../js/jquery.js" charset="utf-8"></script>
	</body>
</html>
<script type="text/javascript">
	//$(".c_radio").val();
	function get(){  
        var value='';  
        var radio = document.getElementsByName("sb");  
        for(var i = 0;i<radio.length;i++)  
        {  
            if(radio[i].checked==true){
            	value = radio[i].value;  
            break;
            }  
        }  
        
        window.c_car_id = value;
        
        $.ajax({
    		url:"http://www.kongtiaoguanjia.com/air/commodity/getCommodityInformationInCart.do",
    		type:"post",
    		data:{"c_car_id":c_car_id},
    		success:function(data){
    			 	var c_car_id=data.c_car_id;
    				var price= data.price;
    				var c_id= data.c_id;
    				var au_id=data.au_id;
    				var open_id= data.open_id;
    				var address_sign=data.address_sign;
    				
    				if(address_sign==0){
    					//没创建地址的情况，跳转去创建地址
					window.location.href="http://www.kongtiaoguanjia.com/air/commodity/createPersonAddressCart.do?c_car_id="+c_car_id+"&price="+price+"&c_id="+c_id+"&au_id="+au_id+"&open_id="+open_id;
    				}else{
    					//创建了地址，直接付钱就ok
    					 $.ajax({
     						url:"http://www.kongtiaoguanjia.com/air/payController/toPay_Weixin.do",
     						type:"post",
     						data:{"money":price,"openid":open_id,"au_id":au_id,"c_id":c_id},
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
     									        window.location.href="http://www.kongtiaoguanjia.com/air/commodity/deleteCommodityInCar.do?c_car_id="+c_car_id;
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
    				
    			},
    		dataType:"json",
    		error: function(msg){
    			alert("请选择商品~");
    			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
    		},
    		async:false
    	}) 
    }  
	 

</script>
<script type="text/javascript">
function delete_commodity(){
	 var value='';  
     var radio = document.getElementsByName("sb");  
     for(var i = 0;i<radio.length;i++)  
     {  
         if(radio[i].checked==true){
         	value = radio[i].value;  
         break;
         }  
     }  
     
     window.c_car_id = value;
     
	window.location.href="http://www.kongtiaoguanjia.com/air/commodity/deleteCommoditysInCart.do?c_car_id="+c_car_id;
	
	
}
</script>
<script type="text/javascript">
function xianshi_price(){
	var value='';  
    var radio = document.getElementsByName("sb");  
    for(var i = 0;i<radio.length;i++)  
    {  
        if(radio[i].checked==true){
        	value = radio[i].value;  
        break;
        }  
    }  
    
    window.c_car_id = value;
	
    $.ajax({//局部刷新获取价格
			url:"http://www.kongtiaoguanjia.com/air/commodity/getCommodityPriceByc_car_id.do",
			type:"post",
			data:{"c_car_id":c_car_id},
			success:function(data){
				$("#to_price").val(data);
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
