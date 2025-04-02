package kr.co.ureca;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest		//SpringBootTest객체 선언, 이거 있어야 테스트가 돌아감
public class TestLifeCycle {
	
	@BeforeAll	//모든 테스트 시작 전 수행해야하는 작업. ex) 드라이버 로딩
	static void beforeAll() {
		System.out.println("beforeAll");
	}
	@BeforeEach	//각 단위 테스트 시작 전 마다 수행
	void beforeEach() {
		System.out.println("beforeEach");
	}
	@AfterAll	//모든 테스트 수행 후 수행하는 작업. ex)close
	static void afterAll() {
		System.out.println("afterAll");
	}
	@AfterEach	//각 단위 테스트 종료 할때마다 수행
	void afterEach() {
		System.out.println("afterEach");
	}
	
	@Test
	void test() {
		//fail("not yet implement");
		System.out.println("default test method");
	}
	
	@Test
	void test2() {
		//fail("not yet implement");
		System.out.println("second test method");
	}
}
