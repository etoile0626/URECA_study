package a0221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 주어진 그래프의 MST 구하기
 * 단, 음수인 가중치도 존재 = > 다익스트라는 못 쓰겠지
 * MST니까 크루스칼 쓰기? / MST는 집합으로 푸는걸 잊지말기(순환이 되지 않게 하는 방법 =>집합에 넣어버리면 됨!
 */
public class Main_BJ1197 {									//최소 스패닝 트리
	static ArrayList<int []> graph;
	static int[] mst;
	
	private static int find(int i) {
		if(i == mst[i]) {
			return i;
		}else {
			return mst[i] = find(mst[i]);
		}
	}
	
	private static boolean union(int i, int j) {
		int root1 = find(i);
		int root2 = find(j);
		if(root1 == root2) {			//이미 mst에 같이 있으면
			return false;
		}
		mst[root2] = root1;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		mst = new int[v+1];
		for(int i = 1; i <= v; i++) {
			mst[i] = i;
		}
		
		for(int i = 0 ; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.add(new int[] {n1, n2, w});
		}
		
		Collections.sort(graph, (o1, o2)->Integer.compare(o1[2], o2[2])); //가중치 기준으로 정렬 -> 크루스칼 알고리즘!
		
		int sum = 0;
		for(int[] tmp : graph) {
			if(union(tmp[0], tmp[1])){		//넣을 간선이 순환이 되는지 검사(이미 mst에 들어가 있는지 검사)
				sum += tmp[2];
			}
		}
		
		System.out.println(sum);
	}
}
