<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>安装订单详情</title>
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/css.css">
    <script type="text/javascript" src="../js/laydate.dev.js"></script>
</head>
<body>
<div class="userMD_all">
    <div class="userMD_divheader">
       <div class="userMD_divheader_div1">
           <span></span>
           <span>安装订单详情${user.au_id}</span>
       </div>
      <div class="userMD_divheader3">
            <span>开始时间</span>
            <input type="date" class="time_js" />
            <span>结束时间</span>
            <input type="date" class="time_js" />
            <input type="hidden" name="" class="orderDo-start">
            <input type="hidden" name="" class="orderDo-end">
        </div> 
        
        <div>
        	 <div class="new_tab">
        	<a onclick="fun1()">商品订单</a>
        	<a  class="on" onclick="fun2()">安装订单</a>
        	<a onclick="fun3()">保养订单</a>
        	<a onclick="fun4()">维修订单</a>
        </div>
        </div>
       <!--  <div class="userMD_divheader2">
            <input type="button" onclick="sousuo()" value="搜索"/>
            <input id="key" type="text" placeholder="请输入搜索关键字"/>
        </div> -->
    </div>
    <div class="userMD_divcontent">
        <table class="userMD_Table">
            <tr class="userMD_TableTrTop">
                <th>序号</th>
                <th>订单号</th>
                <th>用户</th>
                <th>分类</th>
                <th>下单时间</th>
                <th>商品图片</th>
                <th>商品名称</th>
                <th>预定金</th>
                <th>总价格</th>
                <th>订单状态</th>
            </tr>
   <c:if test='${not empty "${install_list}"}'>
  			<c:forEach  items="${install_list}" var="data" varStatus="s">
            <tr class="userMD_TableTrText">
                <td>${s.index+1}</td> 
                <td>${data.install_id}</td> 
                <td><div class="userMD_TableTrTextUser"><img src="../../${data.headimg}" class="userMD_TableTrTextTou"><span class="userMD_TableTrTextName">${data.nickname}</span></div></td> 
                <td><span class="userMD_activespan2">安装</span></td>
                <td>${data.time}</td>
                <td><img src="../${data.cover_picture}" class="userMD_TableTrTextBack"></td>  
                <td>${data.brand}</td>
                <td>${data.deposit}</td>
                <td>${data.total_price}</td>
                <td><span class="uesrMD_TrTextState">
                <c:if test="${data.order_state==0}">未支付</c:if>
               	<c:if test="${data.order_state==1}">已支付</c:if>
               	<c:if test="${data.order_state==2}">待收货</c:if> 
               	<c:if test="${data.order_state==3}">已收货</c:if> 
               	<c:if test="${data.order_state==4}">安装中</c:if>
               	<c:if test="${data.order_state==5}">保养中</c:if>
               	<c:if test="${data.order_state==6}">维修中</c:if>
               	<c:if test="${data.order_state==7}">已评价</c:if>  
               	<c:if test="${data.order_state==8}">预生成订单</c:if>  
                </span></td>
            </tr> 
            	</c:forEach>
    </c:if>	
            
        </table>
    </div>
      <c:if test='${not empty "${install_list}"}'>
     	<div class="userMD_divfooter">
	        <div class="userMD_page">
	            <a href="targetUserMangementDetailInstall.do?au_id=${install_list[0].au_id}&pageNumber=${min}"><input type="button" value="上一页" /></a><!-- ../backageController/ -->
	            <span>当前第${middle}页,共${page}页</span>
	            <a href="../backageController/targetUserMangementDetailInstall.do?au_id=${install_list[0].au_id}&pageNumber=${num}"><input type="button" value="下一页"/></a>
	        </div>
   		</div>
      </c:if>	
</div>
</body>
</html>
 <script type="text/javascript">
	function fun1(){
		window.location.href="../backageController/targetUserMangementDetail.do?au_id=${sessionScope.buyerId}";
	}
	function fun2(){
		window.location.href="../backageController/targetUserMangementDetailInstall.do?au_id=${sessionScope.buyerId}";
	}
	function fun3(){
		window.location.href="../backageController/targetUserMangementDetailMaintian.do?au_id=${sessionScope.buyerId}";
	}
	function fun4(){
		window.location.href="../backageController/targetUserMangementDetailRepair.do?au_id=${sessionScope.buyerId}";
	}
	function sousuo(){
		var key=$("#key").val();
		window.location.href="../backageController/selectInstallOrderVague.do?keyword="+key;
	}
	
</script>
<script>

    $(".uesrMD_TrTextState").each(function(){
        var content = $(this).html();
        if(content=='未完成'){
            $(this).css("color","#2abbb4");
        }else if(content=='已完成'){
            $(this).css("color","#333");
        }
    });
$('.userMD_divheader_ul1 li').eq(0).addClass("userMD_active");
    $('.userMD_divheader_ul1 li').click(function(){
        $(this).addClass("userMD_active").siblings().removeClass("userMD_active");
        var selcet=$(this).find('input[type=hidden]').val();
    })

</script>
<script>
    // JavaScript Document  时间选择
    var start = {
        elem: '#start',
        format: 'YYYY-MM-DD',
        min: laydate.now(), //设定最小日期为当前日期
        max: '2099-06-16', //最大日期
        istime: true,
        istoday: false,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#end',
        format: 'YYYY-MM-DD',
        min: laydate.now(),
        max: '2099-06-16',
        istime: true,
        istoday: false,
        choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);
</script>
