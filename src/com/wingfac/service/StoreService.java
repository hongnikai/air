package com.wingfac.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wingfac.entity.Store;
/**
 * 商店service
 * @author LC
 *
 */
public interface StoreService {

	List<Store> select_storeByauId(@Param("au_id")String au_id);
	
}
