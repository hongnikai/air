package com.wingfac.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wingfac.bean.OAuthInfo;
import com.wingfac.entity.Address;
import com.wingfac.entity.User;
import com.wingfac.service.CommodityOrderService;
import com.wingfac.service.CommodityService;
import com.wingfac.service.InstallService;
import com.wingfac.service.MaintainService;
import com.wingfac.service.RepairService;
import com.wingfac.service.SystemService;
import com.wingfac.service.UserService;
import com.wingfac.util.Constants;
import com.wingfac.util.LocalResponseBody;
import com.wingfac.util.RandomUtil;
import com.wingfac.util.ResponseSuccessOrFail;
import com.wingfac.util.Season;
import com.wingfac.util.TimeUtil;
import com.wingfac.util.UploadUtil;
import com.wingfac.util.WeChatCommonUtil;
import com.wingfac.util.lcRamdomUtil;
/**
 ** @author LC
 *	描述：用户信息   
 *  创建时间：2018-2-16 下午05:27:30 
 */
@Controller
@RequestMapping("userController")
public class UserController{

	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="systemService")
	private SystemService systemService;
	
	@Resource(name="commodityService")
	private CommodityService commodityService;
	
	@Resource(name="commodityOrderService")
	private CommodityOrderService commodityOrderService;
	
	@Resource(name="installService")
	private InstallService installService;
	
	@Resource(name="maintainService")
	private MaintainService maintainService;
	
	@Resource(name="repairService")
	private RepairService repairService;
	
	/**
	 * app微信授权登录
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("login_wechat")
	public LocalResponseBody<Object> login_wechat(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("code") String code) {
		if (null != code && !"".equals(code)) {
			// 根据code换取openId
			OAuthInfo oa = WeChatCommonUtil.getOAuthOpenId(code);
			if (!"".equals(oa) && null != oa){
				String openid = oa.getOpenId();
	
				JSONObject jsonObject = WeChatCommonUtil.getUserInfo_App(oa.getAccessToken(),oa.getOpenId());
				User user = userService.getByOpenid(openid);
				if (user != null) {
					if (user.getDel_flag() == 0){
						return new LocalResponseBody<Object>(Constants.SUCCESS,Season.LOGIN_SUCCESS.getSeasonDesc());
					}else{
						return new LocalResponseBody<Object>(Constants.FAILED,"该帐号被禁止使用！",user);
					}
				} else {
					return new LocalResponseBody<Object>(Constants.FAILED,Season.NOT_REGISTER.getSeasonDesc(),jsonObject);
				}
			}
		}
		return new LocalResponseBody<Object>(Constants.FAILED,"未获取到code值");
	}
	
	/**
	 * 注册我的员工
	 * @param request
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/registeredEmployees")
	@ResponseBody
	public User registeredEmployees(HttpServletRequest request,HttpServletResponse response,
									  @RequestParam(value = "openId", required=true)String open_id,
									  @RequestParam(value = "nickname", defaultValue = "未填写", required = false)String nickname,
									  @RequestParam(value ="mobile",defaultValue="0",required = false)String mobile,
									  @RequestParam(value = "type", defaultValue = "0", required = false)int type){
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		lcRamdomUtil lc=new lcRamdomUtil();
		
		User user=userService.getByOpenid(open_id);
		String au_id=user.getAu_id();
		
		map.put("au_id", au_id);
		map.put("nickname", nickname);
		map.put("mobile", mobile);
		map.put("type", type);
		map.put("open_id", open_id);
		
		userService.updateUserNicenameMoblieTypeByAuId(map);
		
		User result = userService.selectUserByauId(au_id);
		
		return result;
	}
	
	/**
	 * 退出员工组
	 * @param request
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/sigeOutEmployees")
	@ResponseBody
	public String sigeOutEmployees(HttpServletRequest request,HttpServletResponse response,
								@RequestParam(value="openId",required=true)String open_id
								){
		User user=userService.getByOpenid(open_id);
		
		userService.updateUserTypeByAuId(user.getAu_id());
		
		return "SUCCESS";
	}
	
	/**
	 * 编辑资料
	 * @param request
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/uploadUserInformation")
	@ResponseBody
	public ResponseSuccessOrFail uploadHeadImg(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "file", required = false)MultipartFile[] file,
			@RequestParam(value="openId",required=true)String open_id,
			@RequestParam(value="nickname",required=false,defaultValue="老虎")String nickname,
			@RequestParam(value="mobile",required=false,defaultValue="0")String mobile,
			@RequestParam(value="sex",required=false,defaultValue="0")int sex
			){
		String path="pictures/demand/banners";
		UploadUtil u=new UploadUtil();
		String headimg=u.uploadFilesToPath(request, file[0], path);
		String complet_path="www.kongtiaoguanjia.com/"+headimg;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("open_id", open_id);
		map.put("nickname", nickname);
		map.put("mobile", mobile);
		map.put("sex", sex);
		map.put("headimg", complet_path);
		
		userService.updateUserInformation(map);
		User user=userService.getByOpenid(open_id);
		if(user.getAu_id()==null){
			return new ResponseSuccessOrFail("FAIL", "响应失败");
		}
		return new ResponseSuccessOrFail("SUCCESS", user);
	}
	
	/**
	 * 添加新地址
	 * @param request
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/addNewAddress")
	@ResponseBody
	public Object addNewAddress(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="openId",required=true)String open_id,
			@RequestParam(value="name",required=false,defaultValue="老虎")String name,
			@RequestParam(value="mobile",required=false,defaultValue="0")String mobile,
			@RequestParam(value="province",required=false,defaultValue="北京市朝阳区")String province,
			@RequestParam(value="detail",required=false,defaultValue="北京市朝阳区旮旯胡同")String detail
			){
		Map<String,Object> map=new HashMap<String,Object>();
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		User user=userService.getByOpenid(open_id);
		
		map.put("a_id", lc.getRamdomString());
		map.put("au_id", user.getAu_id());
		map.put("name", name);
		map.put("mobile", mobile);
		map.put("province", province);
		map.put("detail", detail);
		map.put("create_time", t.getSystemTimeFormart());
		
		userService.addNewAddressByUser(map);
		List<Address> list=userService.selectAddressByAuId(user.getAu_id());
		if(user.getAu_id()==null){
			return new ResponseSuccessOrFail("FAIL", "响应失败");
		}
		return new ResponseSuccessOrFail("SUCCESS", list);
	}
	
	/**
	 * 根据现有地址修改地址信息
	 * @param request
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/updateAddress")
	@ResponseBody
	public ResponseSuccessOrFail updataAddress(HttpServletRequest request,HttpServletResponse response,
							@RequestParam(value="aId",required=true)String a_id,
							@RequestParam(value="name",required=false,defaultValue="老虎")String name,
							@RequestParam(value="mobile",required=false,defaultValue="0")String mobile,
							@RequestParam(value="province",required=false,defaultValue="北京市朝阳区")String province,
							@RequestParam(value="detail",required=false,defaultValue="北京市朝阳区旮旯胡同")String detail
							){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("a_id", a_id);
		map.put("name", name);
		map.put("mobile", mobile);
		map.put("province", province);
		map.put("detail", detail);
		userService.updateAddressByAId(map);
		Address address=userService.getAddressInformationByAId(a_id);
		if(address==null){
			return new ResponseSuccessOrFail("FAIL", "响应失败");
		}
		return new ResponseSuccessOrFail("SUCCESS", address);
	}
	
	/**
	 * 设为默认地址
	 * @param request
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/setDefaultAddress")
	@ResponseBody
	public ResponseSuccessOrFail setDefaultAddress(HttpServletRequest request,HttpServletResponse response,
										@RequestParam(value="aId",required=true)String a_id
								){
		Address address=userService.getAddressInformationByAId(a_id);
		userService.updateUserDefaulAddress(address.getDetail(), address.getAu_id());
		if(address.getA_id()==null){
			return new ResponseSuccessOrFail("Fail", "响应失败");
		}
		return new ResponseSuccessOrFail("SUCCESS", address);
	}
	
	/**
	 * 删除地址
	 * @param request
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/deleteAddress")
	@ResponseBody
	public ResponseSuccessOrFail deleteAddress(HttpServletRequest request,HttpServletResponse response,
							@RequestParam(value="aId",required=true)String a_id
							){
		Address address=userService.getAddressInformationByAId(a_id);
		if(address.getA_id()==null){
			return new ResponseSuccessOrFail("FAIL","响应失败");
		}
		userService.deleteAddressByAId(a_id);
		return new ResponseSuccessOrFail("SUCCESS", "删除成功");
	}
	
	/**
	 * 修改地址
	 * @param request
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/insertAddress")
	@ResponseBody
	public List insertAddress(@RequestParam(value="openId",required=true)String open_id,
			@RequestParam(value="name",required=true)String name,
			@RequestParam(value="mobile",required=true)String mobile,
			@RequestParam(value="province",required=true)String province,
			@RequestParam(value="detail",required=true)String detail
								){
		User user=userService.getByOpenid(open_id);
		Map<String,Object> map=new HashMap<String,Object>();
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		map.put("a_id", lc.getFourRamdomString());
		map.put("au_id", user.getAu_id());
		map.put("name", name);
		map.put("mobile", mobile);
		map.put("province", province);
		map.put("detail", detail);
		map.put("create_time", t.getSystemTimeFormart());
		userService.insertAddress(map);
		Map<String,Object> another_map=new HashMap<String,Object>();
		another_map.put("au_id", user.getAu_id());
		another_map.put("address", detail);
		userService.updateUserAddressByAuId(another_map);
		List<Address> list=userService.selectAddressByAuId(user.getAu_id());
		
		return list;
	}
 	
	/**
	 * 查询用户地址信息
	 * @param request
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/selectAddress")
	@ResponseBody
	public Object selectAddress(
							@RequestParam(value="openId",required=true)String open_id
							){
		User user=userService.getByOpenid(open_id);
		List<Address> list=userService.selectAddressByAuId(user.getAu_id());
		if(list.size()<1){
			List<String> list3=new ArrayList<String>();
			list3.add("没有查到用户相关的地址信息");
			return list3;
		}else{
			return list;
		}
		
	}
 	
	
          /***************************************后台管理开始****************************************/
