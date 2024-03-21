package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.blog.model.User;

// 자동으로 bean등록이 됨. 
//@Reposytory 생략가능함
public interface UserRepository extends JpaRepository<User, Integer>  {

}
