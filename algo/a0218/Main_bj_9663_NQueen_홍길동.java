package a0218;

import java.util.*;

// BackTracking
public class Main_bj_9663_NQueen_홍길동 {

	static int N, cnt, col[];
	
	static boolean promising(int i) {

		for(int j=0; j<i; j++){

			if(col[j] == col[i] || Math.abs(col[i]-col[j]) == (i-j)) {
				return false;
			} // if

		} // for

		return true;
	} // promising

	static void nqueen(int i) {

		if(!promising(i-1)) return;

		if(i==N){
			cnt++;
//			System.out.println(Arrays.toString(col));
			return;
		} // if

		for(int j=0; j<N; j++){
			col[i]=j;
			nqueen(i+1);
		} // for

	} // nqueen

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		col=new int[N];

		cnt=0;
		nqueen(0);

		System.out.println(cnt);
		sc.close();
	} // main

} // class
