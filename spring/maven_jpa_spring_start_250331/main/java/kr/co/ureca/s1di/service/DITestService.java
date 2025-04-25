package kr.co.ureca.s1di.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DITestService {

	public static final Logger logger = LoggerFactory.getLogger(DITestService.class);

	public Map<String, String> diTestPrint() {

		logger.info(">>> diTestPrint <<<");

		HashMap<String, String> map = new HashMap<>();
		map.put("message", "This is DITest...");
		map.put("isSuccess", "true");

		return map;
	} // diTestPrint

} // class
