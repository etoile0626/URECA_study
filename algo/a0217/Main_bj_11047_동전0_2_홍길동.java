package a0217;

import java.io.*;
import java.util.*;

public class Main_bj_11047_동전0_2_홍길동 {

	public static void main(String args[]) throws Exception{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());

		int[] coin=new int[N];
		for(int i=0; i<N; i++){
			coin[i]=Integer.parseInt(br.readLine());
		}

		for(int i = 0; i<coin.length; i++) {		//동전끼리의 배수 관계를 이용해서 coin 배열을 배수 관계로 만드는 로직 

			if((K % coin[i])!=0) break;

			K = K / coin[i];

			//System.out.printf("coin : %d, K : %d\n", coin[i], K);

			for (int j = i+1; j<coin.length; j++) {
				coin[j] = (coin[j] / coin[i]);
			} // for

			coin[i] = 1;

			System.out.println(Arrays.toString(coin));
		} // for

		int min=0;
		for(int i=N-1; i>=0; i--){
			if(K>=coin[i]){
			   min+=K/coin[i];
			   K=K%coin[i];
			}
		} // for

		System.out.println(min);
		br.close();
	} // main

} // class

/*
3 800
100
400
500
 */