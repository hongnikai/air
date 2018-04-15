<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <script type="text/javascript" src="js/jquery-3.1.0.min.js" charset="utf-8"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   
    

    
    
  <script type="text/javascript" src="./js/jquery.js"></script>
    <script type="text/javascript">
    $(function(){
    	
    	 var maintain_id="adsa";
    	    var a_id="adasdasdad";
    	    var maintain_order_id=";;asdllw";
    	  			function pay(){
    	  				window.location.href="http://www.kongtiaoguanjia.com/air/payController/toPayTheMaintainOrder.do?maintain_id="+maintain_id+"&a_id="+a_id+"&maintian_order_id="+data;
    	  			}
    	
    })
    
   
    
    
    </script>
  </body>
</html>
