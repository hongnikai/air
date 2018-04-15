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
    <title>商品管理</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="../js/laydate.dev.js"></script>
</head>
<body style="background-color: #f5f5f5;">
<div class="commodityM_all">
    <div class="commodityM_divheader">
        <div class="commodityM_divheader_div1">
            <input type="button" value="商品列表"/>
        </div>
       <!--  <div class="commodityM_divheader3">
            <span>开始时间</span>
            <h3 class="laydate-icon" id="start"></h3>
            <span>结束时间</span>
            <h3 class="laydate-icon" id="end"/></h3>
            <input type="hidden" name="" class="orderDo-start">
            <input type="hidden" name="" class="orderDo-end">
        </div> -->
        <div class="commodityM_divheader2">
            <input onclick="sousuo()" type="button" value="搜索"/>
            <input id="key" type="text" placeholder="请输入搜索关键字"/>
        </div>
    </div>
    <!--全部，进行中，已结束的table-->
    <div class="commodityM_TableOut">
        <table class="commodityM_Table">
            <tr class="commodityM_TableTrTop">
                <th>序号</th>
                <th>商品名</th>
                <th>商品图片</th>
                <th>品牌</th>
                <th>用途分类</th>
                <th>价格(元)</th>
                <th>首页标签</th>
                <th>详情</th>
                <th>编辑</th>
            </tr>
            
             <c:if test='${not empty "${list}"}'>
  			<c:forEach  items="${list}" var="data" varStatus="s"> 
            <tr class="commodityM_TableTrText">
                <td>${s.index+1}</td>
                <td>${data.c_name}</td>
                <td><img src="../../${data.cover_picture}" class="commodityM_TableTrTextBack"></td>
                <td><span class="commodityM_Table_span1">${data.brand}</span></td>
                <td>${data.use_type}</td>
                <td>${data.price}</td>
                <td>
                    <div class="commodityM_biaoqiandiv">
                        <div class="commodityM_biaoqiandiv1" onclick="aaa(this)"><img src="../img/img2.png"/><em>折扣专区</em></div>
                        <div class="commodityM_biaoqiandiv2">
                            <div onclick="fun1('${data.c_id}')">优惠活动</div>
                            <div onclick="fun2('${data.c_id}')">普通商品</div>
                            <div onclick="fun3('${data.c_id}')">保养套餐</div>
                            <div onclick="fun4('${data.c_id}')">品牌活动</div>
                            <div onclick="fun5('${data.c_id}')">热销商品</div>
                        </div>
                    </div>
                </td>
                <td><a href="../backageController/good_contentUntitled1.do?c_id=${data.c_id}" class="commodityM_a1">查看</a></td>
                <td><a href="../backageController/newGoods.do?c_id=${data.c_id}" class="commodityM_a2"><img src="../img/img/img9.png"></a></td>
            </tr>
            </c:forEach>
            </c:if>
           
        </table>
        
        <c:if test='${not empty "${list}"}'>
        <div class="commodityM_Footer">
            <input type="button" value="新建" class="commodityM_btnnew"/>
            <div class="commodityM_FooterPage">
                <a href="../backageController/commodityMannagement.do?pageNumber=${min}"><input type="button" value="上一页"/></a>
                <span>当前第${middle+1}页,共${page}页</span>
                <a href="../backageController/commodityMannagement.do?pageNumber=${num}"><input type="button" value="下一页"/></a>
            </div>
        </div>
        </c:if>
        
    </div>
</div>
</body>
</html>
<script>
function fun1(data){
	$.ajax({
		url:"../backageController/updateTag.do",
		type:"post",
		data:{"c_id":data,"mark":1},
		success:function(data){
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
})
}
function fun2(data){
	$.ajax({
		url:"../backageController/updateTag.do",
		type:"post",
		data:{"c_id":data,"mark":0},
		success:function(data){
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
})
}
function fun3(data){
	$.ajax({
		url:"../backageController/updateTag.do",
		type:"post",
		data:{"c_id":data,"mark":3},
		success:function(data){
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
})
}
function fun4(data){
	$.ajax({
		url:"../backageController/updateTag.do",
		type:"post",
		data:{"c_id":data,"mark":4},
		success:function(data){
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
})
}
function fun5(data){
	$.ajax({
		url:"../backageController/updateTag.do",
		type:"post",
		data:{"c_id":data,"mark":2},
		success:function(data){
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
})
}
       $(function(){
           /*商品列表的颜色的显示*/
           $('.commodityM_divheader_div1 input').eq(0).addClass('commodityM_active');
         function eachcolor(){
             /*table循环颜色问题*/
             $('.commodityM_Table tr').each(function(){
                 var biaoqiancolor=$(this).find('.commodityM_biaoqiandiv1 em').html();
                 if($(this).find('.commodityM_biaoqiandiv1 em').html()=='折扣专区'){
                     $(this).find('.commodityM_biaoqiandiv1').css("backgroundColor",'#44bc5f');
                     $(this).find('.commodityM_biaoqiandiv2').css("backgroundColor",'#44bc5f');
                 }else if($(this).find('.commodityM_biaoqiandiv1 em').html()=='无标签'){
                     $(this).find('.commodityM_biaoqiandiv1').css("backgroundColor",'#84ccc9');
                     $(this).find('.commodityM_biaoqiandiv2').css("backgroundColor",'#84ccc9');
                 }
             });
         }
           eachcolor();//不能删掉哈！！！
           $('.commodityM_biaoqiandiv2 div').click(function(){
               var divcontent=$(this).html();
               $(this).parent().siblings('.commodityM_biaoqiandiv1').find('em').html(divcontent);
               $(this).parent().css('display','none');
               eachcolor();
           });


           /*点击新建跳转*/
           $('.commodityM_btnnew').click(function(){
               window.location.href="../targetBackstage/createNewGoods.do";
           });

       });
       /*点击选择首页标签*/

       function aaa(obj) {
           $(obj).siblings('.commodityM_biaoqiandiv2').css('display','block');
       }
function sousuo(){
	alert("进入搜索");
	var key=$("#key").val();
	window.location.href="../backageController/getCommodityVagueResult.do?keyword="+key;
	
}
       
       
       

</script>
<script>
    // JavaScript Document  时间选择
    var start = {
        elem: '#start',
        format: 'YYYY-MM-DD',
        min: laydate.now(), //设定最小日期为当前日期
        max: '2099-06-16', //最大日期
        istime: true,
        istoday: false,
        choose: function(datas){
            end.min = datas; //开始日选好后，重置结束日的最小日期
            end.start = datas //将结束日的初始值设定为开始日
        }
    };
    var end = {
        elem: '#end',
        format: 'YYYY-MM-DD',
        min: laydate.now(),
        max: '2099-06-16',
        istime: true,
        istoday: false,
        choose: function(datas){
            start.max = datas; //结束日选好后，重置开始日的最大日期
        }
    };
    laydate(start);
    laydate(end);
</script>


