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
		<script type="text/javascript" src="../js/jquery.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>维修验收进度</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>维修验收进度</center>
		</header>
		<div class="orderCon mT6">
			<section class="orderBox">
				<p class="fontBig margin05">上门照片</p>
				<div class="uploadBox">
					<div class="upload">
					<!-- 	<i class="removeBtn" onclick="removePic(this)"></i> -->
						<input type="text" value="${repair_order.go_indoor_picture}" id="pic1" style="display: none"/>
						<div id="indoor_pic1">
						

						</div>
						<!-- <input type="file" onchange="uploadPic(this)" /> -->
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="indoor_pic2">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="indoor_pic3">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
				</div>
			</section>
			<section class="orderBox">
				<p class="fontBig margin05">机器检测照片</p>
				<div class="uploadBox">
					<div class="upload">
					<input  type="text"  value="${repair_order.jiqi_jiance_picture}"  id="pic2" style="display: none;"/>
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="jiqi_jiance_pic1">
							
						
						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="jiqi_jiance_pic2">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="jiqi_jiance_pic3">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
				</div>
			</section>
			<section class="orderBox">
				<p class="fontBig margin05">维修更换部件照片</p>
				<div class="uploadBox">
					<div class="upload">
					<input  type="text"  value="${repair_order.change_part_picture}"  id="pic3" style="display: none;"/>
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="change_part_pic1">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="change_part_pic2">
						

						</div>

						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="change_part_pic3">
						

						</div>

						<input type="file" onchange="uploadPic(this)" />
					</div>
				</div>
			</section>
			<input type="hidden" value="${repair_order.repair_detail} "/><!-- 维修详情 -->
			<input type="hidden" value="${repair_order.repair_price}"><!-- 维修报价 -->
			
			<input type="hidden" value="${repair_order.complet_opinion}"/>
			<input type="submit" value="确认并提交尾款" class="longBtn" />
		</div>
		<script type="text/javascript">
			//			var upload=document.getElementsByClassName("upload");
			//			var w=upload.offsetWidth;console.log(w)
			//			upload.style.height=w;
			function uploadPic(obj) {
				var file = obj.files[0],
					imgSrc = obj.value,
					url = URL.createObjectURL(file);
				if(!/\.(jpg|jpeg|png|JPG|PNG|JPEG)$/.test(imgSrc)) {
					alert("请上传jpg或png格式的图片！");
					return false;
				} else {
					obj.previousElementSibling.src = url;
				}
			}

			function removePic(obj) {
				//				var html=[];
				//				var upload='<div class="upload">'+
				//						'<i class="removeBtn" onclick="removePic(this)"></i>'+
				//						'<img src="img/icon_ys_photo@2x.png" />'+
				//						'<input type="file" onchange="uploadPic(this)" /></div>';
				//						html.push(upload);
				var upload = document.createElement("div");
				upload.className = "upload";
				upload.style.marginLeft = 0.3 + "rem";
				upload.innerHTML = '<i class="removeBtn" onclick="removePic(this)"></i>' +
					'<img src="img/icon_ys_photo@2x.png" />' +
					'<input type="file" onchange="uploadPic(this)" />';
				obj.parentElement.parentElement.appendChild(upload);
				obj.parentElement.parentElement.removeChild(obj.parentElement);
			}
		</script>
	</body>

