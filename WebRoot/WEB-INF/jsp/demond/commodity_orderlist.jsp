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
		<title>需求审核</title>
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
						<th>登录账号</th>
						<th>头像</th>
						<th>昵称</th>
						<th>预备期限</th>
						<th>装修类型</th>
						<th>建筑现状</th>
						<th>装修面积</th>
						<th>标题</th>
						<th>需求类型</th>
						<th>装修工期</th>
						<th>需求详情</th>
						<th>预算</th>
						<th>所在区域</th>
						<th>图片</th>
						<th>需求状态</th>
					</tr>
					<c:forEach  items="${list}" var="data" varStatus="s">
					<tbody id="t_body">
				    <td><input type="checkbox" /></td>
						<td>${s.index+1}</td>
						<td>${data.username}</td> 			<!-- 登录账号 -->
						<td><img src="${picturePath}/${data.picture_url}" alt="头像" class="headPortrait"/></td>
						<td>${data.nickname}</td><!-- 昵称 -->
						<td>${data.need_days}天</td><!-- 预备期限 -->
						<td>${data.mission_type}</td><!-- 装修类型 -->
						<td>${data.construction_status_quo}</td><!-- 建筑现状 -->
						<td>${data.building_area}</td>	
						<td>${data.title}</td>
						<td>${data.d_type}</td>
						<td>${data.need_days}天</td>
						<td><span class="needDetail" onclick="show_Bomb_box()">需求详情</span></td>
						<td>${data.offer}</td>
						<td>${data.address}</td>
						<td><span class="picture" onclick="show_Bomb_box2()">图片</span></td>
						<td><button onclick="update_demand_state_pass()">通过</button>
						    <button onclick="update_demand_state_refuse()">拒绝</button></td>
						</div> 
					</tbody>
					<div class="Bomb_box" >
							<div class="model" id="model1">
							<button class="close" onclick="hide_Bomb_box()">X</button>
							<h2>需求详情</h2>
							<h1>${data.demand_details}<h1>
							</div>
					</div>		
					<div class="Bomb_box2">
						<div class="model" id="model2">
							<button class="close" onclick="hide_Bomb_box2()">X</button>
							<h2>图片</h2>
							<div>
								<img src="${picturePath}/${data.photos}"/>
							</div>
						</div>
					</div>	
					<script type="text/javascript">
						var a="${data.d_id}";
					
					</script>
					
					
					</c:forEach>
				</table>
			</div>
			<footer>
				<div class="btnlist">
					<input class="delete" type="button" value="删除" style="display: none;"/>
				</div>
				<span class="page">
					<a href="${ctx }/wzd/Demand/getAllDemondList.action?pageNumber=${num}" class="next">next</a>
					<a class="now">${middle}</a>
					<a href="${ctx }/wzd/Demand/getAllDemondList.action?pageNumber=${min}" class="prev">prev</a>
				</span>
			</footer>
		</div>
		
		
	</body>
</html>
<script type="text/javascript">
		var c; //回传数组
		function show_Bomb_box(){
			$(".Bomb_box").show();
		}
		function hide_Bomb_box(){
			$(".Bomb_box").hide();
		}
		function show_Bomb_box2(){
			$(".Bomb_box2").show();
		}
		function hide_Bomb_box2(){
			$(".Bomb_box2").hide();
		}
		function update_demand_state_pass(message){
			alert("确认通过吗"+message);
			$.ajax({
				url:"${ctx}/wzd/Demand/updateDemandState.action",
				type:"post",
				data:{"d_id":message,"state":"通过"},
				success:function(data){
							alert("修改成功");
							alert(data);
							$("#td_state").html("已通过");
					},
				dataType:"json",
				error: function(msg){
					alert("哎呀网络开小差了，稍等会吧！");
					console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
				},
				async:false
		})
		}
		function update_demand_state_refuse(message){
			alert("确认拒绝吗？"+message);
			$.ajax({
				url:"${ctx}/wzd/Demand/updateDemandState.action",
				type:"post",
				data:{"d_id":message,"state":"拒绝"},
				success:function(data){
							alert("修改成功");
							alert(data);
							$("#td_state").html("已拒绝");
					},
				dataType:"json",
				error: function(msg){
					alert("哎呀网络开小差了，稍等会吧！");
					console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
				},
				async:false
		})
			
		}
		
		 	/* $(".check-all").click(function() {
				if(this.checked) {
					$(":checkbox").prop("checked", true);
				} else {
					$(":checkbox").prop("checked", false);
				}
			}) */
			/* $(".picture").live("click",function(){
				$(".Bomb_box2").show();
			})
			$(".model .delete,.model .close").click(function(){
				$(".Bomb_box2").hide();
			})  */
			
			/* $(function(){
				$.ajax({
					url:"${ctx}/wzd/Demand/getDemandList.action",
					type:"post",
					success:function(data){
						var html=$("#t_body").html("");
						var div_model1=$("#model1").html("");
						var div_model2=$("#model2").html("");
						c=data.data;
						console.log(c);
						for(var i=0;i<c.length;i++){
							var td="<tr>"
								td+="<td><input type='checkbox'/></td>";
								td+="<td>"+i+"</td>"
								td+="<td>"+c[i].creator.username+"</td>";			//登录账号
								td+="<td><img src="+c[i].creator.picture_url+" alt='头像' class='headPortrait'/></td>"//头像
								td+="<td>"+c[i].creator.nickname+"</td>";
							    td+="<td>"+c[i].needDays+"</td>";//预备期限
							    td+="<td>"+c[i].missionType+"</td>";//装修类型 0家装1工装
								td+="<td>"+c[i].constructionStatusQuo+"</td>";//建筑现状 
								td+="<td>"+c[i].buildingArea+"</td>";//装修面积
								td+="<td>"+c[i].title+"</td>";//标题
								td+="<td>"+c[i].dType+"</td>";//需求类型, 0设计服务\1施工服务\2监理服务\3装修材料服务 如有多个选择逗号拼接
								td+="<td>"+c[i].needDays+"</td>";
								td+="<td><span class='needDetail' onclick='show_Bomb_box()'>需求详情</span></td>";//需求详情
								td+="<td>"+c[i].offer+"</td>";//预算
								td+="<td>"+c[i].address+"</td>";//所在区域
								td+="<td><span class='picture' onclick='show_Bomb_box2()'>图片</span></td>";
								td+="<td id='td_state'><button class='myButton' onclick=\"update_demand_state_pass(\'"+c[i].dId+"\')\">通过</button><button class='myButton' onclick=\"update_demand_state_refuse(\'"+c[i].dId+"\')\">拒绝</button></td>";//需求状态, -1已过期1进行中2已完结
								td+="</tr>"
								html.append(td);
									
								var	div_model="<button class='close' onclick='hide_Bomb_box()''>X</button>";
									div_model+="<h2>需求详情</h2>";
								    div_model+="<div>"+c[i].demandDetails+"</div>";
									
								div_model1.html(div_model);
								
							        div_model="<button class='close' onclick='hide_Bomb_box2()'>X</button>";
							        div_model+="<h2>图片</h2>";
							        var strs=new Array();
									strs=c[i].photos.split(",");
									div_model+="<div>";
									for(var j=0;j<strs.length;j++){
										div_model+="<img scr='+strs[j]+' alt='图片加载失败' />";//图片
									}
									div_model+="</div>";
								div_model2.html(div_model);    
						}
					},
					dataType:"json",
					error: function(msg){
						alert("哎呀网络开小差了，稍等会吧！");
						console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
					},
					async:false
				})
			}) */
	
		</script> 