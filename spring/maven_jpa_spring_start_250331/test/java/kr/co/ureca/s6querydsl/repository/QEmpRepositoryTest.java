package kr.co.ureca.s6querydsl.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.querydsl.core.types.Predicate;

import kr.co.ureca.entity.Emp;
import kr.co.ureca.entity.QEmp;

@SpringBootTest
class QEmpRepositoryTest {

	public static final Logger logger = LoggerFactory.getLogger(QEmpRepositoryTest.class);

	@Autowired
	QEmpRepository qEmpRepository;

	@Test
	void test() {
		QEmp qEmp = QEmp.emp;

		Predicate predicate = qEmp.ename.containsIgnoreCase("L")
										.and( qEmp.sal.between(800, 3000) );

		List<Emp> list = qEmpRepository.findAll(predicate);
//		List<Emp> list = qEmpRepository.findAll(
//											qEmp.ename.containsIgnoreCase("L")
//											.and( qEmp.sal.between(800, 3000) )
//										);

		logger.info("test" + " start ===========================================");
		for (Emp emp : list) {
			logger.info(emp.toString());
		} // for
		logger.info("test" + " end =============================================");
	} // test

} // class
