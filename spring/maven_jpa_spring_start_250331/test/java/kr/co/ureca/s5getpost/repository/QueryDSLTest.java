package kr.co.ureca.s5getpost.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.co.ureca.entity.Emp;
import kr.co.ureca.entity.QEmp;
import kr.co.ureca.util.PrintUtil;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class QueryDSLTest {

	public static final Logger logger = LoggerFactory.getLogger(QueryDSLTest.class);

	@PersistenceContext
	private EntityManager entityManager;

//	@Test
	void test() {
		JPAQuery<Emp> query = new JPAQuery<>(entityManager);
		QEmp qEmp = QEmp.emp;

		List<Emp> empList = query
							.from(qEmp)
							.where( qEmp.deptno.eq(30)
									.and( qEmp.job.eq("SALESMAN") ) )
							.orderBy(qEmp.sal.asc())
							.fetch();
		PrintUtil.printEmpList(QueryDSLTest.class, "test", empList);
	} // test

//	@Test
	void test2() {
		JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
		QEmp qEmp = QEmp.emp;

		List<Emp> empList = jpaQueryFactory
							.selectFrom(qEmp)
							.where( qEmp.deptno.eq(30)
									.and( qEmp.job.eq("SALESMAN") ) )
							.orderBy(qEmp.sal.asc())
							.fetch();
		PrintUtil.printEmpList(QueryDSLTest.class, "test2", empList);
	} // test2

	@Test
	void test3() {
		JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
		QEmp qEmp = QEmp.emp;

		List<Tuple> list = jpaQueryFactory.select(
								qEmp.empno
								, qEmp.ename
								, qEmp.job
								, qEmp.sal
								, qEmp.deptno
							).from(qEmp)
				.where( qEmp.deptno.eq(30)
						.and( qEmp.job.eq("SALESMAN") ) )
				.orderBy(qEmp.sal.asc())
				.fetch();

		logger.info("test3 start ===========================================");
		for (Tuple tuple : list) {
			logger.info( tuple.get( qEmp.empno ).toString() );
			logger.info( tuple.get( qEmp.ename ).toString() );
			logger.info( tuple.get( qEmp.job ).toString() );
			logger.info( tuple.get( qEmp.sal ).toString() );
			logger.info( tuple.get( qEmp.deptno ).toString() );
			logger.info("");
		} // for
		logger.info("test3 end =============================================");
	} // test3

} // class
