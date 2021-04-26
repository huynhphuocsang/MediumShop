package com.sang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.dao.DanhMucSanPhamDao;
import com.sang.daoImp.DanhMucSanPhamImp;
import com.sang.entity.DanhMucSanPham;

@Service
public class DanhMucSanPhamService implements DanhMucSanPhamImp{

	@Autowired
	DanhMucSanPhamDao danhmucsanphamdao; 
	
	public List<DanhMucSanPham> getListDanhMucSanPham() {
		return danhmucsanphamdao.getListDanhMucSanPham(); 
	}
	
}
