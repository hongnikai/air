<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>公司订单录单</title>
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/css.css">
</head>
<body style="background-color: #f5f5f5;">
<div class="oCatalogue_all">
    <div class="oCatalogue_divheader">
        <div class="oCatalogue_divheader_div1">
            <span></span>
            <span>公司订单录单</span>
        </div>
    </div>
    <div class="oCatalogue_divcontent">
       <ul>
           <li><span>订单号</span><input type="text"/></li>
           <li><span>服务项目</span><input type="text"/></li>
           <li><span>公司名称</span><input type="text"/></li>
           <li><span>联系电话</span><input type="text"/></li>
           <li><span>企业注册号</span><input type="text"/></li>
           <li>
               <span class="oCatalogue_divcontentspan">营业执照</span>
               <div class="oCatalogue_imgk1">
                   <div id="redface" class="floatl preview">
                       <img src="../img/img1.png" alt=""  id="preview1">
                   </div>
                   <input class="upimg" type="file" name="file" id="doc1" onchange="javascript:setImagePreview1();">
              </div>
           </li>
           <li>
               <span class="oCatalogue_divcontentspan">合同照片</span>
               <div class="oCatalogue_imgk2">
                   <div id="redface" class="floatl preview">
                       <img src="../img/img1.png" alt=""  id="preview2">
                   </div>
                   <input class="upimg1" type="file" name="file" id="doc2" onchange="javascript:setImagePreview2();">
               </div>
           </li>
       </ul>

    </div>
    <div class="oCatalogue_divfooter">
            <div class="oCatalogue_divfooter1">
                <input type="button" value="返回"/>
                <input type="button" value="取消"/>
                <input type="button" value="保存"/>
            </div>
            <div class="oCatalogue_page">
                <input type="button" value="上一页"/>
                <span>1111112345679</span>
                <input type="button" value="下一页"/>
            </div>
    </div>
</div>

</body>
</html>
<script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="../js/upload1.js"></script>
<script>
    $('.oCatalogue_divfooter1 input:first-child').click(function () {
        window.location.href="javaScript:history.back(-1)";
    })

    $('.oCatalogue_divheader_div1').click(function () {
        window.location.href="javaScript:history.back(-1)";
    })
</script>


