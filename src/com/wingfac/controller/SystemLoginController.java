package com.wingfac.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wingfac.bean.OAuthInfo;
import com.wingfac.entity.User;
import com.wingfac.service.SystemService;
import com.wingfac.service.UserService;
import com.wingfac.util.Constants;
import com.wingfac.util.LocalResponseBody;
import com.wingfac.util.ResponseSuccessOrFail;
import com.wingfac.util.Season;
import com.wingfac.util.TimeUtil;
import com.wingfac.util.WeChatCommonUtil;
import com.wingfac.util.lcRamdomUtil;

/**
 *  @描述：后台管理平台登录
 ** @author LC   
 *  创建时间：2018-2-6 下午15:38
 */

@Controller
@Scope(value="prototype")
@RequestMapping("system")
public class SystemLoginController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="systemService")
	private SystemService systemService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		return "/html/index.html";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletResponse response) {
		
		System.out.println("进入测试1");

		return "redirect:/system/aaaaaaaaa.do";
	}
	
	
	@RequestMapping("/aaaaaaaaa")
	public String aaaaaaaaa(HttpServletResponse response) {
		
		System.out.println("进入测试2");

		return "/WEB-INF/gongzhonghao/homePage.html";
	}
	
	@RequestMapping(value = "/LoginAndGetCode")
	public Object getCode(HttpServletRequest request,HttpServletResponse response){
		
		String code = request.getParameter("code");
		String openid = "";
		String accessToken = "";
			if (null != code && !"".equals(code)) {
				// 根据code换取openId
				OAuthInfo oa = WeChatCommonUtil.getOAuthOpenId(code);
				if (!"".equals(oa) && null != oa) {
					openid = oa.getOpenId();
					accessToken = oa.getAccessToken();
				}
			}
		//获取微信用户信息
		JSONObject jsonObject = WeChatCommonUtil.getUserInfo_App(accessToken, openid);
		jsonObject.toString();
		String open_id=jsonObject.getString("openid");
		String headimgurl=jsonObject.getString("headimgurl");
		String nickname=jsonObject.getString("nickname");
		
		HttpSession session = request.getSession();
		session.setAttribute("openid", open_id);
		session.setAttribute("headimgurl", headimgurl);
		session.setAttribute("nickname", nickname);
		
		return "redirect:/system/setRole.do";
	}
	
	/**
	 * 设置角色
	 * @return
	 */
	@RequestMapping(value = "/setRole")
	public Object setRole(HttpServletResponse response,HttpServletRequest request){
				
		HttpSession session = request.getSession();
		
		Object openId=session.getAttribute("openid");
		String open_id=openId.toString();
		String headimgurl=(String)session.getAttribute("headimgurl");
		String nickname=(String) session.getAttribute("nickname");
		
		String result=userService.selectUserOpenIdByOpenId(open_id);
		if(result==null){//第一次访问,创建了角色
			Map<String,Object> map=new HashMap<String,Object>();
			lcRamdomUtil lc=new lcRamdomUtil();
			TimeUtil t=new TimeUtil();
			map.put("au_id", lc.getRamdomString());
			map.put("open_id", openId);
			map.put("create_time", t.getSystemTimeFormart());
			map.put("headimg", headimgurl);	
			map.put("nickname", nickname);						//注： mysql数据库版本问题，
			userService.insertUser(map);						//可能会出现版本过低,不支持emoji表情,
			request.getSession().removeAttribute("headimgurl"); //在开发过程中测试服数据库就不支持
			session.removeAttribute("nickname");//清除没用的session
		}
		
		return "/gongzhonghao/homePage.html";
	}
	
	
	/**
	 * 后台管理登录
	 * @param username 用户名
	 * @param password 密码
	 * @param type 身份（0-普通用户/1-销售/2-技术/3-管理/4-总管理员）
	 * @return
	 */
	@RequestMapping(value = "/loginManager")
	@ResponseBody
	public ResponseSuccessOrFail loginManager(HttpServletRequest request,
							 @RequestParam(value = "username", required = true) String mobile,	
							 @RequestParam(value = "password", required = true) String password,
							 @RequestParam(value = "type", required = true) int type
			){
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("mobile", mobile);
			map.put("password", password);
			map.put("type", type);
			String au_id =systemService.getUserByUnameAndPwd(map);
			if(au_id==null){
				return new ResponseSuccessOrFail("FAIL", "请输入正确的账号和密码");
			}else{
				User user=userService.selectUserByauId(au_id);
				System.out.println("========登录存储session==========");
				HttpSession session = request.getSession();
				session.setAttribute("userId", au_id);
				session.setAttribute("userInfo", user);
				return new ResponseSuccessOrFail("SUCCESS", 1);
			}
		}
	
	/**
	 * 后台管理退出登陆
	 * @param username 用户名
	 * @param password 密码
	 * @param type 身份（0-普通用户/1-销售/2-技术/3-管理/4-总管理员）
	 * @return
	 */
	@RequestMapping(value = "/loginOut")
	public Object loginOut(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.removeAttribute("userId");
		session.removeAttribute("userInfo");
		System.out.println("进入登出接口+++++++++++++++s");
		return "/html/Login.jsp";
	}
	
	/**
	 * 员工登陆接口(用户端)
	 * @param username 用户名
	 * @param password 密码
	 * @param type 身份（0-普通用户/1-销售/2-技术/3-管理/4-总管理员）
	 * @return
	 */
	@RequestMapping(value = "/managementlogin")
	public String managementlogin(HttpServletRequest request,
								@RequestParam("mobile")String mobile,
								@RequestParam("password")String password,
								@RequestParam("usertype")String usertype
								){
		int type=0;
		if(usertype.equals("请选择")){
			request.setAttribute("sign", "请选择用户类型");
			return "/gongzhonghao/register.html";
		}else if(usertype.equals("销售端")){
			Map map=new HashMap();
			map.put("mobile", mobile);
			map.put("password", password);
			map.put("type",1);
			try{
				String au_id=systemService.getUserByUnameAndPwd(map);
				if(au_id==null||au_id==""){
					return "/gongzhonghao/register.html";
				}else{
					User user=userService.selectUserByauId(au_id);
					request.setAttribute("user", user);
					return "/gongzhonghao/personHome_saleman.jsp";
				}
			}catch(Exception e){
				return "/gongzhonghao/register.html";
			}
		}else if(usertype.equals("技术端")){
			Map map=new HashMap();
			map.put("mobile", mobile);
			map.put("password", password);
			map.put("type",2);
			try{
				String au_id=systemService.getUserByUnameAndPwd(map);
				if(au_id==null||au_id==""){
					return "/gongzhonghao/register.html";
				}else{
					User user=userService.selectUserByauId(au_id);
					request.setAttribute("user", user);
					return "/gongzhonghao/personHome_jishu.jsp";
				}
			}catch(Exception e){
				return "/gongzhonghao/register.html";
			}
		}else if(usertype.equals("管理层")){
			Map map=new HashMap();
			map.put("mobile", mobile);
			map.put("password", password);
			map.put("type",3);
			try{
				String au_id=systemService.getUserByUnameAndPwd(map);
				if(au_id==null||au_id==""){
					return "/gongzhonghao/register.html";
				}else{
					User user=userService.selectUserByauId(au_id);
					request.setAttribute("user", user);
					return "/gongzhonghao/personHome_management.jsp";
				}
			}catch(Exception e){
				return "/gongzhonghao/register.html";
			}
		}
		return "/gongzhonghao/register.html";
	}
	
	
}
	
	
	
	
