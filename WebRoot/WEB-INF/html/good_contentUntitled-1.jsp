<%@ page language="java" import="java.util.*,com.wingfac.entity.*,javax.servlet.http.HttpServletRequest" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
        <head>
            <meta charset="utf-8">
            <title>商品详情</title>
            <link rel="stylesheet" href="../css/KTcss1.css">
        </head>
        <body>
            <div class="good_contentUntitled_all">
                <div class="goods_top">
                <%Commodity commodity=(Commodity)request.getAttribute("commodity");%>
                       <a><%=commodity.getC_name()%></a> 
                        商品详情					
                </div>
                <div class="good_content">
                    <div class="div_img"><img src="../../<%=commodity.getCover_picture()%>" alt=""></div>
                    <div class="div_tab">
                        <table>
                               <!--  <span>XXXXXXXXXXXXXXXXXXXXXX</span> -->
                        <tr>
                            <td><input type="button" value="品牌"></td>
                            
                            <td><%=commodity.getBrand()%></td>
                        </tr>
                        <tr>
                            <td><input type="button" value="用途分类"></td>
                            <%if(commodity.getUse_type()==0){%>
                            	<td>家用分体式</td>
                           <%}%>
                       	   <%if(commodity.getUse_type()==1){%>
                        	  <td>家用中央空调</td>
                           <%}%>
                           <%if(commodity.getUse_type()==2){%>
                        	  <td>商用中央空调</td>
                           <%}%>
                        </tr>
                        <tr>
                            <td><input type="button" value="价格"></td>
                            <td><%=commodity.getPrice()%></td>
                        </tr>
                        <tr>
                            <td><input type="button" value="首页标签" style="background-color:#f19149;border:1px solid #f19149"></td>
                            <%if(commodity.getCommodity_mark()==0){%>
                            	<td>无</td>
                            <%}%>
                            <%if(commodity.getCommodity_mark()==1){%>
                            	<td>折扣专区</td>
                            <%}%>
                            <%if(commodity.getCommodity_mark()==2){%>
                            	<td>热销商品</td>
                            <%}%>
                            <%if(commodity.getCommodity_mark()==3){%>
                            	<td>保养套餐</td>
                            <%}%>
                            <%if(commodity.getCommodity_mark()==4){%>
                            	<td>品牌活动</td>
                            <%}%>
                        </tr>
                    </table>
                </div>
                </div>
                <div class="good_bottom">
                        <div class="threebut">
                                <input type="button" onclick="fun1()" value="参数">
                                <input type="button" onclick="fun2()" value="详情">
                                <input type="button" onclick="fun3()" value="评价">
                        </div>
  <!-- ********************************************************************************************************** -->                       
                      <!-- ********************************************************************************************************** -->
				<div class="divpingjia" id="canshu">
					<div class="canshu_info">
						<div><span>品牌</span>爱是飞洒</div><div><span>用途分类</span>爱是飞洒</div><div><span>价格</span>爱是飞洒</div>
						<div><span>材质</span>爱是飞洒</div><div><span>材质</span>爱是飞洒</div><div><span>材质</span>爱是飞洒</div>
						<div><span>材质</span>爱是飞洒</div><div><span>材质</span>爱是飞洒</div><div><span>材质</span>爱是飞洒</div>
						<div><span>材质</span>爱是飞洒</div><div><span>材质</span>爱是飞洒</div><div><span>材质</span>爱是飞洒</div>
					</div>
				</div>
                        <div class="divpingjia" id="canshu">
                                <div> 
                                  <div class="name1tou"><img src="../img/img/20180226091651.png" alt=""></div>
                                  <div class="name1">
                                  <p>参数</p>
                                  <p style="color:#adadad">2017-06-15</p>
                                   </div>
                                  <div class="huifu_but"><input type="button" value="回复"></div>
                                </div>  
          
                                <div class="pingjia_bottom">
                                    
                                    <div>
                                            <div>好评！</div>
                                        <img src="../img/photo.png" style="width:185px;height:185px;">
                                        <img src="../img/photo.png" style="width:185px;height:185px;">
                                        <img src="../img/photo.png" style="width:185px;height:185px;">
                                    </div>
                                    <!--回复-->
                                    <div class='evaluationList-list-answer'>
                                        <div class='evaluationList-list-answer-top'></div>
                                        <div class='evaluationList-list-answer-text'>
                                            <div>客服回复：</div>
                                            <div style="font-size: 17px;">感谢您的回复，我们会继续努力!!!</div>
                                        </div>
                                    </div>
                                    </div>
                                    </div>
 <!-- ********************************************************************************************************** -->
                      	<!-- ********************************************************************************************************** -->
				<div class="divpingjia" id="xiangqing">
					<div class="con_con">
						内容内容内容内容内容内容内容，内容内容内容内容内容内容内容内容内容内容内容内容，内容内容内容内容内容内容内容内容内容内容，内容内容内容内容内容内容内容内容内容内容内容内容，内容内容内容内内容内容内容内容内容，内容内容内容内容内容内容内容内容内容内容内容内容，内容内容内容内内容内容内容内容内容，内容内容内容内容内容内容内容内容内容内容内容内容，内容内容内容内内容内容内容内容内容，内容内容内容内容内容内容内容内容内容内容内容内容，内容内容内容内
						<img src="img/icon_home_by.png" alt="">
						<img src="img/icon_home_by.png" alt="">
						<img src="img/icon_home_by.png" alt="">
					</div>
				</div>
				<!-- ********************************************************************************************************** -->
                      
                      
                        <div class="divpingjia" id="xiangqing">
                                <div> 
                                  <div class="name1tou"><img src="../img/20180226091651.png" alt=""></div>
                                  <div class="name1">
                                  <p>详情</p>
                                  <p style="color:#adadad">2017-06-15</p>
                                   </div>
                                  <div class="huifu_but"><input type="button" value="回复"></div>
                                </div>  
          
                                <div class="pingjia_bottom">
                                    
                                    <div>
                                            <div>好评！</div>
                                        <img src="../img/photo.png" style="width:185px;height:185px;">
                                        <img src="../img/photo.png" style="width:185px;height:185px;">
                                        <img src="../img/photo.png" style="width:185px;height:185px;">
                                    </div>
                                    <!--回复-->
                                    <div class='evaluationList-list-answer'>
                                        <div class='evaluationList-list-answer-top'></div>
                                        <div class='evaluationList-list-answer-text'>
                                            <div>客服回复:</div>
                                            <div style="font-size: 17px;">感谢您的回复，我们会继续努力!!!</div>
                                        </div>
                                    </div>
                                    </div>
                                    </div>
  <!-- ********************************************************************************************************** -->                                 
                     
                        <div class="divpingjia" id="pingjia">
                        <c:if test="${not empty '${sign}'}">   
                          <div>${sign}</div>
                        </c:if>
                         
                        
                     <c:if test="${not empty '${list}'}">   
  						<c:forEach  items="${list}" var="data" varStatus="s">    
                                <div> 
                                  <div class="name1tou"><img src="${data.head_img}" alt="${data.head_img}"></div>
                                  <div class="name1">
                                  <p>评价</p>
                                  <p style="color:#adadad">${data.eva_time}</p>
                                   </div>
                         
                                  <div class="huifu_but"><input type="button" value="回复"></div>
                                </div>  
          					
                                <div class="pingjia_bottom">
                                   
                                    <div>
                                    
                                  
                                      <c:if test="${data.commodity_score==5}"> 
                                             <div>商品评价：5分</div>
                                     </c:if>
                                     <c:if test="${data.picture ne '0'}">   
                               
                                    
                                     	
                                        <img src="pic(${data.picture})" style="width:185px;height:185px;">
                                        <img src="../img/photo.png" style="width:185px;height:185px;">
                                        <img src="../img/photo.png" style="width:185px;height:185px;">
                                	 </c:if> 
                                </div>
                                </div> 
                                   <!--  <!--回复-->
                                    <div class='evaluationList-list-answer'>
                                       
                                    
                                        <c:if test="${data.reply ne '0'}">
                                        <div class='evaluationList-list-answer-top'></div>
                                        <div class='evaluationList-list-answer-text'>
                                            <div>客服回复：</div>
                                            <div style="font-size: 17px;">${data.reply}</div>
                                        </div>
                                        </c:if>
                                    
                                        
                                    </div> 
                                   
                             </c:forEach>
                         </c:if>  
                       </div>   
 <!-- ********************************************************************************************************** -->                                         
            </div>
            </div> 
        </body>
        <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>  
        <script>
        $(".threebut input").eq(0).addClass("threebut_active");
        $(".threebut input").click(function(){
            $(this).addClass("threebut_active").siblings().removeClass("threebut_active");
        })
        </script>
        </html>
