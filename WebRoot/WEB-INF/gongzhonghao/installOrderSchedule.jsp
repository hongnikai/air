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
		<script type="text/javascript" src="../js/jquery.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>安装验收进度</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>安装验收进度</center>
		</header>
		<div class="orderCon mT6">
			<section class="orderBox">
				<p class="fontBig margin05">上门照片</p>
				<div class="uploadBox">
					<div class="upload">
					<!-- 	<i class="removeBtn" onclick="removePic(this)"></i> -->
						<input type="text" value="${data.go_indoor_picture}" id="pic1" style="display: none;" />
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
				<p class="fontBig margin05">安装位置确认</p>
				<div class="uploadBox">
					<div class="upload">
					<input  type="text"  value="${data.area_picture}"  id="pic2" style="display: none;"/>
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="area_pic1">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="area_pic2">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="area_pic3">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
				</div>
			</section>
			<section class="orderBox">
				<p class="fontBig margin05">安装确认</p>
				<div class="uploadBox">
					<div class="upload">
					<input  type="text"  value="${data.make_sure_picture}"  id="pic3" style="display: none;"/>
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="make_sure_pic1">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="make_sure_pic2">
						

						</div>

						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="make_sure_pic3">
						

						</div>

						<input type="file" onchange="uploadPic(this)" />
					</div>
				</div>
			</section>
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
	var area_pic=$("#pic2").val();//安装位置确认图片
	if(area_pic==null||area_pic==""||area_pic=="0"||area_pic==" "){
		var img="<img src='../img/icon_ys_photo@2x.png'/>";
		$("#area_pic1").append(img);
		$("#area_pic2").append(img);
		$("#area_pic3").append(img);
	}else{
		var str=area_pic.split(",");
		alert(str[0]);
		alert(str[1]);
		alert(str[2]);
		if(str[0]!=null||str[0]!=""||str[0]!=" "||str[0]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/head_img/"+str[0]+"'/>";	
			$("#area_pic1").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#area_pic1").append(img);
		} 
			
		if(str[1]!=null||str[1]!=""||str[1]!=" "||str[1]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/head_img/"+str[1]+"'/>";	
			$("#area_pic2").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#area_pic1").append(img);
		} 
		if(str[2]!=null||str[2]!=""||str[2]!=" "||str[2]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/head_img/"+str[2]+"'/>";
			$("#area_pic3").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#area_pic1").append(img);
		}
	}
	/***********************************************************************************************************/	
	var make_sure_pic=$("#pic3").val();//安装确认照片
	if(make_sure_pic==null||make_sure_pic==""||make_sure_pic=="0"||make_sure_pic==" "){
		var img="<img src='../img/icon_ys_photo@2x.png'/>";
		$("#make_sure_pic1").append(img);
		$("#make_sure_pic2").append(img);
		$("#make_sure_pic3").append(img);
	}else{
		var str=make_sure_pic.split(",");
		alert(str[0]);
		alert(str[1]);
		alert(str[2]);
		if(str[0]!=null||str[0]!=""||str[0]!=" "||str[0]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/head_img/"+str[0]+"'/>";	
			$("#make_sure_pic1").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#make_sure_pic1").append(img);
		} 
		if(str[1]!=null||str[1]!=""||str[1]!=" "||str[1]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/head_img/"+str[1]+"'/>";	
			$("#make_sure_pic2").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#make_sure_pic2").append(img);
		} 
		if(str[2]!=null||str[2]!=""||str[2]!=" "||str[2]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/head_img/"+str[2]+"'/>";	
			$("#make_sure_pic3").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#make_sure_pic3").append(img);
		} 
	}
	/***********************************************************************************************************/	
	
	
	
})
</script>
