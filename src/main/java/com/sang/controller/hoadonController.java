package com.sang.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sang.entity.ChiTietHoaDon;
import com.sang.entity.ChiTietHoaDonID;
import com.sang.entity.GioHang;
import com.sang.entity.HoaDon;
import com.sang.service.ChiTietHoaDonService;
import com.sang.service.HoaDonService;

@Controller
@RequestMapping("luuhoadon")
public class hoadonController {
	@Autowired
	HoaDonService hoadonservice; 
	
	@Autowired
	ChiTietHoaDonService chitiethoadonservice; 
	
	
	@PostMapping(produces = "text/plain;charset=UTF-8")
	public String luuHoaDon(HttpSession httpSession, @RequestParam String tenkhachhang, @RequestParam String sodt, @RequestParam String diachigiaohang,@RequestParam String hinhthucgiaohang,@RequestParam String ghichu) {
		
		HoaDon hoadon  = new HoaDon(); 
		hoadon.setTenkhachhang(tenkhachhang);
		hoadon.setSodt(sodt);
		hoadon.setDiachigiaohang(diachigiaohang);
		hoadon.setHinhthucgiaohang(hinhthucgiaohang);
		hoadon.setGhichu(ghichu);
		
		int mahoadon = hoadonservice.saveHoaDon(hoadon);
		
		if(null !=httpSession.getAttribute("danhsachgiohang")) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("danhsachgiohang"); 
			for(GioHang gh: listGioHang) {
				ChiTietHoaDonID chiTietHoaDonID = new ChiTietHoaDonID(); 
				chiTietHoaDonID.setMahoadon(mahoadon);
				chiTietHoaDonID.setMachitietsanpham(gh.getMachitietsanpham());
				
				ChiTietHoaDon chitiethoadon = new ChiTietHoaDon(); 
				chitiethoadon.setChitiethoadonid(chiTietHoaDonID);
				chitiethoadon.setSoluong(gh.getSoluong());
				chitiethoadon.setGiatien(gh.getGiatien());
				
				chitiethoadonservice.saveChiTietHoaDon(chitiethoadon);
			}
			
			
		}
		return "redirect:/"; 
	}
}
