package com.sang.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class SanPhamClone {
	int masanpham; 
	String tensanpham; 
	String giatien; 
	String mota; 
	String hinhsanpham; 
	String gianhcho; 
	

	DanhMucSanPhamClone danhmucsanpham;
	
	Set<ChiTietSanPhamClone> danhsachchitietsanpham = new HashSet<ChiTietSanPhamClone>();

	public int getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhsanpham() {
		return hinhsanpham;
	}

	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}

	public String getGianhcho() {
		return gianhcho;
	}

	public void setGianhcho(String gianhcho) {
		this.gianhcho = gianhcho;
	}

	public DanhMucSanPhamClone getDanhmucsanpham() {
		return danhmucsanpham;
	}

	public void setDanhmucsanpham(DanhMucSanPhamClone danhmucsanpham) {
		this.danhmucsanpham = danhmucsanpham;
	}

	public Set<ChiTietSanPhamClone> getDanhsachchitietsanpham() {
		return danhsachchitietsanpham;
	}

	public void setDanhsachchitietsanpham(Set<ChiTietSanPhamClone> danhsachchitietsanpham) {
		this.danhsachchitietsanpham = danhsachchitietsanpham;
	}  
	
	
}
