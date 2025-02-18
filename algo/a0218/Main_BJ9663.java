package a0218;

import java.util.Scanner;
/*
 * 백트래킹으로 n-퀸 문제 풀어보기
 */
public class Main_BJ9663 {										//N-Queen
	static int arr[];
	static int n, count;
	
	private static boolean isQueen(int i) {						//백트래킹 적용
		for(int j = 0; j < i; j++) {
			//i와 j는 행의 위치, arr[i], arr[j]는 열의 위치라고 생각(i번째 행 arr[i]열에 위치한 퀸)
			//j<i이므로 무조건 다른행에 존재, arr[j]=arr[i]라면 같은 열에 있으므로 거짓.
			//i-j == Math.abs(arr[j]-arr[i]) => 행과 열이 같은 칸만큼 떨어져 있으면 대각선 상에 있게됨
			if(arr[j] == arr[i] || Math.abs(arr[i]-arr[j]) == i-j) {
				return false;
			}
		}
		return true;
	}
	
	private static void queen(int cnt) {
		if(!isQueen(cnt-1)) {				//백트래킹으로 유망함수를 만족하지 않으면 더 이상 진행 안하도록
			return;
		}
		
		if(cnt == n) {						//n개의 퀸을 모두 골랐다면 경우의 수 증가
			count++;
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			arr[cnt] = i;					//cnt 행 i 열 위치에 퀸을 두겠다
			queen(cnt+1);
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		count = 0;
		
		queen(0);
		
		System.out.println(count);
		sc.close();
	}
}
