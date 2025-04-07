package kr.co.ureca.s9validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelephoneValidator implements ConstraintValidator<Telephone, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null) return false;
		
		//null이 아니면 정규식을 반환
		return value.matches("01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$");	
	}
	
	
}
