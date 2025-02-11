package a0211.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ2961_최윤제 {
	static int n, totalS, totalB, cook; 	// 재료, 최종적인 신맛, 최종적인 쓴맛, 요리
	static int[] s, b;						// 신맛(곱), 쓴맛(합)
	static boolean[] isSelected; 			//재료 선택 여부
	
	private static void subSet(int cnt) {	//cnt =depth(깊이)
		if(cnt == n) {						//n개의 재료의 선택 여부가 끝났다면
			totalS = 1;
			totalB = 0;						//값 초기화
			
			for(int i = 0; i < n; i++) {	//고른 재료들의 신맛 쓴맛 계산
				if(isSelected[i]) {
					totalS *= s[i];
					totalB += b[i]; 
				}
			}
			
			if(totalB == 0) {				//재료가 하나도 선택 되지 않은 경우는 스킵
				return;
			}
			
			cook = Math.min(cook, Math.abs(totalS-totalB)); //기존 cook에 저장된 값과 지금 만든 요리의 값 중 최솟값 정하기
			
			return;
		}
		
		isSelected[cnt]	= true;			//cnt번째 재료를 포함하겠다
		subSet(cnt+1);
			
		isSelected[cnt]	= false;		//cnt번째 재료를 포함하지 않겠다
		subSet(cnt+1);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		s = new int[n];
		b = new int[n];
		isSelected = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		cook = 999999999;				//임시로 입력, Integer.maxValue()를 넣는것도 방법일듯
		subSet(0);
		
		System.out.println(cook);
		
		br.close();
	}
}
/*
 * 2
 * 3 8
 * 5 8
 * subset(0,1,0)
 * 		subset(1,3,8)
 * 			subset(2,15,16) ---> min = 1; ---> return;
 * 			하단 subset(2,3,8) ---> return;
 * 		하단 subset(1,1,0)
 * 			subset(2,5,8) ---> return;
 * 			하단 subset(2,1,0) ---> return;
 */