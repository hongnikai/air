<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>礼物设置</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<div>
    <div class="systemHeader">
        <div><input type="button" value="礼物设置" class="wishHeaderInputClick"></div>
        <div><input type="button" value="添加礼物数" class="wishHeaderInputClick add"></div>
    </div>
    <div class="gift">
        <div class="gifTop">
            平台礼物数
        </div>
        <div class="giftText">
            <div>
                <span>平台礼物数总额(缕)</span>
                <span>50000000</span>
            </div>
            <div>
                <span>礼物数充值总额(缕)</span>
                <span>50000000</span>
            </div>
            <div>
                <span>已发现提现总额(缕)</span>
                <span>50000000</span>
            </div>
            <div>
                <span>剩余礼物数总额(缕)</span>
                <span>50000000</span>
            </div>
        </div>
    </div>
    <div class="findReferHui"></div>
    <div class="giftTan">
        <div class="giftTanTop">
            <div>添加礼物数</div>
            <img src="../img/close.png" alt="" class="giftTanTopImg">
        </div>
        <div class="giftTanMid">
            <input type="text" name="" placeholder="请填写礼物数">
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
    $(".findReferHui,.findReferTanBottomBtn2,.findReferTanTopClose,.findReferTanBottomBtn1,.giftTanTopImg").click(function(){
        $(".findReferHui,.giftTan").css("display","none");
    })
    $(".add").click(function(){
        $(".findReferHui,.giftTan").css("display","block");
    })
</script>

