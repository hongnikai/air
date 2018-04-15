$(function() {
	function setCookie(name, value, time) {
		var strsec = getsec(time);
		var exp = new Date();
		exp.setTime(exp.getTime() + strsec * 1);
		document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
	}

	function getsec(str) {
		console.log(str);
		var str1 = str.substring(1, str.length) * 1;
		var str2 = str.substring(0, 1);
		if(str2 == "s") {
			return str1 * 1000;
		} else if(str2 == "h") {
			return str1 * 60 * 60 * 1000;
		} else if(str2 == "d") {
			return str1 * 24 * 60 * 60 * 1000;
		}
	}
	//读取cookies 
	function getCookie(name) {
		var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");

		if(arr = document.cookie.match(reg))

			return unescape(arr[2]);
		else
			return null;
	}
})
//var method = {
//				//设置cookie
//				setCookie: function(c_name, value, expiredays) {
//					var exdate = new Date()
//					exdate.setTime(Number(exdate.getTime()) + Number(expiredays))
//					document.cookie = c_name + "=" + escape(value) +
//						((expiredays == null) ? "" : ";expires=" + exdate.toGMTString())
//				},
//				//获取cookie
//				getCookie: function(c_name) {
//					if(document.cookie.length > 0) {
//						c_start = document.cookie.indexOf(c_name + "=")
//						if(c_start != -1) {
//							c_start = c_start + c_name.length + 1
//							c_end = document.cookie.indexOf(";", c_start)
//							if(c_end == -1) c_end = document.cookie.length
//							return unescape(document.cookie.substring(c_start, c_end))
//						}
//					}
//					return ""
//				}
//			}