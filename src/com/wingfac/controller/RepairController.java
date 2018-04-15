package com.wingfac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wingfac.entity.Address;
import com.wingfac.entity.Repair;
import com.wingfac.entity.RepairOrder;
import com.wingfac.entity.User;
import com.wingfac.service.CommodityOrderService;
import com.wingfac.service.CommodityService;
import com.wingfac.service.InstallService;
import com.wingfac.service.MaintainService;
import com.wingfac.service.RepairService;
import com.wingfac.service.UserService;
import com.wingfac.util.ResponseSuccessOrFail;
import com.wingfac.util.TimeUtil;
import com.wingfac.util.lcRamdomUtil;

/**
 *  @描述：维修接口
 *  @author LC   
 *  创建时间：2018-3-2 上午9:35
 */
@Controller
@Scope(value="prototype")
@RequestMapping("RepairController")
public class RepairController {
		
	@Resource(name="repairService")
	private RepairService repairService;
	
	@Resource(name="commodityOrderService")
	private CommodityOrderService commodityOrderService;
	
	@Resource(name="installService")
	private InstallService installService;
	
	@Resource(name="maintainService")
	private MaintainService maintainService;
	
	@Resource(name="userService")
	private UserService userService;

	/**
	 * 添加维修
	 * @param brand				空调品牌
	 * @param type				空调类型0挂机1柜机2分体机
	 * @param purpose			空调用途 0家用分体式1家用中央空调2商用中央空调
	 * @param level				匹数
	 * @param explain			问题故障说明
	 * @return
	 */
	@RequestMapping("/addRepair")
	@ResponseBody
	public Object addRepair(HttpServletRequest request,HttpServletResponse response,
					@RequestParam(value = "brand",required = false,defaultValue = "格力")String brand,
					@RequestParam(value = "purpose",required = false,defaultValue = "0")int purpose,
					@RequestParam(value = "type",required = false,defaultValue = "0")int type,
					@RequestParam(value = "level",required = false,defaultValue = "1匹")String level,
					@RequestParam(value = "explain",required =false,defaultValue = "无")String explain
					){
		lcRamdomUtil lc=new lcRamdomUtil();
		String repair_id = lc.getRamdomString();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("repair_id", repair_id);
		map.put("brand", brand);
		map.put("type", type);
		map.put("purpose", purpose);
		map.put("level", level);
		map.put("explain", explain);
		
		repairService.addRepair(map);
		Repair repair = repairService.selectRepairByRepairId(repair_id);
		
		return repair;
	}
	
	/**
	 * 添加维修订单
	 * @param 
	 * @param 
	 * @param 
	 * @param 
	 * @param 
	 * @return
	 */
	@RequestMapping("/addRepairOrder")
	@ResponseBody
	public List<RepairOrder> addRepairOrder(HttpServletRequest request,HttpServletResponse response,
							@RequestParam(value = "repairId",required = true)String repair_id,
							@RequestParam(value = "openId",required = true)String open_id,
							@RequestParam(value = "time",required = true)String time,
							@RequestParam(value = "person",required = false,defaultValue = "无")String person,
							@RequestParam(value = "tellphone",required = false,defaultValue ="0")String tellphone,
							@RequestParam(value = "address",required = false,defaultValue ="北京市朝阳区人民群众")String address,
							@RequestParam(value = "totalPrice",required = false,defaultValue = "0" )double total_price,
							@RequestParam(value = "deposit",required = false,defaultValue = "0")double deposit,
							@RequestParam(value = "retainage",required = false,defaultValue = "0")double retainage,
							@RequestParam(value = "timeStage",required = false,defaultValue = "0")int time_stage
							){
		lcRamdomUtil lc=new lcRamdomUtil();
		String repair_order_id=lc.getRamdomString();
		
		TimeUtil t = new TimeUtil();
		
		User user = userService.getByOpenid(open_id);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("repair_order_id", repair_order_id);
		map.put("repair_id", repair_id);
		map.put("au_id", user.getAu_id());
		map.put("time", time);
		map.put("person", person);
		map.put("tellphone", tellphone);
		map.put("address", address);
		map.put("totalPrice", total_price);
		map.put("deposit", deposit);
		map.put("retainage", retainage);
		map.put("timeStage", time_stage);
		map.put("create_time",t.getSystemTimeFormart());
		
		repairService.createRepairOrder(map);
		List<RepairOrder> list = repairService.selectRepairOrderByRepairId(repair_id);
		
		return list;
	}
	
