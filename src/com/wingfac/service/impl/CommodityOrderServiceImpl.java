package com.wingfac.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingfac.dao.CommodityOrderDao;
import com.wingfac.dao.SystemDao;
import com.wingfac.entity.CommodityOrder;
import com.wingfac.entity.CommodityOrder_resultBean;
import com.wingfac.service.CommodityOrderService;
/**
 ** @author lc   
 *  创建时间：2018-02-08 上午10:11:25 
 */
@Service(value="commodityOrderService")
public class CommodityOrderServiceImpl implements CommodityOrderService{
	
	@Autowired
	private CommodityOrderDao commodityOrderDao;
	
	public List<Map<String,Object>> selectCommodityOrderByOpenId(String open_id) {
		return commodityOrderDao.selectCommodityOrderByOpenId(open_id);
	}

	public void createCommodityOrder(Map<String, Object> map) {
		commodityOrderDao.createCommodityOrder(map);
	}

	public List<CommodityOrder> selectCommodityOrderByComId(String com_id) {
		return commodityOrderDao.selectCommodityOrderByComId(com_id);
	}

	public void deleteCommodityOrderByComId(String com_id) {
		commodityOrderDao.deleteCommodityOrderByComId(com_id);
	}

	public void updateCommodityOrderMoney(Map<String, Object> map) {
		commodityOrderDao.updateCommodityOrderMoney(map);
	}

	public List<CommodityOrder> getAllCommodityOrder() {
		return commodityOrderDao.getAllCommodityOrder();
	}

	public void updateCommodityOrderPrivate(String saleman_id, String com_id) {
		commodityOrderDao.updateCommodityOrderPrivate(saleman_id, com_id);
	}

	public List<Map<String, Object>> selectCommodityOrder(Map<String, Object> map){
		return commodityOrderDao.selectCommodityOrder(map);
	}

	public int countCommodityOrder() {
		return commodityOrderDao.countCommodityOrder();
	}

	public List<Map<String, Object>> selectCommodityOrderN(
			Map<String, Object> map) {
		return commodityOrderDao.selectCommodityOrderN(map);
	}

	public int selectCountCommodityOrderN() {
		return commodityOrderDao.selectCountCommodityOrderN();
	}

	public List<Map<String, Object>> selectCommodityOrderY(
			Map<String, Object> map) {
		return commodityOrderDao.selectCommodityOrderY(map);
	}

	public int selectCountCommodityOrderY() {
		return commodityOrderDao.selectCountCommodityOrderY();
	}

	public String getCommodityOrderId(String com_id) {
		return commodityOrderDao.getCommodityOrderId(com_id);
	}

	public List<Map<String, Object>> selectCommodityVagueUserNickname(
					String keywords) {
		return commodityOrderDao.selectCommodityVagueUserNickname(keywords);
	}

	public List<Map<String, Object>> selectCommodityVagueCommodityBrand(
			String keywords) {
		return commodityOrderDao.selectCommodityVagueCommodityBrand(keywords);
	}

	public List<Map<String, Object>> selectComIdVague(String keyword) {
		return commodityOrderDao.selectComIdVague(keyword);
	}

	public List<Map<String, Object>> selectCnameVague(String keyword) {
		return commodityOrderDao.selectCnameVague(keyword);
	}

	public void updateCommodityOrderOrderState(Map<String, Object> map) {
		commodityOrderDao.updateCommodityOrderOrderState(map);
	}

	public List<Map<String, Object>> selectCommodityOrderByAuId(
			Map<String, Object> map) {
		return commodityOrderDao.selectCommodityOrderByAuId(map);
	}

	public Map<String, Object> selectCommodityOrderInnerjoinCommodity(
			String com_id) {
		return commodityOrderDao.selectCommodityOrderInnerjoinCommodity(com_id);
	}

	public List<Map<String, Object>> selectAllCommodityOrderWaitForGet() {
		return commodityOrderDao.selectAllCommodityOrderWaitForGet();
	}

	public void salemanGetCommodityOrder(String com_id, String saleman_id) {
		commodityOrderDao.salemanGetCommodityOrder(com_id, saleman_id);
	}

