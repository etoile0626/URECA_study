package ch02;

public class EqualsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//중괄호가 끝나는 부분에서 표시해두면 편함 -> 개발하는 꿀팁
		//primitive data type
		int a;		//int는 21억까지 밖에 표현이 안됨->금융권 프로젝트에선 long을 쑬 것
		a = 7;
		int b, c;
		b = 7;
		c = 7;
		int d = 7, e = 7;
		
		System.out.println(a == b); //true
		a = 8; //이런식으로 값을 바꿔 담을 수 있음 ->변수
		
		//objective data type(ex.String)
		String s;
		s = new String("hi");	//실제 hi 값이 있는 주소를 가리킴
		String s2, s3;
		s2 = new String("hi");
		s3 = new String("hi");
		String s4 = new String("hi"), s5 = new String("HI");
		
		System.out.println(s == s2); //false - 위치값 비교중
		System.out.println(s.equals(s2)); //true - 참조 내용 비교
		System.out.println(s.equals(s5)); //false - 대소문자의 아스키 값이 다르다
		System.out.println(s.equalsIgnoreCase(s5)); //true - 참조 내용 비교
		
		//String 상수 의 문제가 생김
		String s6 = "hello";		//상수임 이건 new가 없음
		String s7 = "hello";		//s6에서 만든 hello를 재사용한거임
		System.out.println("상수 비교 : "+(s6 == s7)); //true-같은 위치에 있는 hello의 주소값을 가져옴
		
	}	//main

}	//class
