<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/css.css">
    <script type="text/javascript" src="../js/laydate.dev.js"></script>
</head>
<body style="background-color: #f5f5f5;">
<div class="orderM_all">
    <div class="orderM_divheader">
        <div class="orderM_divheader_div1">
            <input type="button" value="公司订单"/>
            <input type="button" value="订单列表"/>
        </div>
        <div class="orderM_divheader3">
            <span>开始时间</span>
            <h3 class="laydate-icon" id="start"></h3>
            <span>结束时间</span>
            <h3 class="laydate-icon" id="end"/></h3>
            <input type="hidden" name="" class="orderDo-start">
            <input type="hidden" name="" class="orderDo-end">
        </div>
        <div class="orderM_divheader2">
            <input type="button" value="搜索"/>
            <input type="text" placeholder="请输入搜索关键字"/>
        </div>
    </div>
    <div class="orderM_divcontent">
        <table class="orderM_Table">
            <tr class="orderM_TableTrTop">
                <th>序号</th>
                <th>订单号</th>
                <th>服务项目</th>
                <th>下单时间</th>
                <th>公司名称</th>
                <th>联系电话</th>
                <th>企业注册号</th>
                <th>营业执照</th>
                <th>合同照片</th>
                <th>状态</th>
            </tr>
            <tr class="orderM_TableTrText">
                <td>1</td>
                <td>123333333333</td>
                <td>空调空调空调</td>
                <td>2016.12.15 12:15:12</td>
                <td>山水公司</td>
                <td>13000000000</td>
                <td>123333333333</td>
                <td><img src="../img/photo.png"/></td>
                <td><img src="../img/photo.png"/></td>
                <td><input type="button" value="未完成"/><input type="button" value="已完成"/></td>
            </tr>
            <tr class="orderM_TableTrText">
                <td>1</td>
                <td>123333333333</td>
                <td>空调空调空调</td>
                <td>2016.12.15 12:15:12</td>
                <td>山水公司</td>
                <td>13000000000</td>
                <td>123333333333</td>
                <td><img src="../img/photo.png"/></td>
                <td><img src="../img/photo.png"/></td>
                <td><input type="button" value="未完成"/><input type="button" value="已完成"/></td>
            </tr>
        </table>

    </div>
    <div class="orderM_divfooter">
        <input type="button" value="新建" class="orderM_newbtn">
        <div class="orderM_page">
            <input type="button" value="上一页"/>
            <span>1111112345679</span>
            <input type="button" value="下一页"/>
        </div>
    </div>
</div>
</body>
</html>
<script>
    /*公司订单和订单列表的颜色切换*/
    $('.orderM_divheader_div1 input').eq(0).addClass('orderM_active');
    $('.orderM_divheader_div1 input').click(function () {
        $(this).addClass('orderM_active').siblings().removeClass('orderM_active');
    });

    /*订单状态未完成已完成的选择*/
    $('.orderM_Table tr td:last-child input').eq(0).addClass("orderM_Table_btnactive");
    $('.orderM_Table tr td:last-child input').click(function () {
        $(this).addClass('orderM_Table_btnactive').siblings().removeClass('orderM_Table_btnactive');
    });
/*点击新建跳转页面*/
$('.orderM_newbtn').click(function(){
    window.location.href='orderCatalogue.html';
    });
/*点击订单列表跳转*/
    $('.orderM_divheader_div1 input').eq(1).click(function(){
        window.location.href='caiManagement.html';
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
