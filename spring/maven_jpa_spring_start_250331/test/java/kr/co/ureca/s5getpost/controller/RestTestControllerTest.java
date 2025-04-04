package kr.co.ureca.s5getpost.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestTestControllerTest { // Test 대상 객체 지정

	// 개념적 given - 실행에서 필요한 요소를 준비하는 단계.
	@Autowired
	private RestTestController controller;

	@Test
	void testNo1() {
		// 개념적 when - 실행 단계 (테스트 코드)
		String rtnStr = controller.no1();

		// 개념적 then - 결과 데이터를 확인하는 단계
		// assertThat(받은 값).비교방법메소드(기대 값) 
//		assertThat(rtnStr).isEqualTo("HELLO WORLD"); // fail
		assertThat(rtnStr).isEqualTo("hello world"); // success
	} // testNo1

} // class
