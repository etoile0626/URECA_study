package a0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 강사님 코드보고 공부한것
 * 본래 내 풀이:사방탐색이니 bfs를 통해 현재 값을 비교하면서 가보자! => 실패
 * 강사님 풀이: 기존의 입력값외에 새로운 배열을 만들어 (i, j)까지 사방탐색을 하면서 걸린 최솟값들을 갱신함
 */
public class Main_BJ4485 {										//녹색 옷을 입은 애가 젤다지?
	static int[][] arr , ruppe;
	static boolean[][] visit;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		while(++count > 0) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				break;
			}
			
			arr = new int [n][n];
			ruppe = new int [n][n];										//누적 루피값이 들어가는 배열
			visit = new boolean [n][n];
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					ruppe[i][j] = 987654321;					//비교해서 더 작은애를 넣도록
				}
			}
			
			ruppe[0][0] = arr[0][0];									//시작위치
			for(int k = 0; k < n*n; k++) {								//배열 전부 돌때 동안 반복하려고 크게 잡음
				int min = 987654321;
				int mi = 0;
				int mj = 0;
				
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						if(!visit[i][j] && min > ruppe[i][j]) {	//아직 방문 안하고 최소값이 있는 곳이 있으면
							min = ruppe[i][j];	//i, j까지 이동하는 비용의 최소값 가져오고 해당 위치로 이동
							mi = i;
							mj = j;
						}
					}
				}
				
				visit[mi][mj] = true;							//최소값 위치 방문
				if(mi == n-1 && mj == n-1) {					//목적지 도달시 탈출
					break;
				}
				
				for(int d = 0; d < 4; d++) {
					int ni = mi + dx[d];
					int nj = mj + dy[d];
					
					if(0 <= ni&&ni<n && 0 <= nj&& nj <n) {
						if(ruppe[ni][nj] > min + arr[ni][nj]) {	//다음의 갈 위치 값이 갱신이 가능하면 갱신
							ruppe[ni][nj] = min + arr[ni][nj];
						}
					}
				}
			}
			
			System.out.println("Problem "+count+": "+ruppe[n-1][n-1]);
		}
		
		br.close();
	}
}
