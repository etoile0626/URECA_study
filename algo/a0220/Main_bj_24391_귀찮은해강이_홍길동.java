package a0220;

import java.util.*;

public class Main_bj_24391_귀찮은해강이_홍길동 {
	static int[] parents;

	static int find(int a){
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}	

	static void union(int a, int b){
		int pa = find(a), pb = find(b);
		parents[pa] = pb;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}

		for(int i=0; i<M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a,b);
		}

		int[] a=new int[N];
		for(int i=0; i<N; i++) {
			a[i]=sc.nextInt();
		}

//		System.out.println("after union : " + Arrays.toString(parents));

		int cnt=0;
		for(int i=0; i<N-1; i++){
			if(find(a[i]) != find(a[i+1])) cnt++;
		}

		System.out.println(cnt);
		sc.close();
	} // main

} // class

/*
5 3
1 3
2 5
3 4
1 2 3 5 4
*/
