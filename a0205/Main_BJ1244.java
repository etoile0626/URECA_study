package a0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ1244 {
	public static int turn(int num) {		//0이면 1로, 1이면 0으로 바꿔주는 메소드
		return 1-num;	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	//스위치 개수 입력
		
		st = new StringTokenizer(br.readLine());
		int[] switches = new int[n];				//n만큼의 크기를 가진 스위치 배열
		for(int i =0; i < n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());	//스위치 정보 입력
		}
		
		int studentNum = Integer.parseInt(br.readLine()); //학생수 입력
		for(int i =0; i < studentNum; i++) {			//
			st = new StringTokenizer(br.readLine());	
			int gender = Integer.parseInt(st.nextToken());		//성별
			int switchNum = Integer.parseInt(st.nextToken());	//스위치 번호 확인
			
			if(gender == 1) {				//학생이 남자라면 자신의 번호의 배수인 스위치들 변경
				 int j = 1;
				 while(n > switchNum * j - 1) {		
					 switches[switchNum * j - 1] = turn(switches[switchNum * j - 1]);	//스위치 변경
					 j++;
				 }
			}
			
			else if(gender == 2) {			//여자라면 좌우가 대칭인 최대한 많은 스위치들을 변경(없으면 해당 번호만)
				int left = switchNum-2;
				int right = switchNum;
				while(right < n && left >= 0) {	//배열 인덱스 범위 안에 있는 경우만 반복
					if(switches[left] != switches[right]) {	//대칭아니면 탈출
						break;
					}
					left--;
					right++;
				}
				left++;
				right--;	//좌우대칭인 애들까지만 범위로
				
				for(int j = left; j <=right; j++) {
					switches[j] = turn(switches[j]);
				}
			}
		}
		
		//스위치 출력
		for(int i = 0 ; i < switches.length; i++) {
			if(i % 20 == 0 && i != 0) {		//20개 넘어가면 줄바꿈
				System.out.println();
			}
			System.out.print(switches[i] + " ");
		}

	}

}
