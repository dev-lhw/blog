package com.cos.blog.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	@Autowired // 의존성 주입(DI)
	private UserRepository userRepository;
	  
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
//		User user = userRepository.findById(id).get();

//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				return new User();
//			}
//		})
		
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>()  {// .orElseThrow(new Supplier<IllegalArgumentException> {
			@Override
			public IllegalArgumentException get(){
				return new IllegalArgumentException("해당 사용자가 없습니다.");
			}
		
		});
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ss";});
		
		return user;
	}
	
	
	// "http://localhost:8080/blog/dumu/join(요청)"
	// http의 body에 userName, password, email 데이를 가지고 (요청)
	@PostMapping("/dummy/join")
	//public String  join(String userName, String password, String email) {
	public String  join(User user) {
		System.out.println("id : " + user.getId());
		System.out.println("userName : " + user.getUserName());
		System.out.println("password : " + user.getPassword());
		System.out.println("email : " + user.getEmail());
		System.out.println("role : " + user.getRole());
		System.out.println("createDate : " + user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);

		return "회원가입이  완료되었습니다.";		
	}

}
