package kr.co.ureca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ureca.dto.MemberDTO;
import kr.co.ureca.service.RestTemplateService;
import kr.co.ureca.service.WebClientService;

//서버1
@RestController
public class RestTemplateController {
	
	@Autowired
	private RestTemplateService service;
	
	@Autowired
	private WebClientService webClientService;
	
	@GetMapping("/test1")
	public String s1test1(){
		//return service.s1Test1();
		return webClientService.s1Test1();
	}
	
	@GetMapping("/test2/{id}/{pwd}")
	public String s1test2(@PathVariable String id, @PathVariable String pwd){
		//return service.s1Test2(id, pwd);
		return webClientService.s1Test2(id, pwd);
	}
	
	@GetMapping("/test3/{id}/{pwd}")
	public String s1test3(@PathVariable String id, @PathVariable String pwd){
		//return service.s1Test3(id, pwd);
		return webClientService.s1Test3(id, pwd);
	}
	
	
	@PostMapping("/test4")
	public MemberDTO s1test4(MemberDTO dto){
		//return service.s1Test4(dto).getBody();
		return webClientService.s1Test4(dto).getBody();
	}
	
	@PostMapping("/test5")
	public MemberDTO s1test5(MemberDTO dto){
		//return service.s1Test5(dto).getBody();
		return webClientService.s1Test5(dto).getBody();
	}
}
