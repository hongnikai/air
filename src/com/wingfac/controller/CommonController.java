package com.wingfac.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom2.Content;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wingfac.entity.Commodity;
import com.wingfac.entity.CommodityAnswer;
import com.wingfac.entity.CommodityAsk;
import com.wingfac.entity.CommodityEvaluate;
import com.wingfac.entity.InstallOrder;
import com.wingfac.entity.MaintainOrder;
import com.wingfac.entity.RepairOrder;
import com.wingfac.entity.Store;
import com.wingfac.entity.User;
import com.wingfac.service.CommodityEvaluateService;
import com.wingfac.service.CommodityOrderService;
import com.wingfac.service.CommodityService;
import com.wingfac.service.CommonService;
import com.wingfac.service.DataService;
import com.wingfac.service.InstallService;
import com.wingfac.service.MaintainService;
import com.wingfac.service.RepairService;
import com.wingfac.service.UserService;
import com.wingfac.util.Constants;
import com.wingfac.util.LocalResponseBody;
import com.wingfac.util.RandomUtil;
import com.wingfac.util.ResponseSuccessOrFail;
import com.wingfac.util.SendVerificodeUtil;
import com.wingfac.util.TimeUtil;
import com.wingfac.util.UploadUtil;
import com.wingfac.util.lcRamdomUtil;

/**
 *  @描述：通用类接口
 *  @author LC   
 *  创建时间：2018-2-11 上午15:49
 */
@Controller
@Scope(value="prototype")
@RequestMapping("CommonController")
public class CommonController {
	
