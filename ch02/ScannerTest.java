package ch02;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		
		// System : 실행 시스템
		// . : 내부를 의미함
		// out : 출력 버터(=메모리, 출력 대기열)
		// print : 출력
		// ln : line을 new하라(엔터키 효과)
		System.out.println(123);
		
		
		Scanner scan = new Scanner(System.in);
		// in : 입력버퍼(=메모리, 입력 대기열 -> 키보드입력을 의미)
		// Scanner : 데이터를 복사해오는 객체
		
		//scan.nextByte();
		//scan.nextShort();
		//scan.nextLong();			이런 애들도 있다
		//scan.nextFloat();
		System.out.print("정수 입력 : ");
		int iVar = scan.nextInt();
		System.out.println("iVar : " + iVar);
		
		System.out.print("실수 입력 : ");
		double dVar = scan.nextDouble();
		System.out.println("dVar : " + dVar);
		
		System.out.print("단어 입력 : ");	//공백(띄어쓰기)을 만날때까지 입력
		String s1 = scan.next();
		System.out.println("s1 : " + s1);
		
		scan.nextLine();			//엔터값 지우기 아래가 씹히는 문제를 해결하기 위한 더미 메소드
		System.out.print("문자 한 줄 입력 : ");	 //엔터키를 만날 때까지 입력
		String s2 = scan.nextLine();		 //근데 이대로 넣으면 전 next()에서 입력한 엔터값을 받아서 값이 바로 나와버림
		System.out.println("s2 : " + s2);
		
		scan.close(); //사용 완료시 close 때릴 것
		
	}

}
