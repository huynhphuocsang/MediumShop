package com.sang.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sang.entity.DanhMucSanPham;
import com.sang.service.DanhMucSanPhamService;

@Controller
@RequestMapping("giohang")
public class giohang {
	@Autowired
	DanhMucSanPhamService danhmucsanphamservice; 
	
	@GetMapping
	public String getGiohang(HttpSession httpSession, ModelMap map) {
		List<DanhMucSanPham> listDanhMuc = danhmucsanphamservice.getListDanhMucSanPham(); 
		map.addAttribute("listDanhMuc", listDanhMuc); 
		
		if(null!=httpSession.getAttribute("numbers")) {
			map.addAttribute("soluongsanpham",httpSession.getAttribute("numbers") );
		}
		if(null != httpSession.getAttribute("danhsachgiohang")) {
			map.addAttribute("danhsachgiohang", httpSession.getAttribute("danhsachgiohang")); 
		}
		return "giohang"; 
	}
}
