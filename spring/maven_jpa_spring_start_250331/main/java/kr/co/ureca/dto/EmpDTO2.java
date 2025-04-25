package kr.co.ureca.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Data // @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
public class EmpDTO2 {

	private Long id;
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private String hiredate;
	private Integer sal;
	private Integer comm;
	private Integer deptno;

	@QueryProjection
	public EmpDTO2(Integer empno, String ename, String job, Integer sal, Integer deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.deptno = deptno;
	} // @QueryProjection

} // class
