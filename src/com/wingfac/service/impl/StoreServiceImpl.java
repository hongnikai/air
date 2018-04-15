package com.wingfac.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wingfac.dao.StoreDao;
import com.wingfac.dao.SystemDao;
import com.wingfac.entity.Store;
import com.wingfac.service.StoreService;

@Service(value="storeService")
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreDao storeDao;
	
	public List<Store> select_storeByauId(String au_id) {
		return storeDao.select_storeByauId(au_id);
	}

	
	
}
