package a0212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main_BJ1181_최윤제 {								//단어 정렬

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();		//중복 제거를 위해 hashset으로
		for(int i =0; i< n; i++) {
			set.add(br.readLine());
		}
		
		String[] str = (String[]) set.toArray(new String[set.size()]);	//다시 배열로 옮겨서
		
		Arrays.sort(str, new Comparator<String>() {						//비교 시작

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {		//같으면 사전순 정렬
					return o1.compareTo(o2);
				}
				return Integer.compare(o1.length(), o2.length());	//짧은거 부터 정렬
			}
			
		}
				);
		
		//출력부
		for(int i = 0; i< str.length; i++) {
			System.out.println(str[i]);
		}
	}
}
