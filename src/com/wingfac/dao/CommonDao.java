package com.wingfac.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wingfac.entity.Commodity;
import com.wingfac.entity.Store;

public interface CommonDao {

	List<Commodity> selectCommodityByKeyWords(@Param("new_keywords")String new_keywords);
	
	List<Store> selectStoreByname(@Param("new_keywords")String new_keywords);
	
	Integer selectUsefulCountByanswerId(@Param("answers_id")String answer_id);
	
	void updateUsefulMarkByAnswerId(Map<String,Object> map);
	
	void createFirstSupport(Map<String,Object> map);
	
	String makeSureFirstSupportOrNot(@Param("au_id")String au_id,@Param("answer_id")String answer_id);
	
	Map<String,Object> getCommodityAskByAskId(@Param("ask_id")String ask_id);
	
	void insertAskAll(Map<String,Object> map);
	
	Map<String,Object> selectAskAllByAskId(@Param("ask_id")String ask_id);
	
	List<Map<String,Object>> selectAnswerByAskId(@Param("ask_id")String ask_id);
	
	List<Map<String,Object>> selectAskAllBycId(@Param("c_id")String c_id);
	
	
	
}
