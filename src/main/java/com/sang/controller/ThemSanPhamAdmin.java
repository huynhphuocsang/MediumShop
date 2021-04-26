package com.sang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sang.entity.DanhMucSanPham;
import com.sang.entity.MauSanPham;
import com.sang.entity.SanPham;
import com.sang.entity.SizeSanPham;
import com.sang.service.DanhMucSanPhamService;
import com.sang.service.MauSanPhamService;
import com.sang.service.SanPhamService;
import com.sang.service.SizeSanPhamService;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamAdmin {

	@Autowired
	SanPhamService sanphamservice; 

	@Autowired
	DanhMucSanPhamService danhmucsanphamservice; 
	
	@Autowired
	MauSanPhamService mausanphamservice; 
	
	@Autowired
	SizeSanPhamService sizesanphamservice; 
	
	
	@GetMapping
	public String getThemSanPham(ModelMap map) {
		int startIndex = 0; 
		int maxRow = 5; 
		List<SanPham> listSanPham = sanphamservice.getLimitProduct(startIndex,maxRow); 
		List<SanPham> allSanPham = sanphamservice.getListProduct(); 
		
		
		map.addAttribute("listSanPham", listSanPham); 
		int pageNumbers = allSanPham.size() % maxRow; 
		if(pageNumbers==0) {
			map.addAttribute("sotrang", allSanPham.size()/maxRow); 
		}
		else map.addAttribute("sotrang",allSanPham.size()/maxRow+1); 
		
		List<DanhMucSanPham> listdanhmucsanpham = danhmucsanphamservice.getListDanhMucSanPham(); 
		map.addAttribute("listdanhmucsanpham",listdanhmucsanpham); 
		map.addAttribute("allSanPham",allSanPham); 
		
		List<MauSanPham> listMauSanPham = mausanphamservice.getAllMauSanPham(); 
		map.addAttribute("listMauSanPham", listMauSanPham);
		
		List<SizeSanPham> listSizeSanPham = sizesanphamservice.getAllSizeSanPham(); 
		map.addAttribute("listSizeSanPham", listSizeSanPham); 
		
		return "themsanpham"; 
	}
	
}
