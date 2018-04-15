package com.wingfac.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingfac.dao.SystemDao;
import com.wingfac.entity.User;
import com.wingfac.service.SystemService;
/**
 ** @author lc   
 *  创建时间：2018-02-08 上午10:11:25 
 */
@Service(value="systemService")
public class SystemServiceImpl implements SystemService{
	
	@Autowired
	private SystemDao systemDao;


	public String getUserByUnameAndPwd(Map<String,Object> map) {
		return systemDao.getUserByUnameAndPwd(map);
	}

	public List<String> getSystemNotice() {
		return systemDao.getSystemNotice();
	}

	public List<Map<String, Object>> getHotGoodsLimitFour() {
		return systemDao.getHotGoodsLimitFour();
	}

	public void updateShopBanner(String shop_banner) {
		systemDao.updateShopBanner(shop_banner);
	}

	public String selectShopBannerFromSysData() {
		return systemDao.selectShopBannerFromSysData();
	}

	public void updateSystemNoticeFromSysData(String system_notice) {
		systemDao.updateSystemNoticeFromSysData(system_notice);
	}
	
}
