package a0221;

import java.util.*;

// Dijkstra, Bellman-Ford, Prim,  Kruskal
public class Main_bj_1922_네트워크연결_1_홍길동 {					//인접리스트와 다익스트라를 적용한 정석 풀이

	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);

		int V = sc.nextInt();
		int E = sc.nextInt();

		List<int[]>[] g = new List[V+1];
		for(int i=1; i<=V; i++) g[i] = new ArrayList<>();

		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			g[a].add(new int[]{b,c});
			g[b].add(new int[]{a,c});
		} // for

//		for(int i=1; i<=V; i++) {
//			System.out.print(i + " : ");
//			for(int[] tmpArr : g[i]) {
//				System.out.print(Arrays.toString(tmpArr));
//			} // for
//			System.out.println();
//		} // for
//		System.out.println();

		boolean[] visited=new boolean[V+1];
		int[] minEdge=new int[V+1];
		for(int i=1; i<=V; i++) minEdge[i]=Integer.MAX_VALUE; 

		int sum=0,cnt=0;
		minEdge[1]=0;										//출발번지는 0으로
		for(int i=1; i<=V; i++){
			int minVertex=-1;								//최소 노드, 즉 다음으로 갈 가중치가 가장 작은 노드
			int min=Integer.MAX_VALUE/2; 					//minEdge보다 크면 minEdge값을 min에 넣음

			for(int j=1; j<=V; j++){ 
				if(!visited[j] &&  min>minEdge[j]){			//최소 가중치가 갱신된 애들이 있으면 
			   		minVertex=j;							//거기로 연결(방문처리) 후 최솟값 갱신
					min=minEdge[j];
//					System.out.printf("i : %d, j : %d, min : %d\n", i, j, min);
				} // if
			} // for
			
			visited[minVertex]=true;						//방문처리
			sum+=min;										//최종값에 더해줌
			if(cnt++ == V) break;							//n-1번 반복했으면 탈출

//			System.out.println(sum + " : " + Arrays.toString(visited));

			for(int[] nx : g[minVertex]){ 
				if(!visited[nx[0]] && minEdge[nx[0]]>nx[1]){	//다음으로 가고자 할 노드의 최소 가중치보다 지금 보고 있는 간선의 가중치가 더 작으면 
					minEdge[nx[0]]=nx[1];						//다음 노드의 최소 가중치 갱신(다음 반복문에서 다음노드로 갈 수 있도록)
//					System.out.printf("nx[0] : %d, minEdge[nx[0]] : %d\n", nx[0], minEdge[nx[0]]);
				} // if
			} // for
//			System.out.println();
		} // for

		System.out.println(sum);
		sc.close();
	} // main

} // class

/*
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8
*/
