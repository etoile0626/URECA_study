package a0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// DisjointSet(Union/Find)
public class Main_bj_1717_집합의표현 {

	private static int N,M;
	private static int[] parents; // parents[3]==1; --> 3번 노드의 부모는 1이다.
	private static StringBuilder builder;

	private static boolean union(int a,int b) {
		int pa = find(a);
		int pb = find(b); 
		if(pa == pb) return false;
		parents[pb] = pa;
		return true;
	} // union

	private static int find(int a) {
		if(parents[a] == a) return a; 
		return parents[a] = find(parents[a]); 		//루트를 찾으면 바로 루트 노드를 향하도록 최적화시킴
	} // find

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		} // for

//		System.out.println("start : " + Arrays.toString(parents));

		builder = new StringBuilder();
		int c,a,b;

		for(int i=0; i<M; ++i) { 
			st= new StringTokenizer(in.readLine(), " ");
			c = Integer.parseInt(st.nextToken()); // 명령구분
			a = Integer.parseInt(st.nextToken()); // a노드
			b = Integer.parseInt(st.nextToken()); // b노드

			switch(c) {
				case 0: // 두노드 합치기
					union(a,b);
					break;
				case 1: // 두노드의 루트노드 비교하기
					builder.append( (find(a)==find(b))?"YES\n":"NO\n" );
					break;
			} // switch

//			System.out.println(i + " : " + Arrays.toString(parents));
		} // for

		System.out.println(builder.toString());
	} // main

} // class

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

7 10
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
1 1 7
1 7 1
*/