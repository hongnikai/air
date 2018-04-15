package com.wingfac.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingfac.dao.InstallDao;
import com.wingfac.dao.MaintainDao;
import com.wingfac.entity.Maintain;
import com.wingfac.entity.MaintainOrder;
import com.wingfac.service.MaintainService;
/**
 ** @author lc   
 *  创建时间：2018-02-26 上午09:02:25 
 */
@Service(value="maintainService")
public class MaintainServiceImpl implements MaintainService {

	@Autowired
	private MaintainDao maintainDao;
	
	public List<MaintainOrder> selectMaintainByauId(String au_id) {
		return maintainDao.selectMaintainByauId(au_id);
	}

	public void addMaintain(Map<String, Object> map) {
		maintainDao.addMaintain(map);
	}

	public Map<String, Object> selectMaintainByMaintainId(String maintain_id) {
		return maintainDao.selectMaintainByMaintainId(maintain_id);
	}

	public void addMaintainOrder(Map<String, Object> map) {
			maintainDao.addMaintainOrder(map);
	}

	public List<MaintainOrder> selectMaintainOrderByMaintain_id(String maintain_id) {
		return maintainDao.selectMaintainOrderByMaintain_id(maintain_id);
	}

	public List<MaintainOrder> selectMaintainOrderNotBuy() {
		return maintainDao.selectMaintainOrderNotBuy();
	}

	public List<Map<String, Object>> selectMaintainOrderByUserId(Map<String, Object> map){
		return maintainDao.selectMaintainOrderByUserId(map);
	}

	public int selectCountMaintainOrderByUserId(String au_id) {
		return maintainDao.selectCountMaintainOrderByUserId(au_id);
	}

	public void deleteMaintainByMaintainId(String maintain_id) {
		maintainDao.deleteMaintainByMaintainId(maintain_id);
	}

	public void createMaintainOrder(Map<String, Object> map) {
		maintainDao.createMaintainOrder(map);
	}

	public Map<String, Object> getMaintainOrderByMaintainOrderId(
			String maintain_order_id) {
		return maintainDao.getMaintainOrderByMaintainOrderId(maintain_order_id);
	}

	public List<Map<String, Object>> selectAllMyMaintainOrders(String au_id) {
		return maintainDao.selectAllMyMaintainOrders(au_id);
	}

	public List<Map<String, Object>> selectAllMyMaintainOrder_state0(
			String au_id) {
		return maintainDao.selectAllMyMaintainOrder_state0(au_id);
	}

	public List<Map<String, Object>> selectAllMyMaintainOrder_state1(
			String au_id) {
		return maintainDao.selectAllMyMaintainOrder_state1(au_id);
	}

	public void updateMaintainOrderState1(String maintain_order_id) {
		maintainDao.updateMaintainOrderState1(maintain_order_id);
	}

	public List<Map<String, Object>> selectMaintainOrderPay() {
		return maintainDao.selectMaintainOrderPay();
	}

	public List<Map<String, Object>> selectMaintainOrderState5(
			String maintain_man_id) {
		return maintainDao.selectMaintainOrderState5(maintain_man_id);
	}

	public void updateMaintainOrderPrivate(String maintain_order_id,
			String maintain_man_id) {
		maintainDao.updateMaintainOrderPrivate(maintain_order_id, maintain_man_id);
	}

	public List<Map<String, Object>> selectMaintainOrderState7(
			String maintain_man_id) {
		return maintainDao.selectMaintainOrderState7(maintain_man_id);
	}

	public List<Map<String, Object>> findEmployeeMaintainOrder(
			String maintain_man_id) {
		return maintainDao.findEmployeeMaintainOrder(maintain_man_id);
	}

	public List<Map<String, Object>> findMaintainEvaByMaintainOrderId(
			String maintain_order_id) {
		return maintainDao.findMaintainEvaByMaintainOrderId(maintain_order_id);
	}

	public Map<String, Object> selectMaintainOrderById(String maintain_order_id) {
		return maintainDao.selectMaintainOrderById(maintain_order_id);
	}

	public void deleteMaintainOrderById(String maintain_order_id) {
		maintainDao.deleteMaintainOrderById(maintain_order_id);
	}


	
	
}