	@RequestMapping("/createRepairAndTarget")
	public String createRepairAndTarget(HttpServletRequest request,
									@RequestParam("brand")String brand,
									@RequestParam("purpose")String purpose,
									@RequestParam("type")String type,
									@RequestParam("level")String level
									){
		String open_id=(String)request.getSession().getAttribute("openid");   //从session里获取
		//String open_id="123123";
		lcRamdomUtil lc=new lcRamdomUtil();
		String repair_id=lc.getRamdomString();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("repair_id", repair_id);
		map.put("brand", brand);
		map.put("purpose", purpose);
		map.put("type", type);
		map.put("level", level);
		repairService.createRepair(map);
		
		Repair repair=repairService.selectRepairByRepairId(repair_id);
		request.setAttribute("repair", repair);
		
		User user=userService.getByOpenid(open_id);
		List<Address> list=userService.selectAddressByAuId(user.getAu_id());
		try{
			if(list.size()<1){
				System.out.println("该用户还没有创建过地址信息");
				request.setAttribute("au_id", user.getAu_id());
				return "/gongzhonghao/repairAddress.jsp";
			}else{
				System.out.println("该用户已经设置了地址信息");
				Address address=list.get(0);
				request.setAttribute("address", address);
			}
		}catch(Exception e){
			System.out.println("该用户还没有创建订单");
		}
		
		
		return "/gongzhonghao/repairConfirmOrder.jsp";
	}
	
	@RequestMapping("/createGongZhongHaoAddress")
	public String createGongZhongHaoAddress(HttpServletRequest request,
										@RequestParam("repair_id")String repair_id,
										@RequestParam("au_id")String au_id,
										@RequestParam("name")String name,
										@RequestParam("mobile")String mobile,
										@RequestParam("province")String province,
										@RequestParam("detail")String detail
										){
		lcRamdomUtil lc=new lcRamdomUtil();
		String a_id=lc.getRamdomString();
		TimeUtil t=new TimeUtil();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("a_id", a_id);
		map.put("au_id", au_id);
		map.put("name", name);
		map.put("mobile", mobile);
		map.put("province", province);
		map.put("detail", detail);
		map.put("create_time", t.getSystemTimeFormart());
		userService.addNewAddressByUser(map);
		Address address=userService.getAddressInformationByAId(a_id);
		Repair repair=repairService.selectRepairByRepairId(repair_id);
		request.setAttribute("address", address);
		request.setAttribute("repair", repair);
		
		return "/gongzhonghao/repairConfirmOrder.jsp";
	}
	
	@RequestMapping("/targetCreateRepairOrder")
	public String targetCreateMainta1inOrder(HttpServletRequest request,
										@RequestParam("repair_id")String repair_id,
										@RequestParam("a_id")String a_id
										){
		Repair repair=repairService.selectRepairByRepairId(repair_id);
		Address address=userService.getAddressInformationByAId(a_id);
		request.setAttribute("repair", repair);
		request.setAttribute("address", address);
		
		return "/gongzhonghao/repairAppoint.jsp";
	}
	
