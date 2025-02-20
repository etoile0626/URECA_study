package a0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * n+1개의 집합 {0}~{n}이 있을때, 합집합 연산(=유니온, 0)과 
 * 두 원소가 같은 집합에 포함되어있는지(=파인드, 1) 확인하는 연산을 수행하고자함
 * 입력은 0/1 a b의 형태, a와 b가 포함되어 있는 집합을 합치거나, a와 b가 같은 집합에 있는지 확인해서 yes나 no로 출력
 */
public class Main_BJ1717 {										//집합의 표현->강사님 피셜 어려움=>????
	static int[] set;
	
	private static int find(int n1) {
		int answer = 0;
		
		if(n1 == set[n1]) {
			answer = n1;
		}
		else if(n1 != set[n1]) {
			answer = find(set[n1]);			//이케하면 시간 개오래걸림
		}
		
		return answer;				//이렇게 하는 것보다 set[n1] = find(set[n1])을 통해 최적화 시키기!!!
	}

	private static void union(int n1, int n2) {
		int root1 = find(n1);
		int root2 = find(n2);
		
		set[root2] = root1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		set = new int[n+1];
		for(int i = 1; i <= n; i++) {
			set[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			if(order == 0) {					//유니온 연산
				union(n1, n2);
			}
			else if(order == 1) {				//파인드 연산
				if(find(n1) ==  find(n2)) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
		
		br.close();
	}
}
