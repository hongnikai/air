<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>梦想秀管理</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
</head>
<body style="background-color: #f5f5f5;">
<div class="dreamM_all">
    <div class="dreamHeader">
        <div class="dreamHeaderdiv1"><input type="button" value="全部" class="wishHeaderInputClick"></div>
        <div class="dreamHeaderdiv2">
            <input type="button" value="搜索"/>
            <input type="text" placeholder="请输入搜索关键字"/>
        </div>
    </div>
    <div class="dreamTableOut">
        <table class="dreamTable">
            <tr class="dreamTableTrTop">
                <th>序号</th>
                <th>名称</th>
                <th>规格描述</th>
                <th>库存</th>
                <th>详情</th>
            </tr>
            <tr class="dreamTableTrText">
                <td>01</td>
                <td>我的梦想</td>
                <td>哈哈哈哈哈哈哈哈啊哈哈</td>
                <td>12111</td>
                <td><input type="button" value="编辑" class="dreamTableTrTextSure"><input type="button" value="删除" class="dreamTableTrTextNo"></td>
            </tr>
            <tr class="dreamTableTrText">
                <td>02</td>
                <td>空调</td>
                <td>哈哈哈哈哈哈哈哈啊哈哈</td>
                <td>12111</td>
                <td><input type="button" value="编辑" class="dreamTableTrTextSure"><input type="button" value="删除" class="dreamTableTrTextNo"></td>
            </tr>
            <tr class="dreamTableTrText">
                <td>03</td>
                <td>空调空调</td>
                <td>哈哈哈哈哈哈哈哈啊哈哈</td>
                <td>12111</td>
                <td><input type="button" value="编辑" class="dreamTableTrTextSure"><input type="button" value="删除" class="dreamTableTrTextNo"></td>
            </tr>
        </table>
        <input type="button" value="新建" class="dreamM_newbtn"/>
        <div class="dreamFooter">
            <div class="dreamFooterPage">
                <input type="button" value="上一页"/>
                <span>1111112345679</span>
                <input type="button" value="下一页"/>
            </div>
        </div>
    </div>

    <div class="dreamM_Hui"></div>
    <div class="dreamM_tan">
        <div class="dreamM_tanHead">新建/新建部件<img src="../img/close.png" class="dreamM_tanclosebtn"></div>
        <div class="dreamM_tancontent">
            <ul>
                <li><span>名称</span><input type="text"/></li>
                <li><span>规格描述</span><input type="text"/></li>
                <li><span>总数量</span><input type="text" class="dreamM_tancontentNumber"/><em>件</em></li>
            </ul>
            <input type="button" value="确认" class="dreamM_tancontentSurebtn"/>
        </div>
    </div>
</div>
</body>
</html>
<script>
    /*点关闭弹框消失*/
    $(".dreamM_tanclosebtn").click(function(){
        $('.dreamM_Hui').css('display','none');
        $('.dreamM_tan').css('display','none');
    });
    /*编辑出现弹框*/
    $('.dreamTableTrTextSure').click(function(){
        $('.dreamM_Hui').css('display','block');
        $('.dreamM_tan').css('display','block');
    });
    /*新建出现弹框*/
    $('.dreamM_newbtn').click(function(){
        $('.dreamM_Hui').css('display','block');
        $('.dreamM_tan').css('display','block');
    });
    /*删除*/
    $('.dreamTableTrTextNo').click(function(){
        $(this).parent().parent().remove();
    });
</script>
