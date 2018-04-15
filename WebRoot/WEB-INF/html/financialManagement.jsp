<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>财务管理</title>
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/css.css">
    <script type="text/javascript" src="../js/laydate.dev.js"></script>
</head>
<body>
<div class="financiaM_all">
    <div class="financiaM_divheader">
        <div class="financiaM_divheader1">
            <input type="button" value="充值"/>
            <input type="button" value="提现"/>
        </div>
        <div class="financiaM_divheader2">
            <input type="button" value="搜索"/>
            <input type="text" placeholder="请输入搜索关键字"/>
        </div>
        <div class="financiaM_divheader3">
            <span>开始时间</span>
            <h3 class="laydate-icon" id="start"></h3>
            <span>结束时间</span>
            <h3 class="laydate-icon" id="end"/></h3>
            <input type="hidden" name="" class="orderDo-start">
            <input type="hidden" name="" class="orderDo-end">
        </div>
    </div>
    <div class="financiaM_divcontent">
        <table>
            <tr>
                <th>序号</th>
                <th>用户名</th>
                <th>操作时间</th>
                <th>金额(元)</th>
                <th>佣金比例</th>
                <th>阳光值(缕)</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <tr>
                <td><input type="checkbox" name="">01</td>
                <td><img src="../img/tie.png">地瓜</td>
                <td>2016.12.15  12:15:12</td>
                <td>500</td>
                <td>50%</td>
                <td>45</td>
                <td>未通过</td>
                <td><input type="button" value="通过" class="financiaM_TableTrTextSure"><input type="button" value="驳回" class="financiaM_TableTrTextNo"></td>
            </tr>
            <tr>
                <td><input type="checkbox" name="">02</td>
                <td><img src="../img/tie.png">地瓜</td>
                <td>2016.12.15  12:15:12</td>
                <td>500</td>
                <td>50%</td>
                <td>45</td>
                <td>已通过</td>
                <td><input type="button" value="通过" class="financiaM_TableTrTextSure"><input type="button" value="驳回" class="financiaM_TableTrTextNo"></td>
            </tr>
            <tr>
                <td><input type="checkbox" name="">03</td>
                <td><img src="../img/tie.png">地瓜</td>
                <td>2016.12.15  12:15:12</td>
                <td>500</td>
                <td>50%</td>
                <td>45</td>
                <td>未通过</td>
                <td><input type="button" value="通过" class="financiaM_TableTrTextSure"><input type="button" value="驳回" class="financiaM_TableTrTextNo"></td>
            </tr>
            <tr>
                <td><input type="checkbox" name="">04</td>
                <td><img src="../img/tie.png">地瓜</td>
                <td>2016.12.15  12:15:12</td>
                <td>500</td>
                <td>50%</td>
                <td>45</td>
                <td>未通过</td>
                <td><input type="button" value="通过" class="financiaM_TableTrTextSure"><input type="button" value="驳回" class="financiaM_TableTrTextNo"></td>
            </tr>
            <tr>
                <td><input type="checkbox" name="">05</td>
                <td><img src="../img/tie.png">地瓜</td>
                <td>2016.12.15  12:15:12</td>
                <td>500</td>
                <td>50%</td>
                <td>45</td>
                <td>未通过</td>
                <td><input type="button" value="通过" class="financiaM_TableTrTextSure"><input type="button" value="驳回" class="financiaM_TableTrTextNo"></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>  <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>  <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>  <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </div>
    <div class="financiaM_divfooter">
        <div class="financiaM_detele"><input type="button" value="删除"/></div>
        <div class="financiaM_page">
            <input type="button" value="上一页"/>
            <span>1111112345679</span>
            <input type="button" value="下一页"/>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $('.financiaM_divheader1 input').eq(0).addClass("financiaM_active");
    $('.financiaM_divheader1 input').click(function(){
        $(this).addClass("financiaM_active").siblings().removeClass('financiaM_active');
    });
    $('.financiaM_divcontent table tr td:nth-child(6)').addClass("financiaM_color");
    $('.financiaM_divheader1 input').eq(0).click(function(){
        $('.financiaM_divcontent table tr td:nth-child(4)').removeClass("financiaM_color");
        $('.financiaM_divcontent table tr td:nth-child(6)').addClass("financiaM_color");
    });
    $('.financiaM_divheader1 input').eq(1).click(function(){
        $('.financiaM_divcontent table tr td:nth-child(4)').addClass("financiaM_color");
        $('.financiaM_divcontent table tr td:nth-child(6)').removeClass("financiaM_color");
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
