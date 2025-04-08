package kr.co.ureca.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	
	private Integer id;
	
	private String name;
	
	private String email;

	private String organization;
}
