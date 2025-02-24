package a0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 배낭에 k 만큼 넣을 수 있다고 할때, 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 구해보기
 * n개의 물건이 주어지고, 각 물건은 w만큼의 무게와 v만큼의 가치를 지님
 * 따로 물건을 쪼갤 수 없는 듯 => 그리디를 쓸 수 없음 => DP로 접근해야함?
 */
public class Main_BJ12865 {									//평범한 배낭 => 전혀 모르겠는데요...

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int w[] = new int[n+1];
		int v[] = new int[n+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());		//무게
			v[i] = Integer.parseInt(st.nextToken());		//가치
		}
		
		int dp[] = new int[k+1]; 							//i 무게일때의 최대가치 dp[i]
		
		for(int i = 1; i <= n; i++) {
			
			for(int j = k; j - w[i] >= 0; j--) {			//w[i] 무게 일때 최대 가치를 dp[w[i]]에 넣고자 함 (이거까진 이해감)
				dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);	//그러면서 dp[k]에 올 수 있는 최댓값을 탐색함 (솔직히 여기 이해 잘 안감)
			}												//결국 여기 끝나면 [0 0 0 6 8 12 13 14]의 dp 배열이 만들어짐 => k 무게일때 가치 dp[k] =14
		}													//검증과 연산을 하나의 모델로 한 코드?
		
		System.out.println(dp[k]);
		br.close();
	}

}
