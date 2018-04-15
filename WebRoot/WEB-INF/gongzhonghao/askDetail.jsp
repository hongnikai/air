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
		<title>问答详情</title>
		<style type="text/css">
			body {
				background-color: #f6f6f6;
			}
			
			.header {
				position: fixed;
				border-bottom: 0;
				background-color: #f6f6f6;
			}
			
			.orderCon {
				background-color: #f6f6f6;
			}
			
			.orderCon .orderBox {
				padding: 1rem;
			}
			
			.userInfo b {
				display: inline-block;
			}
		</style>
	</head>

	<body>
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" class="littlePic" /></a>
			<center>问答详情</center>
		</header>
		<nav class="askCommodity clearfix">
			<a href="../commodity/selectCommodityBycIdAndTarget.do?c_id=${ask_all.c_id}"><img src="../img/img_detal@2x.png" />
				<font id="cName"></font>
				<img src="../img/icon_in@2x.png" alt="" class="littlePic fr" /></a>
		</nav>
		<div class="orderCon">>
			
			<section class="askCon">
				<h3 class="ask"><i class="littleWords">问</i>${ask_all.question}</h3>
				<p class="margin05"><span class="font888 littleWords">提问于<time class="font888" id="askTime">${ask_all.create_time}</time></span></p>
				
				<c:if test="${not empty '${answers}'}">
				<c:forEach items="${answers}" var="data" varStatus="s">
				<article class="askBox clearfix">
					<div class="userInfo">
						<img src="${data.headimg}" />
						<span>
							<p><b class="nickname">${data.nickname}</b><!-- <font class="blueBgc littleWords">已买</font> --></p>
							<time class="font888">${data.create_time}</time>
						</span>
					</div>
					<p class="answer">${data.content}</p>
					<span class="useful" onclick="add_use('${data.answers_id}')">
						<i class="triWhite"></i>
						有用
						<small id="good" style="color: green;">${data.mark}</small>
					</span>
					
				</article>
				</c:forEach>
				</c:if>
			</section>
		
		</div>
		<form action="../commodity/createAnswerByAsk.do">
		<footer class="footer">
			<input type="text" name="content" placeholder="输入您的回答" />
			<input name="ask_id" value="${ask_all.ask_id}" type="hidden">
			<input type="submit" value="发送" />
		</footer>
		
	</body>
		</form>
</html>
<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
function add_use(data){
	$.ajax({
		url:"../CommonController/addSupportRecord.do",
		type:"post",
		data:{"answerId":data},
		success:function(data){
					console.log(data);
					if(data.response_state=='FAIL该账号已经点过赞了'){
						$("#good").html(data.object+"+");
					}else{
						$("#good").html(data.object+"+");
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

