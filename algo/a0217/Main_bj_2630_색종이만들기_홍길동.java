package a0217;

import java.util.*;

public class Main_bj_2630_색종이만들기_홍길동 {
	static int n, cnt0=0, cnt1=0;
	static int[][] a;

	static void paper(int i,int j,int n){
		int sum=0;
		for(int row=i; row<i+n; row++){
			for(int col=j; col<j+n; col++){
				sum+=a[row][col];
			}
		}		
		if(sum==n*n) { // 전부 1인 경우.
			cnt1++;
		} else if(sum==0  ) { // 전부 0인 경우.
			cnt0++;
		} else{ // 전부 1도, 전부 0도 아니면, 4분할.
			paper(i,         j, n/2);
			paper(i+n/2,     j, n/2);
			paper(i,     j+n/2, n/2);
			paper(i+n/2, j+n/2, n/2);
		} // if
	} // paper

	public static void main(String[] args) throws Exception {

		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		a=new int[n][n];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				a[i][j]=sc.nextInt();
			}
		}		

		paper(0,0,n);

		System.out.println(cnt0);
		System.out.println(cnt1);
		sc.close();
	} // main

} // class
