<%@ page language="java" import="java.util.*,com.wingfac.entity.*" pageEncoding="utf-8"%>
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
    <title>账户管理</title>
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/css.css">
</head>
<body>
<div class="userM_all">
    <div class="userM_divheaderw">
        <div class="userM_divheader">
            <input type="button" onclick="sousuo()" value="搜索"/>
            <input id="keywords" type="text"  placeholder="请输入搜索关键字"/>
        </div>
    </div>
    <div class="userM_divcontent">
        <table>
            <tr>
                <th>序号</th>
                <th>用户名</th>
                <th>性别</th>
                <th>详情</th>
            </tr>
		<c:if test='${not empty "${list}"}'>
		<c:forEach  items="${list}" var="data" varStatus="s">
            <tbody id="t_body">
                <td>${s.index+1}</td>
               	<td>${data.nickname}</td>
                <td>${data.sex}</td>
                <td><a href="../backageController/targetUserMangementDetail.do?au_id=${data.au_id}">详情</a></td>
            </tbody>
        </c:forEach>
        </c:if>	     
        </table>
    </div>
    <div class="userM_divfooter">
        <div class="userM_page">
            <a href="../backageController/targetUserMangement.do?pageNumber=${min}"><input type="button" value="上一页"/></a>
            <span>当前第${middle}页,共${page}页</span>
            <a href="../backageController/targetUserMangement.do?pageNumber=${num}"><input type="button" value="下一页"/></a>
        </div>
    </div>
</div>

			


</body>
</html>
<script type="text/javascript">
function sousuo(){
	var key=$("#keywords").val();
	window.location.href="../backageController/selectPersonalByKeyWords.do?keywords="+key;
}
</script>
<script type="text/javascript">




/* $(function(){
	 $.ajax({
			url:"../userController/select_all_users.do",
			type:"post",
			//data:{"conId":message},
			success:function(data){
				alert("成功进入");
				console.log(data);
				alert(data.list[0].sex);
				
			var html=$("#t_body").html("");
				for(var i=0;i<data.list.length;i++){
			   var	td="<tr>";
			   		td+="<td>"+i+"</td>";
			   		td+="<td>"+data.list[i].nickname+"</td>";
			   		td+="<td>"+data.list[i].sex+"</td>";
			   		td+="<td ><a onclick='fun1("+data.list[i].au_id+")'>详情</a></td>";
			   		td+="</td>";
					html.append(td); 
				}			
			},
			dataType:"json",
			error: function(msg){
				alert("哎呀网络开小差了，稍等会吧!");
				console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
			},
			async:false
		}) 
	
})

		function fun1(data){
		  window.location.href="../backageController/targetUserMangementDetail.do?au_id="+data;
		
			
		} */



</script>

