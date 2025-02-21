package a0221;

import java.util.*;

// Dijkstra
public class Main_bj_4485_녹색옷입은애가젤다지_홍길동{

	static int[] di={0,1,0,-1};
	static int[] dj={1,0,-1,0};
	static int[][] map, dst;
	static boolean[][] visit;

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);

		int tc=0;
		while(++tc>0){
			int N=sc.nextInt();
			if(N==0) break;

			map=new int[N][N];
			visit=new boolean[N][N];
			dst=new int[N][N];

			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					map[i][j]=sc.nextInt();
					dst[i][j]=987654321;
				} // for
			} // for

			dst[0][0]=map[0][0];
			for(int k=0; k<N*N; k++){
				int min=987654321;
				int mi=0;
				int mj=0;

				for(int i=0; i<N; i++){
					for(int j=0; j<N; j++){
						if(!visit[i][j] && min>dst[i][j]){
							min=dst[i][j];
							mi=i;
							mj=j;
						} // if
					} // for
				} // for

				visit[mi][mj]=true;
				if(mi==N-1 && mj==N-1) break;

				for(int d=0; d<4; d++){
					int ni = mi+di[d];
					int nj = mj+dj[d];
					if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
					if(dst[ni][nj] > min + map[ni][nj]){
					   dst[ni][nj] = min + map[ni][nj];	 //dst 배열에 i,j까지 왔을때 걸린 최소 비용을 dst[i][j]에 넣음
					} // if
				} // for
			} // for

			System.out.println("Problem "+tc+": "+dst[N-1][N-1]);
		} // while

		sc.close();
	} // main

} // class

/*
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
0
*/
