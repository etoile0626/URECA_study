package a0224;

import java.util.Arrays;
import java.util.Scanner;

public class Main_bj_2579_계단오르기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt(); // 계단의 개수
		int max[] = new int[n+1];
		int arr[] = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = scan.nextInt();
		}

		max[1] = arr[1];
		if (2<=n) max[2] = arr[1]+arr[2];
		if (3<=n) max[3] = (arr[1] >= arr[2] ? arr[1] : arr[2]) + arr[3];
		for (int j = 4; j <= n; j++) {
			int a = max[j-2] + arr[j];
			int b = max[j-3] + arr[j-1] + arr[j];
			max[j] = a >= b ? a : b;
		}

//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(max));

		System.out.println(max[n]);
	} // main

} // class

/*
6
10
20
15
25
10
20
*/
