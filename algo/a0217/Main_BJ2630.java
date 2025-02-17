package a0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 종이 전체가 모두 같은 색이 아니라면, 색종이를 가로 세로 절반 길이로 자른다.
 * 자른 종이가 위의 조건을 만족하지 않는다면, 만족할 때까지 반복한다. 최종적으로 잘랐을때 색종이의 개수를 각각 구하여라. 
 * 분할정복 알고리즘 문제
 */
												//강사님 코드 보면서 공부하기
public class Main_BJ2630 {						//색종이 만들기 => 분할정복의 교과서 같은 애, 얘만 잘 이해하면 다 활용가능
	static int white, blue;
	
	private static boolean isDivide(int[][] arr) {	//배열이 전부 하나의 색으로 칠해지면 해당색의 색종이 수를 증가하고 참을 반환하는 함수
		int len = arr.length;
		int countZero = 0;
		int countOne = 0;
		
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				if(arr[i][j] == 0) countZero++;
				else if(arr[i][j] == 1) countOne++;
			}
		}
		if(countZero == len*len) {
			white++;
			return true;
		}
		else if(countOne == len*len) {
			blue++;
			return true;
		}
		
		return false;
		
	}
	
	private static void divide(int[][] arr){		//주어진 종이가 하나의 색인지 검사, 아니면 하나의 색종이가 될때까지 분할
		if(isDivide(arr)) {
			return;
		}
		
		int len = arr.length;
		int arr1[][] = new int[len/2][len/2];
		int arr2[][] = new int[len/2][len/2];
		int arr3[][] = new int[len/2][len/2];
		int arr4[][] = new int[len/2][len/2];
		for(int i = 0; i < len/2; i++) {
			for(int j = 0; j < len/2; j++) {
				arr1[i][j] = arr[i][j];
				arr2[i][j] = arr[i][j+len/2];
				arr3[i][j] = arr[i+len/2][j];
				arr4[i][j] = arr[i+len/2][j+len/2];
			}
		}
		
		divide(arr1);
		divide(arr2);
		divide(arr3);
		divide(arr4);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}															//입력
		
		divide(arr);												//처리

		System.out.println(white);									//출력
		System.out.println(blue);
	}

}
