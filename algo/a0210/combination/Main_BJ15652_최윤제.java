package a0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ15652_최윤제 {
	
	static int n, r;
	static int[] number;

	private static void combination(int cnt, int cur) {
		if(cnt == r) {
			for(int i = 0; i < r; i++) {
				System.out.print(number[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = cur; i < n; i++) {
			
			number[cnt] = i+1;
			
			combination(cnt+1, i);	//같은 수를 여러번 고르게 조건 설정
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		number = new int[r];
		
		combination(0, 0);

		br.close();
	}
}
