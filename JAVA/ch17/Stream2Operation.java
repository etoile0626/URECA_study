package ch17;

import java.util.Arrays;
/*
 * 스트림 연산은 중간 연산과 최종 연산으로 구분.
 * - 스트림에 대해 중간 연산은 여러 개 적용 가능.
 * - 최종 연산은  마지 막에 한 번만 적용.
 * - 최종연산이 호출되어야 중간연산의 결과가 모두 적용.
 * - filter() : 중간 연산, 요소를 추출.
 * - map() : 중간 연산, 요소를 변환.
 * - sorted() : 최종 연산.
 * - forEach() : 최종 연산, 요소를 하나씩 꺼내 옴.
 * - count() : 최종 연산, 요소의 개수.
 * - sum() : 최종 연산, 요소의 합.
 * - 자료에 대한 스트림을 생성하면 별도의 메모리 공간을 사용하므로 기존 자료를 변경하지 않음.
 */
public class Stream2Operation {

	public static void main(String[] args) {

		int[] arr = {10,9,8,7,6,5,4,3,2,1};
		System.out.println("sum : "+Arrays.stream(arr).sum());
		System.out.println("count : "+Arrays.stream(arr).count());

		System.out.print("forEach : ");
		Arrays.stream(arr).forEach(n->System.out.print(n+"\t"));
		System.out.println();
		System.out.print("sorted : ");
		Arrays.stream(arr).sorted().forEach(n->System.out.print(n+"\t"));
		System.out.println();
		System.out.print("filter : ");
		Arrays.stream(arr).filter(n -> n > 5).forEach(n->System.out.print(n+"\t"));
		System.out.println();
		System.out.print("filter : ");
		Arrays.stream(arr).filter(n -> n > 5).filter(n -> n == 7).forEach(n->System.out.print(n+"\t"));
	}

}
