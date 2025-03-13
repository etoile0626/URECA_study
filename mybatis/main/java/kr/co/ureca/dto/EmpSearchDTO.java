package kr.co.ureca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor		//모든 파라미터가 들어가는 생성자					생성자도 만들어줌 ㄷㄷ
@NoArgsConstructor		//기본 생성자 <-위 생성자 만들면 얘도 필수로
public class EmpSearchDTO {
	
	private String ename;
	private String job;
	private String deptno; 
	
}
