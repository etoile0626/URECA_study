package a0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 아까 색종이하던것처럼 4구역으로 나눠서 구역안의 값이 모두 같도록함=>같으면 그 값으로 압축 시킴
 * 강사님 2630번 코드 보고 풀이 => 한 번 더 살펴보고 공부해서 내 것으로 만들기
 */

public class Main_BJ1992 {								//쿼드트리
	static int[][] arr;
	static String answer = "";
	private static void incoding(int i, int j, int n) {
		int sum = 0;
		for(int row = i; row < i+n; row++) {
			for(int col = j; col < j+n; col++){
				sum += arr[row][col];
			}
		}
		
		if(sum == n*n) {
			answer += 1;
		}else if(sum == 0) {
			answer += 0;
		}else {
			answer += "(";
			incoding(i, j, n/2);
			incoding(i, j+n/2, n/2);
			incoding(i+n/2, j, n/2);
			incoding(i+n/2, j+n/2, n/2);
			answer += ")";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		incoding(0, 0, n);
		
		System.out.println(answer);
	}
}
