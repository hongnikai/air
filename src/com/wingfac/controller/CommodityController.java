package com.wingfac.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.ibatis.annotations.Param;
import org.junit.runner.Request;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wingfac.entity.Address;
import com.wingfac.entity.Commodity;
import com.wingfac.entity.CommodityEvaluate;
import com.wingfac.entity.CommodityOrder;
import com.wingfac.entity.CommoditySaleCounts_resultBean;
import com.wingfac.entity.Store;
import com.wingfac.entity.User;
import com.wingfac.service.CommodityEvaluateService;
import com.wingfac.service.CommodityOrderService;
import com.wingfac.service.CommodityService;
import com.wingfac.service.CommonService;
import com.wingfac.service.DataService;
import com.wingfac.service.StoreService;
import com.wingfac.service.UserService;
import com.wingfac.util.Constants;
import com.wingfac.util.LocalResponseBody;
import com.wingfac.util.RandomUtil;
import com.wingfac.util.ResponseSuccessOrFail;
import com.wingfac.util.TimeUtil;
import com.wingfac.util.UploadUtil;
import com.wingfac.util.lcRamdomUtil;

/**
 *  @描述：商品Controller
 ** @author LC   
 *  创建时间：2018-2-6 下午15:38
 */
@Controller
@Scope(value="prototype")
@RequestMapping("commodity")
public class CommodityController{

	@Resource(name="commodityService")
	private CommodityService commodityService;
	
	@Resource(name="storeService")
	private StoreService storeService;
	
