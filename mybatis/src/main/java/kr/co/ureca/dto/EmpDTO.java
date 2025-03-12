package kr.co.ureca.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString  //EmpDTO 안에 get set tostring 메소드가 있는 것처럼 만들어줌
public class EmpDTO {
	
	private String empno;
	private String ename;
	private String job;
	private String mgr;
	private String hiredate;
	private String sal;		//숫자도 문자열로 받아오기 가능
	private String comm;
	private String deptno; 
	
}
