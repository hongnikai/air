package com.wingfac.controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PUT;

import org.junit.Test;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wingfac.entity.Address;
import com.wingfac.entity.Install;
import com.wingfac.entity.InstallOrder;
import com.wingfac.entity.User;
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
 *  @描述：安装接口
 *  @author LC   
 *  创建时间：2018-2-26 上午9:35
 */
@Controller
@Scope(value="prototype")
@RequestMapping("InstallController")
public class InstallController {

	@Resource(name="installService")
	private InstallService installService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="maintainService")
	private MaintainService maintainService;
	
	@Resource(name="repairService")
	private RepairService repairService;
	
	@Resource(name="commodityService")
	private CommodityService commodityService;
	
	@Resource(name="commodityOrderService")
	private CommodityOrderService commodityOrderService;
	
	/**
	 * 添加安装
	 * @param ins_state			安装类型 0单装1单拆2移机3新空调安装
	 * @param brand				空调品牌
	 * @param type				空调类型0挂机1柜机2分体机
	 * @param purpose			空调用途 0家用分体式1家用中央空调2商用中央空调
	 * @param level				匹数
	 * @return
	 */
	@RequestMapping("/insertInstall")
	@ResponseBody
	public ResponseSuccessOrFail insertInstall(HttpServletRequest request,HttpServletResponse response,
							  @RequestParam(value = "instate",required = false,defaultValue = "3")int ins_state,
							  @RequestParam(value = "brand",required = false,defaultValue = "brand")String brand,
							  @RequestParam(value = "purpose",required = false,defaultValue = "0")int purpose,
							  @RequestParam(value = "type",required = false,defaultValue = "0")int type,
							  @RequestParam(value = "level",required = false,defaultValue = "1匹")String level
							  ){
		System.out.println("进入anhunsdasdasdasd");
			lcRamdomUtil lc = new lcRamdomUtil();
			Map<String,Object> map = new HashMap<String,Object>();
			String install_id = lc.getRamdomString();
			map.put("install_id", install_id);
			map.put("ins_state", ins_state);
			map.put("brand", brand);
			map.put("purpose", purpose);
			map.put("type", type);
			map.put("level", level);
			installService.insertInstall(map);
		Install install=installService.selectInstallByinstall_id(install_id);
		return new ResponseSuccessOrFail("响应成功",install);
	}
	
	/**
	 * 修改预约时间
	 * @param openId			
	 * @param time				预约时间
	 * @param time_stage		时间段 0全天 1上午 2下午
	 * @return
	 */
	@RequestMapping("/updateTimeofappointment")
	@ResponseBody
	public ResponseSuccessOrFail updateTimeofappointment(@RequestParam(value = "install_order_id",required = true)String install_order_id,
										@RequestParam(value = "time",required = true)String time,
										@RequestParam(value = "time_stage",required = false,defaultValue = "0")int time_stage
										){
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("install_order_id", install_order_id);
		map.put("time", time);
		map.put("time_stage", time_stage);
		
		installService.updateTimeByinstallId(map);
		InstallOrder install_order=installService.selectInstallOrderByinstallOrderId(install_order_id);
		if(install_order!=null){
			
			return new ResponseSuccessOrFail("响应成功", install_order);
		}
		
		return new ResponseSuccessOrFail("未知的错误","失败");
	}
	/**
	 * 创建安装订单
	 * @param installId			安装id
	 * @param openId			用户唯一标识
	 * @param time				预约时间	传入格式为: yyyy-MM-dd hh:mm:ss	 
	 * @param person			联系人	默认为无
	 * @param tellphone			联系电话 默认为0
	 * @param address			收货地址	默认为北京市朝阳区人民群众
	 * @param totalPrice		总价格    默认为0
	 * @param deposit			预定金	默认为0
	 * @param retainage			尾款		默认为0		
	 * @param time_stage		时间段 0全天 1上午 2下午 默认为0
	 * @return
	 */
	@RequestMapping("/createInstallOrder")
	@ResponseBody
	public ResponseSuccessOrFail createInstallOrder(HttpServletRequest request,HttpServletResponse response,
									@RequestParam(value = "installId",required = true)String install_id,
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
		lcRamdomUtil lc = new lcRamdomUtil();
		lc.getRamdomString();
		TimeUtil t = new TimeUtil();
		User user = userService.getByOpenid(open_id);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("install_order_id", lc.getRamdomString());
		map.put("install_id", install_id);
		map.put("au_id", user.getAu_id());
		map.put("time", time);
		map.put("person", person);
		map.put("tellphone", tellphone);
		map.put("address", address);
		map.put("total_price", total_price);
		map.put("deposit", deposit);
		map.put("retainage", retainage);
		map.put("time_stage", time_stage);
		map.put("create_time", t.getSystemTimeFormart());
		
		installService.createInstallOrderByInstall(map);
		
		List<InstallOrder> list = installService.selectInstallOrderByAuId(user.getAu_id());
		if(list.size()<1){
			return new ResponseSuccessOrFail("FAIL", "失败");
		}
		
		return new ResponseSuccessOrFail("SUCCESS", list);
	}
	
	/**
	 * 添加安装
	 * @param ins_state			安装类型 0单装1单拆2移机3新空调安装
	 * @param brand				空调品牌
	 * @param type				空调类型0挂机1柜机2分体机
	 * @param purpose			空调用途 0家用分体式1家用中央空调2商用中央空调
	 * @param level				匹数
	 * @return
	 */
	@RequestMapping("/insertInstallGongZhongHao")
	public String insertInstallGongZhongHao(HttpServletRequest request,HttpServletResponse response,
										@RequestParam(value="ins_state",required=true)int ins_state,
										@RequestParam(value="brand",required=true)String brand,
										@RequestParam(value="purpose",required=true)int purpose,
										@RequestParam(value="type",required=true)int type,
										@RequestParam(value="level",required=true)String level
										){
		lcRamdomUtil lc=new lcRamdomUtil();
		String install_id=(lc.getFourRamdomString()+lc.getFourRamdomString());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("install_id", install_id);
		map.put("ins_state", ins_state);
		map.put("brand", brand);
		map.put("purpose", purpose);
		map.put("type", type);
		map.put("level", level);
		installService.insertInstall(map);
		
		request.setAttribute("install_id", install_id);			//发送了安装id
		request.setAttribute("brand", brand);					//发送了空调品牌
		
		request.setAttribute("level", level);//匹数
		if(ins_state==0){
			request.setAttribute("ins_state", "单装");//安装类型 0单装1单拆2移机3新空调安装
		}else if(ins_state==1){
			request.setAttribute("ins_state", "单拆");//安装类型 0单装1单拆2移机3新空调安装
		}else if(ins_state==2){
			request.setAttribute("ins_state", "移机");//安装类型 0单装1单拆2移机3新空调安装
		}else if(ins_state==3){
			request.setAttribute("ins_state", "新空调安装");
		}
		
		if(purpose==0){
			request.setAttribute("purpose", "家用分体式");//空调用途 0家用分体式1家用中央空调2商用中央空调
		}else if(purpose==1){
			request.setAttribute("purpose", "家用中央空调");//空调用途 0家用分体式1家用中央空调2商用中央空调
		}else if(purpose==2){
			request.setAttribute("purpose", "商用中央空调");//空调用途 0家用分体式1家用中央空调2商用中央空调
		}
		
		if(type==0){
			request.setAttribute("type", "挂机");//空调类型0挂机1柜机2分体机
		}else if(type==1){
			request.setAttribute("type", "柜机");//空调类型0挂机1柜机2分体机
		}else if(type==2){
			request.setAttribute("type", "分体机");//空调类型0挂机1柜机2分体机
		}
		/********************* 判定个人用户之前是否设置过默认地址-默认地址在user表里的addresss字段***************************************************************************/		
		String openid=(String)request.getSession().getAttribute("openid");   //从session里获取
		//String openid="oorAYxKwiAmP-1emkOYg9o9n1XWRE";
		User user= userService.getByOpenid(openid);
		List<Address> list=userService.selectAddressByAuId(user.getAu_id());
	
		request.setAttribute("au_id", user.getAu_id()); //发送了au_id
		try{
			if(list.size()<1){
				System.out.println("该用户还没有创建过地址信息");
				return "/gongzhonghao/mineAddressEdit.jsp";
			}else{
				System.out.println("该用户已经设置了地址信息");
				
			}
			String detail=list.get(0).getDetail();
			String province=list.get(0).getProvince();
			String address=(detail+province);
			request.setAttribute("address", address);	// 发送了地址信息
		}catch(Exception e){
			System.out.println("try异常，原因可能是查询地址信息出错！");
			return "/gongzhonghao/mineAddressEdit.jsp";
		}
		
		 System.out.println("获取地址没有异常");
		 String person=list.get(0).getName();
		 request.setAttribute("person", person);		//发送了收货人信息
		 request.setAttribute("price", 100);			//发送了安装费		
		 String a_id=list.get(0).getA_id();
		
		String address=(list.get(0).getProvince()+list.get(0).getDetail());
		if(address.equals("0")||address.equals("")||address==null){
			System.out.println("该用户还没有设置默认地址");
			return "/gongzhonghao/mineAddressEdit.jsp";
		}else{
			System.out.println("地址不为0");
			System.out.println("没有出现异常后,地址信息为:"+address);
			request.setAttribute("address", address);   //发送了地址信息
			String mobile=list.get(0).getMobile();
			request.setAttribute("mobile", "110");	//发送了创建的联系人电话
			System.out.println("发送了a_id");
			request.setAttribute("a_id", a_id);   		//发送了a_id
		}
		
		return "/gongzhonghao/installConfirmOrder.jsp";
	}
	
	/**
	 * 创建安装订单公众号-创建时间段
	 * @param 
	 * @return
	 */
	@RequestMapping("/createInstallOrderGongZhongHao")
	public String createInstallOrderGongZhongHao(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "install_id",required = true)String install_id,
			@RequestParam(value = "au_id",required = true)String au_id,
			@RequestParam(value = "time",required = true,defaultValue="0")String time,
			@RequestParam(value = "time_stage",required = false,defaultValue = "0")int time_stage,
			@RequestParam(value=  "address",required=true)String address,
			@RequestParam(value=  "person",required=true)String person,
			@RequestParam(value=  "mobile",required=true)String mobile
			
												){
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		String install_order_id=lc.getFourRamdomString();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("install_order_id", install_order_id);
		map.put("install_id", install_id);
		map.put("au_id", au_id);
		map.put("time", time);
		map.put("time_stage", time_stage);
		map.put("address", address);
		map.put("person", person);
		map.put("tellphone", mobile);
		map.put("total_price", 100); //订单价格先不算进逻辑
		map.put("create_time", t.getSystemTimeFormart());
		installService.createInstallOrder(map);
		
		List<Address> list=userService.selectAddressByAuId(au_id);
		User user=userService.selectUserByauId(au_id);
		String a_id=list.get(0).getA_id();
		request.setAttribute("person", person);
		request.setAttribute("install_id", install_id);
		request.setAttribute("time", time);
		request.setAttribute("address", address);
		request.setAttribute("install_order_id", install_order_id);
		request.setAttribute("mobile", mobile);
		request.setAttribute("au_id", au_id);
		request.setAttribute("a_id", a_id);
		request.setAttribute("user", user);
		request.setAttribute("price", 100);
		
		Map<String,Object> install=installService.selectInstallByInstallId(install_id);
		request.setAttribute("brand", install.get("brand"));
		request.setAttribute("purpose", install.get("purpose"));
		request.setAttribute("type", install.get("type"));
		
		return "/gongzhonghao/installConfirmOrder.jsp";
	}
	
	/**
	 * 创建安装订单公众号-没有地址先创建地址
	 * @param installId			安装id
	 * @param openId			用户唯一标识
	 * @param time				预约时间	传入格式为: yyyy-MM-dd hh:mm:ss	 
	 * @param person			联系人	默认为无
	 * @param tellphone			联系电话 默认为0
	 * @param address			收货地址	默认为北京市朝阳区人民群众
	 * @param totalPrice		总价格    默认为0
	 * @param deposit			预定金	默认为0
	 * @param retainage			尾款		默认为0		
	 * @param time_stage		时间段 0全天 1上午 2下午 默认为0q
	 * @return
	 */
	@RequestMapping("/createGongZhongHaoAddress")
	public String createInstallOrderGongZhongHaoAddress(HttpServletRequest request,HttpServletResponse response,
													@RequestParam(value="au_id",required=true)String au_id,
													@RequestParam(value="install_id",required=true)String install_id,
													@RequestParam(value="person",required=true)String person,
													@RequestParam(value="tellphone",required=true)String tellphone,
													@RequestParam(value="city",required=true)String city,
													@RequestParam(value="detail",required=true)String detail
													){
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		String a_id=lc.getFourRamdomString();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("a_id", a_id);
		map.put("au_id", au_id);
		map.put("name", person);
		map.put("mobile", tellphone);
		map.put("province", city);
		map.put("detail", detail);
		map.put("create_time", t.getSystemTimeFormart());
		userService.addNewAddressByUser(map);
		String address=(city+detail);
		
		
		request.setAttribute("au_id", au_id);
		request.setAttribute("person", person);
		request.setAttribute("mobile", tellphone);
		request.setAttribute("address", address);
		request.setAttribute("total_price", 100);
		request.setAttribute("a_id", a_id);
		request.setAttribute("install_id", install_id);
		
		
		return "/gongzhonghao/installConfirmOrder.jsp";
	}
	
	/**
	 * 点击确定订单选项-跳转到查看订单详情
	 * @return
	 */
	@RequestMapping("/install_order_yes")
	public String install_order_yes(HttpServletRequest request,HttpServletResponse response,
								@RequestParam(value="au_id",required=true)String au_id
								){
		
		Map<String,Object> map=installService.selectTheNearestInstallOrderByAu_id(au_id);
		String install_id=(String) map.get("install_id");
		Install install=installService.selectInstallByinstall_id(install_id);
		
		request.setAttribute("map", map);
		request.setAttribute("install", install);
		return "/gongzhonghao/installOrderDetail.jsp";
	}

	/**
	 * 跳转到安装时间段界面
	 * @return
	 */
	@RequestMapping("/timeStage")
	public String timeStage(HttpServletRequest request,
			@RequestParam(value="install_id",required=true)String install_id,
			@RequestParam(value="au_id",required=true)String au_id,
			@RequestParam(value="address",required=true)String address,
			@RequestParam(value="person",required=true)String person,
			@RequestParam(value="mobile",required=true)String mobile
 			){
		request.setAttribute("au_id", au_id);
		request.setAttribute("install_id", install_id);
		request.setAttribute("address", address);
		request.setAttribute("person", person);
		request.setAttribute("mobile", mobile);
		return "/gongzhonghao/installAppoint.jsp";
	}
	
	/**
	 * 修改安装订单地址信息
	 * @return
	 */
	@RequestMapping("/updateInstall_OrderAddress")
	public String updateInstall_OrderAddress(HttpServletRequest request,
											@RequestParam(value="install_order_id",required=true)String install_order_id,
											@RequestParam(value="address",required=true)String address,
											@RequestParam(value="person",required=true)String person,
											@RequestParam(value="price",required=true)String price,
											@RequestParam(value="mobile",required=true)String mobile
											){
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("install_order_id", install_order_id);
		 map.put("address", address);
		 map.put("person", person);
		 map.put("total_price", price);
		 map.put("tellphone", mobile);
		 installService.updateInstallOrderAddressInformation(map);
		
		return "/gongzhonghao/homePage.html";
	}
	
	/**
	 * 验收图片接口,查询了验收过程
	 * @return
	 */
	@RequestMapping("/selectInstallOrderPic")
	public String selectInstallOrderPic(HttpServletRequest request,
									@RequestParam(value="install_order_id",required=true)String install_order_id
									){
		InstallOrder installOrder=installService.selectInstallOrderByinstallOrderId(install_order_id);
		request.setAttribute("data", installOrder);
		
		return "/gongzhonghao/installOrderSchedule.jsp";
	}
	

	/**
	 * 跳转到：安装订单地址信息
	 * @return
	 */
	@RequestMapping("/targetChangeInstallOrderAddressInformation")
	public String targetChangeInstallOrderAddressInformation(HttpServletRequest request,
													@RequestParam(value="a_id",required=true)String a_id,
													@RequestParam(value="install_id",required=true)String install_id,
													@RequestParam(value="install_order_id",required=true)String install_order_id
													){
		request.setAttribute("a_id", a_id);
		request.setAttribute("install_id", install_id);
		request.setAttribute("install_order_id", install_order_id);
		return "/gongzhonghao/changeInstallOrderAddress.jsp";
	}
	

	/**
	 * 跳转到：安装订单地址信息
	 * @return
	 */
	@RequestMapping("/changeInstallOrderAddressInformation")
	public String changeInstallOrderAddressInformation(HttpServletRequest request,
													@RequestParam(value="a_id",required=true)String a_id,
													@RequestParam(value="person",required=true)String person,
													@RequestParam(value="tellphone",required=true)String tellphone,
													@RequestParam(value="city",required=true)String city,
													@RequestParam(value="detail",required=true)String detail,
													@RequestParam(value="install_id",required=true)String install_id,
													@RequestParam(value="install_order_id",required=true)String install_order_id
													){
		TimeUtil t=new TimeUtil();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("a_id",a_id);
		map.put("name", person);
		map.put("mobile", tellphone);
		map.put("province", city);
		map.put("detail", detail);
		map.put("create_time", t.getSystemTimeFormart());
		installService.updateAddressInformation(map);    //修改的是用户添加的地址信息
		request.setAttribute("a_id", a_id);
		request.setAttribute("person", person);
		request.setAttribute("address", city+detail);
		request.setAttribute("mobile", tellphone);
		Address address=userService.getAddressInformationByAId(a_id);
		System.out.println(a_id);
		
		
		/*****************************************************************************/
		
		
		
		request.setAttribute("au_id", address.getAu_id());
		request.setAttribute("install_id", install_id);
		
		try{//分析条件，如果用户已经创建完成订单,还想修改地址信息,页面将调取request域的信息，需要代码块判定情况
			InstallOrder install_order=installService.selectInstallOrderByinstallOrderId(install_order_id);	
			//修改订单地址
			Map<String,Object> map2=new HashMap<String,Object>();
			map2.put("install_order_id", install_order_id);
			map2.put("person", person);
			map2.put("address", address);
			map2.put("tellphone", tellphone);
			installService.updateInstallOrderAddressInformation(map2);
			
			/***************************************************************/
			request.setAttribute("install_order_id", install_order_id);
			request.setAttribute("time", install_order.getTime());
			request.setAttribute("price", install_order.getTotal_price());
			request.setAttribute("deposit", install_order.getDeposit());
			request.setAttribute("retainage", install_order.getRetainage());
			request.setAttribute("person", install_order.getPerson());
			request.setAttribute("install_id", install_order.getInstall_id());
			request.setAttribute("au_id", install_order.getAu_id());
			
			
		}catch(Exception e){
			System.out.println("用户还没有创建订单/或者是其他的异常");
		}
		
		return "/gongzhonghao/installConfirmOrder.jsp";
	}
	
	
	/**
	 * 跳转到：删除订单然后跳转到主页
	 * @return
	 */
	@RequestMapping("/deleteInstallOrderAndTarget")
	public String deleteInstallOrderAndTarget(HttpServletRequest request,
											@RequestParam(value="install_order_id",required=true)String install_order_id
											){
		installService.deleteInstallOrderByInstallOrderId(install_order_id);
		return "/gongzhonghao/homePage.html";
	}
	
	/**
	 * 跳转到：已付款订单修改订单状态
	 * @return
	 */
	@RequestMapping("/changeInstallOrderState1")
	public String changeInstallOrderState1(HttpServletRequest request,
										@RequestParam("install_order_id")String install_order_id
										){
		installService.updateInstallOrderState1(install_order_id);
		return "/gongzhonghao/homePage.html";
	}
	
	/**
	 * 跳转到：技术查看待接订单界面   
	 * @param sign：0 返回所有状态为已支付的待接技术单
	 * @param sign：1返回所有状态为456的技术单
	 * @param sign：2返回所有状态为7(已评价)的技术单
	 * @return
	 */
	@RequestMapping("/selectJiShuOrderWaitForGet")
	@ResponseBody
	public Object selectJiShuOrderWaitForGet(HttpServletRequest request,
											@RequestParam("au_id")String au_id,
											@RequestParam(value="sign",required=false,defaultValue="0")int sign
											){
		Map<String,Object> map=new HashMap<String, Object>();
		if(sign==0){
			List<Map<String,Object>> install_order=installService.selectInstallOrderPay();
			List<Map<String,Object>> maintain_order=maintainService.selectMaintainOrderPay();
			List<Map<String,Object>> repair_order=repairService.selectRepairOrderPay();
			
			map.put("install_order", install_order);
			map.put("maintain_order", maintain_order);
			map.put("repair_order", repair_order);
			return map;
		}else if(sign==1){
			List<Map<String,Object>> install_order=installService.selectInstallOrder4(au_id);
			List<Map<String,Object>> maintain_order=maintainService.selectMaintainOrderState5(au_id);
			List<Map<String,Object>> repair_order=repairService.selectRepairOrderState6(au_id);
			map.put("install_order", install_order);
			map.put("maintain_order", maintain_order);
			map.put("repair_order", repair_order);
			return map;
		}else if(sign==2){
			List<Map<String,Object>> install_order=installService.selectInstallOrder7(au_id);
			List<Map<String,Object>> maintain_order=maintainService.selectMaintainOrderState7(au_id);
			List<Map<String,Object>> repair_order=repairService.selectRepairOrderState7(au_id);
			map.put("install_order", install_order);
			map.put("maintain_order", maintain_order);
			map.put("repair_order", repair_order);
			return map;
		}
		
		return "";
	}
	

	/**
	 * 跳转到：技术查看待接订单界面
	 * @return
	 */
	@RequestMapping("/targetJiShuWaitForGet")
	public String targetJiShuWaitForGet(HttpServletRequest request,
										@RequestParam("au_id")String au_id
										){
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		return "/jishu/jishuWaitForGet.jsp";
	}
	
	/**
	 * 跳转到：技术查看未完成订单界面
	 * @return
	 */
	@RequestMapping("/targetJiShuNotComplete")
	public String targetJiShuNotComplete(HttpServletRequest request,
										@RequestParam("au_id")String au_id
										){
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		return "/jishu/jishuNotComplete.jsp";
	}
	
	/**
	 * 技术 人员接单接口
	 * @return
	 */
	@RequestMapping("/jishuGetOrders")
	@ResponseBody
	public Object jishuGetOrders(HttpServletRequest request,
							@RequestParam("order_id")String order_id,
							@RequestParam("au_id")String au_id,
							@RequestParam(value="sign",required=false,defaultValue="0")int sign
							 ){
		Map<String,Object> map=new HashMap<String,Object>();
		if(sign==0){//维修人员接单
			try{
				repairService.updateRepairOrderPrivate(order_id, au_id);	//order_state 修改为6
			}catch(Exception e){
				map.put("sign", "访问成功,数据库不对应/逻辑失败");
				return map;
			}
				map.put("sign", "接单成功");
			return map;
			
		}else if(sign==1){//保养人员接单
			try{
				maintainService.updateMaintainOrderPrivate(order_id, au_id);
			}catch(Exception e){
				map.put("sign", "访问成功,数据库不对应/逻辑失败");
				return map;
			}
				map.put("sign", "接单成功");
			return map;
			
		}else if(sign==2){//安装人员接单
			try{
				installService.updateInstallOrderPrivate(au_id, order_id);
			}catch(Exception e){
				map.put("sign", "访问成功,数据库不对应/逻辑失败");
				return map;
			}
				map.put("sign", "接单成功");
			return map;
		}
		return "";
	}
	
	/**
	 * 跳转到：技术查看未完成订单界面
	 * @return
	 */
	@RequestMapping("/targetJiShuComplete")
	public String targetJiShuComplete(HttpServletRequest request,
			@RequestParam("au_id")String au_id){
		
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		return "/jishu/jishuComplete.jsp";
	}
	
	/**
	 * 查看安装订单评价详情
	 * @param  
	 * @return
	 */
	@RequestMapping("/findInstallEvaDetail")
	public String findInstallEvaDetail(HttpServletRequest request,
									@RequestParam("install_order_id")String install_order_id
									){
		List<Map<String,Object>> eva=installService.findInstallEvaByInstallOrderId(install_order_id);
		request.setAttribute("eva", eva);
		return "/management/InstallEvaDetail.jsp";
	}
	
	/**
	 * 查看安装订单评价详情
	 * @param  
	 * @return
	 */
	@RequestMapping("/delectInstallAndOrder")
	public String delectInstallAndOrder(HttpServletRequest request,
									@RequestParam("install_order_id")String install_order_id
									){
		InstallOrder installOrder=installService.selectInstallOrderByinstallOrderId(install_order_id);
		String install_id=installOrder.getInstall_id();
		installService.deleteInstallOrderByInstallOrderId(install_order_id);
		installService.deleteInstallByInstallId(install_id);
		
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
