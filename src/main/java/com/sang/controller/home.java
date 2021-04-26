package com.sang.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.sang.entity.DanhMucSanPham;
import com.sang.entity.SanPham;
import com.sang.service.DanhMucSanPhamService;
import com.sang.service.SanPhamService;



@Controller
@RequestMapping("/")
public class home {
	@Autowired
	SessionFactory sessionFactory; 
	
	@Autowired
	SanPhamService sanphamservice; 
	
	@Autowired
	DanhMucSanPhamService danhmucsanphamservice; 
	
	@GetMapping
	@Transactional
	public String home(HttpSession session,  ModelMap map) {
		
		if(session.getAttribute("emailsession") !=null) {
			map.addAttribute("emailsession", session.getAttribute("emailsession")); 
		}
		if(session.getAttribute("numbers")!=null) {
			map.addAttribute("soluongsanpham", session.getAttribute("numbers")); 
		}
		List<SanPham> listProduct = sanphamservice.getListProduct();
		
		List<DanhMucSanPham> listDanhMuc = danhmucsanphamservice.getListDanhMucSanPham();
		
		map.addAttribute("listDanhMuc", listDanhMuc); 
		map.addAttribute("listProduct", listProduct); 
		return "trangchu"; 
	}
	
	
}
