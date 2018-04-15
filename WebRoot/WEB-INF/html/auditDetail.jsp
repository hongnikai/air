<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>审核详情</title>
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<div class="auditD_all">
    <div class="auditD_divheader">
        <div class="auditD_divheader_div1">
            <span></span>
            <span>心愿梦想秀蔡宝尚的审核详情</span>
        </div>
        <ul class="auditD_divheader_ul1">
            <li class="auditD_divheader_ul1li1">心愿<input type="hidden" value=""/></li>
            <li class="auditD_divheader_ul1li1">梦想秀<input type="hidden" value=""/></li>
            <li class="auditD_divheader_ul1li1">菜宝赏<input type="hidden" value=""/></li>
            <li class="auditD_divheader_ul1li2">提现<input type="hidden" value=""/></li>
        </ul>
    </div>
    <!--心愿，梦想秀，菜宝赏的表格-->
    <div class="auditD_divcontent">
        <table class="auditD_Table">
            <tr class="auditD_TableTrTop">
                <th>序号</th>
                <th>标题</th>
                <th>内容</th>
                <th>用户</th>
                <th>发布时间</th>
                <th>已获得阳光值(缕)</th>
                <th>点赞数</th>
                <th>状态</th>
                <th>审核时间</th>
                <th>审核员</th>
            </tr>
            <tr class="auditD_TableTrText">
                <td>1</td>
                <td>我的梦想</td>
                <td><img src="../img/photo.png" class="auditD_TableTrTextBack"></td>
                <td><div class="auditD_TableTrTextUser"><img src="../img/tie.png" class="auditD_TableTrTextTou"><span class="auditD_TableTrTextName">哈哈</span></div></td>
                <td>2016.12.15 <br> 12:15:12</td>
                <td class="auditD_TableTrTextSun">2222</td>
                <td>454545</td>
                <td><input type="button" value="通过" class="auditD_TableTrTextSure"><input type="button" value="驳回" class="auditD_TableTrTextNo"></td>
                <td>2016.12.15 <br> 12:15:12</td>
                <td>哈哈</td>
            </tr>
            <tr class="auditD_TableTrText">
                <td>2</td>
                <td>我的梦想</td>
                <td><img src="../img/photo.png" class="auditD_TableTrTextBack"></td>
                <td><div class="auditD_TableTrTextUser"><img src="../img/tie.png" class="auditD_TableTrTextTou"><span class="auditD_TableTrTextName">哈哈哈哈哈哈</span></div></td>
                <td>2016.12.15 <br>12:15:12</td>
                <td class="auditD_TableTrTextSun">2222</td>
                <td>454545</td>
                <td><span class="auditD_TrTextState">进行中</span></td>
                <td>2016.12.15 <br> 12:15:12</td>
                <td>哈哈</td>
            </tr>
            <tr class="auditD_TableTrText">
                <td>3</td>
                <td>我的梦想</td>
                <td><img src="../img/photo.png" class="auditD_TableTrTextBack"></td>
                <td><div class="auditD_TableTrTextUser"><img src="../img/tie.png" class="auditD_TableTrTextTou"><span class="auditD_TableTrTextName">哈哈哈哈哈哈</span></div></td>
                <td>2016.12.15<br> 12:15:12</td>
                <td class="auditD_TableTrTextSun">2222</td>
                <td>454545</td>
                <td><span class="auditD_TrTextState">已完成</span></td>
                <td>2016.12.15 <br> 12:15:12</td>
                <td>哈哈</td>
            </tr>
        </table>
    </div>
    <!--提现的表格-->
    <div class="auditD_divcontentTixian">
        <table class="auditD_TableTixian">
            <tr class="auditD_TableTrTopTixian">
                <th>序号</th>
                <th>用户名</th>
                <th>操作时间</th>
                <th>金额(元)</th>
                <th>佣金比例</th>
                <th>阳光值(缕)</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            <tr class="auditD_TableTrTextTixian">
                <td>1</td>
                <td><div class="auditD_TableTrTextUser"><img src="../img/tie.png" class="auditD_TableTrTextTou"><span class="auditD_TableTrTextName">哈哈哈</span></div></td>
                <td>2016.12.15 <br> 12:15:12</td>
                <td>777</td>
                <td>50%</td>
                <td class="auditD_TableTrTextSunTixian">2222</td>
                <td>未通过</td>
                <td><input type="button" value="通过" class="auditD_TableTrTextSure"><input type="button" value="驳回" class="auditD_TableTrTextNo"></td>
            </tr>
            <tr class="auditD_TableTrTextTixian">
                <td>2</td>
                <td><div class="auditD_TableTrTextUser"><img src="../img/tie.png" class="auditD_TableTrTextTou"><span class="auditD_TableTrTextName">哈哈哈</span></div></td>
                <td>2016.12.15 <br> 12:15:12</td>
                <td>777</td>
                <td>50%</td>
                <td class="auditD_TableTrTextSunTixian">2222</td>
                <td>未通过</td>
                <td><input type="button" value="通过" class="auditD_TableTrTextSure"><input type="button" value="驳回" class="auditD_TableTrTextNo"></td>
            </tr>
            <tr class="auditD_TableTrTextTixian">
                <td>3</td>
                <td><div class="auditD_TableTrTextUser"><img src="../img/tie.png" class="auditD_TableTrTextTou"><span class="auditD_TableTrTextName">哈哈哈</span></div></td>
                <td>2016.12.15 <br> 12:15:12</td>
                <td>777</td>
                <td>50%</td>
                <td class="auditD_TableTrTextSunTixian">2222</td>
                <td>未通过</td>
                <td><input type="button" value="通过" class="auditD_TableTrTextSure"><input type="button" value="驳回" class="auditD_TableTrTextNo"></td>
            </tr>
        </table>
    </div>
    <div class="auditD_divfooter">
        <div class="auditD_page">
            <input type="button" value="上一页"/>
            <span>1111112345679</span>
            <input type="button" value="下一页"/>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(".auditD_TrTextState").each(function(){
        var content = $(this).html();
        if(content=='进行中'){
            $(this).css("color","#63c335");
        }else if(content=='已完成'){
            $(this).css("color","#333");
        }
    });
    $('.auditD_divheader_ul1 li').eq(0).addClass("auditD_active");
    $('.auditD_divheader_ul1 li').click(function(){
        $(this).addClass("auditD_active").siblings().removeClass("auditD_active");
        var selcet=$(this).find('input[type=hidden]').val();
    });

    $(".auditD_divheader_ul1li1").click(function(){
        $(".auditD_divcontent").css("display","block");
        $(".auditD_divcontentTixian").css("display","none");
    })
    $(".auditD_divheader_ul1li2").click(function(){
        $(".auditD_divcontent").css("display","none");
        $(".auditD_divcontentTixian").css("display","block");
    })

</script>