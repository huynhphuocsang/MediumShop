package com.sang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.dao.SizeSanPhamDao;
import com.sang.daoImp.SizeSanPhamImp;
import com.sang.entity.SizeSanPham;

@Service
public class SizeSanPhamService implements SizeSanPhamImp {

	@Autowired
	SizeSanPhamDao sizesanphamdao; 
	
	public List<SizeSanPham> getAllSizeSanPham() {
		return sizesanphamdao.getAllSizeSanPham(); 
	}

}
