package kr.co.ureca.s5getpost.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import kr.co.ureca.entity.Emp;

// @SpringBootTest or @DataJpaTest + @AutoConfigureTestDatabase(replace = Replace.NONE)
// Replace.ANY : embeded DBMS (h2) / Replace.NONE : 기존 DBMS 사용
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class EmpRepositoryTest {

	public static final Logger logger = LoggerFactory.getLogger(EmpRepositoryTest.class);

	@Autowired
	private EmpRepository repository;

//	@Test
	void test() {

		// 개념적 given
		Emp emp = new Emp(null, 6666, "GGC", "General", 9999
							, "2020-03-01", 3600, 1200, 40, null, null);

		// 개념적 when
		Emp savedEmp = repository.save(emp);

		// 개념적 then
		assertEquals( emp.getEmpno(), savedEmp.getEmpno() );
		assertEquals( emp.getEname(), savedEmp.getEname() );

		logger.info("test start ======================");
		logger.info("emp : " + emp.toString());
		logger.info("savedEmp : " + savedEmp.toString());
		logger.info("test end =========================");

	} // test

	@Test
	void test2() {

		List<Emp> list = repository.findAll();

		logger.info("test2 start======================================");
		for(Emp tmpEmp : list) {
			logger.info( tmpEmp.toString() );
		} // for
		logger.info("test2 end========================================");
	} // test2

} // class
