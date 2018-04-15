package com.wingfac.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wingfac.entity.Store;

public interface StoreDao {

 	List<Store> select_storeByauId(@Param("au_id")String au_id);
	
}