</html>
<script type="text/javascript">
$(function(){
	//var indoor_pic1="1.jpg,2.jpg,3.jpg";	
	var indoor_pic1=$("#pic1").val();  //上门照片
 	if(indoor_pic1==null||indoor_pic1==""||indoor_pic1=="0"||indoor_pic1==" "){
			
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#indoor_pic1").append(img);
			$("#indoor_pic2").append(img);
			$("#indoor_pic3").append(img);
		}else{
			var str=indoor_pic1.split(",");
			if(str[0]!=null||str[0]!=""||str[0]!=" "||str[0]!=","){
				var img="<img src='http://www.kongtiaoguanjia.com/"+str[0]+"'/>";
				$("#indoor_pic1").append(img);
			}else{
				var img="<img src='../img/icon_ys_photo@2x.png'/>";
				$("#indoor_pic1").append(img);
			}
			if(str[1]!=null||str[1]!=""||str[1]!=" "||str[1]!=","){
				var img="<img src='http://www.kongtiaoguanjia.com/"+str[1]+"'/>";
				$("#indoor_pic2").append(img);
			}else{
				var img="<img src='../img/icon_ys_photo@2x.png'/>";
				$("#indoor_pic2").append(img);
			}
			if(str[2]!=null||str[2]!=""||str[2]!=" "||str[2]!=","){
				var img="<img src='http://www.kongtiaoguanjia.com/"+str[2]+"'/>";
				$("#indoor_pic3").append(img);
			}else{
				var img="<img src='../img/icon_ys_photo@2x.png'/>";
				$("#indoor_pic3").append(img);
			}
		} 
	/***********************************************************************************************************/
	 
		//var jiqi_jiance_pic="1.jpg,2.jpg,3.jpg";	
		var jiqi_jiance_pic=$("#pic2").val();   //机器检测图片
		if(jiqi_jiance_pic==null||jiqi_jiance_pic==""||jiqi_jiance_pic=="0"||jiqi_jiance_pic==" "){
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#jiqi_jiance_pic1").append(img);
			$("#jiqi_jiance_pic2").append(img);
			$("#jiqi_jiance_pic3").append(img);
		}else{
			var str=jiqi_jiance_pic.split(",");
			if(str[0]!=null||str[0]!=""||str[0]!=" "||str[0]!=","){
				var img="<img src='http://www.kongtiaoguanjia.com/"+str[0]+"'/>";
				$("#jiqi_jiance_pic1").append(img);
			}else{
				var img="<img src='../img/icon_ys_photo@2x.png'/>";
				$("#jiqi_jiance_pic1").append(img);
			}
			if(str[1]!=null||str[1]!=""||str[1]!=" "||str[1]!=","){
				var img="<img src='http://www.kongtiaoguanjia.com/"+str[1]+"'/>";
				$("#jiqi_jiance_pic2").append(img);
			}else{
				var img="<img src='../img/icon_ys_photo@2x.png'/>";
				$("#jiqi_jiance_pic2").append(img);
			}
			if(str[2]!=null||str[2]!=""||str[2]!=" "||str[2]!=","){
				var img="<img src='http://www.kongtiaoguanjia.com/"+str[2]+"'/>";
				$("#jiqi_jiance_pic3").append(img);
			}else{
				var img="<img src='../img/icon_ys_photo@2x.png'/>";
				$("#jiqi_jiance_pic3").append(img);
			}
		}
		 
		/***********************************************************************************************************/
		
		//var change_part_pic="1.jpg,2.jpg,3.jpg";	
		var change_part_pic=$("#pic3").val();   //压力检测图片
		if(change_part_pic==null||change_part_pic==""||change_part_pic=="0"||change_part_pic==" "){
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#change_part_pic1").append(img);
			$("#change_part_pic2").append(img);
			$("#change_part_pic3").append(img);
		}else{
			var str=change_part_pic.split(",");
			if(str[0]!=null||str[0]!=""||str[0]!=" "||str[0]!=","){
				var img="<img src='http://www.kongtiaoguanjia.com/"+str[0]+"'/>";
				$("#change_part_pic1").append(img);
			}else{
				var img="<img src='../img/icon_ys_photo@2x.png'/>";
				$("#change_part_pic1").append(img);
			}
			if(str[1]!=null||str[1]!=""||str[1]!=" "||str[1]!=","){
				var img="<img src='http://www.kongtiaoguanjia.com/"+str[1]+"'/>";
				$("#change_part_pic2").append(img);
			}else{
				var img="<img src='../img/icon_ys_photo@2x.png'/>";
				$("#change_part_pic2").append(img);
			}
			if(str[2]!=null||str[2]!=""||str[2]!=" "||str[2]!=","){
				var img="<img src='http://www.kongtiaoguanjia.com/"+str[2]+"'/>";
				$("#change_part_pic3").append(img);
			}else{
				var img="<img src='../img/icon_ys_photo@2x.png'/>";
				$("#change_part_pic3").append(img);
			}
		}
		/***********************************************************************************************************/
		
		
		});
</script>