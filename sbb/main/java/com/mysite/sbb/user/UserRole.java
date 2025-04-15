package com.mysite.sbb.user;

import lombok.Getter;

@Getter
public enum UserRole {
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER");			//ADMIN과 USER 상수 생성
	
	private String value;
	
	UserRole(String value){
		this.value = value;
	}
}
