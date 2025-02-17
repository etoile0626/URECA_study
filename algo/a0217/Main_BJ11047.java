package a0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N종류의 동전을 이용해 K원을 만들려고 할때, 동전개수의 최솟 값 구하기
 * 동전 종류는 오름차순으로 주어지고, n번째 동전은 이전 n-1 번째 동전 종류의 배수
 * 큰 동전부터 쓰면 되지 않을까
 */
public class Main_BJ11047 {

	public static void main(String[] args) throws IOException {		//동전 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int coin[] = new int[n];
		int count = 0;
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}												//입력
	
		int sum = k;									//남은 가치
		for(int i = n-1; i >= 0; i--) {
			if(sum < coin[i]) {				//현재 남은 가치가 탐색 중인 동전 크기보다 작으면(동전을 합치지 못함)
				continue;					//다음 작은 동전으로
			}
			
			count += (sum / coin[i]);		//조건을 만족하는 동전이라면 개수 추가
			sum = (sum % coin[i]);			//남은 값 갱신
			
			if(sum == 0) {					//합을 k로 만들었으면 탈출
				break;
			}
		}
		
		System.out.println(count);			//근데 이 풀이는 모든 해를 만족시키지 않음 => 강사님의 2번째 코드 참고
	}

}
