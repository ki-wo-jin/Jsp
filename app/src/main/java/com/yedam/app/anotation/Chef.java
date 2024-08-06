package com.yedam.app.anotation;

import org.springframework.stereotype.Component;

@Component
public class Chef {
	public void cooking() {
		System.out.println("Spring 어노테이션 방식");
	}

}
