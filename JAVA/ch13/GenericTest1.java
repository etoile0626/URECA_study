package ch13;

import java.util.ArrayList;

/*
 * 제네릭 : 클래스 내부에서 사용할 타입을 외부에서 지정하는 기법을 의미.
 * - 클래스 내부에서 사용하는 Data Type을 다이아몬드 지시자로 받을 수 있다.
 * - 불필요한 형 변환 코드 사용을 줄일 수 있다.
 * - 부주의한 형 변환으로 인해 발생할 수 있는 오류를 예방할 수 있다.
 * - 변수의 선언이나 메서드의 매개변수를 하나의 참조 자료형이 아닌 여러 자료형을 변환 될 수 있도록 프로그래밍 하는 방식.
 * - 실제 사용되는 참조 자료형으로의 변환은 컴파일러가 검증하므로 안정적인 프로그래밍 방식.
 */
public class GenericTest1 {

	public static void main(String[] args) {
		Integer iObj = 777;
		String sObj = "hi";

		// 1. generic을 사용하지 않으면,
		ArrayList list1 = new ArrayList();
		list1.add(iObj);
		list1.add(sObj);
		// -> list에 들어 있는 타입을 알 수 없다.

		// 2. generic을 사용하면,
		ArrayList<Integer> intList = new ArrayList<>();
		intList.add(iObj);
//		intList.add(sObj); // error

	} // main

}