	@Resource(name="commodityService")
	private CommodityService commodityService;
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	@Resource(name="commodityEvaluateService")
	private CommodityEvaluateService commodityEvaluateService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="installService")
	private InstallService installService;
	
	@Resource(name="maintainService")
	private MaintainService maintainService;
	
	@Resource(name="repairService")
	private RepairService repairService;
	
	@Resource(name="commodityOrderService")
	private CommodityOrderService commodityOrderService;
	
	@Resource(name="dataService")
	private DataService dataService;
	
	Log log = LogFactory.getLog(CommonController.class);
	 
	
	/**
     * 发送用户验证码并缓存在服务器
     * @param mobile
     * @param request
     * @return
     */
	@RequestMapping("/sendVerifyCode")
	@ResponseBody
	public Map<String,Object> ads(HttpServletRequest request,
					  @RequestParam(value="mobile",required = true)String mobile){
		Map<String,Object> result = new HashMap<String, Object>();
		log.info("发送用户验证码:");
		if(mobile != null && !"".equals(mobile)){
            String code = RandomUtil.getFourRandom();

            request.getServletContext().setAttribute(mobile, code);
            SendVerificodeUtil.sendVerificode(mobile, code);
            log.info("验证码发送成功:手机号 " + mobile + " 验证码: " + code);
            result.put("msg", "发送成功");
            result.put("responseState", 0);
        } else {
            log.info("验证码发送失败, 参数异常");
            result.put("msg", "发送失败, 参数异常");
            result.put("responseState", 1);
        }
		return result;
	}
	
	/**
	 * @描述:根据关键字查询商品
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/selectGoodsByKeyWords")
	public String selectCommodityByKeyWords(HttpServletRequest request,HttpServletResponse response,
											@RequestParam(value="keyword",required=false,defaultValue="格力")String keyword
			){
		if(keyword==null||keyword==""||keyword==" "){
		}else{
			String new_keywords="%"+keyword+"%";
			List<Commodity> commdity_list=commonService.selectCommodityByKeyWords(new_keywords);
			List<Store> store_list=commonService.selectStoreByname(new_keywords);
			request.setAttribute("commdity_list", commdity_list);
			request.setAttribute("store_list", store_list);
		}
		
		return "/gongzhonghao/commodityResult.jsp";
	}
	
	/**
	 * @描述:提交评价接口
	 * @param  cId  商品唯一标识
	 * @param  openId 用户标识
	 * @param  content 评价内容
	 * @param  picture 评价图片
	 * @param  score   分数 
	 * @return
	 */
	@RequestMapping(value = "/submitCommodityOrderBycomId")
	@ResponseBody
	public LocalResponseBody<Object> submitCommodityOrderBycomId(HttpServletRequest request,HttpServletResponse response,
											@RequestParam(value = "cId",required=true)String c_id,
											@RequestParam(value = "openId",required=true)String open_id,
											@RequestParam(value = "content",required = false,defaultValue = "无")String content,
											@RequestParam(value = "picture",required = false,defaultValue = "无")String picture,
											@RequestParam(value = "commodityScore",required = false,defaultValue = "0")int commodity_score,
											@RequestParam(value = "salesManScore",required = false,defaultValue = "0")int sales_man_score,
											@RequestParam(value = "installerScore",required = false,defaultValue = "0")int installer_score
											){
		Map<String,Object> map = new HashMap<String,Object>();//入参map
		
		lcRamdomUtil util = new lcRamdomUtil();
		String eva_id = util.getRamdomString();
		
		User user = userService.getByOpenid(open_id);
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String pay_time = simple.format(System.currentTimeMillis());
		String eva_time = simple.format(System.currentTimeMillis());
		
		map.put("eva_id", eva_id);
		map.put("c_id", c_id);
		map.put("au_id", user.getAu_id());
		map.put("nickname", user.getNickname());
		map.put("head_img", user.getHeadimg());
		map.put("eva_time", eva_time);
		map.put("content", content);
		map.put("picture", picture);
		map.put("reply", "*");
		map.put("type", 0);
		map.put("commodityScore", commodity_score);
		map.put("salesManScore", sales_man_score);
		map.put("installerScore", installer_score);
		
		commodityEvaluateService.insertCommodityEvaluateBycId(map);
		
		List<CommodityEvaluate> list = commodityEvaluateService.getCommodityEvaluateBycId(c_id);
		if(list.size()<1){
			return new LocalResponseBody<Object>("Fail");
		}
		return new LocalResponseBody<Object>("1","SUCCESS",list);
	}
	
	/**
	 * @描述:  问大家发起提问
	 * @param  cId  商品唯一标识
	 * @param  openId 用户标识
	 * @param  content 提问内容
	 * @return
	 */
	@RequestMapping(value = "/createQuestionBycId")
	@ResponseBody
	public Object createQuestionBycId(HttpServletRequest request,HttpServletResponse response,
									@RequestParam(value = "cId",required = true)String c_id,
									@RequestParam(value = "openId",required = true)String open_id,
									@RequestParam(value = "content",required = false,defaultValue="无")String content
									){
		lcRamdomUtil lc = new lcRamdomUtil();
		String ask_id = lc.getRamdomString();
		
		User user = userService.getByOpenid(open_id);
		
		if(user.getAu_id() == null){
			return new ResponseSuccessOrFail("响应失败", "openId错误");
		}
		
		Commodity commodity=commodityService.getCommodityByc_id(c_id);
		if(commodity.getC_id()==null){
			return new ResponseSuccessOrFail("FAIL", "cId不存在");
		}
		TimeUtil time = new TimeUtil();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ask_id", ask_id);
		map.put("c_id", c_id);
		map.put("au_id", user.getAu_id());
		map.put("ask_content", content);
		map.put("create_time",time.getSystemTimeFormart());
		map.put("other", "无");
		
		commodityService.insertCommodityAsk(map);
		
		Map<String,Object> commodity_ask=commonService.getCommodityAskByAskId(ask_id);
		
		return new ResponseSuccessOrFail("SUCCESS", commodity_ask);
	}
	
	/**
	 * @描述:  根据商品遍历所有提问
	 * @param  cId  商品唯一标识
	 * @return
	 */
	@RequestMapping(value = "/selectCommodityAskContentBycId")
	@ResponseBody
	public Object selectCommodityAskContentBycId(HttpServletRequest request,HttpServletResponse response,
												@RequestParam(value="cId",required = true)String c_id
												){
		List<CommodityAsk> list= commodityService.selectAskBycId(c_id);
		if(list.size()<1){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("sign", "该商品还没有人发起提问");
			return map; 
		}
		return new ResponseSuccessOrFail("SUCCESS", list);
	}
	
	/**
	 * @描述:  根据提问ask_id添加回答,
	 * @param  ask_id 问题唯一标识
	 * @return list 回答全部信息
	 */
	@RequestMapping(value = "/addCommodityAnswerByAskId")
	@ResponseBody
	public ResponseSuccessOrFail addCommodityAnswerByAskId(HttpServletRequest request,HttpServletResponse response,
											@RequestParam(value = "askId",required = true)String ask_id,
											@RequestParam(value = "openId",required = true)String open_id,
											@RequestParam(value = "content",required = false,defaultValue = "无")String answer_content){
		Map<String,Object> map = new HashMap<String,Object>();
		
		TimeUtil time = new TimeUtil();
		lcRamdomUtil lc = new lcRamdomUtil();
		User user = userService.getByOpenid(open_id);
		
		map.put("answer_id", lc.getRamdomString());
		map.put("ask_id", ask_id);
		map.put("au_id", user.getAu_id());
		map.put("answer_content", answer_content);
		map.put("create_time", time.getSystemTimeFormart());
		map.put("useful",0);
	
		commodityService.addCommodityAnswer(map);
		
		List<Map<String,Object>> list= commodityService.selectCommodityAnswerByaskId(ask_id);
		if(list.size()<1){
			return new ResponseSuccessOrFail("Fail","没有回答");
		}
		return new ResponseSuccessOrFail("SUCCESS", list);
	}
	
	/**
	 * @描述:  根据提问ask_id获取全部回答
	 * @param  ask_id 问题唯一标识
	 * @return list 回答全部信息
	 */
	@RequestMapping(value = "/getAllAnswerByaskId")
	@ResponseBody
	public ResponseSuccessOrFail getAllAnswerByaskId(HttpServletRequest request,HttpServletResponse response,
									 @RequestParam(value = "askId")String ask_id
									){
		List<Map<String,Object>> list = commodityService.selectCommodityAnswerByaskId(ask_id);
		if(list.size() < 1){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("sign", "该问题还没还有答案");
			return new ResponseSuccessOrFail("FAIL", map);
		}
		return new ResponseSuccessOrFail("SUCCESS", list);
	}
	

	/**
	 * @描述:  根据回答点赞
	 * @param  ask_id 答案的唯一标识
	 * @return 
	 */
	@RequestMapping(value = "/addUserfulMarkByAnswerId")
	@ResponseBody
	public ResponseSuccessOrFail addUserfulMarkByAnswerId(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "openId")String open_id,@RequestParam(value = "answerId")String answer_id){
		lcRamdomUtil lc=new lcRamdomUtil();

		User user = userService.getByOpenid(open_id);
		//查询是否点过赞了
		String support_id = commonService.makeSureFirstSupportOrNot(user.getAu_id(), answer_id);
		
		if(support_id==null){//如果用户没点过赞
			//为该用户创建第一次点赞记录
			Map<String,Object> create_map = new HashMap<String,Object>();
			create_map.put("support_id", lc.getRamdomString());
			create_map.put("au_id", user.getAu_id());
			create_map.put("answer_id", answer_id);	
		commonService.createFirstSupport(create_map);
		
		Integer useful = commonService.selectUsefulCountByanswerId(answer_id);
		useful = useful +1;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("useful", useful);
		map.put("answer_id", answer_id);
		commonService.updateUsefulMarkByAnswerId(map);
		}else{//如果点过赞了 
			return new ResponseSuccessOrFail("FAIL该账号已经点过赞了", commonService.selectUsefulCountByanswerId(answer_id));
		}
		return new ResponseSuccessOrFail("SUCCESS成功为该账号点赞", commonService.selectUsefulCountByanswerId(answer_id));
	}
	

	/**
	 * @描述:  技术人员查看所有待接单
	 * @param  
	 * @return 
	 */
	@RequestMapping(value = "/selectAllOrder")
	@ResponseBody
	public Map selectAllOrder(){
		Map<String,Object> map=new HashMap<String,Object>();
		List<InstallOrder> install_order_list=installService.selectAllInstallOrderNotBuy();
		if(install_order_list.size()<1){
			map.put("InstallFAIL", "没有待接的安装订单");
		}else{
			map.put("install_order_list",install_order_list);
		}
		List<MaintainOrder> maintain_order_list=maintainService.selectMaintainOrderNotBuy();
		if(maintain_order_list.size()<1){
			map.put("MaintainFAIL","没有待接的保养订单");
		}else{
			map.put("maintain_order_list", maintain_order_list);
		}
		List<RepairOrder> repair_order_list=repairService.selectAllRepairOrderNotBuy();
		if(repair_order_list.size()<1){
			map.put("RepairFAIL", "没有待接的维修订单");
		}else{
			map.put("repair_order_list", repair_order_list);
		}
		return map;
	}
	
	/**
	 * @描述:  技术人员查看所有待接单
	 * @param  
	 * @return 
	 */
	@RequestMapping("/targetAddCommodityOrderEvalute")
	public String targetAddCommodityOrderEvalute(HttpServletRequest request,
												@RequestParam("com_id")String com_id){
		Map<String,Object> commodity_order=commodityOrderService.getCommodityOrderByComId(com_id);
		request.setAttribute("commodity_order", commodity_order);
		return "/person/addEvalute.jsp";
	}
	
	/**
	 * @描述:  添加商品订单评价接口
	 * @param  
	 * @return 
	 */
	@RequestMapping("/addCommodityOrderEvalute")
	public String addCommodityOrderEvalute(HttpServletRequest request,
										@RequestParam("com_id")String com_id,
										@RequestParam("content")String content,
										@RequestParam(value="picture",required=false)MultipartFile[] file,
										@RequestParam(value="commodity_score",required=false,defaultValue="0")int commodity_score,
										@RequestParam(value="sales_man_score",required=false,defaultValue="0")int sales_man_score,
										@RequestParam(value="installer_score",required=false,defaultValue="0")int installer_score
										){
		UploadUtil u=new UploadUtil();
		TimeUtil t=new TimeUtil();
		lcRamdomUtil lc=new lcRamdomUtil();
		String eva_id=lc.getSixPlusTimeStampRamdomString();   //评价表id
		String path="EvalutePic/"+eva_id;
		String picture="";
		System.out.println("以上步骤无错误*******下面开始进入for循环");
		for (int i = 0; i < file.length; i++) {
    		String s=u.uploadFilesToPath(request, file[i], path);	
    		if(s==null||s.equals("")||s.equals(" ")){
    			System.out.println("上传图片是空的");
    		}else{
    			System.out.println("居然有图片");
    			 picture+=s+",";   //1.jpg,2.jpg,   
    		}
    	}
		System.out.println("循环结束");
        Map<String,Object> commodity_order = commodityOrderService.getCommodityOrderByComId(com_id);
		String au_id=(String) commodity_order.get("au_id");
		User user=userService.selectUserByauId(au_id);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("eva_id", eva_id);
		map.put("c_id", commodity_order.get("c_id"));
		map.put("com_id", com_id);
		map.put("au_id", au_id);
		map.put("nickname", user.getNickname());
		map.put("head_img", user.getHeadimg());
		map.put("eva_time", t.getSystemTimeFormart());
		map.put("content", content);
		map.put("picture", picture);
		map.put("reply", "0");  				//初始创建  客服回复"0"
		map.put("type", 0);
		map.put("commodity_score", commodity_score);
		map.put("sales_man_score", sales_man_score);
		map.put("installer_score", installer_score);
		commodityEvaluateService.insertCommodityEvaluate(map);
		
		//修改订单状态为：7 已评价
		Map<String,Object> chang_OrderState=new HashMap<String,Object>();
		chang_OrderState.put("com_id", com_id);
		chang_OrderState.put("order_state", 7);    //7 已评价
		commodityOrderService.updateCommodityOrderOrderState(chang_OrderState);
		
		return "/gongzhonghao/homePage.html";
	}
	
	/**
	 * @描述:  发起提问接口
	 * @param  
	 * @return 
	 */
	@RequestMapping("/addQuestionBycId")
	public String addQuestionBycId(HttpServletRequest request,
								@RequestParam("c_id")String c_id,
								@RequestParam("question")String question
								){
		String open_id = (String) request.getSession().getAttribute("openid");
		lcRamdomUtil lc=new lcRamdomUtil();
		TimeUtil t=new TimeUtil();
		
		User user=userService.getByOpenid(open_id);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("ask_id", lc.getSixPlusTimeStampRamdomString());
		map.put("c_id", c_id);
		map.put("au_id", user.getAu_id());
		map.put("question", question);
		map.put("create_time", t.getSystemTimeFormart());
		commonService.insertAskAll(map);
		
		List<Map<String,Object>> ask=dataService.selectAskInnerJoinUserBycId(c_id);
		request.setAttribute("ask", ask);//查询了所有问题 
		request.setAttribute("c_id", c_id);
		
		return "/gongzhonghao/askList.jsp";
	}
	
	
	/**
	 * @描述:  商品详情页    发起提问接口 - 跳转 -发起提问
	 * @param  
	 * @return 
	 */
	@RequestMapping("/gotoCreateQuestion")
	public String gotoCreateQuestion(HttpServletRequest request,
									@RequestParam("c_id")String c_id,
									@RequestParam(value="content",required=false,defaultValue="0")String content
								   ){
		List<Map<String,Object>> ask=commonService.selectAskAllBycId(c_id);
		request.setAttribute("ask", ask);
		if(content.equals("0")){}else{
			Map<String,Object> map=new HashMap<String,Object>();
			lcRamdomUtil lc=new lcRamdomUtil();
			TimeUtil t=new TimeUtil();
			String open_id=(String) request.getSession().getAttribute("openid");
			User user=userService.getByOpenid(open_id);
			String ask_id=lc.getSixPlusTimeStampRamdomString();
			map.put("ask_id", ask_id);
			map.put("c_id", c_id);
			map.put("au_id", user.getAu_id());
			map.put("question", content);  //问题内容
			map.put("create_time", t.getSystemTimeFormart());
			commonService.insertAskAll(map);
			Map<String,Object> new_ask=commonService.selectAskAllByAskId(ask_id);
		}
		
		return "/gongzhonghao/ask.jsp";
	}
	
	/**
	 * @描述:  根据回答点赞
	 * @param  ask_id 答案的唯一标识
	 * @return 
	 */
	@RequestMapping(value = "/addSupportRecord")
	@ResponseBody
	public ResponseSuccessOrFail addUserfulMarkByAnswerId(HttpServletRequest request,HttpServletResponse response,
															@RequestParam(value = "answerId")String answer_id
															){
		lcRamdomUtil lc=new lcRamdomUtil();
//		String open_id=(String) request.getSession().getAttribute("openid");
		User user = userService.getByOpenid("623238232");
		//查询是否点过赞了
		String support_id = commonService.makeSureFirstSupportOrNot(user.getAu_id(), answer_id);
		
		if(support_id==null){//如果用户没点过赞
			//为该用户创建第一次点赞记录
			Map<String,Object> create_map = new HashMap<String,Object>();
			create_map.put("support_id", lc.getRamdomString());
			create_map.put("au_id", user.getAu_id());
			create_map.put("answer_id", answer_id);	
		commonService.createFirstSupport(create_map);
		//创建第一次点赞记录的同时,为该回答添加一次mark
		
		Integer mark = commonService.selectUsefulCountByanswerId(answer_id);
		mark = (mark+1);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mark", mark);
		map.put("answers_id", answer_id);
		commonService.updateUsefulMarkByAnswerId(map);
		}else{//如果点过赞了 
			return new ResponseSuccessOrFail("FAIL该账号已经点过赞了", commonService.selectUsefulCountByanswerId(answer_id));
		}
		return new ResponseSuccessOrFail("SUCCESS成功为该账号点赞", commonService.selectUsefulCountByanswerId(answer_id));
	}
	


	
	
}
