package a0210;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest {	//순열 테스트

	static int N, R;
	static int[] input,number;
	static boolean[] isSelected;
	static int totalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();				//몇개중에
		R = sc.nextInt();				//몇개를 뽑을것이냐
		input = new int[N];
		isSelected = new boolean[N];	//이미 고른애인지 검증하는 함수
		number = new int[R];

		for (int i=0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		permutation(0);
		System.out.println("총 경우의 수 : "+totalCnt);
	}

	private static void permutation(int cnt) {// cnt: 순열을 뽑는 자리	//외우다시피해서 알아둘 것

		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}

		// 해당 자리에 뽑을 가능한 모든 수에 대해 시도(앞자리까지 선택된 수 배제)
		for (int i=0; i<N ; i++) {

			if(isSelected[i]) continue;		//이미 고른애면 탈출	

			System.out.printf("cnt : %d, i : %d ", cnt, i); //cnt번 자리를 뽑는데 i번째 
			System.out.println();

			number[cnt] = input[i];							//골라서 순열에 추가

			isSelected[i] = true;

			permutation(cnt+1); // 다음자리의 순열 뽑기

			isSelected[i] = false;	//다음 연산에 대비해서 다시 false로
		} // for

	} // main

} // class

/*
 * N : 3, R : 2, input : {0,1,2}
 * 시작 permutation(0)
 * cnt : 0, i : 0 ---> number[0]=0, isSelected[0]=true, permutation(1)
 * 		cnt : 1, i : 1 ---> number[1]=1, isSelected[1]=true, 출력 : [0, 1], isSelected[1]=false
 * 		cnt : 1, i : 2 ---> number[1]=2, isSelected[2]=true, 출력 : [0, 2], isSelected[2]=false
 * isSelected[0]=false
 * cnt : 0, i : 1 ---> number[0]=1, isSelected[1]=true, permutation(1)
 * 		cnt : 1, i : 0 ---> number[1]=0, isSelected[0]=true, 출력 : [1, 0], isSelected[0]=false
 * 		cnt : 1, i : 2 ---> number[1]=2, isSelected[2]=true, 출력 : [1, 2], isSelected[2]=false
 * isSelected[1]=false
 * cnt : 0, i : 2 ---> number[0]=2, isSelected[2]=true, permutation(1)
 * 		cnt : 1, i : 0 ---> number[1]=0, isSelected[0]=true, 출력 : [2, 0], isSelected[0]=false
 * 		cnt : 1, i : 1 ---> number[1]=1, isSelected[1]=true, 출력 : [2, 1], isSelected[1]=false
 * isSelected[2]=false
*/