	public List<Map<String, Object>> selectAllSalemanGetCommodityOrderNotComplate(
			String saleman_id) {
		return commodityOrderDao.selectAllSalemanGetCommodityOrderNotComplate(saleman_id);
	}

	public void updateComPrice(Map map) {
		commodityOrderDao.updateComPrice(map);
	}

	public List<Map<String, Object>> selectCommodityOrder_state7(
			String saleman_id) {
		return commodityOrderDao.selectCommodityOrder_state7(saleman_id);
	}

	public List<Map<String, Object>> selectAllMyCommodityOrders(String au_id) {
		return commodityOrderDao.selectAllMyCommodityOrders(au_id);
	}

	public List<Map<String, Object>> selectAllMyCommodityOrder_state0(
			String au_id) {
		return commodityOrderDao.selectAllMyCommodityOrder_state0(au_id);
	}

	public List<Map<String, Object>> selectAllMyMaintainOrder_state0(
			String au_id) {
		return commodityOrderDao.selectAllMyCommodityOrder_state0(au_id);
	}

	public List<Map<String, Object>> selectAllMyCommodityOrder_state1(
			String au_id) {
		return commodityOrderDao.selectAllMyCommodityOrder_state1(au_id);
	}

	public List<Map<String, Object>> selectAllSalemanCommodityOrder(
			String saleman_id) {
		return commodityOrderDao.selectAllSalemanCommodityOrder(saleman_id);
	}

	public List<Map<String, Object>> selectAllSalemanCommodityOrder_state7(
			String saleman_id) {
		return commodityOrderDao.selectAllSalemanCommodityOrder_state7(saleman_id);
	}

	public void insertCommodityOrder(Map<String, Object> map) {
		commodityOrderDao.insertCommodityOrder(map);
	}

	public Map<String, Object> getCommodityOrderByComId(String com_id) {
		return commodityOrderDao.getCommodityOrderByComId(com_id);
	}

	public Map<String, Object> selectCommodityOrderBytiaojian(
			Map<String, Object> map) {
		return commodityOrderDao.selectCommodityOrderBytiaojian(map);
	}

	public void updateCommodityOrderState1(
			Map<String, Object> map) {
		commodityOrderDao.updateCommodityOrderState1(map);
	}

	public List<Map<String, Object>> selectUserCentralAirNotPay(String au_id) {
		return commodityOrderDao.selectUserCentralAirNotPay(au_id);
	}

	public List<Map<String, Object>> selectUserCentralAirPay(String au_id) {
		return commodityOrderDao.selectUserCentralAirPay(au_id);
	}

	public List<Map<String, Object>> selectUserCentralAirEvaluated(String au_id) {
		return commodityOrderDao.selectUserCentralAirEvaluated(au_id);
	}

	public List<Map<String, Object>> selectOwnNotPay(String au_id) {
		return commodityOrderDao.selectOwnNotPay(au_id);
	}

	public List<Map<String, Object>> selecOwnPay(String au_id) {
		return commodityOrderDao.selecOwnPay(au_id);
	}

	public List<Map<String, Object>> selectOwnEvalute(String au_id) {
		return commodityOrderDao.selectOwnEvalute(au_id);
	}

	public List<Map<String, Object>> selectAllMyCommodityOrder_state8() {
		return commodityOrderDao.selectAllMyCommodityOrder_state8();
	}

	public void updateCommodityOrderPrice(Map<String, Object> map) {
		commodityOrderDao.updateCommodityOrderPrice(map);
	}

	public List<Map<String, Object>> selectCentralAirOrdersNotPay(String au_id) {
		return commodityOrderDao.selectCentralAirOrdersNotPay(au_id);
	}

	public List<Map<String, Object>> selectNomalAirOrdersNotPay(String au_id) {
		return commodityOrderDao.selectNomalAirOrdersNotPay(au_id);
	}

	public List<Map<String, Object>> selectEmployeeCommodityOrder(
			String saleman_id) {
		return commodityOrderDao.selectEmployeeCommodityOrder(saleman_id);
	}

	public List<Map<String, Object>> selectCentralAirCreateByUser(String au_id) {
		return commodityOrderDao.selectCentralAirCreateByUser(au_id);
	}



}
