package ch17;

import java.util.Arrays;
/*
 * reduce() : 정의된 연산이 아닌 프로그래머가 직접 지정하는 연산을 적용
 */
public class Stream5Reduce {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(Arrays.stream(arr).sum());
		System.out.println(Arrays.stream(arr).count());
		System.out.println(Arrays.stream(arr).reduce(0, (a,b)->a+b));
		System.out.println(Arrays.stream(arr).reduce(1, (a,b)->a-b));
		System.out.println(Arrays.stream(arr).reduce(2, (a,b)->a*b));
		System.out.println(Arrays.stream(arr).reduce(3, (a,b)->a/b));
		System.out.println(Arrays.stream(arr).reduce(4, (a,b)->a%b));
		System.out.println(Arrays.stream(arr).reduce(5, (a,b)->a+b));

		String[] strArr = {"hi", "hello", "how are you", "i am fine", "thank you"};

		String str = Arrays.stream(strArr)
						.reduce("", (s1, s2)-> 
										{if (s1.getBytes().length >= s2.getBytes().length) return s1;
										else return s2;}
								);
		System.out.println(str); 

	}//main

}
