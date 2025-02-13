package a0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
 * 문자열 T에서 패턴 P가 몇개, 어디에 위치해 있는지 표시하는 문제
 * =>KMP 알고리즘 문제!(강사님 정답 봄-->다시 공부하기)
 */
public class Main_BJ1786_최윤제 {								//찾기
	static String T, P;
	static int[] k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();									//문자열 T
		P = br.readLine();									//패턴 P
		
		int n = T.length();
		int m = P.length();
		
		k = new int[m];										//건너뛰기에 관련된 배열
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int t = 1, p = 0; t < m; t++) {
			while(p > 0 && P.charAt(t) != P.charAt(p)) {	//일치하지 않는다면
				p = k[p-1];									//이 부분 이해가 부족함
			}
			if(P.charAt(t) == P.charAt(p)) {				//비교해서 동일한 문자 있으면 어디로 건너뛰어야하는지 기입
				k[t] = ++p;
			}
		}	//전처리 끝
		
		for(int t =0, p =0; t < n; t++) {					//문자열 비교 시작
			while(p > 0 && T.charAt(t) != P.charAt(p)) {	//문자가 일치하지 않는데 패턴의 첫 문자를 검사하던게 아니면
				p = k[p-1];									//p값 갱신(왜 p-1이지->문제는 인덱스를 1번부터 세서?)
			}
			
			if(T.charAt(t) == P.charAt(p)) {
				if(p == m-1) {								//p가 패턴의 마지막을 가리키면(패턴이 문자열에 포함되면)
					list.add(t-p+1);						//포함되는 문자열의 시작 위치 추가
					p = k[p];								//p값 갱신
				}
				else {										//이전 자리수가 동일하면 다음 자리수도 비교
					++p;						
				}
			}
		}
		
		System.out.println(list.size());					//출력
		for(int i : list) {
			System.out.print(i+" ");
		}
	}
}

