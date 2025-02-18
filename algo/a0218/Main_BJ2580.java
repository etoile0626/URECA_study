package a0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 9x9칸에서 스도쿠 빈칸 넣기
 * 가로, 세로, 3x3 칸 안에 1~9가 한 번씩만 있어야함
 * 유망함수 : 가로, 세로, 3x3칸에 빈칸이 적은 곳부터 안 겹치는 숫자 입력, 숫자가 겹치면 더 탐색 x?
 */

public class Main_BJ2580 {						//스도쿠 => 프로그래머스에도 '스도쿠 퍼즐'에 문제가 존재함(한 번 더 풀어보기)
	static int[][] arr;
	static ArrayList<int[]> num;				//빈칸인 곳의 좌표를 저장하는 리스트
	static boolean flag;					
	
	private static boolean backtraking(int r, int c, int k) {	//r 행, c 열, k 넣고자하는 값
		for(int i = 0; i <9; i++) {
			if(arr[r][i] == k || arr[i][c] == k) {		//가로 세로에 넣고자하는 값이 이미 존재하면
				return false;
			}
		}
		
		r = r/3 * 3;		//0이 들어있는 3x3배열의 왼쪽 위 인덱스로 초기화(3x3배열에 k가 있는지 확인해야하므로)
		c = c/3 * 3;		//=>그래야 왼쪽위부터 3x3으로 배열 인덱스 접근이 용이해짐
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (arr[r+i][c+j] == k) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static void sdoku(int cnt) {					//dfs형태로 구현 (강사님 풀이)
		
		if(flag) {
			return;
		}
		
		if(cnt == num.size()) {								//탈출조건(0인 좌표들을 모두 살펴보면 출력)
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] +" ");
				}
				System.out.println();
			}
			
			flag = true;									//조건을 만족하면 바로 나머지 재귀호출들을 끝내기 위한 플래그
			
			return;
		}
		
		int[] tmp = num.get(cnt);
		int r = tmp[0];
		int c = tmp[1];										//리스트에서 좌표값 가져오기
		
		for(int k = 1; k <= 9; k++) {
			if(backtraking(r, c, k)) {
				arr[r][c] = k;
				sdoku(cnt+1);
				arr[r][c] = 0;								//굳이 없어도 되는데 dfs 형태임을 보여주기 위해 추가
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		num = new ArrayList<>();
		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 0) {
					num.add(new int[] {i, j});				//0(빈칸)의 좌표값 리스트에 추가
				}
			}
		}
		
		sdoku(0);
		
		br.close();
	}
}
