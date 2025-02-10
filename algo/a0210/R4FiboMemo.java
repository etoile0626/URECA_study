package a0210;

import java.util.Scanner;

public class R4FiboMemo {
	
	static long totalCnt2;	//총 몇번 돌았니
	static long call2[];	//fibo(n)이 몇번 호출됐는지 체킹용
	static long memo[];		//메모화를 위해 값을 저장할 배열
	
	private static long fibo(int n) {
		++totalCnt2;
		++call2[n];
		if(n <= 1) return n;	//탈출조건
		
		if(memo[n] != 0) {	//memo 배열에 이미 값이 저장되어있다면
			return memo[n];	//재귀하지 않고 이미 저장된 값으로 호출하기 => 재귀함수의 메모화!
		}
		
		return memo[n] = fibo(n-1)+fibo(n-2);	//수행 결과값을 memo에 담으면서 재귀하기
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		call2 = new long[n+1];
		memo = new long[n+1];
		System.out.println("result : "+fibo(n));

		System.out.println("==================");
		
		for(int i = 0; i < call2.length; i++) {
			System.out.printf("fido(%d) : %d\n", i+1, call2[i]);
		}
		
		System.out.println("totalCnt : " + totalCnt2);
	}

}
