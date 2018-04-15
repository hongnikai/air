package com.wingfac.controller.target;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wingfac.service.UserService;

/**
 *  @描述：跳转专用
 ** @author LC   
 *  创建时间：2018-3-7 下午15:38
 */
@Controller
@Scope(value="prototype")
@RequestMapping("targetBackstage")
public class TargetBackstage {
	/** 
	 * 负责页面跳转   后台管理html文件夹
	 * @author boy 
	 * 
	 */  
	  @RequestMapping(value="{pageName}",method=RequestMethod.GET)  
	  public String toPageHtml(@PathVariable("pageName")String pageName){  
	        return "/html/"+pageName+".jsp";  
	    }  
	 //启动项目后，如果你想跳转到login.jsp页面，直接http://localhost:8080/项目名/page/login.do即可。

	  
	  
	  
}
