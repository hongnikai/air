package com.wingfac.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingfac.dao.CommodityDao;
import com.wingfac.dao.CommodityOrderDao;
import com.wingfac.entity.Commodity;
import com.wingfac.entity.CommodityAnswer;
import com.wingfac.entity.CommodityAsk;
import com.wingfac.entity.CommoditySaleCounts_resultBean;
import com.wingfac.service.CommodityService;
/**
 ** @author lc   
 *  创建时间：2018-02-08 下午15:11:25 
 */
@Service(value="commodityService")
public class CommodityServiceImpl implements CommodityService{
	
	@Autowired
	private CommodityDao commodityDao;
	
	public void insertCommodity_Messages(Map<String, Object> map){
		commodityDao.insertCommodity_Messages(map);
	}

	public List<Commodity> selectCommodityByscreen(Map<String, Object> map) {
		return commodityDao.selectCommodityByscreen(map);
	}

	public List<Commodity> selectStoreGoodsByauId(String au_id) {
		return commodityDao.selectStoreGoodsByauId(au_id);
	}

	public List<Commodity> selectCommoditys() {
		return commodityDao.selectCommoditys();
	}

	public List<Commodity> selectAllcommodityByasc() {
		return commodityDao.selectAllcommodityByasc();
	}

	public List<Commodity> selectAllcommodityBydesc() {
		return commodityDao.selectAllcommodityBydesc();
	}

	public List<CommoditySaleCounts_resultBean> selectCommodityBySaleCountsDesc() {
		return commodityDao.selectCommodityBySaleCountsDesc();
	}

	public List<CommoditySaleCounts_resultBean> selectCommodityBySaleCountsAsc() {
		return commodityDao.selectCommodityBySaleCountsAsc();
	}

	public Commodity getCommodityByc_id(String c_id) {
	    return commodityDao.getCommodityByc_id(c_id);
	}

	public void insertCommodityAsk(Map<String, Object> map) {
		commodityDao.insertCommodityAsk(map);
	}

	public List<CommodityAsk> selectAskBycId(String c_id) {
		return commodityDao.selectAskBycId(c_id);
	}

	public void addCommodityAnswer(Map<String, Object> map) {
		commodityDao.addCommodityAnswer(map);
	}

	public List<Map<String, Object>> selectCommodityAnswerByaskId(String ask_id) {
		return commodityDao.selectCommodityAnswerByaskId(ask_id);
	}
	
	public List<CommoditySaleCounts_resultBean> selectFourHotCommodity() {
		return commodityDao.selectFourHotCommodity();
	}

	public List<Map<String, Object>> getAllCommodity(Map<String, Object> map) {
		return commodityDao.getAllCommodity(map);
	}

	public int CountAllCommodity() {
		return commodityDao.CountAllCommodity();
	}

	public List<Map<String, Object>> selectEvaluateBycId(String c_id) {
		return commodityDao.selectEvaluateBycId(c_id);
	}

	public void updateCoverPictureBycId(String cover_picture, String c_id) {
		commodityDao.updateCoverPictureBycId(cover_picture, c_id);
	}

	public void updateCommodityUseType(Map<String, Object> map) {
		commodityDao.updateCommodityUseType(map);
	}

	public void updateCommodityInformation(Map<String, Object> map) {
		commodityDao.updateCommodityInformation(map);
	}

	public void updateCommodityMarkBycId(Map<String, Object> map) {
		commodityDao.updateCommodityMarkBycId(map);
	}

	public List<Commodity> selectCommodityVague(String keyword) {
		return commodityDao.selectCommodityVague(keyword);
	}

	public List<Map<String, Object>> selectCommodityBrandVague(String keyword) {
		return commodityDao.selectCommodityBrandVague(keyword);
	}

	public List<Map<String, Object>> selectCommodityCnameVague(String keyword) {
		return commodityDao.selectCommodityCnameVague(keyword);
	}

	public void insertCommodity(Map<String, Object> map) {
		commodityDao.insertCommodity(map);
	}

	public List<Map<String, Object>> getCommodityActivity(
			Map<String, Object> map) {
		return commodityDao.getCommodityActivity(map);
	}

	public List<Map<String, Object>> selectCommodityOrder_orderState(
			String saleman_id) {
		return commodityDao.selectCommodityOrder_orderState(saleman_id);
	}

	public void addCommodityToCommodityCar(Map<String, Object> map) {
		commodityDao.addCommodityToCommodityCar(map);
	}

	public List<Map<String, Object>> selectUserAllCommodityInCommodityCar(
			String au_id) {
		return commodityDao.selectUserAllCommodityInCommodityCar(au_id);
	}

	public double selectCommodityCarPrice(String au_id) {
		return commodityDao.selectCommodityCarPrice(au_id);
	}

	public List<Map<String, Object>> selectCommodityNotCentralAirCondition() {
		return commodityDao.selectCommodityNotCentralAirCondition();
	}

	public List<Commodity> selectCommodityNotCentralAirConditionAsc() {
		return commodityDao.selectCommodityNotCentralAirConditionAsc();
	}

	public List<Commodity> selectCommodityNotCentralAirConditionDesc() {
		return commodityDao.selectCommodityNotCentralAirConditionDesc();
	}

	public List<CommoditySaleCounts_resultBean> selectCommodiyBySaleCountsNotCentralAirConditionDesc() {
		return commodityDao.selectCommodiyBySaleCountsNotCentralAirConditionDesc();
	}

	public List<CommoditySaleCounts_resultBean> selectCommodityBySaleCountsNotCentralAirConditionAsc() {
		return commodityDao.selectCommodityBySaleCountsNotCentralAirConditionAsc();
	}

	public List<Map<String, Object>> selectEvaluateBycIdInnerJoinUser(
			String c_id) {
		return commodityDao.selectEvaluateBycIdInnerJoinUser(c_id);
	}

	public Map<String, Object> selectCommodityCarInformationInnerJoin(
			String c_car_id) {
		return commodityDao.selectCommodityCarInformationInnerJoin(c_car_id);
	}

	public void delectCommodityInCart(String c_car_id) {
		commodityDao.delectCommodityInCart(c_car_id);
	}

	public Map<String, Object> getCommodityPriceByc_car_id(String c_car_id) {
		return commodityDao.getCommodityPriceByc_car_id(c_car_id);
	}

	public List<Map<String, Object>> selectAllCentralAirCondition() {
		return commodityDao.selectAllCentralAirCondition();
	}

	public List<Map<String, Object>> selectAllCentralAirConditionOrderByPriceDesc() {
		return commodityDao.selectAllCentralAirConditionOrderByPriceDesc();
	}

	public List<Map<String, Object>> selectAllCentralAirConditionOrderByPriceAsc() {
		return commodityDao.selectAllCentralAirConditionOrderByPriceAsc();
	}

	public List<Map<String, Object>> selecAllCentralAirConditionOrderBySaleCountsDesc() {
		return commodityDao.selecAllCentralAirConditionOrderBySaleCountsDesc();
	}

	public List<Map<String, Object>> selecAllCentralAirConditionOrderBySaleCountsAsc() {
		return commodityDao.selecAllCentralAirConditionOrderBySaleCountsAsc();
	}

	public void insertAskAllAnswers(Map<String, Object> map) {
		commodityDao.insertAskAllAnswers(map);
	}

	public List<Map<String, Object>> chooseCommodityByScreen(
			Map<String, Object> map) {
		return commodityDao.chooseCommodityByScreen(map);
	}


	



}
