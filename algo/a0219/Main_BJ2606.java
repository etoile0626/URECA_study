package a0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 내 컴퓨터가 바이러스에 걸리면 연결된 다른 컴퓨터도 바이러스에 감염됨
 * 1번 컴퓨터가 바이러스에 걸렸을때, 1번을 통해 바이러스에 걸리는 컴퓨터의 수 구하기(당연히 1번은 제외해야함 이미 걸려있음)
 * 1번부터 차례로 번호가 매겨짐
 * **네트워크니까 당연히 무방향 그래프로 생각해야겠지..?
 */
public class Main_BJ2606 {										//바이러스
	static ArrayList<Integer>[] graph;
	static boolean [] visit;
	static int n, m, count;
	
	private static void dfs(int i) {
		if(visit[i]) {
			return;
		}														//이미 방문한 곳이면 빠른 탈출
		
		visit[i] = true;
		
		for(int j = 0; j < graph[i].size(); j++) {
			int n2 = graph[i].get(j);							//방문 예정 노드(다음노드)
			if(!visit[n2]) {									//다음노드가 아직 방문하지 않은 곳이면
				count++;										//바이러스 수 증가하고 이동처리
				dfs(n2);
			}
		}
		
	}

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());		//컴퓨터의 수
		m = Integer.parseInt(br.readLine());		//연결된 컴퓨터의 쌍 수, 즉 간선의 개수
		
		visit = new boolean[n+1];
		graph = new ArrayList[n+1];
		for(int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph[n1].add(n2);
			graph[n2].add(n1);						//네트워크는 양방향이니까 양방향 그래프로 처리
		}
		
		count = 0;
		dfs(1);										//완전 탐색을 해야하므로 bfs보다는 dfs가 나을듯
		
		System.out.println(count);
		br.close();
	}

}
