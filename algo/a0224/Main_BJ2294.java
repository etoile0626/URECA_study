package a0224;

import java.util.Scanner;

/*
 * 아까한 평범한 배낭이랑 비슷한 흐름인데 좀 더 쉬움
 * n가지 종류 동전을 사용해 k원이 되고자 함. 그러면서 동전의 개수가 최소가 되는 것이 목표
 * 배낭과 다르게 아래서부터 위로 검증해 나가야 함
 */
public class Main_BJ2294 {								//동전 2		=> 보면 알겠는데 제가 이렇게 생각은 못하겠어요 dp 개같다 진짜

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] coin = new int[n];
		for(int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
		}
		
		int[] dp = new int[k+1];							//k원 만큼에 사용한 동전의 최소개수 dp[k]
		for(int i = 1; i <= k; i++) {
			dp[i] = k+1;									//최솟값을 찾기위해 k보다 큰 값인 k+1로 초기화
		}
		
		for(int i =0; i < n; i++) {
			for(int j = coin[i]; j <= k; j++) {
				//coin[i] 코인을 사용해서 coin[i]원부터 k원까지 사용한 동전의 수 나타내기 (내가 가진 동전으로 만들 수 없으면 k+1 값이 나올 것임)
				dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);	
			}
		}
		
		if(dp[k] == k+1) {
			System.out.println("-1");
		}else {
			System.out.println(dp[k]);
		}
		sc.close();
	}

}
