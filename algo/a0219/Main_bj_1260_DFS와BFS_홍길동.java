package a0219;

import java.util.*;

// Graph
public class Main_bj_1260_DFS와BFS_홍길동 {
	static int N;
	static int[][] graph;
	static boolean[] visited;
	static StringBuilder sb;

	static void dfs(int node){
		visited[node] = true;
		sb.append(node+" ");

		for(int next=1; next<=N; next++){
			if(!visited[next] && graph[node][next] == 1){
				dfs(next);
			} // if
		} // for
	} // dfs

	static void bfs(int node){
		Queue<Integer> q = new ArrayDeque<Integer>();
		visited[node] = true;
		q.offer(node);

		while(!q.isEmpty()){
			node=q.poll();
			sb.append(node+" ");

			for(int next=1; next<=N; next++){
				if(!visited[next] && graph[node][next] == 1){
					visited[next]=true;
					q.offer(next);
				} // if
			} // for

		} // while
	} // bfs

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();
		int start = sc.nextInt();

		graph = new int[N+1][N+1];
		for(int i=0; i<M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();			
			graph[a][b] = graph[b][a] = 1;
		}

		visited=new boolean[N+1];
		sb=new StringBuilder();
		dfs(start);
		System.out.println(sb);
		
		visited=new boolean[N+1];
		sb=new StringBuilder();
		bfs(start);
		System.out.println(sb);
		
		sc.close();
	} // main

} // class
