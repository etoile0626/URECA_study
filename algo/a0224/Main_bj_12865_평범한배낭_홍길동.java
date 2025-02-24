package a0224;

import java.util.*;

public class Main_bj_12865_평범한배낭_홍길동{

	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();  
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		for(int i=1; i<=N; i++){
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		} // for

		int[] dp=new int[K+1]; 
		for(int i=1; i<=N; i++){

			for(int j=K; j-W[i]>=0; j--){
				dp[j] = Math.max(dp[j], dp[j-W[i]]+V[i]);
			} // for

		} // for

		System.out.println(dp[K]);
		sc.close();
	} // main

} // class

/*
4 7
6 13
4 8
3 6
5 12
*/
