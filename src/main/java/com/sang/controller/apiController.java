package com.sang.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
import com.sang.entity.ChiTietSanPham;
import com.sang.entity.ChiTietSanPhamClone;
import com.sang.entity.DanhMucSanPham;
import com.sang.entity.DanhMucSanPhamClone;
import com.sang.entity.GioHang;
import com.sang.entity.MauSanPham;
import com.sang.entity.SanPham;
import com.sang.entity.SanPhamClone;
import com.sang.entity.SizeSanPham;
import com.sang.service.DanhMucSanPhamService;
import com.sang.service.NhanVienService;
import com.sang.service.SanPhamService;

@Controller
@RequestMapping("api")
@SessionAttributes({ "emailsession", "danhsachgiohang", "numbers" })
public class apiController {

	@Autowired
	NhanVienService nhanvienservice;

	@Autowired
	SanPhamService sanphamservice;
	

	@GetMapping("/checkForLogin")
	@ResponseBody
	public String checkLoginAPI(@RequestParam String email, @RequestParam String password, ModelMap map) {
		boolean checkResult = nhanvienservice.checkForLogin(email, password);
		if (checkResult) {
			map.addAttribute("emailsession", email);
			return "true";
		}
		return "false";
	}

	@GetMapping("/addCart")
	@ResponseBody
	public String addCart(@RequestParam int masanpham, @RequestParam int masize, @RequestParam int mamau,
			@RequestParam int machitietsanpham, @RequestParam int soluong, @RequestParam String giatien,
			@RequestParam String tensanpham, @RequestParam String tenmau, @RequestParam String tensize,
			HttpSession httpSession, ModelMap map) {
		GioHang giohang = new GioHang();
		giohang.setMachitietsanpham(machitietsanpham);
		giohang.setMasanpham(masanpham);
		giohang.setMasize(masize);
		giohang.setMamau(mamau);
		giohang.setSoluong(1);
		giohang.setGiatien(giatien);
		giohang.setTensanpham(tensanpham);
		giohang.setTenmau(tenmau);
		giohang.setTensize(tensize);

		List<GioHang> listGioHang = new ArrayList<GioHang>();
		if (null == httpSession.getAttribute("danhsachgiohang")) {
			listGioHang.add(giohang);

		} else {
			listGioHang = (List<GioHang>) httpSession.getAttribute("danhsachgiohang");
			boolean found = false;
			for (GioHang gh : listGioHang) {
				if (gh.getMasanpham() == masanpham && gh.getMasize() == masize && gh.getMamau() == mamau) {
					gh.setSoluong(gh.getSoluong() + 1);
					found = true;
					break;
				}
			}
			if (found == false) {
				listGioHang.add(giohang);
			}
		}
		map.addAttribute("danhsachgiohang", listGioHang);
		map.addAttribute("numbers", listGioHang.size());

		return String.valueOf(listGioHang.size());
	}

