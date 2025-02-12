package ch13;

/*
 * 자료형 매개 변수 T
 * - 자료형 매개변수 : 여러 참조 자료형으로 대체 될 수 있는 부분을 하나의 문자로 표현한 것.
 * - T는 data type의 의미.
 * - <>는 다이아몬드 지시자.
 * 와일드 카드
 * - Element : 내부 요소
 * - Key
 * - Value
 * - Type : 외부에서 입력 받는 클래스가 제네릭 클래스 내부에서  타입으로 사용.
 * - Number
 * - ? : 모든 클래스 - Object
 */
public class GenericTest2 {

	public static void main(String[] args) {

		AllType<Integer> all1 = new AllType<>();
		Integer intObj = 777;
		all1.setMember(intObj);
		System.out.println(all1.getMember());

		AllType<String> all2 = new AllType<>();
		all2.setMember(new String("HELLO"));
		System.out.println(all2.getMember());

	}

}
