<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimum-scale=1.0,maximum-scale=1.0" />
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<script type="text/javascript" src="../js/jquery.js"></script>
		<title>立即评价</title>
	</head>	
<form action="http://www.kongtiaoguanjia.com/air/CommonController/addCommodityOrderEvalute.do" method="post" enctype="multipart/form-data">					  
	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>立即评价</center>
		</header>
		<div class="orderCon mT6">
			<section class="orderBox cartEvaluate">
				<article>
					<p class="fontBig">商品评价</p>
					<textarea contenteditable="true" class="editAble" name="content"></textarea>
				</article>
				<article>
				<input type="hidden" value="${commodity_order.com_id}" name="com_id" >
					<p class="fontBig">添加商品图片</p>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<img src="../img/icon_ys_photo@2x.png" />
						<input type="file" onchange="uploadPic(this)" name="picture"/>
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<img src="../img/icon_ys_photo@2x.png" />
						<input type="file" onchange="uploadPic(this)" name="picture"/>
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<img src="../img/icon_ys_photo@2x.png" />
						<input type="file" onchange="uploadPic(this)" name="picture"/>
					</div>
				</article>
			</section>
			<section class="orderBox">
				<ul>
					<li onmouseover="starRating(this)">
						<font class="w10">商品评价</font><span class="stars"><i></i><i></i><i></i><i></i><i></i></span>
						<font class="redFont"><a class="redFont grade"></a>分</font>
						<input type="hidden" id="commodity_score" name="commodity_score"> 
					</li>
					<li onmouseover="starRating2(this)">
						<font class="w10">销售员评价</font><span class="stars"><i></i><i></i><i></i><i></i><i></i></span>
						<font class="redFont"><a class="redFont grade"></a>分</font>
						<input type="hidden" id="sales_man_score" name="sales_man_score">
					</li>
					<li onmouseover="starRating3(this)">
						<font class="w10">安装工评价</font><span class="stars"><i></i><i></i><i></i><i></i><i></i></span>
						<font class="redFont"><a class="redFont grade"></a>分</font>
						<input type="hidden" id="installer_score" name="installer_score">
					</li>
				</ul>
			</section>
			<input type="submit" value="提交" class="longBtn" />
			
		</div>
		
<script type="text/javascript">
			function starRating(obj) {
				var starsBox = obj.getElementsByClassName("stars")[0];
				var stars = starsBox.getElementsByTagName("i"),
					starsLen = stars.length,
					starShow = 0;
				var grade = obj.getElementsByClassName("grade")[0];
				for(var i = 0; i < starsLen; i++) {
					stars[i].onclick = (function(num) {
						return function() {
							for(var j = 0; j < starsLen; j++) {
								if(j <= num) {
									stars[j].className = "light";
								} else {
									stars[j].className = "";
								}
							}
						}
					}(i));
					stars[i].onmouseup = (function(i) {
						return function() {
							starShow = i + 1;
							grade.innerHTML = starShow ;
							$("#commodity_score").val(starShow);
						}
					}(i));
				}
				return starShow;
			}
	
			function starRating2(obj) {
				var starsBox = obj.getElementsByClassName("stars")[0];
				var stars = starsBox.getElementsByTagName("i"),
					starsLen = stars.length,
					starShow = 0;
				var grade = obj.getElementsByClassName("grade")[0];
				for(var i = 0; i < starsLen; i++) {
					stars[i].onclick = (function(num) {
						return function() {
							for(var j = 0; j < starsLen; j++) {
								if(j <= num) {
									stars[j].className = "light";
								} else {
									stars[j].className = "";
								}
							}
						}
					}(i));
					stars[i].onmouseup = (function(i) {
						return function() {
							starShow = i + 1;
							grade.innerHTML = starShow ;
							$("#sales_man_score").val(starShow);
						}
					}(i));
				}
				return starShow;
			}
			function starRating3(obj) {
				var starsBox = obj.getElementsByClassName("stars")[0];
				var stars = starsBox.getElementsByTagName("i"),
					starsLen = stars.length,
					starShow = 0;
				var grade = obj.getElementsByClassName("grade")[0];
				for(var i = 0; i < starsLen; i++) {
					stars[i].onclick = (function(num) {
						return function() {
							for(var j = 0; j < starsLen; j++) {
								if(j <= num) {
									stars[j].className = "light";
								} else {
									stars[j].className = "";
								}
							}
						}
					}(i));
					stars[i].onmouseup = (function(i) {
						return function() {
							starShow = i + 1;
							grade.innerHTML = starShow ;
							$("#installer_score").val(starShow);
						}
					}(i));
				}
				return starShow;
			}
			
			// 循环遍历每个星星
			//          for (var i = 0; i < starsLen; i++) {
			//              stars[i].onmouseover = (function (num) {
			//                  return function () {
			//                      //再遍历一次所有的星鼠标左边的星变成黄色,有边变成灰色
			//                      for (var j = 0; j < starsLen; j++) {
			//                          if (j <= num) {
			//                              //黄色五角星添加类名imageOne
			//                              stars[j].className = "light";
			//                          } 
			//                      }
			//                  }
			//              }(i));//立即调用，把i传给num
			//			}
			function uploadPic(obj) {
				var file = obj.files[0],
					imgSrc = obj.value,
					url = URL.createObjectURL(file);
				if(!/\.(jpg|jpeg||png|JPG|PNG|JPEG)$/.test(imgSrc)) {
					alert("请上传jpg或png格式的图片！");
					return false;
				} else {
					obj.previousElementSibling.src = url;
				}
			}
		</script>
	</body>
</form>
</html>