/**
 * 后台管理页面查询所有用户
 * @author lc
 * @param pageNumber
 * @param request
 * @return num     下一页
 * 		   middle  当前页数
 * 		   min     上一页
 * 		   totalPageCount 总页数
 * 		   list		所有用户
 */
	@RequestMapping("select_all_users")
	@ResponseBody
	public Map<String,Object> test(HttpServletRequest request,
			               HttpServletResponse response,
			               @RequestParam(value = "pageNumber", defaultValue = "1",required = false)int pageNumber
			               ){
		Map<String,Object> map=new HashMap<String,Object>();	   //查找map
		Map<String,Object> resultmap=new HashMap<String,Object>(); //出参map
		int pageSize=10;//每页显示多少条数据 
	   	int totalRecouds; //表中的总记录数 select count (*) from 表名   
	   	int totalPageCount; //总页数   
	   	int page= 10*(pageNumber-1);
	   	
	   	int counts=userService.countAllUsers();
		 if(counts/10!=0){//条数大于10
	   		 if(counts%10==0){//能除开
	   			 totalPageCount=counts/10;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/10+1);
	   		 }
		   	 }else{//条数小于10
		   		     totalPageCount=1;
		   	 }
		
		map.put("page", page);
		List<Map<String,Object>> list=userService.findUser(map);
		resultmap.put("list", list);
		resultmap.put("page",totalPageCount);
        int num=pageNumber;//下一页
	   	num=pageNumber+1;
	   	resultmap.put("num", num);		
	   	int middle=num-1;
	   	resultmap.put("middle", middle);//当前页数
	   	int min=pageNumber; //上一页
	   	if(min>1){
	   		 min=pageNumber-1;
	   	}
	   	resultmap.put("min", min);
		return resultmap;
	}
	
	/**
	 * 员工管理
	 * @param request
	 * @param response
	 * @return	
	 */
	@ResponseBody
	@RequestMapping("employee_Management")
	public Map<String,Object> employee_Management(){
		Map<String,Object> map=new HashMap<String,Object>();	   //查找map
		Map<String,Object> resultmap=new HashMap<String,Object>(); //出参map
		int page=1;
		map.put("page", page);
		List<Map<String,Object>> list=userService.findUser(map);
		
		resultmap.put("list", list);
		return resultmap;
	}
	
	/**
	 * 后台管理
	 * @param request
	 * @param response
	 * @return	
	 */
	@RequestMapping("returnIndex")
	public String returnIndex(){
		return "/html/index.html";
	}
	
	/**
	 * 返回User详情根据au_id
	 * @param request
	 * @param response
	 * @return	
	 */
	@RequestMapping("getUserInformationByAuId")
	public Object getUserInformationByAuId(HttpServletRequest request,HttpServletResponse response,
										  @RequestParam(value="au_id",required=true)String au_id
											){
		System.out.println(au_id+"_____________________________");
		
		 User user=userService.selectUserByauId(au_id);
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("au_id", user.getAu_id());
		 request.setAttribute("map", map);
		
		return "/html/userMangementDetail.jsp";
	}
	
	/**
	 * 账户管理，遍历账户列表
	 * @param request
	 * @param response
	 * @return	
	 */
	@RequestMapping("getUserListByPage")
	public Object getUserListByPage(HttpServletRequest request,
						            HttpServletResponse response,
						            @RequestParam(value = "pageNumber", defaultValue = "1",required = false)int pageNumber
									){
		Map<String,Object> map=new HashMap<String,Object>();	   //查找map
		int pageSize=10;//每页显示多少条数据 
	   	int totalRecouds; //表中的总记录数 select count (*) from 表名   
	   	int totalPageCount; //总页数   
	   	int page= 10*(pageNumber-1);
	   	
	   	int counts=userService.countAllUsers();
		 if(counts/10!=0){//条数大于10
	   		 if(counts%10==0){//能除开
	   			 totalPageCount=counts/10;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/10+1);
	   		 }
		   	 }else{//条数小于10
		   		     totalPageCount=1;
		   	 }
		
		map.put("page", page);
		List<Map<String,Object>> list=userService.findUser(map);
		
        int num=pageNumber;//下一页
	   	num=pageNumber+1;
	   	
	   	int middle=num-1;
	   	request.setAttribute("middle", middle);//当前页数
	   	int min=pageNumber; //上一页
	   	if(min>1){
	   		 min=pageNumber-1;
	   	}
	   	request.setAttribute("min", min);//上一页
	   	request.setAttribute("num", num);//下一页
	   	request.setAttribute("page", totalPageCount);//总页数
	   	request.setAttribute("list", list);
	   	request.setAttribute("text", "测试");
	   	
	   	Map<String,Object> mapaaa= list.get(1);
	   	System.out.println(mapaaa.get("au_id"));
	   	System.out.println("今天是我的生日我的祖国");
	   	
		return "/html/userManagement.jsp";
	
	} 
	
	/**
	 * 导航栏点击我的按钮   判定身份跳转
	 * @param request
	 * @param response
	 * @return	
	 */
	@RequestMapping("/targetPersonHome")
	public String targetPersonHome(HttpServletRequest request){
		String open_id=(String) request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		request.setAttribute("user", user);
		if(user.getType()==0){//普通用户
			return "/gongzhonghao/personHome.jsp";
		}else if(user.getType()==1){//销售
			return "/gongzhonghao/personHome_saleman.jsp";
		}else if(user.getType()==2){//技术
			return "/gongzhonghao/personHome_jishu.jsp";
		}else if(user.getType()==3){//管理
			return "/gongzhonghao/personHome_management.jsp";
		}else if(user.getType()==4){//总管理员
			return "";
		}
		
		return "/gongzhonghao/personHome.jsp";
	}
	
	/**
	 * 移除员工type,变成普通用户
	 * @param request
	 * @param response
	 * @return	
	 */
	@RequestMapping("/changUserType0")
	public String changUserType0(HttpServletRequest request){
		String open_id=(String)request.getSession().getAttribute("openid");
		User user=userService.getByOpenid(open_id);
		userService.updateUserType0(user.getAu_id());
		return "/gongzhonghao/set.html";
	}
	
	/**
	 * 跳转到changeUserInformationOrType.jsp
	 * @param request
	 * @param response
	 * @return	
	 */
	@RequestMapping("/targetchangUserInformation")
	public String changUserInformation(HttpServletRequest request,
									@RequestParam("au_id")String au_id
									){
		
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		return "/person/changeUserInformationOrType.jsp";
	}
	
	/**
	 * 角色登陆接口
	 * @return	
	 */
	@RequestMapping("/roleReLogin")
	@ResponseBody
	public Object roleReLogin(HttpServletRequest request,
							@RequestParam(value="mobile",required=true)String mobile,
							@RequestParam(value="password",required=true)String password
							){	
		String result=userService.checkUserInformation(mobile, password);//查询出user的au_id
		Map<String,Object> map=new HashMap<String,Object>();
		if(result==null||result=="0"||result==""){
			map.put("sign", 0);//登录失败返回0
			return map;
		}else{
			map.put("sign", 1);//登陆成功返回1
			User user=userService.selectUserByauId(result);
			String open_id=user.getOpen_id();
			request.getSession().removeAttribute("openid");
			request.getSession().removeAttribute("headimg");
			request.getSession().setAttribute("openid", open_id);
			request.getSession().setAttribute("headimg", user.getHeadimg());
			return map;
		}
	}
	
	/**
	 * 角色登陆接口
	 * @return	
	 */
	@RequestMapping("/managementSelectAllEmployee")
	public String managementSelectAllEmployee(HttpServletRequest request
											){
		List<Map<String,Object>> employee=userService.selectALLSalemanAndJiShu();
		request.setAttribute("employee", employee);
		return "/management/selectAllEmployee.jsp";
	}
	
	/**
	 * 查看员工订单
	 * @return	
	 */
	@RequestMapping("/selectEmployeeOrder")
	public String selectEmployeeOrder(HttpServletRequest request,
									@RequestParam("au_id")String au_id
									){
		User user=userService.selectUserByauId(au_id);
		request.setAttribute("user", user);
		if(user.getType()==1){
			//销售员  查询销售订单
			List<Map<String,Object>> commodity_order=commodityOrderService.selectEmployeeCommodityOrder(au_id);
			request.setAttribute("commodity_order", commodity_order);
			return "/management/findSalemanOrders.jsp";
		}else if(user.getType()==2){
			//技术   查询技术人员订单
			List<Map<String,Object>> install_order=installService.findEmployeeInstallOrder(au_id);
			List<Map<String,Object>> maintain_order=maintainService.findEmployeeMaintainOrder(au_id);
			List<Map<String,Object>> repair_order=repairService.findEmployeeRepairOrder(au_id);
			request.setAttribute("install_order", install_order);
			request.setAttribute("maintain_order", maintain_order);
			request.setAttribute("repair_order", repair_order);
			return "/management/findJiShuOrders.jsp";
		}
		
		return "";
	}
	
}
