package a0210;

import java.util.Scanner;

// Recursive
public class R1Factorial {

	// n! : n * (n-1)!

	// n! 계산
	private static long factorial(int n) {

		if(n==1) return 1; // 기저(재귀 탈출) 파트

		return n * factorial(n-1); // 유도(파생) 파트
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		System.out.println(factorial(N));
	}

}
