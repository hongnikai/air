package com.wingfac.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wingfac.entity.Install;
import com.wingfac.entity.InstallOrder;

/**
 * 安装service
 * @author LC
 *
 */
public interface InstallService {

	void insertInstall(Map<String,Object> map);
	
	List<String> getInstall_IdByAu_id(@Param("au_id")String au_id);
	
	void updateTimeByinstallId(Map<String,Object> map);
	
	InstallOrder selectInstallOrderByinstallOrderId(@Param("install_order_id")String install_order_id);
	
	void createInstallOrderByInstall(Map<String,Object> map);
	
	List<InstallOrder> selectInstallOrderByAuId(@Param("au_id")String au_id);
	
	Install selectInstallByinstall_id(@Param("install_id")String install_id);
	
	List<InstallOrder> selectAllInstallOrderNotBuy();
	
	List<Map<String,Object>> selectInstallBrandVague(@Param("keyword")String keyword);
	
	void createInstallOrder(Map<String,Object> map);
	
	void updateInstallOrderAddressInformation(Map<String,Object> map);
	
	Map<String,Object> selectTheNearestInstallOrderByAu_id(@Param("au_id")String au_id);
	
	void updateAddressInformation(Map<String,Object> map);
	
	Map<String,Object> selectInstallOrderByInstall_idLimit1(@Param("install_id")String install_id);
	
	void deleteInstallOrderByInstallOrderId(@Param("install_order_id")String install_order_id);
	
	List<Map<String,Object>> selectAllMyInstallOrders(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectAllMyInstallOrder_state0(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectAllMyInstallOrder_state1(@Param("au_id")String au_id);
	
	void updateInstallOrderState1(@Param("install_order_id")String install_order_id);
	
	List<Map<String,Object>> selectInstallOrderPay();
	
	List<Map<String,Object>> selectInstallByInstallOrder_id(@Param("install_id")String install_id);
	
	List<Map<String,Object>> selectInstallOrder4(@Param("install_man_id")String install_man_id);
	
	void updateInstallOrderPrivate(@Param("install_man_id")String install_man_id,@Param("install_order_id")String install_order_id);

	List<Map<String,Object>> selectInstallOrder7(@Param("install_man_id")String install_man_id);

	List<Map<String,Object>> findEmployeeInstallOrder(@Param("install_man_id")String install_man_id);
	
	List<Map<String,Object>> findInstallEvaByInstallOrderId(@Param("install_order_id")String install_order_id);
	
	Map<String,Object> selectInstallByInstallId(@Param("install_id")String install_id);
	
	void deleteInstallByInstallId(@Param("install_id")String install_id);
	
}
