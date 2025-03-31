package kr.co.ureca.s1di.service;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;		//무조건 이 logger 사용

@Service
public class DITestService {

	public static final Logger logger = LoggerFactory.getLogger(DITestService.class);
	
	public Map<String, String> diTestPrint(){
		
		logger.info(">>>diTestPrint<<<");
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "This is DITest...");
		map.put("isSuccess", "true");
		
		return map;
	}
}
