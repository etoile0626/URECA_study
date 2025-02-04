package ch02;

public class VarInitTest {
	
	static int a;	//멤버 변수는 0으로 자동초기화 됨
	
	public static void main(String[] args) {
			System.out.println("멤버 변수 : " + a);
			
			int b;	//정수 지역 변수는 자동초기화 없음 -> 초기화 후 사용
			b = 7;
			System.out.println("local variable : " + b);
	}

}
