package com.sang.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sang.entity.DanhMucSanPham;
import com.sang.entity.SanPham;
import com.sang.service.DanhMucSanPhamService;
import com.sang.service.SanPhamService;

@Controller
@RequestMapping("sanphamtheodanhmuc")
public class SanPhamTheoDanhMuc {
	
	@Autowired
	SanPhamService sanphamservice; 
	
	@Autowired
	DanhMucSanPhamService danhmucsanphamservice; 
	
	@RequestMapping("/{id}")
	public String getSanPhamTheoDanhMuc(HttpSession httpSession ,@PathVariable int id, ModelMap map) {
		
		List<SanPham> listSanPham = sanphamservice.getListProductViaCategory(id);
		map.addAttribute("listSanPham",listSanPham); 
		
		List<DanhMucSanPham> listDanhMuc = danhmucsanphamservice.getListDanhMucSanPham(); 
		
		map.addAttribute("listDanhMuc", listDanhMuc);
		
		if(httpSession.getAttribute("numbers") !=null) {
			int soluongsanpham = (Integer) httpSession.getAttribute("numbers"); 
			map.addAttribute("soluongsanpham",soluongsanpham); 
		}
		
		return "sanphamtheodanhmuc"; 
	}
}