<script type="text/javascript">
$(function(){
	$("#canshu").show();
	$("#xiangqing").hide();
	$("#pingjia").hide();
})
function fun1(){
	$("#canshu").show();
	$("#xiangqing").hide();	
	$("#pingjia").hide();
}
function fun2(){
	$("#canshu").hide();	
	$("#xiangqing").show();
	$("#pingjia").hide();
}

 function fun3(){
	$("#canshu").hide();	
	$("#xiangqing").hide();
	$("#pingjia").show();
} 
function pic(data){
	
	alert("开始切割");
	alert(data);
	var pictures=data ;   
	var atk=pictures.split(",");
		for (var i = 0; i < atk.length; i++) {
			console.log(atk[i]);
		}
	
}

</script>      
 <!--          <script type="text/javascript">
									$(function(){
										alert("开始切割");
										/* var pictures=${data.picture};    
                                    	var atk=pictures.split(",");
                                    		for (var i = 0; i < atk.length; i++) {
												console.log(i.toLocaleString());
											} */
										
										
									})                               
                                    
                                    
                                    
                                    </script> -->
        <style type="text/css">
            .good_contentUntitled_all,.good_content,.good_bottom{overflow: hidden;}
            .good_content,.good_bottom{width: 950px;margin:0 auto;}
            html, body, div, h1, h2, h3, h4, h5, h6, p, input {
    margin: 0px;
    padding: 0px;
}

a {
    color: inherit;
    text-decoration: none;
    -webkit-tap-highlight-color: transparent;
    outline: none;
}

ul, li {
    list-style: none;
    margin: 0px;
    padding: 0px;
}

input {
    -webkit-tap-highlight-color: transparent;
    background-color: transparent;
}

html {
    width: 100%;
    font-family: 'SourceHanSansCN-Normal';
    height: 100%;
}

body {
    width: 100%;
    height: 100%;
    font-family: 'SourceHanSansCN-Normal';
}

canvas {
    display: block;
    position: relative;
}

img {
    border: 0 none;
    outline: 0 none
}

em {
    font-style: normal;
}

i {
    font-style: normal;
}

button {
    outline: none;
    border: none;
    font-size: inherit;
    font-family: inherit;
}

* {
    padding: 0rem;
    margin: 0rem;
}
        </style>
