package com.wingfac.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingfac.dao.CommodityEvaluateDao;
import com.wingfac.entity.CommodityEvaluate;
import com.wingfac.service.CommodityEvaluateService;
@Service(value="commodityEvaluateService")
public class CommodityEvaluateServiceImpl implements CommodityEvaluateService{

	@Autowired
	private CommodityEvaluateDao commodityEvaluateDao;

	public void insertCommodityEvaluateBycId(Map<String, Object> map) {
		commodityEvaluateDao.insertCommodityEvaluateBycId(map);
	}

	public List<CommodityEvaluate> getCommodityEvaluateBycId(String c_id) {
		return commodityEvaluateDao.getCommodityEvaluateBycId(c_id);
	}

	public List<Map<String, Object>> selectCommodityInnerJoinEvaluateByc_id(
			String c_id) {
		return commodityEvaluateDao.selectCommodityInnerJoinEvaluateByc_id(c_id);
	}

	public void insertCommodityEvaluate(Map<String, Object> map) {
		commodityEvaluateDao.insertCommodityEvaluate(map);
	}

	public Map<String, Object> selectEvaluteByCidAndAuid(Map<String, Object> map) {
		return commodityEvaluateDao.selectEvaluteByCidAndAuid(map);
	}

	public List<Map<String, Object>> selectCommodityEvaInnerJoinUserByComId(
			String com_id) {
		return commodityEvaluateDao.selectCommodityEvaInnerJoinUserByComId(com_id);
	}
	

}
