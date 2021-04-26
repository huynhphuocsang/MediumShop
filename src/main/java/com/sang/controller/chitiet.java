package com.sang.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sang.entity.ChiTietSanPham;
import com.sang.entity.DanhMucSanPham;
import com.sang.entity.SanPham;
import com.sang.service.DanhMucSanPhamService;
import com.sang.service.SanPhamService;

@Controller
@RequestMapping("chitiet")
public class chitiet {
	@Autowired
	DanhMucSanPhamService danhmucsanphamservice; 
	
	@Autowired
	SanPhamService sanphamservice;
	
	@RequestMapping("/{masanpham}")
	public String chitiet2(@PathVariable int masanpham, ModelMap map, HttpSession httpSession) {
		List<DanhMucSanPham> listDanhMuc = danhmucsanphamservice.getListDanhMucSanPham(); 
		map.addAttribute("listDanhMuc", listDanhMuc); 
		
		SanPham sanpham = sanphamservice.getSpecificProduct(masanpham);
		Set<ChiTietSanPham> chiTietSanPham = sanpham.getDanhsachchitietsanpham(); 
		map.addAttribute("chitietsanpham",chiTietSanPham); 
		map.addAttribute("sanpham", sanpham); 
		
		if(httpSession.getAttribute("numbers") !=null) {
			int soluongsanpham = (Integer) httpSession.getAttribute("numbers"); 
			map.addAttribute("soluongsanpham",soluongsanpham); 
		}
		
		
		return "chitiet"; 
	}
	
	@GetMapping
	public String getChitiet() {
		return "chitiet";
	}
	
}
