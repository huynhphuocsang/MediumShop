package com.sang.daoImp;

public interface NhanVienImp {
	public boolean checkForLogin(String email, String password); 
	public void signUp(String email, String password); 
}
