package com.sang.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sang.daoImp.DanhMucSanPhamImp;
import com.sang.entity.DanhMucSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucSanPhamDao implements DanhMucSanPhamImp{

	@Autowired
	SessionFactory sessionFactory; 
	
	@Transactional
	public List<DanhMucSanPham> getListDanhMucSanPham() {
		Session session = sessionFactory.getCurrentSession(); 
		String sql="from danhmucsanpham";
		 List<DanhMucSanPham> listDanhMuc = session.createQuery(sql).getResultList(); 
		 return listDanhMuc; 
	}
	
}
























