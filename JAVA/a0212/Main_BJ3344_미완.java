package a0212;

import java.util.Scanner;
//잠정보류 문제
public class Main_BJ3344_미완 {							//N-Queen 문제
	static int n;
	static int[] board;								//i번째 열 board[i]행에 퀸이 있다 
	static int[] board2;
	static boolean[] cheak1, cheak2, cheak3;		
	static StringBuilder sb = new StringBuilder();
	
	
	private static void queen(int cnt) {
	
		for(int i = 0; i < n; i++) {
			if(cheak1[i] == false && cheak2[cnt+i] == false && cheak3[cnt-i+n-1] == false) {
				board[cnt] = i;
				if(cnt == n-1) {
					for (int j = 0; j < n; i++) {
			            board2[j] = board[j];
			        }
				}else {
					cheak1[i] = cheak2[cnt+i] = cheak3[cnt-i+n-1] = true;
					queen(cnt+1);
					cheak1[i] = cheak2[cnt+i] = cheak3[cnt-i+n-1] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		board = new int[n];
		board2 = new int[n];
		cheak1 = new boolean[n];
		cheak2 = new boolean[n*2 -1];
		cheak3 = new boolean[n*2 -1];
		
		queen(0);
		
		for(int i = 0; i < n; i++) {
			sb.append(board2[i]+"\n");
		}
		System.out.println(sb.toString());
	}
}
