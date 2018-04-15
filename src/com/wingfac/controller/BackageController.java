package com.wingfac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wingfac.entity.Commodity;
import com.wingfac.entity.User;
import com.wingfac.service.CommodityOrderService;
import com.wingfac.service.CommodityService;
import com.wingfac.service.InstallService;
import com.wingfac.service.MaintainService;
import com.wingfac.service.RepairService;
import com.wingfac.service.UserService;
import com.wingfac.util.UploadUtil;
import com.wingfac.util.lcRamdomUtil;

/**
 *  @描述：后台管理Controller
 ** @author LC   
 *  创建时间：2018-3-9 下午15:38
 */
@Controller
@Scope(value="prototype")
@RequestMapping("backageController")
public class BackageController {

	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="maintainService")
	private MaintainService maintainService;
	
	@Resource(name="repairService")
	private RepairService repairService;
	
	@Resource(name="commodityOrderService")
	private CommodityOrderService commodityOrderService;
	
	@Resource(name="commodityService")
	private CommodityService commodityService;
	
	@Resource(name="installService")
	private InstallService installService;
	
	
	/**
	 * @描述：查询个人商品订单
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/targetUserMangementDetail")
	public String targetUserMangementDetail(HttpServletRequest request,HttpServletResponse response,
										@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
										){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 5*(pageNumber-1);
		String au_id=request.getParameter("au_id");
		
		HttpSession session = request.getSession();
		session.setAttribute("buyerId", au_id);

		 Map<String,Object> map=new HashMap<String, Object>();
			map.put("au_id", au_id);
			map.put("page", page);
			counts = userService.selectCountCommodityOrderByUserId(map);//查询一共有多少条数据
			if(counts/5!=0){//条数大于五
		   		 if(counts%5==0){//能除开
		   			 totalPageCount=counts/5;
		   		 }else{//不能除开
		   			 totalPageCount=(counts/5+1);
		   		 }
			   	 }else{//条数小于5
			   		     totalPageCount=1;
			   	 }
		 List<Map<String,Object>> list=userService.selectUserCommodityOrderByUserId(map);
			if(list.size()<1){//购买空
			}else{
				 
				 request.setAttribute("list", list);
				 request.setAttribute("page", totalPageCount);
			}
			 int num=pageNumber;//下一页
			 if(num<totalPageCount){
				 num=pageNumber+1;
			 }
			   	request.setAttribute("num", num);
			   	int middle=num-1;
			   	request.setAttribute("middle", middle);
			   	int min=pageNumber; //上一页
			   	if(min>1){
			   		 min=pageNumber-1;
			   	}
			   	request.setAttribute("min", min);
		
		
		return "/html/userMangementDetail.jsp";
	}
	
	/**
	 * @描述：查询个人安装订单
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/targetUserMangementDetailInstall")
	public String targetUserMangementDetail_install(HttpServletRequest request,HttpServletResponse response,
												@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
												){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 5*(pageNumber-1);
	   	int middle=1;
		String au_id=request.getParameter("au_id");
		
		 Map<String,Object> map=new HashMap<String, Object>();
			map.put("au_id", au_id);
			map.put("page", page);
			counts+=counts=userService.selectCountInstallOrderByUserId(au_id);
			
			if(counts/5!=0){//条数大于五
		   		 if(counts%5==0){//能除开
		   			 totalPageCount=counts/5;
		   		 }else{//不能除开
		   			 totalPageCount=(counts/5+1);
		   		 }
			   	 }else{//条数小于5,视为只有一页
			   		     totalPageCount=1;
			   	 }
		List<Map<String,Object>> install_list=userService.selectUserInstallOrderByUserId(map);
		if(install_list.size()<1){//安装空记录
		}else{
			request.setAttribute("install_list", install_list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
		 int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
			 request.setAttribute("num", num);
		 }else{
			 request.setAttribute("num", num);
		 }
		 request.setAttribute("num", num);
		 if(totalPageCount==1){//如果总页数就只有一页
			 middle=1;
			 request.setAttribute("middle", middle);
		 }else{
			   	request.setAttribute("middle", pageNumber);
		 }
		 request.setAttribute("middle", pageNumber);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}else{
		   		request.setAttribute("min", min);
		   	}
		   	request.setAttribute("min", min);
		
		return "/html/userMangementDetail_Install.jsp";
	}
	
	/**
	 * @描述：查询个人保养订单
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/targetUserMangementDetailMaintian")
	public String targetUserMangementDetailMaintian(HttpServletRequest request,HttpServletResponse response,
												@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
												){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 5*(pageNumber-1);
	   	int middle=1;
		String au_id=request.getParameter("au_id");
		 Map<String,Object> map=new HashMap<String, Object>();
			map.put("au_id", au_id);
			map.put("page", page);
			counts+=counts=maintainService.selectCountMaintainOrderByUserId(au_id);
			if(counts/5!=0){//条数大于五
		   		 if(counts%5==0){//能除开
		   			 totalPageCount=counts/5;
		   		 }else{//不能除开
		   			 totalPageCount=(counts/5+1);
		   		 }
			   	 }else{//条数小于5,视为只有一页
			   		     totalPageCount=1;
			   	 }
		List<Map<String,Object>> maintain_list=maintainService.selectMaintainOrderByUserId(map);
		if(maintain_list.size()<1){//安装空记录
		}else{
			request.setAttribute("maintain_list", maintain_list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
		int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
			 request.setAttribute("num", num);
		 }else{
			 request.setAttribute("num", num);
		 }
		 request.setAttribute("num", num);
		 if(totalPageCount==1){//如果总页数就只有一页
			 middle=1;
			 request.setAttribute("middle", middle);
		 }else{
			   	request.setAttribute("middle", pageNumber);
		 }
		 request.setAttribute("middle", pageNumber);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}else{
		   		request.setAttribute("min", min);
		   	}
		   	request.setAttribute("min", min);
		
		return "/html/userMangementDetail_Maintain.jsp";
	}
	
	/**
	 * @描述：查询个人维修订单
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/targetUserMangementDetailRepair")
	public String targetUserMangementDetailRepair(HttpServletRequest request,HttpServletResponse response,
												@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
												){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 5*(pageNumber-1);
	   	int middle=1;
		String au_id=request.getParameter("au_id");
		 Map<String,Object> map=new HashMap<String, Object>();
			map.put("au_id", au_id);
			map.put("page", page);
		counts+=counts=repairService.selectCountRepairOrderByUserId(au_id);
		 if(counts/5!=0){//条数大于五
	   		 if(counts%5==0){//能除开
	   			 totalPageCount=counts/5;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/5+1);
	   		 }
		   	 }else{//条数小于5,视为只有一页
		   		     totalPageCount=1;
		   	 }
		List<Map<String,Object>> repair_list=repairService.selectRepairOrderByUserId(map);
		if(repair_list.size()<1){//安装空记录
		}else{
			request.setAttribute("repair_list", repair_list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
		int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
			 request.setAttribute("num", num);
		 }else{
			 request.setAttribute("num", num);
		 }
		 request.setAttribute("num", num);
		 if(totalPageCount==1){//如果总页数就只有一页
			 middle=1;
			 request.setAttribute("middle", middle);
		 }else{
			   	request.setAttribute("middle", pageNumber);
		 }
		 request.setAttribute("middle", pageNumber);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}else{
		   		request.setAttribute("min", min);
		   	}
		   	request.setAttribute("min", min);
		 
		return "/html/userMangementDetail_Repair.jsp";
	}
	
	/**
	 * @描述：查询所有待审核员工
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/getUserWaitingFor")
	public String getUserWaitingFor(HttpServletRequest request,HttpServletResponse response,
								@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
								){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 5*(pageNumber-1);
	   	int middle=1;
	   	counts+=counts=userService.CountUserOrderstateWait();
	   	if(counts/5!=0){//条数大于五
	   		 if(counts%5==0){//能除开
	   			 totalPageCount=counts/5;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/5+1);
	   		 }
		   	 }else{//条数小于5,视为只有一页
		   		     totalPageCount=1;
		   	 }
	   	List<User> list=userService.getUserOrderStateWait(page);
	   	if(list.size()<1){//安装空记录
		}else{
			request.setAttribute("list", list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
	   	int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
			 request.setAttribute("num", num);
		 }else{
			 request.setAttribute("num", num);
		 }
		 request.setAttribute("num", num);
		 if(totalPageCount==1){//如果总页数就只有一页
			 middle=1;
			 request.setAttribute("middle", middle);
		 }else{
			   	request.setAttribute("middle", pageNumber);
		 }
		 request.setAttribute("middle", pageNumber);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}else{
		   		request.setAttribute("min", min);
		   	}
		   	request.setAttribute("min", min);

		 return "/html/wishManagement.jsp";
	}
	
	
	
	/**
	 * @描述：跳转到用户管理界面
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/targetUserMangement")
	public String targetUserMangement(HttpServletRequest request,HttpServletResponse response,
									@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
									){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 10*(pageNumber-1);
	   	int middle=1;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		counts+=counts=userService.countAllUsers();
		if(counts/10!=0){//条数大于10
	   		 if(counts%10==0){//能除开
	   			 totalPageCount=counts/10;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/10+1);
	   		 }
		   	 }else{//条数小于10,视为只有一页
		   		     totalPageCount=1;
		   	 }
		List<Map<String,Object>> list=userService.findUser(map);
		if(list.size()<1){//空记录
		}else{
			request.setAttribute("list", list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
		 int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
		 }
		   	request.setAttribute("num", num);
		    middle=num-1;
		   	request.setAttribute("middle", middle);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}
		   	request.setAttribute("min", min);
		
		return "/html/userManagement.jsp";
	}
	
	/**
	 * @描述：用户审核通过接口
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/userPass")
	public String userPass(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="au_id",required=true)String au_id){
		
		System.out.println("进入用户神和接口"+au_id);
		userService.updateUserOrderStatePass(au_id);
		return "redirect:../backageController/getUserWaitingFor.do";
	}
	
	/**
	 * @描述：用户审核拒绝接口
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/userRefuse")
	public String userRefuse(HttpServletRequest request,HttpServletResponse response,
							@RequestParam(value="au_id",required=true)String au_id
							){
		userService.updateUserOrderStateRefuse(au_id);
		return "redirect:../backageController/getUserWaitingFor.do";
	}
	
	
	/**
	 * @描述：用户审核删除接口
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/userDelete")
	public String userDelete(HttpServletRequest request,HttpServletResponse response,
						@RequestParam(value="au_id",required=true)String au_id
						){
		userService.deleteUserByUserId(au_id);
		return "redirect:../backageController/getUserWaitingFor.do";
	}
	
	/**
	 * @描述：销售人员管理
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/salerManagement")
	public String salerManagement(HttpServletRequest request,HttpServletResponse response,
						@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
						){
		
	 /*********************************以下是销售员************************************************/
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 10*(pageNumber-1);
	   	int middle=1;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		counts+=counts=userService.selectCountAllSaler();
		if(counts/10!=0){//条数大于10
	   		 if(counts%10==0){//能除开
	   			 totalPageCount=counts/10;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/10+1);
	   		 }
		   	 }else{//条数小于10,视为只有一页
		   		     totalPageCount=1;
		   	 }
		List<User> list=userService.selectAllSaler(map);
		if(list.size()<1){//空记录
		}else{
			request.setAttribute("list", list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
		 int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
		 }
		   	request.setAttribute("num", num);
		    middle=num-1;
		   	request.setAttribute("middle", middle);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}
		   	request.setAttribute("min", min);
		System.out.println("跳转到遍历销售人员界面");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getNickname());
		}
		
		return "/html/managerment/SalerManagement.jsp";
	}
	
	/**
	 * @描述：销售员审核关闭权限
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/closeSalerManagement")
	public String closeSalerManagement(HttpServletRequest request,HttpServletResponse response,
									@RequestParam(value="au_id",required=true)String au_id
									){
		userService.closeSalerOrderstateAndType(au_id);
		return "redirect:../backageController/salerManagement.do";
	}
	
	/**
	 * @描述：维修人员管理
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/repairManagement")
	public String repairManagement(HttpServletRequest request,HttpServletResponse response,
								@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
								){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 10*(pageNumber-1);
	   	int middle=1;
	   	Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		counts+=counts=userService.CountAllRepairWorker();
		if(counts/10!=0){//条数大于10
	   		 if(counts%10==0){//能除开
	   			 totalPageCount=counts/10;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/10+1);
	   		 }
		   	 }else{//条数小于10,视为只有一页
		   		     totalPageCount=1;
		   	 }
		List<Map<String,Object>> list=userService.selectAllRepairWorker(map);
		if(list.size()<1){//空记录
		}else{
			request.setAttribute("list", list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
		int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
		 }
		   	request.setAttribute("num", num);
		    middle=num-1;
		   	request.setAttribute("middle", middle);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}
		   	request.setAttribute("min", min);
		
		return "/html/managerment/RepairManagement.jsp";
	}
	
	/**
	 * @描述：关闭维修人员权限
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/closeRepair")
	public String closeRepair(HttpServletRequest request,HttpServletResponse response,
							@RequestParam(value="au_id",required=true)String au_id
							){
		 userService.closeSalerOrderstateAndType(au_id);
		return "redirect:../backageController/repairManagement.do";
	}
	
	
	/**
	 * @描述：跳转到订单管理界面
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/caiManagement")
	public String orderManagement(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
								){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 10*(pageNumber-1);
	   	int middle=1;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		counts+=counts=commodityOrderService.countCommodityOrder();
		if(counts/10!=0){//条数大于10
	   		 if(counts%10==0){//能除开
	   			 totalPageCount=counts/10;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/10+1);
	   		 }
		   	 }else{//条数小于10,视为只有一页
		   		     totalPageCount=1;
		   	 }
		List<Map<String,Object>> list=commodityOrderService.selectCommodityOrder(map);
		if(list.size()<1){//空记录
		}else{
			request.setAttribute("list", list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
		int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
		 }
		   	request.setAttribute("num", num);
		    middle=num-1;
		   	request.setAttribute("middle", middle);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}
		   	request.setAttribute("min", min);
		
		return "/html/caiManagement.jsp";
	}
	
	/**
	 * @描述：跳转到未完成订单界面
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/commodity_orderN")
	public String commodity_orderN(
								HttpServletRequest request,HttpServletResponse response,
								@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
								){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 10*(pageNumber-1);
	   	int middle=1;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		counts+=counts=commodityOrderService.selectCountCommodityOrderN();
		if(counts/10!=0){//条数大于10
	   		 if(counts%10==0){//能除开
	   			 totalPageCount=counts/10;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/10+1);
	   		 }
		   	 }else{//条数小于10,视为只有一页
		   		     totalPageCount=1;
		   	 }
		List<Map<String,Object>> list=commodityOrderService.selectCommodityOrderN(map);
		if(list.size()<1){//空记录
		}else{
			request.setAttribute("list", list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
		int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
		 }
		   	request.setAttribute("num", num);
		    middle=num-1;
		   	request.setAttribute("middle", middle);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}
		   	request.setAttribute("min", min);
		
		return "/html/commodityorder/commodity_orderN.jsp";
	}
	
	/**
	 * @描述：跳转到已完成订单界面
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/commodity_orderY")
	public String commodity_orderY(HttpServletRequest request,HttpServletResponse response,
								@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
								){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 10*(pageNumber-1);
	   	int middle=1;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		counts+=counts=commodityOrderService.selectCountCommodityOrderY();
		if(counts/10!=0){//条数大于10
	   		 if(counts%10==0){//能除开
	   			 totalPageCount=counts/10;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/10+1);
	   		 }
		   	 }else{//条数小于10,视为只有一页
		   		     totalPageCount=1;
		   	 }
		List<Map<String,Object>> list=commodityOrderService.selectCommodityOrderY(map);
		if(list.size()<1){//空记录
		}else{
			request.setAttribute("list", list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
		int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
		 }
		   	request.setAttribute("num", num);
		    middle=num-1;
		   	request.setAttribute("middle", middle);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}
		   	request.setAttribute("min", min);
		
		
		return "/html/commodityorder/commodity_orderY.jsp";
	}
	

	/**
	 * @描述：跳转到商品管理界面
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/commodityMannagement")
	public String commodityMannagement(HttpServletRequest request,HttpServletResponse response,
									@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
									){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 10*(pageNumber-1);
	   	int middle=1;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		counts+=counts=commodityService.CountAllCommodity();
		if(counts/10!=0){//条数大于10
	   		 if(counts%10==0){//能除开
	   			 totalPageCount=counts/10;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/10+1);
	   		 }
		   	 }else{//条数小于10,视为只有一页
		   		     totalPageCount=1;
		   	 }
		List<Map<String,Object>> list=commodityService.getAllCommodity(map);
		if(list.size()<1){//空记录
		}else{
			request.setAttribute("list", list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
		int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
		 }
		   	request.setAttribute("num", num);
		    middle=num-1;
		   	request.setAttribute("middle", middle);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}
		   	request.setAttribute("min", min);		
				
		return "/html/commodityManagement.jsp";
	}
	
	
	/**
	 * @描述：商品管理->商品详情
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/good_contentUntitled1")
	public String good_contentUntitled1(HttpServletRequest request,HttpServletResponse response,
									@RequestParam(value="c_id",required=true)String c_id
									){
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		request.setAttribute("commodity", commodity);
		List<Map<String,Object>> list=commodityService.selectEvaluateBycId(c_id);
		if(list.size()<1){
			request.setAttribute("sign","该用户尚未做出任何评价" );
		}else{
			request.setAttribute("list", list);
		}
		return "/html/good_contentUntitled-1.jsp";
	}
	
	/**
	 * @描述：商品管理->商品详情
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/newGoods")
	public String newGoods(HttpServletRequest request,HttpServletResponse response,
						@RequestParam(value="c_id",required=true)String c_id
						){
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		request.setAttribute("commodity", commodity);
		
		return "html/newGoods.jsp";
	}
	
	/**
	 * @描述：修改商品首页标签
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/updateTag")
	@ResponseBody
	public Map<String,Object> updateTag(HttpServletRequest request,HttpServletResponse response,
						@RequestParam(value="c_id",required=true)String c_id,
						@RequestParam(value="mark",required=true)int mark
						){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("commodity_mark", mark);
		map.put("c_id", c_id);
		commodityService.updateCommodityMarkBycId(map);
		return map;
	}
	
	/**
	 * @描述：根据关键字模糊查询个人账户信息
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectPersonalByKeyWords")
	public String selectPersonalByKeyWords(HttpServletRequest request,HttpServletResponse response,
										@RequestParam(value="keywords",required=false)String keywords
										){
		Map<String,Object> map=new HashMap<String,Object>();
		String str="%"+keywords+"%";
		System.out.println(str);
		
		List<Map<String,Object>> list=userService.selectKeywordsInNickname(str);
		if(list.size()<1){
			System.out.println("没有查询到结果");
		}else{
			request.setAttribute("list", list);
		}
		return "html/userManagement2.jsp";
	}
	
	
	/**
	 * @描述：根据关键字模糊查询订单信息
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectCommodityOrderByKeyWords")
	public String selectCommodityOrderByKeyWords(HttpServletResponse response,HttpServletRequest request,
											@RequestParam(value="keywords",required=false)String keywords
											){
		String str="%"+keywords+"%";
		List<Map<String,Object>> user_list=commodityOrderService.selectCommodityVagueUserNickname(str);
		List<Map<String,Object>> brand_list=commodityOrderService.selectCommodityVagueCommodityBrand(str);
		user_list.addAll(brand_list);
		if(user_list.size()<1){
			System.out.println("没有查询到结果");
		}else{
			System.out.println("查询到了结果");
			request.setAttribute("list", user_list);
		}
		return "html/userMangementDetail2.jsp";
	}
	
	/**
	 * @描述：根据关键字模糊查询订单信息
	 * @param  
	 * @return
	 */
	/*@RequestMapping(value = "/selectInstallOrderVague")
	@ResponseBody
	public String selectInstallOrderVague(HttpServletRequest request,HttpServletResponse response,
										@RequestParam(value="keyword",required=false)String keyword
										){
		String str="%"+keyword+"%";
		List<Map<String,Object>> list=installService.selectInstallBrandVague(str);
		if(list.size()<1){}else{
			
			request.setAttribute("list", list);
		}
		return "";
	}*/
	
	/**
	 * @描述：查询并跳转管理层人员
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectAndTargetManagement")
	public String selectAndTargetManagement(HttpServletRequest request,HttpServletResponse response,
										@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber
										){
		int pageSize=10;//每页显示多少条数据 
	    int counts=0;  //根据auId查询合同条数,初始值为0;
	   	int totalPageCount; //总页数   
	   	int page= 10*(pageNumber-1);
	   	int middle=1;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("page", page);
		counts+=counts=userService.getCountUserType3();
		if(counts/10!=0){//条数大于10
	   		 if(counts%10==0){//能除开
	   			 totalPageCount=counts/10;
	   		 }else{//不能除开
	   			 totalPageCount=(counts/10+1);
	   		 }
		   	 }else{//条数小于10,视为只有一页
		   		     totalPageCount=1;
		   	 }
		List<User> list=userService.getUserType3(map);
		if(list.size()<1){//空记录
		}else{
			request.setAttribute("list", list);
			request.setAttribute("page", totalPageCount);//一共多少页
		}
		int num=pageNumber;//下一页
		 if(num<totalPageCount){
			 num=pageNumber+1;
		 }
		   	request.setAttribute("num", num);
		    middle=num-1;
		   	request.setAttribute("middle", middle);
		   	int min=pageNumber; //上一页
		   	if(min>1){
		   		 min=pageNumber-1;
		   	}
		   	request.setAttribute("min", min);	
		
		return "html/managerment/Management.jsp";
	}

	/**
	 * @描述：员工管理模糊查询结果
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/getWishManagementResulet")
	public String selectAndTargetManagement(HttpServletRequest request,HttpServletResponse response,
										@RequestParam(value="pageNumber",required=false,defaultValue="1")int pageNumber,
										@RequestParam(value="keyword",required=false)String keyword
										){
		String str="%"+keyword+"%";
		List<Map<String,Object>> list=userService.selectKeywordsInNickname(str);
		List<Map<String,Object>> list2=userService.selectUserMobileVague(str);
		list.addAll(list2);
		if(list.size()<1){}else{
			request.setAttribute("list", list);
		}
		return "/html/managerment/VagueResult.jsp";
	}
	
	/**
	 * @描述：员工管理模糊查询结果
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/getOrderVagueResult")
	public String getOrderVagueResult(HttpServletRequest request,HttpServletResponse response,
									@RequestParam(value="keyword",required=false)String keyword
									){
		String str="%"+keyword+"%";
		List<Map<String,Object>> list=commodityOrderService.selectComIdVague(str);
		List<Map<String,Object>> list2=commodityOrderService.selectCnameVague(str);
		list.addAll(list2);
		if(list.size()<1){
		}else{
			request.setAttribute("list", list);
		}
		return "html/commodityorder/VagueResult.jsp";
	}
	
	/**
	 * @描述：商品管理模糊查询结果
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/getCommodityVagueResult")
	public String getCommodityVagueResult(HttpServletRequest request,HttpServletResponse response,
										@RequestParam(value="keyword",required=false)String keyword
										){
		String str="%"+keyword+"%";									
		List<Map<String,Object>> list=commodityService.selectCommodityBrandVague(str);
		List<Map<String,Object>> list2=commodityService.selectCommodityCnameVague(str);
		list.addAll(list2);
		if(list.size()<1){}else{
			request.setAttribute("list", list);
		}
		return "html/commodityorder/VagueResult.jsp";
	}
	
	/**
	 * @描述: 新建商品提交接口
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/targetAddNewCommoditys")
	public String targetAddNewCommoditys(HttpServletRequest request,HttpServletResponse response,
										@RequestParam(value="c_name",required=false)String c_name,
										@RequestParam(value="condition_type",required=false,defaultValue="0")String use_type,
										@RequestParam(value="cover_picture",required=false,defaultValue="0")MultipartFile[] file,
										@RequestParam(value="detaile_picture",required=false,defaultValue="0")MultipartFile[] file2,
										@RequestParam(value="price",required=true)double price,
										@RequestParam(value="brand",required=false,defaultValue="无")String brand,
										@RequestParam(value="create_time",required=false)String creat_time,
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
		UploadUtil u=new UploadUtil();
		lcRamdomUtil lc=new lcRamdomUtil();
		String c_id=lc.getFourRamdomString();
		String path="commodityCoverPic/"+c_id;
		
		String cover_picture=u.uploadFilesToPath(request, file[0], path);//上传商品封面图片
		if(cover_picture==""||cover_picture==" "){
			System.out.println("上传图片是空的");
			cover_picture="0";
		}else{
			System.out.println("居然有图片");
		}
		
		/************************上传详情图片*************************************/
		String detail_path="commodityDetailPic/"+c_id;
		String pics="";
		for (int i = 0; i < file2.length; i++) {
    		String s=u.uploadFilesToPath(request, file2[i], detail_path);	
    		if(s==null||s.equals("")||s.equals(" ")){
    			
    		}else{
    			pics+=(","+s);
    		}
    	}
		
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("c_id", c_id);
			map.put("c_name", c_name);
			map.put("use_type",use_type);
			map.put("cover_picture", cover_picture);
			map.put("detaile_picture",pics);
			map.put("price", price);
			map.put("brand", brand);
			map.put("create_time", creat_time);
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
			
		commodityService.insertCommodity(map);
		
		return "/html/index.jsp";
	}
	
	
	
}
