package com.sang.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="sizesanpham")
public class SizeSanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int masize; 
	String tensize;
	public int getMasize() {
		return masize;
	}
	public void setMasize(int masize) {
		this.masize = masize;
	}
	public String getTensize() {
		return tensize;
	}
	public void setTensize(String tensize) {
		this.tensize = tensize;
	} 
	
}
