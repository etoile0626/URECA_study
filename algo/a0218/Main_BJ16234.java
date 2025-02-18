package a0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 인접한 배열의 인덱스들의 값의 차를 d라고 할 때 
 * L <= d <= R을 만족하는 배열의 인덱스들은 전부 인구를 동등하게 나눠준다(다 합치고 나누기)
 * 위 조건을 불만족할때까지(플래그 이용) 인구이동을 반복, 그때의 인구 이동 기간 구하기
 */

public class Main_BJ16234 {								//인구이동 => 강사님 코드 참고하였음.(bfs를 구현함은 성공했는데 while문 구현을 하지 못함)
	static ArrayList<int[]> list;
	static int[] dx = {0, 0, 1, -1}; 
	static int[] dy = {-1, 1, 0, 0}; 
	static int[][] arr;
	static boolean[][] visit;
	static boolean flag;
	static int n , l, r, date, sum;
	
	private static void bfs(int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();								//bfs용 큐
		visit[i][j] = true;
		queue.offer(new int[] {i, j});
		list.add(new int[] {i, j});
		
		while(!queue.isEmpty()) {
			int[] ij = queue.poll();
			i = ij[0];
			j = ij[1];
			sum += arr[i][j];
			for(int d = 0; d < 4; d++) {
				int ni = i + dx[d];
				int nj = j + dy[d];
				if(0 <= ni&&ni < n && 0 <= nj&&nj < n && !visit[ni][nj]) {		//배열 안이고 방문 안했으면
					int diff = Math.abs(arr[ni][nj] - arr[i][j]);				//문제 조건 만족하면
					if(l <= diff&&diff <= r) {
						flag = true;											//다음에도 들어가도록 플래그 변경
						visit[ni][nj] = true;
						queue.offer(new int[] {ni, nj});
						list.add(new int[] {ni, nj});
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		date = 0;
		flag = true;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(flag) {										//인구이동 한 사이클
			flag = false;
			date++;
			visit = new boolean[n][n];
			
			for(int i = 0; i <n; i++) {
				for(int j = 0; j < n; j++) {
					if(visit[i][j]) {						//방문한 애는 넘어가기
						continue;
					}
					
					sum = 0;								//연합 인구수의 총합
					list = new ArrayList<>();				//연합의 좌표를 담을 리스트
					
					bfs(i, j);								//방문한 애가 아니면 bfs 시작
					
					int avg = sum/list.size();
					for(int k = 0; k < list.size(); k++) {
						arr[list.get(k)[0]][list.get(k)[1]] = avg;
					}
				}
			}
		}//while
		System.out.println(date-1);		//마지막에 bfs 할수 있는지 보려고 한 번 더 들어와서 실제 인구이동 횟수는 date-1
	}
}
