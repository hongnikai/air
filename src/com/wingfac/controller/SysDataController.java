package com.wingfac.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.Constants;
import com.wingfac.service.DataService;
import com.wingfac.service.SystemService;
import com.wingfac.util.ResponseSuccessOrFail;
import com.wingfac.util.UploadUtil;

/**
 * @描述:系统数据
 * @author lc
 * 创建时间：2018-1-16 下午13:17
 */
@Controller
@RequestMapping("/lc/sysdata")
public class SysDataController {
	
	@Autowired
	private DataService dataService;
	
	@Autowired
	private SystemService systemService;
	
	private MultipartFile[] file;
	/**
	 * 上传图片
	 * @return
	 */
    @RequestMapping("/uploadImags")
    public ResponseSuccessOrFail uploadImags(HttpServletResponse response,
    						  HttpServletRequest request,
    						  @RequestParam(value="path",required = false,defaultValue="pictures/system")String path,
    						  @RequestParam(value = "file", required = false)MultipartFile[] file,
  							  @RequestParam(value="file_name",required=false,defaultValue="1.jpg")String file_name
    						  ){
    	UploadUtil u=new UploadUtil();
    	
    	String shop_banner =dataService.findSysBanner();
    	String[] banners=shop_banner.split(",");
    	for (int i = 0; i < file.length; i++) {
    		String s=u.uploadFilesToPath(request, file[i], path);	
    		if(s==null||s.equals("")||s.equals(" ")){
    			banners[i]=banners[i];
    		}else{
    			banners[i]=s;
    		}
    	}
    	String str=StringUtils.join(banners, ",");
    	dataService.updateSysBanner(str);
    	
    	String pictures =dataService.findSysBanner();
    	/*
    	String picturePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ "/";
    	String new_path = picturePath +"air/"+ path+file_name;*/
    	
    	
    	return new ResponseSuccessOrFail("上传成功",pictures);
    }
    /**
	 * 上传图片
	 * @return
	 */
    @RequestMapping("/uploadImags2")
    public String uploadImags2(HttpServletResponse response,
							   HttpServletRequest request,
							   @RequestParam(value = "file", required = false)MultipartFile[] file
							   ){
    	UploadUtil u=new UploadUtil();
    	String path="pictures/demand/casebanners";
    	String sys_case_banner=dataService.findSysCaseBanner();
    	String[] banners=sys_case_banner.split(",");
    	for (int i = 0; i < file.length; i++) {
    		String s=u.uploadFilesToPath(request, file[i], path);	
    		if(s==null||s.equals("")||s.equals(" ")){
    			banners[i]=banners[i];
    		}else{
    			banners[i]=s;
    		}
    	}
    	String str=StringUtils.join(banners, ",");
    	dataService.updateSysCaseBanner(str);
    	return "redirect:/lc/sysdata/slideshowManage.action";
    }
    /**
	 * 上传图片
	 * @return
	 */
    @RequestMapping("/uploadImags3")
    public String uploadImags3(HttpServletResponse response,
							   HttpServletRequest request,
							   @RequestParam(value = "file", required = false)MultipartFile[] file
							   ){
    	UploadUtil u=new UploadUtil();
    	String path="pictures/demand/demandBanners";
    	String sys_demand_banner=dataService.findSysDemandBanner();
    	String[] banners=sys_demand_banner.split(",");
    	for (int i = 0; i < file.length; i++) {
    		String s=u.uploadFilesToPath(request, file[i], path);	
    		if(s==null||s.equals("")||s.equals(" ")){
    			banners[i]=banners[i];
    		}else{
    			banners[i]=s;
    		}
    	}
    	String str=StringUtils.join(banners, ",");
    	dataService.updateSysDemandBanner(str);
    	return "redirect:/lc/sysdata/slideshowManage.action";
    }
    
    @RequestMapping("/asdasd")
    @ResponseBody
    public String asdasd(HttpServletRequest request){
    	String picturePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ "/";
    	return picturePath;
    }
    /**
     * 获取系统轮播图  
     * @param request
     * @return
     */
    @RequestMapping("/getSystemBanners")
    @ResponseBody
    public List getSystemBanners(HttpServletRequest request,HttpServletResponse response){
    /*	String picturePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ "/";
    	String path="pictures/system/";*/
    	List<Object> list=new ArrayList<Object>();
    	String banner=systemService.selectShopBannerFromSysData();
    	String[] banners=banner.split(",");
    	list.add(banners[1]);
    	list.add(banners[2]);
    	list.add(banners[3]);
    	
    	return list;
    }
    
