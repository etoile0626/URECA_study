package a0224;

import java.util.Scanner;

/*
 * 정수 n을 1로 만들때 사용하는 연산의 최소 횟수 구하기
 * 연산 1 - 3으로 나누어 떨어지면 3으로 나누기
 * 연산 2 - 2로 나누어 떨어지면 2로 나누기
 * 연산 3 - 1을 빼기
 */
public class Main_BJ1463 {										//1로 만들기
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int dp[] = new int[n+1];		//0번지 안씀, i를 1로 만드는데 필요한 최소 연산횟수 dp[i]
		dp[1] = 0;						//1은 이미 1이므로 연산을 안함 =>0회
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] +1;							//1 빼기 연산을 반영한 것
			if(i%2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);		//전자는 1을 뺀 연산, 후자는 2로 나눈 연산횟수를 추가해서 둘 중 더 작은 값이 최솟값으로
			}
			if(i%3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		
		System.out.println(dp[n]);
	}
}
