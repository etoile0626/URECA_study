package a0217;

import java.util.*;

public class main_bj_1074_Z_홍길동 {
	static int[] di={0,0,1,1};
	static int[] dj={0,1,0,1};						//시작좌표를 중심으로 Z모양으로 순회하기 위한 좌표(0,0)->(0,1)->(1,0)->(1,1)
	static int row, col;

	static void draw(int i, int j, int cnt, int size){

		if( (row<i || i+size<=row) || (col<j || j+size<=col) ) return;		//3행을 찾아야하는데 2행에 있다던지, 즉 Z를 그릴 수 없는 상황에서는 탈출

//		System.out.printf("i : %d, j : %d, cnt : %d, size : %d, row : %d, col : %d\n", i, j, cnt, size, row, col);

		if(size==2){												//계속 분할 진행(2*2 배열이 될때까지)
			for(int d=0; d<4; d++){
				int ni=i+di[d];
				int nj=j+dj[d];										//Z모양으로 이동
				if(ni==row && nj==col) System.out.println(cnt+d);	//이동한 곳이 내가 찾는 좌표면 출력
			}
			return;
		}

		draw(i,			j,			cnt+(size/2*size/2*0),	size/2);		//cnt => 현재 회차, 몇번째 방문인지(1사분면의 시작위치의 회차 계산) 
		draw(i,			j+size/2,	cnt+(size/2*size/2*1),	size/2);
		draw(i+size/2,	j,			cnt+(size/2*size/2*2),	size/2);
		draw(i+size/2,	j+size/2,	cnt+(size/2*size/2*3),	size/2);
	} // draw

	public static void main(String args[]) throws Exception{

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		row=sc.nextInt();
		col=sc.nextInt();

		draw(0,0,0,(int)Math.pow(2,N));

		sc.close();
	} // main

} // class
