package kr.co.ureca.s5getpost.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import kr.co.ureca.entity.Emp;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class JPQLTest {

	public static final Logger logger = LoggerFactory.getLogger(JPQLTest.class);

	@Autowired
	private EmpRepository repository;

//	@Test
	void test() {

		List<Emp> list = repository.findByDeptno( Integer.valueOf(40) );
		logger.info("test start ===========================================");
		for (Emp emp : list) {
			logger.info( emp.toString() );
		} // for
		logger.info("test end =============================================");

	} // test

//	@Test
	void test2() {
		boolean existsEmpno = repository.existsByEmpno( 3333 ); // false

		logger.info("test2 start ===========================================");
		logger.info("existsEmpno : " + existsEmpno);
		logger.info("test2 end =============================================");

		assertThat(existsEmpno).isEqualTo(true);
	} // test2

//	@Test
	void test3() {
		int countDeptno = repository.countByDeptno(40);

		logger.info("test3 start ===========================================");
		logger.info("countDeptno : " + countDeptno);
		logger.info("test3 end =============================================");

		assertThat(countDeptno).isEqualTo(9);
	} // test3

//	@Test
	void test4() {
		int deleteEmpno = repository.deleteByEmpno(1111);

		logger.info("test4 start ===========================================");
		logger.info("deleteEmpno : " + deleteEmpno);
		logger.info("test4 end =============================================");

		assertThat(deleteEmpno).isEqualTo(1);
	} // test4

//	@Test
	void test5() {
		List<Emp> list = repository.findTop3ByDeptno(30);

		logger.info("test5 start ===========================================");
		for (Emp emp : list) {
			logger.info(emp.toString());
		} // for
		logger.info("test5 end =============================================");
	} // test5

//	@Test
	void test6() {
		List<Emp> list1 = repository.findBySalLessThan(3000);
		List<Emp> list2 = repository.findBySalGreaterThanEqual(3000);
		List<Emp> list3 = repository.findBySalBetween(800, 1600);

		logger.info("test6 start ===========================================");
		for (Emp emp : list1) {
			logger.info(emp.toString());
		} // for
		logger.info("test6 ing =============================================");
		for (Emp emp : list2) {
			logger.info(emp.toString());
		} // for
		logger.info("test6 ing =============================================");
		for (Emp emp : list3) {
			logger.info(emp.toString());
		} // for
		logger.info("test6 end =============================================");
	} // test6

//	@Test
	void test7() {
		List<Emp> list = repository.findByEnameLike("%L%");
		List<Emp> list2 = repository.findByEnameLikeOrderByDeptnoDesc("%L%");
		List<Emp> list3 = repository.findByEnameLikeOrderByDeptnoDescJobAsc("%L%");

		logger.info("test7 start ===========================================");
		for (Emp emp : list) {
			logger.info(emp.toString());
		} // for
		logger.info("test7 ing =============================================");
		for (Emp emp : list2) {
			logger.info(emp.toString());
		} // for
		logger.info("test7 ing =============================================");
		for (Emp emp : list3) {
			logger.info(emp.toString());
		} // for
		logger.info("test7 end =============================================");
	} // test7

//	@Test
	void test8() {
		List<Emp> list = repository.findByEnameLike( "%L%", Sort.by( Order.desc("deptno"), Order.asc("job") ) );

		logger.info("test8 start ===========================================");
		for (Emp emp : list) {
			logger.info(emp.toString());
		} // for
		logger.info("test8 end =============================================");
	} // test8

//	@Test
	void test9() {
//		Page<Emp> list = repository.findBySalLessThanOrderByIdAsc( 3000, PageRequest.of(0, 5) );
//		Page<Emp> list = repository.findBySalLessThanOrderByIdAsc( 3000, PageRequest.of(1, 5) );
		Page<Emp> list = repository.findBySalLessThanOrderByIdAsc( 3000, PageRequest.of(2, 5) );

		logger.info("test9 start ===========================================");
		for (Emp emp : list) {
			logger.info(emp.toString());
		} // for
		logger.info("test9 end =============================================");
	} // test9

//	@Test
	void test10() {
		List<Emp> list = repository.findByDeptnoAndJob( 30, "SALESMAN" );
		List<Emp> list2 = repository.findByDeptnoOrJob( 30, "MANAGER" );

		logger.info("test10 start ===========================================");
		for (Emp emp : list) {
			logger.info(emp.toString());
		} // for
		logger.info("test10 ing =============================================");
		for (Emp emp : list2) {
			logger.info(emp.toString());
		} // for
		logger.info("test10 end =============================================");
	} // test10

	@Test
	void test11() {
		Emp emp1 = repository.findByEnameQuery("SMITH");
		Emp emp2 = repository.findByEnameQueryParam("ALLEN");
		List<Object[]> emp3 = repository.findByEnameQueryParamObj("BLAKE");

		logger.info("test11 start ===========================================");
		logger.info(emp1.toString());
		logger.info("test11 ing =============================================");
		logger.info(emp2.toString());
		logger.info("test11 ing =============================================");
		logger.info( emp3.get(0)[0].toString() );
		logger.info( emp3.get(0)[1].toString() );
		logger.info( emp3.get(0)[2].toString() );
		logger.info( emp3.get(0)[3].toString() );
		logger.info( emp3.get(0)[4].toString() );
		logger.info("test11 end =============================================");
	} // test11

} // class
