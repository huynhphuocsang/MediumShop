package com.sang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.dao.ChiTietHoaDonDao;
import com.sang.daoImp.ChiTietHoaDonImp;
import com.sang.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp{

	@Autowired
	ChiTietHoaDonDao chitiethoadondao; 
	
	public void saveChiTietHoaDon(ChiTietHoaDon chitiethoadon) {
		
		chitiethoadondao.saveChiTietHoaDon(chitiethoadon);
	}

}
