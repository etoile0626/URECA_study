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

@RestController
@RequestMapping("/validation")
public class ValidationController {

	public static final Logger logger = LoggerFactory.getLogger(ValidationController.class);

	@PostMapping("/valid")
	public ResponseEntity<String> checkValidationByValid(
										@Valid ValidRequestDTO validRequestDTO) {
		logger.info( validRequestDTO.toString() );
		return ResponseEntity.status(HttpStatus.OK)
								.body( validRequestDTO.toString() );
	} // checkValidationByValid

	@PostMapping("/validated")
	public ResponseEntity<String> checkValidation(
										@Validated ValidRequestDTO validRequestDTO) {
		logger.info( validRequestDTO.toString() );
		return ResponseEntity.status(HttpStatus.OK)
								.body( validRequestDTO.toString() );
	} // checkValidation

	@PostMapping("/validated/group1")
	public ResponseEntity<String> checkValidation1(
			@Validated(ValidationGroup1.class) ValidRequestDTO validRequestDTO) {
		logger.info( validRequestDTO.toString() );
		return ResponseEntity.status(HttpStatus.OK)
								.body( validRequestDTO.toString() );
	} // checkValidation1

	@PostMapping("/validated/group2")
	public ResponseEntity<String> checkValidation2(
			@Validated(ValidationGroup2.class) ValidRequestDTO validRequestDTO) {
		logger.info( validRequestDTO.toString() );
		return ResponseEntity.status(HttpStatus.OK)
								.body( validRequestDTO.toString() );
	} // checkValidation2

	@PostMapping("/validated/all-group")
	public ResponseEntity<String> checkValidation3(
			@Validated({ValidationGroup1.class, ValidationGroup2.class})
				ValidRequestDTO validRequestDTO) {
		logger.info( validRequestDTO.toString() );
		return ResponseEntity.status(HttpStatus.OK)
								.body( validRequestDTO.toString() );
	} // checkValidation3

} // class
