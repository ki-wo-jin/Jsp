package com.yedam.app.javabase;

import org.springframework.beans.factory.annotation.Autowired;

public class Restaurant {
	private Chef chef;
	
	@Autowired
	// 생성자 인젝션
	Restaurant(Chef chef){
		this.chef = chef;
	}
	

	
	// 세터 인젝션
	Restaurant(){
		System.out.println("세터 인젝션");
	}
	
	public void setChef(Chef chef) {
		this.chef =chef;
	}
	
	public void run() {
		chef.cooking();
	}
}
