package a0218;

import java.util.*;

// BackTracking
public class Main_bj_16234_인구이동_홍길동{

	static int[] di={-1,1,0,0}; // 사방 탐색 좌표를 만들기 위한 배열
	static int[] dj={0,0,1,-1};

	static int N, L, R; // N : 배열 크기, L : Left 값, R : Right 값
	static int[][] map; // 초기 Data 배열
	static boolean[][] visit; // 초기 Data 배열의 방문 기록을 위한 배열

	static int time; // 반복 회차
	static int sum; // 평균 값 측정을 위한 합계
	static List<int[]> p; // 합계 대상 좌표 저장을 위한 리스트

	static boolean chk; // while문 탈출 조건

	static void bfs(int i,int j){

		Queue<int[]> q=new ArrayDeque<int[]>();
		visit[i][j]=true;	 
		q.offer(new int[]{i,j});
		sum=map[i][j];
		p.add(new int[]{i,j});

		while(!q.isEmpty()){

			int[] ij=q.poll();
			i=ij[0];
			j=ij[1];

			for(int d=0; d<4; d++){

				int ni=i+di[d];
				int nj=j+dj[d];

				if(ni<0 || N<=ni || nj<0 || N<=nj || visit[ni][nj]) continue;

				int diff = Math.abs(map[i][j]-map[ni][nj]);

				if( L <= diff && diff <= R ){  
					chk=true;
					visit[ni][nj]=true;
					q.offer(new int[]{ni,nj});
					sum+=map[ni][nj];
					p.add(new int[]{ni,nj});
				} // if

			} // for

		} // while

	} // bfs

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);

		N=sc.nextInt();
		L=sc.nextInt();
		R=sc.nextInt();

		map=new int[N][N];		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
			} // for
		} // for
		
		time=0;
		chk=true;

		while(chk){
			chk=false; 
			visit=new boolean[N][N];
			time++;

			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){

					if(visit[i][j]) continue;

					sum=0;
					p=new ArrayList<int[]>();

					bfs(i,j);

					int avr=sum/p.size();
					for(int[] ij : p) {
						map[ij[0]][ij[1]] = avr;
					} // for

				} // for
			} // for

//			System.out.println("===========");
//			for(int[] ij : map) {
//				System.out.println( Arrays.toString(ij) );
//			} // for
//			System.out.println("===========");

		} // while

		System.out.println(time-1);
		sc.close();
	} // main

} // class

/*
3 5 10
10 15 20
20 30 25
40 22 10
*/
