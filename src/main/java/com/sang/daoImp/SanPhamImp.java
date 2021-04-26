package com.sang.daoImp;

import java.util.List;

import com.sang.entity.SanPham;

public interface SanPhamImp {
	public List<SanPham> getListProduct(); 
	public SanPham getSpecificProduct(int id);
	public List<SanPham> getListProductViaCategory(int id);
	public List<SanPham> getLimitProduct(int startIndex, int maxRow); 
	public void deleteProduct(int id);
	public int addProduct(SanPham sp); 
	public int updateProduct(SanPham sp); 
}
