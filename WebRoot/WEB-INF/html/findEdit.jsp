<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑文章</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="../js/upload.js"></script>
</head>
<body style="background-color: #f5f5f5;">
<div class="findEditAll">
    <div class="findEditTitle">标题</div>
    <div class="findEditTitleText">
        <input type="text" placeholder="请输入标题内容" value="">
    </div>
    <div class="findEditTitle">封面</div>
    <div class="findEditTitleBack">
        <div class="imgk">
            <div id="redface" class="floatl preview">
                <img src="../img/816225271321491805.png" alt=""  id="preview1">
            </div>
            <input class="upimg" type="file" name="file" id="doc1" onchange="javascript:setImagePreview1();">
        </div>
        <div class="findEditTitleBackDiv">推荐图片尺寸710X320</div>
    </div>
    <div class="findEditTitle">内容</div>
    <div class="findEditTitleArticle">
        <textarea placeholder="请输入内容">这是一条内容，这是一条重要内容</textarea>
        <div class="findEditTitleArticleImg">
            <div class="findEditTitleArticleImg-imgk">
                <div id="redface" class="floatl preview">
                    <img src="../img/816225271321491805.png" alt=""  id="preview2">
                </div>
                <input class="upimg" type="file" name="file" id="doc2" onchange="javascript:setImagePreview2();">
            </div>
            <div class="findEditTitleArticleImg-imgk">
                <div id="redface" class="floatl preview">
                    <img src="../img/816225271321491805.png" alt=""  id="preview3">
                </div>
                <input class="upimg" type="file" name="file" id="doc3" onchange="javascript:setImagePreview3();">
            </div>
            <div class="findEditTitleArticleImg-imgk">
                <div id="redface" class="floatl preview">
                    <img src="../img/816225271321491805.png" alt=""  id="preview4">
                </div>
                <input class="upimg" type="file" name="file" id="doc4" onchange="javascript:setImagePreview4();">
            </div>
        </div>
    </div>
    <div class="findEditBtn">
        <input type="button" value="保存" class="findEditBtnSave">
        <input type="button" value="发送" class="findEditBtnSend">
    </div>
</div>
</body>
</html>
