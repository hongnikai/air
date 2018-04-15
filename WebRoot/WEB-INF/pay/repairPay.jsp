<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'repairPay.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>付款界面</h1>
	<input value="${address.a_id}" id="a_id">
	<input value="${repair.repair_id}" id="repair_id">
	<input value="${repair_order.repair_order_id}" id="repair_order_id">
	<input value="${user.au_id}" id="au_id">
	<input value="${user.open_id}" id="open_id">
	<%-- <input value="${address.a_id}" id="a_id">
 --%>	

  </body>
</html>
<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript">
$(function(){
	var a_id=$("#a_id").val();
	var repair_id=$("#repair_id").val();
	var repair_order_id=$("#repair_order_id").val();
	var au_id=$("#au_id").val();
	var open_id=$("#open_id").val();
	
	 $.ajax({
			url:"http://www.kongtiaoguanjia.com/air/payController/toPay_Weixin.do",
			type:"post",
			data:{"money":0.01,"openid":open_id,"au_id":au_id,"c_id":repair_id,"a_id":a_id},
			success:function(data){
						alert("success!");
						alert(data.data.appId);
//						WeixinJSBridge.invoke('getBrandWCPayRequest', {
//						    "appId":""+data.data.appId+"",//公众号名称，由商户传入
//						    "timeStamp":""+data.data.timeStamp+"",//时间戳，自1970年以来的秒数
//						    "nonceStr":""+data.data.nonceStr+"", //随机串
//						    "package":""+data.data.package+"",
//						    "signType":"MD5",//微信签名方式：
//						    "paySign":""+data.data.paySign+"" //微信签名
//						},
//						function(res){
//						    // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回
						    // ok，但并不保证它绝对可靠。
//						    if(res.err_msg == "get_brand_wcpay_request:ok" ) {
//						    window.location.href="http://www.kongtiaoguanjia.com/air/CommodityOrderController/createCommodityOrderState1.do?money="
////						    		+price+"&au_id="+au_id+"&c_id="+c_id+"&a_id="+a_id;
//						    }
//						}
//						);
				},
			dataType:"json",
			error: function(msg){
				alert("哎呀网络开小差了，稍等会吧！");
				console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
			},
			async:false
		}) 
	
	
})
</script>