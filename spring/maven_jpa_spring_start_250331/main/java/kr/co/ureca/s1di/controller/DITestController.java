package kr.co.ureca.s1di.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ureca.s1di.service.DITestService;

@Controller
public class DITestController {

	public static final Logger logger = LoggerFactory.getLogger(DITestController.class);

//	private DITestService service = new DITestService(); // 개발자가 제어. -> Bye~~~

	// 3번 방법. 필드 선언에 의한 의존성 주입(DI).
	@Autowired
	private DITestService service; // 스프링 프레임워크가 생성 및 제공. Dependancy Injection.

	// 1번 방법. 생성자에 의한 의존성 주입(DI).
	// 생성자 실행 시, DITestService 필요. -> 스프링 프레임워크가 생성 및 제공.
	// 스프링 공식 권장 : 의존 객체(DITestService) 없이 생성(DITestController) 불가 이유.
//	public DITestController(DITestService service) {
//		this.service = service;
//	}

	// 2번 방법. setter 메소드를 사용한 의존성 주입(DI).
//	@Autowired
//	public void setService(DITestService service) {
//		this.service = service;
//	} // serService

	@GetMapping("/ditest")
	@ResponseBody
	public Map<String, String> diTest() {
		Map<String, String> map = service.diTestPrint();
		return map;
	} // diTest

} // class
