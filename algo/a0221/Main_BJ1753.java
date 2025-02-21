package a0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 방향 그래프에서 '다른 모든 정점'으로의 최단 경로를 구하는 프로그램
 * 가중치도 10이하 자연수 => 완전 다익스트라자너
 */
public class Main_BJ1753 {								//최단 경로
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int k =  Integer.parseInt(br.readLine());
		
		ArrayList<int[]>[] graph = new ArrayList[v+1];
		for(int i = 0; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[n1].add(new int[] {n2, w});
		}
		
		boolean visit[] = new boolean[v+1];
		int minCost[] = new int[v+1];
		for(int i = 0; i < v+1; i++) {
			minCost[i] = Integer.MAX_VALUE;
		}
		
		minCost[k] = 0;								//시작노드
		
		for(int i = 1; i <= v; i++) {
			int min = Integer.MAX_VALUE / 2;
			int nextNode = -1;
			
			for(int j = 1; j <= v; j++) {
				if(!visit[j] && min > minCost[j]) {
					min = minCost[j];
					nextNode = j;
				}
			}
			
			if(nextNode == -1) {
				break;
			}
			visit[nextNode] = true;
			
			for(int[] tmp : graph[nextNode]) {
	//아까 네트워크랑 차이점, 기존에 minCost[j]에 있던 최단 경로 값을 더 해줘야 k에서 j번째 정점으로부터의 최단경로값을 출력
				if(!visit[tmp[0]] && minCost[tmp[0]] > min + tmp[1]) {
					minCost[tmp[0]] = min + tmp[1];
				}
			}
		}
		
		for(int i = 1; i <= v; i++) {
			if(minCost[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(minCost[i]);
			}
		}
		
		br.close();
	}

}
