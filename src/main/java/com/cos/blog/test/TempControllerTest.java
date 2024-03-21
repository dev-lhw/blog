package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	@GetMapping("/temp/home")
	public String  tempHome() {
		System.out.println("tempHome()");
		
		
		// 파일기본위치 : src/main/resource/static
		// 리턴명 : /home.html
		// 풀경로: src/main/resource/static/home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		
		System.out.println("tempImg()");
		
		return "/al.png";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		System.out.println("tempJsp()");
		
		return "test";
	}

}
