package a0210;

import java.util.Scanner;

public class R3FiboCnt {
	
	static long totalCnt1;	//총 몇번 돌았니
	static long call1[];	//fibo(n)이 몇번 호출됐는지 체킹용
	
	private static long fibo(int n) {
		++totalCnt1;
		++call1[n];
		if(n <= 1) return n;	//탈출조건
		
		return fibo(n-1)+fibo(n-2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		call1 = new long[n+1];
		System.out.println("result : "+fibo(n));

		System.out.println("==================");
		
		for(int i = 0; i < call1.length; i++) {
			System.out.printf("fido(%d) : %d\n", i+1, call1[i]);
		}
		
		System.out.println("totalCnt : " + totalCnt1);
	}

}
