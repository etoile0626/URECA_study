package a0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 컴퓨터를 연결하는 '비용을 최소'로 네트워크를 구축하고자 함
 * 모든 컴퓨터를 연결하는데 필요한 최소 비용 출력하기, 연결 못하는 경우는 없음
 * =>비용 최소 얘기가 나오면 최소 신장 트리를 생각해볼것, 다익스트라 알고리즘 적용?(=>MST보다는 다익스트라로 푼 문제?)
 */
public class Main_BJ1922 {						//네트워크 연결 => 모르겠워요..다시 공부하세요.. 아래는 정석 풀이고 2번 코드로 풀이하는걸 목표로
	static ArrayList<int[]>[] graph;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[n+1];
		for(int i = 1; i <= n ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i =0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[n1].add(new int[] {n2, w});			//n1에서 n2를 가는데 드는 비용 w 
			graph[n2].add(new int[] {n1, w});			//n2에서 n1를 가는데 드는 비용 w(네트워크는 양방향이니까 같음)
		}
		
		boolean visit[] = new boolean[n+1];				// i번째 노드 방문 여부
		int minCost[] = new int [n+1];					// i 노드까지 오는데 걸리는 최소 비용 = minCost[i]
		for(int i = 1; i <= n; i++) {
			minCost[i] = Integer.MAX_VALUE;				//아직 방문하지 않아 최솟값이 갱신되지 않음을 의미
		}
		
		minCost[1] = 0;									//출발 번지는 0으로
		int answer = 0, cnt = 0;						//정답을 담을 곳과 반복횟수
		
		for(int i = 1; i <= n; i++) {					//n-1번 반복예정
			int min = Integer.MAX_VALUE/2;				//minCost의 초기값보다는 작게 두는 것이 목표
			int nextNode = -1;							//다음에 갈 노드
			
			for(int j = 1; j <= n; j++) {
				if(!visit[j] && min > minCost[j]) {
					min = minCost[j];					//j노드로 오는 최소 가중치 갱신
					nextNode = j;						//j노드를 다음에 갈 노드로 지정
				}
			}
			
			visit[nextNode] = true;						//방문처리
			answer += min;								//정답 합치기
			if(cnt++ == n) {							//n-1번 반복했으면 가중치 비교를 안하고 탈출
				break;
			}
			
			for(int k = 0; k < graph[nextNode].size(); k++) {	//노드에 연결된 다음으로 갈 노드 탐색
				int[] tmp = graph[nextNode].get(k);	
				if(!visit[tmp[0]] && minCost[tmp[0]] > tmp[1]) {//가중치가 원래 가지고 있던 최솟값 정보보다 작으면 갱신
					minCost[tmp[0]] = tmp[1];					//이건 그냥 이 노드로 오는데 가장 작은 가중치 값일 뿐임
				}
			}
		}
		
		System.out.println(answer);
		
		br.close();
	}

}
