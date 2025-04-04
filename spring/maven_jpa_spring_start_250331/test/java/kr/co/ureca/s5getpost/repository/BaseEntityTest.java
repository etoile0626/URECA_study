package kr.co.ureca.s5getpost.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.ureca.entity.Emp;

@SpringBootTest
class BaseEntityTest {

	public static final Logger logger = LoggerFactory.getLogger(BaseEntityTest.class);

	@Autowired
	private EmpRepository repository;

	@Test
	void test() {

		Emp emp = new Emp(null, 6666, "JamesBond", "SALESMAN"
							, 9999, "2023-05-01", 1800, 1200, 40, null, null);
		Emp savedEmp = repository.save(emp);

		logger.info("test start ======================");
		logger.info("savedEmp : " + emp.toString());
		logger.info("CreatedAt : " + savedEmp.getCreatedAt());
		logger.info("ModifiedAt : " + savedEmp.getModifiedAt());
		logger.info("test end =========================");

	} // test

} // class
