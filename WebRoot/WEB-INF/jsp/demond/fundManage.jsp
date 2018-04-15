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
		<title>资金管理</title>
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
						<th><input type="checkbox" class="check-all"/></th>
						<th></th>
						<th>变动时间</th>
						<th>类型</th>
						<th>金额</th>
						<th>变动来源</th>
						<th>资金去向</th>
						<th>余额</th>
					</tr>
					<tbody id="t_body">
						<td><input type="checkbox" /></td>
						<td>1</td>
						<td>2017年12月21日</td>
						<td>支出</td>
						<td>12345</td>
						<td>2017年12月21日</td>
						<td>sldkjflsjd</td>
						<td>132</td>
					</tbody>
				</table>
			</div>
			<footer >
				<div class="btnlist">
				<!-- 	<input class="delete" type="button" value="删除" /> -->
				</div>
				<span class="page">
				</span>
			</footer>
		</div>
	</body>
</html>
<script type="text/javascript">
var money=0;//订单金额
var i;
var userbalance;//用户账户余额
			$(".check-all").click(function(){
				if(this.checked){
					$(":checkbox").prop("checked",true);
				}else{
					$(":checkbox").prop("checked",false);
				}
			})
			$(function(){
				$.ajax({
					url:"${ctx}/lc/capital/commodityOrderController/findUserBalance.action",
					type:"post",
					data:{"au_id":${userId}},
					success:function(data){
						userbalance=data;
				$.ajax({
					url:"${ctx}/lc/capital/commodityOrderController/findAllBycId.action",
					type:"post",
					data:{"c_id":${userId}},
					success:function(data){
						console.log(data)
						var html=$("#t_body").html("");
						for(i=0;i<data.length;i++){
								var td;
							 if(data[i].order_state>0){
								 console.log(i+"***********8")
								 money=(money+data[i].total_price);
									td="<tr>";
									td+="<td><input type='checkbox' /></td>";
									td+="<td>"+i+"</td>";
									var tt=new Date(data[i].create_time).toLocaleString().replace(/\//g, "-"); 
									td+="<td>"+tt+"</td>";
									td+="<td>支出</td>";
									td+="<td>"+money+"</td>";
									td+="<td>购买商品</td>";
									td+="<td>购买商品</td>";
									td+="<td>"+userbalance+"</td>";
									td+="</tr>";
									html.append(td); 
							 } 
							 
						}
						console.log(money);
					},
					dataType:"json",
					error: function(msg){
						alert("哎呀网络开小差了，稍等会吧！");
						console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
					},
					async:false
				});
			},
					dataType:"json",
					error: function(msg){
						alert("哎呀网络开小差了，稍等会吧！");
						console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
					},
					async:false
				})
				
			})
			
</script>