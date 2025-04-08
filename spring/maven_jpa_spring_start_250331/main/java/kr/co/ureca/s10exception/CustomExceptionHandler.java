package kr.co.ureca.s10exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice		//advice -> AOP 개념, 끼어드는 프로그램 조각을 의미함
public class CustomExceptionHandler {
	
	public static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@ExceptionHandler(value = IDNotFoundException.class)
	public ResponseEntity< Map<String, String> > handleIDNotFound(IDNotFoundException e, HttpServletRequest req){
		
		HttpStatus httpStatus = HttpStatus.FORBIDDEN;	//403 코드, 정상적인 req지만 서비스하지 않음
		
		logger.error("advice - handleIDNotFound, {}, {}", req.getRequestURI(), e.getMessage());
		
		Map<String, String> map = new HashMap<>();
		
		map.put("error type", httpStatus.getReasonPhrase());
		map.put("code", "403");
		map.put("message", e.getMessage());
		
		return new ResponseEntity<>(map, new HttpHeaders(), httpStatus);
	}
	
	
	@ExceptionHandler(value = RuntimeException.class)	//exception 처리
	public ResponseEntity< Map<String, String> > handleException( RuntimeException e, HttpServletRequest request) {
		
		HttpHeaders responseheaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;	//400
		
		
		logger.error("advice - handleException, {}, {}", request.getRequestURI(), e.getMessage());
		
		Map<String, String> map = new HashMap<>();
		map.put("error type", httpStatus.getReasonPhrase());
		map.put("code", "400");
		map.put("message", e.getMessage());
		
		//@RestController 방식으로, 즉 json 방식으로 결과값 리턴 + AOP service 개념
		return new ResponseEntity<>(map, responseheaders, httpStatus);
	}
	
}
