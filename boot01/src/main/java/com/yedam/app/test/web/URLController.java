package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller // Bean 등록, Web과 관련된 부분
public class URLController {
	//@RequestMapping(path="/test", method=RequestMethod.GET)
	@GetMapping("/test")
	@ResponseBody
	public String urlGetTest(String keyword) {
		return "Server Response : Get Method\n Select - " + keyword;
	}
	
	
	//@RequestMapping(path="/test", method=RequestMethod.POST)
	@PostMapping("/test")
	@ResponseBody
	public String urlPostTest(String keyword) {
		return "Server Response : Post Method\n Select - " + keyword;
	}
}
