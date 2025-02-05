package ch04;

import java.util.Scanner;

public class DoWhileTest {

	public static void main(String[] args) {
		//for문, while 예제도 있으나 아는거라 스킵
		
		Scanner sc = new Scanner(System.in);

		int command = 0;
		do {
			System.out.println("0:종료, 그 외 숫자는 계속");
			System.out.print("숫자 입력 : ");
			command = sc.nextInt();
		}
		while(command != 0); 		//프로세스가 이런식으로 동적, 접속프로그램 만들때 쓸 수 있음
	}

}
