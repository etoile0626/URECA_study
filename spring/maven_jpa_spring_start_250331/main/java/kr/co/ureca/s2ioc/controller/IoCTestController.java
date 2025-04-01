package kr.co.ureca.s2ioc.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ureca.s2ioc.service.BallPenService;
import kr.co.ureca.s2ioc.service.PenService;

@Controller
public class IoCTestController {
	
	public static final Logger logger = LoggerFactory.getLogger(IoCTestController.class);
	
	@Autowired
	private PenService service;
	
	@GetMapping("/ioctest")
	@ResponseBody
	public Map<String, String> iocTest(){
		Map<String, String> map = service.write();	// 위에서 penservice 를 선언해서 아마 penservice 메소드 결과를 가져올듯
		
		logger.info(">>>iocTest<<<");
		
		return map;
	}
}
