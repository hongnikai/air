package com.wingfac.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wingfac.entity.Maintain;
import com.wingfac.entity.MaintainOrder;

public interface MaintainDao {

	List<MaintainOrder> selectMaintainByauId(@Param("au_id")String au_id);
	
	void addMaintain(Map<String,Object> map);
	
	Map<String,Object> selectMaintainByMaintainId(@Param("maintain_id")String maintain_id);
	
	void addMaintainOrder(Map<String,Object> map);
	
	List<MaintainOrder> selectMaintainOrderByMaintain_id(@Param("maintain_id")String maintain_id);
	
	List<MaintainOrder> selectMaintainOrderNotBuy();
	
	List<Map<String,Object>> selectMaintainOrderByUserId(Map<String,Object> map);
	
	int selectCountMaintainOrderByUserId(@Param("au_id")String au_id);
	
	void deleteMaintainByMaintainId(@Param("maintain_id")String maintain_id);
	
	void createMaintainOrder(Map<String,Object> map);
	
	Map<String,Object> getMaintainOrderByMaintainOrderId(@Param("maintain_order_id")String maintain_order_id);
	
	List<Map<String,Object>> selectAllMyMaintainOrders(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectAllMyMaintainOrder_state0(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectAllMyMaintainOrder_state1(@Param("au_id")String au_id);
	
	void updateMaintainOrderState1(@Param("maintain_order_id")String maintain_order_id);
	
	List<Map<String,Object>> selectMaintainOrderPay();
	
	List<Map<String,Object>> selectMaintainOrderState5(@Param("maintain_man_id")String maintain_man_id);
	
	void updateMaintainOrderPrivate(@Param("maintain_order_id")String maintain_order_id,@Param("maintain_man_id")String maintain_man_id);
	
	List<Map<String,Object>> selectMaintainOrderState7(@Param("maintain_man_id")String maintain_man_id);
	
	List<Map<String,Object>> findEmployeeMaintainOrder(@Param("maintain_man_id")String maintain_man_id);
	
	List<Map<String,Object>> findMaintainEvaByMaintainOrderId(@Param("maintain_order_id")String maintain_order_id);
	
	Map<String,Object> selectMaintainOrderById(@Param("maintain_order_id")String maintain_order_id);
	
	void deleteMaintainOrderById(@Param("maintain_order_id")String maintain_order_id);
	
	
	
}
