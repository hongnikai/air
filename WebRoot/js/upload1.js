// JavaScript Document
//下面用于图片上传预览功能
function setImagePreview1(avalue) {
    var docObj = document.getElementById("doc1");
    var imgObjPreview = document.getElementById("preview1");
    if (docObj.files && docObj.files[0]) {
//火狐下，直接设img属性
        imgObjPreview.style.display = 'block';
        imgObjPreview.style.width = '100%';
        imgObjPreview.style.height = '100%';
//imgObjPreview.src = docObj.files[0].getAsDataURL();

//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
        imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
    }
    else {
//IE下，使用滤镜
        docObj.select();
        var imgSrc = document.selection.createRange().text;
        var localImagId = document.getElementById("redface");
//必须设置初始大小
        localImagId.style.width = "200px";
        localImagId.style.height = "200px";
//图片异常的捕捉，防止用户修改后缀来伪造图片
        try {
            localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
        }
        catch (e) {
            alert("您上传的图片格式不正确，请重新选择!");
            return false;
        }
        imgObjPreview.style.display = 'block';
        document.selection.empty();
    }
    return true;
}
function setImagePreview2(avalue) {
    var docObj = document.getElementById("doc2");

    var imgObjPreview = document.getElementById("preview2");
    if (docObj.files && docObj.files[0]) {
//火狐下，直接设img属性
        imgObjPreview.style.display = 'block';
        imgObjPreview.style.width = '100%';
        imgObjPreview.style.height = '100%';
//imgObjPreview.src = docObj.files[0].getAsDataURL();

//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
        imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
    }
    else {
//IE下，使用滤镜
        docObj.select();
        var imgSrc = document.selection.createRange().text;
        var localImagId = document.getElementById("reddetails");
//必须设置初始大小
        localImagId.style.width = "600px";
        localImagId.style.height = "500px";
//图片异常的捕捉，防止用户修改后缀来伪造图片
        try {
            localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
        }
        catch (e) {
            alert("您上传的图片格式不正确，请重新选择!");
            return false;
        }
        imgObjPreview.style.display = 'block';
        document.selection.empty();
    }
    return true;
}

function setImagePreview3(avalue) {
    var docObj = document.getElementById("doc3");

    var imgObjPreview = document.getElementById("preview3");
    if (docObj.files && docObj.files[0]) {
//火狐下，直接设img属性
        imgObjPreview.style.display = 'block';
        imgObjPreview.style.width = '100%';
        imgObjPreview.style.height = '100%';
//imgObjPreview.src = docObj.files[0].getAsDataURL();

//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
        imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
    }
    else {
//IE下，使用滤镜
        docObj.select();
        var imgSrc = document.selection.createRange().text;
        var localImagId = document.getElementById("reddetails");
//必须设置初始大小
        localImagId.style.width = "600px";
        localImagId.style.height = "500px";
//图片异常的捕捉，防止用户修改后缀来伪造图片
        try {
            localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
        }
        catch (e) {
            alert("您上传的图片格式不正确，请重新选择!");
            return false;
        }
        imgObjPreview.style.display = 'block';
        document.selection.empty();
    }
    return true;
}

function setImagePreview4(avalue) {
    var docObj = document.getElementById("doc4");

    var imgObjPreview = document.getElementById("preview4");
    if (docObj.files && docObj.files[0]) {
//火狐下，直接设img属性
        imgObjPreview.style.display = 'block';
        imgObjPreview.style.width = '100%';
        imgObjPreview.style.height = '100%';
//imgObjPreview.src = docObj.files[0].getAsDataURL();

//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
        imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
    }
    else {
//IE下，使用滤镜
        docObj.select();
        var imgSrc = document.selection.createRange().text;
        var localImagId = document.getElementById("reddetails");
//必须设置初始大小
        localImagId.style.width = "600px";
        localImagId.style.height = "500px";
//图片异常的捕捉，防止用户修改后缀来伪造图片
        try {
            localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
        }
        catch (e) {
            alert("您上传的图片格式不正确，请重新选择!");
            return false;
        }
        imgObjPreview.style.display = 'block';
        document.selection.empty();
    }
    return true;
}


