package a0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * NxN크기 배열에서 집이 있으면1, 아니면 0
 * 연결된 집들은 하나의 단지로 취급, 대각선상에 있는 집은 연결로 취급하지 않음
 * 단지 수 와 단지에 속하는 집의 수들을 오름차순으로 정렬하여 출력할것
 * 
 * 힌트-bfs(너비우선), dfs(깊이우선)?
 */
public class Main_BJ2667_최윤제 {
	static int n;
	static int [][] arr;
	static int[][] dxdy = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	//방향백터 <-상하좌우 탐색을 위해 필요한 것!
	static ArrayList<Integer> apt; //단지에 속하는 집의 개수를 담을 객체
	static boolean[][] visited;//방문 확인용
	
	public static int dfs(int i, int j) {		//깊이 우선 탐색, 근방에 안 간 곳은 다 찾아내기
		int num = 1; //단지내 아파트 수
		visited[i][j] = true;
		Queue<int[]> q = new ArrayDeque<>();		//컬렉션에 배열이 들어가지더라
		q.offer(new int[] {i,j});					//queue에 현재 위치 입력
		while(!q.isEmpty()) {
			int[] xy = q.poll();					//큐에서 값 가져오기
			i = xy[0];
			j = xy[1];
			for(int d = 0; d < 4; d++) {			//4방향 탐색
				int ni = i + dxdy[d][0];
				int nj = j + dxdy[d][1];
				if(ni >= 0 && ni < n && nj >= 0 && nj < n && visited[ni][nj] == false && arr[ni][nj]==1) {
					num++;
					visited[ni][nj] = true;
					q.offer(new int[] {ni, nj});
				}
			}
		}
		return num;
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][n];				//입력배열
		visited = new boolean[n][n];
		apt = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j)-'0'; //Integer.parseInt(s.charAt(j)+""); 로 했는데 s.charAt(j)-'0';이 더 빠르고 나아보임
			}
		}//입력 끝
		
		//처리부
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1 && visited[i][j] == false) {	//안 방문한 아파트에 가면
					apt.add(dfs(i, j));						//단지 내 탐색 후 아파트 수 입력	
				}
			}
		}
		
		//단지내 아파트 수가 입력된 리스트를 정렬 후 배열로 출력
		int[] sol = apt.stream().sorted().mapToInt(Integer::intValue).toArray();
		
		//출력부
		System.out.println(sol.length);
		for(int r : sol) {
			System.out.println(r);
		}
		br.close();
	}

}
