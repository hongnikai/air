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
		<title>评价列表</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>评价列表</center>
		</header>
		<div class="orderCon mT6">
			<section class="orderBox padding1">
				<div class="userInfo">
					<img src="${user.headimg}" />
					<span>
						<b class="nickname">${user.nickname}</b>
						<time class="font888">${eva.eva_time}</time>
					</span>
					<!-- <tt class="fr"><img class="littlePic" src="../img/634132897328110305.png"/>
					回复</tt> -->
				</div>
				<figure class="picBox">
					<figcaption class="margin1">${eva.content}</figcaption>
					<input type="text" value="${eva.picture}" id="picture" style="display: none">
					<div id="box">
					<!-- <img src="../img/img_sp@2x.png" />
					<img src="../img/img_home_bytc@2x.png" />
					<img src="../img/img_home_md@2x.png" /> -->
					</div>
				</figure>
				<article class="customerService marginT1 padding1">
					<p>客服回复：</p>
					<p>
					<c:if test="${eva.type=='0'}">
					暂无回复
					</c:if>
					<c:if test="${eva.type=='1'}">
					${eva.reply}
					</c:if>
					</p>
				</article>
			</section>
		</div>
		<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>

	</body>
</html>
<script type="text/javascript">
$(function(){
	var pic= $("#picture").val();			
		var html= $("#box").html("");
		var p=pic.split(",");
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