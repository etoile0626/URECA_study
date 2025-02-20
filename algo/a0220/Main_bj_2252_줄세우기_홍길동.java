package a0220;

import java.util.*;

// Kruskal
public class Main_bj_2252_줄세우기_홍길동{
	static int N, M; // N : 노드의 수. M : 간선의 수.
	static int inDegree[]; // inDegree[3]==2; --> 3번 노드는 출력 순서가 0, 1, 2에서 2에 위치이다.
	static List<Integer>[] g; // g[1]==3; --> 1번 노드가 3번 노드의 앞에 위치한다.
	
	static void bfs(){
		Queue<Integer> q=new ArrayDeque<Integer>();

		for(int i=1; i<=N; i++){
			if(inDegree[i]==0) q.offer(i);					//0번쨰 순서(가장 앞에 와야하는 애들)인 값을 큐에 넣기
		} // for

		while(!q.isEmpty()){

//			System.out.println("\nq : " + q);

			int cur=q.poll();
			System.out.print(cur+" ");						//큐에서 꺼낸에 줄 세우기

			for(int nxt : g[cur]){							//방금 줄 세운에보다 큰 애들 중에서
				if(--inDegree[nxt]==0) q.offer(nxt);		//다음으로 와야하는 애가 있으면 큐에 넣기
			} // for
		} // while
	} // bfs

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);

		N=sc.nextInt();
		M=sc.nextInt();
		g=new List[N+1];
		inDegree=new int[N+1];

		for(int i=1; i<N+1; i++) {
			g[i]=new ArrayList<>();
		} // for

		for(int i=0; i<M; i++){
			int a=sc.nextInt();
			int b=sc.nextInt();
			g[a].add(b);
			inDegree[b]++;
		} // for

//		System.out.println("g : " + Arrays.toString(g));
//		System.out.println("inDegree : " + Arrays.toString(inDegree));

		bfs();

		sc.close();
	} // main

} // class

/*
3 2
1 3
2 3
*/
