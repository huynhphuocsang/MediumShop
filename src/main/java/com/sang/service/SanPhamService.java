package com.sang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sang.dao.NhanVienDao;
import com.sang.dao.SanPhamDao;
import com.sang.daoImp.SanPhamImp;
import com.sang.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp{

	@Autowired
	SanPhamDao sanphamdao; 
	
	
	public List<SanPham> getListProduct() {
		return sanphamdao.getListProduct(); 
	}


	


	public SanPham getSpecificProduct(int id) {
		return sanphamdao.getSpecificProduct(id); 
	}





	public List<SanPham> getListProductViaCategory(int id) {
		return sanphamdao.getListProductViaCategory(id);
	}





	public List<SanPham> getLimitProduct(int startIndex, int maxRow) {
		return sanphamdao.getLimitProduct(startIndex, maxRow); 
	}





	public void deleteProduct(int id) {
		sanphamdao.deleteProduct(id);
		
	}





	public int addProduct(SanPham sp) {
		return sanphamdao.addProduct(sp); 
	}





	public int updateProduct(SanPham sp) {
		return sanphamdao.updateProduct(sp); 
		
	}

}
