package com.sang.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sang.daoImp.ChiTietHoaDonImp;
import com.sang.entity.ChiTietHoaDon;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDao implements ChiTietHoaDonImp{

	@Autowired
	SessionFactory sessionFactory; 
	
	@Transactional
	public void saveChiTietHoaDon(ChiTietHoaDon chitiethoadon) {
		Session session = sessionFactory.getCurrentSession(); 
		session.save(chitiethoadon);
		
	}

}





















