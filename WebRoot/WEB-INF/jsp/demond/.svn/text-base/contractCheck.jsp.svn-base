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
		<title></title>
		<link rel="stylesheet" type="text/css" href="${ctx }/css/style.css" />
		<script src="${ctx }/media/js/jquery/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${ctx }/media/js/bootstrap/js/bootstrap.min.js"></script>
		<script src="${ctx }/media/js/jquery-bootpag/jquery.bootpag.js"></script>
	</head>
	<body>
		<div class="container commodityEdit">
			<a class="editCommodity" style="float: right;" href="${ctx}/wzd/Demand/contractManage.action">返回</a>
			<div>
				<h2 class="greenFont">${map.title}</h2>
				<a style="display: none;" id="a_consid">${map.cons_id}</a>
				<ul>
					<li><span>项目内容</span><span>${map.detail}</span></li>
					<li><span>付款金额(元)</span><span>${map.price}</span></li>
					<li><span>开始日期</span><span>${map.start_time}</span></li>
					<li><span>结束日期</span><span>${map.end_time}</span></li>
				</ul>
			</div>
			<div>
				<h2 class="greenFont">上传验收资料</h2>
				<textarea id="text"></textarea>
				<p><input type="button" value="保存" class="save" onclick="fun1()"/></p>
			</div>
			<div>
				<h2 class="greenFont">上传图片</h2>
				<form action="${ctx}/wzd/Demand/uploadStageImags.action" method="post" enctype="multipart/form-data">
				<div class="editUpload">
					<div class="upload">
						<button class="removeBtn" onclick="javascript:removePic(this)"></button>
						<input type="text" name="consId" value="${map.cons_id}" style="display: none;"/>
						<img class="" src="../../img/addPic.png"/>
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
					<div class="upload">
						<button class="removeBtn" onclick="javascript:removePic(this)"></button>
						<img class="" src="../../img/addPic.png" />
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
					<div class="upload">
						<button class="removeBtn" onclick="javascript:removePic(this)"></button>
						<img class="" src="../../img/addPic.png" />
						<input type="file" id="upfile" onchange="upLoadPic(this)" name="file"/>
					</div>
				</div>
				<p><input type="submit" value="保存" class="save"/></p>
				</form>
			</div>
			<div>
				<form action="${ctx}/wzd/Demand/uploadFile.action" method="post" enctype="multipart/form-data" id="fileform">
				<h2 class="greenFont">上传表格附件</h2>
				<input type="text" name="consid" value="${map.cons_id}" style="display: none;"/>
				<input type="file" accept="" name="file"/>        
				<p><input type="submit" value="保存" class="save" /></p >
				</form>
			</div>
		</div>
<script type="text/javascript">
var consId;//合同阶段Id
var text;//上传资料文字
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
			function removePic(e) {
				$(e).parent().parent().append("<div class='upload'>" +
					"<button class='removeBtn' onclick='javascript:removeImg(this)'></button>" +
					"<img src='img/addPic.png' />" +
					"<input type='file' id='upfile' onchange='upLoadPic(this)' /></div>")
				$(e).parent().remove();
			}
			function fun1(){
				 consId=$("#a_consid").text();
				 text =$("#text").val();
				$.ajax({
					url:"${ctx}/wzd/Demand/materialInformation.action",
					type:"post",
					data:{"text":text,"consId":consId},
					success:function(data){
						alert("成功上传资料");
						alert(data);
					},
					//dataType:"json",
					error: function(msg){
						alert("哎呀网络开小差了，稍等会吧！");
						console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
					},
					async:false
				});
			}
</script>
	</body>

</html>