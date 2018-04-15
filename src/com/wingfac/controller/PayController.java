package com.wingfac.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.ibatis.annotations.Param;
import org.jdom.JDOMException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wingfac.entity.Address;
import com.wingfac.entity.CommodityOrder;
import com.wingfac.entity.Repair;
import com.wingfac.entity.User;
import com.wingfac.service.CommodityOrderService;
import com.wingfac.service.CommodityService;
import com.wingfac.service.InstallService;
import com.wingfac.service.MaintainService;
import com.wingfac.service.RepairService;
import com.wingfac.service.UserService;
import com.wingfac.util.Constants;
import com.wingfac.util.TimeUtil;
import com.wingfac.util.WXUtil;
import com.wingfac.util.WXPay.GZ.RequestHandler;
import com.wingfac.util.WXPay.GZ.XMLUtil;
import com.wingfac.util.WXPay.GZ.PayCommonUtil;

/**
 *  @描述：支付测试Controller
 ** @author LC   
 *  创建时间：2018-3-9 下午15:38
 */
@Controller
@Scope(value="prototype")
@RequestMapping("payController")
public class PayController {

	protected static Logger logger = Logger.getLogger(PayController.class);
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="commodityOrderService")
	private CommodityOrderService commodityOrderService;
	
	@Resource(name="maintainService")
	private MaintainService maintainService;
	
	@Resource(name="installService")
	private InstallService installService;
	
	@Resource(name="repairService")
	private RepairService repairService;
	 /**
     * 预支付生成订单
     * @param request
     * @param money	金额
     * @param openid	微信用户openid
     * @param user_id	用户id
     * @return
     */
	@RequestMapping(value = "/toPay_Weixin")
	@ResponseBody
    public Map<String, Object> ToPay(HttpServletRequest request,
    		@Param(value = "money") BigDecimal money,
    		@Param(value = "openid") String openid,
    		@Param(value = "au_id") String au_id,
    		@Param(value = "a_id") String a_id,
    		@Param(value = "c_id")String c_id
    		/*,
    		@Param(value = "exchange_integral") Double exchange_integral,
    		@Param(value = "charging_ratio") Double charging_ratio*/
    		){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		User user=userService.selectUserByauId(au_id);
		if(user!= null){
			if (user.getMobile()!= null){
				String timeMillis = WXUtil.getTimeStamp();//时间戳
				String nonceStr = WXUtil.getNonceStr();//随机字符串
				String trade_no = WXUtil.getTrade_No();//随机订单号
				Map<String, String> map = weixinPrePay(trade_no,money,openid,nonceStr,request);
				String return_code = (String) map.get("return_code");
		        String prepay_id = null;
		        if (return_code.contains("SUCCESS")) {
		        	System.out.println("下单成功");
		String com_id= commodityOrderService.getCommodityOrderId(trade_no);
		if(com_id==null){
			prepay_id = (String) map.get("prepay_id");// 获取到prepay_id
			System.out.println("prepay_id:"+prepay_id);
			SortedMap<String, Object> finalpackage = new TreeMap<String, Object>();
			finalpackage.put("appId", Constants.GZ_AppID);  
	        finalpackage.put("timeStamp", timeMillis);  
	        finalpackage.put("nonceStr", nonceStr);  
	        finalpackage.put("package", "prepay_id="+prepay_id);
	        finalpackage.put("signType", "MD5");
	        System.out.println("*****************返回结果****************************");
	        System.out.println("appId："+Constants.GZ_AppID);  
	        System.out.println("timeStamp："+timeMillis);  
	        System.out.println("nonceStr："+ nonceStr);  
	        System.out.println("package："+ "prepay_id="+prepay_id);
	        System.out.println("signType："+ "MD5");
	        String sign = PayCommonUtil.createSign("UTF-8", finalpackage);  
	        System.out.println("第二次生成签名:"+sign);
	        finalpackage.put("paySign", sign);
	        resultMap.put("data", finalpackage);
	        System.out.println("给前台的paySign:"+finalpackage.get("paySign"));
			resultMap.put("responseStatus", 0);
			resultMap.put("msg", "微信统一订单下单成功！");
		}else{
			System.out.println("网络错误！");
			System.out.println("创建订单失败");
		}
		        }else{
		        	resultMap.put("responseStatus", 1);
					resultMap.put("msg", "微信统一订单下单失败！");
		        }
			}else{
				resultMap.put("responseStatus", 2);
				resultMap.put("msg", "请绑定手机手机号！！");
			}
		}else{
			resultMap.put("responseStatus", 1);
			resultMap.put("msg", "请重新登录！");
		}
		return resultMap;
	}
	
	
	@SuppressWarnings("unchecked")
    public Map<String, String> weixinPrePay(String trade_no,BigDecimal totalAmount, 
    		      String openid, String nonceStr,HttpServletRequest request
    		      ){ 
		SortedMap<String, Object> parameterMap = new TreeMap<String, Object>();  
		 parameterMap.put("appid", Constants.GZ_AppID);  
	     parameterMap.put("mch_id", Constants.GZ_WXMchid);  // 微信商户账号
	     parameterMap.put("device_info", "WEB");
	     parameterMap.put("nonce_str", nonceStr);  
	     parameterMap.put("body", "微信公众号支付");// 商品参数信息
	     parameterMap.put("out_trade_no", trade_no);// 订单编号
	     BigDecimal total = totalAmount.multiply(new BigDecimal(100));  
	     java.text.DecimalFormat df=new java.text.DecimalFormat("0");  
	     parameterMap.put("total_fee", df.format(total)); // 支付金额 单位为分 
	     parameterMap.put("trade_type", "JSAPI");
	     parameterMap.put("openid", openid);
	     parameterMap.put("notify_url",Constants.GZ_WXNotifyUrl);
	     
	     System.out.println("appid："+ Constants.GZ_AppID);
	     System.out.println("mch_id："+ Constants.GZ_WXMchid);
	     System.out.println("nonce_str："+ nonceStr);
	     System.out.println("body："+"微信公众号支付");
	     System.out.println("out_trade_no："+ trade_no);
	     System.out.println("total_fee："+ df.format(total));
	     System.out.println("notify_url: "+Constants.GZ_WXNotifyUrl);
	     String sign = PayCommonUtil.createSign("UTF-8", parameterMap); // 生成签名
	     parameterMap.put("sign", sign);  
	     System.out.println("第一次生成签名:"+sign);
	     
	     String requestXML = XMLUtil.getRequestXml(parameterMap);// 生成Xml格式的字符串  
	     String result = PayCommonUtil.httpsRequest(Constants.GATEURL, "POST",   requestXML);  // 以post请求的方式调用统一下单接口
	     System.out.println("=======下单失败原因：======"+result);
	     
	     Map<String, String> map = null;  
	        try {  
	            map = PayCommonUtil.doXMLParse(result);  
	        } catch (JDOMException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
		return map;
	}
	
	/**
     * 微信支付结果通知
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/weixinNotify")
    public void payNotifyUrl(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	System.out.println("===========进入微信支付结果通知===================");
    	String out_trade_no=null;
        String return_code =null;
        String total_fee = null;
        
        try {
            InputStream inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            String resultStr  = new String(outSteam.toByteArray(),"utf-8");
            logger.info("支付成功的回调："+resultStr);
            Map<String, Object> resultMap = XMLUtil.doXMLParse(resultStr);
            String result_code = (String) resultMap.get("result_code");
            String is_subscribe = (String) resultMap.get("is_subscribe");
            String transaction_id = (String) resultMap.get("transaction_id");
            String sign = (String) resultMap.get("sign");
            String time_end = (String) resultMap.get("time_end");
            String bank_type = (String) resultMap.get("bank_type");
            total_fee = (String) resultMap.get("total_fee");
            out_trade_no = (String) resultMap.get("out_trade_no");
            return_code = (String) resultMap.get("return_code");
            request.setAttribute("out_trade_no", out_trade_no);
            System.out.println("支付金额："+total_fee);
            //通知微信.异步确认成功.必写.不然微信会一直通知后台.八次之后就认为交易失败了.
            response.getWriter().write(RequestHandler.setXML("SUCCESS", ""));
        }  catch (Exception e) {
            logger.error("微信回调接口出现错误：",e);
            try {
                response.getWriter().write(RequestHandler.setXML("FAIL", "error"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } 
        if(return_code.equals("SUCCESS")){
       	System.out.println("==========支付成功的业务逻辑==========");
          //5.推送
          //判断是否存在此订单
       	
       		
			//Store_Order store_Order =  this.store_Order_Service.getById(out_trade_no);
		/*	if (com_id != null) {
				if (store_Order.getStatus() == 0) {
					int reply = this.store_Order_Service.doPay(out_trade_no);
					if (reply > 0) {
						//5.推送
						Store store = this.store_Service.detailedInformation(Long.parseLong(store_Order.getS_id()));//店铺信息
						Long au_id = store.getAu_id();//店主id
						Average_User average_User = login_Registration_Service.viewUserInformation(au_id);//店主信息
						String registerId = average_User.getRegister_id();
						String content = "兑兑乐提醒您，有新订单！金额为："+store_Order.getMoney();
						if (registerId != null) {
							JpushClientUtil.sendToRegistrationId(registerId, content, content, content, content);
						}
						logger.debug("支付宝支付成功");
					} else {
						logger.debug("支付宝支付失败");
					}
				}else{
					logger.debug("此订单已支付成功");
				}
			}else{
				logger.debug("此订单不存在");
			}*/
       	String com_id=commodityOrderService.getCommodityOrderId(out_trade_no);
        if(com_id!=null){
         List<CommodityOrder> list=commodityOrderService.selectCommodityOrderByComId(out_trade_no);
         /*list.get(0).get*/
         
        }
        
        
        }else{
            //支付失败的业务逻辑
        	System.out.println("==========支付失败的业务逻辑==========");
        }
    }
	
	@RequestMapping("/targetPay")
	public String targetPay(HttpServletRequest request,HttpServletResponse response
							){
		return "/gongzhonghao/Pay.jsp";
	}
	
	/**
	 *  查询保养订单表图片
	 * @return
	 */
	@RequestMapping("/toPayTheMaintainOrder")
	public String toPayTheOrder(HttpServletRequest request,
							@RequestParam("maintain_id")String maintain_id,
							@RequestParam("a_id")String a_id,
							@RequestParam("maintain_order_id")String maintain_order_id
							){
		
		Address address=userService.getAddressInformationByAId(a_id);
		Map<String,Object> maintain=maintainService.selectMaintainByMaintainId(maintain_id);
		request.setAttribute("maintain", maintain);
		request.setAttribute("address", address);
		User user=userService.selectUserByauId(address.getAu_id());
		request.setAttribute("user", user);
		Map<String,Object> maintain_order=maintainService.getMaintainOrderByMaintainOrderId(maintain_order_id);
		request.setAttribute("maintain_order", maintain_order);
		
		return "/pay/maintainPay.jsp";
	}
	
	/**
	 *  查询保养订单表图片
	 * @return
	 */
	@RequestMapping("/toPayTheRepairOrder")
	public String toPayThePairOrder(HttpServletRequest request,
								@RequestParam("repair_id")String repair_id,
								@RequestParam("a_id")String a_id,
								@RequestParam("repair_order_id")String repair_order_id
								){
		Address address=userService.getAddressInformationByAId(a_id);
		request.setAttribute("address", address);
		Repair repair=repairService.selectRepairByRepairId(repair_id);
		Map<String,Object> repair_order=repairService.getRepairOrderByRepairOrderId(repair_order_id);
		request.setAttribute("repair", repair);
		request.setAttribute("repair_order", repair_order);
		User user=userService.selectUserByauId(address.getAu_id());
		request.setAttribute("user", user);
		
		return "/pay/repairPay.jsp";
	}
	
}
