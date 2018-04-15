<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
</head>
<body  style="position: relative; height: 100%; min-width:1300px">
<div class="header">
    <div class="headerLeft">
        <span>空调金管家</span>
        <span>后台管理系统</span>
    </div>
    <div class="headerRight">
        <div class="headerRightName">
            <img src="../img/img/img10.png">
            <span>管理员</span>
        </div>
        <div class="headerRightOut">
            <a href="../system/loginOut.do"><img src="../img/img/20180123162015.png">
            <span>退出系统</span></a>
        </div>
    </div>
</div>
<div class="containerAll">
    <!--iframe_box-->
    <div id="iframe_box" class="Hui-articleALL">
        <div class="show_iframeALL">
            <div style="display:none" class="loading"></div>
            <iframe scrolling="auto" frameborder="0" src="../targetBackstage/indexInner.do" id="iframe" width="100%; height=100%;"></iframe>
        </div>
    </div>
</div>
</body>
</html>
