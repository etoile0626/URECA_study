package kr.co.ureca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "emp")
@Entity
@Getter
@Setter
@ToString
public class Emp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private Integer empno;
	
	@Column
	private String ename;
	
	@Column
	private String job;
	
	@Column
	private Integer mgr;
	
	@Column
	private String hiredate;
	
	@Column
	private Integer sal;
	
	@Column
	private Integer comm;
	
	@Column
	private Integer deptno;
}
