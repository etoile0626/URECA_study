package a0219;

import java.io.*;
import java.util.*;

// Graph - BFS
public class Main_bj_2178_미로탐색_홍길동 {

	static int[] di={-1,1,0,0};
	static int[] dj={0,0,-1,1};
	static int N,M;
	static int[][] maze;
	static boolean[][] visited;

	static void bfs(int i, int j){
		Queue<int[]> q=new ArrayDeque<>();
		visited[i][j]=true;
		q.offer(new int[]{i,j});

		while(!q.isEmpty()){
			int[] ij=q.poll();
			i=ij[0];
			j=ij[1];

			for(int d=0; d<4; d++){
				int ni=i+di[d];
				int nj=j+dj[d];

				if(0<=ni && ni<N && 0<=nj && nj<M){
					if(!visited[ni][nj] && maze[ni][nj]!=0){
						maze[ni][nj]=maze[i][j]+1;
						visited[ni][nj]=true;
						q.offer(new int[]{ni,nj});
					} // if
				} // if
			} // for
		} // while
	} // bfs

	public static void main(String args[]) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		maze=new int[N][M];
		visited=new boolean[N][M];

		for(int i=0; i<N; i++){
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			for(int j=0; j<M; j++){
				maze[i][j]=s.charAt(j)-'0';
			}
		}

		bfs(0,0);

		for(int [] tmpArr : maze) {
			System.out.println( Arrays.toString(tmpArr) );
		}

		System.out.println(maze[N-1][M-1]);
		br.close();
	} // main

} // class

/*
4 6
101111
101010
101011
111011

7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
*/
