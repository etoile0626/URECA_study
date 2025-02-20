package a0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 강의코드가 1~N인 강의가 1~N번 건물에서 진행되고 있음
 * 강의 시간표 대로 강의를 들으면서 건물에서 밖으로 다른 건물로 이동하는 거리를 최소화 하고싶음
 * 단, 건물끼리 이어진 건물도 존재. 이때의 건물 밖으로 나오는 횟수의 최솟값을 구하기
 * =>건물끼리 이어진 건물들을 하나의 집합으로 보기?
 * =>find, union은 구현했으나 시간초과 문제가 발생???-> find와 union함수에서 강사님과 차이가 있었음
 */
public class Main_BJ24391 {							//귀찮은 해강이 => find 함수부분 다시 살펴보기
	static int[] set;
	
	private static int find(int i) {
		if(set[i] == i) {
			return i;
		}
		else {										//(탐색 시간을 최적화 시킬 수 있음)
			return set[i] = find(set[i]);			//루트 노드를 찾으면 해당 인덱스가 바로 루트 노드를 가리키도록 최적화
		}
	}
	
	private static void union(int n1, int n2) {
		int root1 = find(n1);
		int root2 = find(n2);
		
		set[root1] = root2;							
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
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			union(n1, n2);
		}
		
		int [] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int move = 0;
		for(int i = 0; i < n-1; i++) {
			if(find(arr[i]) != find(arr[i+1])) {		//루트가 다를때마다 건물에서 튀어나와욧
				move++;
			}
		}
		
		System.out.println(move);
		br.close();
	}
}
