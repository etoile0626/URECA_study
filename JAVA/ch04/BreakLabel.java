package ch04;

public class BreakLabel {

	public static void main(String[] args) {
		Outter : for(int a = 1; a<5; a++) {		//이 반복문의 이름을 Outter로 붙임
			for(int b =1; b <=5; b++) {
				for(int c= 1; c<=10; c++) {
					System.out.printf("a : %d, b : %d, c : %d\n", a, b, c);
					if(c == 3) break Outter;	//c가 3이면 Outter라는 반복문을 break 이런게 있구낭
				}
			}
		}

	}

}
