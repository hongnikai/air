package com.wingfac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.wingfac.entity.Address;
import com.wingfac.entity.MaintainOrder;
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
 *  @描述：安装接口
 *  @author LC   
 *  创建时间：2018-2-26 上午9:35
 */
@Controller
@Scope(value="prototype")
@RequestMapping("MaintainController")
public class MaintainController {
	
	@Resource(name="maintainService")
	private MaintainService maintainService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="commodityService")
	private CommodityService commodityService;
	
	@Resource(name="repairService")
	private RepairService repairService;
	
	@Resource(name="installService")
	private InstallService installService;
	
	@Resource(name="commodityOrderService")
	private CommodityOrderService commodityOrderService;
	
	/**
	 * 添加保养
	 * @param brand				空调品牌
	 * @param type				空调类型0挂机1柜机2分体机
	 * @param purpose			空调用途 0家用分体式1家用中央空调2商用中央空调
	 * @param level				匹数
	 * @return
	 */
	@RequestMapping("/addMaintain")
	@ResponseBody
	public ResponseSuccessOrFail addMaintain(HttpServletRequest request,HttpServletResponse response,
							@RequestParam(value = "brand",required = false,defaultValue = "格力")String brand,
							@RequestParam(value = "purpose",required = false,defaultValue = "0")int purpose,
							@RequestParam(value = "type",required = false,defaultValue = "0")int type,
							@RequestParam(value = "level",required = false,defaultValue = "1匹")String level
							){
		lcRamdomUtil lc = new lcRamdomUtil();
		String maintain_id= lc.getRamdomString();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("maintain_id", maintain_id);
		map.put("brand", brand);
		map.put("purpose", purpose);
		map.put("type", type);
		map.put("level", level);
		maintainService.addMaintain(map);
	
		Map<String,Object> result_map = maintainService.selectMaintainByMaintainId(maintain_id);
		
		return new ResponseSuccessOrFail("SUCCESS",result_map);
	}
	
	/**
	 * 添加保养订单
	 * @return
	 */
	@RequestMapping("/addMaintainOrder")
	@ResponseBody
	public ResponseSuccessOrFail addMaintainOrder(HttpServletRequest request,HttpServletResponse response,
								@RequestParam(value = "maintainId",required = true)String maintain_id,
								@RequestParam(value = "openId",required = true)String open_id,
								@RequestParam(value = "time",required = true)String time,
								@RequestParam(value = "person",required = false,defaultValue = "无")String person,
								@RequestParam(value = "tellphone",required = false,defaultValue ="0")String tellphone,
								@RequestParam(value = "address",required = false,defaultValue ="北京市朝阳区人民群众")String address,
								@RequestParam(value = "totalPrice",required = false,defaultValue = "0" )double total_price,
								@RequestParam(value = "deposit",required = false,defaultValue = "0")double deposit,
								@RequestParam(value = "retainage",required = false,defaultValue = "0")double retainage,
								@RequestParam(value = "time_stage",required = false,defaultValue = "0")int time_stage
							){
		lcRamdomUtil lc=new lcRamdomUtil();
		String maintain_order_id=lc.getRamdomString();
		TimeUtil t = new TimeUtil();
		
		User user=userService.getByOpenid(open_id);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("maintain_order_id", maintain_order_id);
		map.put("maintain_id", maintain_id);
		map.put("au_id", user.getAu_id());
		map.put("time", time);
		map.put("person", person);
		map.put("tellphone", tellphone);
		map.put("address", address);
		map.put("totalPrice", total_price);
		map.put("deposit", deposit);
		map.put("retainage", retainage);
		map.put("time_stage", time_stage);
		map.put("create_time", t.getSystemTimeFormart());
		
		maintainService.addMaintainOrder(map);
		
		List<MaintainOrder> list = maintainService.selectMaintainOrderByMaintain_id(maintain_id);
		
		return new ResponseSuccessOrFail("SUCCESS", list);
	}
	
	/**
	 *  创建保养商品然后跳转
	 * @return
	 */
	@RequestMapping("/createMaintainAndTarget")
	public String createMaintainAndTarget(HttpServletRequest request,
										@RequestParam(value="brand",required=true)String brand,
										@RequestParam(value="purpose",required=true)int purpose,
										@RequestParam(value="type",required=true)int type,
										@RequestParam(value="level",required=true)String level
										){
		String open_id=(String)request.getSession().getAttribute("openid");   //从session里获取
		//String open_id="123123";
		lcRamdomUtil lc=new lcRamdomUtil();
		String maintain_id=lc.getRamdomString();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("maintain_id", maintain_id);
		map.put("brand", brand);
		map.put("purpose", purpose);
		map.put("type", type);
		map.put("level", level);
		
		maintainService.addMaintain(map);
		Map<String, Object> maintain=maintainService.selectMaintainByMaintainId(maintain_id);
		request.setAttribute("maintain", maintain);
		
		
		User user=userService.getByOpenid(open_id);
		List<Address> list=userService.selectAddressByAuId(user.getAu_id());
		try{
			if(list.size()<1){
				System.out.println("该用户还没有创建过地址信息");
				request.setAttribute("au_id", user.getAu_id());
				return "/gongzhonghao/maintainAddress.jsp";
			}else{
				System.out.println("该用户已经设置了地址信息");
				Address address=list.get(0);
				request.setAttribute("address", address);
			}
			
		}catch(Exception e){
			System.out.println("该用户还没有创建订单");
		}
		
		return "/gongzhonghao/maintainConfirmOrder.jsp";
	}
	
	
	/**
	 *  删除保养
	 * @return
	 */
	@RequestMapping("/deleteMaintian")
	public String deleteMaintian(HttpServletRequest request,
								@RequestParam(value="maintain_id",required=true)String maintain_id
								){
		maintainService.deleteMaintainByMaintainId(maintain_id);
		return "/gongzhonghao/maintain.html";
	}
	
	@RequestMapping("/createGongZhongHaoAddress")
	public String createGongZhongHaoAddress(HttpServletRequest request,
										@RequestParam(value="maintain_id",required=true)String maintain_id,
										@RequestParam(value="au_id",required=true)String au_id,
										@RequestParam(value="name",required=true)String name,
										@RequestParam(value="mobile",required=true)String mobile,
										@RequestParam(value="province",required=true)String province,
										@RequestParam(value="detail",required=true)String detail
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
		
		Map<String,Object> maintain=maintainService.selectMaintainByMaintainId(maintain_id);
		Address address=userService.getAddressInformationByAId(a_id);
		request.setAttribute("address", address);
		request.setAttribute("maintain", maintain);;
		
		
		return "/gongzhonghao/maintainConfirmOrder.jsp";
	}
	/**
	 *  创建并跳转保养订单
	 * @return
	 */
	@RequestMapping("/targetCreateMainta1inOrder")
	public String targetCreateMainta1inOrder(HttpServletRequest request,
											@RequestParam(value="maintain_id",required=true)String maintain_id,
											@RequestParam(value="a_id",required=true)String a_id
											){
		Address address=userService.getAddressInformationByAId(a_id);
		Map<String,Object> map= maintainService.selectMaintainByMaintainId(maintain_id);
		request.setAttribute("maintain", map);
		request.setAttribute("address", address);
		return "/gongzhonghao/maintainAppoint.jsp";
	}
	/**
	 *  公众号：创建保养订单
	 * @return
	 */
	@RequestMapping("/createMaintainOrderGongZhongHao")
	public String createMaintainOrderGongZhongHao(HttpServletRequest request,
												@RequestParam(value="a_id",required=true)String a_id,
												@RequestParam(value="maintain_id",required=true)String maintain_id,
												@RequestParam(value="time")String time,
												@RequestParam("time_stage")int time_stage
												){
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		Address address=userService.getAddressInformationByAId(a_id);
		Map<String,Object> maintain=maintainService.selectMaintainByMaintainId(maintain_id);
		Map<String,Object> map=new HashMap<String,Object>();
		String maintain_order_id=lc.getRamdomString();
		map.put("maintain_order_id",maintain_order_id);
		map.put("maintain_id", maintain_id);
		map.put("au_id", address.getAu_id());
		map.put("time", time);
		map.put("person", address.getName());
		map.put("tellphone", address.getMobile());
		map.put("address", address.getProvince()+address.getDetail());
		map.put("total_price", 100);
		map.put("time_stage", time_stage);
		map.put("create_time", t.getSystemTimeFormart());
		
		maintainService.createMaintainOrder(map);
		User user=userService.selectUserByauId(address.getAu_id());
		Map<String,Object> maintain_order=maintainService.getMaintainOrderByMaintainOrderId(maintain_order_id);
		request.setAttribute("maintain_order", maintain_order);
		request.setAttribute("address", address);
		request.setAttribute("maintain", maintain);
		request.setAttribute("user", user);
		
		return "/gongzhonghao/maintainConfirmOrder.jsp";
	}
	/**
	 *  跳转到：保养订单详情
	 * @return
	 */
	@RequestMapping("/targetmaintainOrderDetail")
	public String targetmaintainOrderDetail(HttpServletRequest request,
										@RequestParam("maintain_order_id")String maintain_order_id
										){
		Map<String,Object> maintain_order=maintainService.getMaintainOrderByMaintainOrderId(maintain_order_id);
		String maintain_id=(String) maintain_order.get("maintain_id");
		Map<String,Object> maintain=maintainService.selectMaintainByMaintainId(maintain_id);
		request.setAttribute("maintain", maintain);
		request.setAttribute("maintain_order", maintain_order);
		
		return "/gongzhonghao/maintainOrderDetail.jsp";
	}
	
	/**
	 *  查询保养订单表图片
	 * @return
	 */
	@RequestMapping("/selectMaintainOrderPic")
	public String selectMaintainOrderPic(HttpServletRequest request,
										@RequestParam("maintain_order_id")String maintain_order_id
										){
		Map<String,Object> maitain_order=maintainService.getMaintainOrderByMaintainOrderId(maintain_order_id);
		request.setAttribute("maintain_order", maitain_order);
		
		return "/gongzhonghao/maintainOrderSchedule.jsp";
	}
	
	/**
	 * 对支付成功的订单，修改订单状态
	 * @return
	 */
	@RequestMapping("/changeMaintainOrderStage1")
	public String changeMaintainOrderStage1(HttpServletRequest request,
										@RequestParam("maintain_order_id")String maintain_order_id
										){
		maintainService.updateMaintainOrderState1(maintain_order_id);
		
		return "/gongzhonghao/homePage.html";
	}
	
	/**
	 * 查看保养订单评论 详情
	 * @return
	 */
	@RequestMapping("/findMaintainEvaDetail")
	public String findMaintainOrderEvaDetail(HttpServletRequest request,
											@RequestParam("maintain_order_id")String maintain_order_id
											){
		List<Map<String,Object>> eva=maintainService.findMaintainEvaByMaintainOrderId(maintain_order_id);
		request.setAttribute("eva", eva);
		return "/management/maintainEvaDetail.jsp";
	}
	
	/**
	 * 删除保养订单 和保养
	 * @return
	 */
	@RequestMapping("/deleteMaintainAndOrder")
	public String deleteMaintainAndOrder(HttpServletRequest request,
									@RequestParam("maintain_order_id")String maintain_order_id
									){
		Map<String,Object> maintainOrder=maintainService.selectMaintainOrderById(maintain_order_id);
		String maintain_id=(String)maintainOrder.get("maintain_id");
		maintainService.deleteMaintainOrderById(maintain_order_id);
		maintainService.deleteMaintainByMaintainId(maintain_id);
		
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
