package com.wingfac.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DataDao {
	
	Map<String,Object> findBanners();
	
	String findSysBanner();
	
	void updateSysBanner(String shop_banner);
	
	String findSysCaseBanner();
	
	void updateSysCaseBanner(String sys_case_banner);
	
	String findSysDemandBanner();
	
	void updateSysDemandBanner(String sys_demand_banner);
	
	List<Map<String,Object>> selectAskInnerJoinUserBycId(@Param("c_id")String c_id);
	
	void createCommodityAsk(Map<String,Object> map);
	
	
}