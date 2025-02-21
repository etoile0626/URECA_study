package a0221;

import java.io.*;
import java.util.*;

// Kruskal
public class Main_bj_1197_최소스패닝트리_홍길동 {
	static List<int[]> g;
	static int V, E, p[];						//노드, 간선, 부모배열

	static int find(int a){
		if(p[a]==a) return a;
		return p[a]=find(p[a]);
	} // find

	static boolean union(int a, int b){
		a=find(a);
		b=find(b);
		if(a==b) return false;
		p[a]=b;
		return true;
	} // union

	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken()); 

		g=new ArrayList<>();
		for(int i=0; i<E; i++){
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			g.add(new int[]{a,b,c});
		} // for

		p=new int[V+1];			
		for(int i=1; i<=V; i++) p[i]=i;

		Collections.sort(g, (o1,o2)->Integer.compare(o1[2],o2[2]));

//		for(int[] tmpArr : g){
//			System.out.println( Arrays.toString(tmpArr) );
//		} // for

		int sum=0;
		for(int[] e : g){
			if( union( e[0], e[1] ) ){
//				System.out.println( Arrays.toString(p) );
				sum+=e[2];
			} // if
		} // for

		System.out.println(sum);
		br.close();
	} // main

} // class

/*
3 3
1 2 1
2 3 2
1 3 3
*/
