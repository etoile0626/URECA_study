package kr.co.ureca.s9validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

@Target(ElementType.FIELD) //변수
@Retention(RetentionPolicy.RUNTIME)	//효력범위, 런타임에 살아있음
@Constraint(validatedBy = TelephoneValidator.class)		//어떤 걸 기준으로 유효성을 검사할지?
public @interface Telephone {
	String message() default "전화번호 형식이 일치하지 않습니다.";	//오류시 띄울 메세지
	Class[] groups() default {};		//지정이 필요할 그룹들 지정
	Class[] payload() default {};		//클라이언트에게 보낼 내용
}
