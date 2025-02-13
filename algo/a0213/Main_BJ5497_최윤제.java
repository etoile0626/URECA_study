package a0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main_BJ5497_최윤제 {								//키로거

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		

		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			LinkedList<Character> list = new LinkedList<>();		//기존 풀이: 정수 변수 cnt를 통해 인덱스 접근 => 시간초과 발생
			ListIterator<Character> iter = list.listIterator();		//현재 커서 위치(다른 사람 풀이 참조: 시간초과로 인해)
			for(char c : str.toCharArray()) {
				if(c == '<') {						
					if(iter.hasPrevious()) {		//커서 왼쪽 이동이 가능하면 이동
						iter.previous();
					}
				}else if(c == '>') {				
					if(iter.hasNext()) {			//커서 오른쪽 이동이 가능하면 이동
						iter.next();
					}
				}else if(c == '-') {				//커서 앞 삭제
					if(iter.hasPrevious()) {		
						iter.previous();
						iter.remove();
					}
				}else {								//키 입력
					iter.add(c);
				}
			}
			
			//출력
			StringBuilder password = new StringBuilder();
			for(char c : list) {
				password.append(c); 
			}
			bw.write(password.toString()+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
