<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>业务员</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<div>
    <div class="systemHeader">
        <div><input type="button" value="业务员" class="wishHeaderInputClick"></div>
        <div><input type="button" value="添加管理员" class="wishHeaderInputClick add"></div>
    </div>
    <div class="systemOuter">
        <table class="systemTable">
            <tr class="systemTableTop">
                <th>序号</th>
                <th>姓名</th>
                <th>推荐码</th>
                <th>联系电话</th>
                <th>推荐详情</th>
                <th>操作(仅超级管理员可见)</th>
            </tr>
            <tr class="systemTableText">
                <td>1</td>
                <td>超级</td>
                <td>2225225411</td>
                <td>15254125222</td>
                <td><a href="salesmanDetail.html"><img src="../img/20180123162043.png"></a></td>
                <td>————</td>
            </tr>
            <tr class="systemTableText">
                <td>2</td>
                <td>超级</td>
                <td>2225225411</td>
                <td>15254125222</td>
                <td><a href="salesmanDetail.html"><img src="../img/20180123162043.png"></a></td>
                <td><input type="button" value="编辑" class="systemTableTrTextSure"></td>
            </tr>
            <tr class="systemTableText">
                <td>3</td>
                <td>超级</td>
                <td>2225225411</td>
                <td>15254125222</td>
                <td><a href="salesmanDetail.html"><img src="../img/20180123162043.png"></a></td>
                <td><input type="button" value="编辑" class="systemTableTrTextSure"></td>
            </tr>
        </table>
        <div class="wishFooter">
            <div class="wishFooterPage">
                <input type="button" value="上一页"/>
                <span>1111112345679</span>
                <input type="button" value="下一页"/>
            </div>
        </div>
    </div>
    <div class="findReferHui"></div>
    <div class="findReferTan">
        <div class="findReferTanTop">
            <div>添加业务员</div>
        </div>
        <div class="systemReferTanMid">
            <span class="systemReferTanMidSpan">业务员姓名</span>
            <input type="text" value="哈哈" class="systemReferTanMidInput">
        </div>
        <div class="systemReferTanMid">
            <span class="systemReferTanMidSpan">业务员电话</span>
            <input type="text" value="15454874512" class="systemReferTanMidInput">
        </div>
        <div class="systemReferTanMid">
            <span class="systemReferTanMidSpan">输入密码</span>
            <input type="text" value="12254785" class="systemReferTanMidInput">
        </div>
        <div class="systemReferTanMid">
            <span class="systemReferTanMidSpan">确认密码</span>
            <input type="text" value="12454674" class="systemReferTanMidInput">
        </div>
        <div class="systemReferTanMid">
            <span class="systemReferTanMidSpan">设置推荐码</span>
            <input type="text" value="12454674" class="systemReferTanMidInput">
        </div>
        <div class="systemReferTanBottom">
            <input type="button" value="确定" class="findReferTanBottomBtn1">
            <input type="button" value="取消" class="findReferTanBottomBtn2">
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
<script>
    $(".systemTableTrTextSure").each(function(){
        $(this).click(function(){
            $(".findReferHui,.findReferTan").css("display","block");
            $(".findReferTanTop div").html("编辑业务员");
        })
    });
    $(".findReferHui,.findReferTanBottomBtn2,.findReferTanTopClose,.findReferTanBottomBtn1").click(function(){
        $(".findReferHui,.findReferTan").css("display","none");
    })
    $(".add").click(function(){
        $(".findReferHui,.findReferTan").css("display","block");
        $(".findReferTanTop div").html("添加业务员");
    })
</script>

