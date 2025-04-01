package kr.co.ureca.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpDTO {
	
	private Long id;
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private String hiredate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;
}