    /**
     * 获取活动轮播图
     * @param request
     * @return
     */
    @RequestMapping("/getActivityBanners")
    @ResponseBody
    public ResponseSuccessOrFail getActivityBanners(HttpServletRequest request,HttpServletResponse response){
    	String picturePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ "/";
    	String path="pictures/activity/";
    	
    	String pic1="1.jpg";
    	String pic2="2.jpg";
    	String pic3="3.jpg";
    	List list=new ArrayList();
    	
    	list.add(new String(picturePath+"air/"+path+pic1));
    	list.add(new String(picturePath+"air/"+path+pic2));
    	list.add(new String(picturePath+"air/"+path+pic3));
    	
    	return new ResponseSuccessOrFail("响应成功", list);
    }
    
    /**
	 * @描述:获取品牌活动轮播图
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/getBrandActivityBanners")
	@ResponseBody
    public ResponseSuccessOrFail getBrandActivityBanners(HttpServletRequest request,HttpServletResponse response){
		
		String picturePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ "/";
    	String path="pictures/brandActivity/";
    	
    	String pic1="1.jpg";
    	String pic2="2.jpg";
    	String pic3="3.jpg";
    	String pic4="4.jpg";
    	List list=new ArrayList();
    	
    	list.add(new String(picturePath+"air/"+path+pic1));
    	list.add(new String(picturePath+"air/"+path+pic2));
    	list.add(new String(picturePath+"air/"+path+pic3));
    	list.add(new String(picturePath+"air/"+path+pic4));
    	
    	return new ResponseSuccessOrFail("响应成功", list);
	}
	
	/**
	 * @描述:获取热销商品轮播图
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/getHotCommodityBanners")
	@ResponseBody
	public ResponseSuccessOrFail getHotCommodityBanners(HttpServletRequest request,HttpServletResponse response){
		
		/*String picturePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ "/";
    	String path="pictures/hotCommodity/";
    	
    	String pic1="1.jpg";
    	String pic2="2.jpg";
    	String pic3="3.jpg";
    	String pic4="4.jpg";
    	List list=new ArrayList();
    	
    	list.add(new String(picturePath+"air/"+path+pic1));
    	list.add(new String(picturePath+"air/"+path+pic2));
    	list.add(new String(picturePath+"air/"+path+pic3));
    	list.add(new String(picturePath+"air/"+path+pic4));*/
    		
    	List<Map<String,Object>> list=systemService.getHotGoodsLimitFour();
    	
    	return new ResponseSuccessOrFail("响应成功", list);
	}
	
	/**
	 * @描述:获取系统公告
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/getSystemNotice")
	@ResponseBody
	public ResponseSuccessOrFail getSystemNotice(HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin","*");
		List<String> list=systemService.getSystemNotice();
		if(list.size()<1){
			return new ResponseSuccessOrFail("FAIL", "数据为空");
		}
		return new ResponseSuccessOrFail("SCUESS", list);
	}
	
	/**
	 * @描述:上传首页广告图
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/uploadSystemBanners")
	public String uploadSystemBanners(HttpServletRequest request,HttpServletResponse response,
									@RequestParam(value = "file", required = false)MultipartFile[] file
									){
		UploadUtil u=new UploadUtil();
		String detail_path="pictures/system";
		String pics="";
		for (int i = 0; i < file.length; i++) {
    		String s=u.uploadFilesToPath(request, file[i], detail_path);	
    		if(s==null||s.equals("")||s.equals(" ")){
    		}else{
    			pics+=(","+s);
    		}
    	}
		if(pics==null||pics==""||pics==" "){}else{
			systemService.updateShopBanner(pics);	
		}
		return "html/informationManagement.jsp";
	}
	
	/**
	 * @描述:上传首页公告
	 * @param  
	 * @return
	 */
	@RequestMapping(value = "/uploadSystemNotice")
	public String updataSystemNotice(HttpServletResponse response,HttpServletRequest request,
									@RequestParam(value="neirong",required=false)String neirong
									){
		systemService.updateSystemNoticeFromSysData(neirong);
		
		return "redirect:../../targetBackstage/informationManagement.do";
	}
	
	
}
