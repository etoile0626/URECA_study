package a0210;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {
	static int n , r, totalCnt;
	static int[] number, input;
	
	private static void combination(int cnt, int cur) {	//cur : 현재위치

		if(cnt == r) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}

		for (int i = cur; i < n; i++) { //i가 cur부터 시작(cur 이전은 중복되는거라 for문을 돌리지 않아도 된다는 판단)
			
			number[cnt] = i+1;
			
			combination(cnt+1, i+1);	//i+1을 함으로써 중복 되는 수까지 배제
			
		} 

	} 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();

		input = new int[n];
		number = new int[r];

		for (int i=0; i < n; i++) {
			input[i] = sc.nextInt();
		}

		combination(0, 0);
		System.out.println("총 경우의 수:"+totalCnt);
		
	}

}
