package com.sang.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sang.daoImp.SizeSanPhamImp;
import com.sang.entity.SizeSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeSanPhamDao implements SizeSanPhamImp {

	@Autowired
	SessionFactory sessionFactory; 
	
	@Transactional
	public List<SizeSanPham> getAllSizeSanPham() {
		Session session = sessionFactory.getCurrentSession(); 
		String sql = "from sizesanpham"; 
		List<SizeSanPham> listSizeSanPham = session.createQuery(sql).getResultList(); 
		
		return listSizeSanPham;
	}

}











