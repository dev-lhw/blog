package com.cos.blog.model;

import java.security.KeyStore.PrivateKeyEntry;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.logging.log4j.message.AsynchronouslyFormattable;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedBy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 패턴
@Entity // 테이블 생성
//@DynamicInsert //Insert 시에 null인 필드를 제외시켜준다.
public class User {
	
	@Id  // 프라이머리 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략ㅇ르 따라간다.
	private int id; //시퀀스, auto_increment
	
	@Column(nullable = false, length = 30)
	private String userName;
	
	@Column(nullable = false, length = 100)  // 비밀번호 해쉬값 저장 
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
//	@ColumnDefault("'user'")
//	private String role; // Enum을 쓰는게 좋음 // admin, user, manager
	// DB는 RoleType 이라는 것이 없음.
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	
	@CreationTimestamp // 시간을 자동으로 등록
	private Timestamp createDate;

}
