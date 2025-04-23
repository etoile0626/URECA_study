package kr.co.ureca.service;

import kr.co.ureca.dto.SignInResultDto;
import kr.co.ureca.dto.SignUpResultDto;


public interface SignService {
	
	public SignUpResultDto signUp(String id, String password, String name, String role);
	
	public SignInResultDto signIn(String id, String password);
	
}
