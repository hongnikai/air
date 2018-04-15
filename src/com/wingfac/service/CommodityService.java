package com.wingfac.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wingfac.entity.Commodity;
import com.wingfac.entity.CommodityAnswer;
import com.wingfac.entity.CommodityAsk;
import com.wingfac.entity.CommoditySaleCounts_resultBean;
/**
 * 商品service
 * @author LC
 *
 */
public interface CommodityService {

	
	void insertCommodity_Messages(Map<String,Object> map);
	
	List<Commodity> selectCommodityByscreen(Map<String,Object> map);
	
	List<Commodity> selectStoreGoodsByauId(@Param("au_id")String au_id);
	
	List<Commodity> selectCommoditys();
	
	List<Commodity> selectAllcommodityByasc();
	
	List<Commodity> selectAllcommodityBydesc();
	
	List<CommoditySaleCounts_resultBean> selectCommodityBySaleCountsDesc();
	
	List<CommoditySaleCounts_resultBean> selectCommodityBySaleCountsAsc();
	
	Commodity getCommodityByc_id(@Param("c_id")String c_id);
	
	void insertCommodityAsk(Map<String,Object> map);
	
	List<CommodityAsk> selectAskBycId(@Param("c_id")String c_id);
	
	void addCommodityAnswer(Map<String,Object> map);
	
	List<Map<String,Object>> selectCommodityAnswerByaskId(@Param("ask_id")String ask_id);
	
	List<CommoditySaleCounts_resultBean> selectFourHotCommodity();
	
	List<Map<String,Object>> getAllCommodity(Map<String,Object> map);
	
	int CountAllCommodity();
	
	List<Map<String,Object>> selectEvaluateBycId(@Param("c_id")String c_id);
	
	void updateCoverPictureBycId(@Param("cover_picture")String cover_picture,@Param("c_id")String c_id);
	
	void updateCommodityUseType(Map<String,Object> map);
	
	void updateCommodityInformation(Map<String,Object> map);
	
	void updateCommodityMarkBycId(Map<String,Object> map);
	
	List<Commodity> selectCommodityVague(@Param("keyword")String keyword);
	
	List<Map<String,Object>> selectCommodityBrandVague(@Param("keyword")String keyword);
	
	List<Map<String,Object>> selectCommodityCnameVague(@Param("keyword")String keyword);
	
	void insertCommodity(Map<String,Object> map);
	
	List<Map<String,Object>> getCommodityActivity(Map<String,Object> map);
	
	List<Map<String,Object>> selectCommodityOrder_orderState(@Param("saleman_id")String saleman_id);
	
	void addCommodityToCommodityCar(Map<String,Object> map);
	
	List<Map<String,Object>> selectUserAllCommodityInCommodityCar(@Param("au_id")String au_id);
	
	double selectCommodityCarPrice(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectCommodityNotCentralAirCondition();
	
	List<Commodity> selectCommodityNotCentralAirConditionAsc();
	
	List<Commodity> selectCommodityNotCentralAirConditionDesc();
	
	List<CommoditySaleCounts_resultBean> selectCommodiyBySaleCountsNotCentralAirConditionDesc();
	
	List<CommoditySaleCounts_resultBean> selectCommodityBySaleCountsNotCentralAirConditionAsc();
	
	List<Map<String,Object>> selectEvaluateBycIdInnerJoinUser(@Param("c_id")String c_id);
	
	Map<String,Object> selectCommodityCarInformationInnerJoin(@Param("c_car_id")String c_car_id);
	
	void delectCommodityInCart(@Param("c_car_id")String c_car_id);
	
	Map<String,Object> getCommodityPriceByc_car_id(@Param("c_car_id")String c_car_id);
	
	List<Map<String,Object>> selectAllCentralAirCondition();
	
	List<Map<String,Object>> selectAllCentralAirConditionOrderByPriceDesc();
	
	List<Map<String,Object>> selectAllCentralAirConditionOrderByPriceAsc();
	
	List<Map<String,Object>> selecAllCentralAirConditionOrderBySaleCountsDesc();
	
	List<Map<String,Object>> selecAllCentralAirConditionOrderBySaleCountsAsc();
	
	void insertAskAllAnswers(Map<String,Object> map);
	
	List<Map<String,Object>> chooseCommodityByScreen(Map<String,Object> map);
	
}
