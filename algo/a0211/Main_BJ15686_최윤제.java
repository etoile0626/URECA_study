package a0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * n*n배열의 도시에 빈칸(=0),치킨집(=2),집(=1)이 존재
 * 치킨 거리 = 집과 가장 가까운 치킨집의 거리
 * 각각의 집은 치킨 거리를 가지고 있음, 도시의 치킨 거리 = 존재하는 모든 치킨 거리의 합
 * m개를 제외하고 치킨 집을 전부 없애고자 할 때, 도시의 치킨 거리가 가장 작게 되는 경우를 구하기
 */
//강사님 코드 참고
public class Main_BJ15686_최윤제 {						//백준 치킨 배달
	static int n, m, cityLen = 987654321;//입력값 n, m, 도시의 치킨 거리			
	static List<int[]> chicken = new ArrayList<>();			//치킨집
	static List<int[]> house = new ArrayList<>();			//집		=>배열리스트 배열을 쓴게 키포인트!
	static int choise[];							//고른 치킨집들 목록
	
	private static void combination(int cnt, int cur) {
		if(cnt == m) {
			int sum = 0;
			for(int i = 0; i < house.size(); i++) {			//도시의 치킨거리 구하기
			
				int dist = 987654321;						//집 하나의 치킨 거리	
				for(int j =0; j < m; j++) {			//집 하나의 치킨 거리 계산(집 a와 치킨집1~m개 사이의 거리의 최솟값)
					dist = Math.min(dist, Math.abs(house.get(i)[0]-chicken.get(choise[j])[0])+ 
													Math.abs(house.get(i)[1]-chicken.get(choise[j])[1]));
				}
				sum += dist;
			}
			cityLen = Math.min(cityLen, sum);				//도시의 치킨 거리의 최솟값
			return;
		}
		
		for(int i = cur; i < chicken.size(); i++) {
			
			choise[cnt] = i;						//치킨집 중 m개를 골라 len 배열에 저장하겠다
			combination(cnt+1, i+1);
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int a = Integer.parseInt(st.nextToken());	//입력부, 굳이 지도를 전부 저장안하고 치킨집과 집의 좌표만 알면 되더라 
				if(a == 2) {
					chicken.add(new int[] {i, j});					//지도에 있는 치킨집 값 증가
				}
				else if(a == 1) {
					house.add(new int[] {i, j});					//지도에 있는 집 값 증가
				}
			}
		}	
		choise = new int[m];
		
		combination(0,0);
		
		
		br.close();
	}
}
