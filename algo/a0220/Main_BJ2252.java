package a0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N명의 학생들을 키 순으로 세우기(1번~N번)
 * 두 학생의 키를 비교하면서 세움, 일부 학생들만 비교
 * A와 B를 비교했다면 A는 B의 앞으로 와야한다				==> 방향그래프로 생각?
 * 답이 여러개면 아무거나 출력
 */
//그리디 알고리즘으로 크루스칼 알고리즘을 해볼 수 있는 예제??
public class Main_BJ2252 {						//줄 세우기 =>어려움, 못 풀었음 강사님 코드 보고 공부하기

	static int n, m;
	static int[] degree;						//i번 학생은 0~n-1번의 순서 중 degree[i]번째에 있어야한다
	static ArrayList<Integer>[] students;		//키 비교 정보
	static StringBuilder sb;
	
	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		
		for(int i = 1; i <= n; i++) {
			if(degree[i] == 0) {				//남은 학생들 중 가장 앞에 와야하는 애들은 큐에 넣기
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur + " ");				//큐에서 하나 뽑아서 앞에 줄 세우기
		
			for(int i = 0; i < students[cur].size(); i++) {	//뽑아온 애보다 큰 애들 중에서
				if(--degree[students[cur].get(i)] == 0) {	//하나 뽑아서 줄 세웠으므로 남은 애들 값은 하나 감소시킴
					q.offer(students[cur].get(i));			//남은 애들 중 먼저 오는 애가 있으면 큐에 넣기
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		degree = new int[n+1];					
		students = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			students[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			students[node1].add(node2);
			degree[node2]++;					//node2는 node1보다 뒤에 있어야하므로 그만큼 뒤로가기(출력 순서를 저장하는 개념)
		}
		
		bfs();
		
		System.out.println(sb.toString());
	}
}
