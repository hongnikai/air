<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>推荐用户</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body style="background-color: #f5f5f5;position: relative;">
<div>
    <div class="findHeader">
        <a class="findLink" href="findManagement.html">
            <div><input type="button" value="草稿箱"></div>
        </a>
        <a class="findLink" href="findSend.html">
            <div><input type="button" value="已发布"></div>
        </a>
        <a class="findLink" href="findNew.html">
            <div><input type="button" value="新建文章"></div>
        </a>
        <a class="findLink" href="findReference.html">
            <div><input type="button" value="推荐用户" class="findHeaderInputClick"></div>
        </a>
    </div>
    <div class="findReferContent">
        <div class="findReferContentTop">推荐用户设置</div>
        <div class="findReferContentMid">
            <div class="findReferContentMid1">
                <div class="findReferContentMid1-imgk">
                    <div id="redface1" class="floatl preview">
                        <img src="../img/001.png" alt="" id="preview1">
                    </div>
                    <input class="upimg" type="file" name="file" id="doc1" onchange="javascript:setImagePreview1();">
                </div>
                <div class="findReferContentMid1Choose">
                    <div class="findReferContentMid1Choose1">选择用户</div>
                    <div class="findReferContentMid1Choose2"><input type="text" value="哈哈哈哈" readonly></div>
                </div>
                <div class="findReferContentMid1Chuan">
                    <input type="button" value="保存">
                </div>
            </div>
            <div class="findReferContentMid1">
                <div class="findReferContentMid1">
                    <div class="findReferContentMid1-imgk">
                        <div id="redface1" class="floatl preview">
                            <img src="../img/002.png" alt="" id="preview2">
                        </div>
                        <input class="upimg" type="file" name="file" id="doc2"
                               onchange="javascript:setImagePreview2();">
                    </div>
                    <div class="findReferContentMid1Choose">
                        <div class="findReferContentMid1Choose1">选择用户</div>
                        <div class="findReferContentMid1Choose2"><input type="text" value="哈哈哈哈" readonly></div>
                    </div>
                    <div class="findReferContentMid1Chuan">
                        <input type="button" value="保存">
                    </div>
                </div>
            </div>
            <div class="findReferContentMid1">
                <div class="findReferContentMid1">
                    <div class="findReferContentMid1-imgk">
                        <div id="redface1" class="floatl preview">
                            <img src="../img/003.png" alt="" id="preview3">
                        </div>
                        <input class="upimg" type="file" name="file" id="doc3"
                               onchange="javascript:setImagePreview3();">
                    </div>
                    <div class="findReferContentMid1Choose">
                        <div class="findReferContentMid1Choose1">选择用户</div>
                        <div class="findReferContentMid1Choose2"><input type="text" value="哈哈哈哈" readonly></div>
                    </div>
                    <div class="findReferContentMid1Chuan">
                        <input type="button" value="保存">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="findReferHui"></div>
    <div class="findReferTan">
        <div class="findReferTanTop">
            <div>选择推荐用户</div>
            <img src="../img/close.png" class="findReferTanTopClose">
        </div>
        <div class="findReferTanMid">
            <img src="../img/search.png" class="findReferTanMidImg">
            <input type="text" class="findReferTanMidInput">
        </div>
        <div class="findReferTanChooseAll">
            <div class="findReferTanChoose">
                <span>01.</span>
                <img src="../img/photo.png">
                <span>哈哈哈</span>
                <input type="radio" name="name" class="findReferTanChooseInput">
            </div>
            <div class="findReferTanChoose">
                <span>02.</span>
                <img src="../img/photo.png">
                <span>哈哈哈</span>
                <input type="radio" name="name" class="findReferTanChooseInput">
            </div>
            <div class="findReferTanChoose">
                <span>03.</span>
                <img src="../img/photo.png">
                <span>哈哈哈</span>
                <input type="radio" name="name" class="findReferTanChooseInput">
            </div>
            <div class="findReferTanChoose">
                <span>04.</span>
                <img src="../img/photo.png">
                <span>哈哈哈</span>
                <input type="radio" name="name" class="findReferTanChooseInput">
            </div>
            <div class="findReferTanChoose">
                <span>05.</span>
                <img src="../img/photo.png">
                <span>哈哈哈</span>
                <input type="radio" name="name" class="findReferTanChooseInput">
            </div>
        </div>
        <div class="findReferTanBottom">
            <input type="button" value="确定" class="findReferTanBottomBtn1">
            <input type="button" value="取消" class="findReferTanBottomBtn2">
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="../js/upload.js"></script>
<script>
$(".findReferContentMid1Choose").each(function(){
    $(this).click(function(){
        $(".findReferHui,.findReferTan").css("display","block");
    })
});
$(".findReferHui,.findReferTanBottomBtn2,.findReferTanTopClose,.findReferTanBottomBtn1").click(function(){
    $(".findReferHui,.findReferTan").css("display","none");
})
</script>
