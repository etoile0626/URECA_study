package kr.co.ureca.s5getpost.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import kr.co.ureca.dto.EmpDTO2;
import kr.co.ureca.entity.QEmp;
import kr.co.ureca.util.PrintUtil;

@SpringBootTest
class QueryDSLTest2 {

	public static final Logger logger = LoggerFactory.getLogger(QueryDSLTest2.class);

	@Autowired
	JPAQueryFactory jpaQueryFactory;

	@Test
	void test4() {
		QEmp qEmp = QEmp.emp;

		List<EmpDTO2> list = jpaQueryFactory.select(
								Projections.constructor(
									EmpDTO2.class
									, qEmp.empno
									, qEmp.ename
									, qEmp.job
									, qEmp.sal
									, qEmp.deptno)
							).from(qEmp)
				.where( qEmp.deptno.eq(30)
						.and( qEmp.job.eq("SALESMAN") ) )
				.orderBy(qEmp.sal.asc())
				.fetch();

		PrintUtil.printEmpDTO2List(QueryDSLTest2.class, "test3", list);
	} // test4

} // class
