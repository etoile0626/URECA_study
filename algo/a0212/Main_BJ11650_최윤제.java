package a0212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ11650_최윤제 {								//좌표 정렬

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int pos[][] = new int[n][2];
		
		for(int i = 0; i< n; i++) {
			st = new StringTokenizer(br.readLine());
			
			pos[i][0] = Integer.parseInt(st.nextToken());			//x
			pos[i][1] = Integer.parseInt(st.nextToken());			//y
		}
		
		Arrays.sort(pos, new Comparator<int[]>() {					//비교 시작

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		for(int i = 0; i< n; i++) {									//출력
			bw.write(pos[i][0]+" "+pos[i][1]+"\n");
		}
		
		bw.close();
		br.close();
	}
}
