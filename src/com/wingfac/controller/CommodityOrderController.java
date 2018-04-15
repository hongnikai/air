package com.wingfac.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.core.appender.RandomAccessFileAppender;
import org.aspectj.apache.bcel.classfile.Constant;
import org.quartz.simpl.RAMJobStore;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wingfac.entity.Address;
import com.wingfac.entity.Commodity;
import com.wingfac.entity.CommodityOrder;
import com.wingfac.entity.CommodityOrder_resultBean;
import com.wingfac.entity.Install;
import com.wingfac.entity.InstallOrder;
import com.wingfac.entity.Maintain;
import com.wingfac.entity.MaintainOrder;
import com.wingfac.entity.Repair;
import com.wingfac.entity.RepairOrder;
import com.wingfac.entity.User;
import com.wingfac.service.CommodityEvaluateService;
import com.wingfac.service.CommodityOrderService;
import com.wingfac.service.CommodityService;
import com.wingfac.service.InstallService;
import com.wingfac.service.MaintainService;
import com.wingfac.service.RepairService;
import com.wingfac.service.UserService;
import com.wingfac.util.LocalResponseBody;
import com.wingfac.util.RandomUtil;
import com.wingfac.util.ResponseSuccessOrFail;
import com.wingfac.util.TimeUtil;
import com.wingfac.util.lcRamdomUtil;

/**
 *  @描述：订单管理
 ** @author LC   
 *  创建时间：2018-2-6 下午15:49
 */
@Controller
@Scope(value="prototype")
@RequestMapping("CommodityOrderController")
public class CommodityOrderController {
	
