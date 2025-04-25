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

@RestControllerAdvice // @RestController 방식으로 결과 값을 return + AOP advice 개념 
public class CustomExceptionHandler {

	public static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(value = IDNotFoundException.class)
	public ResponseEntity< Map<String,String> > handleIDNotFound(IDNotFoundException e, HttpServletRequest req) {

		logger.error( "advice - handleIDNotFound, {}, {}", req.getRequestURI(), e.getMessage() );

		HttpStatus httpStatus = HttpStatus.FORBIDDEN;

		Map<String,String> map = new HashMap<>();
		map.put( "error type", httpStatus.getReasonPhrase() );
		map.put( "code", "403" );
		map.put( "message", e.getMessage() );

		return new ResponseEntity<>( map, new HttpHeaders(), httpStatus);
	} // handleIDNotFound

	@ExceptionHandler(value = RuntimeException.class) // exception 처리
	public ResponseEntity< Map<String,String> > handleException( RuntimeException e, HttpServletRequest request) {

		HttpHeaders responseHeaders = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

		logger.error( "advice - handleException, {}, {}", request.getRequestURI(), e.getMessage() );

		Map<String,String> map = new HashMap<>();
		map.put( "error type",  httpStatus.getReasonPhrase() );
		map.put( "code", "400" );
		map.put( "message", e.getMessage() );

		return new ResponseEntity<>( map, responseHeaders, httpStatus );
	} // handleException

} // class
