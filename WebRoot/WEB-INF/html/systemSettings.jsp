<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>系统设置</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<div>
    <div class="systemHeader">
        <div><input type="button" value="管理员" class="wishHeaderInputClick"></div>
        <div><input type="button" value="添加管理员" class="wishHeaderInputClick add"></div>
    </div>
    <div class="systemOuter">
        <table class="systemTable">
            <tr class="systemTableTop">
                <th>序号</th>
                <th>级别</th>
                <th>权限</th>
                <th>用户名</th>
                <th>联系电话</th>
                <th>操作(仅超级管理员可见)</th>
                <th>详情</th>
            </tr>
            <tr class="systemTableText">
                <td>1</td>
                <td>超级</td>
                <td>全部</td>
                <td>哈哈哈</td>
                <td>15254125222</td>
                <td>————</td>
                <td><a href="auditDetail.html"><img src="../img/20180123162043.png"></a></td>
            </tr>
            <tr class="systemTableText">
                <td>2</td>
                <td>二级</td>
                <td>任务审核</td>
                <td>哈哈哈</td>
                <td>15254125222</td>
                <td><input type="button" value="编辑" class="systemTableTrTextSure"></td>
                <td><a href="auditDetail.html"><img src="../img/20180123162043.png"></a></td>
            </tr>
            <tr class="systemTableText">
                <td>3</td>
                <td>二级</td>
                <td>任务审核</td>
                <td>哈哈哈</td>
                <td>15254125222</td>
                <td><input type="button" value="编辑" class="systemTableTrTextSure"></td>
                <td><a href="auditDetail.html"><img src="../img/20180123162043.png"></a></td>
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
            <div>添加管理员</div>
        </div>
        <div class="systemReferTanMid">
            <span class="systemReferTanMidSpan">管理员姓名</span>
            <input type="text" value="哈哈" class="systemReferTanMidInput">
        </div>
        <div class="systemReferTanMid">
            <span class="systemReferTanMidSpan">管理员电话</span>
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
            <span class="systemReferTanMidSpan">设置权限</span>
            <select class="systemReferTanMidSelect">
                <option>任务审核</option>
                <option>提现审核</option>
                <option>超级管理员</option>
            </select>
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
            $(".findReferTanTop div").html("编辑管理员");
        })
    });
    $(".findReferHui,.findReferTanBottomBtn2,.findReferTanTopClose,.findReferTanBottomBtn1").click(function(){
        $(".findReferHui,.findReferTan").css("display","none");
    })
    $(".add").click(function(){
        $(".findReferHui,.findReferTan").css("display","block");
        $(".findReferTanTop div").html("添加管理员");
    })
</script>