	/**
	 * 添加维修订单
	 * @param 
	 * @return
	 */
	@RequestMapping("/createRepairOrderGongZhongHao")
	public String createRepairOrderGongZhongHao(HttpServletRequest request,
											@RequestParam("repair_id")String repair_id,
											@RequestParam("a_id")String a_id,
											@RequestParam("time")String time,
											@RequestParam("time_stage")String time_stage
											
											){
		Repair repair=repairService.selectRepairByRepairId(repair_id);
		Address address=userService.getAddressInformationByAId(a_id);
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		String repair_order_id=lc.getRamdomString();
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("repair_order_id", repair_order_id);
		map.put("repair_id", repair_id);
		map.put("au_id", address.getAu_id());
		map.put("time", time);
		map.put("person", address.getName());
		map.put("tellphone", address.getMobile());
		map.put("address",address.getProvince()+address.getDetail());
		map.put("total_price",100);
		map.put("time_stage", time_stage);
		map.put("create_time", t.getSystemTimeFormart());
		
		repairService.insertRepairOrder(map);
		Map<String,Object> repair_order=repairService.getRepairOrderByRepairOrderId(repair_order_id);
		request.setAttribute("repair", repair);
		request.setAttribute("address", address);
		request.setAttribute("repair_order", repair_order);
		String au_id=address.getAu_id();
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		
		return "/gongzhonghao/repairConfirmOrder.jsp";
	}
	
	/**
	 * 跳转到查看订单详情页面
	 * @param 
	 * @return
	 */
	@RequestMapping("/targetRepairOrderDetail")
	public String targetRepairOrderDetail(HttpServletRequest request,
										@RequestParam("repair_order_id")String repair_order_id
										){
		Map<String,Object> repair_order=repairService.getRepairOrderByRepairOrderId(repair_order_id);
		request.setAttribute("repair_order", repair_order);
		String repair_id=(String)repair_order.get("repair_id");
		
		
		Repair repair=repairService.selectRepairByRepairId(repair_id);
		request.setAttribute("repair", repair);
		
		return "/gongzhonghao/repairOrderDetail.jsp";
	}
	
	/**
	 * 跳转到维修详情界面
	 * @param 
	 * @return
	 */
	@RequestMapping("/selectRepairPic")
	public String selectRepairPic(HttpServletRequest request,
								@RequestParam("repair_order_id")String repair_order_id
								){
		System.out.println(repair_order_id);
		Map<String,Object> repair_order=repairService.getRepairOrderByRepairOrderId(repair_order_id);
		request.setAttribute("repair_order", repair_order);
		System.out.println("进入关键节点");
		request.setAttribute("aaa", "这是个bug");
		
		return "/gongzhonghao/repairOrderSchedule.jsp";
	}
	
	/**
	 * 已支付维修订单 修改订单状态
	 * @param 
	 * @return
	 */
	@RequestMapping("/updateRepairOrderState1")
	public String updateRepairOrderState1(@RequestParam("repair_order_id")String repair_order_id){
		repairService.updateRepairOrderState1(repair_order_id);
		return "/gongzhonghao/homePage.html";
	}
	
	/**
	 * 查看维修订单 评价详情
	 * @param 
	 * @return
	 */
	@RequestMapping("/findRepairEvaDetail")
	public String findRepairEvaDetail(HttpServletRequest request,
									@RequestParam("repair_order_id")String repair_order_id
									){
		List<Map<String,Object>> eva=repairService.findRepairEvaDetail(repair_order_id);
		request.setAttribute("eva", eva);
		return "/management/repairEvaDetail.jsp";
	}
	
	/**
	 * 删除安装
	 * @param 
	 * @return
	 */
	@RequestMapping("deleteRepair")
	public String deleteRepair(@RequestParam("repair_id")String repair_id){
		repairService.deleteRepairByRepairId(repair_id);
		return "/gongzhonghao/homePage.html";
	}
	
	/**
	 * 删除安装  订单+商品  返回MyOrder.jsp
	 * @param 
	 * @return
	 */
	@RequestMapping("/deleteRepairAndOrder")
	public String deleteRepairAndOrder(HttpServletRequest request,
									@RequestParam("repair_order_id")String repair_order_id
									){
		Map<String,Object> repairOrder=repairService.selectReapirOrderById(repair_order_id);
		String repair_id=(String)repairOrder.get("repair_id");
		repairService.deleteRepairOrderById(repair_order_id);
		repairService.deleteRepairByRepairId(repair_id);
		
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
