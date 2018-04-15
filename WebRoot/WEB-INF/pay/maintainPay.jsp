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
    <title>maintainPay.jsp</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
  	<input type="hidden" value="${maintain_order.maintain_order_id}" id="maintain_order_id" />
  	<input type="hidden" value="${maintain_order.total_price}" id="price" />
  	<input type="hidden" value="${user.open_id}" id="open_id" />
  	<input type="hidden" value="${user.au_id}" id="au_id" />
  	<input type="hidden" value="${maintain.maintain_id}" id="maintain_id" />
  	<input type="hidden" value="${address.a_id}" id="a_id" />
  	
  	
  </body>
</html>
<script type="text/javascript">
$(function(){
	var maintain_order_id=$("#maintain_order_id").val();
	var price=$("#price").val();
	var open_id=$("#open_id").val();
	var au_id=$("#au_id").val();
	var maintain_id=$("#maintain_id").val();
	var a_id=$("#a_id").val();
	

	alert(price);
	alert(open_id);
	alert(au_id);
	alert(maintain_id);
	alert(a_id);
	
	$.ajax({
		url:"http://www.kongtiaoguanjia.com/air/payController/toPay_Weixin.do",
		type:"post",
		data:{"money":price,"openid":open_id,"au_id":au_id,"c_id":maintain_id,"a_id":a_id},
		success:function(data){
			alert("success");
			alert(data.data.appId);
			alert()
			
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
//			    	window.location.href="../InstallController/install_order_yes.do?au_id="+au_id;
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
})

</script>
