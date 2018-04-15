package com.wingfac.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingfac.dao.MaintainDao;
import com.wingfac.dao.RepairDao;
import com.wingfac.entity.Repair;
import com.wingfac.entity.RepairOrder;
import com.wingfac.service.RepairService;
/**
 ** @author lc   
 *  创建时间：2018-02-26 上午09:02:25 
 */
@Service(value="repairService")
public class RepairServiceImpl implements RepairService{

	@Autowired
	private RepairDao repairDao;
	
	public List<RepairOrder> selectRepairByauId(String au_id) {
		return repairDao.selectRepairByauId(au_id);
	}

	public void addRepair(Map<String, Object> map) {
			repairDao.addRepair(map);
	}

	public Repair selectRepairByRepairId(String repair_id) {
		return repairDao.selectRepairByRepairId(repair_id);
	}

	public void createRepairOrder(Map<String, Object> map) {
		repairDao.createRepairOrder(map);
	}

	public List<RepairOrder> selectRepairOrderByRepairId(String repair_id) {
		return repairDao.selectRepairOrderByRepairId(repair_id);
	}

	public List<RepairOrder> selectAllRepairOrderNotBuy() {
		return repairDao.selectAllRepairOrderNotBuy();
	}

	public List<Map<String, Object>> selectRepairOrderByUserId(Map<String, Object> map) {
		return repairDao.selectRepairOrderByUserId(map);
	}

	public int selectCountRepairOrderByUserId(String au_id) {
		return repairDao.selectCountRepairOrderByUserId(au_id);
	}

	public void createRepair(Map<String, Object> map) {
		repairDao.createRepair(map);
	}

	public void insertRepairOrder(Map<String, Object> map) {
		repairDao.insertRepairOrder(map);
	}

	public Map<String, Object> getRepairOrderByRepairOrderId(
			String repair_order_id) {
		return repairDao.getRepairOrderByRepairOrderId(repair_order_id);
	}

	public List<Map<String, Object>> selectAllMyRepairOrders(String au_id) {
		return repairDao.selectAllMyRepairOrders(au_id);
	}

	public List<Map<String, Object>> selectAllMyRepairOrder_state0(String au_id) {
		return repairDao.selectAllMyRepairOrder_state0(au_id);
	}

	public List<Map<String, Object>> selectAllMyRepairOrder_state1(String au_id) {
		return repairDao.selectAllMyRepairOrder_state1(au_id);
	}

	public void updateRepairOrderState1(String repair_order_id) {
		repairDao.updateRepairOrderState1(repair_order_id);
	}

	public List<Map<String, Object>> selectRepairOrderPay() {
		return repairDao.selectRepairOrderPay();
	}

	public List<Map<String, Object>> selectRepairOrderState6(
			String repair_man_id) {
		return repairDao.selectRepairOrderState6(repair_man_id);
	}

	public void updateRepairOrderPrivate(String repair_order_id,
			String repair_man_id) {
			repairDao.updateRepairOrderPrivate(repair_order_id, repair_man_id);
	}

	public List<Map<String, Object>> selectRepairOrderState7(
			String repair_man_id) {
		return repairDao.selectRepairOrderState7(repair_man_id);
	}

	public List<Map<String, Object>> findEmployeeRepairOrder(
			String repair_man_id) {
		return repairDao.findEmployeeRepairOrder(repair_man_id);
	}

	public List<Map<String, Object>> findRepairEvaDetail(String repair_order_id) {
		return repairDao.findRepairEvaDetail(repair_order_id);
	}

	public void deleteRepairByRepairId(String repair_id) {
		repairDao.deleteRepairByRepairId(repair_id);
	}

	public Map<String, Object> selectReapirOrderById(String repair_order_id) {
		return repairDao.selectReapirOrderById(repair_order_id);
	}

	public void deleteRepairOrderById(String repair_order_id) {
		repairDao.deleteRepairOrderById(repair_order_id);
	}

	
}
