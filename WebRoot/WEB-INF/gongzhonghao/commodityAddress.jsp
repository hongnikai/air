<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=0,minimum-scale=1.0,maximum-scale=1.0" />
		<link rel="stylesheet" type="text/css" href="../css/air.css" />
		<title>编辑地址</title>
	</head>

	<body class="bgcGray">
		<header class="header">
			<a href="javascript:history.back()"><img src="../img/icon_back@2x.png" /></a>
			<center>编辑地址</center>
		</header>
		<form action="../commodity/createGongZhongHaoAddress.do">
				
		<div class="orderCon mT6">
			<section class="orderBox paddingTB0">
				<ul class="addrEdit">
					<input type="text" value="${commodity.c_id}" name="c_id" />
					<input type="text" value="${au_id}" name="au_id" style="display: none;"/>
					<li><span>收货人</span><input type="text" name="name" required="required"/></li>
					<li><span>联系电话</span><input type="text" name="mobile" required="required"/></li>
					<li><span>所在地区</span><input type="text" style="float: none;" id="demo2" name="province" required="required"/><a class="right-icon" id="right-icon"><img class="littlePic" src="../img/icon_in@2x.png"/></a></li>
					<li><span>详细地址</span><input type="text" name="detail" required="required"/></li>
				</ul>
			</section>
			<input type="submit" class="longBtn" value="保存" />
		</div>
		</form>
		<script type="text/javascript" src="../js/jquery.js"></script>
		<script src="../js/picker.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="../js/city.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var nameEl = document.getElementById('right-icon');
			var ipt = document.getElementById("demo2");
			var first = []; /* 省，直辖市 */
			var second = []; /* 市 */
			var third = []; /* 镇 */

			var selectedIndex = [0, 0, 0]; /* 默认选中的地区 */

			var checked = [0, 0, 0]; /* 已选选项 */

			function creatList(obj, list) {
				obj.forEach(function(item, index, arr) {
					var temp = new Object();
					temp.text = item.name;
					temp.value = index;
					list.push(temp);
				})
			}

			creatList(city, first);

			if(city[selectedIndex[0]].hasOwnProperty('sub')) {
				creatList(city[selectedIndex[0]].sub, second);
			} else {
				second = [{
					text: '',
					value: 0
				}];
			}

			if(city[selectedIndex[0]].sub[selectedIndex[1]].hasOwnProperty('sub')) {
				creatList(city[selectedIndex[0]].sub[selectedIndex[1]].sub, third);
			} else {
				third = [{
					text: '',
					value: 0
				}];
			}

			var picker = new Picker({
				data: [first, second, third],
				selectedIndex: selectedIndex,
				title: '地址选择'
			});

			picker.on('picker.select', function(selectedVal, selectedIndex) {
				var text1 = first[selectedIndex[0]].text;
				var text2 = second[selectedIndex[1]].text;
				var text3 = third[selectedIndex[2]] ? third[selectedIndex[2]].text : '';

				ipt.value = text1 + ' ' + text2 + ' ' + text3;
			});

			picker.on('picker.change', function(index, selectedIndex) {
				if(index === 0) {
					firstChange();
				} else if(index === 1) {
					secondChange();
				}

				function firstChange() {
					second = [];
					third = [];
					checked[0] = selectedIndex;
					var firstCity = city[selectedIndex];
					if(firstCity.hasOwnProperty('sub')) {
						creatList(firstCity.sub, second);

						var secondCity = city[selectedIndex].sub[0]
						if(secondCity.hasOwnProperty('sub')) {
							creatList(secondCity.sub, third);
						} else {
							third = [{
								text: '',
								value: 0
							}];
							checked[2] = 0;
						}
					} else {
						second = [{
							text: '',
							value: 0
						}];
						third = [{
							text: '',
							value: 0
						}];
						checked[1] = 0;
						checked[2] = 0;
					}

					picker.refillColumn(1, second);
					picker.refillColumn(2, third);
					picker.scrollColumn(1, 0)
					picker.scrollColumn(2, 0)
				}

				function secondChange() {
					third = [];
					checked[1] = selectedIndex;
					var first_index = checked[0];
					if(city[first_index].sub[selectedIndex].hasOwnProperty('sub')) {
						var secondCity = city[first_index].sub[selectedIndex];
						creatList(secondCity.sub, third);
						picker.refillColumn(2, third);
						picker.scrollColumn(2, 0)
					} else {
						third = [{
							text: '',
							value: 0
						}];
						checked[2] = 0;
						picker.refillColumn(2, third);
						picker.scrollColumn(2, 0)
					}
				}

			});

			picker.on('picker.valuechange', function(selectedVal, selectedIndex) {
				console.log(selectedVal);
				console.log(selectedIndex);
			});

			nameEl.addEventListener('click', function() {
				picker.show();
			});
		</script>
	</body>

</html>
