package ch05;

public class RefVarTest {

	public static void main(String[] args) {
		
		String s1 = new String("hello");
		String s2 = new String("hi");
		String s3 = s2;
		
		System.out.println(s1 == s2); //false
		System.out.println(s3 == s2); //true
		
		String s4 = new String("여행");	//좌항, 우항, 대입연산자 순으로 실행됨(s4를 만들고, 객체를 만들고, 객체 주소를 담음)
		s4 = null; //new String("여행")은 쓰래기 수거 대상
		
		String s5 = new String("취미");
		String s6 = s5;	//pass by reference
		s5 = null;		//이러면 new String("취미");는 쓰래기 수거 대상이 아님(s6가 가리키고 있으니까)
	}

}
