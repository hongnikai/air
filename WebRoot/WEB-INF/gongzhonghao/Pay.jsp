<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Pay.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
  </head>
  
  <body>
  <!--   <form action="Http://localhost:8080/air/payController/toPay_Weixin.do">
    <input name="money" value="0.1" type="text">
    <input name="openid" value="oorAYxKwiAmP-emkOYg9o9n1XWRE" type="text">
    <input name="au_id" value="hongnikai" type="text">
    <input name="c_id" value="0" type="text">
    <input type="submit" value="提交">
    </form> -->
    
   <input type="button" value="tijiao" onclick="fun1()"/>
  </body>
</html>
<script type="text/javascript" src="http://www.kongtiaoguanjia.com/air/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script type="text/javascript">
function fun1(){
	alert("asd");
	 $.ajax({
		url:"../air/payController/toPay_Weixin.do",
		type:"post",
		data:{"money":0.1,"openid":"oorAYxKwiAmP-emkOYg9o9n1XWRE","au_id":"hongnikai","c_id":"0"},
		success:function(data){
					console.log(data);
					
				/* 	wx.config({
					    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
					    appId: 'data.appId', // 必填，公众号的唯一标识
					    timestamp: , // 必填，生成签名的时间戳
					    nonceStr: '', // 必填，生成签名的随机串
					    signature: '',// 必填，签名
					    jsApiList: [] // 必填，需要使用的JS接口列表
					}); */
					
					
					alert(data.data.appId);
					
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



</script>
