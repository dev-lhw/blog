package com.cos.blog.test;

import javax.swing.text.html.HTML.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	
	@GetMapping("/http/lombok")
	public String lombik() {
		
		Member m = Member.builder().userName("ssar").password("1234").email("hwlee@naver.com").build();
		System.out.println("Tag getter : " + m.getId());
		m.setId(5000);
		System.out.println("Tag getter : " + m.getId());
		return "lombok test 완료";
	}
	
	@GetMapping("/http/get")
	public String getTest() {
		return "get요청 : "; // + m.toString(); 
	}
	
	@PostMapping("/http/post")
	public String getPost(@RequestBody Member  m) {
		return "post요청 : " + m.toString(); 
	}
	
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put요청 : " + m.toString(); 
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest(@RequestBody Member m) {
		return "delete요청 : " + m.toString(); 
	}
	

}
