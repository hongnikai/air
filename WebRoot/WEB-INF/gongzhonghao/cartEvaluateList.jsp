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
		<c:if test='${not empty "${list}"}'>
		<c:forEach  items="${list}" var="data" varStatus="s">
					<img src="${data.head_img}" alt="暂无头像"/>
					<span>
						<b class="nickname">${data.nickname}</b>
						<time class="font888">2018-01-01</time>
					</span>
					<!-- <tt class="fr"><img class="littlePic" src="../img/634132897328110305.png"/>
					回复</tt> -->
				</div>
				
				<figure class="picBox">
					<figcaption class="margin1">${data.content}</figcaption>
					<input type="text" id="getPics" value="${data.picture}" style="display: none;"/>
					<div id="picBox">
					<!-- 放图片的地方 -->
					</div>
				</figure>
				<article class="customerService marginT1 padding1">
					<p>客服回复：</p>
					<p>${data.reply}</p>
				</article>
		 </c:forEach>
        </c:if>			
			</section>
		</div>
		<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
	</body>
<script type="text/javascript">
$(function(){
	var pics= $("#getPics").val();
	var html= $("#picBox").html("");
	var p =pics.split(",");
	var img="";
	
	if(p[0]==","||p[0]==""||p[0]==null){}else{
		 img+="<img src='../../"+p[0]+"'/>";	
	}
	if(p[1]==","||p[1]==""||p[1]==null){}else{
		img+="<img src='../../"+p[1]+"'/>";
	}
	if(p[2]==","||p[2]==""||p[2]==null){}else{
		img+="<img src='../../"+p[2]+"'/>";
	}
	if(p[3]==","||p[3]==""||p[3]==null){}else{
		img+="<img src='../../"+p[3]+"'/>";
	}
			
	html.append(img);
	
})

</script>
</html>