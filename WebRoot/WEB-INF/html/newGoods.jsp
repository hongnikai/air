<%@ page language="java" import="java.util.*,com.wingfac.entity.*,javax.servlet.http.HttpServletRequest" pageEncoding="utf-8"%>
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
    <title>新建/编辑商品</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
</head>
<body>
<div class="newG_all">
    <div class="newG_divheader">
        <div class="newG_divheader_div1">
            <span></span>
            <span>某空调某空调的商品详情</span>
        </div>
    </div>
    <form action="../commodity/updateNewGoods.do" method="post" enctype="multipart/form-data">
   
    <div class="newG_content">
        <ul class="newG_content_ul1">
            <li>
                <span>商品名称</span>
                <%Commodity commodity=(Commodity)request.getAttribute("commodity");%>
                       <a><%=commodity.getC_name()%></a> 
                  <input value="<%=commodity.getC_id()%>" name="c_id" style="display: none">      
                <input type="text" class="newG_input1" value="<%=commodity.getC_name()%>" name="c_name"/>
            </li>
            <li>
                <span>商品图片</span>
                <div class="newG_imgk1">
                    <div id="redface" class="floatl preview">
                        <img src="../../<%=commodity.getCover_picture()%>" alt=""  id="preview1" class="img1-img">
                        <input type="button" class="btn" onclick="browerfile.click()" value="上传">
  				   		<input type="file" id="browerfile" name="cover_picture" style="display: none;" class="test">
                    </div>
                    
     <!--  -->           <!-- doc1 -->   <!--  <input class="upimg" type="file" name="cover_picture" id="cover_picture" onchange="javascript:setImagePreview1();"> -->
             
                </div>
            </li>
               
            <li><span>价格</span><input type="text" class="newG_input2" value="<%=commodity.getPrice()%>" name="price"/><em>元</em></li>
            <li><span>品牌型号</span><input type="text" class="newG_input1"/ value="<%=commodity.getBrand()%>" name="brand"></li>
            <li class="aaaaaanewG">
                <span>用途分类</span>
                <div class="newG_kontiaotypeall">
                    <div class="newG_kontiaotype">
                        <%if(commodity.getUse_type()==0){%>
                           <i class="newG_namekongtiao" onclick="fun1(<%=commodity.getUse_type()%>,<%=commodity.getC_id()%>)">家用分体式空调</i>
                        <%}%>
                        <%if(commodity.getUse_type()==1){%>
                           <i class="newG_namekongtiao" onclick="fun2(<%=commodity.getUse_type()%>)">家用中央空调</i>
                        <%}%>
                        <%if(commodity.getUse_type()==2){%>
                           <i class="newG_namekongtiao" onclick="fun3(<%=commodity.getUse_type()%>)">商用中央空调</i>
                        <%}%>
                    </div>
                    <div class="newG_kontiaotype2">
                        <div onclick="fun4('<%=commodity.getC_id()%>')">家用分体空调</div>
                        <div onclick="fun5('<%=commodity.getC_id()%>')">家用中央空调</div>
                        <div onclick="fun6('<%=commodity.getC_id()%>')">商用中央空调</div>
                    </div>
                </div>
            </li>
            <li>
            
                <span>商品参数</span>
                <ul class="newG_content_ul2">
                    <div><span>上市时间</span><input type="text" value="<%=commodity.getCreate_time()%>" name="creat_time"></div>
                    <div><span>保修期</span><input type="text" value="<%=commodity.getRepair_time()%>" name="repair_time"></div>
               
                    <div><span>内机包装尺寸</span><input type="text" value="<%=commodity.getInsert_pack_size()%>" name="insert_pack_size"></div>
                    <div><span>内机堆码层数极限</span><input type="text" value="<%=commodity.getInsert_plies_max()%>" name="insert_plies_max"></div>
                    <div><span>内机毛重</span><input type="text" value="<%=commodity.getInsert_weight()%>" name="insert_weight"></div>
                    <div><span>内机尺寸</span><input type="text" value="<%=commodity.getInsert_size()%>" name="insert_size"></div>
                    <div><span>制冷功率</span><input type="text" value="<%=commodity.getCold_power()%>" name="cold_power"></div>
                    <div><span>制冷量</span><input type="text" value="<%=commodity.getCold_amount()%>" name="cold_amount"></div>
                    <div><span>制热功率</span><input type="text" value="<%=commodity.getHot_power()%>" name="hot_power"></div>
                    <div><span>制热量</span><input type="text" value="<%=commodity.getHot_amount()%>" name="hot_amount"></div> 
                    <div><span>外机包装尺寸</span><input type="text" value="<%=commodity.getOut_pack_size()%>" name="out_pack_size"></div>
                    <div><span>外机堆码层数极限</span><input type="text" value="<%=commodity.getOut_plies_max()%>" name="out_plies_max"></div>
                    <div><span>外机尺寸</span><input type="text" value="<%=commodity.getOut_size()%>" name="out_size"></div>
                    <div><span>外机毛重</span><input type="text" value="<%=commodity.getOut_weight()%>" name="out_weight"></div>
                    <div><span>室内机噪音</span><input type="text" value="<%=commodity.getIndoor_noise()%>" name="indoor_noise"></div>
                    <div><span>室外机噪音</span><input type="text" value="<%=commodity.getOutdoor_noise()%>" name="outdoor_noise"></div>
                    <div><span>智能类型</span><input type="text" value="<%=commodity.getSmart_type()%>" name="smart_type"></div>
                    <div><span>加热功率电辅</span><input type="text" value="<%=commodity.getHeating_power()%>" name="heating_power"></div>
                    <div><span>空调面板颜色</span><input type="text" value="<%=commodity.getAir_board_color()%>" name="air_board_color"></div>
                    <div><span>能效备案号</span><input type="text" value="<%=commodity.getEfficiency_number()%>" name="efficiency_number"></div>
                    <div><span>空调类型</span><input type="text" value="<%=commodity.getAir_type()%>" name="air_type"></div>
                    <div><span>冷暖类型</span><input type="text" value="<%=commodity.getTemperature_type()%>" name="temperature_type"></div>
                    <div><span>空调功率</span><input type="text" value="<%=commodity.getAir_power()%>" name="air_power"></div>
                    <div><span>适用面积</span><input type="text" value="<%=commodity.getSuit_area()%>" name="suit_area"></div>
                    <div><span>售后服务</span><input type="text" value="<%=commodity.getCustomer_service()%>" name="customer_service"></div>
                    <div><span>工作方式</span><input type="text" value="<%=commodity.getWork_method()%>" name="work_method"></div>
                    <div><span>能效等级</span><input type="text" value="<%=commodity.getPower_level()%>" name="power_level"></div>
                    <div><span>是否循环风量</span><input type="text" value="<%=commodity.getWind_refresh_yes_or_not()%>" name="wind_refresh_yes_or_not"></div>
                    <div><span>室外净机质量</span><input type="text" value="<%=commodity.getOut_net_weight()%>" name="out_net_weight"></div>
                    <div><span>室内净机质量</span><input type="text" value="<%=commodity.getInsert_net_weight()%>" name="insert_net_weight"></div>
                </ul>
            </li>
            <li>
            
                <span>商品详情</span>
                <div class="newG_xiangqing">
                    <textarea name="commodity_details"><%=commodity.getCommodity_details()%></textarea>
                    <div class="newG_xiangqingimg">
                        <div class="newG_imgk2">
                            <div id="redface" class="floatl preview">
                                <img src="../img/img/img1.png" alt=""  id="preview2">
                            </div>
                            <input class="upimg" type="file" name="detaile_picture" id="doc2" onchange="javascript:setImagePreview2();">
                        </div>
                        <div class="newG_imgk3">
                            <div id="redface" class="floatl preview">
                                <img src="../img/img/img1.png" alt=""  id="preview3">
                            </div>
                            <input class="upimg" type="file" name="detaile_picture" id="doc3" onchange="javascript:setImagePreview3();">
                        </div>
                        <div class="newG_imgk4">
                            <div id="redface" class="floatl preview">
                                <img src="../img/img/img1.png" alt=""  id="preview4">
                            </div>
                            <input class="upimg" type="file" name="detaile_picture" id="doc4" onchange="javascript:setImagePreview4();">
                        </div>
                    </div>

                </div>
            </li>
        </ul>
    </div>
    <div class="newG_divfooter">
        <div class="newG_divfooter1">
            <input type="button" value="返回"/>
              <input type="submit" value="保存"/>
            </form>
            <input type="button" value="取消" onclick="window.location.href='../backageController/commodityMannagement.do'"/>
           
        </div>
    </div>
