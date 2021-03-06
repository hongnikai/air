package com.wingfac.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wingfac.entity.CommodityEvaluate;

public interface CommodityEvaluateDao {

	void insertCommodityEvaluateBycId(Map<String,Object> map);
	
	List<CommodityEvaluate> getCommodityEvaluateBycId(@Param("c_id")String c_id);
	
	List<Map<String,Object>> selectCommodityInnerJoinEvaluateByc_id(@Param("c_id")String c_id);
	
	void insertCommodityEvaluate(Map<String,Object> map);
	
	Map<String,Object> selectEvaluteByCidAndAuid(Map<String,Object> map);
	
	List<Map<String,Object>> selectCommodityEvaInnerJoinUserByComId(@Param("com_id")String com_id);
}
