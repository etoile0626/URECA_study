package kr.co.ureca.s10exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ExceptionController {

	public static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	@GetMapping("/exception/custom")
	public void throwCustomException(String id) throws IDNotFoundException {
		throw new IDNotFoundException(id);
	} // getRunTimeException

	@GetMapping("/exception")
	public void getRunTimeException() {
		throw new RuntimeException("getRunTimeException 메소드 호출");
	} // getRunTimeException

	@ExceptionHandler(value = RuntimeException.class) // exception 처리
	public ResponseEntity< Map<String,String> > handleException( RuntimeException e, HttpServletRequest request) {

		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

		logger.error( "controller - handleException, {}, {}", request.getRequestURI(), e.getMessage() );

		Map<String,String> map = new HashMap<>();
		map.put( "error type",  httpStatus.getReasonPhrase() );
		map.put( "code", "400" );
		map.put( "message", e.getMessage() );

		return new ResponseEntity<>( map, responseHeaders, httpStatus );
	} // handleException

} // class
