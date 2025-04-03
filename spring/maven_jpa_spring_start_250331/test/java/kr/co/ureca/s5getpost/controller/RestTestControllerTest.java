package kr.co.ureca.s5getpost.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestTestControllerTest {			//테스트 대상 객체 지정

	//given - 실행에 필요한 요소를 준비하는 단계
	@Autowired
	RestTestController controller;
	
	@Test
	void testNo1() {
		//when -  실행 단계(테스트 코드)
		String str = controller.no1();
		
		//then - 결과 데이터 확인
		//assertThat("받은값").비교방법메소드("기댓값");의 형태를 많이씀
		//결과값 str이 예측값과 같은지 확인		//str은 hello world가 나와야함
		//assertThat(str).isEqualTo("HELLo world");		//실패
		assertThat(str).isEqualTo("hello world");		//성공
	}

}
