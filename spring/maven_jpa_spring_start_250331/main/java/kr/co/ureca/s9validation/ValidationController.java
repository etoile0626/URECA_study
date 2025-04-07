package kr.co.ureca.s9validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController		//화면생산 안하겠다
@RequestMapping("/validation")
public class ValidationController {
	
	public static final Logger logger = LoggerFactory.getLogger(ValidationController.class);
	
	@PostMapping("/validation")
	public ResponseEntity<String> checkValidationByValid(
											@Valid ValidRequestDTO validRequestDTO){
		
		logger.info(validRequestDTO.toString());
		return ResponseEntity.status(HttpStatus.OK)
								.body(validRequestDTO.toString());
	}
	
	@PostMapping("/validated")
	public ResponseEntity<String> checkValidation(
											@Validated ValidRequestDTO validRequestDTO){
		
		logger.info(validRequestDTO.toString());
		return ResponseEntity.status(HttpStatus.OK)
								.body(validRequestDTO.toString());
	}
	
	@PostMapping("/validated/group1")
	public ResponseEntity<String> checkValidation1(	//Group1만 체크
							@Validated(ValidationGroup1.class) ValidRequestDTO validRequestDTO){
		
		logger.info(validRequestDTO.toString());
		return ResponseEntity.status(HttpStatus.OK)
								.body(validRequestDTO.toString());
	}
	
	@PostMapping("/validated/group2")
	public ResponseEntity<String> checkValidation2(	//Group2만 체크
							@Validated(ValidationGroup2.class) ValidRequestDTO validRequestDTO){
		
		logger.info(validRequestDTO.toString());
		return ResponseEntity.status(HttpStatus.OK)
								.body(validRequestDTO.toString());
	}
	
	@PostMapping("/validated/groupall")
	public ResponseEntity<String> checkValidation3(	//Group1, 2모두 체크, 여러개 넣을때는 배열 형태(중괄호)로
		@Validated({ValidationGroup1.class, ValidationGroup2.class}) ValidRequestDTO validRequestDTO){
		
		logger.info(validRequestDTO.toString());
		return ResponseEntity.status(HttpStatus.OK)
								.body(validRequestDTO.toString());
	}
}