	@Resource(name="commodityOrderService")
	private CommodityOrderService commodityOrderService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="commodityEvaluateService")
	private CommodityEvaluateService commodityEvaluateService;
	
	@Resource(name="dataService")
	private DataService dataService;
	
	@Resource(name="commonService")
	private CommonService commonservice;
	
	/**
	 * @描述：新建商品
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/insertCommodity_Messages")
	@ResponseBody
	public LocalResponseBody insertCommodity_Messages(HttpServletRequest request,HttpServletResponse response,
										   @RequestParam(value="name",required=false,defaultValue="格力空调")String name,
										   @RequestParam(value="price",required=false,defaultValue="0.0")double price,
										   @RequestParam(value="brand",required=false,defaultValue="格力")String brand,
										   @RequestParam(value="usetype",required=false,defaultValue="0")int use_type,
										   @RequestParam(value="createtime",required=false,defaultValue="0")String create_time,
										   @RequestParam(value="repairtime",required=false,defaultValue="0天")String repair_time,
										   @RequestParam(value="insertPackSize",required=false,defaultValue="内机包装尺寸")String insert__pack_size,
										   @RequestParam(value="insertPilesMax",required=false,defaultValue="内机堆码层数极限")String insert_plies_max,
										   @RequestParam(value="insertWeight",required=false,defaultValue="内机毛重")String insert_weight,
										   @RequestParam(value="insertSize",required=false,defaultValue="内机尺寸")String insert_size,
										   @RequestParam(value="coldpower",required=false,defaultValue="制冷功率")String cold_power,
										   @RequestParam(value="coldamount",required=false,defaultValue="制冷量")String cold_amount,
										   @RequestParam(value="outpacksize",required=false,defaultValue="外机包装尺寸")String out_pack_size,
										   @RequestParam(value="outpliesmax",required=false,defaultValue="外机堆码层数极限")String out_plies_max,
										   @RequestParam(value="outsize",required=false,defaultValue="外机尺寸")String out_size,
										   @RequestParam(value="outweight",required=false,defaultValue="外机毛重")String out_weight,
										   @RequestParam(value="indoorNoise",required=false,defaultValue="室内机噪音")String indoor_noise,
										   @RequestParam(value="outDoorNoise",required=false,defaultValue="室外机噪音")String outdoor_noise,
										   @RequestParam(value="smartType",required=false,defaultValue="智能类型")String smart_type,
										   @RequestParam(value="heatingPower",required=false,defaultValue="电辅加热功率")String heating_power,
										   @RequestParam(value="airboardColor",required=false,defaultValue="空调面板颜色")String air_board_color,
										   @RequestParam(value="efficiencyNumber",required=false,defaultValue="能效备案号")String efficiency_number,
										   @RequestParam(value="airtype",required=false,defaultValue="空调类型")String air_type,
										   @RequestParam(value="temperatureType",required=false,defaultValue="冷暖类型")String temperature_type,
										   @RequestParam(value="airpower",required=false,defaultValue="空调功率")String air_power,
										   @RequestParam(value="suitarea",required=false,defaultValue="适用面积")String suit_area,
										   @RequestParam(value="customerService",required=false,defaultValue="售后服务")String customer_service,
										   @RequestParam(value="workmethod",required=false,defaultValue="工作方式")String work_method,
										   @RequestParam(value="powerlevel",required=false,defaultValue="能效等级")String power_level,
										   @RequestParam(value="windRefreshYesOrNot",required=false,defaultValue="是否循环风量")String wind_refresh_yes_or_not,
										   @RequestParam(value="outNetWeight",required=false,defaultValue="室外净机重量")String out_net_weight,
										   @RequestParam(value="insertNetWeight",required=false,defaultValue="室内净机重量")String insert_net_weight,
										   @RequestParam(value="commoditydetails",required=false,defaultValue="商品详情(文字内容)")String commodity_details
										   ){
		HttpSession session = request.getSession();
		Object auId=session.getAttribute("userId");
		String au_id=auId.toString();
		
		List<Store> list=storeService.select_storeByauId(au_id);//根据登录存储session中的用户信息,查取用户店铺信息
		int s_id=list.get(0).getS_id();
		
		Map<String,Object> map=new HashMap<String,Object>();	//查询map
		
		RandomUtil r=new RandomUtil();
		String c_id=r.getEightRandom();
		
		System.out.println(c_id+"******************");
		
		try {
		map.put("c_id", c_id);
		map.put("s_id", s_id);
		map.put("name", name);
		map.put("price", price);
		map.put("brand", brand);
		map.put("use_type", use_type);
		map.put("create_time", create_time);
		map.put("repair_time", repair_time);
		map.put("insert__pack_size", insert__pack_size);
		map.put("insert_plies_max", insert_plies_max);
		map.put("insert_weight", insert_weight);
		map.put("insert_size", insert_size);
		map.put("cold_power", cold_power);
		map.put("cold_amount", cold_amount);
		map.put("out_pack_size",out_pack_size);
		map.put("out_plies_max", out_plies_max);
		map.put("out_size", out_size);
		map.put("out_weight", out_weight);
		map.put("indoor_noise", indoor_noise);
		map.put("outdoor_noise", outdoor_noise);
		map.put("smart_type", smart_type);
		map.put("heating_power", heating_power);
		map.put("air_board_color", air_board_color);
		map.put("efficiency_number", efficiency_number);
		map.put("air_type",air_type);
		map.put("temperature_type", temperature_type);
		map.put("air_power", air_power);
		map.put("suit_area", suit_area);
		map.put("customer_service", customer_service);
		map.put("work_method", work_method);
		map.put("power_level", power_level);
		map.put("wind_refresh_yes_or_not", wind_refresh_yes_or_not);
		map.put("out_net_weight", out_net_weight);
		map.put("insert_net_weight", insert_net_weight);
		map.put("commodity_details", commodity_details);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		    System.out.println("数字转换异常捕捉:***************************让人难受的异常");
		    System.out.println("这个异常可能是:Integer.parseInt(str);");
		    System.out.println("也可能是:map/破逼数据太多");
		}
		commodityService.insertCommodity_Messages(map);
		LocalResponseBody localResponseBody=new LocalResponseBody();
		return localResponseBody.doSuccess("耶耶耶");
	}
	
	/**
	 * @描述:根据筛选条件查询商品
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectCommodityByscreen")
	@ResponseBody
	public Object selectCommodityByscreen(HttpServletRequest request,HttpServletResponse response,
										@RequestParam(value="brand",required=false,defaultValue="格力")String brand,
										@RequestParam(value="usetype",required=false,defaultValue="0")int use_type,//空调种类
										@RequestParam(value="type",required=false,defaultValue="0")int type,//分类
										@RequestParam(value="frequency",required=false,defaultValue="0")int frequency,//频率
										@RequestParam(value="level",required=false,defaultValue="1匹")String level//功率
										){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("brand", brand);
		map.put("use_type", use_type);
		map.put("type", type);
		map.put("frequency", frequency);
		map.put("level", level);
		List<Commodity> list=commodityService.selectCommodityByscreen(map);
		if(list.size()<1){
			return new ResponseSuccessOrFail("响应失败","没有符合条件的商品");
		}
		return new ResponseSuccessOrFail("响应成功", list);
	}
	
	/**
	 * @描述:个人店铺宝贝详情
	 * @param  mark //初始为0//价格降序为1//价格升序为2//销量降序为3//销量降序为4
	 * @return ResponseSuccessOrFail
	 */
	@RequestMapping(value = "/selectCommodity")
	public String selectCommodity(HttpServletResponse response,HttpServletRequest request,
										@RequestParam(value="mark",defaultValue="0",required=false)String mark){
			List<Map<String,Object>> commodity=commodityService.selectCommodityNotCentralAirCondition();
			request.setAttribute("commodity", commodity);
			return "/gongzhonghao/commodityShop.jsp";
	}
	
	/**
	 * @描述:  查询商品价格排列方式数据
	 * @param  mark	//初始为0//价格降序为1//价格升序为2//销量降序为3//销量降序为4
	 * @return ResponseSuccessOrFail
	 */
	@RequestMapping("/selectCommodityByMark")
	@ResponseBody
	public Object selectCommodityByMark(@RequestParam("mark")int mark){
		if(mark==1){//价格降序为1
			List<Commodity> list=commodityService.selectCommodityNotCentralAirConditionAsc();
			return list;
		}else if(mark==2){//价格升序为2
			List<Commodity> list=commodityService.selectCommodityNotCentralAirConditionDesc();
			return list;
		}else if(mark==3){//销量降序为3
			List<CommoditySaleCounts_resultBean> list=commodityService.selectCommodiyBySaleCountsNotCentralAirConditionDesc();
			return list;
		}else if(mark==4){//销量升序为4
			List<CommoditySaleCounts_resultBean> list=commodityService.selectCommodityBySaleCountsNotCentralAirConditionAsc();
			return list;
		}else{}
		
		return "";
	}
	
	
	/**
	 * @描述: 根据商品标识获取商品详情
	 * @param  c_id
	 * @return ResponseSuccessOrFail
	 */
	@RequestMapping(value = "/selectCommodityByc_id")
	@ResponseBody
	public ResponseSuccessOrFail selectCommodityByc_id(HttpServletResponse response,HttpServletRequest request,
									@RequestParam(value="c_id",defaultValue="0",required=false)String c_id
									){
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		if(commodity==null){
			new ResponseSuccessOrFail("FAIL", "未知的错误");
		}
		return new ResponseSuccessOrFail("回调数据", commodity);
	}
	
	/**
	 * @描述:热销的四个商品
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectHotCommodity")
	@ResponseBody
	public ResponseSuccessOrFail selectHotCommodity(){
		List<CommoditySaleCounts_resultBean> list=commodityService.selectFourHotCommodity();
		if(list.size()<1){
			return new ResponseSuccessOrFail("FAILE", "未知的错误");
		}
		return new ResponseSuccessOrFail("SUCCESS",list);
	}
	
	/**
	 * @描述:查询热销的所有商品
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectAllHotCommodity")
	@ResponseBody
	public ResponseSuccessOrFail selectAllHotCommodity(){
		List<CommoditySaleCounts_resultBean> list=commodityService.selectCommodityBySaleCountsDesc();
		if(list.size()<1){
			return new ResponseSuccessOrFail("FAILE", "未知的错误");
		}
		return new ResponseSuccessOrFail("SUCCESS",list);
	}
	
	
	/**
	 * @描述:根据商品获取所有评价
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/getCommodityEvaBycId")
	@ResponseBody
	public ResponseSuccessOrFail getCommodityEvaBycId(HttpServletRequest request,HttpServletResponse response,
									@RequestParam(value="cId",required=true)String c_id
									){
		List<Map<String,Object>> list=commodityService.selectEvaluateBycId(c_id);
		if(list.size()<1){
			return new ResponseSuccessOrFail("FAIL", "查询失败");
		}
		return new ResponseSuccessOrFail("SUCCESS", list);
	}
	
	
	//==============================================后台管理开始==============================================//
	
	
	/**
	 * @描述:个人店铺宝贝详情
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectStoreGoods")
	@ResponseBody
	public Object selectStoreGoods(HttpServletRequest request,
											 HttpServletResponse response,
											 @RequestParam(value="auId",required=false,defaultValue="123123")String auId 
											){
		HttpSession session = request.getSession();
		Object obj=session.getAttribute("userId");
		if(obj==null){
			List<Commodity> list=commodityService.selectStoreGoodsByauId(auId);
			if(list.isEmpty()){
				return "没有数据";
			}else{
				return new LocalResponseBody<Object>(Constants.SUCCESS,"响应成功",list);
			}
		}else{
			List<Commodity> list=commodityService.selectStoreGoodsByauId(obj.toString());
			if(list.isEmpty()){
				return "没有数据";
			}else{
				return new LocalResponseBody<Object>(Constants.SUCCESS,"响应成功",list);
			}
		}
	}
	

	/**
	 * @描述:个人店铺宝贝详情
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/updateNewGoods")
	public String updateNewGoods(HttpServletRequest request,HttpServletResponse response,
							@RequestParam(value="c_id",required=true)String c_id, 
							@RequestParam(value="c_name",required=false)String c_name,
							@RequestParam(value="cover_picture",required=false)MultipartFile[] file,
							@RequestParam(value="detaile_picture",required=false)MultipartFile[] file2,
							@RequestParam(value="price",required=false)double price,
							@RequestParam(value="brand",required=false,defaultValue="无")String brand,
							@RequestParam(value="creat_time",required=false)String creat_time,
							@RequestParam(value="repair_time",required=false)String repair_time,
							@RequestParam(value="insert_pack_size",required=false)String insert_pack_size,
							@RequestParam(value="insert_plies_max",required=false)String insert_plies_max,
							@RequestParam(value="insert_weight",required=false)String insert_weight,
							@RequestParam(value="insert_size",required=false)String insert_size,
							@RequestParam(value="cold_power",required=false)String cold_power,
							@RequestParam(value="cold_amount",required=false)String cold_amount,
							@RequestParam(value="hot_power",required=false)String hot_power,
							@RequestParam(value="hot_amount",required=false)String hot_amount,
							@RequestParam(value="out_pack_size",required=false)String out_pack_size,
							@RequestParam(value="out_plies_max",required=false)String out_plies_max,
							@RequestParam(value="out_size",required=false)String out_size,
							@RequestParam(value="out_weight",required=false)String out_weight,
							@RequestParam(value="indoor_noise",required=false)String indoor_noise,
							@RequestParam(value="outdoor_noise",required=false)String outdoor_noise,
							@RequestParam(value="smart_type",required=false)String smart_type,
							@RequestParam(value="heating_power",required=false)String heating_power,
							@RequestParam(value="air_board_color",required=false)String air_board_color,
							@RequestParam(value="efficiency_number",required=false)String efficiency_number,
							@RequestParam(value="air_type",required=false)String air_type,
							@RequestParam(value="temperature_type",required=false)String temperature_type,
							@RequestParam(value="air_power",required=false)String air_power,
							@RequestParam(value="suit_area",required=false)String suit_area,
							@RequestParam(value="customer_service",required=false)String customer_service,
							@RequestParam(value="work_method",required=false)String work_method,
							@RequestParam(value="power_level",required=false)String power_level,
							@RequestParam(value="wind_refresh_yes_or_not",required=false)String wind_refresh_yes_or_not,
							@RequestParam(value="out_net_weight",required=false)String out_net_weight,
							@RequestParam(value="insert_net_weight",required=false)String insert_net_weight,
							@RequestParam(value="commodity_details",required=false)String commodity_details
							){
		
		System.out.println(c_name+"回家啊哈哈哈");
		UploadUtil u=new UploadUtil();
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		String path="commodityCoverPic/"+commodity.getC_id();
		
	
		
		String cover_picture=u.uploadFilesToPath(request, file[0], path);	
		if(cover_picture==""||cover_picture==" "){
			System.out.println("上传图片是空的");
		}else{
			System.out.println("居然有图片");
			commodityService.updateCoverPictureBycId(cover_picture, c_id);
		}
		/************************上传详情图片*************************************/
		String detail_path="commodityDetailPic/"+commodity.getC_id();
		String detail_pics=commodity.getDetaile_picture(); 
		String[] pics=detail_pics.split(",");
		
		for (int i = 0; i < file2.length; i++) {
    		String s=u.uploadFilesToPath(request, file2[i], detail_path);	
    		if(s==null||s.equals("")||s.equals(" ")){
    			
    		}else{
    			pics[i]=s;
    		}
    	}
		String str=StringUtils.join(pics, ",");
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("c_id", c_id);
		map.put("c_name", c_name);
		map.put("price", price);
		map.put("brand", brand);
		map.put("creat_time", creat_time);
		map.put("repair_time", repair_time);
		map.put("insert_pack_size", insert_pack_size);
		map.put("insert_plies_max", insert_plies_max);
		map.put("insert_weight", insert_weight);
		map.put("insert_size", insert_size);
		map.put("cold_power", cold_power);
		map.put("cold_amount", cold_amount);
		map.put("hot_power", hot_power);
		map.put("hot_amount", hot_amount);
		map.put("out_pack_size", out_pack_size);
		map.put("out_plies_max", out_plies_max);
		map.put("out_size", out_size);
		map.put("out_weight", out_weight);
		map.put("indoor_noise", indoor_noise);
		map.put("outdoor_noise", outdoor_noise);
		map.put("smart_type", smart_type);
		map.put("heating_power", heating_power);
		map.put("air_board_color", air_board_color);
		map.put("efficiency_number", efficiency_number);
		map.put("air_type", air_type);
		map.put("temperature_type", temperature_type);
		map.put("air_power", air_power);
		map.put("suit_area", suit_area);
		map.put("customer_service", customer_service);
		map.put("work_method", work_method);
		map.put("power_level", power_level);
		map.put("wind_refresh_yes_or_not", wind_refresh_yes_or_not);
		map.put("out_net_weight", out_net_weight);
		map.put("insert_net_weight", insert_net_weight);
		map.put("commodity_details", commodity_details);
		map.put("detaile_picture", str);
		//map.put("commodity_mark", commodity_mark);
		commodityService.updateCommodityInformation(map);
	
		return "redirect:../backageController/commodityMannagement.do";
		
		
		
		
	}
	
	/**
	 * @描述:修改商品用途
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/updateCommodityUse_type")
	@ResponseBody
	public void updateCommodityUse_type(HttpServletRequest request,HttpServletResponse response,
									@RequestParam(value="c_id",required=true)String c_id,
									@RequestParam(value="use_type",required=false,defaultValue="0")int use_type
									){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("c_id", c_id);
		map.put("use_type", use_type);
		commodityService.updateCommodityUseType(map);
	}
	
	/**
	 * @描述:模糊查询品牌活动商品
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectCommodityActivity")
	@ResponseBody
	public Object selectCommodityActivity(HttpServletRequest request,HttpServletResponse response,
										@RequestParam(value="keyword",required=true)String keyword
										){
		String str="%"+keyword+"%";
		List<Commodity> list=commodityService.selectCommodityVague(str);
		if(list.size()<1){
				List null_list=new ArrayList<Object>();
				null_list.add("没有数据");
			return null_list;
		}else{
			return list;
		}
	}
	
	/**
	 * @描述:根据cId查询商品详情(用户端)
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectCommodityBycIdAndTarget")
	public String selectCommodityBycIdAndTarget(
											@RequestParam(value="c_id",required=true)String c_id,
											HttpServletRequest request
											){
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		request.setAttribute("commodity", commodity);
		List<Map<String,Object>> list=commodityService.selectEvaluateBycIdInnerJoinUser(c_id);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("nickname"));
		}
		if(list.size()<1){}else{
			request.setAttribute("list", list);
		}
		String open_id=(String)request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		request.setAttribute("user", user);
		List<Map<String,Object>> ask=dataService.selectAskInnerJoinUserBycId(c_id);
		request.setAttribute("ask", ask);
		
		return "gongzhonghao/commodityDetail.jsp";
	}
	

	/**
	 * @描述:根据cId查询商品评价详情(用户端)
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/targetCommodityEvaBycId")
	public String targetCommodityEvaBycId(HttpServletRequest request,
										@RequestParam(value="c_id",required=true)String c_id
										){
		List<Map<String,Object>> list=commodityService.selectEvaluateBycIdInnerJoinUser(c_id);
		if(list.size()<1){}else{
			request.setAttribute("list", list);
		}
		
		return "/gongzhonghao/cartEvaluateList.jsp";
	}
	
	
	/**
	 * @描述:修改订单状态
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/updateCommodityOrderOrderState")
	@ResponseBody
	public Object updateCommodityOrderOrderState(
			@RequestParam(value="com_id",required=true)String com_id
			){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("com_id", com_id);
		map.put("order_state", 8);
		commodityOrderService.updateCommodityOrderOrderState(map);
		Map<String,Object> map2=commodityOrderService.selectCommodityOrderInnerjoinCommodity(com_id);
		
		return map2;
		
	}
 	
	/**
	 * @描述:查询个人所有预生成订单信息
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectAllCommodityOrderShopCarPay")
	@ResponseBody
	public List selectAllCommodityOrderShopCarPay(
			@RequestParam(value="openId",required=true)String open_id
			){
			User u=userService.getByOpenid(open_id);
			System.out.println(u.getAu_id());
			
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("au_id", u.getAu_id());
			map.put("order_state", 8);
		List<Map<String,Object>> list=commodityOrderService.selectCommodityOrderByAuId(map);
		
		return list;
	}
	
	/**
	 * @描述:获取优惠活动接口
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/getCommodityActivity")
	@ResponseBody
	public Object getOnSaleActivityCommodity(@RequestParam(value="commodity_mark")int commodity_mark){
			Map<String,Object> map=new HashMap<String,Object>();
			if(commodity_mark==1){
				map.put("commodity_mark", commodity_mark);
				List<Map<String,Object>> list=commodityService.getCommodityActivity(map);
				return list;
			}else if(commodity_mark==2){
				map.put("commodity_mark", commodity_mark);
				List<Map<String,Object>> list=commodityService.getCommodityActivity(map);
				return list;
			}else if(commodity_mark==3){
				map.put("commodity_mark", commodity_mark);
				List<Map<String,Object>> list=commodityService.getCommodityActivity(map);
				return list;
			}else if(commodity_mark==4){
				map.put("commodity_mark", commodity_mark);
				List<Map<String,Object>> list=commodityService.getCommodityActivity(map);
				return list;
			}else{
				return "";
			}
	}
	
	/**
	 * @描述:查询所有订单
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectAllCommodityOrder")
	public String selectAllCommodityOrder(HttpServletRequest request,
										@RequestParam("au_id")String au_id
										){
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		List<Map<String, Object>> commodityOrder=commodityOrderService.selectAllCommodityOrderWaitForGet();
		request.setAttribute("commodityOrder", commodityOrder);
		return "/gongzhonghao/salemanOrder.jsp";
	}
	
	/**
	 * @描述: 销售人员接单接口
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/salemanGetCommodityOrder")
	public String salemanGetCommodityOrder(HttpServletRequest request,
										@RequestParam(value="au_id")String au_id,
										@RequestParam("com_id")String com_id
										){
		
		commodityOrderService.salemanGetCommodityOrder(com_id, au_id);
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		List<Map<String, Object>> commodityOrder=commodityOrderService.selectAllCommodityOrderWaitForGet();
		request.setAttribute("commodityOrder", commodityOrder);
		return "/gongzhonghao/salemanOrder.jsp";
	}
	
	/**
	 * @描述: 查找销售人员 : 未完成
	 * @param  
	 * @return
	 */
	@RequestMapping("/commodityOrderNotComplete")
	public String findSalemanGetCommodityOrderNotComplate(HttpServletRequest request,
														@RequestParam(required=true,value="au_id")String au_id
														){
		List<Map<String,Object>> commodityOrder=commodityOrderService.selectAllSalemanGetCommodityOrderNotComplate(au_id);
		request.setAttribute("commodityOrder", commodityOrder);
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		
		return "/gongzhonghao/commodityOrderNotComplete.jsp";
		}
	
	/**
	 * @描述: 报价
	 * @param  
	 * @return
	 */
	@RequestMapping("/commodityOrderComplete")
	public String commodityOrderComplete(HttpServletRequest request,
										@RequestParam("au_id")String au_id,
										@RequestParam("com_id")String com_id
										){
		Map<String,Object> commodityOrder=commodityOrderService.selectCommodityOrderInnerjoinCommodity(com_id);
		request.setAttribute("commodityOrder", commodityOrder);
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		
		return "/gongzhonghao/sale_makePrice.jsp";
	}

	
	/**
	 * @描述: 修改订单价格 
	 * @param  
	 * @return
	 */
	@RequestMapping("/changeCommodityOrderPrice")
	public  String changeCommodityOrderPrice(HttpServletRequest request,
											@RequestParam("au_id")String au_id,
											@RequestParam("com_id")String com_id,
											@RequestParam("price")double price,
											@RequestParam("text")String text
											){
		Map map=new HashMap();
		map.put("com_id", com_id);
		map.put("total_price", price);
		map.put("other", text);
		commodityOrderService.updateComPrice(map);
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		
		List<Map<String,Object>> commodityOrder=commodityOrderService.selectCommodityOrder_state7(au_id);
		request.setAttribute("commodityOrder", commodityOrder);
		
		return "/gongzhonghao/sale_myMessage.jsp";
	}
	
	/**
	 * @描述: 跳转到我的消息 
	 * @param  
	 * @return
	 */
	@RequestMapping("/targetMyMessage")
	public String targetMyMessage(HttpServletRequest request,
								@RequestParam("au_id")String au_id
								){
		List<Map<String,Object>> commodityOrder=commodityOrderService.selectCommodityOrder_state7(au_id);
		request.setAttribute("commodityOrder", commodityOrder);
		
		return "/gongzhonghao/sale_myMessage.jsp";
	}
	
	@RequestMapping("/findPersonCommdityOrderComplete")
	public String findPersonCommdityOrderComplete(HttpServletRequest request,
			@RequestParam("au_id")String au_id){
		List<Map<String,Object>> commodityOrder=commodityService.selectCommodityOrder_orderState(au_id);
		request.setAttribute("commodityOrder", commodityOrder);
		return null;
		
	}

	/**
	 * @描述: 将商品添加到购物车
	 * @param  
	 * @return
	 */
	@RequestMapping("/addShopCar")
	public String addShopCar(HttpServletRequest request,
							@RequestParam("c_id")String c_id
							){
		lcRamdomUtil lc=new lcRamdomUtil();
		String open_id=(String)request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		request.setAttribute("user", user);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("c_car_id", lc.getRamdomString());
		map.put("c_id", c_id);
		map.put("au_id", user.getAu_id());
		commodityService.addCommodityToCommodityCar(map);
		
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		request.setAttribute("commodity", commodity);
		List<Map<String,Object>> list=commodityService.selectEvaluateBycId(c_id);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("nickname"));
		}
		if(list.size()<1){}else{
			request.setAttribute("list", list);
		}
		return "/gongzhonghao/commodityDetail.jsp";
	}
	
	/**
	 * @描述: 将商用空调添加到购物车
	 * @param  
	 * @return
	 */
	@RequestMapping("/addCentralAirShopCar")
	public String addCentralAirShopCar(HttpServletRequest request,
									@RequestParam("c_id")String c_id
									){
		lcRamdomUtil lc=new lcRamdomUtil();
		String open_id=(String)request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		request.setAttribute("user", user);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("c_car_id", lc.getRamdomString());
		map.put("c_id", c_id);
		map.put("au_id", user.getAu_id());
		commodityService.addCommodityToCommodityCar(map);
		
		Commodity central_air=commodityService.getCommodityByc_id(c_id);
		request.setAttribute("central_air", central_air);
		List<Map<String,Object>> commodity_evaluate=commodityService.selectEvaluateBycId(c_id);
		for (int i = 0; i < commodity_evaluate.size(); i++) {
			System.out.println(commodity_evaluate.get(i).get("nickname"));
		}
		if(commodity_evaluate.size()<1){}else{
			request.setAttribute("commodity_evaluate", commodity_evaluate);
		}
		
		return "/central/centralAironditionDetail.jsp";
	}
	
	
	/**
	 * @描述: 跳转到购物车
	 * @param  
	 * @return
	 */
	@RequestMapping("/targetCommodityCart")
	public String targetCommodityCart(HttpServletRequest request){
		String open_id=(String)request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,Object>> commodity_car=commodityService.selectUserAllCommodityInCommodityCar(user.getAu_id());
		request.setAttribute("commodity_car", commodity_car);
		
		Map<String,Object> address= userService.findNewAddressPersonal(user.getAu_id());//查询用户新建地址
		request.setAttribute("address", address);
		return "/gongzhonghao/cart.jsp";
	}
	
	/**
	 * @描述: 查看参数
	 * @param  
	 * @return
	 */
	@RequestMapping("/canshu")
	public String canshu(HttpServletRequest request,
						@RequestParam("c_id")String c_id
						){
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		request.setAttribute("commodity", commodity);
		return "/gongzhonghao/canshu.jsp";
	}
	
	/**
	 * @描述: 确定购买然后跳转
	 * @param  
	 * @return
	 */
	@RequestMapping("/toBuyRightNow")
	public String toBuyRightNow(HttpServletRequest request,
							@RequestParam("c_id")String c_id
							){
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		request.setAttribute("commodity", commodity);
		String open_id=(String) request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		List<Address> list=userService.selectAddressByAuId(user.getAu_id());
		request.setAttribute("user", user);
		try{
			if(list.size()<1){
				System.out.println("该用户还没有创建过地址信息");
				request.setAttribute("au_id", user.getAu_id());
				return "/gongzhonghao/commodityAddress.jsp";
			}else{
				System.out.println("该用户已经设置了地址信息");
				Address address=list.get(0);
				request.setAttribute("address", address);
			}
			
		}catch(Exception e){
			System.out.println("该用户还没有创建订单");
		}
		return "/gongzhonghao/commodityConfirmOrder.jsp";
	}
	
	/**
	 * @描述: 商用空调确定购买然后跳转
	 * @param  
	 * @return
	 */
	@RequestMapping("/centralAirtoBuyRightNow")
	public String centralAirtoBuyRightNow(HttpServletRequest request,
										@RequestParam("c_id")String c_id
										){
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		request.setAttribute("commodity", commodity);
		String open_id=(String) request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		List<Address> list=userService.selectAddressByAuId(user.getAu_id());
		request.setAttribute("user", user);
		try{
			if(list.size()<1){
				System.out.println("该用户还没有创建过地址信息");
				request.setAttribute("au_id", user.getAu_id());
				return "/central/centralAirAddress.jsp";
			}else{
				System.out.println("该用户已经设置了地址信息");
				Address address=list.get(0);
				request.setAttribute("address", address);
			}
			
		}catch(Exception e){
			System.out.println("该用户还没有创建订单");
		}
		return "/central/centralAirConfirmOrder.jsp";
	}
	
	
	/**
	 * @描述: 创建地址
	 * @param  
	 * @return
	 */
	@RequestMapping("/createGongZhongHaoAddress")
	public String createGongZhongHaoAddress(HttpServletRequest request,
										@RequestParam("c_id")String c_id,
										@RequestParam("au_id")String au_id,
										@RequestParam("name")String name,
										@RequestParam("mobile")String mobile,
										@RequestParam("province")String province,
										@RequestParam("detail")String detail
										){
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		Map<String,Object> map=new HashMap<String,Object>();
		String a_id=lc.getRamdomString();
		map.put("a_id", a_id);
		map.put("au_id", au_id);
		map.put("name", name);
		map.put("mobile",mobile);
		map.put("province", province);
		map.put("detail", detail);
		map.put("create_time", t.getSystemTimeFormart());
		userService.insertAddress(map);
		
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		Address address=userService.getAddressInformationByAId(a_id);
		request.setAttribute("address", address);
		request.setAttribute("commodity", commodity);
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		
		return "/gongzhonghao/commodityConfirmOrder.jsp";
	}
	
	
	/**
	 * 跳转到创建商品订单
	 * @return
	 */
	@RequestMapping("/targetCreateCommodityOrder")
	public String targetCreateCommodityOrder(HttpServletRequest request,
										@RequestParam("c_id")String c_id,
										@RequestParam("a_id")String a_id
										){
		Address address=userService.getAddressInformationByAId(a_id);
		Commodity commodity= commodityService.getCommodityByc_id(c_id);
		request.setAttribute("commodity", commodity);
		request.setAttribute("address", address);
		return "/gongzhonghao/commodityAppoint.jsp";
	}
	
	@RequestMapping("/createCommodityOrderGongZhongHao")
	public String createCommodityOrderGongZhongHao(HttpServletRequest request,
											@RequestParam(value="a_id",required=true)String a_id,
											@RequestParam(value="c_id",required=true)String c_id,
											@RequestParam(value="time")String time,
											@RequestParam("time_stage")int time_stage
												){
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		Address address=userService.getAddressInformationByAId(a_id);
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		Map<String,Object> map=new HashMap<String,Object>();
		String com_id=lc.getRamdomString();
		map.put("com_id",com_id);
		map.put("c_id", c_id);
		map.put("au_id", address.getAu_id());
		map.put("time", time);
		map.put("person", address.getName());
		map.put("tellphone", address.getMobile());
		map.put("address", address.getProvince()+address.getDetail());
		map.put("total_price", 100);
		map.put("time_stage", time_stage);
		map.put("create_time", t.getSystemTimeFormart());
		
		commodityOrderService.insertCommodityOrder(map);//创建订单
		
		Map<String,Object> commodity_order=commodityOrderService.getCommodityOrderByComId(com_id);
		request.setAttribute("commodity_order", commodity_order);
		request.setAttribute("address", address);
		request.setAttribute("commodity", commodity);
		
		return "/gongzhonghao/commodityConfirmOrder.jsp";
	}
	
	/**
	 * 返回购物车商品信息
	 * @return
	 */
	@RequestMapping("/getCommodityInformationInCart")
	@ResponseBody
	public Object getCommodityInformationInCart(@RequestParam("c_car_id")String c_car_id){
		Map<String,Object> commodity_car=commodityService.selectCommodityCarInformationInnerJoin(c_car_id);
		String au_id=(String) commodity_car.get("au_id");
		List<Address> address_list=userService.selectAddressByAuId(au_id);//查询用户之前是否创建了地址信息
		if(address_list.size()<1){
			//用户没有创建地址
			commodity_car.put("address_sign", 0);
		}else{
			//用户已经创建地址
			commodity_car.put("address_sign", 1);
		}
		return commodity_car;
	}
	
	
	/**
	 * 创建已支付订单并删除购物车
	 * @return
	 */
	@RequestMapping("/deleteCommodityInCar")
	public String deleteCommodityInCar(HttpServletRequest request,
									@RequestParam("c_car_id")String c_car_id){
		Map<String,Object> map=new HashMap<String,Object>();
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		Map<String,Object> commodity_car_delete=commodityService.selectCommodityCarInformationInnerJoin(c_car_id);//购物车，商品，个人信息
		String au_id=(String) commodity_car_delete.get("au_id");
		Map<String,Object> address= userService.findNewAddressPersonal(au_id);//查询最新创建的地址信息
		//该逻辑存在bug：当用户想以最初的地址收货时，默认选择该用户最新创建的地址信息：
		//更正方法：后期在用户设置界面,由于设置默认地址进行处理，将显示的默认地址显示为最新
		map.put("com_id", lc.getRamdomString());
		map.put("au_id", au_id);
		map.put("c_id", commodity_car_delete.get("c_id"));
		map.put("order_state", 1);
		map.put("total_price", commodity_car_delete.get("price"));
		map.put("pay_time", t.getSystemTimeFormart());
		map.put("pay_id", lc.getRamdomString());
		map.put("create_time", t.getSystemTimeFormart());
		map.put("a_id", address.get("a_id"));
		map.put("slice_flag", 1);
		map.put("deposit", commodity_car_delete.get("price"));
		map.put("retainage", 0);
		
		commodityOrderService.insertCommodityOrder(map);//创建订单
		
		commodityService.delectCommodityInCart(c_car_id);  //删除购物车对应的商品
		//查询出个人购物车里的商品，setAttribute
		List<Map<String,Object>> commodity_car=commodityService.selectUserAllCommodityInCommodityCar(au_id);
		request.setAttribute("commodity_car", commodity_car);
		request.setAttribute("address", address);
		
		
		return "/gongzhonghao/cart.jsp";
	}
	
	
	/**
	 * 跳转到订单添加地址界面
	 * @return
	 */
	@RequestMapping("/createPersonAddressCart")
	public String createPersonAddressCart(HttpServletRequest request,
										@RequestParam(value="c_car_id")String c_car_id,
										@RequestParam(value="price")double price,
										@RequestParam(value="c_id")String c_id,
										@RequestParam(value="au_id")String au_id,
										@RequestParam(value="open_id")String open_id
										){
		request.setAttribute("c_car_id", c_car_id);
		request.setAttribute("price", price);
		request.setAttribute("c_id", c_id);
		request.setAttribute("au_id", au_id);
		request.setAttribute("open_id", open_id);
		return "/gongzhonghao/mineAddressCreate.jsp";
	}
	
	/**
	 * 创建地址
	 * @return
	 */
	@RequestMapping("/createPersonAddressCartTarget")
	public String createPersonAddressCartTarget(HttpServletRequest request,
										@RequestParam(value="c_car_id")String c_car_id,
										@RequestParam(value="price")double price,
										@RequestParam(value="c_id")String c_id,
										@RequestParam(value="au_id")String au_id,
										@RequestParam(value="open_id")String open_id,
										@RequestParam(value="name")String name,
										@RequestParam(value="mobile")String mobile,
										@RequestParam(value="province")String province,
										@RequestParam(value="detail")String detail
											){
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("a_id", lc.getRamdomString());
		map.put("au_id", au_id);
		map.put("name", name);
		map.put("mobile", mobile);
		map.put("province", province);
		map.put("detail", detail);
		map.put("create_time", t.getSystemTimeFormart());
		userService.insertAddress(map);//创建地址
		/*********跳转回到购物车界面**************************************/		
		User user=userService.getByOpenid(open_id);
		List<Map<String,Object>> commodity_car=commodityService.selectUserAllCommodityInCommodityCar(user.getAu_id());
		
		Map<String,Object> address= userService.findNewAddressPersonal(au_id);
		request.setAttribute("commodity_car", commodity_car);
		request.setAttribute("address", address);
		
		return "/gongzhonghao/cart.jsp";
	}
	
	/**
	 * 删除多余购物车中的商品
	 * @return
	 */
	@RequestMapping("/deleteCommoditysInCart")
	public String deleteCommoditysInCart(HttpServletRequest request,
										@RequestParam("c_car_id")String c_car_id
										){
		
		commodityService.delectCommodityInCart(c_car_id);  //删除购物车对应的商品
		//查询出个人购物车里的商品，setAttribute
		String open_id=(String) request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		List<Map<String,Object>> commodity_car=commodityService.selectUserAllCommodityInCommodityCar(user.getAu_id());
		request.setAttribute("commodity_car", commodity_car);
		
		Map<String,Object> address= userService.findNewAddressPersonal(user.getAu_id());
		request.setAttribute("address", address);
		
		return "/gongzhonghao/cart.jsp";
	}
	
	/**
	 * 局部刷新获取价格
	 * @return
	 */
	@RequestMapping("/getCommodityPriceByc_car_id")
	@ResponseBody
	public double getCommodityPriceByc_car_id(@RequestParam("c_car_id")String c_car_id){
		
		Map<String,Object> commodity_in_car=commodityService.getCommodityPriceByc_car_id(c_car_id);
		double price= (double) commodity_in_car.get("price");
		return price;
	}
	
	/**
	 * 跳转到商用中央空调
	 * @return
	 */
	@RequestMapping("/targetContralAirConditionShop")
	public String targetContralAirConditionShop(HttpServletRequest request){
		List<Map<String,Object>> central_air=commodityService.selectAllCentralAirCondition();
		request.setAttribute("central_air", central_air);
		
		return "/central/centralShop.jsp";
	}
	
	/**
	 * 商用空调商品排序
	 * @return
	 */
	@RequestMapping("/selectCentralAirConditionByMark")
	@ResponseBody
	public Object selectCentralAirBycIdAndTarget(HttpServletRequest request,
												@RequestParam(value="mark",required=false,defaultValue="0")int mark
												){
		
		if(mark==0){
			//价格升序 top
			List<Map<String,Object>> central_air=commodityService.selectAllCentralAirCondition();
			return central_air;
		}else if(mark==1){
			//iBottom 价格降序
			List<Map<String,Object>> central_air=commodityService.selectAllCentralAirConditionOrderByPriceDesc();
			return central_air;
		}else if(mark==2){
			//iBottom 价格升序
			List<Map<String,Object>> central_air=commodityService.selectAllCentralAirConditionOrderByPriceAsc();
			return central_air;
		}else if(mark==3){
			//销量降序   
			List<Map<String,Object>> central_air=commodityService.selecAllCentralAirConditionOrderBySaleCountsDesc();
			return central_air;
		}else if(mark==4){
			//销量升序 top
			List<Map<String,Object>> central_air=commodityService.selecAllCentralAirConditionOrderBySaleCountsAsc();
			return central_air;
		}
		
		return "";
	}
	
	/**
	 * 商用空调查看商品详情
	 * @return
	 */
	@RequestMapping("/selectCentralAirBycIdAndTarget")
	public String selectCentralAirBycIdAndTarget(HttpServletRequest request,
											@RequestParam("c_id")String c_id
											){
		String open_id=(String) request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		request.setAttribute("user", user);//
		
		Commodity central_air=commodityService.getCommodityByc_id(c_id);
		request.setAttribute("central_air", central_air);//商用空调商品详情
		
		List<Map<String,Object>> commodity_evaluate=commodityEvaluateService.selectCommodityInnerJoinEvaluateByc_id(c_id);
		request.setAttribute("commodity_evaluate", commodity_evaluate);//商品，评价，评论人
		
		
		List<Map<String,Object>> ask=dataService.selectAskInnerJoinUserBycId(c_id);
		request.setAttribute("ask", ask);
		
		return "/central/centralAirConditionDetail.jsp";
	}
	
	/**
	 * 商用空调未创建地址：提交地址信息并创建
	 * @return
	 */
	@RequestMapping("/createCentralAddress")
	public String createCentralAddress(HttpServletRequest request,
									@RequestParam("c_id")String c_id,
									@RequestParam("au_id")String au_id,
									@RequestParam("name")String name,
									@RequestParam("mobile")String mobile,
									@RequestParam("province")String province,
									@RequestParam("detail")String detail
									){
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		Map<String,Object> map=new HashMap<String,Object>();
		String a_id=lc.getRamdomString();
		map.put("a_id", a_id);
		map.put("au_id", au_id);
		map.put("name", name);
		map.put("mobile",mobile);
		map.put("province", province);
		map.put("detail", detail);
		map.put("create_time", t.getSystemTimeFormart());
		userService.insertAddress(map);
		
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		Address address=userService.getAddressInformationByAId(a_id);
		request.setAttribute("address", address);
		request.setAttribute("commodity", commodity);
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		
		return "/central/centralAirConfirmOrder.jsp";
	}
	
	/**
	 * 商用空调：创建预订单
	 * @return
	 */
	@RequestMapping("/targetCreateCentralAirOrderState8")
	public String targetCreateCentralAirOrderState7(HttpServletRequest request,
												@RequestParam("c_id")String c_id,
												@RequestParam("a_id")String a_id,
												@RequestParam("au_id")String au_id,
												@RequestParam("open_id")String open_id,
												@RequestParam("price")double price,
												@RequestParam("deposit")double deposit,
												@RequestParam("slice_flag")int slice_flag,
												@RequestParam(value="sign",required=false,defaultValue="0")int sign
												){
		double retainage=0;
		retainage=(price-deposit);    //尾款=商品总价-预定金
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("com_id", lc.getRamdomString());
		map.put("au_id", au_id);
		map.put("c_id", c_id);
		map.put("order_state", 8);  //预订单 ：未付款已确认购买状态   等待销售员接单
		map.put("total_price", price);
		map.put("pay_time", t.getSystemTimeFormart());
		map.put("create_time", t.getSystemTimeFormart());
		map.put("a_id", a_id);
		map.put("deposit", deposit);
		map.put("slice_flag", slice_flag);
		map.put("retainage", retainage);
		
		commodityOrderService.insertCommodityOrder(map);
		
		List<Map<String,Object>> commodity_order=commodityOrderService.selectUserCentralAirNotPay(au_id);
		request.setAttribute("commodityOrder", commodity_order);
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		return "/central/centralOrderNotPay.jsp";
	}
	
	/**
	 * 未支付、已支付、已评价  商用空调
	 * @return
	 */
	@RequestMapping("/centralOrderState8BySign")
	public String centralOrderState8BySign(HttpServletRequest request,
										@RequestParam("au_id")String au_id,
										@RequestParam(value="sign",required=false,defaultValue="0")int sign
										){
		if(sign==0){//个人未付款商用空调
			List<Map<String,Object>> commodity_order=commodityOrderService.selectUserCentralAirNotPay(au_id);
			request.setAttribute("commodityOrder", commodity_order);
			User user=userService.selectUserByauId(au_id);
			request.setAttribute("user", user);
			return "/central/centralOrderNotPay.jsp";
		}else if(sign==1){//个人已付款商用空调
			List<Map<String,Object>> commodity_order=commodityOrderService.selectUserCentralAirPay(au_id);
			request.setAttribute("commodityOrder", commodity_order);
			User user=userService.selectUserByauId(au_id);
			request.setAttribute("user", user);
			return "/central/centralOrderPay.jsp";
		}else if(sign==2){//个人已评价商用空调
			List<Map<String,Object>> commodity_order=commodityOrderService.selectUserCentralAirEvaluated(au_id);
			request.setAttribute("commodityOrder", commodity_order);
			User user=userService.selectUserByauId(au_id);
			request.setAttribute("user", user);
			return "/central/centralOrderEvalute.jsp";
		}
		
		return "";
	}
	
	/**
	 * 查看全部提问
	 * @return
	 */
	@RequestMapping("/selectAllAsk_all")
	public String selectAllAsk_all(HttpServletRequest request,
								@RequestParam("c_id")String c_id
								){
		List<Map<String,Object>> ask=dataService.selectAskInnerJoinUserBycId(c_id);
		request.setAttribute("ask", ask);//查询了所有问题 
		request.setAttribute("c_id", c_id);
		
		return "/gongzhonghao/askList.jsp";
	}
	
	/**
	 * 创建问题
	 * @return
	 */
	@RequestMapping("/commoditycreateQuestion")
	public String commoditycreateQuestion(HttpServletRequest request,
										@RequestParam("c_id")String c_id,
										@RequestParam("content")String content
										){
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		String open_id=(String) request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("ask_id", lc.getSixPlusTimeStampRamdomString());
		map.put("c_id", c_id);
		map.put("au_id", user.getOpen_id());
		map.put("question", content);
		map.put("create_time", t.getSystemTimeFormart());
		dataService.createCommodityAsk(map);
		
		return "redirect:../commodity/selectAllAsk_all.do?c_id"+c_id;
	}
	
	/**
	 * 查询问题和对应的额全部回答
	 * @return
	 */
	@RequestMapping("/selectAskAndAnswers")
	public String selectAskAndAnswers(HttpServletRequest request,
									@RequestParam("ask_id")String ask_id
									){
		//先查询问题
		Map<String,Object> ask_all=commonservice.selectAskAllByAskId(ask_id);
		request.setAttribute("ask_all", ask_all);
		//在查询答案
		List<Map<String,Object>> answers=commonservice.selectAnswerByAskId(ask_id);
		request.setAttribute("answers", answers);
		
		return "/gongzhonghao/askDetail.jsp";
	}
	
	/**
	 * 根据问题添加回答
	 * @return
	 */
	@RequestMapping("/createAnswerByAsk")
	public String createAnswerByAsk(HttpServletRequest request,
								@RequestParam("ask_id")String ask_id,
								@RequestParam("content")String content
								){
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		String open_id=(String) request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("answers_id", lc.getSixPlusTimeStampRamdomString());
		map.put("ask_id", ask_id);
		map.put("au_id", user.getAu_id());
		map.put("content", content);
		map.put("mark", 0);
		map.put("create_time", t.getSystemTimeFormart());
		commodityService.insertAskAllAnswers(map);
		
		return "redirect:../commodity/selectAskAndAnswers.do?ask_id="+ask_id;
	}
	
	/**
	 * 筛选空调接口   //商城的普通空调
	 * @return
	 */
	@RequestMapping("/chooseCommodityByParameter")  
	public String chooseCommodityByParameter(HttpServletRequest request,
											@RequestParam("brand")String brand,
											@RequestParam("use_type")int use_type,
											@RequestParam("type")int type,
											@RequestParam("frequency")int frequency,
											@RequestParam("level")String level
											){
		String new_brand="%"+brand+"%";
		String new_use_type="%"+use_type+"%";
		String new_type="%"+type+"%";
		String new_frequency="%"+frequency+"%";
		String new_level="%"+level+"%";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("brand", new_brand);
		map.put("use_type", new_use_type);
		map.put("type", new_type);
		map.put("frequency", new_frequency);
		map.put("level", new_level);
		List<Map<String,Object>> commodity=commodityService.chooseCommodityByScreen(map);
		request.setAttribute("commodity", commodity);
		return "/gongzhonghao/commodityShop.jsp";
	}
	
	/**
	 * 筛选空调接口   //中央空调
	 * @return
	 */
	@RequestMapping("/chooesCentralAirByParameter")
	public String chooesCentralAirByParameter(HttpServletRequest request,
											@RequestParam("brand")String brand,
											@RequestParam("use_type")int use_type,
											@RequestParam("type")int type,
											@RequestParam("frequency")int frequency,
											@RequestParam("level")String level
											){
		String new_brand="%"+brand+"%";
		String new_use_type="%"+use_type+"%";
		String new_type="%"+type+"%";
		String new_frequency="%"+frequency+"%";
		String new_level="%"+level+"%";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("brand", new_brand);
		map.put("use_type", new_use_type);
		map.put("type", new_type);
		map.put("frequency", new_frequency);
		map.put("level", new_level);
		List<Map<String,Object>> central_air=commodityService.chooseCommodityByScreen(map);
		request.setAttribute("central_air", central_air);
		
		return "/central/centralShop.jsp";
	}
	
	
}
