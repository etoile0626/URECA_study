package kr.co.ureca.s1di.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ureca.s1di.service.DITestService;

@Controller
public class DITestController {
	
	
	//private DITestService service = new DITestService(); //개발자가 제어하던 방식-이제 안씀
	//3. 필드 선언에 의한 의존성 주입 = 얘도 @Autowired 사용, 이게 효율 제일 좋음
	@Autowired
	private DITestService service;			//이젠 스프링 프레임워크가 생성 및 제공->이게 Dependancy Injection
	
	//DI 방법 3가지
	//1. 생성자에 의한 의존성 주입 = 생성자 실행시 DITestService 필요 -> 이걸 스프링 프레임워크가 해결(생성 및 제공)
	/*
	public DITestController(DITestService service) {
		this.service = service;
	}
	*/
	
	//2. setter를 통한 의존성 주입 = @Autowired 사용
	/*
	@Autowired	//이걸 실행할때 연결되어야함을 표시한 어노테이션, 프레임워크가 먼저 실행해서 필요한 부분을 완성 시켜줌
	public void setService(DITestService service) {
		this.service = service;
	}
	*/
	
	@GetMapping("/ditest")
	@ResponseBody //얘는 리턴 값이 화면이 아니고 객체입니다 라는 뜻(response가 html의 body다)
	public Map<String, String> diTest() {
		Map<String, String> map = service.diTestPrint();//우리는 서비스객체를 선언만하고 생성한 적없는데 스프링 프레임워크가 알아서 만들어줬음
		return map;
	}
	
}
