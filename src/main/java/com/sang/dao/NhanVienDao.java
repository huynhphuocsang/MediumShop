package com.sang.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sang.daoImp.NhanVienImp;
import com.sang.entity.Nhanvien;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDao implements NhanVienImp {
	
	@Autowired 
	SessionFactory sessionFactory;

	@Transactional
	public boolean checkForLogin(String email, String password) {
		System.out.println("dao called!");
		Session session = sessionFactory.getCurrentSession(); 
		String sql = "from nhanvien where email = '"+email+"' and matkhau = '"+password+"'"; 
		try {
			Nhanvien nhanvien = (Nhanvien) session.createQuery(sql).getSingleResult(); 
		}catch(Exception ex) {
			return false; 
		}
		return true; 
	}

	@Transactional
	public void signUp(String email, String password) {
		Nhanvien nv = new Nhanvien(); 
		nv.setEmail(email);
		nv.setMatkhau(password);
		Session session = sessionFactory.getCurrentSession(); 
		session.save(nv);
		
	} 
	
}
