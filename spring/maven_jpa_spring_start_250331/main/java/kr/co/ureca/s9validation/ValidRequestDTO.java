package kr.co.ureca.s9validation;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ValidRequestDTO {
	
	@NotBlank
	String name;
	
	@Email
	String email;
	
	//@Pattern(regexp = "01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$")	//regexp = 정규표현식
	@Telephone		//이렇게 내가 만든 어노테이션 사용 가능
	String phoneNumber;
	
	@Min(value = 20, groups = ValidationGroup1.class) 	//ValidationGroup1일때만 검사
	@Max(value = 40, groups = ValidationGroup1.class) 	//ValidationGroup2일때만 검사
	int age;
	
	@Size(min = 0, max = 40)	//길이 지정
	String description;
	
	@Positive(groups = ValidationGroup2.class)	//양수만
	int count;
	
	@AssertTrue					//true인지 체크, null은 확인 안함
	boolean booleanCheck;
	
}
