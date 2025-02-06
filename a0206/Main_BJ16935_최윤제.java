package a0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N x M 배열에 R번 (1~6)의 연산 적용
 * 1:상하반전 2:좌우반전 3: 오른쪽으로 90도 4: 왼쪽으로 90도 5: 시계방향으로 구역 밀기 6: 반시계로 구역 밀기
 * 
 */
public class Main_BJ16935_최윤제 {
	public static int[][] reverseUpDown(int[][] arr) {	//상하 반전
		int n = arr.length;
		int m = arr[0].length;
		
		int[] temp = new int [m];
		
		for(int i = 0; i < n/2; i++) {
			temp = arr[i];
			arr[i] = arr[n-1 - i];
			arr[n-1 - i] = temp;
		}
		
		return arr;
	}
	
	public static int[][] reverseLeftRight(int[][] arr) {	//좌우 반전
		int n = arr.length;
		int m = arr[0].length;
		
		int temp;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m/2; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[i][m-1 - j];
				arr[i][m-1 - j] = temp;
			}
		}
		return arr;
	}
	
	public static int[][] turnRight(int[][] arr) {			//90도 오른쪽
		int n = arr.length;
		int m = arr[0].length;
		
		int [][]arr2 = new int[m][n];	//m*n배열
		
		for(int i = 0; i < m; i++) {		//arr2.length = m
			for(int j = 0; j < n; j++) {	//arr2[0].length = n
				arr2[i][j] = arr[n-1 - j][i];
			}
		}
		return arr2;
	}
	
	public static int[][] turnLeft(int[][] arr) {			//90도 왼쪽
		int n = arr.length;
		int m = arr[0].length;
		
		int [][]arr2 = new int[m][n];	//m*n배열
		
		for(int i = 0; i < m; i++) {		//arr2.length = m
			for(int j = 0; j < n; j++) {	//arr2[0].length = n
				arr2[i][j] = arr[j][m-1 -i];
			}
		}
		return arr2;
	}
	
	public static int[][] moveClock(int[][] arr) {			//4구역으로 쪼개서 시계방향으로
		int n = arr.length;
		int m = arr[0].length;
		
		int [][]temp = new int[n/2][m/2];	// (n/2) * (m/2)배열
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[0].length; j++) {
				temp[i][j] = arr[i][j];					//1그룹 arr2로 복사
				arr[i][j] = arr[i + n/2][j];		//4그룹->1그룹 이동
				arr[i + n/2][j] = arr[i + n/2][j + m/2]; // 3그룹->4그룹 이동
				arr[i + n/2][j + m/2] = arr[i][j + m/2]; //2그룹->3그룹
				arr[i][j + m/2] = temp[i][j];	//1->2
			}
		}
		return arr;
	}
	
	public static int[][] moveUnclock(int[][] arr) {		//4구역으로 쪼개서 반시계방향으로
		int n = arr.length;
		int m = arr[0].length;
		
		int [][]temp = new int[n/2][m/2];	// (n/2) * (m/2)배열
		for(int i = 0; i < temp.length; i++) {
			for(int j = 0; j < temp[0].length; j++) {
				temp[i][j] = arr[i][j + m/2];	//2그룹 복사
				arr[i][j + m/2] = arr[i + n/2][j + m/2]; //3그룹->2그룹
				arr[i + n/2][j + m/2] = arr[i + n/2][j]; // 4그룹->3그룹 이동
				arr[i + n/2][j] = arr[i][j];		//1그룹->4그룹 이동
				arr[i][j] = temp[i][j];					//2->1로
			}
		}
		return arr;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}//배열 입력
		
		
		st = new StringTokenizer(br.readLine());	//명령 목록 읽기
		while(r>0) {	//r번 연산 수행
			int o = Integer.parseInt(st.nextToken());
			switch(o) {
			case 1:
				arr = reverseUpDown(arr);		//상하반전
				break;
			case 2:
				arr = reverseLeftRight(arr);	//좌우반전
				break;
			case 3:
				arr = turnRight(arr);			//우로 90도 회전
				break;
			case 4:
				arr = turnLeft(arr);			//좌로 90도 회전
				break;
			case 5:
				arr = moveClock(arr);			//4구역으로 나눠 시계방향으로 회전
				break;
			case 6:
				arr = moveUnclock(arr);			//4구역으로 나눠 반시계방향으로 회전
				break;
			}
			r--;
		}
		//출력
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(); 				//줄바꿈
		}//배열 출력
		
		br.close();
	}

}
