package a0224;

import java.util.*;

// Dynamic Programming
public class Main_bj_2294_동전2_홍길동 {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] coin = new int[n];
		for(int i=0; i<n; i++) coin[i] = sc.nextInt();

		int[] dp = new int[k+1];
		for(int i=1; i<=k; i++) dp[i]=k+1;

		for(int i=0; i<n; i++){
			for(int j=coin[i]; j<=k; j++){
				dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
			}
		}

		System.out.println(Arrays.toString(dp));

		System.out.println(dp[k] == k+1? -1:dp[k]);
		sc.close();
	} // main

} // class

/*
3 15
1
5
12
*/
