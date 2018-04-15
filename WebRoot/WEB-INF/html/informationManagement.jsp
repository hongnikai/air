<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>信息管理</title>
    <link rel="stylesheet" type="text/css" href="../css/css.css">
    <script type="text/javascript" src="../js/jquery-3.1.0.min.js"></script>
    <script type="text/javascript" src="../js/upload.js"></script>
</head>
<body>
<div class="informationM_all">
    <div class="informationM_divheader">
        <div class="informationM_divheader1">
            <input type="button" value="首页公告"/>
            <input type="button" value="广告图"/>
        </div>
    </div>
    <div class="informationM_divcontent">
        <div class="informationM_divcontentdiv1">
            <header>
                <span>编辑内容</span>
            </header>
            <textarea disabled="disabled" id="neirong">我要发送心愿贺卡，很高兴在这里祝大家新年快乐</textarea>
            <div class="informationM_bianjidiv">
                <button type="button" onclick="add()">保存</button>
                <button type="button" class="delete">删除</button>
                <span class="exit">编辑</span>
            </div>
        </div>

        <div class="informationM_divcontentdiv2">
            <header>
                <span>首页轮播图</span>
            </header>
            <article>
                <section>
                <form action="../lc/sysdata/uploadSystemBanners.do" method="post" enctype="multipart/form-data">
                    <div class="informationM_ContentMid1">
                        <div class="informationM_ContentMid1-imgk">
                            <div id="redface1" class="floatl preview">
                                <img src="../img/img/01.png" alt="" id="preview1">
                            </div>
                            <input class="upimg" type="file" name="file" id="doc1" required="true"
                                   onchange="javascript:setImagePreview1();"/>
                            <span class="informationM_uploadspan">上传</span>
                        </div>
                    </div>
                </section>
                <section>
                    <div class="informationM_ContentMid1">
                        <div class="informationM_ContentMid1-imgk">
                            <div id="redface1" class="floatl preview">
                                <img src="../img/img/02.png" alt="" id="preview2">
                            </div>
                            <input class="upimg" type="file" name="file" id="doc2" required="true"
                                   onchange="javascript:setImagePreview2();"/>
                            <span class="informationM_uploadspan">上传</span>
                        </div>
                    </div>
                </section>
                <section>
                    <div class="informationM_ContentMid1">
                        <div class="informationM_ContentMid1-imgk">
                            <div id="redface1" class="floatl preview">
                                <img src="../img/img/03.png" alt="" id="preview3">
                            </div>
                            <input class="upimg" type="file" name="file" id="doc3" required="true"
                                   onchange="javascript:setImagePreview3();"/>
                            <span class="informationM_uploadspan">上传</span>
                        </div>

                    </div>
                </section>
            </article>
            <input type="submit" value="确定" class="informationM_surebtn"/>
            </form>
        </div>
    </div>
</div>

</body>
</html>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:"../lc/sysdata/getSystemNotice.do",
		type:"post",
		success:function(data){
					$("#neirong").val(data.object);
			},
		dataType:"json",
		error: function(msg){
			alert("哎呀网络开小差了，稍等会吧！");
			console.log("网络请求异常: 错误信息-----> " + JSON.stringify(msg));
		},
		async:false
	}); 	
	
	
	
})



</script>
<script>
    $('.informationM_divheader1 input').eq(0).addClass("informationM_active");
    $('.informationM_divheader1 input').click(function(){
        $(this).addClass("informationM_active").siblings().removeClass('informationM_active');
    });

    $('.informationM_divheader1 input').eq(0).click(function(){
        $(".informationM_divcontentdiv1").css('display',"block");
        $(".informationM_divcontentdiv2").css('display',"none");
    });
    $('.informationM_divheader1 input').eq(1).click(function(){
        $(".informationM_divcontentdiv1").css('display',"none");
        $(".informationM_divcontentdiv2").css('display',"block");
    });






    /*弹框的选择*/
    $(".informationM_chooseul li").eq(0).find("input").addClass("informationM_tanactive");
    $(".informationM_chooseul li").click(function(){
        $(this).find("input").addClass("informationM_tanactive");
    $(this).siblings().find("input").removeClass("informationM_tanactive");
    });
    /*编辑*/
    $('.exit').click(function(){
        $('textarea').attr('disabled',false).focus();
    });

        /*删除*/
        $('.delete').click(function(){
            $('textarea').html("").attr('disabled',false).focus();
        });
        
        function add(){
        	var neirong=$("#neirong").val();
          alert("进入保存方法");
          window.location.href="../lc/sysdata/uploadSystemNotice.do?neirong="+neirong;
        }
        
        
</script>
