<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>合同管理</title>
		<link rel="stylesheet" type="text/css" href="${ctx }/css/style.css" />
		<script src="${ctx }/media/js/jquery/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${ctx }/media/js/bootstrap/js/bootstrap.min.js"></script>
		<script src="${ctx }/media/js/jquery-bootpag/jquery.bootpag.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="tab">
				<table>
					<tr>
						<th><input type="checkbox" class="check-all" /></th>
						<th></th>
						<th>合同编号</th>
						<th>甲方</th>
						<th>乙方</th>
						<th>质保金</th>
						<th>工期</th>
						<th>项目阶段</th>
					</tr>
					<c:forEach  items="${list}" var="data" varStatus="s">
					<tbody id="t_body">
						<td><input type="checkbox" /></td>
						<td>${s.index+1}</td>
						<td>${data.con_id}</td><!-- 合同编号 -->
						<td>${data.nickname1}</td><!-- 甲方 -->
						<td>${data.nickname2}</td><!-- 乙方 -->
						<td>${data.quality_guarantee_deposit}</td><!-- 质保金 -->
						<td>${data.need_time}</td><!-- 工期 -->
						<td onclick="fun1('${data.con_id}')">项目阶段</td>
					</tbody>
		</c:forEach>
				</table>
			</div>
			<footer>
				<div class="page" align="center">
				</div>
				<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
			</footer>
			<span class="page">
					<a href="${ctx }/wzd/Demand/findContract.action?pageNumber=${num}" class="next">next</a>
					<a class="now">${middle}</a>
					<a href="${ctx }/wzd/Demand/findContract.action?pageNumber=${min}" class="prev">prev</a>
			</span>
			<div class="Bomb_box" id="Bomb_box">
			<div class="model">
				<h2>项目阶段</h2>
				<ul>
					<h2>项目阶段1</h2>
					<li><span></span></li>
					<li><span>付款金额(元)</span></li>
					<li><span>开始日期</span></li>
					<li><span>结束日期</span></li>
				</ul>
				<ul>
					<h2>项目阶段2</h2>
					<li><span>项目内容</span></li>
					<li><span>付款金额(元)</span></li>
					<li><span>开始日期</span><input type="text" placeholder="输入开始日期" /></li>
					<li><span>结束日期</span><input type="text" placeholder="输入结束日期" /></li>
				</ul>
				<ul>
					<h2>项目阶段3</h2>
					<li><span>项目内容</span><input type="text" placeholder="输入项目内容" /></li>
					<li><span>付款金额(元)</span><input type="text" placeholder="输入付款金额" /></li>
					<li><span>开始日期</span><input type="text" placeholder="输入开始日期" /></li>
					<li><span>结束日期</span><input type="text" placeholder="输入结束日期" /></li>
				</ul>
			</div>
		</div>
		</div>
		
		
<script type="text/javascript">
		var c;//第一次回调数据
		var user_information;//查询用户信息的回调数据
		var serviceProviders_information;//服务商信息
		function fun1(message){//显示项目阶段 
		 $.ajax({
			url:"${ctx}/wzd/Demand/getContract.action",
			type:"post",
			data:{"conId":message},
			success:function(data){
				c=data.data;
				console.log(c);
			var html=$(".model").html("");
				for(var i=0;i<c[0].contractStageList.length;i++){
				 var ul="<button class='close' onclick='fun2()'>X</button>";
					ul+="<h2>项目阶段</h2>";
					ul+="<ul>";
					var j=(i+1);
					ul+="<h2>项目阶段:"+j+"</h2>";
					ul+="<li><span>项目内容:"+c[0].contractStageList[i].detail+"</span></li>";
					ul+="<li><span>付款金额(元):"+c[0].contractStageList[i].price+"</span></li>";
					ul+="<li><span>开始日期:"+c[0].contractStageList[i].startTime+"</span></li>";
					ul+="<li><span>结束日期:"+c[0].contractStageList[i].endTime+"</span></li>";
					ul+="<li><a href='${ctx}/wzd/Demand/contractCheck.action?consId="+c[0].contractStageList[i].consId+"' class='contractCheck'>发起验收</a></li>"
					ul+="</ul>";
					ul+="<button onclick='fun4'>";
					html.append(ul); 
				}			
			},
			dataType:"json",
			error: function(msg){
				alert("哎呀网络开小差了，稍等会吧！");
				console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
			},
			async:false
		}) 
			$(".Bomb_box").show();
    	}
		function fun2(){
			$(".Bomb_box").hide()//隐藏项目阶段
		}
		function fun3(){
			$(".Bomb_box").hide()//隐藏项目阶段
		}
			$(function(){
				/*  $.ajax({
					url:"${ctx}/wzd/Demand/findContractByAuId.action",
					type:"post",
					data:{"userId":${userId}},
					success:function(data){
						alert("成功");
						console.log(data);
						},
					dataType:"json",	
					error: function(msg){
						alert("哎呀网络开小差了，稍等会吧！");
						console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
					},
					async:false
				})  */
				
					/*  $.ajax({
						url:"${ctx}/wzd/Demand/findContract.action",
						type:"post",
						success:function(data){
							c=data.data;
							var html=$("#t_body").html("");
							for(var i=0;i<c.length;i++){
								var td="<tr>"
									td+="<td><input type='checkbox'/></td>";
									td+="<td>"+i+"</td>";
									td+="<td>"+c[i].conId+"</td>";
									$.ajax({
										url:"${ctx}/user/getById.action",
										type:"post",
										data:{"au_id":c[i].confirmId},
										success:function(data){
											user_information=data.data;
										},
										dataType:"json",
										error: function(msg){
											alert("哎呀网络开小差了，稍等会吧！");
											console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
										},
										async:false
									})
									td+="<td>"+user_information.nickname+"</td>";
									$.ajax({
											url:"${ctx}/user/getById.action",
											type:"post",
											data:{"au_id":c[i].serviceProvidersId},
											success:function(data){
												serviceProviders_information=data.data;
											},
											dataType:"json",
											error: function(msg){
												alert("哎呀网络开小差了，稍等会吧！");
												console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
											},
											async:false
									})
								    td+="<td>"+serviceProviders_information.nickname+"</td>"; 
								    td+="<td>"+c[i].totalPrice+"</td>";
								    var end_timestamp = Date.parse(new Date(c[i].endTime));
								    var start_timestamp = Date.parse(new Date(c[i].startTime));
								    var days=(end_timestamp-start_timestamp)/1000/60/60/24;
									if(end_timestamp > start_timestamp){
									if(days>0){td+="<td>"+days+"天"+"</td>";
									}else{td+="<td>"+"信息有误/或未添加时间信息"+"</td>";}
									}else{td+="<td>"+"信息有误/或未添加时间信息"+"</td>";}
									td+="<td onclick=\"fun1(\'"+c[i].conId+"\')\">项目阶段</td>";
								    td+="</tr>";
								    html.append(td);
							}
						},
						dataType:"json",
						error: function(msg){
							alert("哎呀网络开小差了，稍等会吧！");
							console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
						},
						async:false
					})  */
				})	
		</script>
	</body>
</html>