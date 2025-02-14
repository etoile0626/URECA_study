package ch17;

import java.util.Arrays;
/*
 * 스트림 (stream) : 자료를 읽어 들여온 객체를 생성. 소모성. 일회성.
 * - 배열, 컬렉션을 대상으로 일관성 있는 연산으로 자료의 처리를 쉽고 간단하게 함.
 * - 한 번 생성하고 사용한 스트림은 재사용 할 수 없음.
 * - 자료에 대한 스트림을 생성하면 별도의 메모리 공간을 사용하므로 기존 자료를 변경하지 않음.
 */
public class Stream1OverView {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.stream(arr));
		System.out.println(Arrays.stream(arr).sum());
		System.out.println(Arrays.stream(arr).count());
		System.out.println(Arrays.toString(arr));

	}//main

}
