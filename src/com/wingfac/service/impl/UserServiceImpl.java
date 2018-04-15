package com.wingfac.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingfac.dao.UserDao;
import com.wingfac.entity.Address;
import com.wingfac.entity.User;
import com.wingfac.service.UserService;
/**
 ** @author lc   
 *  创建时间：2018-02-08 上午10:11:25 
 */
@Service(value="userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public List<Map<String,Object>> findUser(Map<String,Object> map) {
		return userDao.findUser(map);
	}

	public User getByOpenid(String open_id) {
		return userDao.getByOpenid(open_id);
	}

	public int countAllUsers() {
		return userDao.countAllUsers();
	}

	public User selectUserByauId(String au_id) {
		return userDao.selectUserByauId(au_id);
	}

	public void updateUserNicenameMoblieTypeByAuId(Map<String, Object> map) {
		userDao.updateUserNicenameMoblieTypeByAuId(map);
	}

	public void updateUserTypeByAuId(String au_id) {
		userDao.updateUserTypeByAuId(au_id);
	}

	public void insertUser(Map<String, Object> map) {
		userDao.insertUser(map);
	}

	public void updateUserInformation(Map<String, Object> map) {
		userDao.updateUserInformation(map);
	}

	public void addNewAddressByUser(Map<String, Object> map) {
		userDao.addNewAddressByUser(map);
	}

	public List<Address> selectAddressByAuId(String au_id) {
		return userDao.selectAddressByAuId(au_id);
	}

	public void updateAddressByAId(Map<String, Object> map) {
		userDao.updateAddressByAId(map);
	}

	public Address getAddressInformationByAId(String a_id) {
		return userDao.getAddressInformationByAId(a_id);
	}

	public void updateUserDefaulAddress(String address, String au_id) {
		userDao.updateUserDefaulAddress(address, au_id);
	}

	public void deleteAddressByAId(String a_id) {
		userDao.deleteAddressByAId(a_id);
	}

	public String selectUserOpenIdByOpenId(String open_id) {
		return userDao.selectUserOpenIdByOpenId(open_id);
	}

	public List<Map<String,Object>> selectUserCommodityOrderByUserId(Map<String,Object> map) {
		return userDao.selectUserCommodityOrderByUserId(map);
	}

	public List<Map<String, Object>> selectUserInstallOrderByUserId(Map<String,Object> map) {
		return userDao.selectUserInstallOrderByUserId(map);
	}

	public int selectCountCommodityOrderByUserId(Map<String, Object> map) {
		return userDao.selectCountCommodityOrderByUserId(map);
	}

	public int selectCountInstallOrderByUserId(String au_id) {
		return userDao.selectCountInstallOrderByUserId(au_id);
	}

	public List<User> getUserOrderStateWait(int page) {
		return userDao.getUserOrderStateWait(page);
	}

	public int CountUserOrderstateWait() {
		return userDao.CountUserOrderstateWait();
	}

	public void updateUserOrderStatePass(String au_id) {
		userDao.updateUserOrderStatePass(au_id);
	}

	public void updateUserOrderStateRefuse(String au_id) {
		userDao.updateUserOrderStateRefuse(au_id);
	}

	public void deleteUserByUserId(String au_id) {
		userDao.deleteUserByUserId(au_id);
	}

	public List<User> selectAllSaler(Map<String,Object> map) {
		return userDao.selectAllSaler(map);
	}

	public int selectCountAllSaler() {
		return userDao.selectCountAllSaler();
	}

	public int closeSalerOrderstateAndType(String au_id) {
		return userDao.closeSalerOrderstateAndType(au_id);
	}

	public List<Map<String,Object>> selectAllRepairWorker(Map<String, Object> map) {
		return userDao.selectAllRepairWorker(map);
	}

	public int CountAllRepairWorker() {
		return userDao.CountAllRepairWorker();
	}

	public List<Map<String, Object>> selectKeywordsInNickname(String keywords) {
		return userDao.selectKeywordsInNickname(keywords);
	}

	public List<User> getUserType3(Map<String,Object> map) {
		return userDao.getUserType3(map);
	}

	public int getCountUserType3() {
		return userDao.getCountUserType3();
	}

	public List<Map<String, Object>> selectUserMobileVague(String keyword) {
		return userDao.selectUserMobileVague(keyword);
	}

	public void insertAddress(Map<String, Object> map) {
		 userDao.insertAddress(map);
	}

	public void updateUserAddressByAuId(Map<String, Object> map) {
		userDao.updateUserAddressByAuId(map);
	}

	public void updateUserType0(String au_id) {
		userDao.updateUserType0(au_id);
	}

	public Map<String, Object> findNewAddressPersonal(String au_id) {
		return userDao.findNewAddressPersonal(au_id);
	}

	public String checkUserInformation(String mobile, String password) {
		return userDao.checkUserInformation(mobile, password);
	}

	public List<Map<String, Object>> selectALLSalemanAndJiShu() {
		return userDao.selectALLSalemanAndJiShu();
	}






}
