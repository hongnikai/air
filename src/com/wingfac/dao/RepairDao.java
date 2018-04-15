package com.wingfac.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wingfac.entity.Repair;
import com.wingfac.entity.RepairOrder;

public interface RepairDao {

	List<RepairOrder> selectRepairByauId(@Param("au_id")String au_id);
	
	void addRepair(Map<String,Object> map);
	
	Repair selectRepairByRepairId(@Param("repair_id")String repair_id);
	
	void createRepairOrder(Map<String,Object> map);
	
	List<RepairOrder> selectRepairOrderByRepairId(@Param("repair_id")String repair_id);
	
	List<RepairOrder> selectAllRepairOrderNotBuy();
	
	List<Map<String,Object>> selectRepairOrderByUserId(Map<String,Object> map);
	
	int selectCountRepairOrderByUserId(@Param("au_id")String au_id);
	
	void createRepair(Map<String,Object> map);
	
	void insertRepairOrder(Map<String,Object> map);
	
	Map<String,Object> getRepairOrderByRepairOrderId(@Param("repair_order_id")String repair_order_id);
	
	List<Map<String,Object>> selectAllMyRepairOrders(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectAllMyRepairOrder_state0(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectAllMyRepairOrder_state1(@Param("au_id")String au_id);
	
	void updateRepairOrderState1(@Param("repair_order_id")String repair_order_id);
	
	List<Map<String,Object>> selectRepairOrderPay();
	
	List<Map<String,Object>> selectRepairOrderState6(@Param("repair_man_id")String repair_man_id);
	
	void updateRepairOrderPrivate(@Param("repair_order_id")String repair_order_id,@Param("repair_man_id")String repair_man_id);

	List<Map<String,Object>> selectRepairOrderState7(@Param("repair_man_id")String repair_man_id);

	List<Map<String,Object>> findEmployeeRepairOrder(@Param("repair_man_id")String repair_man_id);

	List<Map<String,Object>> findRepairEvaDetail(@Param("repair_order_id")String repair_order_id);
	
	void deleteRepairByRepairId(@Param("repair_id")String repair_id);
	
	Map<String,Object> selectReapirOrderById(@Param("repair_order_id")String repair_order_id);
	
	void deleteRepairOrderById(@Param("repair_order_id")String repair_order_id);
	
	
	
	
	
}
