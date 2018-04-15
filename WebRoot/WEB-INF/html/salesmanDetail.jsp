<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>业务员推荐详情</title>
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<div class="salesmanD_top">
    <a href="javascript:history.back(-1);" title="">
        <img src="../img/back.png" alt="">   
        <span>哈哈哈哈</span> 
        <span>的推荐详情</span>  
    </a>
</div>
<div class="salesmanD_all">
    <div class="salesmanD_divcontent">
        <table>
            <tr>
                <th>序号</th>
                <th>推荐时间</th>
                <th>用户名</th>
                <th>联系电话</th>
                <th>性别</th>
                <th>阳光值余额(数)</th>
            </tr>
            <tr>
                <td>01</td>
                <td>2016.02.13 12:12:15</td>
                <td><img src="../img/tie.png">地瓜</td>
                <td>183xxxx6333</td>
                <td>男</td>
                <td>500000</td>
            </tr>
            <tr>
                <td>02</td>
                <td>2016.02.13 12:12:15</td>
                <td><img src="../img/tie.png">地瓜</td>
                <td>183xxxx6333</td>
                <td>男</td>
                <td>500000</td>
            </tr>
            <tr>
                <td>03</td>
                <td>2016.02.13 12:12:15</td>
                <td><img src="../img/tie.png">地瓜</td>
                <td>183xxxx6333</td>
                <td>男</td>
                <td>500000</td>
            </tr>
            <tr>
                <td>04</td>
                <td>2016.02.13 12:12:15</td>
                <td><img src="../img/tie.png">地瓜</td>
                <td>183xxxx6333</td>
                <td>男</td>
                <td>500000</td>            
            </tr>
            <tr>
                <td>05</td>
                <td>2016.02.13 12:12:15</td>
                <td><img src="../img/tie.png">地瓜</td>
                <td>183xxxx6333</td>
                <td>男</td>
                <td>500000</td>
            </tr>
        </table>
    </div>
    <div class="salesmanD_divfooter">
        <div class="salesmanD_page">
            <input type="button" value="上一页"/>
            <span>1111112345679</span>
            <input type="button" value="下一页"/>
        </div>
    </div>
</div>
</body>
</html>
