package a0221;

import java.io.*;
import java.util.*;

// Dijkstra
public class Main_bj_1753_최단경로_홍길동 {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int V = Integer.parseInt(st.nextToken()); // 노드 수
		int E = Integer.parseInt(st.nextToken()); // 간선 정보 수
		int K = Integer.parseInt(br.readLine()); // 시작 정점 번호

		List<int[]>[] g = new List[V+1];
		for(int i=0; i<=V; i++) g[i]=new ArrayList<int[]>();

		for(int i=0; i<E; i++){
			st=new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			g[u].add(new int[]{v,w}); // 단방향
		} // for

//		for(int i=1; i<=V; i++) {
//			System.out.print(i + " : ");
//			for(int[] tmpArr : g[i]) {
//				System.out.print(Arrays.toString(tmpArr));
//			} // for
//			System.out.println();
//		} // for
//		System.out.println();

		boolean[] visited = new boolean[V+1];
		int[] minEdge = new int[V+1];
		for(int i=0; i<=V; i++) minEdge[i]=987654321;

		minEdge[K] = 0;
		for(int i=1; i<=V; i++){
			int min = Integer.MAX_VALUE;
			int minVertex = -1;

			for(int j=1; j<=V; j++){
				if(!visited[j] && min > minEdge[j]){
					min = minEdge[j];
					minVertex = j;
				}
			} // for

			if(minVertex == -1) break;
			visited[minVertex]=true;

			for(int[] j:g[minVertex]){
				if(!visited[j[0]] && minEdge[j[0]]>min+j[1]){
					minEdge[j[0]] = min+j[1];
				}
			} // for
		} // for

		for(int i=1; i<=V; i++){
			if(minEdge[i]==987654321)	System.out.println("INF");
			else						System.out.println(minEdge[i]);
		} // for

		br.close();
	} // main

} // class

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/
