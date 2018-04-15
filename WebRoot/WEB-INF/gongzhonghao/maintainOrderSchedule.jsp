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
		<title>保养验收进度</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>保养验收进度</center>
		</header>
		<div class="orderCon mT6">
			<section class="orderBox">
				<p class="fontBig margin05">上门照片</p>
				<div class="uploadBox">
					<div class="upload">
					<!-- 	<i class="removeBtn" onclick="removePic(this)"></i> -->
						<input type="text" value="${maintain_order.go_indoor_picture}" id="pic1" style="display: none;" />
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
				<p class="fontBig margin05">压力、电流、维修检测</p>
				<div class="uploadBox">
					<div class="upload">
					<input  type="text"  value="${maintain_order.yali_dianliu_weixiu}"  id="pic2" style="display: none;"/>
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="yali_pic1">
						
						
						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="yali_pic2">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="yali_pic3">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
				</div>
			</section>
			<section class="orderBox">
				<p class="fontBig margin05">清洗前</p>
				<div class="uploadBox">
					<div class="upload">
					<input  type="text"  value="${maintain_order.clean_before}"  id="pic3" style="display: none;"/>
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="clean_before1">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="clean_before2">
						

						</div>

						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="clean_before3">
						

						</div>

						<input type="file" onchange="uploadPic(this)" />
					</div>
				</div>
			</section>
			<section class="orderBox">
				<p class="fontBig margin05">清洗中</p>
				<div class="uploadBox">
					<div class="upload">
					<input  type="text"  value="${maintain_order.clean_ing}"  id="pic4" style="display: none;"/>
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="clean_ing1">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="clean_ing2">
						

						</div>

						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="clean_ing3">
						

						</div>

						<input type="file" onchange="uploadPic(this)" />
					</div>
				</div>
			</section>
			<section class="orderBox">
				<p class="fontBig margin05">清洗后</p>
				<div class="uploadBox">
					<div class="upload">
					<input  type="text"  value="${maintain_order.clean_after}"  id="pic5" style="display: none;"/>
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="clean_after1">
						

						</div>
						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="clean_after2">
						

						</div>

						<input type="file" onchange="uploadPic(this)" />
					</div>
					<div class="upload">
						<i class="removeBtn" onclick="removePic(this)"></i>
						<div id="clean_after3">
						

						</div>

						<input type="file" onchange="uploadPic(this)" />
					</div>
				</div>
			</section>
			<input type="button" value="${maintain_order.complet_opinion}" style="display: none;"/>
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
	var yali_pic=$("#pic2").val();   //压力检测图片
	
	if(yali_pic==null||yali_pic==""||yali_pic=="0"||yali_pic==" "){
		var img="<img src='../img/icon_ys_photo@2x.png'/>";
		$("#yali_pic1").append(img);
		$("#yali_pic2").append(img);
		$("#yali_pic3").append(img);
	}else{
		var str=yali_pic.split(",");
		if(str[0]!=null||str[0]!=""||str[0]!=" "||str[0]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/"+str[0]+"'/>";
			$("#yali_pic1").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#yali_pic1").append(img);
		}
		if(str[1]!=null||str[1]!=""||str[1]!=" "||str[1]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/"+str[1]+"'/>";
			$("#yali_pic2").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#yali_pic2").append(img);
		}
		if(str[2]!=null||str[2]!=""||str[2]!=" "||str[2]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/"+str[2]+"'/>";
			$("#yali_pic3").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#yali_pic3").append(img);
		}
	}
	/***********************************************************************************************************/
	//var clean_before="1.jpg,2.jpg,3.jpg";
	var clean_before=$("#pic3").val();
	if(clean_before==null||clean_before==""||clean_before=="0"||clean_before==" "){
		var img="<img src='../img/icon_ys_photo@2x.png'/>";
		$("#clean_before1").append(img);
		$("#clean_before2").append(img);
		$("#clean_before3").append(img);
	}else{
		var str=clean_before.split(",");
		if(str[0]!=null||str[0]!=""||str[0]!=" "||str[0]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/"+str[0]+"'/>";
			$("#clean_before1").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#clean_before1").append(img);
		}
		if(str[1]!=null||str[1]!=""||str[1]!=" "||str[1]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/"+str[1]+"'/>";
			$("#clean_before2").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#clean_before2").append(img);
		}
		if(str[2]!=null||str[2]!=""||str[2]!=" "||str[2]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/"+str[2]+"'/>";
			$("#clean_before3").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#clean_before3").append(img);
		}
	}
	/***********************************************************************************************************/
	//var clean_ing="1.jpg,2.jpg,3.jpg";
	var clean_ing=$("#pic4").val();
	if(clean_ing==null||clean_ing==""||clean_ing=="0"||clean_ing==" "){
		var img="<img src='../img/icon_ys_photo@2x.png'/>";
		$("#clean_ing1").append(img);
		$("#clean_ing2").append(img);
		$("#clean_ing3").append(img);
	}else{
		var str=clean_ing.split(",");
		if(str[0]!=null||str[0]!=""||str[0]!=" "||str[0]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/"+str[0]+"'/>";
			$("#clean_ing1").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#clean_ing1").append(img);
		}
		if(str[1]!=null||str[1]!=""||str[1]!=" "||str[1]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/"+str[1]+"'/>";
			$("#clean_ing2").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#clean_ing2").append(img);
		}
		if(str[2]!=null||str[2]!=""||str[2]!=" "||str[2]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/"+str[2]+"'/>";
			$("#clean_ing3").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#clean_ing3").append(img);
		}
	}
	/***********************************************************************************************************/	
	//var clean_after="1.jpg,2.jpg,3.jpg";
	var clean_after=$("#pic5").val();
	if(clean_after==null||clean_after==""||clean_after=="0"||clean_after==" "){
		var img="<img src='../img/icon_ys_photo@2x.png'/>";
		$("#clean_after1").append(img);
		$("#clean_after2").append(img);
		$("#clean_after3").append(img);
	}else{
		var str=clean_after.split(",");
		if(str[0]!=null||str[0]!=""||str[0]!=" "||str[0]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/head_img/"+str[0]+"'/>";
			$("#clean_after1").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#clean_after1").append(img);
		}
		if(str[1]!=null||str[1]!=""||str[1]!=" "||str[1]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/head_img/"+str[1]+"'/>";
			$("#clean_after2").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#clean_after2").append(img);
		}
		if(str[2]!=null||str[2]!=""||str[2]!=" "||str[2]!=","){
			var img="<img src='http://www.kongtiaoguanjia.com/head_img/"+str[2]+"'/>";
			$("#clean_after3").append(img);
		}else{
			var img="<img src='../img/icon_ys_photo@2x.png'/>";
			$("#clean_after3").append(img);
		}
	
	}
	
})
</script>
