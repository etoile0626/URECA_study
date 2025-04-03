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

//	@SpringBootTest or @DataJpaTest + @AutoConfigureTestDatabase(replace = Replace.NONE) 사용 가능
// 	Replace.Any : embeded DBMS 사용 (ex.h2) / Replace.NONE :  기존 DBMS 사용 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class EmpRepositoryTest {
	
	public static final Logger logger = LoggerFactory.getLogger(EmpRepositoryTest.class);

	@Autowired
	private EmpRepository repository;
	
	@Test
	void test() {	//save test
		
		//given (개념적)
		Emp emp = new Emp(null, 6666, "GGC", "General", 9999, "2020-03-01", 3600, 1200, 40, null);
		
		//when (개념적)
		Emp savedEmp = repository.save(emp);
		
		//then (개념적)
		assertEquals(emp.getEmpno(), savedEmp.getEmpno());
		assertEquals(emp.getEname(), savedEmp.getEname());
		
		//로그 출력
	}
	
	@Test
	void test2() { //목록 조회 테스트
		List<Emp> list = repository.findAll();
		
		logger.info("test2 start==================================");
		for(Emp tmp : list) {
			logger.info(tmp.toString());
		}
		logger.info("test2 end==================================");
	}

}
