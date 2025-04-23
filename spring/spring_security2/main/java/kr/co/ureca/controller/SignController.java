package kr.co.ureca.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import kr.co.ureca.dto.SignInResultDto;
import kr.co.ureca.dto.SignUpResultDto;
import kr.co.ureca.service.SignService;
import kr.co.ureca.service.SignServiceImpl;

@RestController
@RequestMapping("/sign-api")
public class SignController {

	private final SignService signService;

	public SignController(SignService signService) {
		this.signService = signService;
	}

	@PostMapping("/sign-up")
	public SignUpResultDto signUp(
			@Parameter(description = "아이디", required = true) @RequestParam String id,
			@Parameter(description = "패스워드", required = true) @RequestParam String password,
			@Parameter(description = "이름", required = true) @RequestParam String name,
			@Parameter(description = "역할", required = true) @RequestParam String role ) {

		SignUpResultDto signUpResultDto = signService.signUp(id, password, name, role);

		System.out.println("SignController - signUp - dto : " + signUpResultDto);

		return signUpResultDto;
	} // signUp

	@PostMapping("/sign-in")
	public SignUpResultDto signIn(
			@Parameter(description = "아이디", required = true) @RequestParam String id,
			@Parameter(description = "패스워드", required = true) @RequestParam String password ) {

		SignInResultDto signInResultDto = signService.signIn(id, password);

		System.out.println("SignController - signIn - dto : " + signInResultDto);

		return signInResultDto;
	} // signIn

} // class
