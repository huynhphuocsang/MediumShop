package com.sang.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sang.daoImp.HoaDonImp;
import com.sang.entity.HoaDon;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDao implements HoaDonImp{

	@Autowired
	SessionFactory sessionFactory; 
		
	@Transactional
	public int saveHoaDon(HoaDon hoadon) {
		Session session = sessionFactory.getCurrentSession(); 
		int id =  (Integer) session.save(hoadon);  
		return id; 
	}

}
