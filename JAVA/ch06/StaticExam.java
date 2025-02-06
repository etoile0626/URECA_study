package ch06;

public class StaticExam {

	//int iVar;
	static int iVar;	//쓸꺼면 이렇게 해줘야지
	
	public static void main(String[] args) {
		
		System.out.println(iVar); //iVar가 static 변수가 아니므로 static 메소드(메인 메소드) 안에 있는 이 실행문에서 iVar를 건드리지 못함
		
		StaticClass s1 = new StaticClass();
		s1.staticInt = 777;
		StaticClass s2 = new StaticClass();
		s2.staticInt = 888;
		System.out.println(s1.staticInt);	//s1과 s2는 같은 영역을 가리키고 있음
		System.out.println(s2.staticInt);
		System.out.println(StaticClass.staticInt);	//3개 다 같은거
		
		StaticNonClass no1 = new StaticNonClass();	//new 라는 키워드를 만나기 전까지 인스턴트 영역은 메모리에 로딩이 되지 않음
		no1.nonStaticInt = 777;
		StaticNonClass no2 = new StaticNonClass();
		no2.nonStaticInt = 888;
		System.out.println(no1.nonStaticInt);
		System.out.println(no2.nonStaticInt);
		System.out.println(no1.staticBlockTest);
		System.out.println(no2.staticBlockTest);

	}

}
