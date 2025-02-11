package a0210;

import java.util.Scanner;

public class R2Fibo {
	private static long fibo(int n) {
		if(n <= 1) return n;	//탈출조건
		
		return fibo(n-1)+fibo(n-2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println("result : "+fibo(n));

	}

}
