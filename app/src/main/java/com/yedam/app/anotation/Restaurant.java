package com.yedam.app.anotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 빈으로 등록하겠다고 선언
public class Restaurant {
	private Chef chef;
	
	
	 // 생성자 인젝션
	Restaurant(Chef chef){
		this.chef = chef;
	}
	
	// 세터 인젝션
	Restaurant(){
		System.out.println("세터 인젝션");
	}
	
	@Autowired
	public void setChef(Chef chef) {
		this.chef =chef;
	}
	
	public void run() {
		chef.cooking();
	}
}
