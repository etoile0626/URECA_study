package kr.co.ureca.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

} // class














