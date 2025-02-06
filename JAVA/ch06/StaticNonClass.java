package ch06;

public class StaticNonClass {
	
	int nonStaticInt;
	
	static int staticBlockTest;
	
	static {					//단 한 번만 실행되는 코드 블락?
		staticBlockTest = 123456;
	}
}
