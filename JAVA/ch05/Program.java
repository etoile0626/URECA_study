package ch05;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int student = 0;
		int [] scores = null;
		int n = 1;
		while(true) {
			System.out.println("---------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.printf("선택> %d\n", n);
			
			switch (n) {
			case 1:
				System.out.print("학생수> ");
				student = Integer.parseInt(sc.nextLine());
				break;
			case 2:
				scores = new int[student];
				for(int i =0; i<scores.length; i++) {
					System.out.printf("students[%d]> ", i);
					scores[i] = Integer.parseInt(sc.nextLine());
				}
				sc.close();
				break;
			case 3:
				for(int i =0; i<scores.length; i++) {
					System.out.printf("students[%d]: %d\n", i, scores[i]);
				}
				break;
			case 4:
				int max = 0;
				float mean = 0;
				for(int score : scores) {
					if(max < score) {
						max = score;
					}
					mean += (float)score;
				}
				mean = (mean / scores.length);
				System.out.println("최고 점수: "+max);
				System.out.println("평균 점수: "+mean);
				break;
			case 5:
				System.out.println("프로그램 종료");
				return;
			}
			n++;
		}

	}

}
