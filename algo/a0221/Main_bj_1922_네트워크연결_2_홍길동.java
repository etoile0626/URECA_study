package a0221;

import java.util.*;

// Dijkstra, Bellman-Ford, Prim,  Kruskal	
public class Main_bj_1922_네트워크연결_2_홍길동 {							//정석이긴한데 우선순위 큐를 사용함

	public static void main(String args[]) throws Exception{
		Scanner sc=new Scanner(System.in);

		int V=sc.nextInt();
		int E=sc.nextInt();

		List<int[]>[] g=new List[V+1];
		for(int i=1; i<=V; i++) g[i]=new ArrayList<>();

		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			g[a].add(new int[]{b,c});
			g[b].add(new int[]{a,c});
		} // for

		boolean[] visited=new boolean[V+1];
		int[] minEdge=new int[V+1];
		for(int i=1; i<=V; i++) minEdge[i]=Integer.MAX_VALUE;
		
		//우선순위 큐를 사용해서 가중치 값을 정렬하면 더 빠르고 날먹이더라
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1],o2[1]));

		int sum=0,cnt=0;
		minEdge[0]=0;	
		pq.offer(new int[]{1,0});			//시작노드 1번에 가중치 0으로 넣음

		while(!pq.isEmpty()){			//흐름도 1번 코드랑 같음
			int[] cur=pq.poll();
			int minVertex=cur[0];			//다음 노드
			int min=cur[1];					//다음 노드의 가중치
			if(visited[minVertex]) continue;	//방문한 애면 큐의 다음 애로	   

			visited[minVertex]=true; 			//방문 안했던 애면 방문처리
			sum+=min;   
			if(cnt++ == V) break;  				//n-1번 반복시 탈출

			for(int[] nx : g[minVertex]){ 		//다음 큐에 넣을거 탐색
				if(!visited[nx[0]] && minEdge[nx[0]]>nx[1]){
					minEdge[nx[0]]=nx[1];
					pq.offer(new int[]{nx[0],minEdge[nx[0]]});
				} // if
			} // for
		} // while

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