</div>

</body>
</html>
<<script type="text/javascript">
function getObjectURL(file){
	  var url = null;
	  if(window.createObjectURL != undefined){
	    url = window.createObjectURL(file);//basic
	  }else if(window.URL != undefined){
	    url = window.URL.createObjectURL(file);
	  }else if(window.webkitURL != undefined){
	    url = window.webkitURL.createObjectURL(file);
	  }
	 
	  return url;
	}
	//实现功能代码
	$(function(){
	  $("#browerfile").change(function(){
	    var path = browerfile.value;
	    var objUrl = getObjectURL(this.files[0]);
	    if(objUrl){
	      $('.img1-img').attr("src",objUrl);
	    }
	  })
	})
	
	
	
function fun2(data){/* alert("进入fun2"); */}
function fun3(data){/* alert("进入fun3"); */}
function fun4(data){
	
	alert("进入fun4");
	$.ajax({
		url:"../commodity/updateCommodityUse_type.do",
		type:"post",
		data:{"c_id":data,"use_type":0},
		success:function(){
					
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
	}); 	
	
	
	
	
	}
function fun5(data){


	$.ajax({
		url:"../commodity/updateCommodityUse_type.do",
		type:"post",
		data:{"c_id":data,"use_type":1},
		success:function(){
					
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
	}); 	

}
function fun6(data){
	$.ajax({
		url:"../commodity/updateCommodityUse_type.do",
		type:"post",
		data:{"c_id":data,"use_type":2},
		success:function(){
					
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
	}); 	
	}
</script>

<script type="text/javascript" src="../js/upload1.js"></script>
<script>
    $('.newG_kontiaotype2 div').click(function () {
        var newG_kontiaotypeContent= $(this).html();
        $('.newG_namekongtiao').text(newG_kontiaotypeContent);
        $('.newG_kontiaotype2').css('display','none');
    })
    $('.newG_kontiaotype').click(function(){
        $('.newG_kontiaotype2').css('display','block');
    })
    
    
    
</script>