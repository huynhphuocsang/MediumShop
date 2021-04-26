package com.sang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.dao.HoaDonDao;
import com.sang.daoImp.HoaDonImp;
import com.sang.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp{

	
	@Autowired
	HoaDonDao hoadondao;

	public int saveHoaDon(HoaDon hoadon) {
		return hoadondao.saveHoaDon(hoadon); 
	} 
	
	
	

}
