<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文章详情</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<div>
    <div class="findADetailTop">
        <a href="javaScript:history.back(-1);"><img src="../img/back.png"></a>
        <span>我的梦想</span>
        <span>文章详情</span>
        <a href="findEdit.html"><input type="button" value="编辑"></a>
    </div>
    <div class="findADetailContent">
        <h3>我的梦想</h3>
        <img src="../img/photo.png" class="findADetailContentImg">
        <div class="findADetailContentDiv">
            哈哈哈哈哈市附近啊就静静地捡的减点击点击点击点击点击点击点击点击大家都绝得觉得大姐夫就死额交的点击点击说肯德基都看得到看
        </div>
        <img src="../img/photo.png" class="findADetailContentImg">
        <div class="findADetailContentDiv">
            哈哈哈哈哈市附近啊就静静地捡的减点击点击点击点击点击点击点击点击大家都绝得觉得大姐夫就死额交的点击点击说肯德基都看得到看
        </div>
    </div>
</div>
</body>
</html>
