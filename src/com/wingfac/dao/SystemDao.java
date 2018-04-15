package com.wingfac.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wingfac.entity.User;

public interface SystemDao{
	
	String getUserByUnameAndPwd(Map<String,Object> map);
	
	List<String> getSystemNotice();
	
	List<Map<String,Object>> getHotGoodsLimitFour();
	
	void updateShopBanner(@Param("shop_banner")String shop_banner);
	
	String selectShopBannerFromSysData();
	
	void updateSystemNoticeFromSysData(@Param("system_notice")String system_notice);
	
}