	@Resource(name="commodityOrderService")
	private CommodityOrderService commodityOrderService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="commodityService")
	private CommodityService commodityService;
	
	@Resource(name="installService")
	private InstallService installService;
	
	@Resource(name="maintainService")
	private MaintainService maintainService;
	
	@Resource(name="repairService")
	private RepairService repairService;
	
	@Resource(name="commodityEvaluateService")
	private CommodityEvaluateService commodityEvaluateService;
	
	/**
	 * 查找订单部分信息
	 * @param auId
	 * @return
	 */
	@RequestMapping("/selectCommodityOrderByOpenId")
	@ResponseBody
	public LocalResponseBody<Object> selectCommodityOrderByAuid(HttpServletRequest request,
											 @RequestParam(value="openId",required = true)String open_id
											){
		Map<String,Object> map = new HashMap<String,Object>();
		User user=userService.getByOpenid(open_id);
		List<Map<String,Object>> commodity_order_list=commodityOrderService.selectCommodityOrderByOpenId(open_id);
		List<InstallOrder> install_list=installService.selectInstallOrderByAuId(user.getAu_id());
		List<MaintainOrder> maintain_list = maintainService.selectMaintainByauId(user.getAu_id());
		List<RepairOrder> repair_list = repairService.selectRepairByauId(user.getAu_id());
		
		if(commodity_order_list.size()<1){
			map.put("commodity","没有订单数据");
		}else if(install_list.size()<1){
			map.put("install", "没有安装订单数据");
		}else if(maintain_list.size()<1){
			map.put("main", "没有保养订单数据");
		}else if(repair_list.size()<1){
			map.put("repair", repair_list);
		}
		map.put("commodity", commodity_order_list);
		map.put("install", install_list);
		map.put("main", maintain_list);
		map.put("repair", repair_list);
		
		return new LocalResponseBody<Object>("1","SUCCESS",map);
	}
	
	/**
	 * 根据商品创建订单
	 * @param c_id  	 订单id
	 * @param openId	 用户唯一标识	
	 * @param count		 订单内商品数量
	 * @param leave_message		买家留言
	 * @param slice_flag		分期标识 0不分期 1分期
	 * @param deposit			预定金
	 * @return
	 */
	@RequestMapping("/createCommodity_orderByCommodity")
	@ResponseBody
	public ResponseSuccessOrFail createCommodity_orderByCommodity(HttpServletRequest request,HttpServletResponse response,
												@RequestParam(value="c_id",required = true)String c_id,
												@RequestParam(value="openId",required = true)String open_id,
												@RequestParam(value="count",required = false,defaultValue="1")int count,
												@RequestParam(value="leave_message",required = false,defaultValue ="无")String leave_message,
												@RequestParam(value="slice_flag",required = false,defaultValue = "0")int slice_flag,
												@RequestParam(value="deposit",required = false,defaultValue = "0")double deposit
											){
		RandomUtil r = new RandomUtil();
		String com_id = r.getEightRandom();
		String pay_id = r.getEightRandom();
		
		User user=userService.getByOpenid(open_id);
		String au_id=user.getAu_id();
		
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		double total_price = commodity.getPrice()*count;
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		String pay_time = simple.format(System.currentTimeMillis());
		String create_time = simple.format(System.currentTimeMillis());
		
		String a_id = r.getEightRandom();
		
		double retainage = total_price - deposit;
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("com_id", com_id);
		map.put("au_id", au_id);
		map.put("c_id", c_id);
		map.put("order_state", 0);//订单状态 0未支付1已支付,2待收货3已收货4安装中5保养中6维修中7已评价
		map.put("total_price", total_price);
		map.put("pay_time", pay_time);
		map.put("pay_id", pay_id);
		map.put("create_time", create_time);
		map.put("leave_message", leave_message);
		map.put("a_id", a_id);
		map.put("slice_flag", slice_flag);
		map.put("deposit", deposit);
		map.put("retainage", retainage);
		
		commodityOrderService.createCommodityOrder(map);
		
		return new ResponseSuccessOrFail("SUCCESS", "SUCCESS");
	}
	
	/**
	 * 支付尾款接口
	 * @param  com_id   订单id
	 * @return
	 */
	@RequestMapping("/findAllCommodityOrderByOpenId")
	@ResponseBody
	public LocalResponseBody<Object> findAllCommodityOrderByOpenId(HttpServletRequest request,HttpServletResponse response,
												@RequestParam(value="comId",required = true)String com_id
												){
		List<CommodityOrder> list=commodityOrderService.selectCommodityOrderByComId(com_id);
		if(list.size()<1){
			return new LocalResponseBody<Object>("0","没有数据");
		}
		return new LocalResponseBody<Object>("1","SUCCESS",list);
	}
	
	/**
	 * 取消订单接口
	 * @param  com_id   订单id
	 * @return
	 */
	@RequestMapping("/deleteCommodityOrderByComId")
	@ResponseBody
	public String deleteCommodityOrderByComId(HttpServletRequest request,HttpServletResponse response,
											@RequestParam(value="comId",required = true)String com_id
											){
		commodityOrderService.deleteCommodityOrderByComId(com_id);
		return "SUCCESS";
	}
		
	/**
	 * 制作订单价格
	 * @param  
	 * @return
	 */
	@RequestMapping("/salesmanGetCommodityOrder")
	@ResponseBody
	public ResponseSuccessOrFail salesmanGetCommodityOrder(HttpServletRequest request,HttpServletResponse response,
											@RequestParam(value="openId",required=true)String open_id,
											@RequestParam(value="comId",required=true)String com_id,
											@RequestParam(value="total_price",required=false,defaultValue="0")double total_price,
											@RequestParam(value="deposit",required=false,defaultValue="0")double deposit,
											@RequestParam(value="other",required=false,defaultValue="无")String other
											){
		double retainage=total_price-deposit;//尾款
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("saleman_id", open_id);
		map.put("other", other);
		map.put("total_price", total_price);
		map.put("deposit", deposit);
		map.put("retainage", retainage);
		map.put("com_id", com_id);
		commodityOrderService.updateCommodityOrderMoney(map);
		
		List<CommodityOrder> list=commodityOrderService.selectCommodityOrderByComId(com_id);
		if(list.size()<1){
			return new ResponseSuccessOrFail("FAIL", "响应失败");
		}
		return new ResponseSuccessOrFail("SUCCESS", list);
	}
	
	/**
	 * 销售抢单接口
	 * @param  
	 * @return
	 */
	@RequestMapping("/salesmanCompeteCommodityOrder")
	@ResponseBody
	public ResponseSuccessOrFail salesmanCompeteCommodityOrder(HttpServletRequest request,HttpServletResponse response,
												@RequestParam(value="openId",required=true)String open_id,
												@RequestParam(value="comId",required=true)String com_id
			){
		commodityOrderService.updateCommodityOrderPrivate(open_id,com_id);
		List<CommodityOrder> list=commodityOrderService.selectCommodityOrderByComId(com_id);
		if(list.size()<1){
			return new ResponseSuccessOrFail("FAIL", "出错了");
		}
		return new ResponseSuccessOrFail("SUCCESS", list);
	}
	
	/**
	 * 查询所有待抢商品订单
	 * @param  
	 * @return
	 */
	@RequestMapping("/selectCommodityOrderNotRob")
	@ResponseBody
	public ResponseSuccessOrFail selectCommodityOrderNotRob(){
		List<CommodityOrder> list=commodityOrderService.getAllCommodityOrder();
		if(list.size()<1){
			new ResponseSuccessOrFail("FAIL", "未查询到相关订单");
		}
		return new ResponseSuccessOrFail("SUCCESS", list);
	}
	
	
	/**
	 * (普通用户)查询个人所有订单接口
	 * @param  
	 * @return
	 */
	@RequestMapping("/findAllMyOrder")
	public String findAllMyOrder(HttpServletRequest request,
								@RequestParam("au_id")String au_id,
								@RequestParam(value="sign",required=false,defaultValue="0")int sign
								){
		if(sign==0){//未付款
			List<Map<String,Object>> commodity_order=commodityOrderService.selectAllMyCommodityOrder_state0(au_id);
			List<Map<String,Object>> commodity_order2=commodityOrderService.selectCentralAirCreateByUser(au_id);
			commodity_order.addAll(commodity_order2);//将2结果添加给1   发送1
			List<Map<String,Object>> install_order=installService.selectAllMyInstallOrder_state0(au_id);
			List<Map<String,Object>> maintain_order=maintainService.selectAllMyMaintainOrder_state0(au_id);
			List<Map<String,Object>> repair_order=repairService.selectAllMyRepairOrder_state0(au_id);
			User user=userService.selectUserByauId(au_id);
			request.setAttribute("commodity_order", commodity_order);
			request.setAttribute("install_order", install_order);
			request.setAttribute("maintain_order", maintain_order);
			request.setAttribute("repair_order", repair_order);
			request.setAttribute("user", user);
			return "/gongzhonghao/MyOrder.jsp";
		}else if(sign==1){//已付款
			List<Map<String,Object>> commodity_order=commodityOrderService.selectAllMyCommodityOrder_state1(au_id);
			List<Map<String,Object>> install_order=installService.selectAllMyInstallOrder_state1(au_id);
			List<Map<String,Object>> maintain_order=maintainService.selectAllMyMaintainOrder_state1(au_id);
			List<Map<String,Object>> repair_order=repairService.selectAllMyRepairOrder_state1(au_id);
			request.setAttribute("commodity_order", commodity_order);
			request.setAttribute("install_order", install_order);
			request.setAttribute("maintain_order", maintain_order);
			request.setAttribute("repair_order", repair_order);
			User user=userService.selectUserByauId(au_id);
			request.setAttribute("user", user);
			return "/gongzhonghao/MyOrder2.jsp";
		}else if(sign==2){//所有订单
			List<Map<String,Object>> commodity_order=commodityOrderService.selectAllMyCommodityOrders(au_id);
			List<Map<String,Object>> install_order=installService.selectAllMyInstallOrders(au_id);
			List<Map<String,Object>> maintain_order=maintainService.selectAllMyMaintainOrders(au_id);
			List<Map<String,Object>> repair_order=repairService.selectAllMyRepairOrders(au_id);
			request.setAttribute("commodity_order", commodity_order);
			request.setAttribute("install_order", install_order);
			request.setAttribute("maintain_order", maintain_order);
			request.setAttribute("repair_order", repair_order);
			User user=userService.selectUserByauId(au_id);
			request.setAttribute("user", user);
			return "/gongzhonghao/MyOrder3.jsp";
		}
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		return "/gongzhonghao/MyOrder.jsp";
	}

	@RequestMapping("/findCommodity")
	@ResponseBody
	public Object findCommodity(HttpServletRequest request,
							@RequestParam("com_id")String com_id
							){
		Map<String,Object> commodityOrder=commodityOrderService.getCommodityOrderByComId(com_id);
		String au_id=(String)commodityOrder.get("au_id");
		double retainage=(double) commodityOrder.get("retainage");//尾款
		String c_id=(String) commodityOrder.get("c_id");
		String a_id=(String) commodityOrder.get("a_id");
		
		User user=userService.selectUserByauId(au_id);
		String open_id=user.getOpen_id();
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("com_id", com_id);
		result.put("money", retainage);
		result.put("open_id", open_id);
		result.put("au_id", au_id);
		result.put("a_id", a_id);
		result.put("c_id", c_id);
		
		return result;
	}
	
	/**
	 * 销售抢单接口2
	 * @param  
	 * @return
	 */
	@RequestMapping("/salesmanCompeteCommodityOrder2")
	@ResponseBody
	public Object salesmanCompeteCommodityOrder(HttpServletRequest request,
											@RequestParam("com_id")String com_id
											){
		String open_id=(String) request.getSession().getAttribute("openid");
		User user =userService.getByOpenid(open_id);
		commodityOrderService.updateCommodityOrderPrivate(user.getAu_id(),com_id);
		List<CommodityOrder> list=commodityOrderService.selectCommodityOrderByComId(com_id);
		return list;
	}
	
	/**
	 * (销售)查询所有订单
	 * @param  
	 * @return
	 */
	@RequestMapping("/findAllMyOrder_saleman")
	public String findAllMyOrder_saleman(HttpServletRequest request,
										@RequestParam("au_id")String au_id,
										@RequestParam(value="sign",required=false,defaultValue="0")int sign
										){
		if(sign==0){//未付款和预生成
			List<Map<String,Object>> commodity_order=commodityOrderService.selectAllMyCommodityOrder_state8();
			User user=userService.selectUserByauId(au_id);
			request.setAttribute("commodity_order", commodity_order);
			request.setAttribute("user", user);
			return "/gongzhonghao/MyOrder_saleman.jsp";
		}else if(sign==2){//未完成已接单
			List<Map<String,Object>> commodity_order=commodityOrderService.selectAllSalemanCommodityOrder(au_id);
			User user=userService.selectUserByauId(au_id);
			request.setAttribute("commodity_order", commodity_order);
			request.setAttribute("user", user);
			return "/gongzhonghao/MyOrder_saleman2.jsp";
		}else if(sign==3){//已付款
			List<Map<String,Object>> commodity_order=commodityOrderService.selectAllSalemanCommodityOrder_state7(au_id);
			User user=userService.selectUserByauId(au_id);
			request.setAttribute("commodity_order", commodity_order);
			request.setAttribute("user", user);
			return "/gongzhonghao/MyOrder_saleman3.jsp";
		}
		return "";
	}
	
	/**
	 * 已购买  创建订单
	 * @param  
	 * @return
	 */
	@RequestMapping("/createCommodityOrderState1")
	public String createCommodityOrderState1(HttpServletRequest request,
											@RequestParam(value="money",required=true)double money,
											@RequestParam(value="au_id",required=true)String au_id,
											@RequestParam(value="c_id",required=true)String c_id,
											@RequestParam(value="a_id",required=true)String a_id
											){
			lcRamdomUtil lc=new lcRamdomUtil();
			TimeUtil t=new TimeUtil();
			String pay_time=t.getSystemTimeFormart();
			String create_time=t.getSystemTimeFormart();
			Map<String,Object> map=new HashMap<String,Object>();					
			map.put("com_id", lc.getRamdomString());
			map.put("au_id", au_id);
			map.put("c_id", c_id);
			map.put("order_state", 1);
			map.put("total_price", money);
			map.put("pay_time", pay_time);
			map.put("create_time", create_time);
			map.put("a_id", a_id);
			map.put("slice_flag", 0);
			map.put("deposit", money);
			map.put("retainage", 0);
			commodityOrderService.insertCommodityOrder(map);
			
		return "redirect:http://www.kongtiaoguanjia.com/air/CommodityOrderController/findAllMyOrder.do?au_id="+au_id;
	}
	

	/**
	 * 个人未付款jsp
	 * @param  
	 * @return
	 */
	@RequestMapping("/commodityOrderNotPay")
	public String commodityOrderNotPay(HttpServletRequest request
									
									){
		 String open_id=(String) request.getSession().getAttribute("openid");
		 User user=userService.getByOpenid(open_id);
		List<Map<String,Object>> commodity_order=commodityOrderService.selectCentralAirOrdersNotPay(user.getAu_id());
		List<Map<String,Object>> commodity_order2=commodityOrderService.selectNomalAirOrdersNotPay(user.getAu_id());
		commodity_order.addAll(commodity_order2);
		request.setAttribute("commodity_order", commodity_order);
		
		return "/person/commodityOrderNotPay.jsp";
	}
	
	/**
	 * 已付款jsp
	 * @param  
	 * @return
	 */
	@RequestMapping("/commodityOrderPay")
	public String commodityOrderPay(){
		return "/person/commodityOrderPay.jsp";
	}
	
	/**
	 * 已评价jsp
	 * @param  
	 * @return
	 */
	@RequestMapping("/commodityOrderEvalute")
	public String commodityOrderEvalute(){
		return "/person/commodityOrderEvalute.jsp";
	}
	
	/**
	 * 首页查看自己的购买订单
	 * @param  
	 * @return
	 */
	@RequestMapping("/selectOwnCommodityOrder")
	@ResponseBody
	public Object selectOwnCommodityOrder(HttpServletRequest request,
										@RequestParam(value="sign",required=false,defaultValue="0")int sign
										){
		//String open_id=(String) request.getSession().getAttribute("openid");
		User user=userService.getByOpenid("oorAYxKwiAmP-emkOYg9o9n1XWRE");
		String au_id=user.getAu_id();
		if(sign==0){//未支付订   商用空调+普通空调
			List<Map<String,Object>> commodityOrder=commodityOrderService.selectOwnNotPay(au_id);	
			return commodityOrder;
		}else if(sign==1){//已支付
			List<Map<String,Object>> commodityOrder=commodityOrderService.selecOwnPay(au_id);
			return commodityOrder;
		}else if(sign==2){//已评价
			List<Map<String,Object>> commodityOrder=commodityOrderService.selectOwnEvalute(au_id);
			return commodityOrder;
		}
		return "";
	}
	
	/**
	 * 跳转到销售员买单
	 * @param  
	 * @return
	 */
	@RequestMapping("/updateCentralAirPrice")
	public String updateCentralAirPrice(HttpServletRequest request,
									@RequestParam("com_id")String com_id
									){
		Map<String,Object> commodityOrder = commodityOrderService.selectCommodityOrderInnerjoinCommodity(com_id);
		request.setAttribute("commodityOrder", commodityOrder);
		
		return "/saleman/myOrderMakePrice.jsp";
	}
	
	/**
	 * 销售员修改订单价格
	 * @param  
	 * @return
	 */
	@RequestMapping("/updatePriceCommodityOrderBySaleman")
	@ResponseBody
	public Object updatePriceCommodityOrderBySaleman(HttpServletRequest request,
													@RequestParam("com_id")String com_id,
													@RequestParam("price")double price,
													@RequestParam("beizhu")String beizhu
													){
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> commodityOrder = commodityOrderService.selectCommodityOrderInnerjoinCommodity(com_id);
		double old_price = (double) commodityOrder.get("total_price");//商品原价
		double old_retainage= (double) commodityOrder.get("retainage");//尾款
		double deposit=(double) commodityOrder.get("deposit");//预定金
		//尾款= 新价格 - 预定金
		//如果价格修改高了还好说，一旦价格小于预订金，那不成立
		if(price>deposit){
			double new_retainage=price-deposit;
			String other=beizhu+"修改订单总价格为: "+price+"元，修改尾款为："+new_retainage+"元";
			Map<String,Object> up_msg =new HashMap<String,Object>();
			up_msg.put("retainage", new_retainage);//尾款
			up_msg.put("total_price", price);
			up_msg.put("other", other);
			commodityOrderService.updateCommodityOrderPrice(up_msg);
			
			map.put("sign", other);
			return map;
		}else{
			map.put("sign", 0);//错误返回0
			return map;
		}
		
	}
	
	/**
	 * 去付款
	 * @param  
	 * @return
	 */
	@RequestMapping("/toPayTheMoney")
	public String toPayTheMoney(@RequestParam("com_id")String com_id){
		System.out.println(com_id);
		System.out.println("进入付款啊圣诞节啊是第几艾赛杜拉按道理");
		return "/index.jsp";
	}
	
	
	/**
	 * 支付成功修改商用空调的状态和尾款
	 * @param  
	 * @return
	 */
	@RequestMapping("/updataCentralAirOrderRetainage")
	@ResponseBody
	public Object updataCentralAirOrderRetainage(HttpServletRequest request,
												@RequestParam("com_id")String com_id,
												@RequestParam("money")double money
												){
		Map<String,Object> commodityOrder=commodityOrderService.getCommodityOrderByComId(com_id);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("com_id", com_id);
		map.put("retainage", 0);
		map.put("order_state", 1);
		
		try{
			commodityOrderService.updateCommodityOrderState1(map);	
		}catch(Exception e){
			map.put("sign", 0);
			return map;
		}
		map.put("sign", 1);
		return map;
	}
	
	
	/**
	 * 查看所有订单
	 * @param  
	 * @return
	 */
	@RequestMapping("/findAllMyOrder_hompage")
	public String findAllMyOrder_hompage(HttpServletRequest request){
			String open_id=(String) request.getSession().getAttribute("openid");
			User user=userService.getByOpenid(open_id);
			String au_id=user.getAu_id();
			List<Map<String,Object>> commodity_order=commodityOrderService.selectAllMyCommodityOrder_state0(au_id);
			List<Map<String,Object>> install_order=installService.selectAllMyInstallOrder_state0(au_id);
			List<Map<String,Object>> maintain_order=maintainService.selectAllMyMaintainOrder_state0(au_id);
			List<Map<String,Object>> repair_order=repairService.selectAllMyRepairOrder_state0(au_id);
			request.setAttribute("commodity_order", commodity_order);
			request.setAttribute("install_order", install_order);
			request.setAttribute("maintain_order", maintain_order);
			request.setAttribute("repair_order", repair_order);
			request.setAttribute("user", user);
			return "/gongzhonghao/MyOrder.jsp";
	}

	/**
	 * 查看订单详情
	 * @param  
	 * @return
	 */
	@RequestMapping("/getCommodityOrderDetail")
	public String getCommodityOrderDetail(HttpServletRequest request,
										@RequestParam("com_id")String com_id
										){
		Map<String,Object> commodity_order=commodityOrderService.getCommodityOrderByComId(com_id);
		request.setAttribute("commodity_order", commodity_order);
		String au_id=(String)commodity_order.get("au_id");
		String c_id=(String)commodity_order.get("c_id");
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("com_id", com_id);
		map.put("c_id", c_id);
		map.put("au_id", au_id);
     	Map<String,Object> eva=commodityEvaluateService.selectEvaluteByCidAndAuid(map);
     	request.setAttribute("eva", eva);
     	
     	User user=userService.selectUserByauId(au_id);
     	request.setAttribute("user", user);
     	
		return "/person/Evalute.jsp";
	}
	
	/**
	 * 查看订单评价详情
	 * @param  
	 * @return
	 */
	@RequestMapping("/findCommodityOrderEvaDetail")
	public String findCommodityOrderDetail(HttpServletRequest request,
										@RequestParam("com_id")String com_id
										){
//		Map<String,Object> commodity_Order=commodityOrderService.getCommodityOrderByComId(com_id);
//		String au_id= (String)commodity_Order.get("au_id");
//		String c_id=(String )commodity_Order.get("c_id");
//		一个订单可以有  第一次评论 追评...等等
		List<Map<String,Object>> eva=commodityEvaluateService.selectCommodityEvaInnerJoinUserByComId(com_id);
		request.setAttribute("eva", eva);
		return "/management/EvaDetail.jsp";
	}
	
	/**
	 * 未支付点击删除 - -  删除订单
	 * @param  
	 * @return
	 */
	@RequestMapping("/deleteCommodityOrder")
	public String deleteCommodityOrder(HttpServletRequest request,
									@RequestParam("com_id")String com_id
									){
		commodityOrderService.deleteCommodityOrderByComId(com_id);
		String open_id=(String) request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		String au_id=user.getAu_id();
		List<Map<String,Object>> commodity_order=commodityOrderService.selectAllMyCommodityOrder_state0(au_id);
		List<Map<String,Object>> commodity_order2=commodityOrderService.selectCentralAirCreateByUser(au_id);
		commodity_order.addAll(commodity_order2);//将2结果添加给1   发送1
		List<Map<String,Object>> install_order=installService.selectAllMyInstallOrder_state0(au_id);
		List<Map<String,Object>> maintain_order=maintainService.selectAllMyMaintainOrder_state0(au_id);
		List<Map<String,Object>> repair_order=repairService.selectAllMyRepairOrder_state0(au_id);
		request.setAttribute("commodity_order", commodity_order);
		request.setAttribute("install_order", install_order);
		request.setAttribute("maintain_order", maintain_order);
		request.setAttribute("repair_order", repair_order);
		request.setAttribute("user", user);
		return "/gongzhonghao/MyOrder.jsp";
	}
	
}
