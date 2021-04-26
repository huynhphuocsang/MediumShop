package com.sang.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sang.entity.Nhanvien;
import com.sang.service.NhanVienService;



@Controller
@RequestMapping("login")
public class dangnhap {
	
	@Autowired
	NhanVienService nhanvienService; 
	
	@GetMapping
	public String getLogin() {
		
		return "login"; 
	}
	
	@PostMapping
	public String getSignUp(@RequestParam String email, @RequestParam String password, @RequestParam String checkPassword,ModelMap map) {
		
		map.addAttribute("signup", 1); 
		String emailPattern = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
		String passwordPattern = "[1-9a-zA-Z]{6,}";
		if(!email.matches(emailPattern)) {
			 
			String error = "Vui lòng nhập đúng định dạng email!"; 
			map.addAttribute("errorEmail", error);
			
			return "login";
		}
		
		else if(!password.matches(passwordPattern)) {
			
			String error = "Mật khẩu tối thiểu 6 kí tự và không chứa kí tự đặc biệt!";
			map.addAttribute("errorPassword", error); 
			
			return "login";
		}
		else if(!checkPassword.equals(password)) {
			
			String error = "Mật không nhập lại không trùng khớp!";
			map.addAttribute("errorCheckPassword", error);
			
			return "login"; 
		}
		else {
			
			nhanvienService.signUp(email, password);
			map.addAttribute("success", "Đăng kí thành công!"); 
			
		}
		return "login"; 
	}
	
}





















