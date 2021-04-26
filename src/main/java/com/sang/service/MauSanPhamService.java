package com.sang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.dao.MauSanPhamDao;
import com.sang.daoImp.MauSanPhamImp;
import com.sang.entity.MauSanPham;

@Service
public class MauSanPhamService implements MauSanPhamImp{

	@Autowired
	MauSanPhamDao mausanphamdao; 
	
	public List<MauSanPham> getAllMauSanPham() {
		return mausanphamdao.getAllMauSanPham(); 
	}

}
