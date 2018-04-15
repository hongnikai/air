package com.wingfac.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingfac.dao.DataDao;
import com.wingfac.service.DataService;

@Service(value="dataService")
public class DataServiceImpl implements DataService{

	@Autowired(required=false)
	private DataDao dataDao;

	public Map<String,Object> findBanners() {
		return dataDao.findBanners();
	}

	public String findSysBanner() {
		return dataDao.findSysBanner();
	}

	public void updateSysBanner(String shop_banner) {
		dataDao.updateSysBanner(shop_banner);
	}

	public String findSysCaseBanner() {
		return dataDao.findSysCaseBanner();
	}

	public void updateSysCaseBanner(String sys_case_banner) {
		dataDao.updateSysCaseBanner(sys_case_banner);
	}

	public String findSysDemandBanner() {
		return dataDao.findSysDemandBanner();
	}

	public void updateSysDemandBanner(String sys_demand_banner) {
		dataDao.updateSysDemandBanner(sys_demand_banner);
	}

	public List<Map<String, Object>> selectAskInnerJoinUserBycId(String c_id) {
		return dataDao.selectAskInnerJoinUserBycId(c_id);
	}

	public void createCommodityAsk(Map<String, Object> map) {
		dataDao.createCommodityAsk(map);
	}
	
}
