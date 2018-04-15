<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>404</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
</head>
<body>
<div class="findADetailTop">
    <a href="javaScript:history.back(-1);"><img src="../img/back.png">
    <span>返回上一页</span></a>
</div>
<div class="error">
	<a href="javascript:history.back(-1);" title=""><img src="../img/016cc459081056a8012145502621c1.jpg" alt=""></a>
</div>
</body>
</html>

