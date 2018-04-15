package com.wingfac.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.wingfac.entity.CommodityOrder;
import com.wingfac.entity.CommodityOrder_resultBean;
import com.wingfac.entity.User;

public interface CommodityOrderDao{
	
	List<Map<String,Object>> selectCommodityOrderByOpenId(@Param("open_id")String open_id);
	
	void createCommodityOrder(Map<String,Object> map);
	
	List<CommodityOrder> selectCommodityOrderByComId(@Param("com_id")String com_id);
	
	void deleteCommodityOrderByComId(@Param("com_id")String com_id);
	
	void updateCommodityOrderMoney(Map<String,Object> map);
	
	List<CommodityOrder> getAllCommodityOrder();
	
	void updateCommodityOrderPrivate(@Param("saleman_id")String saleman_id,@Param("com_id")String com_id);
	
	List<Map<String,Object>> selectCommodityOrder(Map<String,Object> map);
	
	int countCommodityOrder();
	
	List<Map<String,Object>> selectCommodityOrderN(Map<String,Object> map);
	
	int selectCountCommodityOrderN();
	
	List<Map<String,Object>> selectCommodityOrderY(Map<String,Object> map);
	
	int selectCountCommodityOrderY();
	
	String getCommodityOrderId(@Param("com_id")String com_id);
	
	List<Map<String,Object>> selectCommodityVagueUserNickname(@Param("keywords")String keywords);
	
	List<Map<String,Object>> selectCommodityVagueCommodityBrand(@Param("keywords")String keywords);
	
	List<Map<String,Object>> selectComIdVague(@Param("keyword")String keyword);
	
	List<Map<String,Object>> selectCnameVague(@Param("keyword")String keyword);
	
	void updateCommodityOrderOrderState(Map<String,Object> map);
	
	List<Map<String,Object>> selectCommodityOrderByAuId(Map<String,Object> map);
	
	Map<String,Object> selectCommodityOrderInnerjoinCommodity(@Param("com_id")String com_id);
	
	List<Map<String,Object>> selectAllCommodityOrderWaitForGet();
	
	void salemanGetCommodityOrder(@Param("com_id")String com_id,@Param("saleman_id")String saleman_id);
	
	List<Map<String,Object>> selectAllSalemanGetCommodityOrderNotComplate(@Param("saleman_id")String saleman_id);
	
	void updateComPrice(Map map);
	
	List<Map<String,Object>> selectCommodityOrder_state7(@Param("saleman_id")String saleman_id);
	
	List<Map<String,Object>> selectAllMyCommodityOrders(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectAllMyCommodityOrder_state0(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectAllMyCommodityOrder_state1(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectAllSalemanCommodityOrder(@Param("saleman_id")String saleman_id);
	
	List<Map<String,Object>> selectAllSalemanCommodityOrder_state7(@Param("saleman_id")String saleman_id);
	
	void insertCommodityOrder(Map<String,Object> map);
	
	Map<String,Object> getCommodityOrderByComId(@Param("com_id")String com_id);
	
	Map<String,Object> selectCommodityOrderBytiaojian(Map<String,Object> map);
	
	void updateCommodityOrderState1(Map<String,Object> map);
	
	List<Map<String,Object>> selectUserCentralAirNotPay(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectUserCentralAirPay(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectUserCentralAirEvaluated(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectOwnNotPay(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selecOwnPay(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectOwnEvalute(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectAllMyCommodityOrder_state8();
	
	void updateCommodityOrderPrice(Map<String,Object> map);
	
	List<Map<String,Object>> selectCentralAirOrdersNotPay(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectNomalAirOrdersNotPay(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectEmployeeCommodityOrder(@Param("saleman_id")String saleman_id);
	
	List<Map<String,Object>> selectCentralAirCreateByUser(@Param("au_id")String au_id);
	
	
	
	
	
}
