package a0218;

import java.util.*;

// BackTracking
public class Main_bj_2580_스도쿠_홍길동 {
	static int[][] a;
	static List<int[]> list;
	static boolean rtn;

	static boolean available(int r, int c, int target){			//백트래킹 적용

		for(int i=0; i<a.length; i++){ // 가로 세로에 target 값이 있는지 확인.
			if(a[i][c]==target || a[r][i]==target) return false;
		} // for

		r=r/3*3;
		c=c/3*3; // 0이 있는 좌표의 9칸 계산을 위한 r, c 초기화.

		for(int i=0; i<3; i++){ // 9칸 중에 target 값이 있는지 확인.
			for(int j=0; j<3; j++){
				if(a[r+i][c+j]==target) return false;
			} // for
		} // for

		return true;

	} // available

	static void dfs(int cnt){				//dfs를 사용하여 문제 해결

		if(rtn) return;

		if(cnt==list.size()){

			for(int[] b : a){
				for(int n : b){
					System.out.print(n+" ");
				} // for
				System.out.println();
			} // for

			rtn=true;						//조건을 만족하면 바로 나머지 재귀호출들을 끝내기 위한 플래그

			return;
		} // if

		int[] loc=list.get(cnt);
		int i=loc[0];
		int j=loc[1];						//내가 했으면 여기에 이중반복문을 썼을거같은데 그럼 시간 낭비가 심했을듯

		for(int t=1; t<10; t++){

			if(available(i,j,t)){
				a[i][j]=t;
				dfs(cnt+1);
				a[i][j]=0;					//이거 크게의미 없음, 일반적인 dfs 모습 보여주려고 넣으셨음
			} // if

		} // for

	} // dfs

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);

		a=new int[9][9];
		list=new ArrayList<>(); // 0이 있는 위치 좌표 배열 리스트.

		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				a[i][j]=sc.nextInt();
				if(a[i][j]==0) list.add(new int[]{i,j});
			} // for
		} // for

		dfs(0);

		sc.close();
	} // main

} // class

/*
0 3 5 4 6 9 2 7 8
7 8 2 1 0 5 6 0 9
0 6 0 2 7 8 1 3 5
3 2 1 0 4 6 8 9 7
8 0 4 9 1 3 5 0 6
5 9 6 8 2 0 4 1 3
9 1 7 6 5 2 0 8 0
6 0 3 7 0 1 9 5 2
2 5 8 3 9 4 7 6 0
 */
