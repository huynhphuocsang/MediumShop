package com.sang.controller;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		String emailPattern = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$"; 
		System.out.print("Nhap vao dia chi email: ");
		Scanner sc = new Scanner(System.in); 
		String email = sc.nextLine(); 
		if(email.matches(emailPattern)) {
			System.out.println("Dung");
		}else {
			System.out.println("sai!");
		}
	}
}
