package ch04;

public class IfTest {

	public static void main(String[] args) {
		
		int a = 7;
		if(a > 5) System.out.println("a는 5보다 크다");	//참이라 수행
		if(a < 5) System.out.println("a는 5보다 작다");	//거짓이라 수행x , a가 5인 경우는 포함x
		
		if(a < 5) {
			System.out.println("a는 5보다 작은 모든 경우");
		}else {
			System.out.println("a는 5보다 작지않은 모든 경우"); //a=5인 경우도 포함	
		}
		
		//if else if else문, 스위치문도 예제를 했으나 아는 내용이라 스킵함
		switch("hi") {	//자바는 문자열이 가능함
		case "hi": System.out.println("hi"); break;
		case "hello": System.out.println("hello"); break;
		case "ho": System.out.println("ho"); break;
		}
	}	//main

}