	@GetMapping("/updateCart")
	@ResponseBody
	public void updateCart(@RequestParam int masanpham, @RequestParam int masize, @RequestParam int mamau,
			@RequestParam int soluong, HttpSession httpSession) {
		if (null != httpSession.getAttribute("danhsachgiohang")) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("danhsachgiohang");
			for (GioHang gh : listGioHang) {
				if (gh.getMasanpham() == masanpham && gh.getMasize() == masize && gh.getMamau() == mamau) {
					gh.setSoluong(soluong);
				}
			}
		}
	}

	@GetMapping("/deleteProduct")
	@ResponseBody
	public void deleteProduct(HttpSession httpSession, ModelMap map, @RequestParam int masanpham,
			@RequestParam int masize, @RequestParam int mamau) {
		if (null != httpSession.getAttribute("danhsachgiohang")) {
			List<GioHang> listGioHang = (List<GioHang>) httpSession.getAttribute("danhsachgiohang");
			for (GioHang gh : listGioHang) {

				if (gh.getMasanpham() == masanpham && gh.getMasize() == masize && gh.getMamau() == mamau) {
					listGioHang.remove(gh);
					break;
				}
			}
			map.addAttribute("numbers", listGioHang.size());
		}

	}

	@GetMapping(value="/showProductViaPage", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String showProductViaPage(@RequestParam int pageIndex) {
		int maxRow = 5; 
		String html = ""; 
		List<SanPham> listSanPham = sanphamservice.getLimitProduct((pageIndex-1)*maxRow, maxRow); 
		for(SanPham sp: listSanPham) {
			
			html+="<tr>"; 
			html+="<td><div class='form-check'>"; 
			html+="<input class='form-check-input check-product' type='checkbox' value='' id='flexCheckDefault'> "; 
						
			
			html+="<label class='form-check-label' for='flexCheckDefault'> Chọn </label>";
			html+="</div></td>"; 
			html+="<td>"+sp.getTensanpham()+"</td>"; 
			html+="<td>"+sp.getGiatien()+"</td>"; 
			html+="<td>"+sp.getGianhcho()+"</td>"; 
			html+="<td><button type='button' class='btn btn-warning btn-xoa-san-pham-admin' data-masanpham='"+sp.getMasanpham()+"'>Xóa</button> </td>";
			html+="<td><button type='button' class='btn btn-primary btn-capnhat-san-pham-admin' data-masanpham='"+sp.getMasanpham()+"'>Cập nhật</button></td>";
			html+="</tr>"; 
		}
		
		
		return html; 
	}
	
	
	@PostMapping("/deleteProduct")
	@ResponseBody
	public String deleteProduct(@RequestParam int masanpham) {
		sanphamservice.deleteProduct(masanpham);
		System.out.println("da thuc thi");
		return ""; 
	}
	
	@Autowired
	ServletContext context; 
	
	@PostMapping("/uploadFile")
	@ResponseBody
	public String uploadFile(MultipartHttpServletRequest request) {
		String path = context.getRealPath("/resources/Image/Sanpham/"); 
		
		Iterator<String> listNames = request.getFileNames(); 
		MultipartFile mpf = request.getFile(listNames.next()); 
		
		java.io.File fileUpload = new java.io.File(path + mpf.getOriginalFilename()); 
		try {
			mpf.transferTo(fileUpload);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(path);
		return "true"; 
	}
	
	@PostMapping("/addProduct")
	@ResponseBody
	public String addProduct(@RequestParam String product) {
		ObjectMapper objectMapper = new ObjectMapper(); 
		JsonNode jsonObject; 
		try {
			jsonObject = objectMapper.readTree(product);
			System.out.println(jsonObject);
			SanPham sp = new SanPham(); 
			
			int madanhmucsanpham = jsonObject.get("danhmucsanpham").asInt(); 
			DanhMucSanPham danhmucsanpham = new DanhMucSanPham(); 
			danhmucsanpham.setMadanhmuc(madanhmucsanpham);
			
			String tensanpham = jsonObject.get("tensanpham").asText(); 
			String giatien = jsonObject.get("giatien").asText(); 
			String gianhcho = jsonObject.get("gianhcho").asText(); 
			String mota = jsonObject.get("mota").asText(); 
			
			JsonNode jsonChitiet = jsonObject.get("chitietsanpham"); 
			Set<ChiTietSanPham> setChitietsanpham = new HashSet<ChiTietSanPham>(); 
			
			for(JsonNode chitiet: jsonChitiet) {
				ChiTietSanPham chitietsanpham = new ChiTietSanPham(); 
				
				SizeSanPham sizesanpham = new SizeSanPham(); 
				sizesanpham.setMasize(chitiet.get("sizesanpham").asInt());
				
				MauSanPham mausanpham = new MauSanPham(); 
				mausanpham.setMamau(chitiet.get("mausanpham").asInt());
				
				int soluong = chitiet.get("soluong").asInt(); 
				
				chitietsanpham.setSizesanpham(sizesanpham);
				chitietsanpham.setMausanpham(mausanpham);
				chitietsanpham.setSoluong(soluong);
				
				setChitietsanpham.add(chitietsanpham); 
			}
			
			sp.setDanhmucsanpham(danhmucsanpham);
			sp.setTensanpham(tensanpham);
			sp.setGiatien(giatien);
			sp.setGianhcho(gianhcho);
			sp.setMota(mota);
			sp.setDanhsachchitietsanpham(setChitietsanpham);
			
			int id  = sanphamservice.addProduct(sp); 
			System.out.println(id);
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return ""; 
	}
	
	
	@PostMapping(value="/aboutProduct", produces="application/json")
	@ResponseBody
	public SanPhamClone aboutProduct(@RequestParam int id) {
		SanPham sanpham = sanphamservice.getSpecificProduct(id); 
		SanPhamClone model = new SanPhamClone(); 
		
		DanhMucSanPham danhmucsanpham = sanpham.getDanhmucsanpham(); 
		
		DanhMucSanPhamClone danhmucModel = new DanhMucSanPhamClone(); 
		danhmucModel.setMadanhmuc(danhmucsanpham.getMadanhmuc());
		danhmucModel.setTendanhmuc(danhmucsanpham.getTendanhmuc());
		
		Set<ChiTietSanPham> setChitietsanpham = sanpham.getDanhsachchitietsanpham();
		Set<ChiTietSanPhamClone> setchitietsanphamclone = new HashSet<ChiTietSanPhamClone>(); 
		
		for(ChiTietSanPham chitiet: setChitietsanpham) {
			SizeSanPham size = new SizeSanPham(); 
			MauSanPham mau = new MauSanPham(); 
			
			size.setMasize(chitiet.getSizesanpham().getMasize());
			size.setTensize(chitiet.getSizesanpham().getTensize());
			
			mau.setMamau(chitiet.getMausanpham().getMamau());
			mau.setTenmau(chitiet.getMausanpham().getTenmau());
			
			ChiTietSanPhamClone chitietclone = new ChiTietSanPhamClone(); 
			chitietclone.setMachitietsanpham(chitiet.getMachitietsanpham());
			chitietclone.setMausanpham(mau);
			chitietclone.setSizesanpham(size);
			chitietclone.setSoluong(chitiet.getSoluong());
			
			setchitietsanphamclone.add(chitietclone); 
		}
		
		model.setMasanpham(sanpham.getMasanpham());
		model.setTensanpham(sanpham.getTensanpham());
		model.setDanhmucsanpham(danhmucModel);
		model.setDanhsachchitietsanpham(setchitietsanphamclone);
		model.setGianhcho(sanpham.getGianhcho());
		model.setGiatien(sanpham.getGiatien());
		model.setMasanpham(sanpham.getMasanpham());
		model.setMota(sanpham.getMota());
		System.out.println(model.getTensanpham()+"-"+model.getGiatien());
		return model; 
	}
	
	
	@PostMapping("/updateProduct")
	@ResponseBody
	public void updateProduct(@RequestParam String product) {
		ObjectMapper objectMapper = new ObjectMapper(); 
		JsonNode jsonObject; 
		try {
			jsonObject = objectMapper.readTree(product);
			System.out.println(jsonObject);
			SanPham sp = new SanPham(); 
			
			
			int madanhmucsanpham = jsonObject.get("danhmucsanpham").asInt(); 
			DanhMucSanPham danhmucsanpham = new DanhMucSanPham(); 
			danhmucsanpham.setMadanhmuc(madanhmucsanpham);
			
			int masanpham = jsonObject.get("masanpham").asInt(); 
			String tensanpham = jsonObject.get("tensanpham").asText(); 
			String giatien = jsonObject.get("giatien").asText(); 
			String gianhcho = jsonObject.get("gianhcho").asText(); 
			String mota = jsonObject.get("mota").asText(); 
			
			JsonNode jsonChitiet = jsonObject.get("chitietsanpham"); 
			Set<ChiTietSanPham> setChitietsanpham = new HashSet<ChiTietSanPham>(); 
			
			for(JsonNode chitiet: jsonChitiet) {
				
				ChiTietSanPham chitietsanpham = new ChiTietSanPham(); 
				
				
				SizeSanPham sizesanpham = new SizeSanPham(); 
				sizesanpham.setMasize(chitiet.get("sizesanpham").asInt());
				
				MauSanPham mausanpham = new MauSanPham(); 
				mausanpham.setMamau(chitiet.get("mausanpham").asInt());
				
				int soluong = chitiet.get("soluong").asInt(); 
				chitietsanpham.setMachitietsanpham(chitiet.get("machitietsanpham").asInt());
				chitietsanpham.setSizesanpham(sizesanpham);
				chitietsanpham.setMausanpham(mausanpham);
				chitietsanpham.setSoluong(soluong);
				
				setChitietsanpham.add(chitietsanpham); 
			}

			sp.setMasanpham(masanpham);
			sp.setDanhmucsanpham(danhmucsanpham);
			sp.setTensanpham(tensanpham);
			sp.setGiatien(giatien);
			sp.setGianhcho(gianhcho);
			sp.setMota(mota);
			sp.setDanhsachchitietsanpham(setChitietsanpham);
			System.out.println("kiem tra danh sach chitietsanpham");
			for(ChiTietSanPham chitietsanpham: setChitietsanpham) {
				System.out.println("-"+chitietsanpham.getSoluong());
			}
			
			int result = sanphamservice.updateProduct(sp); 
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
		
}



























