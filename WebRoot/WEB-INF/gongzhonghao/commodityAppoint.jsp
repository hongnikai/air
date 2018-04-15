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
		<link href="css/mobiscroll_date.css" rel="stylesheet" />
		<title>预约上门时间</title>
	</head>
<form action="../commodity/createCommodityOrderGongZhongHao.do">
	<body>
		<header class="header">
	     <input name="c_id" type="text"  value="${commodity.c_id}" style="display: none;" /> 
		 <input name="a_id" type="text" value="${address.a_id}" style="display: none;"/> 
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>预约上门时间</center>
			<a class="timeSure"><input type="submit" value="确定"/></a>
		</header>
		<ul class="installList mT5">
			<li class="airType">
				<h3>选择日期</h3>
			<div class="userMD_divheader3">
            <span>请选择日期</span>
            <input type="date" class="time_js" name="time" required="required"/>
        </div> 
			</li>
			<li class="airType">
				<h3>选择时间段</h3><input id="time_stage" name="time_stage" type="text" value="0" style="display: none;"/>
				<center class="period">
					<span class="installAct" onclick="fun_time_stage(0)">全天</span>
					<span onclick="fun_time_stage(1)">上午</span>
					<span onclick="fun_time_stage(2)">下午</span>
				</center>
			</li>
		
			<script src="../js/jquery.js" type="text/javascript" charset="utf-8"></script>
			<script src="../js/mobiscroll_date.js" charset="gb2312"></script>
			<script src="../js/mobiscroll.js"></script>
			<!-- <script type="text/javascript">
				$(function() {
					var currYear = (new Date()).getFullYear();
					var opt = {};
					opt.date = {
						preset: 'date'
					};
					opt.datetime = {
						preset: 'datetime'
					};
					opt.time = {
						preset: 'time'
					};
					opt.default = {
						theme: 'android-ics light', //皮肤样式
						display: 'modal', //显示方式 
						mode: 'scroller', //日期选择模式
						dateFormat: 'yyyy-mm-dd',
						lang: 'zh',
						showNow: true,
						nowText: "今天",
						startYear: currYear - 50, //开始年份
						endYear: currYear + 10 //结束年份
					};

					$("#USER_AGE").mobiscroll($.extend(opt['date'], opt['default']));

				});

				var period = $(".period span.installAct").html();

				$('.installList li span').click(function() { /*选择时间段*/
					$(this).addClass('installAct').siblings().removeClass('installAct');
					return period = $(this).html();
				})

				$(".timeSure").click(function() { //点击确定
					var dateSeleted = $("#USER_AGE").val(); //获取时间
	  				window.location.href="installConfirmOrder.html?"+dateSeleted + "&" + period;
				})
			</script> -->
	</body>
</form>
</html>
<script type="text/javascript">
function fun_time_stage(data){
	$("#time_stage").val(data);
}
</script>