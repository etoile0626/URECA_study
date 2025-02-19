package a0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 그래프를 DFS와 BFS로 탐색하여 그 결과 출력하기
 * 방문 가능 노드가 여러개면 노드 번호가 작은 것부터, 노드 번호는 1~N번
 * **간선은 양방향임!!!
 */
public class Main_BJ1260 {										//DFS와 BFS
	static int n, m, v;
	static ArrayList<Integer>[] graph;	// 인접리스트 배열
	static boolean [] visit;			//방문 확인용
	static StringBuilder sb1, sb2;

	private static void dfs(int v1) {
		
		visit[v1] = true;
		sb1.append(v1+" ");
		
		for(int i = 0; i < graph[v1].size(); i++) {
			int v2 = graph[v1].get(i);
			if(!visit[v2]) {
				dfs(v2);
			}
		}
	}
	
	private static void bfs(int v1) {
		Queue<Integer> q = new ArrayDeque<>();			//LinkedList보다 속도가 빨라 ArrayDeque 사용
		
		q.add(v1);
		visit[v1] = true;
		
		while(!q.isEmpty()) {
			int v2 = q.poll();
			 
			sb2.append(v2+" ");
			 
			for(int i = 0; i < graph[v2].size(); i++) {
				int v3 = graph[v2].get(i);
				if(!visit[v3]) {
					visit[v3] = true;
					q.add(v3);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb1 = new StringBuilder();								//dfs 결과 출력용
		sb2 = new StringBuilder();								//bfs 결과 출력용

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];						//리스트 배열, 0번지 버리고 1번지부터 N번지까지 쓸거임
		for(int i = 0; i < n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph[n1].add(n2);								//n1->n2간선 리스트에 추가
			graph[n2].add(n1);								//양방향(무방향) 그래프라 그 반대도 추가
		}
		
		for(int i = 0; i < graph.length; i++) {
			Collections.sort(graph[i]);
		}												//노드 번호 낮은애부터 찾을 수 있게 미리 정렬
		
		visit = new boolean[n+1];						//그래프랑 같이 1~n
		dfs(v);
		
		visit = new boolean[n+1];						//그래프랑 같이 1~n, dfs에서 한 번 썼으니까 초기화
		bfs(v);

		System.out.println(sb1.toString());
		System.out.println(sb2.toString());
	}
}
