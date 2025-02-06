package ch06.pac.test;

//private : 외부에 공개하지 않는 변수나 메소드, 자기 클래스에서만 사용=>잘못된 데이터 입력방지를 위해 사용

public class PrivateTest {
	String defaultName = "privateClass";
	private String className = "privateClass";
	
	private void privateMethod() {
		System.out.println("privateMethod");
	}
	
	private int age;				//외부에서 age를 직접 건드리지 못하게 private 설정
	public void setAge(int age) {	//클래스 외부에서는 age를 건드리기 위해서 이 메소드를 이용해야함.
		if(age < 0) {
			System.out.println("age가 0보다 작을 수 없음.");
		}
		else {
			this.age = age;
		}
	}//setAge
}
