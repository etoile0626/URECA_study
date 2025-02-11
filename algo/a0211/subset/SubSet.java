package a0211.subset;

import java.util.Scanner;

public class SubSet {							//부분집합

	static int N, totalCnt;
	static int[] input;
	static boolean[] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		generateSubset(0);
		System.out.println("총 경우의 수 : "+totalCnt);

		sc.close();
	}

	private static void generateSubset(int cnt) {			//부분집합을 구하는 recursion(재귀)
		//부분집합 => 해당 원소를 고르거나/고르지 않거나로 생각 가능
		if(cnt == N) {										//출력파트(cnt가 N이 될 때)
			totalCnt++;
			for (int i = 0; i < N; i++) {
				//isSelected가 참일때만 고른 것으로 생각
				System.out.print((isSelected[i]?input[i]:"X")+"\t"); 
			}
			System.out.println();
			return;
		}

		// 부분집합에 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt+1);

		// 부분집합에 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}

}

/*
 * N == 3, input = {0,1,2};
 * generateSubset(0)
 * 	isSelected[0] = true; generateSubset(1);
 * 		isSelected[1] = true; generateSubset(2);  [0, 1, ?]
 * 			isSelected[2] = true; [0,1,2] 출력, isSelected[2] = false; [0,1,X] 출력
 * 		isSelected[1] = false; generateSubset(2); [0, X, ?]
 * 			isSelected[2] = true; [0,X,2] 출력, isSelected[2] = false; [0,X,X] 출력
 * 	isSelected[0] = false; generateSubset(1);
 * 		isSelected[1] = true; generateSubset(2);  [X, 1, ?]
 * 			isSelected[2] = true; [X,1,2] 출력, isSelected[2] = false; [X,1,X] 출력
 * 		isSelected[1] = false; generateSubset(2); [X, X, ?]
 * 			isSelected[2] = true; [X,X,2] 출력, isSelected[2] = false; [X,X,X] 출력
 */
