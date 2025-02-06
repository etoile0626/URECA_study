package a0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//수도코드
/*
 * 회의의 수, 회의 시간들 입력
 * 받은 회의 시간들을 비교
 * 가장 짧으면서 이른 시간에 시작하는 회의부터 회의를 구성 => 회의의 최대 개수가 될 것으로 예상
 * 주의할점 : 회의 시간이 24시간이 아님, 0 ~ 2^31-1 / 시작하자마자 끝나는 회의도 존재
 */
/*
 * 다른 분 풀이
 * 종료 시간을 기준으로 정렬, 가장 낮은 값부터 고른다. <- 그리드 알고리즘?
 */
public class Main_BJ1931 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n= Integer.parseInt(br.readLine());		//N
		
		int []table[] = new int[n][2];				//회의시간이 담긴 테이블
		int[] time = new int[2];					//현재 진행중인 회의시간
		int count;								//최대 회의 개수
		
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			table[i][0] = start;
			table[i][1] = end;						//시작과 끝 입력
		}//입력 끝
		
		//처리 시작
		Arrays.sort(table, (o1, o2) -> o1[1] == o2[1]? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
		
		time = table[0];	//정렬되었으므로 첫번째 것 선택해 회의
		count = 1;				//선택했으므로 count값 증가
		for(int i = 0; i < n; i++) {
			if(time[1] <= table[i][0]) {
				time = table[i];		//현재 회의가 끝나고서 가장 빠른 회의 선택
				count++;
			}
		}
		
		System.out.println(count);
		br.close();
	}
}
