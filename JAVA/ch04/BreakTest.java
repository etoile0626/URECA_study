package ch04;

public class BreakTest {

	public static void main(String[] args) {
		
		for(int i = 1; i<=10; i++) {
			if(i == 5) break; //5일때 반복문 종료
			System.out.println("break : " + i);
		}//for
		
		for(int i = 1; i<=10; i++) {
			if(i == 5) continue; //5일때 수행을 안하고 다음으로
			System.out.println("continue : " + i);
		}//for

	}//main

}
