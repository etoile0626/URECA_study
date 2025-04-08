package kr.co.ureca.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ureca.dto.MemberDTO;

//서버 2
@RestController
public class RestTemplateTestController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestTemplateTestController.class);
	
	@GetMapping("/api/test1")
	public String s2Test1() {
		
		return "Flature";
	}
	
	@GetMapping("/api/test2/{id}/{pwd}")
	public String s2Test2(@PathVariable String id, @PathVariable String pwd) {
		
		return "Id : " + id + ", Pwd : " + pwd;
	}
	
	@GetMapping("/api/test3")
	public String s2Test3(@RequestParam String id, @RequestParam String pwd) {
		
		return "Test3 Id : " + id + ", Pwd : " + pwd;
	}
	
	@PostMapping("/api/test4")
	public ResponseEntity<MemberDTO> s2Test4(MemberDTO dto) {
		dto.setId(9999);
		return ResponseEntity.status(HttpStatus.OK).body((dto));
	}
	
	@PostMapping("/api/test5")					//헤더도 같이 받기
	public ResponseEntity<MemberDTO> s2Test5(@RequestHeader("my-header") String header
											, @RequestBody MemberDTO dto) {
		logger.info("===========start=============");
		logger.info(header);
		logger.info("============end==============");
		
		dto.setId(8888);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
}
