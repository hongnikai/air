package com.wingfac.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wingfac.entity.Address;
import com.wingfac.entity.User;

public interface UserDao{
	
	List<Map<String,Object>> findUser(Map<String,Object> map);
	
	User getByOpenid(@Param("open_id")String open_id);
	
	int countAllUsers();
	
	void updateUserNicenameMoblieTypeByAuId(Map<String,Object> map);
	
	User selectUserByauId(@Param("au_id")String au_id);
	
	void updateUserTypeByAuId(@Param("au_id")String au_id);
	
	void insertUser(Map<String,Object> map);
	
	void updateUserInformation(Map<String,Object> map);
	
	void addNewAddressByUser(Map<String,Object> map);
	
	List<Address> selectAddressByAuId(@Param("au_id")String au_id);
	
	void updateAddressByAId(Map<String,Object> map);
	
	Address getAddressInformationByAId(@Param("a_id")String a_id);
	
	void updateUserDefaulAddress(@Param("address")String address,@Param("au_id")String au_id);
	
	void deleteAddressByAId(@Param("a_id")String a_id);
	
	String selectUserOpenIdByOpenId(@Param("open_id")String open_id);
	
	List<Map<String,Object>> selectUserCommodityOrderByUserId(Map<String,Object> map);
	
	List<Map<String,Object>> selectUserInstallOrderByUserId(Map<String,Object> map);
	
	int selectCountCommodityOrderByUserId(Map<String,Object> map);
	
	int selectCountInstallOrderByUserId(@Param("au_id")String au_id);
	
	List<User> getUserOrderStateWait(@Param("page")int page);
	
	int CountUserOrderstateWait();
	
	void updateUserOrderStatePass(@Param("au_id")String au_id);
	
	void updateUserOrderStateRefuse(@Param("au_id")String au_id);
	
	void deleteUserByUserId(@Param("au_id")String au_id);
	
	List<User> selectAllSaler(Map<String,Object> map);
	
	int selectCountAllSaler();
	
	int closeSalerOrderstateAndType(@Param("au_id")String au_id);
	
	List<Map<String,Object>> selectAllRepairWorker(Map<String,Object> map);
	
	int CountAllRepairWorker();
	
	List<Map<String,Object>> selectKeywordsInNickname(@Param("keywords")String keywords);
	
	List<User> getUserType3(Map<String,Object> map);
	
	int getCountUserType3();
	
	List<Map<String,Object>> selectUserMobileVague(@Param("keyword")String keyword);
	
	void insertAddress(Map<String,Object> map);
	
	void updateUserAddressByAuId(Map<String,Object> map);
	
	void updateUserType0(@Param("au_id")String au_id);
	
	Map<String,Object> findNewAddressPersonal(@Param("au_id")String au_id);
	
	String checkUserInformation(@Param("mobile")String mobile,@Param("password")String password);
	
	List<Map<String,Object>> selectALLSalemanAndJiShu();
	
	
}
