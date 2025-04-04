package kr.co.ureca.s6querydsl.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.ureca.entity.Emp;

@SpringBootTest
class EmpCustomRepositoryTest {

	public static final Logger logger = LoggerFactory.getLogger(EmpCustomRepositoryTest.class);

	@Autowired
	private EmpCustomRepository empCustomRepository;

	@Test
	void test() {

		List<Emp> list = empCustomRepository.empByDeptno(30);

		logger.info("test start ===========================================");
		for (Emp emp : list) {
			logger.info( emp.toString() );
		} // for
		logger.info("test end =============================================");

	} // test

} // test
