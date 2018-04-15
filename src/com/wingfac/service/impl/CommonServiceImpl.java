package com.wingfac.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingfac.dao.CommonDao;
import com.wingfac.entity.Commodity;
import com.wingfac.entity.Store;
import com.wingfac.service.CommonService;

/**
 ** @author lc   
 *  创建时间：2018-02-23 上午09:02:25 
 */
@Service(value="commonService")
public class CommonServiceImpl implements CommonService{

	@Autowired
	private CommonDao commonDao;
	
	public List<Commodity> selectCommodityByKeyWords(String new_keywords) {
		return commonDao.selectCommodityByKeyWords(new_keywords);
	}

	public List<Store> selectStoreByname(String new_keywords) {
		return commonDao.selectStoreByname(new_keywords);
	}

	public Integer selectUsefulCountByanswerId(String answer_id) {
		return commonDao.selectUsefulCountByanswerId(answer_id);
	}

	public void updateUsefulMarkByAnswerId(Map<String, Object> map) {
		commonDao.updateUsefulMarkByAnswerId(map);
	}

	public void createFirstSupport(Map<String, Object> map) {
		commonDao.createFirstSupport(map);
	}

	public String makeSureFirstSupportOrNot(String au_id, String answer_id) {
		return commonDao.makeSureFirstSupportOrNot(au_id, answer_id);
	}

	public Map<String, Object> getCommodityAskByAskId(String ask_id) {
		return commonDao.getCommodityAskByAskId(ask_id);
	}

	public void insertAskAll(Map<String, Object> map) {
		commonDao.insertAskAll(map);
	}

	public Map<String, Object> selectAskAllByAskId(String ask_id) {
		return commonDao.selectAskAllByAskId(ask_id);
	}

	public List<Map<String, Object>> selectAnswerByAskId(String ask_id) {
		return commonDao.selectAnswerByAskId(ask_id);
	}

	public List<Map<String, Object>> selectAskAllBycId(String c_id) {
		return commonDao.selectAskAllBycId(c_id);
	}


}
