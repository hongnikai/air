<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>销售管理</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
</head>
<body style="background-color: #f5f5f5;">
<div>
    <div class="wishHeader">
        <div><input type="button" value="待审核"></div>
        <div><input type="button" value="销售员"></div>
        <div><input type="button" value="维修员"></div>
        <div><input type="button" value="管理层"></div>

        <span class="wishMD_divheader2">
            <input onclick="sousuo()" type="button" value="搜索"/>
            <input id="key" type="text" placeholder="请输入搜索关键字"/>
        </span>
    </div>
    <div class="wishTableOut">
       <%--  <div class="wishtablediv1">
        <table class="wishTable">
            <tr class="wishTableTrTop">
                <th>序号</th>
                <th>用户名</th>
                <th>联系电话</th>
                <th>性别</th>
                <th>审核</th>
            </tr>
          <c:if test='${not empty "${list}"}'>
  			<c:forEach  items="${list}" var="data" varStatus="s"> 
            <tr class="wishTableTrText">
                <td>${s.index+1}</td>
                <td><div class="wishTableTrTextUser"><img src="${data.headimg}" class="wishTableTrTextTou"><span class="wishTableTrTextName">${data.nickname}</span></div></td>
                <td>${data.mobile}</td>
                <td>${data.sex}</td>
                <td>
                <input type="button" onclick="fun1('${data.au_id}')" value="通过" class="wishTableTrTextNo"> 
                <input type="button" onclick="fun2('${data.au_id}')" value="拒绝" class="wishTableTrTextNo"><!-- class="wishTableTrTextSure" -->
                <input type="button" onclick="fun3('${data.au_id}')" value="删除" class="wishTableTrTextNo">
                <c:if test="${data.orderstate==0}">
                	<input type="button" value="(待审核)" class="wishTableTrTextNo">
                </c:if>
               <c:if test="${data.orderstate==1}">
               		<input type="button" value="(未通过)" class="wishTableTrTextNo">
               </c:if>
               <c:if test="${data.orderstate==2}">
               		<input type="button" value="(已通过)" class="wishTableTrTextNo">
               </c:if>
                </td>
            </tr>
           	 </c:forEach>
           	 </c:if>
        </table>
        <div class="wishFooter">
            <div class="wishFooterPage">
                <a href="../backageController/getUserWaitingFor.do?pageNumber=${min}"><input type="button" value="上一页"/></a>
                <span>当前第${middle}页,共${page}页</span>
                <a href="../backageController/getUserWaitingFor.do?pageNumber=${num}"><input type="button" value="下一页"/></a>
            </div>
        </div>
        </div> --%>
        
        
        <div class="wishtablediv2">
        <!--销售-->
        <table class="wishTableXiaoshou">
        
            <tr class="wishTableTrTopxiaoshou">
                <th>序号</th>
                <th>用户名</th>
                <th>联系电话</th>
                <th>性别</th>
                <th>当前得分</th>
                <th>账号操作</th>
            </tr>
          <c:if test="${not empty '${list}'}">
          <c:forEach  items="${list}" var="data" varStatus="s"> 
            <tr class="wishTableTrTextxiaoshou">
                <td>${s.index+1}</td>
                <td><div class="wishTableTrTextUser"><img src="${data.headimg}" class="wishTableTrTextTou"><span class="wishTableTrTextName">${data.nickname}</span></div></td>
                <td>${data.mobile}</td> 
                <td>${data.sex}</td>
                <td>${data.score}</td>
                <td><input type="button" onclick="fun1('${data.au_id}')" value="关闭" class="wishTableTrTextSure"></td>
            </tr>
            </c:forEach>  
            
        </table>
        <div class="wishFooter">
            <div class="wishFooterPage">
                <input type="button" value="上一页"/>
                <span>2222222222222222222</span>
                <input type="button" value="下一页"/>
            </div>
        </div>
        </div>
          </c:if>
    
    
          
          
    </div>
</div>
</body>
</html>
<script type="text/javascript">
function fun1(data){
	alert(data);
	 window.location.href="../backageController/closeSalerManagement.do?au_id="+data; 
}
function sousuo(){
	var key=$("#key").val();
	window.location.href="../backageController/getWishManagementResulet.do?keyword="+key;
}

</script>

<script>
$('.wishtablediv2').css('display','block');
    //待审核，销售员，维修员，管理成点击更换颜色
    $(".wishHeader div input").eq(0).addClass("wishHeaderInputClick");
    $(".wishHeader div input").click(function(){
        $(this).addClass("wishHeaderInputClick");
        $(this).removeClass("wishHeaderInput");
        $(this).parent().siblings().find('input').addClass("wishHeaderInput");
        $(this).parent().siblings().find('input').removeClass("wishHeaderInputClick");
    });
$('.wishMD_divheader2 input:last-child').addClass("wishHeaderInput2").removeClass('wishHeaderInput');
    //进行中与已完成颜色更换
   $(".wishTableTrTextSure").each(function(){
        var content = $(this).val();
        if(content=='关闭'){
            $(this).css("backgroundColor","#f19149");
        }else if(content=='已关闭'){
            $(this).css("backgroundColor","#a0a0a0");
        }
    });
	
   $('.wishHeader div:first-child').click(function () {
     /*   $('.wishtablediv1').css('display','block');
       $('.wishtablediv2').css('display','none');
       $('.wishtablediv3').css('display','none');
       $('.wishtablediv4').css('display','none'); */
       window.location.href="../backageController/getUserWaitingFor.do";
       
   });
    $('.wishHeader div:nth-child(2)').click(function () {
      /*   $('.wishtablediv1').css('display','none');
        $('.wishtablediv2').css('display','block');
        $('.wishtablediv3').css('display','none');
        $('.wishtablediv4').css('display','none'); */
        $('.wishtablediv2').css('display','block');
       // alert("进入第二个方法");
       /*  window.location.href="";  */
        
        
    });
    $('.wishHeader div:nth-child(3)').click(function () {
    	/* alert("进入方法23"); */
       /*  $('.wishtablediv1').css('display','none');
        $('.wishtablediv3').css('display','block');
        $('.wishtablediv2').css('display','none');
        $('.wishtablediv4').css('display','none'); */
        window.location.href="../backageController/repairManagement.do";
        
        
    });
    $('.wishHeader div:nth-child(4)').click(function () {
    	//alert("进入方法4");
    	/* $('.wishtablediv1').css('display','none');
        $('.wishtablediv2').css('display','none');
        $('.wishtablediv3').css('display','none');
        $('.wishtablediv4').css('display','block'); */
    	window.location.href="../backageController/selectAndTargetManagement.do";
    });



</script>