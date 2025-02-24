package a0224;

import java.util.Scanner;

/*
 * 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임
 * 계단을 밟으면 해당 계단에 적힌 점수 획득
 * 계단은 한 번에 하나, 혹은 2계단을 오를 수 있으나, 연속된 3계단을 밟아선 안된다(1 연속 3번 x, 시작점은 계단이 아님)
 * 도착 계단은 반드시 밟을 것. =>이게 점화식 규칙
 * 이때 점수의 최댓값 구하기
 */
public class Main_BJ2579 {								//계단 오르기 => 다시 공부하기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int arr[] = new int[n+1];						//시작점 버리고 점수담을 배열
		int dp[] = new int[n+1];							//i번째 계단까지 올랐을때의 최댓값 dp[i]
		for(int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		dp[1] = arr[1];
		if(n >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		//값이 같으면 직전계단을 밟는것보다 2계단 오른 애를 우선으로 
		//그래야 다음 계단 선택시 더 큰 애를 확정적으로 고를 수 있음...?근데 생각해보니 값이라서 상관없잖아
		if(n >= 3) {
			dp[3] = Math.max(arr[1], arr[2]) +arr[3];	//1, 2번지 중 더 큰 값 고르기
		}
		for(int i = 4; i <= n; i++) {
			//2계단 건너뛴 것 vs 1계단 건너뛴 것 중 최댓값
			dp[i] = Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]);
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}
}
