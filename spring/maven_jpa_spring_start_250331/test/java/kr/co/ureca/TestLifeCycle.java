package kr.co.ureca;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 스프링 부트 환경에서의 테스트
class TestLifeCycle {

	@BeforeAll
	static void beforeAll() {
		System.out.println("@BeforeAll : 모든 테스트 시작 전에 수행해야 하는 작업. 예-driver loading" );
	}

	@AfterAll
	static void afterAll() {
		System.out.println("@AfterAll : 모든 테스트 끝난 후에 수행해야 하는 작업. 예-close()" );
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("@BeforeEach : 각 메소드 테스트 시작 전에 수행하는 작업." );
	}

	@AfterEach
	void afterEach() {
		System.out.println("@AfterEach : 각 메소드 테스트 실행 후에 수행하는 작업." );
	}

	@Test
	void test() {
		// fail("Not yet implemented"); // 비정상 종료는 빨간색 return.
		System.out.println("default test method"); // 정상 종료는 초록색 return.
	}

	@Test
	void test2() {
		System.out.println("second test method"); // 정상 종료는 초록색 return.
	}

} // class
