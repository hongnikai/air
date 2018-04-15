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
    <form action="../backageController/targetAddNewCommoditys.do" method="post" enctype="multipart/form-data">
   
    <div class="newG_content">
        <ul class="newG_content_ul1">
            <li>
                <span>商品名称</span>
                       <a></a> 
                  <input value="" name="c_id" style="display: none">      
                <input type="text" class="newG_input1" value="" name="c_name"/>
                 
            </li>
            <li>
                <span>商品图片</span>
                <div class="newG_imgk1">
                    <div id="redface" class="floatl preview">
                        <img src="" alt=""  id="preview1" class="img1-img">
                        <input type="button" class="btn" onclick="browerfile.click()" value="上传">
  				   		<input type="file" id="browerfile" name="cover_picture" style="display: none;" class="test">
                    </div>
                </div>
            </li>
               
            <li><span>价格</span><input type="number" required="true" placeholder="请输入价格" class="newG_input2" value="" name="price"/><em>元</em></li>
            <li><span>品牌型号</span><input type="text" class="newG_input1"/ value="" name="brand"></li>
            <li class="aaaaaanewG">
                <span>用途分类</span>
                <div class="newG_kontiaotypeall">
                    <div class="newG_kontiaotype">
                           <i class="newG_namekongtiao">家用分体式空调</i>
                    </div>
                    <div class="newG_kontiaotype2">
                        <div onclick="fun1()">家用分体空调</div>
                        <div onclick="fun2()">家用中央空调</div>
                        <div onclick="fun3()">商用中央空调</div>
                    </div>
                    <input id="condition_type" type="text" value="0"  style="display: none;"/>
                </div>
            </li>
            <li>
            
                <span>商品参数</span>
                <ul class="newG_content_ul2">
                    <div><span>上市时间</span><input type="date" name="create_time" required="true"/></div>
                    <div><span>保修期</span><input type="date" name="repair_time" required="true"></div>
                    <div><span>内机包装尺寸</span><input type="text" value="" name="insert_pack_size" required="true"></div>
                    <div><span>内机堆码层数极限</span><input type="text" value="" name="insert_plies_max"></div>
                    <div><span>内机毛重</span><input type="text" value="" name="insert_weight"></div>
                    <div><span>内机尺寸</span><input type="text" value="" name="insert_size"></div>
                    <div><span>制冷功率</span><input type="text" value="" name="cold_power"></div>
                    <div><span>制冷量</span><input type="text" value="" name="cold_amount"></div>
                    <div><span>制热功率</span><input type="text" value="" name="hot_power"></div>
                    <div><span>制热量</span><input type="text" value="" name="hot_amount"></div> 
                    <div><span>外机包装尺寸</span><input type="text" value="" name="out_pack_size"></div>
                    <div><span>外机堆码层数极限</span><input type="text" value="" name="out_plies_max"></div>
                    <div><span>外机尺寸</span><input type="text" value="" name="out_size"></div>
                    <div><span>外机毛重</span><input type="text" value="" name="out_weight"></div>
                    <div><span>室内机噪音</span><input type="text" value="" name="indoor_noise"></div>
                    <div><span>室外机噪音</span><input type="text" value="" name="outdoor_noise"></div>
                    <div><span>智能类型</span><input type="text" value="" name="smart_type"></div>
                    <div><span>加热功率电辅</span><input type="text" value="" name="heating_power"></div>
                    <div><span>空调面板颜色</span><input type="text" value="" name="air_board_color"></div>
                    <div><span>能效备案号</span><input type="text" value="" name="efficiency_number"></div>
                    <div><span>空调类型</span><input type="text" value="" name="air_type"></div>
                    <div><span>冷暖类型</span><input type="text" value="" name="temperature_type"></div>
                    <div><span>空调功率</span><input type="text" value="" name="air_power"></div>
                    <div><span>适用面积</span><input type="text" value="" name="suit_area"></div>
                    <div><span>售后服务</span><input type="text" value="" name="customer_service"></div>
                    <div><span>工作方式</span><input type="text" value="" name="work_method"></div>
                    <div><span>能效等级</span><input type="text" value="" name="power_level"></div>
                    <div><span>是否循环风量</span><input type="text" value="" name="wind_refresh_yes_or_not"></div>
                    <div><span>室外净机质量</span><input type="text" value="" name="out_net_weight"></div>
                    <div><span>室内净机质量</span><input type="text" value="" name="insert_net_weight"></div>
                </ul>
            </li>
            <li>
            
                <span>商品详情</span>
                <div class="newG_xiangqing">
                    <textarea name="commodity_details"></textarea>
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
<script type="text/javascript">
function fun1(){
	$("#condition_type").val(0);
}
function fun2(){
	$("#condition_type").val(1);
}
function fun3(){
	$("#condition_type").val(2);
}




</script>

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