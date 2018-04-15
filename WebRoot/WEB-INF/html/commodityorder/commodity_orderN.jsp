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
    <title>菜宝赏管理</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="../js/laydate.dev.js"></script>
</head>
<body style="background-color: #f5f5f5;">
<div class="caiM_all">
    <div class="caiM_divheader">
        <div class="caiM_divheader_div1">
            <input type="button" onclick="fun1()" value="全部"/>
            <input type="button" value="未完成"/>
            <input type="button" onclick="fun2()" value="已完成"/>
        </div>
      <!--   <div class="caiM_divheader3">
            <span>开始时间</span>
            <h3 class="laydate-icon" id="start"></h3>
            <span>结束时间</span>
            <h3 class="laydate-icon" id="end"/></h3>
            <input type="hidden" name="" class="orderDo-start">
            <input type="hidden" name="" class="orderDo-end">
        </div> -->
        <div class="caiM_divheader2">
            <input onclick="sousuo()" type="button" value="搜索"/>
            <input id="key" type="text" placeholder="请输入搜索关键字"/>
        </div>
    </div>
    <!--全部，进行中，已结束的table-->
    <div class="caiM_TableOut">
        <table class="caiM_Table">
            <tr class="caiM_TableTrTop">
                <th>序号</th>
                <th>订单号</th>
                <th>用户</th>
                <th>分类</th>
                <th>下单时间</th>
                <th>商品图片</th>
                <th>商品名称</th>
                <th>预定金</th>
                <th>总价格</th>
                <th>状态</th>
            </tr>
           <c:if test='${not empty "${list}"}'>
  			<c:forEach  items="${list}" var="data" varStatus="s"> 
            <tr class="caiM_TableTrText">
                <td>${s.index+1}</td>
                <td>${data.com_id}</td> 
                <td><div class="caiM_TableTrTextUser"><img src="${data.headimg}" class="caiM_TableTrTextTou"><span class="caiM_TableTrTextName">${data.nickname}</span></div></td>
                <td><span class="caiM_Table_span1">商城</span></td>
                <td>${data.create_time}</td>
                <td><img src="${data.cover_picture}" class="caiM_TableTrTextBack"></td>
                <td>${data.c_name}</td>
                <td>${data.deposit}</td>
                <td>${data.total_price}</td>
                <c:if test="${data.order_state==0}">
                <td><input type="button" value="待审核" class="caiM_TableTrTextSure"></td>
                </c:if>
                <c:if test="${data.order_state==1}">
                <td><input type="button" value="未通过" class="caiM_TableTrTextSure"></td>
                </c:if>
                <c:if test="${data.order_state==2}">
                <td><input type="button" value="已通过" class="caiM_TableTrTextSure"></td>
                </c:if>
            </tr>
            </c:forEach>
            </c:if>
        </table>
         <c:if test='${not empty "${list}"}'>
        <div class="caiM_Footer">
            <div class="caiM_FooterPage">
                <a href="../backageController/commodity_orderN.do?pageNumber=${min}"><input type="button" value="上一页"/></a>
                <span>当前第${middle}页,共${page}页</span>
                <a href="../backageController/commodity_orderN.do?pageNumber=${num}"><input type="button" value="下一页"/></a>
            </div>
        </div>
        </c:if>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
function fun1(){
	window.location.href="../backageController/caiManagement.do";
}
function fun2(){
	window.location.href="../backageController/commodity_orderY.do";
}
function sousuo(){
	var key=$("#key").val();
	window.location.href="../backageController/getOrderVagueResult.do?keyword="+key;	
}
</script>
<script>
    /*订单列表全部未完成已完成的颜色切换*/
    $('.caiM_divheader_div1 input').eq(0).addClass('caiM_active');
    $('.caiM_divheader_div1 input').click(function () {
        $(this).addClass('caiM_active').siblings().removeClass('caiM_active');
    });
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


