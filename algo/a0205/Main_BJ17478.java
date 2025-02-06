package a0205;

import java.util.Scanner;

public class Main_BJ17478 {
	static String dash = "";
	
	static String[] s = {"\"재귀함수가 뭔가요?\"", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.", "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.", 
							"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"","\"재귀함수는 자기 자신을 호출하는 함수라네\"" ,"라고 답변하였지."};
	public void repeat(int n) {
		String dash2 = dash;
		
		System.out.println(dash+s[0]);
		if (n == 0) {
			System.out.println(dash+s[4]);//=>이런 출력값들을 static, 배열 처리를 하면 더 좋을지도
			System.out.println(dash+s[5]);
			return;
		}
		System.out.println(dash+s[1]);
		System.out.println(dash+ s[2]);
		System.out.println(dash+ s[3]);
		dash = dash+"____"; //+를 통해서 기존 객체를 버리고 새로 만들다보니 좀 고민할만한 부분=> StringBuilder를 써볼까
		repeat(n-1);
		System.out.println(dash2+s[5]);
		
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		//스캐너 말고 BufferedReader를 사용하는것이 더 바람직?
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		Main_BJ17478 main = new Main_BJ17478();
		main.repeat(n);
	}

}
