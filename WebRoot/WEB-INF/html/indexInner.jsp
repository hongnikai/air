<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>账户管理</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
</head>
<body style="position: relative; height: 100%; min-width:1300px">
<div class="navwrap">
    <div class="floatl nav">
        <div class="admin2">
            <div class="admin2Div">
                <span class="admin2DivSpan1">WELCOME！</span>
                <span class="admin2DivSpan2" id="show_time0"></span>
                <script>  
				 setInterval("show_time0.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);    
				</script> 
                
            </div>
        </div>
        <div class="nav_menu">
            <a class="link active" href="javascript:void(0)" _href="../backageController/targetUserMangement.do">
                <img src="../img/img/img4.png">
                <span>账户管理</span>
            </a>
            <a class="link" href="javascript:void(0)" _href="../backageController/getUserWaitingFor.do">
                <img src="../img/img/img6.png"/>
                <span>员工管理</span>
            </a>
            <a class="link" href="javascript:void(0)" _href="../backageController/caiManagement.do">
                <img src="../img/img/img5.png">
                <span>订单管理</span>
            </a>
            <a class="link" href="javascript:void(0)" _href="../backageController/commodityMannagement.do">
                <img src="../img/img/img7.png">
                <span>商品管理</span>
            </a>
            <a class="link" href="javascript:void(0)" _href="../targetBackstage/dreamManagement.do">
                <img src="../img/img/img8.png">
                <span>部件库管理</span>
            </a>
            <a class="link" href="javascript:void(0)" _href="../targetBackstage/informationManagement.do">
                <img src="../img/img/img3.png"/>
                <span>信息管理</span>
            </a>
        </div>
    </div>
</div>
<div class="container floatl">
    <!--iframe_box-->
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <iframe scrolling="auto" frameborder="0" src="../backageController/targetUserMangement.do" id="iframe" width="100%; height=100%;"></iframe>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function(){
        $(".link").click(function(){
            $(this).addClass('active').siblings().removeClass('active');
            var val = $(this).attr("_href");
            $(".show_iframe iframe").attr("src",val);
        });
    });
</script>
