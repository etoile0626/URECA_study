package a0212;

// 셸정렬(버전 2 : h = …, 40, 13, 4, 1)

import java.util.Scanner;

class ShellSort2 {
	//--- 셸 정렬 ---//
	static void shellSort(int[] a, int n) {
		int h;
		for (h = 1; h < n; h = h * 3 + 1)
			;

		for ( ; h > 0; h /= 3)
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				System.out.printf("h : %d, i : %d, tmp : %d, ", h, i, tmp);
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
					a[j + h] = a[j];
					System.out.printf("j : %d, ", j);
				}
				a[j + h] = tmp;
				System.out.printf("tmp : %d\n", tmp);
			}
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("셸 정렬(버전 2)");
		System.out.print("요솟수: ");
		int nx = stdIn.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = stdIn.nextInt();
		}

		shellSort(x, nx);			// 배열 x를 셸정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);

		stdIn.close();
	} // main

}
