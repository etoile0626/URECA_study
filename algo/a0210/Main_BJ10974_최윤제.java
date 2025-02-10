package a0210;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 강사님의 순열 뽑는 메소드를 참고하였음.
 */
public class Main_BJ10974_최윤제 {
	static int n;
	static int[] number;
	static boolean[] isSelected;
	
	private static void permutation(int cnt) {
		if (cnt == n) {
			
			//출력부를 좀 더 개선할 수는 없을까
			String str = Arrays.toString(number).replace(",", "");	//, 제거
			str = str.replace("[", "");								
			str = str.replace("]", "");								//대괄호 제거
			System.out.println(str);
			return;
		}
		
		for(int i = 0; i < n; i++) {	
			
			if(isSelected[i]) {
				continue;
			}
			
			number[cnt] = i+1;			//고르지 않았던 애라면 골라서 배열에 담기
			
			isSelected[i] = true;
			
			permutation(cnt + 1);		//다음 자리 순열 찾기
			
			isSelected[i] = false;		//다음번을 위해 다시 false로 초기화
		}
		
	}
	public static void main(String[] args) {	//모든 순열구하기
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();				//입력부, n개 중에 n개를 순서 있게 뽑아보자
		
		isSelected = new boolean[n];	//이미 고른애인지 검증하는 함수
		number = new int[n];
		
		permutation(0);					//0번째 자리부터 순열 뽑아보기
	}

}