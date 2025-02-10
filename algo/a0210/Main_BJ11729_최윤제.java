package a0210;

import java.util.Scanner;

//하노이 함수 안에 재귀호출 부분은 공식처럼 외워두면 좋음!!
public class Main_BJ11729_최윤제 {
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	//교수님 풀이
	private static void hanoi(int n, int a, int temp, int b) {	//n개의 원반을 a에서 b로 옮긴다?(+temp를 임시로 이용해서)
		if(n == 0) return;				//옮길 원판이 없으면 탈출 (함수 호출을 안 한 것으로 취급)
		
		++cnt;						//함수 호출될때마다 옮긴횟수 증가
		hanoi(n-1, a, b, temp);		//n번째 원판을 제외한 n-1개를 a(1)->temp(2)로 기둥 이동, 임시 기둥으로 b(3)를 이용
		
		sb.append(a+" "+b+"\n");	//원판 이동
		//===============여기 윗 부분이 n-1개의 원판을 temp 기둥으로 옮기는 과정, 그 후 1에 있던 원판 n을 3으로===================
		hanoi(n-1, temp, a, b);		//(n-1)개를 temp(2)에서 b(3)로 이동, 임시 기둥으로 a(1)를 사용
		//===============여기 윗 부분이 temp에 있던 n-1개의 원판을 목적지인 b 기둥으로 옮기는 과정===================
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		hanoi(n, 1, 2, 3);
		
		System.out.println(cnt);
		System.out.println(sb.toString());

	}

}
