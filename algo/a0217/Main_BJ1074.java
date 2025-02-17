package a0217;

import java.util.Scanner;

/*
 * 2^n * 2^n 인 2차원 배열을 Z모양으로 재귀적으로 탐색하고자함.
 * 강사님 정답 보고 수정한 코드(기존코드: 한칸씩 Z를 그리는 규칙에 맞게 전부 탐색 => 수정코드: Z모양으로 묶어서 탐색)
 * **왜 자꾸 시간 초과가 뜨는가 => 하나씩 일일히 탐색중이기 때문에! => 강사님 해답: z모양 하나를 기준으로 묶자(내것보다 4배는 빨라질듯)
 */

public class Main_BJ1074 {									//Z
	static int r, c;
	static int count = 0;
	static int answer;
	static int[] di = {0, 0, 1, 1};
	static int[] dj = {0, 1, 0, 1};				//시작좌표를 중심으로 Z모양으로 순회하기 위한 좌표(0,0)->(0,1)->(1,0)->(1,1)
	
	private static void zett(int i, int j, int cnt, int n) {	//i행, j열, 현재위치 cnt, 배열크기 n
		if((r < i || i+n <= r) || (c < j || j+n <= c)) return; //3행을 찾아야하는데 2행에 있다던지, 즉 Z를 그릴 수 없는 상황에서는 탈출
		
		if(n/2 == 0) {										//쪼개면 더 이상 z를 그리지 못하면(=2*2배열이 된다면)
			for(int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni == r && nj == c) {
					answer = cnt+d;
				}
			}
			return;
		}
		
		zett(i,         j, cnt+(n/2*n/2*0), n/2);				//왼쪽 위 z
		zett(i,     j+n/2, cnt+(n/2*n/2*1), n/2);				//오른쪽 위 z
		zett(i+n/2,     j, cnt+(n/2*n/2*2), n/2);				//왼쪽 아래 z
		zett(i+n/2, j+n/2, cnt+(n/2*n/2*3), n/2);				//오른쪽 아래 z
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		n = (int) Math.pow(2, n);
		
		zett(0, 0, 0, n);
		
		System.out.println(answer);
		sc.close();
	}
}
