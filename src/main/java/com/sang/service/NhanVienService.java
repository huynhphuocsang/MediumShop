package com.sang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.dao.NhanVienDao;
import com.sang.daoImp.NhanVienImp;

@Service
public class NhanVienService implements NhanVienImp{
	@Autowired
	NhanVienDao nhanviendao;

	public boolean checkForLogin(String email, String password) {
		
		return nhanviendao.checkForLogin(email, password);
	}

	public void signUp(String email, String password) {
		nhanviendao.signUp(email, password);
		
	} 
	
}
