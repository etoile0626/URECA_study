package a0219;

import java.util.*;

//Graph - DFS
public class Main_bj_2606_바이러스_홍길동{
	static List<Integer>[] com;
	static boolean[] visit;

	static void dfs(int node){
		visit[node]=true;
		for(int x : com[node]){
			if(!visit[x]){ 
				dfs(x);
			} // if
		} // for
	} // dfs

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);

		int n=sc.nextInt();
		int pair=sc.nextInt();
		visit=new boolean[n+1]; 
		com=new ArrayList[n+1];

		for(int i=1; i<=n; i++){
			com[i]=new ArrayList<Integer>();
		} // for

		for(int i=1; i<=pair; i++){
			int node=sc.nextInt();
			int sub=sc.nextInt();
			com[node].add(sub);
			com[sub].add(node);
		} // for

		dfs(1);

		int count=0;
		for(int i=2; i<=visit.length-1; i++){
			if(visit[i]) count++;
		} // for

		System.out.println(count);
		sc.close();
	} // main

} // class
