package kr.co.ureca.s2ioc.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ureca.s2ioc.service.PenService;

@Controller
public class IOCTestController {

	public static final Logger logger = LoggerFactory.getLogger(IOCTestController.class);

	@Autowired
	private PenService service;

	@GetMapping("/ioctest")
	@ResponseBody
	public Map<String, String> iocTest() {

		logger.info(">>> iocTest <<<");

		Map<String, String> map = service.write();

		return map;
	} // iocTest

} // class
