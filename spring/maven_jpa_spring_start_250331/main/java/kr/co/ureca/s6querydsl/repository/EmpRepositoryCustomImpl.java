package kr.co.ureca.s6querydsl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import kr.co.ureca.entity.Emp;
import kr.co.ureca.entity.QEmp;

@Component
public class EmpRepositoryCustomImpl
				extends QuerydslRepositorySupport
				implements EmpRepositoryCustom {

	public EmpRepositoryCustomImpl() {
		super(Emp.class);
	}

	@Override
	public List<Emp> empByDeptno(Integer deptno) {
		QEmp qEmp = QEmp.emp;

		List<Emp> list = from(qEmp)
							.where( qEmp.deptno.eq(deptno) )
							.select(qEmp)
							.fetch();
		return list;
	} // empByDeptno

} // class
