<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>已发布</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
</head>
<body style="background-color: #f5f5f5;">
<div class="findHeader">
    <a class="findLink" href="findManagement.html"><div><input type="button" value="草稿箱"></div></a>
    <a class="findLink" href="findSend.html"><div><input type="button" value="已发布" class="findHeaderInputClick"></div></a>
    <a class="findLink" href="findNew.html"><div><input type="button" value="新建文章"></div></a>
    <a class="findLink" href="findReference.html"><div><input type="button" value="推荐用户"></div></a>
</div>
<div class="findTableOut">
    <table class="findTable">
        <tr class="findTableTrTop">
            <th>序号</th>
            <th>标题</th>
            <th>封面</th>
            <th>更新时间</th>
            <th>内容</th>
            <th>点赞数</th>
            <th>详情</th>
            <th>操作</th>
        </tr>
        <tr class="findTableTrText">
            <td>1</td>
            <td>我的梦想</td>
            <td><img src="../img/photo.png" class="findTableTrTextBack"></td>
            <td>2016.12.15<br>12:15:12</td>
            <td>我是一个天才，哈哈哈哈</td>
            <td>1222</td>
            <td><a href="findArticleDetail.html"><img src="../img/20180123162043.png"></a></td>
            <td><input type="button" value="删除" class="findTableTrTextDelSend"></td>
        </tr>
        <tr class="findTableTrText">
            <td>2</td>
            <td>我的梦想</td>
            <td><img src="../img/photo.png" class="findTableTrTextBack"></td>
            <td>2016.12.15<br>12:15:12</td>
            <td>我是一个天才，哈哈哈哈</td>
            <td>1333</td>
            <td><a href="findArticleDetail.html"><img src="../img/20180123162043.png"></a></td>
            <td><input type="button" value="删除" class="findTableTrTextDelSend"></td>
        </tr>
        <tr class="findTableTrText">
            <td>3</td>
            <td>我的梦想</td>
            <td><img src="../img/photo.png" class="findTableTrTextBack"></td>
            <td>2016.12.15<br>12:15:12</td>
            <td>我是一个天才，哈哈哈哈</td>
            <td>1444</td>
            <td><a href="findArticleDetail.html"><img src="../img/20180123162043.png"></a></td>
            <td><input type="button" value="删除" class="findTableTrTextDelSend"></td>
        </tr>
    </table>
    <div class="findFooter">
        <div class="findFooterPage">
            <input type="button" value="上一页"/>
            <span>1111112345679</span>
            <input type="button" value="下一页"/>
        </div>
    </div>
</div>
</body>
</html>

