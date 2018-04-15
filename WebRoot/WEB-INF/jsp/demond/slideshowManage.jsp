<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>轮播图管理</title>
		<link rel="stylesheet" type="text/css" href="${ctx }/css/style.css" />
		<script src="${ctx }/media/js/jquery/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${ctx }/media/js/bootstrap/js/bootstrap.min.js"></script>
		<script src="${ctx }/media/js/jquery-bootpag/jquery.bootpag.js"></script>
		<style type="text/css">
			.delete{
				margin-left: 90%;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<div class="slideBox">
				<h2>①首页</h2>
				<form action="${ctx}/lc/sysdata/uploadImags.action" method="post" enctype="multipart/form-data">
				<div class="uploadBox">
					<div class="upload">
					<c:if test="${empty map.pic11}">
						<img class="floatl view" src="${ctx}/img/addPic.png"/>
					</c:if>
					<c:if test="${not empty map.pic11}">
						<img class="floatl view" src="${picturePath}/${map.pic11}"/>
					</c:if>	
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
				</div>
				<div class="uploadBox">
					<div class="upload">
						<img class="floatl view" src="${picturePath}/${map.pic12}" />
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
				</div>
				<div class="uploadBox">
					<div class="upload">
						<img class="floatl view" src="${picturePath}/${map.pic13}" />
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
				</div>
				<input type="submit" value="保存" class="delete"/>
			</div>
			</form>
			<div class="slideBox">
				<h2>②发布</h2>
				<div class="uploadBox">
					<div class="upload">
						<form action="${ctx}/lc/sysdata/uploadImags2.action" method="post" enctype="multipart/form-data">
						<img class="floatl view" src="${picturePath}/${map.pic21}" />
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
				</div>
				<div class="uploadBox">
					<div class="upload">
						<img class="floatl view" src="${picturePath}/${map.pic22}" />
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
				</div>
				<div class="uploadBox">
					<div class="upload">
						<img class="floatl view" src="${picturePath}/${map.pic23}" />
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
				</div>
				<input type="submit" value="保存" class="delete"/>
				</form>
			</div>
			<div class="slideBox">
				<h2>③案例</h2>
				<div class="uploadBox">
					<div class="upload">
						<form action="${ctx}/lc/sysdata/uploadImags3.action" method="post" enctype="multipart/form-data">
						<img class="floatl view" src="${picturePath}/${map.pic31}" />
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
				</div>
				<div class="uploadBox">
					<div class="upload">
						<img class="floatl view" src="${picturePath}/${map.pic32}" />
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
				</div>
				<div class="uploadBox">
					<div class="upload">
						<img class="floatl view" src="${picturePath}/${map.pic33}" />
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
				</div>
				<input type="submit" value="保存" class="delete"/>
				</form>
			</div>
		</div>
<script type="text/javascript">
var url;
var c;//回调数据
			function upLoadPic(obj) {
				var file = $(obj)[0].files[0],
					imgSrc = $(obj)[0].value,
					url = URL.createObjectURL(file);
				if(!/\.(jpg|jpeg|png|JPG|PNG|JPEG)$/.test(imgSrc)) {
					alert("请上传jpg或png格式的图片！");
					return false;
				} else {
					$(obj).prev("img").attr('src', url);
				}
			}
		/*  $(function(){
			$.ajax({
				url:"${ctx}/wzd/Demand/getSystemData.action",
				type:"post",
				success:function(data){
					alert("回调数据成功");
					c=data.data;
					console.log(c);
					var str = c.sys_banner.split(",");
						if(typeof(str[0]) != "undefined"&&str[0] != null){
							var html=$("#img1-1").html("");
							var img="<img class='floatl view' src='${ctx }/"+str[0]+"/' alt='加载中'/>";
							html.append(img);
						}else{console.log("图片为空/系统出现异常")};
						if(typeof(str[1]) != "undefined"&&str[1] != null){
							var html=$("#img1-2").html("");
							var img="<img class='floatl view' src='${ctx }/"+str[1]+"/'/>";
							html.append(img);
						}else{console.log("图片为空/系统出现异常");};
						if(typeof(str[2]) != "undefined"&&str[2] != null){
							var html=$("#img1-3").html("");
							var img="<img class='floatl view' src='${ctx }/"+str[2]+"/'/>";
							html.append(img);
						}else{console.log("图片为空/系统出现异常");}
					
					
					var str2 = c.sys_case_banner.split(",");
						if(typeof(str2[0]) != "undefined"&&str2[0] != null){
							var html=$("#img2-1").html("");
							var img="<img class='floatl view' src='${ctx }/"+str[0]+"/'/>";
							html.append(img);
							}else{console.log("图片为空/系统出现异常")}
						if(typeof(str2[1]) != "undefined"&&str2[1] != null){
							var html=$("#img2-2").html("");
							var img="<img class='floatl view' src='${ctx }/"+str[1]+"/'/>";
							html.append(img);
							}else{console.log("图片为空/系统出现异常");}
						if(typeof(str2[2]) != "undefined"&&str2[2] != null){
							var html=$("#img2-3").html("");
							var img="<img class='floatl view' src='${ctx }/"+str2[2]+"/'/>";
							html.append(img);
							}else{console.log("图片为空/系统出现异常");}
						
					
					var str3 = c.sys_demand_banner.split(",");
							if(typeof(str3[0]) != "undefined"&&str3[0] != null){
								var html=$("#img3-1").html("");
								var img="<img class='floatl view' src='${ctx }/"+str3[0]+"/'/>";
								html.append(img);
							}else{console.log("图片为空/系统出现异常");}
							if(typeof(str2[1]) != "undefined"&&str2[1] != null){
								var html=$("#img3-2").html("");
								var img="<img class='floatl view' src='${ctx }/"+str3[1]+"/'/>";
								html.append(img);
							}else{console.log("图片为空/系统出现异常");}
							if(typeof(str2[2]) != "undefined"&&str2[2] != null){
								var html=$("#img3-3").html("");
								var img="<img class='floatl view' src='${ctx }/"+str3[2]+"/'/>";
								html.append(img);
							}else{console.log("图片为空/系统出现异常");}
				
				},
				dataType:"json",
				error: function(msg){
					alert("哎呀网络开小差了，稍等会吧！");
					console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
				},
				async:false
			})
			
			
		})   */
			
			
</script>
	</body>
</html>