package com.wingfac.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingfac.dao.CommonDao;
import com.wingfac.dao.InstallDao;
import com.wingfac.entity.Install;
import com.wingfac.entity.InstallOrder;
import com.wingfac.service.InstallService;
/**
 ** @author lc   
 *  创建时间：2018-02-26 上午09:02:25 
 */
@Service(value="installService")
public class InstallServiceImpl implements InstallService{

	@Autowired
	private InstallDao installDao;
	
	public void insertInstall(Map<String, Object> map) {
		installDao.insertInstall(map);
	}

	public List<String> getInstall_IdByAu_id(String au_id) {
		return installDao.getInstall_IdByAu_id(au_id);
	}

	public void updateTimeByinstallId(Map<String, Object> map) {
		installDao.updateTimeByinstallId(map);
	}

	public void createInstallOrderByInstall(Map<String, Object> map) {
			installDao.createInstallOrderByInstall(map);
	}

	public List<InstallOrder> selectInstallOrderByAuId(String au_id) {
		return installDao.selectInstallOrderByAuId(au_id);
	}

	public InstallOrder selectInstallOrderByinstallOrderId(
			String install_order_id) {
		return installDao.selectInstallOrderByinstallOrderId(install_order_id);
	}

	public Install selectInstallByinstall_id(String install_id) {
		return installDao.selectInstallByinstall_id(install_id);
	}

	public List<InstallOrder> selectAllInstallOrderNotBuy() {
		return installDao.selectAllInstallOrderNotBuy();
	}

	public List<Map<String, Object>> selectInstallBrandVague(String keyword) {
		return installDao.selectInstallBrandVague(keyword);
	}

	public void createInstallOrder(Map<String, Object> map) {
		installDao.createInstallOrder(map);
	}

	public void updateInstallOrderAddressInformation(Map<String, Object> map) {
		installDao.updateInstallOrderAddressInformation(map);
	}

	public Map<String, Object> selectTheNearestInstallOrderByAu_id(String au_id) {
		return installDao.selectTheNearestInstallOrderByAu_id(au_id);
	}

	public void updateAddressInformation(Map<String, Object> map) {
		installDao.updateAddressInformation(map);
	}

	public Map<String, Object> selectInstallOrderByInstall_idLimit1(
			String install_id) {
		return installDao.selectInstallOrderByInstall_idLimit1(install_id);
	}

	public void deleteInstallOrderByInstallOrderId(String install_order_id) {
		installDao.deleteInstallOrderByInstallOrderId(install_order_id);
	}

	public List<Map<String, Object>> selectAllMyInstallOrders(String au_id) {
		return installDao.selectAllMyInstallOrders(au_id);
	}

	public List<Map<String, Object>> selectAllMyInstallOrder_state0(String au_id) {
		return installDao.selectAllMyInstallOrder_state0(au_id);
	}

	public List<Map<String, Object>> selectAllMyInstallOrder_state1(String au_id) {
		return installDao.selectAllMyInstallOrder_state1(au_id);
	}
	
	public void updateInstallOrderState1(String install_order_id) {
		installDao.updateInstallOrderState1(install_order_id);
	}

	public List<Map<String, Object>> selectInstallOrderPay() {
		return installDao.selectInstallOrderPay();
	}

	public List<Map<String, Object>> selectInstallByInstallOrder_id(
			String install_id) {
		return installDao.selectInstallByInstallOrder_id(install_id);
	}

	public List<Map<String, Object>> selectInstallOrder4(
			String install_man_id) {
		return installDao.selectInstallOrder4(install_man_id);
	}

	public void updateInstallOrderPrivate(String install_man_id,
			String install_order_id) {
		installDao.updateInstallOrderPrivate(install_man_id, install_order_id);
	}

	public List<Map<String, Object>> selectInstallOrder7(String install_man_id) {
		return installDao.selectInstallOrder7(install_man_id);
	}

	public List<Map<String, Object>> findEmployeeInstallOrder(
			String install_man_id) {
		return installDao.findEmployeeInstallOrder(install_man_id);
	}

	public List<Map<String, Object>> findInstallEvaByInstallOrderId(
			String install_order_id) {
		return installDao.findInstallEvaByInstallOrderId(install_order_id);
	}

	public Map<String, Object> selectInstallByInstallId(String install_id) {
		return installDao.selectInstallByInstallId(install_id);
	}

	public void deleteInstallByInstallId(String install_id) {
		installDao.deleteInstallByInstallId(install_id);
	}



}
