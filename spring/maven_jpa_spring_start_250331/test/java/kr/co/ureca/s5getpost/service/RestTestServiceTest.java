package kr.co.ureca.s5getpost.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.ureca.dto.EmpDTO;

@SpringBootTest
class RestTestServiceTest {
	
	public static final Logger logger = LoggerFactory.getLogger(RestTestServiceTest.class);

	@Autowired
	private RestTestService service;
	
	@Test
	void test() {
		EmpDTO dto = service.findById(7L);
		
		assertThat(dto).isNotNull();
		
		assertThat(dto.getId()).isEqualTo(7L);
		
		assertThat(dto.getEname()).isEqualTo("CLARK");
		
		System.out.println("============================");
		System.out.println(dto.toString());
		System.out.println("============================");
	}

}
